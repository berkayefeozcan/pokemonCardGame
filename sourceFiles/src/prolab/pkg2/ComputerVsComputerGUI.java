
package prolab.pkg2;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static prolab.pkg2.Prolab2.yenile;
import static prolab.pkg2.Prolab2.flag;

public class ComputerVsComputerGUI {
    private boolean tekrarOynansinMi = false;
    private boolean anaMenuyeDonulsunMu = false;
    private boolean dongudenCikilsinMi=false;
    private boolean programSonlansinMi=false;
    private String kazananOyuncu = "";

    JFrame mainFrame = new JFrame();   
    
    OyuncuBilgisayar computer1 = new OyuncuBilgisayar("Bilgisayar 1",0,0);
    OyuncuBilgisayar computer2 = new OyuncuBilgisayar("Bilgisayar 2",0,0);
    ArrayList<Pokemon> listOfPokemon = new ArrayList<>();
    JTextField tbxComputer1Skor = new JTextField("  0");
    JTextField tbxComputer2Skor = new JTextField("  0");
    public boolean TekrarOynansinMi() {
        return tekrarOynansinMi;
    }

    public boolean AnaMenuyeDonulsunMu() {
        return anaMenuyeDonulsunMu;
    }

    public boolean DongudenCikilsinMi() {
        return dongudenCikilsinMi;
    }

    public void setDongudenCikilsinMi(boolean dongudenCikilsinMi) {
        this.dongudenCikilsinMi = dongudenCikilsinMi;
    }

    public boolean ProgramSonlansinMi() {
        return programSonlansinMi;
    }
    

    public ComputerVsComputerGUI() {

        ImageIcon icon = new ImageIcon(this.getClass().getResource("frameIcon.png"));
        mainFrame.setIconImage(icon.getImage());
        mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
        mainFrame.setLayout(null);
        
        
        JLabel lblComputer1 = new JLabel(new ImageIcon(this.getClass().getResource("computer.jpg")));
        JLabel lblComputer1Text = new JLabel("Bilgisayar1");

        lblComputer1Text.setFont(new java.awt.Font("Arial", Font.BOLD, 24));
        lblComputer1Text.setOpaque(true);
        lblComputer1Text.setBackground(Color.WHITE);
        lblComputer1Text.setForeground(Color.lightGray);

        JLabel lblComputer2 = new JLabel(new ImageIcon(this.getClass().getResource("computer.jpg")));
        JLabel lblComputer2Text = new JLabel("Bilgisayar2");

        lblComputer2Text.setFont(new java.awt.Font("Arial", Font.BOLD, 24));
        lblComputer2Text.setOpaque(true);
        lblComputer2Text.setBackground(Color.WHITE);
        lblComputer2Text.setForeground(Color.lightGray);

        lblComputer1.setBounds(0, 0, 300, 300);
        lblComputer2.setBounds(1550, 0, 300, 300);
        lblComputer1Text.setBounds(85, 320, 135, 100);
        lblComputer2Text.setBounds(1600, 300, 135, 100);

        JLabel lblComputer1Skor = new JLabel("Skor : ");
        lblComputer1Skor.setBounds(85, 500, 75, 100);
        lblComputer1Skor.setFont(new java.awt.Font("Arial", Font.BOLD, 24));
        lblComputer1Skor.setOpaque(true);
        lblComputer1Skor.setBackground(Color.WHITE);
        lblComputer1Skor.setForeground(Color.red);

        JLabel lblComputer2Skor = new JLabel("Skor : ");
        lblComputer2Skor.setBounds(1600, 500, 75, 100);
        lblComputer2Skor.setFont(new java.awt.Font("Arial", Font.BOLD, 24));
        lblComputer2Skor.setOpaque(true);
        lblComputer2Skor.setBackground(Color.WHITE);
        lblComputer2Skor.setForeground(Color.red);

        tbxComputer1Skor.setBounds(180, 500, 50, 100);
        tbxComputer1Skor.setFont(new java.awt.Font("Arial", Font.BOLD, 24));
        tbxComputer1Skor.setOpaque(true);
        tbxComputer1Skor.setBackground(Color.WHITE);
        tbxComputer1Skor.setForeground(Color.red);
        tbxComputer1Skor.setEditable(false);

        tbxComputer2Skor.setBounds(1700, 500, 50, 100);
        tbxComputer2Skor.setFont(new java.awt.Font("Arial", Font.BOLD, 24));
        tbxComputer2Skor.setOpaque(true);
        tbxComputer2Skor.setBackground(Color.WHITE);
        tbxComputer2Skor.setForeground(Color.red);
        tbxComputer2Skor.setEditable(false);

        mainFrame.add(lblComputer1);
        mainFrame.add(lblComputer2);
        mainFrame.add(lblComputer2Text);
        mainFrame.add(lblComputer1Text);
        mainFrame.add(lblComputer1Skor);
        mainFrame.add(lblComputer2Skor);
        mainFrame.add(tbxComputer1Skor);
        mainFrame.add(tbxComputer2Skor);
        mainFrame.repaint();

    }

    public void Savas() throws InterruptedException {
        Pikachu pikachu = new Pikachu("Pikachu", "Elektirik");
        Bulbasaur bulbasaur = new Bulbasaur("Bulbasaur", "Çim");
        Charmander charmander = new Charmander("Charmander", "Ateş");
        Squirtle squirtle = new Squirtle("Squirtle", "Su");
        Zubat zubat = new Zubat("Zubat", "Hava");
        Psyduck psyduck = new Psyduck("Psyduck", "Su");
        Snorlax snorlax = new Snorlax("Snorlax", "Normal");
        Butterfree butterfree = new Butterfree("Butterfree", "Hava");
        Jigglypuff jigglypuff = new Jigglypuff("Jigglypuff", "Ses");
        Meowth meowth = new Meowth("Meowth", "Normal");

        listOfPokemon.add(0, pikachu);
        listOfPokemon.add(1, bulbasaur);
        listOfPokemon.add(2, charmander);
        listOfPokemon.add(3, squirtle);
        listOfPokemon.add(4, zubat);
        listOfPokemon.add(5, psyduck);
        listOfPokemon.add(6, snorlax);
        listOfPokemon.add(7, butterfree);
        listOfPokemon.add(8, jigglypuff);
        listOfPokemon.add(9, meowth);

        int[][] kartKonumu1 = {{600, 40, 202, 252}, {820, 40, 202, 252}, {1040, 40, 202, 252}};
        int[][] kartKonumu2 = {{600, 600, 202, 252}, {820, 600, 202, 252}, {1040, 600, 202, 252}};
        int[] arenaBot1 = {720, 310, 202, 252};
        int[] arenaBot2 = {940, 310, 202, 252};

        Random random = new Random();
        int randomNumber;
        int aralik = 10;
        int i;
        for (i = 0; i < 3; i++) {

            randomNumber = random.nextInt(aralik);
            computer1.kart.add(listOfPokemon.get(randomNumber));
            listOfPokemon.get(randomNumber).butonAyarla("", kartKonumu1[i][0], kartKonumu1[i][1], kartKonumu1[i][2], kartKonumu1[i][3]);
            listOfPokemon.get(randomNumber).GUI_ekle(mainFrame);
            listOfPokemon.remove(randomNumber);
            aralik--;
        }

        for (i = 0; i < 3; i++) {
            randomNumber = random.nextInt(aralik);
            computer2.kart.add(listOfPokemon.get(randomNumber));
            listOfPokemon.get(randomNumber).butonAyarla("", kartKonumu2[i][0], kartKonumu2[i][1], kartKonumu2[i][2], kartKonumu2[i][3]);
            listOfPokemon.get(randomNumber).GUI_ekle(mainFrame);
            listOfPokemon.remove(randomNumber);
            aralik--;
        }

        for (i = 0; i < 5; i++) {
            Thread.sleep(1000);
            int randomNumber1 = computer1.kartSec();
            computer1.kart.get(randomNumber1).kartKullanildiMi = true;
            computer1.kart.get(randomNumber1).GUI_cikar(mainFrame);
            computer1.kart.get(randomNumber1).butonAyarla("", arenaBot1[0], arenaBot1[1], arenaBot1[2], arenaBot1[3]);
            computer1.kart.get(randomNumber1).GUI_ekle(mainFrame);

            int randomNumber2 = computer2.kartSec();
            computer2.kart.get(randomNumber2).kartKullanildiMi = true;
            computer2.kart.get(randomNumber2).GUI_cikar(mainFrame);
            computer2.kart.get(randomNumber2).butonAyarla("", arenaBot2[0], arenaBot2[1], arenaBot2[2], arenaBot2[3]);
            computer2.kart.get(randomNumber2).GUI_ekle(mainFrame);
            Thread.sleep(2000);
            yenile(mainFrame);
            int hasarPuani1 = computer1.kart.get(randomNumber1).hasarPuaniGoster();
            int hasarPuani2 = computer2.kart.get(randomNumber2).hasarPuaniGoster();

            if (hasarPuani1 > hasarPuani2) {
                computer1.SkoruArtir();
                tbxComputer1Skor.setText(Integer.toString(computer1.SkorGoster()));
            } else if (hasarPuani1 < hasarPuani2) {
                computer2.SkoruArtir();
                tbxComputer2Skor.setText(Integer.toString(computer2.SkorGoster()));
            }
            computer1.kart.get(randomNumber1).GUI_cikar(mainFrame);
            computer2.kart.get(randomNumber2).GUI_cikar(mainFrame);
            Thread.sleep(1000);
            computer1.kart.remove(randomNumber1);
            computer2.kart.remove(randomNumber2);

            if (listOfPokemon.size() > 0) {
                int newRandomNumber1 = random.nextInt(listOfPokemon.size());
                computer1.kart.add(randomNumber1, listOfPokemon.get(newRandomNumber1));
                listOfPokemon.remove(newRandomNumber1);
                computer1.kart.get(randomNumber1).butonAyarla("", kartKonumu1[randomNumber1][0], kartKonumu1[randomNumber1][1], kartKonumu1[randomNumber1][2], kartKonumu1[randomNumber1][3]);
                computer1.kart.get(randomNumber1).GUI_ekle(mainFrame);

                int newRandomNumber2 = random.nextInt(listOfPokemon.size());
                computer2.kart.add(randomNumber2, listOfPokemon.get(newRandomNumber2));
                listOfPokemon.remove(newRandomNumber2);
                computer2.kart.get(randomNumber2).butonAyarla("", kartKonumu2[randomNumber2][0], kartKonumu2[randomNumber2][1], kartKonumu2[randomNumber2][2], kartKonumu1[randomNumber2][3]);
                computer2.kart.get(randomNumber2).GUI_ekle(mainFrame);
            }

            mainFrame.repaint();

        }

        if (computer1.SkorGoster() > computer2.SkorGoster()) {
            kazananOyuncu = computer1.getOyuncuAdi();
        } else if (computer2.SkorGoster() > computer1.SkorGoster()) {
            kazananOyuncu = computer2.getOyuncuAdi();
        } else {
            kazananOyuncu = "Oyuncular Berabere Kaldı.";
        }
        
        JFrame exitFrame = new JFrame("Çıkış yapmak üzeresiniz.");
        JButton cikis = new JButton("Oyundan çıkış");
        JButton anaMenu = new JButton("Ana Menü");
        JButton tekrarOyna = new JButton("Tekrar Oyna");
        JLabel kazanan = new JLabel("Kazanan oyuncu :" + kazananOyuncu);
        kazanan.setFont(new java.awt.Font("Arial", Font.BOLD, 24));
        kazanan.setForeground(Color.red);

        exitFrame.add(kazanan);
        exitFrame.add(cikis);
        exitFrame.add(anaMenu);
        exitFrame.add(tekrarOyna);
        
        if (kazananOyuncu.equals("Bilgisayar")) { // Bilgisayar kazanira pencere boyutu 
            exitFrame.setSize(370, 120);
        } else {
            exitFrame.setSize(370, 120);
        }

        exitFrame.setLocationRelativeTo(null);// mesaj kutusunu merkeze almayi sagliyor.
        exitFrame.setLayout(new FlowLayout(FlowLayout.CENTER));
        exitFrame.setVisible(true);

        cikis.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                exitFrame.dispose();                
                mainFrame.dispose();
                programSonlansinMi=true;
                dongudenCikilsinMi=true;

            }
        });
        anaMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                anaMenuyeDonulsunMu = true;
                dongudenCikilsinMi=true;
                exitFrame.dispose();                
                mainFrame.dispose();
                flag=4;

            }
        });
        tekrarOyna.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // savas fonksiyonu yazilacak.
                tekrarOynansinMi = true;
                dongudenCikilsinMi=true;
                exitFrame.dispose();                
                mainFrame.dispose();

            }
        });

        

    }

}
