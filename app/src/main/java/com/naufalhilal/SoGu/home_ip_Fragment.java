package com.naufalhilal.SoGu;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



/**
 * A simple {@link Fragment} subclass.
 * Use the {@link home_ip_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class home_ip_Fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public home_ip_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment home_ip_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static home_ip_Fragment newInstance(String param1, String param2) {
        home_ip_Fragment fragment = new home_ip_Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        TextView ipKotaAsal;
        TextView ipJamBrkt;
        TextView iptglBrkt;
        TextView ipHarga;
        TextView ipKotaTujuan;
        TextView ipJamSampai;
        TextView ipTglSampai;
        View view=inflater.inflate(R.layout.fragment_home_ip_, container, false);
        ipKotaAsal=(TextView)view.findViewById(R.id.kota_asal);
        ipJamBrkt=(TextView)view.findViewById(R.id.jamBerangkat);
        iptglBrkt=(TextView)view.findViewById(R.id.tgl_berangkat);
        ipHarga=(TextView)view.findViewById(R.id.harga_tiket);
        ipKotaTujuan=(TextView)view.findViewById(R.id.kota_tujuan);
        ipJamSampai=(TextView)view.findViewById(R.id.jam_sampai);
        ipTglSampai=(TextView)view.findViewById(R.id.tgl_sampai);

        String kotaasal=getActivity().getIntent().getStringExtra("kota_asal");
        String jambrkt=getActivity().getIntent().getStringExtra("jam_brkt");
        String tglbrkt=getActivity().getIntent().getStringExtra("tgl_brkt");
        String harga=getActivity().getIntent().getStringExtra("harga");
        String kotatujuan=getActivity().getIntent().getStringExtra("kota_tujuan");
        String jamsampai=getActivity().getIntent().getStringExtra("jam_sampai");
        String tglsampai=getActivity().getIntent().getStringExtra("tgl_sampai");

        ipKotaAsal.setText(kotaasal);
        ipJamBrkt.setText(jambrkt);
        iptglBrkt.setText(tglbrkt);
        ipHarga.setText(harga);
        ipKotaTujuan.setText(kotatujuan);
        ipJamSampai.setText(jamsampai);
        ipTglSampai.setText(tglsampai);

        return view;
    }
}