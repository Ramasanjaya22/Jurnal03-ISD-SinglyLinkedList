package com.perusahaan;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	SinglyLinkedList<Pegawai> linkedList = new SinglyLinkedList<>();
        Scanner in = new Scanner(System.in);

        String masukkanNip;
        String masukkanNama;
        String masukkanDivisi;
        String pilihanUser;
        int daftarMenu = 0;
        int pilihanHapus = 0;

        //membuat daftar menu
        while(daftarMenu != 4){
            System.out.println("\n Daftar Menu: ");
            System.out.println("\t 1. Input data pegawai");
            System.out.println("\t 2. Hapus data pegawai");
            System.out.println("\t 3. Tampilkan data pegawai");
            System.out.println("\t 4. Keluar");
            System.out.println("\n\t Pilihan anda :");
            daftarMenu = in.nextInt();

            //opsi 1 Input data Pegawai
            if (daftarMenu == 1){
                System.out.println("Masukkan data(tulis nip,nama,dan divisi pegawai): ");
                masukkanNip = in.next();
                masukkanNama = in.next();
                masukkanDivisi = in.next();

                //pilih dimana posisi data akan dimasukkan
                System.out.println("Tambahkan data di awal list? (y/n)?");
                pilihanUser = in.next();

                if (pilihanUser.equalsIgnoreCase("y")){
                    linkedList.tambahDiAwal(new Pegawai(masukkanNip,masukkanNama,masukkanDivisi));
                }
                if (pilihanUser.equalsIgnoreCase("n")){
                    linkedList.tambahDiAkhir(new Pegawai(masukkanNip,masukkanNama,masukkanDivisi));
                }
            }

            //opsi 2 Hapus data
            else if (daftarMenu == 2){
                System.out.println("Opsi yang akan dihapus: ");
                System.out.println("\t 1. Data Pertama");
                System.out.println("\t 2. Data Kedua");
                pilihanHapus = in.nextInt();

                //opsi hapus posisi data
                if (pilihanHapus == 1){
                    linkedList.hapusDiAwal();
                } else{
                    linkedList.hapusDiAkhir();
                }
            }

            //opsi 3. Tampilkan data pegawai
            else if(daftarMenu == 3){
                linkedList.print();
            }
        }

    }
}
