package ides.link.androidlifecycles;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.util.Log;

/**
 * Created by Eman on 10/9/2017.
 */

public class BoundLocationManager {
    public static void bindLocationListenerIn(LifecycleOwner lifecycleOwner,
                                              LocationListener listener, Context context) {
        new BoundLocationListener(lifecycleOwner, listener, context);
    }

    @SuppressWarnings("MissingPermission")
    static class BoundLocationListener implements LifecycleObserver {

        private LocationManager mLocationManager;
        private LocationListener mLocationListener;
        private Context mContext;

        public BoundLocationListener(LifecycleOwner lifecycleOwner,
                                     LocationListener listener, Context context) {
            mLocationListener = listener;
            mContext = context;
            //Add lifecycle observer
            lifecycleOwner.getLifecycle().addObserver(this);
        }

        //Call this on resume
        @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
        void addLocationListener() {

            mLocationManager = (LocationManager) mContext.getSystemService(Context.LOCATION_SERVICE);
            mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, mLocationListener);
            Log.d("BoundLocationMgr", "Listener added");

            // Force an update with the last location, if available.
            Location lastLocation =
                    mLocationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            if (lastLocation != null) {
                mLocationListener.onLocationChanged(lastLocation);
            }
        }

        //Call this on pause
        @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
        void removeLocationListener() {
            if (mLocationManager == null) {
                return;
            }
            mLocationManager.removeUpdates(mLocationListener);
            mLocationManager = null;
            Log.d("BoundLocationMgr", "LocationListener removed");
        }

    }
}