package com.kelompokB.entity;

import java.time.LocalTime;

public class Activity {
    private String namaKegiatan;
    private LocalTime waktuMulai;
    private LocalTime waktuSelesai;

    public Activity() {
    }

    public Activity(String namaKegiatan, LocalTime waktuMulai, LocalTime waktuSelesai) {
        this.namaKegiatan = namaKegiatan;
        this.waktuMulai = waktuMulai;
        this.waktuSelesai = waktuSelesai;
    }

    public String getNamaKegiatan() {
        return namaKegiatan;
    }

    public void setNamaKegiatan(String namaKegiatan) {
        this.namaKegiatan = namaKegiatan;
    }

    public LocalTime getWaktuMulai() {
        return waktuMulai;
    }

    public void setWaktuMulai(LocalTime waktuMulai) {
        this.waktuMulai = waktuMulai;
    }

    public LocalTime getWaktuSelesai() {
        return waktuSelesai;
    }

    public void setWaktuSelesai(LocalTime waktuSelesai) {
        this.waktuSelesai = waktuSelesai;
    }
}
