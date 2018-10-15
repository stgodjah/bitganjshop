package com.btcrelax.bitganjshop;
import android.content.*;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;

public final class Utils
{
	public static boolean isNoNetworkAvailable(Context c) {
        final ConnectivityManager connectivityManager = (ConnectivityManager) c
			.getSystemService(Context.CONNECTIVITY_SERVICE);
        final NetworkInfo activeNetworkInfo = connectivityManager
			.getActiveNetworkInfo();
        return activeNetworkInfo == null || !activeNetworkInfo.isConnected();
    }
}
