package codr.hoh;

import android.content.SharedPreferences;
import android.location.Location;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;



/**
 * Created by Gopi on 04-Sep-15.
 */
public class sen_sms extends AppCompatActivity implements GoogleApiClient.ConnectionCallbacks,GoogleApiClient.OnConnectionFailedListener {
    Location loc=new Location("new");
    GoogleApiClient client;
    Double lat,lon;
    String no="no";
    int check;
    private static final String not_repeat = "restart";

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(not_repeat,check);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onPause() {

        super.onPause();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms_sent);
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        if(savedInstanceState!=null)
            check=savedInstanceState.getInt(not_repeat);
        buildapiclient();
        client.connect();

    }
    protected synchronized void buildapiclient()
    {
        client=new GoogleApiClient.Builder(this).addConnectionCallbacks(this).addOnConnectionFailedListener(this).addApi(LocationServices.API).build();
    }
    @Override
    public void onConnected(Bundle bundle) {
        if(check!=1) {
            loc = LocationServices.FusedLocationApi.getLastLocation(client);
            if (loc != null) {
                lat = loc.getLatitude();
                lon = loc.getLongitude();
                SharedPreferences details = PreferenceManager.getDefaultSharedPreferences(this);
                SmsManager sms = SmsManager.getDefault();
                if (!no.equals(details.getString("number1", "no")))
                    sms.sendTextMessage(details.getString("number1", "no"), null, "Help me.I am at: http://maps.google.com/?q=" + String.valueOf(lat) + "," + String.valueOf(lon), null, null);
                if (!no.equals(details.getString("number2", "no")))
                    sms.sendTextMessage(details.getString("number2", "no"), null, "Help me.I am at: http://maps.google.com/?q=" + String.valueOf(lat) + "," + String.valueOf(lon), null, null);
                if (!no.equals(details.getString("number3", "no")))
                    sms.sendTextMessage(details.getString("number3", "no"), null, "Help me.I am at: http://maps.google.com/?q=" + String.valueOf(lat) + "," + String.valueOf(lon), null, null);
                if (!no.equals(details.getString("number4", "no")))
                    sms.sendTextMessage(details.getString("number4", "no"), null, "Help me.I am at: http://maps.google.com/?q=" + String.valueOf(lat) + "," + String.valueOf(lon), null, null);
                if (!no.equals(details.getString("number5", "no")))
                    sms.sendTextMessage(details.getString("number5", "no"), null, "Help me.I am at: http://maps.google.com/?q=" + String.valueOf(lat) + "," + String.valueOf(lon), null, null);
                check=1;
            }
        }
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }

}
