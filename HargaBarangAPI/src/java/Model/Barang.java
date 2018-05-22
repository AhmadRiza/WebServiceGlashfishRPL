/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

/**
 *
 * @author Ahmad Riza
 */
public class Barang {

    private String kode;
    private String nama;
    private String tgl;
    private String satuan;
    private double harga;

    public Barang(String kode, String nama, String tgl, String satuan, double harga) {
        this.kode = kode;
        this.nama = nama;
        this.tgl = tgl;
        this.satuan = satuan;
        this.harga = harga;
    }

    public double getHarga() {
        return harga;
    }

    public String getKode() {
        return kode;
    }

    public String getNama() {
        return nama;
    }

    public String getSatuan() {
        return satuan;
    }

    public String getTgl() {
        return tgl;
    }




    
}
