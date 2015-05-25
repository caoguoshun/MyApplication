package com.example.administrator.myapplication;

/**
 * Created by Administrator on 2015/5/25.
 */
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Log;

public class MyService extends Service {
    boolean mLooper=true;//true:循环继续
    @Override
    public IBinder onBind(Intent intent) {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        new Thread(){
            public void run() {
                while(mLooper){
                    SystemClock.sleep(1000);
                    Log.i("main","service is loop...");
                }
            };
        }.start();
        return super.onStartCommand(intent, flags, startId);
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("main","service Stopped...");
        mLooper=false;
    }
}
