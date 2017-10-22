package com.example.android.sunshine.databinding;
import com.example.android.sunshine.R;
import com.example.android.sunshine.BR;
import android.view.View;
public class ActivityDetailBindingLandImpl extends ActivityDetailBinding  {

    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new android.databinding.ViewDataBinding.IncludedLayouts(3);
        sIncludes.setIncludes(0, 
            new String[] {"primary_weather_info", "extra_weather_details"},
            new int[] {1, 2},
            new int[] {R.layout.primary_weather_info, R.layout.extra_weather_details});
        sViewsWithIds = null;
    }
    // views
    private final android.widget.LinearLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityDetailBindingLandImpl(android.databinding.DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 3, sIncludes, sViewsWithIds));
    }
    private ActivityDetailBindingLandImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2
            , (com.example.android.sunshine.databinding.ExtraWeatherDetailsBinding) bindings[2]
            , (com.example.android.sunshine.databinding.PrimaryWeatherInfoBinding) bindings[1]
            );
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
        }
        primaryInfo.invalidateAll();
        extraDetails.invalidateAll();
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        if (primaryInfo.hasPendingBindings()) {
            return true;
        }
        if (extraDetails.hasPendingBindings()) {
            return true;
        }
        return false;
    }

    public boolean setVariable(int variableId, Object variable) {
        switch(variableId) {
        }
        return false;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangePrimaryInfo((com.example.android.sunshine.databinding.PrimaryWeatherInfoBinding) object, fieldId);
            case 1 :
                return onChangeExtraDetails((com.example.android.sunshine.databinding.ExtraWeatherDetailsBinding) object, fieldId);
        }
        return false;
    }
    private boolean onChangePrimaryInfo(com.example.android.sunshine.databinding.PrimaryWeatherInfoBinding PrimaryInfo, int fieldId) {
        switch (fieldId) {
            case BR._all: {
                synchronized(this) {
                        mDirtyFlags |= 0x1L;
                }
                return true;
            }
        }
        return false;
    }
    private boolean onChangeExtraDetails(com.example.android.sunshine.databinding.ExtraWeatherDetailsBinding ExtraDetails, int fieldId) {
        switch (fieldId) {
            case BR._all: {
                synchronized(this) {
                        mDirtyFlags |= 0x2L;
                }
                return true;
            }
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        // batch finished
        executeBindingsOn(primaryInfo);
        executeBindingsOn(extraDetails);
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): primaryInfo
        flag 1 (0x2L): extraDetails
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}