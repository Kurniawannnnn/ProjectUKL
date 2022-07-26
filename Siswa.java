/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uklperpustakaanterbaru;

import java.util.ArrayList;

/**
 *
 * @author KazeeX
 */
public class Siswa implements User {
    private ArrayList<String> namaSiswa = new ArrayList<String>();
    private ArrayList<String> alamat = new ArrayList<String>();
    private ArrayList<String> telepon = new ArrayList<String>();
    private ArrayList<String> email = new ArrayList<String>();
    private ArrayList<Boolean> status = new ArrayList<Boolean>();
    
    public Siswa(){
        this.namaSiswa.add("Joko");
        this.alamat.add("Semarang");
        this.telepon.add("0894547389504");
        this.email.add("Joko123@gmail.com");
        this.status.add(true);
        
        this.namaSiswa.add("Alki");
        this.alamat.add("Papua");
        this.email.add("Alki123@gmail.com");
        this.telepon.add("0856793029690");
        this.status.add(true);
    }

    @Override
    public void setNama(String nama) {
        this.namaSiswa.add(nama);
    }

    @Override
    public void setAlamat(String alamat) {
        this.alamat.add(alamat);
    }

    @Override
    public void setTelepon(String telepon) {
        this.telepon.add(telepon);
    }
    @Override
    public void setEmail (String email){
        this.telepon.add(email);
    }

    @Override
    public String getNama(int id) {
        return this.namaSiswa.get(id);
    }

    @Override
    public String getAlamat(int id) {
        return this.alamat.get(id);
    }

    @Override
    public String getTelepon(int id) {
        return this.telepon.get(id);
    }
    @Override
    public String getEmail(int id){
        return this.email.get(id);
    }
    public void setStatus(int id, boolean status){
        this.status.set(id, status);
    }
    public boolean getStataus(int id){
        return this.status.get(id);
    }
    public void tampilkanSiswa(){
        int n = this.namaSiswa.size();
        for(int i = 0;i<n;i++){
            System.out.println("--------------------------");
            System.out.println("Nama    = "+getNama(i));
            System.out.println("Alamat  = "+getAlamat(i));
            System.out.println("Telepon = "+getTelepon(i));
            System.out.println("Email   = "+getEmail(i));
        }
        
    }
}

