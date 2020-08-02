/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prolab.pkg2;

public class Bulbasaur extends Pokemon{

    public Bulbasaur() {
        
    }
    

    public Bulbasaur(String pokemonAdi, String pokemonTipi) {
        super(pokemonAdi, pokemonTipi);
    }       

    @Override
    public int hasarPuaniGoster() {
        return 50;
    }
     @Override
    public void butonAyarla(String imagePath, int x, int y, int width, int weigth) {
        super.butonAyarla("/pokemons/balbasaur.png", x, y, width, weigth); //To change body of generated methods, choose Tools | Templates.
    }
    
}
