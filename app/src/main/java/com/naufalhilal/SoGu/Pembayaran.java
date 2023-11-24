package com.naufalhilal.SoGu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;
import java.util.Random;

public class Pembayaran extends AppCompatActivity {
    String seat="";
    Random random=new Random();
    int n=random.nextInt(1000000000);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pembayaran);
        TextView kode=findViewById(R.id.kode_pambayaran);
        kode.setText(Integer.toString(n));

        FirebaseFirestore database=FirebaseFirestore.getInstance();
        database.collection("seat").document("bis01").get().addOnCompleteListener(task -> {
            if(task.isSuccessful()) {

                DocumentSnapshot document = task.getResult();
                if (document.exists()) {

                    seat = document.getString("seat");
                    String seatUpdate=seat.substring(0,hitungKursi())+"U"+seat.substring(hitungKursi()+1);
                    database.collection("seat").document("bis01").update("seat",seatUpdate).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            Toast.makeText(Pembayaran.this, "Data berhasil di update", Toast.LENGTH_SHORT).show();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(Pembayaran.this, "", Toast.LENGTH_SHORT).show();
                            Toast.makeText(Pembayaran.this, "Data gagal diupdate ", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
    }
    private int hitungKursi(){
        transaksi x=(transaksi) getIntent().getSerializableExtra("transaksi");
        int hitungKursi=Integer.parseInt(x.getKursi().substring(0,x.getKursi().length()-1));
        if (hitungKursi<=4){
            hitungKursi+=2;
        } else if (hitungKursi<=6) {
            hitungKursi+=3;
        }else if (hitungKursi<=8) {
            hitungKursi+=5;
        }else if (hitungKursi<=10) {
            hitungKursi+=6;
        }else if (hitungKursi<=12) {
            hitungKursi+=8;
        }else if (hitungKursi<=14) {
            hitungKursi+=9;
        }else if (hitungKursi<=16) {
            hitungKursi+=11;
        }else if (hitungKursi<=18) {
            hitungKursi+=12;
        }else if (hitungKursi<=20) {
            hitungKursi+=14;
        }else if (hitungKursi<=22) {
            hitungKursi+=15;
        }else if (hitungKursi<=24) {
            hitungKursi+=17;
        }else if (hitungKursi<=26) {
            hitungKursi+=18;
        }else if (hitungKursi<=28) {
            hitungKursi+=20;
        }else if (hitungKursi<=30) {
            hitungKursi+=21;
        }else if (hitungKursi<=32) {
            hitungKursi+=23;
        }else if (hitungKursi<=34) {
            hitungKursi+=24;
        }else if (hitungKursi<=36) {
            hitungKursi+=26;
        }else if (hitungKursi<=38) {
            hitungKursi+=31;
        }else if (hitungKursi<=41) {
            hitungKursi+=35;
        }
        return hitungKursi;
    }

    public void gotoMainActivity(View view){
        Intent intent=new Intent(this,searchTiket.class);
        transaksi x=(transaksi) getIntent().getSerializableExtra("transaksi");
        x.setKodeTiket(n);
        intent.putExtra("transaksi",x);
        startActivity(intent);
        finish();
    }
}