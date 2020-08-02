/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prolab.pkg2;


import java.util.ArrayList;
import java.util.Random;

public class OyuncuBilgisayar extends Oyuncu {

    private int sinir;
    Random random = new Random();
    private int rastgele;

    public OyuncuBilgisayar() {
    }

    public OyuncuBilgisayar(String oyuncuAdi, int oyuncuID, int Skor) {
        super(oyuncuAdi, oyuncuID, Skor);
    } 
    
   
    @Override
    public int kartSec() {
        sinir=kart.size();
        rastgele = random.nextInt(sinir);
      

        return rastgele;
    }

}
