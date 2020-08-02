/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prolab.pkg2;


public class GercekOyuncu extends Oyuncu{

    public GercekOyuncu() {
    }

    public GercekOyuncu(String oyuncuAdi, int oyuncuID, int Skor) {
        super(oyuncuAdi, oyuncuID, Skor);
    }
    
    
    
    @Override
    public int kartSec() {
        int i;
        int index=-1;
        for(i=0;i<kart.size();i++){
            if(kart.get(i).kartKullanildiMi){
                index=i;
                        
            }
        }
       return index;
    }
    
}
