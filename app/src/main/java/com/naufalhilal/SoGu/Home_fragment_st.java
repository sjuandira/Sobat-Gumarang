package com.naufalhilal.SoGu;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Home_fragment_st#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Home_fragment_st extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    String[] items={"Bandar Lampung", "Bukittinggi", "Payakumbuh"};
    AutoCompleteTextView autoCompleteTextView;
    AutoCompleteTextView autoCompleteTextView1;
    ArrayAdapter<String> adapterItem;
    public Home_fragment_st() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Home_fragment_st.
     */
    // TODO: Rename and change types and number of parameters
    public static Home_fragment_st newInstance(String param1, String param2) {
        Home_fragment_st fragment = new Home_fragment_st();
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
        View view = inflater.inflate(R.layout.fragment_home_st, container, false);
        // Inflate the layout for this fragment
        autoCompleteTextView= view.findViewById(R.id.asal);
        autoCompleteTextView1= view.findViewById(R.id.tujuan);
        adapterItem= new ArrayAdapter<String>(getContext(), R.layout.dropdown_item, items);
        autoCompleteTextView.setAdapter(adapterItem);
        autoCompleteTextView1.setAdapter(adapterItem);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(getContext(),"Item: "+item,Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}