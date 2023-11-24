package com.naufalhilal.SoGu;

import java.util.ArrayList;

public class tiketData {
    private static String [] kotaAsal={
           "Tanjung Karang(TNK)",
            "Tanjung Karang(TNK)"
    };
    private static String[] jamBrkt={
      "18.51","20.35"
    };
    private static String[] tglBrkt={
            "19 Maret 2023","19 Maret 2023"
    };
    private static String[]harga={
            "Rp.400.000","Rp.400.000"
    };
    private static String []kotaTujuan={
            "BukitTinggi(PDG)","Payakumbuh(PDG)"
    };
    private static String []jamSampai={
            "06.00","08.16"
    };
    private static String []tglSampai={
            "20 Maret 2023","20 Maret 2023"
    };

    static ArrayList<Tiket> getListData(){
        ArrayList<Tiket> list=new ArrayList<>();
        for (int i =0;i<kotaAsal.length;i++){
            Tiket tiket = new Tiket();
            tiket.setKota_asal(kotaAsal[i]);
            tiket.setKota_tujuan(kotaTujuan[i]);
            tiket.setJam_brkt(jamBrkt[i]);
            tiket.setTgl_brkt(tglBrkt[i]);
            tiket.setHarga(harga[i]);
            tiket.setJam_sampai(jamSampai[i]);
            tiket.setTgl_sampai(tglSampai[i]);
            list.add(tiket);
        }
        return list;
    }
}
