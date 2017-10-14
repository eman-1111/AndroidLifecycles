package ides.link.androidpersistence;

import android.arch.lifecycle.LifecycleActivity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

import ides.link.androidpersistence.db.AppDatabase;
import ides.link.androidpersistence.db.User;
import ides.link.androidpersistence.db.utils.DatabaseInitializer;

/**
 * Created by Eman on 10/12/2017.
 */

public class UsersActivity extends LifecycleActivity{
    private AppDatabase mDb;
    private TextView mYoungUsersTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.db_activity);
        mYoungUsersTextView = (TextView) findViewById(R.id.young_users_tv);

       // Note: Db references should not be in an activity.
        mDb = AppDatabase.getInMemoryDatabase(getApplicationContext());

        populateDb();

        fetchData();
    }

    private void populateDb() {
        DatabaseInitializer.populateAsync(mDb);
    }

    private void fetchData() {
        // Note: this kind of logic should not be in an activity.
        StringBuilder sb = new StringBuilder();
        List<User> youngUsers = mDb.userModel().findYoungerThanSolution(35);
        for (User youngUser : youngUsers) {
            sb.append(String.format(Locale.US,
                    "%s, %s (%d)\n", youngUser.lastName, youngUser.name, youngUser.age));
        }
        mYoungUsersTextView.setText(sb);
    }

    @Override
    protected void onDestroy() {
        AppDatabase.destroyInstance();
        super.onDestroy();
    }
}
