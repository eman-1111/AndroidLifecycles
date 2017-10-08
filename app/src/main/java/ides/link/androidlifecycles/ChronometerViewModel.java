package ides.link.androidlifecycles;

import android.arch.lifecycle.ViewModel;
import android.support.annotation.Nullable;
/**
 * Created by Eman on 10/8/2017.
 */

public class ChronometerViewModel extends ViewModel {

    @Nullable
    private Long startDate;

    @Nullable
    public Long getStartDate() {
        return startDate;
    }

    public void setStartDate(final long startDate) {
        this.startDate = startDate;
    }
}
