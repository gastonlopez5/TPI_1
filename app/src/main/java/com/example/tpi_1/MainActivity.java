package com.example.tpi_1;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private USBconectado usb;
    private USBconectado usb2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
                && checkSelfPermission(Manifest.permission.RECEIVE_SMS)
                != PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[]{Manifest.permission.RECEIVE_SMS},1000);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        usb = new USBconectado();
        usb2 = new USBconectado();
        registerReceiver(usb, new IntentFilter("android.hardware.usb.action.USB_STATE"));
        registerReceiver(usb2, new IntentFilter("android.provider.Telephony.SMS_RECEIVED"));
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(usb);
        unregisterReceiver(usb2);
    }
}
