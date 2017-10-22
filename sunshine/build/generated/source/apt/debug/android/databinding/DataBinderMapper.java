
package android.databinding;
import com.example.android.sunshine.BR;
class DataBinderMapper  {
    final static int TARGET_MIN_SDK = 14;
    public DataBinderMapper() {
    }
    public android.databinding.ViewDataBinding getDataBinder(android.databinding.DataBindingComponent bindingComponent, android.view.View view, int layoutId) {
        switch(layoutId) {
                case com.example.android.sunshine.R.layout.activity_detail:
 {
                        final Object tag = view.getTag();
                        if(tag == null) throw new java.lang.RuntimeException("view must have a tag");
                    if ("layout-land/activity_detail_0".equals(tag)) {
                            return new com.example.android.sunshine.databinding.ActivityDetailBindingLandImpl(bindingComponent, view);
                    }
                    if ("layout/activity_detail_0".equals(tag)) {
                            return new com.example.android.sunshine.databinding.ActivityDetailBindingImpl(bindingComponent, view);
                    }
                        throw new java.lang.IllegalArgumentException("The tag for activity_detail is invalid. Received: " + tag);
                }
                case com.example.android.sunshine.R.layout.primary_weather_info:
                    return com.example.android.sunshine.databinding.PrimaryWeatherInfoBinding.bind(view, bindingComponent);
                case com.example.android.sunshine.R.layout.extra_weather_details:
                    return com.example.android.sunshine.databinding.ExtraWeatherDetailsBinding.bind(view, bindingComponent);
        }
        return null;
    }
    android.databinding.ViewDataBinding getDataBinder(android.databinding.DataBindingComponent bindingComponent, android.view.View[] views, int layoutId) {
        switch(layoutId) {
        }
        return null;
    }
    int getLayoutId(String tag) {
        if (tag == null) {
            return 0;
        }
        final int code = tag.hashCode();
        switch(code) {
            case 597830097: {
                if(tag.equals("layout-land/activity_detail_0")) {
                    return com.example.android.sunshine.R.layout.activity_detail;
                }
                break;
            }
            case 257710925: {
                if(tag.equals("layout/activity_detail_0")) {
                    return com.example.android.sunshine.R.layout.activity_detail;
                }
                break;
            }
            case 98450412: {
                if(tag.equals("layout/primary_weather_info_0")) {
                    return com.example.android.sunshine.R.layout.primary_weather_info;
                }
                break;
            }
            case -19416940: {
                if(tag.equals("layout/extra_weather_details_0")) {
                    return com.example.android.sunshine.R.layout.extra_weather_details;
                }
                break;
            }
        }
        return 0;
    }
    String convertBrIdToString(int id) {
        if (id < 0 || id >= InnerBrLookup.sKeys.length) {
            return null;
        }
        return InnerBrLookup.sKeys[id];
    }
    private static class InnerBrLookup {
        static String[] sKeys = new String[]{
            "_all"};
    }
}