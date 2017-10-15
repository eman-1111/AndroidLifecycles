package ides.link.androidpersistence;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import ides.link.androidpersistence.db.LoanWithUserAndBook;
import ides.link.androidpersistence.models.CustomResultViewModel;

/**
 * Created by Eman on 10/15/2017.
 */

public class CustomResultActivity extends LifecycleActivity {

    @SuppressWarnings("unused")
    private TextView mBooksTextView;
    private CustomResultViewModel mViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.db_activity_);

        mBooksTextView = (TextView) findViewById(R.id.books_tv);

        mViewModel = ViewModelProviders.of(this).get(CustomResultViewModel.class);

        // Update the UI whenever there's a change in the ViewModel's data.
        subscribeUiLoans();

    }

    private void subscribeUiLoans() {
        mViewModel.getLoansResult().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String result) {
                mBooksTextView.setText(result);
            }
        });
    }


    public void onRefreshBtClicked(View view) {
        mViewModel.createDb();
        subscribeUiLoans();
    }
}
