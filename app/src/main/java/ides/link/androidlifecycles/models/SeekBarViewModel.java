package ides.link.androidlifecycles.models;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.Nullable;

/**
 * Created by Eman on 10/11/2017.
 */

public class SeekBarViewModel extends ViewModel {
    public MutableLiveData<Integer> seekBarValue = new MutableLiveData<>();


}
