package com.ventapratama.listjadwalkeretaapi;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<com.ventapratama.listjadwalkeretaapi.Jadwal> Jadwal;
    public CustomListAdapter(Activity activity, List<com.ventapratama.listjadwalkeretaapi.Jadwal> Jadwal) {
        this.activity = activity;
        this.Jadwal = Jadwal;
    }
    @Override
    public int getCount() {
        return Jadwal.size();
    }
    @Override
    public Object getItem(int location) {
        return Jadwal.get(location);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup
            parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity

                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.custom_list,
                    null);
        TextView kode = (TextView)
                convertView.findViewById(R.id.text_kode);
        TextView nama = (TextView)
                convertView.findViewById(R.id.text_nama);
        TextView jumlah = (TextView)
                convertView.findViewById(R.id.text_jml);
        ImageView imageView = (ImageView)
                convertView.findViewById(R.id.iconid);
        com.ventapratama.listjadwalkeretaapi.Jadwal m = Jadwal.get(position);
        kode.setText("Kode : "+ m.get_kode());
        nama.setText("Nama : "+ m.get_nama());
        jumlah.setText("Jenis : "+ m.get_jumlah());
        return convertView;
    }
}
