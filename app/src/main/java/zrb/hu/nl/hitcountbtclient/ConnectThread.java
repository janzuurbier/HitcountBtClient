package zrb.hu.nl.hitcountbtclient;

import android.app.AlertDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;


/**
 * Created by JZuurbier on 8-5-2017.
 */

public class ConnectThread extends Thread {

    private UUID MY_UUID = new UUID(0xffffffffffffffffL,0x1L);
    private Context cntxt;
    private BluetoothDevice device;

    ConnectThread(Context cntxt, BluetoothDevice device){
        this.cntxt = cntxt;
        this.device = device;
    }


    public void run() {
        try{
            //todo

        }
        catch(IOException e){
            Message msg = new Message();
            msg.getData().putString("bericht", e.toString());
            myHandler.sendMessage(msg);
        }
    }

   private Handler myHandler = new Handler(){
       public void handleMessage(Message msg){
           String bericht = msg.getData().getString("bericht");
           AlertDialog dialog = new AlertDialog.Builder(cntxt).create();
           dialog.setMessage(bericht);
           dialog.show();
       }
   };

}
