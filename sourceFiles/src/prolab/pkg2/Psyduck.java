/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prolab.pkg2;

/**
 *
 * @author BerkayEfeOzcan
 */
public class Psyduck extends Pokemon {

    public Psyduck() {
    }

    public Psyduck(String pokemonAdi, String pokemonTipi) {
        super(pokemonAdi, pokemonTipi);
        
    }
   
    
    
    @Override
    public int hasarPuaniGoster() {
        return 20;
    }
      
    @Override
    public void butonAyarla(String imagePath, int x, int y, int width, int weigth) {
        super.butonAyarla("/pokemons/psyduck.png", x, y, width, weigth); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
