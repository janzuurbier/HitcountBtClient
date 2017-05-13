package zrb.hu.nl.hitcountbtclient;

import android.app.AlertDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * Created by JZuurbier on 5-5-2017.
 */

public class ConnectTask extends AsyncTask <BluetoothDevice, Void, String> {

    private UUID MY_UUID = new UUID(0xffffffffffffffffL,0x1L);
    private Context cntxt;

    ConnectTask(Context cntxt){
        this.cntxt = cntxt;
    }

    @Override
    protected String doInBackground(BluetoothDevice... arg0) {
        //todo
        return null;
    }

    @Override
    protected void onPostExecute(String result){
        //todo
    }
}
