package com.example.administrator.myapplication;

/**
 * Created by Administrator on 2015/5/25.
 */
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String action=intent.getAction();
        Intent intent2=null;
        if(action.equals("com.sxt.day07_05.start_activity")){
            //启动SecondActivity
            intent2=new Intent(context, SecondActivity.class);
            intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent2);
        }else if(action.equals("com.sxt.day07_05.start_service")){
            intent2=new Intent(context, MyService.class);
            context.startService(intent2);
        }else if(action.equals("com.sxt.day07_05.stop_service")){
            intent2=new Intent(context, MyService.class);
            context.stopService(intent2);
        }
    }

}
