package ides.link.androidlifecycles;

import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.TextView;

import ides.link.androidlifecycles.models.LiveDataTimerViewModel;

/**
 * Created by Eman on 10/8/2017.
 */

public class ChronoActivity3 extends LifecycleActivity {

    private LiveDataTimerViewModel mLiveDataTimerViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chrono_activity_3);

        mLiveDataTimerViewModel = ViewModelProviders.of(this).get(LiveDataTimerViewModel.class);

        subscribe();
    }

    private void subscribe() {
        //create the Observer
        final Observer<Long> elapsedTimeObserver = new Observer<Long>() {
            //what should be updated when observable"LiveData" send notification that data is changed
            @Override
            public void onChanged(@Nullable Long aLong) {
                String newText = ChronoActivity3.this.getResources().getString(R.string.seconds, aLong);
                ((TextView) findViewById(R.id.timer_textview)).setText(newText);
                Log.d("ChronoActivity3", "Updating timer");
            }
        };
        //Adds the given observer to the observers list within the lifespan of the given owner
        mLiveDataTimerViewModel.getElapsedTime().observe(this, elapsedTimeObserver);
    }

}
