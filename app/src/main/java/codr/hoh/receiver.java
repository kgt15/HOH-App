package codr.hoh;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Gopi on 04-Sep-15.
 */
public class receiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String phoneNo;
        phoneNo=getResultData();
        if(phoneNo.equals("123"))
        {
            Intent intent1= new Intent(context,sen_sms.class);
            intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent1);
            setResultData(null);
        }
    }
}
