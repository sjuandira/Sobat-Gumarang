package com.naufalhilal.SoGu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class detailTiket extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tiket);
        TextView asal=findViewById(R.id.asal);
        TextView tujuan=findViewById(R.id.tujuan);
        TextView jambrkt=findViewById(R.id.jambrkt);
        TextView jamsampai=findViewById(R.id.jamsampai);
        TextView tglbrkt=findViewById(R.id.tglbrkt);
        TextView tglsampai=findViewById(R.id.tglsampai);
        TextView kode=findViewById(R.id.kode);
        TextView nama=findViewById(R.id.nama);
        TextView nik=findViewById(R.id.nik);
        TextView kursi=findViewById(R.id.kursi);
        if (getIntent().getSerializableExtra("transaksi")!=null) {
            transaksi x=(transaksi) getIntent().getSerializableExtra("transaksi");
            asal.setText(x.getAsal());
            tujuan.setText(x.getTujuan());
            jambrkt.setText(x.getJam_brkt());
            jamsampai.setText(x.getJam_sampai());
            tglbrkt.setText(x.getTgl_brkt());
            tglsampai.setText(x.getTgl_sampai());
            kode.setText(Integer.toString(x.getKodeTiket()));
            nama.setText(x.getNama());
            nik.setText(x.getNik());
            kursi.setText(x.getKursi());
        }
    }
}