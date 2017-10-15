package ides.link.androidpersistence.models;

import android.app.Application;
import android.arch.core.util.Function;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Transformations;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import ides.link.androidpersistence.db.AppDatabase;
import ides.link.androidpersistence.db.LoanWithUserAndBook;
import ides.link.androidpersistence.db.utils.DatabaseInitializer;

/**
 * Created by Eman on 10/15/2017.
 */

public class CustomResultViewModel extends AndroidViewModel {

    private AppDatabase mDb;
    private LiveData<String> mLoansResult;

    public CustomResultViewModel(Application application) {
        super(application);
        createDb();
    }

    public void createDb() {
        mDb = AppDatabase.getInMemoryDatabase(this.getApplication());

        DatabaseInitializer.populateAsync(mDb);

        // to Receive changes
        subscribeToDbChanges();
    }

    public LiveData<String> getLoansResult() {
        return mLoansResult;
    }

    private void subscribeToDbChanges() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DATE, -1);
        Date yesterday = calendar.getTime();

        LiveData<List<LoanWithUserAndBook>> mLoans = mDb.loanModel().findLoansByNameAfter("Mike", yesterday);

        // Instead of exposing the list of Loans, we can apply a transformation and expose Strings.
        mLoansResult = Transformations.map(mLoans,
                new Function<List<LoanWithUserAndBook>, String>() {
                    @Override
                    public String apply(List<LoanWithUserAndBook> loansWithUserAndBook) {
                        StringBuilder sb = new StringBuilder();
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm",
                                Locale.US);

                        for (LoanWithUserAndBook loan : loansWithUserAndBook) {
                            sb.append(String.format("%s\n  (Returned: %s)\n",
                                    loan.bookTitle,
                                    simpleDateFormat.format(loan.endTime)));
                        }
                        return sb.toString();
                    }
                });
    }

}
