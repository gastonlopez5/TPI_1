package com.example.tpi_1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class USBconectado extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent i = new Intent(context, InicialLlamada.class);
        context.startActivity(i);
    }
}
