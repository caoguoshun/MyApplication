package com.example.administrator.myapplication;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.content.Intent;
import android.content.IntentFilter;

public class MainActivity extends ActionBarActivity implements View.OnClickListener{
    MyReceiver mReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // registerReceiver();
        findViewById(R.id.StartSecondActivity).setOnClickListener(this);
        findViewById(R.id.StartService).setOnClickListener(this);
        findViewById(R.id.StopService).setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent();
        switch (v.getId()) {
            case R.id.StartSecondActivity:
                intent.setAction("com.sxt.day07_05.start_activity");
                break;
            case R.id.StartService:
                intent.setAction("com.sxt.day07_05.start_service");
                break;
            case R.id.StopService:
                intent.setAction("com.sxt.day07_05.stop_service");
                break;
        }
        sendBroadcast(intent);
    }


    private void registerReceiver() {
        mReceiver=new MyReceiver();
        IntentFilter filter=new IntentFilter();
        filter.addAction("com.sxt.day07_05.start_activity");
        filter.addAction("com.sxt.day07_05.start_service");
        filter.addAction("com.sxt.day07_05.stop_service");
        registerReceiver(mReceiver, filter);
    }
}
