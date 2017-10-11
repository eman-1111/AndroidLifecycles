package ides.link.androidlifecycles.models;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

import java.util.Timer;
import java.util.TimerTask;

import ides.link.androidlifecycles.ChronoActivity3;

/**
 * A ViewModel used for the {@link ChronoActivity3}.
 */

public class LiveDataTimerViewModel extends ViewModel {

    private static  int ONE_SECOND = 1000;
    private MutableLiveData<Long> mElapsedTime = new MutableLiveData<>();
    private long mInitialTime;

    public LiveDataTimerViewModel(){
        mInitialTime = SystemClock.elapsedRealtime();
        Timer timer = new Timer();
        // Update the elapsed time every second.
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                final long newValue = (SystemClock.elapsedRealtime() - mInitialTime) / 1000;
                // setValue() cannot be called from a background thread so post to main thread.
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        //when setValue() is called the observable "LiveData" notify all the observer
                        mElapsedTime.setValue(newValue);
                    }
                });
            }
        },ONE_SECOND, ONE_SECOND);
    }

    public LiveData<Long> getElapsedTime() {
        return mElapsedTime;
    }
}
