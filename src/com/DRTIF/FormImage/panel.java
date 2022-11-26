package com.DRTIF.FormImage;

public class panel {
    String NomorKartu;
    String JenisATM;
    String Bank;
    String NamaPemilik;

    public panel() {
    }

    public panel(String nomorKartu, String jenisATM, String bank, String namaPemilik) {
        NomorKartu = nomorKartu;
        JenisATM = jenisATM;
        Bank = bank;
        NamaPemilik = namaPemilik;
    }

    public String getNomorKartu() {
        return NomorKartu;
    }

    public void setNomorKartu(String nomorKartu) {
        NomorKartu = nomorKartu;
    }

    public String getJenisATM() {
        return JenisATM;
    }

    public void setJenisATM(String jenisATM) {
        JenisATM = jenisATM;
    }

    public String getBank() {
        return Bank;
    }

    public void setBank(String bank) {
        Bank = bank;
    }

    public String getNamaPemilik() {
        return NamaPemilik;
    }

    public void setNamaPemilik(String namaPemilik) {
        NamaPemilik = namaPemilik;
    }

    @Override
    public String toString() {
        return "panel{" +
                "NomorKartu='" + NomorKartu + '\'' +
                ", JenisATM='" + JenisATM + '\'' +
                ", Bank='" + Bank + '\'' +
                ", NamaPemilik='" + NamaPemilik + '\'' +
                '}';
    }
}
