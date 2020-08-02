/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prolab.pkg2;

import java.awt.event.*;
import javax.swing.*;
import static prolab.pkg2.Prolab2.yenile;
public  class Pokemon {
    private String pokemonAdi;
    private String pokemonTipi;
    public boolean kartKullanildiMi = false;
    private JButton button = new JButton();
    
    public Pokemon() {
        this.pokemonAdi="Bilgi Yok.";
        this.pokemonTipi="Bilgi Yok.";
        
    }

    public Pokemon(String pokemonAdi, String pokemonTipi) {
        this.pokemonAdi = pokemonAdi;
        this.pokemonTipi = pokemonTipi;
        
    }

    public String getPokemonAdi() {
        return pokemonAdi;
    }

    public String getPokemonTipi() {
        return pokemonTipi;
    }

    public boolean isKartKullanildiMi() {
        return kartKullanildiMi;
    } 

    public void setPokemonAdi(String pokemonAdi) {
        this.pokemonAdi = pokemonAdi;
    }

    public void setPokemonTipi(String pokemonTipi) {
        this.pokemonTipi = pokemonTipi;
    }

    public void setKartKullanildiMi(boolean kartKullanildiMi) {
        this.kartKullanildiMi = kartKullanildiMi;
    }

    public void setButton(JButton button) {
        this.button = button;
    }
    
    
    
    public int hasarPuaniGoster()
    {
        return -1;
    }
    public void butonAyarla(String imagePath,int x,int y ,int width,int heigth){    
        button.setIcon(new ImageIcon(this.getClass().getResource(imagePath)));
        button.setBounds(x,y,width,heigth);// butonun konumlarini ayarladik.
        
    }
    public void tikDinle(){
        button.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e){  
              // savas fonksiyonu yazilacak.
              kartKullanildiMi=true;
              
        }  
    });
    }
    public void GUI_ekle(JFrame zemin){ // buton guimize ekleniyot.
        zemin.add(button);
        tikDinle();
        yenile(zemin);
    }
    public void GUI_cikar(JFrame zemin){
        yenile(zemin);
        zemin.remove(button);
    }
    
    
}
