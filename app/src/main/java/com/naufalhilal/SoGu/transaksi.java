package com.naufalhilal.SoGu;

import java.io.Serializable;
import java.util.Arrays;

public class transaksi implements Serializable {
    String nama;
    String idkursi;
    String nik;
    String asal;
    String harga;
    String tujuan;
    String jam_brkt;
    String jam_sampai;
    String tgl_brkt;
    String tgl_sampai;
    int kodeTiket;

    public int getKodeTiket() {
        return kodeTiket;
    }

    public void setKodeTiket(int kodeTiket) {
        this.kodeTiket = kodeTiket;
    }

    static int[][] addElement(int[][] a, int[] e){
        a  = Arrays.copyOf(a, a.length + 1);
        a[a.length - 1] = e;
        return a;
    }
    public String getHarga(){
        return harga;
    }

    public void setHarga(String harga){
        this.harga=harga;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKursi() {
        return idkursi;
    }

    public void setKursi(String kursi) {
        this.idkursi =kursi ;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getAsal() {
        return asal;
    }

    public void setAsal(String asal) {
        this.asal = asal;
    }

    public String getTujuan() {
        return tujuan;
    }

    public void setTujuan(String tujuan) {
        this.tujuan = tujuan;
    }

    public String getJam_brkt() {
        return jam_brkt;
    }

    public void setJam_brkt(String jam_brkt) {
        this.jam_brkt = jam_brkt;
    }

    public String getJam_sampai() {
        return jam_sampai;
    }

    public void setJam_sampai(String jam_sampai) {
        this.jam_sampai = jam_sampai;
    }

    public String getTgl_brkt() {
        return tgl_brkt;
    }

    public void setTgl_brkt(String tgl_brkt) {
        this.tgl_brkt = tgl_brkt;
    }

    public String getTgl_sampai() {
        return tgl_sampai;
    }

    public void setTgl_sampai(String tgl_sampai) {
        this.tgl_sampai = tgl_sampai;
    }
}
