package ides.link.androidpersistence;

import android.arch.lifecycle.LifecycleActivity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import ides.link.androidpersistence.db.AppDatabase;
import ides.link.androidpersistence.db.Book;
import ides.link.androidpersistence.db.utils.DatabaseInitializer;

/**
 * Created by Eman on 10/14/2017.
 */

public class JankShowUserActivity extends LifecycleActivity {

    private AppDatabase mDb;
    private TextView mBookTextView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Note: Db references should not be in an activity.
        setContentView(R.layout.db_activity_);
        mBookTextView = (TextView) findViewById(R.id.books_tv);

        mDb = AppDatabase.getInMemoryDatabase(getApplicationContext());

        populateDb();

        fetchData();
    }

    private void populateDb() {
        //The database is currently populated synchronously, blocked the UI
        //DatabaseInitializer.populateSync(mDb);
        //following statement, to switch to using an asynchronous task to populate the data
        DatabaseInitializer.populateAsync(mDb);
        //The database is being populated in the background, but you're still querying it in the
        // main thread. The issue is caused by a race condition.
        // Query results arrive before the Loan table is populated.
        // If you press REFRESH after a couple of seconds, the results appear
    }

    private void fetchData() {
        List<Book> books = mDb.bookModel().findBooksBorrowedByNameSync("Mike");
        showListInUI(books, mBookTextView);

        // The query is still being executed on the main thread, potentially blocking the UI.
        //There is no way to know when the database tables are finished being populated.

    }
    private static void showListInUI(final @NonNull List<Book> books,
                                     final TextView booksTextView) {
        StringBuilder sb = new StringBuilder();
        for (Book book : books) {
            sb.append(book.title);
            sb.append("\n");
        }
        booksTextView.setText(sb.toString());
    }

    public void onRefreshBtClicked(View view) {
        mBookTextView.setText("");
        fetchData();
    }
    @Override
    protected void onDestroy() {
        AppDatabase.destroyInstance();
        super.onDestroy();
    }
}
