package com.example.android.sunshine.databinding;
import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
public abstract class ActivityDetailBinding extends ViewDataBinding {
    public final com.example.android.sunshine.databinding.ExtraWeatherDetailsBinding extraDetails;
    public final com.example.android.sunshine.databinding.PrimaryWeatherInfoBinding primaryInfo;
    // variables
    protected ActivityDetailBinding(android.databinding.DataBindingComponent bindingComponent, android.view.View root_, int localFieldCount
        , com.example.android.sunshine.databinding.ExtraWeatherDetailsBinding extraDetails
        , com.example.android.sunshine.databinding.PrimaryWeatherInfoBinding primaryInfo
    ) {
        super(bindingComponent, root_, localFieldCount);
        this.extraDetails = extraDetails;
        setContainedBinding(this.extraDetails);
        this.primaryInfo = primaryInfo;
        setContainedBinding(this.primaryInfo);
    }
    //getters and abstract setters
    public static ActivityDetailBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static ActivityDetailBinding inflate(android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static ActivityDetailBinding bind(android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static ActivityDetailBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot, android.databinding.DataBindingComponent bindingComponent) {
        return DataBindingUtil.<ActivityDetailBinding>inflate(inflater, com.example.android.sunshine.R.layout.activity_detail, root, attachToRoot, bindingComponent);
    }
    public static ActivityDetailBinding inflate(android.view.LayoutInflater inflater, android.databinding.DataBindingComponent bindingComponent) {
        return DataBindingUtil.<ActivityDetailBinding>inflate(inflater, com.example.android.sunshine.R.layout.activity_detail, null, false, bindingComponent);
    }
    public static ActivityDetailBinding bind(android.view.View view, android.databinding.DataBindingComponent bindingComponent) {
        return (ActivityDetailBinding)bind(bindingComponent, view, com.example.android.sunshine.R.layout.activity_detail);
    }
}