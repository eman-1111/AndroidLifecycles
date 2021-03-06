package ides.link.androidpersistence;

import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import ides.link.androidpersistence.db.Book;
import ides.link.androidpersistence.models.BooksBorrowedByUserViewModel;
import ides.link.androidpersistence.models.TypeConvertersViewModel;

/**
 * Created by Eman on 10/14/2017.
 */

public class BooksBorrowedByUserActivity extends LifecycleActivity {

    //private BooksBorrowedByUserViewModel mViewModel;

    private TypeConvertersViewModel mViewModel;
    //we create a new @Query in the BookDao class to list the books borrowed by a user within the last day.
    //using @TypeConverter annotation. You can use type converters to define conversions between
    // data types in your plain old Java object (POJO), and column types in a SQLite database.

    @SuppressWarnings("unused")
    private TextView mBooksTextView;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.db_activity_);
        mBooksTextView = (TextView) findViewById(R.id.books_tv);

        // Get a reference to the ViewModel for this screen.
        mViewModel = ViewModelProviders.of(this).get(TypeConvertersViewModel.class);

        // Update the UI whenever there's a change in the ViewModel's data.
        subscribeUiBooks();


    }

    private void subscribeUiBooks() {
        mViewModel.getBooks().observe(this, new Observer<List<Book>>() {
            @Override
            public void onChanged(@Nullable List<Book> books) {
                showBooksInUi(books, mBooksTextView);
            }
        });
    }

    @SuppressWarnings("unused")
    public static void showBooksInUi(final @Nullable List<Book> books,
                                     final TextView mBooksTextView){

        StringBuilder sb = new StringBuilder();
        for(Book book : books){
            sb.append(book.title);
            sb.append("\n");

        }
        mBooksTextView.setText(sb.toString());
    }
    public void onRefreshBtClicked(View view) {
        mViewModel.createDb();
    }
}
