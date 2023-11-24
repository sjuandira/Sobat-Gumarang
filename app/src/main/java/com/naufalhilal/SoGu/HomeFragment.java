package com.naufalhilal.SoGu;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private RecyclerView rvTiket;
    private ArrayList<Tiket> list=new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_home,container,false);

        Bundle bundle = null;
        transaksi x = new transaksi();
        if (getArguments()!=null){
            bundle=getArguments();
            x=(transaksi) bundle.getSerializable("transaksi");
        }

        rvTiket=(RecyclerView) view.findViewById(R.id.rv_tiket);
        rvTiket.setHasFixedSize(true);
        list=new ArrayList<>();
        list.addAll(tiketData.getListData());
        rvTiket.setLayoutManager(new LinearLayoutManager(getContext()));
        listTiketAdapter ListtiketAdapter=new listTiketAdapter(getContext());
        ListtiketAdapter.setListTiket(list,x);
        rvTiket.setAdapter(ListtiketAdapter);
        return view;
    }

}