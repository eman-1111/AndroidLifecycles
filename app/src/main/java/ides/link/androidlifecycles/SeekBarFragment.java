package ides.link.androidlifecycles;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

import ides.link.androidlifecycles.models.SeekBarViewModel;

/**
 * Created by Eman on 10/11/2017.
 */

public class SeekBarFragment extends Fragment {
    private SeekBar seekBar;
    private SeekBarViewModel mSeekBarViewModel;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_seekbar,container , false);
        seekBar = (SeekBar) view.findViewById(R.id.seekbar);

        mSeekBarViewModel = ViewModelProviders.of(getActivity()).get(SeekBarViewModel.class);
        subscribeSeekBar();

        return view;
    }

    private void subscribeSeekBar() {
        // Update the ViewModel when the SeekBar is changed.
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // Set the ViewModel's value when the change comes from the user.
                if (fromUser) {
                    Log.d("Step5", "Progress changed!");
                    mSeekBarViewModel.seekBarValue.setValue(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        // Update the SeekBar when the ViewModel is changed.
        mSeekBarViewModel.seekBarValue.observe(
                (LifecycleOwner) getActivity(),
                new Observer<Integer>() {
                    @Override
                    public void onChanged(@Nullable Integer value) {
                        if (value != null) {
                            seekBar.setProgress(value);
                        }
                    }
                });
    }
}
