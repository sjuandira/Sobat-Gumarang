package com.naufalhilal.SoGu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class rincian_pembayaran extends AppCompatActivity {
    transaksi y=new transaksi();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rincian_pembayaran);
        TextView tvKotaAsal;
        TextView tvJamBrkt;
        TextView tvTgl_brkt;
        TextView tvKota_tujuan;
        TextView tvJam_sampai;
        TextView tvTgl_sampai;
        TextView Nama;
        TextView idKursi;
        TextView harga;

        tvKotaAsal=findViewById(R.id.kota_asal);
        tvJamBrkt=findViewById(R.id.jamBerangkat);
        tvTgl_brkt=findViewById(R.id.tgl_berangkat);
        tvKota_tujuan=findViewById(R.id.kota_tujuan);
        tvJam_sampai=findViewById(R.id.jam_sampai);
        tvTgl_sampai=findViewById(R.id.tgl_sampai);
        Nama=findViewById(R.id.nama_penumpang);
        idKursi=findViewById(R.id.id_kursi);
        harga=findViewById(R.id.harga);
        transaksi x=(transaksi) getIntent().getSerializableExtra("transaksi");
        tvKotaAsal.setText(x.getAsal());
        tvJamBrkt.setText(x.getJam_brkt());
        tvTgl_brkt.setText(x.getTgl_brkt());
        tvKota_tujuan.setText(x.getTujuan());
        tvJam_sampai.setText(x.getJam_sampai());
        tvTgl_sampai.setText(x.getTgl_sampai());
        Nama.setText(x.getNama());
        idKursi.setText(x.getKursi());

        String Kursi=x.getKursi().toString();
        int banyakKursi = 0;
        for (int i=0;i<Kursi.length();i++){
            if (Kursi.charAt(i) == ','){
                banyakKursi=banyakKursi+1;
            }
        }
        String s=x.getHarga();
//        String[]parts=s.split(".");
//        String a= String.join(",",Arrays.copyOfRange(parts,1,parts.length));
//        int totalHarga=Integer.parseInt(a)*banyakKursi;
        harga.setText(s);
        y=x;
    }
    public void gotoMetodePembayaran(View view){
        Intent intent=new Intent(this,MetodePembayaran.class);
        intent.putExtra("transaksi",y);
        startActivity(intent);
    }
}