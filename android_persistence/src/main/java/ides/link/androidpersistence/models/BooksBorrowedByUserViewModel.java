package ides.link.androidpersistence.models;


import android.app.Application;

import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

import ides.link.androidpersistence.db.AppDatabase;
import ides.link.androidpersistence.db.Book;
import ides.link.androidpersistence.db.utils.DatabaseInitializer;


/**
 * Created by Eman on 10/14/2017.
 */

public class BooksBorrowedByUserViewModel extends AndroidViewModel  {

    //what we observe so we make it public, or we can make it private and make getter to observe
    public final LiveData<List<Book>> books;
    private AppDatabase mDb;
    public BooksBorrowedByUserViewModel(Application application){
        super(application);
        createDb();

        //Assign books to the 'findBooksBorrowedByName' query.
        books = mDb.bookModel().findBooksBorrowedByName("Mike");;
    }

    public void createDb() {
        mDb = AppDatabase.getInMemoryDatabase(this.getApplication());

        // Populate it with initial data
        DatabaseInitializer.populateAsync(mDb);
    }
}
