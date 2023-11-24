package com.naufalhilal.SoGu;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class listTiketAdapter extends RecyclerView.Adapter<listTiketAdapter.ListViewHolder>{
    private ArrayList<Tiket> listTiket;
    private Context context;
    public listTiketAdapter(Context context){
        this.context=context;
    }

    public ArrayList<Tiket> getListTiket() {
        return listTiket;
    }
    private transaksi x;

    public void setListTiket(ArrayList<Tiket> listTiket,transaksi x) {
        this.listTiket = listTiket;
        this.x=x;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_ticket,parent,false);
        ListViewHolder viewHolder=new ListViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        Tiket tiket=listTiket.get(position);
        holder.tvKotaAsal.setText(x.getAsal());
        holder.tvJamBrkt.setText(tiket.getJam_brkt());
        holder.tvTgl_brkt.setText(tiket.getTgl_brkt());
        holder.tvHarga.setText(tiket.getHarga());
        holder.tvKota_tujuan.setText(x.getTujuan());
        holder.tvJam_sampai.setText(tiket.getJam_sampai());
        holder.tvTgl_sampai.setText(tiket.getTgl_sampai());
        holder.rl_tiket.setOnClickListener(new CustomOnItemClickListener(position, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                final Intent intent;
                switch (position){
                    case 0:
                        intent=new Intent(context,identidasPenumpang.class);
                        intent.putExtra("kota_asal",x.getAsal());
                        intent.putExtra("jam_brkt",tiket.getJam_brkt());
                        intent.putExtra("tgl_brkt",tiket.getTgl_brkt());
                        intent.putExtra("harga",tiket.getHarga());
                        intent.putExtra("kota_tujuan",x.getTujuan());
                        intent.putExtra("jam_sampai",tiket.getJam_sampai());
                        intent.putExtra("tgl_sampai",tiket.getTgl_sampai());
                        break;
                    case 1:
                        intent=new Intent(context,identidasPenumpang.class);
                        intent.putExtra("kota_asal",x.getAsal());
                        intent.putExtra("jam_brkt",tiket.getJam_brkt());
                        intent.putExtra("tgl_brkt",tiket.getTgl_brkt());
                        intent.putExtra("harga",tiket.getHarga());
                        intent.putExtra("kota_tujuan",x.getTujuan());
                        intent.putExtra("jam_sampai",tiket.getJam_sampai());
                        intent.putExtra("tgl_sampai",tiket.getTgl_sampai());
                        break;
                    default:
                        intent=new Intent(context,HomeFragment.class);
                        break;
                }
                context.startActivity(intent);
            }

        }));
    }

    @Override
    public int getItemCount() {
        return listTiket.size();
    }
    public class ListViewHolder extends RecyclerView.ViewHolder {
        TextView tvKotaAsal;
        TextView tvJamBrkt;
        TextView tvTgl_brkt;
        TextView tvHarga;
        TextView tvKota_tujuan;
        TextView tvJam_sampai;
        TextView tvTgl_sampai;
        RelativeLayout rl_tiket;
        public ListViewHolder(View itemview) {
            super(itemview);
            rl_tiket=itemview.findViewById(R.id.layout_tiket);
            tvKotaAsal=itemview.findViewById(R.id.kota_asal);
            tvJamBrkt=itemview.findViewById(R.id.jamBerangkat);
            tvTgl_brkt=itemview.findViewById(R.id.tgl_berangkat);
            tvHarga=itemview.findViewById(R.id.harga_tiket);
            tvKota_tujuan=itemview.findViewById(R.id.kota_tujuan);
            tvJam_sampai=itemview.findViewById(R.id.jam_sampai);
            tvTgl_sampai=itemview.findViewById(R.id.tgl_sampai);
        }
    }
}
