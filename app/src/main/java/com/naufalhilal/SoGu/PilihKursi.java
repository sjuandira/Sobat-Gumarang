package com.naufalhilal.SoGu;

import android.content.Intent;
import android.graphics.Color;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class PilihKursi extends AppCompatActivity implements View.OnClickListener {
    ViewGroup layout;

    String seats = "UU__UU/"
            + "UU__RA/"
            + "UU__UU/"
            + "AA__RR/"
            + "AA__AA/"
            + "UU__UU/"
            + "AA__AA/"
            + "AA__AA/"
            + "AA__UU/"
            + "____AA/"
            + "___AAA/";

    List<TextView> seatViewList = new ArrayList<>();
    int seatSize = 70;
    int seatGaping = 10;

    int STATUS_AVAILABLE = 1;
    int STATUS_BOOKED = 2;
    int STATUS_RESERVED = 3;
    String selectedIds = "";

    String seat = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilih_kursi);
        layout = findViewById(R.id.layoutSeat);

        seats = "/" + seats;

//        LinearLayout layoutSeat = new LinearLayout(this);
//        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        layoutSeat.setOrientation(LinearLayout.VERTICAL);
//        layoutSeat.setLayoutParams(params);
//        layoutSeat.setPadding(8 * seatGaping, 8 * seatGaping, 8 * seatGaping, 8 * seatGaping);
//        layout.addView(layoutSeat);



        FirebaseFirestore db=FirebaseFirestore.getInstance();
        db.collection("seat").document("bis01").get().addOnCompleteListener(task ->{
            if(task.isSuccessful()){

                DocumentSnapshot document = task.getResult();
                if(document.exists()){
                    seat = document.getString("seat");
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            LinearLayout layoutSeat = new LinearLayout(PilihKursi.this);
                            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                            layoutSeat.setOrientation(LinearLayout.VERTICAL);
                            layoutSeat.setLayoutParams(params);
                            layoutSeat.setPadding(8 * seatGaping, 8 * seatGaping, 8 * seatGaping, 8 * seatGaping);
                            layout.addView(layoutSeat);
                            LinearLayout layout = null;
                            int count = 0;
                            for (int index = 0; index < seat.length(); index++) {
                                if (seat.charAt(index) == '/') {
                                    layout = new LinearLayout(PilihKursi.this);
                                    layout.setOrientation(LinearLayout.HORIZONTAL);
                                    layoutSeat.addView(layout);
                                } else if (seat.charAt(index) == 'U') {
                                    count++;
                                    TextView view = new TextView(PilihKursi.this);
                                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(seatSize, seatSize);
                                    layoutParams.setMargins(seatGaping, seatGaping, seatGaping, seatGaping);
                                    view.setLayoutParams(layoutParams);
                                    view.setPadding(0, 0, 0, 2 * seatGaping);
                                    view.setId(count);
                                    view.setGravity(Gravity.CENTER);
                                    view.setBackgroundResource(R.drawable.ic_seats_booked);
                                    view.setTextColor(Color.WHITE);
                                    view.setTag(STATUS_BOOKED);
                                    view.setText(count + "");
                                    view.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 9);
                                    layout.addView(view);
                                    seatViewList.add(view);
                                    view.setOnClickListener(PilihKursi.this);
                                } else if (seat.charAt(index) == 'A') {
                                    count++;
                                    TextView view = new TextView(PilihKursi.this);
                                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(seatSize, seatSize);
                                    layoutParams.setMargins(seatGaping, seatGaping, seatGaping, seatGaping);
                                    view.setLayoutParams(layoutParams);
                                    view.setPadding(0, 0, 0, 2 * seatGaping);
                                    view.setId(count);
                                    view.setGravity(Gravity.CENTER);
                                    view.setBackgroundResource(R.drawable.ic_seats_book);
                                    view.setText(count + "");
                                    view.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 9);
                                    view.setTextColor(Color.BLACK);
                                    view.setTag(STATUS_AVAILABLE);
                                    layout.addView(view);
                                    seatViewList.add(view);
                                    view.setOnClickListener(PilihKursi.this);
                                } else if (seat.charAt(index) == 'R') {
                                    count++;
                                    TextView view = new TextView(PilihKursi.this);
                                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(seatSize, seatSize);
                                    layoutParams.setMargins(seatGaping, seatGaping, seatGaping, seatGaping);
                                    view.setLayoutParams(layoutParams);
                                    view.setPadding(0, 0, 0, 2 * seatGaping);
                                    view.setId(count);
                                    view.setGravity(Gravity.CENTER);
                                    view.setBackgroundResource(R.drawable.ic_seats_reserved);
                                    view.setText(count + "");
                                    view.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 9);
                                    view.setTextColor(Color.WHITE);
                                    view.setTag(STATUS_RESERVED);
                                    layout.addView(view);
                                    seatViewList.add(view);
                                    view.setOnClickListener(PilihKursi.this);
                                } else if (seat.charAt(index) == '_') {
                                    TextView view = new TextView(PilihKursi.this);
                                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(seatSize, seatSize);
                                    layoutParams.setMargins(seatGaping, seatGaping, seatGaping, seatGaping);
                                    view.setLayoutParams(layoutParams);
                                    view.setBackgroundColor(Color.TRANSPARENT);
                                    view.setText("");
                                    layout.addView(view);
                                }
                            }
                        }
                    });

                }
           }
        });

    }
    @Override
    public void onClick(View view) {
        int[] x = new int[0];
        if ((int) view.getTag() == STATUS_AVAILABLE) {
            if (selectedIds.contains(view.getId() + ",")) {
                selectedIds = selectedIds.replace(+view.getId() + ",", "");
                view.setBackgroundResource(R.drawable.ic_seats_book);
            } else {
                selectedIds = selectedIds + view.getId() + ",";
                view.setBackgroundResource(R.drawable.ic_seats_selected);
            }

        } else if ((int) view.getTag() == STATUS_BOOKED) {
            Toast.makeText(this, "Seat " + view.getId() + " is Booked", Toast.LENGTH_SHORT).show();
        } else if ((int) view.getTag() == STATUS_RESERVED) {
            Toast.makeText(this, "Seat " + view.getId() + " is Reserved", Toast.LENGTH_SHORT).show();
        }
    }
    public void gotoRincianPembayaran(View view){
        transaksi x=(transaksi)getIntent().getSerializableExtra("transaksi");
        x.setKursi(selectedIds);
        Intent intent=new Intent(this,rincian_pembayaran.class);
        if (selectedIds.length()!=0){
            intent.putExtra("transaksi",x);
            startActivity(intent);
        }else{
            Toast.makeText(this, "Silahkan pilih kursi", Toast.LENGTH_SHORT).show();
        }
    }
}