package com.naufalhilal.SoGu;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link booking_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class booking_fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public booking_fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment booking_fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static booking_fragment newInstance(String param1, String param2) {
        booking_fragment fragment = new booking_fragment();
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
        View view=inflater.inflate(R.layout.fragment_booking_fragment, container, false);
        TextView kotaasal=view.findViewById(R.id.kota_asal);
        TextView kotatujuan=view.findViewById(R.id.kota_tujuan);
        TextView jambrkt=view.findViewById(R.id.jamBerangkat);
        TextView jamsampai=view.findViewById(R.id.jam_sampai);
        TextView tglbrkt=view.findViewById(R.id.tgl_berangkat);
        TextView tglsampai=view.findViewById(R.id.tgl_sampai);

        Bundle bundle = null;
        if (getArguments()!=null){
            bundle=getArguments();
            transaksi x=(transaksi) bundle.getSerializable("transaksi");
            kotaasal.setText(x.getAsal());
            kotatujuan.setText(x.getTujuan());
            jambrkt.setText(x.getJam_brkt());
            jamsampai.setText(x.getJam_sampai());
            tglbrkt.setText(x.getTgl_brkt());
            tglsampai.setText(x.getTgl_sampai());
        }
        return view;
    }
}