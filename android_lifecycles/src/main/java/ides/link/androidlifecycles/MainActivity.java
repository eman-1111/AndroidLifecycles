package ides.link.androidlifecycles;

import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.ViewModelProviders;
import android.os.SystemClock;
import android.os.Bundle;
import android.widget.Chronometer;

import ides.link.androidlifecycles.models.ChronometerViewModel;

public class MainActivity extends LifecycleActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // The ViewModelStore provides a new ViewModel or one previously created
        ChronometerViewModel chronometerViewModel =
                ViewModelProviders.of(this).get(ChronometerViewModel.class);
        // this refers to an instance of LifecycleOwner. The framework keeps the ViewModel alive as
        // long as the scope of the LifecycleOwner is alive. A ViewModel is not destroyed if its
        // owner is destroyed for a configuration change, such as screen rotation.
        // The new instance of the owner re-connects to the existing ViewModel

        Chronometer chronometer = (Chronometer) findViewById(R.id.chronometer);

        if (chronometerViewModel.getStartDate() == null) {
            // If the start date is not defined, it's a new ViewModel so set it.
            long date = SystemClock.elapsedRealtime();
            chronometerViewModel.setStartDate(date);
            chronometer.setBase(date);

        } else {
            // Otherwise the ViewModel has been retained, set the chronometer's base to the original
            // starting time.
            chronometer.setBase(chronometerViewModel.getStartDate());
        }
        chronometer.start();
    }
}
