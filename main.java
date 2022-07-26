/*+ 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uklperpustakaanterbaru;
// arti enkap = menyembunyikan sesuatu objek dari suatu class
//macam macam enkap = privat, public, protected = sub clas, clas sendiri, package
/**
 *
 * @author KazeeX
 */
import java.util.Scanner;
public class main {
    static Buku buku = new Buku();
    static Peminjaman peminjaman = new Peminjaman();
    static Petugas petugas = new Petugas();
    static Siswa siswa = new Siswa();
    
    static Scanner input = new Scanner(System.in);
    
    static boolean tetap = true;
    static String key;
    
    public static void main(String[] args){
     System.out.println("Masukkan ID Siswa");
        int id = input.nextInt();
        int BukuPinjaman = 4;
        System.out.println("Selamat datang "+siswa.getNama(peminjaman.getIDSiswa(id)));
        while(tetap){
            System.out.println("-- Perpustakaan --");
            System.out.println("1. List Buku");
            System.out.println("2. List Petugas");
            System.out.println("3. List Siswa");
            System.out.println("4. Pinjam Buku");
            System.out.println("5. Beli Buku");
            System.out.println("6. Kembalikan Buku");
            System.out.println("7. Jam Operasi");
            System.out.println("8. Exit");
            System.out.print("Pilih menu: ");
            int menu = input.nextInt();
            
            if(menu==1){
                buku.tampilkanBuku();
                System.out.println("Ketik apapun dan enter untuk keluar");
                key = input.next();
            }
            else if(menu==2){
                petugas.tampilKaryawan();
                System.out.println("Ketik apapun dan enter untuk keluar");
                key = input.next();
            }
            else if(menu==3){
                siswa.tampilkanSiswa();
                System.out.println("Ketik apapun dan enter untuk keluar");
                key = input.next();
            }
            else if(menu==4){
                System.out.println("Masukkan id buku yang ingin dipinjam");
                int ID = input.nextInt();
                if(siswa.getStataus(ID)==true){
                    buku.setStok(ID, buku.getStok(ID)-1);
                    BukuPinjaman = ID;
                    System.out.println("Terimakasih telah meminjam buku "+buku.getNama(ID));
                    siswa.setStatus(peminjaman.getIDSiswa(id), false);
                    System.out.println("Ketik apapun dan enter untuk keluar");
                    key = input.next();
                }
                else{
                    System.out.println("Anda sudah meminjam buku");
                    System.out.println("Ketik apapun dan enter untuk keluar");
                    key = input.next();
                }
            }
            else if(menu==5){
                System.out.println("Masukkan id buku yang ingin dibeli");
                int ID = input.nextInt();
                System.out.println("Masukkan Jumlah buku yang ingin dibeli");
                int banyak = input.nextInt();
                peminjaman.setBanyak(banyak);
                if(peminjaman.getBanyak(peminjaman.getIDBanyak(banyak))<=buku.getStok(ID)){
                    buku.setStok(ID, buku.getStok(ID)-banyak);
                    System.out.println("Terinakasih telah membeli buku "+buku.getNama(ID));
                    System.out.println("Ketik apapun dan enter untuk keluar");
                    key = input.next();
                }
                else{
                    System.out.println("Jumlah yang anda inginkan melebihi stok");
                    System.out.println("Ketik apapun dan enter untuk keluar");
                    key = input.next();
                }
            }
            else if(menu==6){
                System.out.println("Masukkan id buku yang ingin anda kembalikan");
                int ID = input.nextInt();
                if(siswa.getStataus(peminjaman.getIDSiswa(id))==false){
                    if(peminjaman.getBuku(ID)==BukuPinjaman){
                        buku.setStok(ID, buku.getStok(ID)+1);
                        System.out.println("Terimakasih telah mengembalikan buku "+buku.getNama(ID));
                        siswa.setStatus(peminjaman.getIDSiswa(id), true);
                        System.out.println("Ketik apapun dan enter untuk keluar");
                        key = input.next();
                    }
                    else{
                        System.out.println("Buku yang ingin anda kembalikan tidak sesuai");
                        System.out.println("Ketik apapun dan enter untuk keluar");
                        key = input.next();
                    }
                }
                else{
                    System.out.println("Anda belum meminjam buku");
                    System.out.println("Ketik apapun dan enter untuk keluar");
                    key = input.next();
                }
            }
            else if(menu==7){
                System.out.println("======== JAM OPERASI =======");
                System.out.println("Hari"+"\t\t"+"Jam");
                JamBukak a = new weekday();
                System.out.println (a.Jam());
                a=new weekend();
                System.out.println (a.Jam());
                System.out.println("Ketik apapun dan enter untuk keluar");
                key = input.next();

            }else if(menu==8){
                tetap = false;
            }
            else{
                System.out.println("Input anda salah");
                System.out.println("Ketik apapun dan enter untuk keluar");
                key = input.next();
            }
        }
    }
}