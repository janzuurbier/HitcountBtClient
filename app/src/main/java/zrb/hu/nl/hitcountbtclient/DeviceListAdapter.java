package zrb.hu.nl.hitcountbtclient;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by JZuurbier on 1-5-2017.
 */

public class DeviceListAdapter extends RecyclerView.Adapter<DeviceListAdapter.MyViewHolder> {

    private ArrayList<BluetoothDevice> lijst = new ArrayList<>();
    private Bitmap mIcon1;
    private Bitmap mIcon2;
    Context cntxt;

    public DeviceListAdapter(Context c){
        mIcon1 = BitmapFactory.decodeResource(c.getResources(), R.drawable.phone);
        mIcon2 = BitmapFactory.decodeResource(c.getResources(), R.drawable.computer);
        cntxt = c;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.devicerow, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        BluetoothDevice device = lijst.get(position);
        holder.text.setText(device.getName());
        if(device.getBluetoothClass().getMajorDeviceClass()== BluetoothClass.Device.Major.PHONE)
            holder.icon.setImageBitmap(mIcon1);
        if(device.getBluetoothClass().getMajorDeviceClass()== BluetoothClass.Device.Major.COMPUTER)
            holder.icon.setImageBitmap(mIcon2);
    }

    @Override
    public int getItemCount() {
        return lijst.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView text;
        public ImageView icon;

        public MyViewHolder(View view) {
            super(view);
            text = (TextView) view.findViewById(R.id.textView1);
            icon = (ImageView) view.findViewById(R.id.imageView1);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int pos = getAdapterPosition();
            //BluetoothDevice[] devices = { lijst.get(pos)};
            //Log.i("HitCountClient", "geklikt op " + devices[0].getName());
            //new ConnectTask(cntxt).execute(devices);

            //BluetoothDevice device = lijst.get(pos);
            //Log.i("HitCountClient", "geklikt op "+ device.getName());
            //new ConnectThread(cntxt, device).start();


        }
    }

    public synchronized void add(BluetoothDevice founddevice){
        if(!lijst.contains(founddevice)) {
            lijst.add(0, founddevice);
            notifyItemInserted(0);
        }
    }

    public void clear(){
        lijst.clear();
        notifyDataSetChanged();
    }





}
