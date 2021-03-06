package com.btcrelax.bitganjshop;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.view.*;
import android.security.*;
import android.content.Context;
import android.telephony.TelephonyManager;
import android.provider.Settings.Secure;


public class MainActivity extends Activity 
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate main_menu.xml 
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		switch (item.getItemId())
		{
			case R.id.menuAbout:
				boolean vIsNetwork = Utils.isNoNetworkAvailable(this);
				String vState = vIsNetwork ? "offline":"online";
				String vMsg = "Твой Id:" + getUniqueID() + ".\n Состояние сети:" + vState;
				Toast.makeText(this, vMsg, Toast.LENGTH_LONG).show();
				return true;
			case R.id.menuExit:
				finish();
				return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public String getUniqueID(){    
		String myAndroidDeviceId = "";
		TelephonyManager mTelephony = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
		if (mTelephony.getDeviceId() != null){
			myAndroidDeviceId = mTelephony.getDeviceId(); 
		}else{
			myAndroidDeviceId = Secure.getString(getApplicationContext().getContentResolver(), Secure.ANDROID_ID); 
		}
		return myAndroidDeviceId;
	}
}
