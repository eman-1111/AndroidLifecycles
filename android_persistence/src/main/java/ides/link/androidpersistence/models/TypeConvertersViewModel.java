package ides.link.androidpersistence.models;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import ides.link.androidpersistence.db.AppDatabase;
import ides.link.androidpersistence.db.Book;
import ides.link.androidpersistence.db.utils.DatabaseInitializer;

/**
 * Created by Eman on 10/15/2017.
 */

public class TypeConvertersViewModel extends AndroidViewModel {

    private AppDatabase mDb;
    private LiveData<List<Book>> mBooks;

    public TypeConvertersViewModel(Application application) {
        super(application);
        createDb();
    }

    public void createDb() {
        mDb = AppDatabase.getInMemoryDatabase(this.getApplication());

        // Populate it with initial data
        DatabaseInitializer.populateAsync(mDb);

        // to Receive changes
        subscribeToDbChanges();
    }
    //what we observe
    public LiveData<List<Book>> getBooks() {
        return mBooks;
    }

    private void subscribeToDbChanges() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DATE, -1);
        Date yesterday = calendar.getTime();
        mBooks = mDb.bookModel().findBooksBorrowedByNameAfter("Mike", yesterday);
    }


}
