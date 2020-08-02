/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prolab.pkg2;

import java.util.ArrayList;

/**
 *
 * @author BerkayEfeOzcan
 */
public abstract class Oyuncu {
    
    private  String oyuncuAdi;
    private  int oyuncuID;
    private  int  Skor;

    public ArrayList <Pokemon> kart = new ArrayList<>(); // pokemon objeleri tutulacak.
    
    public Oyuncu() {
        oyuncuAdi = "Gecersiz kullanici";
        oyuncuID =-1;
        Skor=0;
    }

    public Oyuncu(String oyuncuAdi, int oyuncuID, int Skor) {
        this.oyuncuAdi = oyuncuAdi;
        this.oyuncuID = oyuncuID;
        this.Skor = Skor;
    }

    public String getOyuncuAdi() {
        return oyuncuAdi;
    }

    public int getOyuncuID() {
        return oyuncuID;
    }

   

    public void setOyuncuAdi(String oyuncuAdi) {
        this.oyuncuAdi = oyuncuAdi;
    }

    public void setOyuncuID(int oyuncuID) {
        this.oyuncuID = oyuncuID;
    }

    public void setSkor(int Skor) {
        this.Skor = Skor;
    }
    
    public int SkorGoster(){
        return Skor;
    }
    public void SkoruArtir(){
        Skor+=5;
    }
    public void kartEkle(Pokemon poke){
    
        kart.add(poke);
    }
    public void kartCikar(Pokemon poke){
        kart.remove(poke);
    }
    
   abstract int kartSec();
   
   
    
}
