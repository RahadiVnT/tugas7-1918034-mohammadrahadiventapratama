package com.ventapratama.listjadwalkeretaapi;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainRead extends AppCompatActivity implements
        AdapterView.OnItemClickListener{
    private ListView mListView;
    private CustomListAdapter adapter_off;
    private com.ventapratama.listjadwalkeretaapi.MyDatabase db;
    private List<com.ventapratama.listjadwalkeretaapi.Jadwal> ListJadwal = new
            ArrayList<com.ventapratama.listjadwalkeretaapi.Jadwal>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_read);
        db = new com.ventapratama.listjadwalkeretaapi.MyDatabase(this);
        adapter_off = new CustomListAdapter(this, ListJadwal
        );
        mListView = (ListView) findViewById(R.id.list_alat);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        ListJadwal.clear();
        List<com.ventapratama.listjadwalkeretaapi.Jadwal> Jadwal = db.ReadJadwal();
        for (com.ventapratama.listjadwalkeretaapi.Jadwal alt : Jadwal) {
            com.ventapratama.listjadwalkeretaapi.Jadwal daftar = new com.ventapratama.listjadwalkeretaapi.Jadwal();
            daftar.set_id(alt.get_id());
            daftar.set_kode(alt.get_kode());
            daftar.set_nama(alt.get_nama());
            daftar.set_jumlah(alt.get_jumlah());
            ListJadwal.add(daftar);
            if ((ListJadwal.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int
            i, long l) {
        Object o = mListView.getItemAtPosition(i);
        com.ventapratama.listjadwalkeretaapi.Jadwal detailAlt = (com.ventapratama.listjadwalkeretaapi.Jadwal)o;
        String Sid = detailAlt.get_id();
        String Skode = detailAlt.get_kode();
        String Snama = detailAlt.get_nama();
        String Sjumlah = detailAlt.get_jumlah();
        Intent goUpdel = new Intent(MainRead.this,
                com.ventapratama.listjadwalkeretaapi.MainUpdel.class);
        goUpdel.putExtra("Iid", Sid);
        goUpdel.putExtra("Ikode", Skode);
        goUpdel.putExtra("Inama", Snama);
        goUpdel.putExtra("Ijumlah", Sjumlah);
        startActivity(goUpdel);
    }
    @Override
    protected void onResume() {
        super.onResume();
        ListJadwal.clear();
        mListView.setAdapter(adapter_off);
        List<com.ventapratama.listjadwalkeretaapi.Jadwal> Jadwal = db.ReadJadwal();
        for (com.ventapratama.listjadwalkeretaapi.Jadwal alt : Jadwal) {
            com.ventapratama.listjadwalkeretaapi.Jadwal daftar = new com.ventapratama.listjadwalkeretaapi.Jadwal();
            daftar.set_id(alt.get_id());
            daftar.set_kode(alt.get_kode());
            daftar.set_nama(alt.get_nama());
            daftar.set_jumlah(alt.get_jumlah());
            ListJadwal.add(daftar);
            if ((ListJadwal.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
}
