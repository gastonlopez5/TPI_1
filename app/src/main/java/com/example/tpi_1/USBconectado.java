package com.example.tpi_1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class USBconectado extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getExtras().getBoolean("connected")){
            Intent i = new Intent(context, InicialLlamada.class);
            context.startActivity(i);
        } else {
            Toast.makeText(context, "No conectado", Toast.LENGTH_LONG).show();
        }

    }
}
