
package prolab.pkg2;

import java.awt.*;
import java.awt.event.*;

import java.util.Random;
import java.util.ArrayList;
import javax.swing.*;
import static prolab.pkg2.Prolab2.flag;

public class ComputerVsPlayerGUI {

    GercekOyuncu gercekOyuncu = new GercekOyuncu("Gercek Oyuncu", 0, 0);
    OyuncuBilgisayar bot = new OyuncuBilgisayar("Bilgisayar", 1, 0);
    
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

    JLabel skorGercekOyuncu = new JLabel("Skor: 0");
    JLabel skorBilgisayar = new JLabel("Skor :0");
    JFrame mainFrame = new JFrame("Pokemon Oyunu"); // yeni bir gui olusturduk.
    JLabel botDurum = new JLabel("BOT DURUM");
    JLabel playerDurum = new JLabel("Oyuncu DURUM");

    // pokemonlar tanımlandı.
    public ArrayList<Pokemon> deste = new ArrayList<>();

    Random random = new Random();
    // kartların konumu tanımlandi.
    int[][] kartKonumu1 = {{600, 70, 202, 252}, {820, 70, 202, 252}, {1040, 70, 202, 252}};
    int[][] kartKonumu2 = {{600, 680, 202, 252}, {820, 680, 202, 252}, {1040, 680, 202, 252}};
    int[] arenaBot = {720, 370, 202, 252};
    int[] arenaGercek = {940, 370, 202, 252};

    private boolean tekrarOynansinMi = false;
    private boolean anaMenuyeDonulsunMu = false;
    private boolean dongudenCikilsinMi = false;
    private boolean programSonlansinMi = false;

    private String kazananOyuncu = "";

    public ComputerVsPlayerGUI(String oyuncuİsim, int oyuncuid) {
        gercekOyuncu.setOyuncuAdi(oyuncuİsim);
        gercekOyuncu.setOyuncuID(oyuncuid);
        
    }

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

    public void PrepareGUI() {

        JLabel real_label = new JLabel(new ImageIcon(this.getClass().getResource("real_player.png")));
        JLabel computer_label = new JLabel(new ImageIcon(this.getClass().getResource("computer.jpg")));
        JLabel computer_name = new JLabel(bot.getOyuncuAdi());
        JLabel real_name = new JLabel(gercekOyuncu.getOyuncuAdi());
        JLabel gercekOyuncuId = new JLabel("Oyuncu ID :" + Integer.toString(gercekOyuncu.getOyuncuID()));
        JLabel bilgisayarId = new JLabel("Oyuncu ID :" + Integer.toString(bot.getOyuncuID()));
        ImageIcon icon = new ImageIcon(this.getClass().getResource("frameIcon.png"));
        mainFrame.setIconImage(icon.getImage());
        mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainFrame.setLayout(null);
        mainFrame.setVisible(true);
        mainFrame.setResizable(false); // framin tekrar boyutlanmaini istemiyoruz.
        // burada sonra freame eklen şeyler gozukmez ama repaint yapiyoruz.

        real_label.setBounds(1500, 50, 214, 250);
        real_name.setFont(new Font("Arial", Font.BOLD, 24));
        real_name.setBounds(1500, 300, 200, 30);
        gercekOyuncuId.setBounds(1500, 330, 250, 30);
        gercekOyuncuId.setFont(new Font("Arial", Font.PLAIN, 24));
        skorGercekOyuncu.setBounds(1500, 360, 150, 30);
        skorGercekOyuncu.setFont(new Font("Skor : 0 ", Font.PLAIN, 30));
        playerDurum.setBounds(1500, 390, 250, 50);
        playerDurum.setFont(new Font("Arial", Font.BOLD, 18));
        //skorGercekOyuncu.setBackground(Color.white);
        skorGercekOyuncu.setForeground(Color.red);

        computer_label.setBounds(130, 50, 214, 250);
        computer_name.setBounds(130, 300, 150, 50);
        bilgisayarId.setBounds(130, 340, 250, 30);
        skorBilgisayar.setBounds(130, 370, 180, 50);
        botDurum.setBounds(130, 400, 250, 50);
        botDurum.setFont(new Font("Arial", Font.BOLD, 18));
        computer_name.setFont(new Font("Arial", Font.BOLD, 24));
        bilgisayarId.setFont(new Font("Arial", Font.PLAIN, 24));

        skorBilgisayar.setFont(new Font("Arial ", Font.PLAIN, 30));
        skorBilgisayar.setForeground(Color.red);

        mainFrame.add(real_name);
        mainFrame.add(computer_label);
        mainFrame.add(real_label);
        mainFrame.add(computer_name);
        mainFrame.add(skorGercekOyuncu);
        mainFrame.add(skorBilgisayar);
        mainFrame.add(gercekOyuncuId);
        mainFrame.add(bilgisayarId);
        mainFrame.add(playerDurum);
        mainFrame.add(botDurum);

    }

    public void Savas() throws InterruptedException {

        int i = 0;
        int sinir = 10;// index sinirini belirledim.
        int indis;
        deste.add(0, pikachu);
        deste.add(1, bulbasaur);
        deste.add(2, charmander);
        deste.add(3, squirtle);
        deste.add(4, zubat);
        deste.add(5, psyduck);
        deste.add(6, snorlax);
        deste.add(7, butterfree);
        deste.add(8, jigglypuff);
        deste.add(9, meowth);

        for (i = 0; i < 3; i++) {
            indis = random.nextInt(sinir); // rastgale bir indis
            Pokemon temp = deste.get(indis);
            gercekOyuncu.kart.add(temp);// gercek oyuncuya rastgele uc kart dagitildi.
            deste.remove(temp);
            sinir--;

        }
        for (i = 0; i < 3; i++) {
            indis = random.nextInt(sinir); // rastgale bir indis
            Pokemon temp = deste.get(indis);
            bot.kart.add(temp);// bot a rastgele uc kart dagitildi.
            deste.remove(temp);
            sinir--;
        }
        for (i = 0; i < 3; i++) { // gercek oyuncuya kartlar dagıtılıyor.

            gercekOyuncu.kart.get(i).butonAyarla("",
                    kartKonumu2[i][0], kartKonumu2[i][1], kartKonumu2[i][2],
                    kartKonumu2[i][3]);
            gercekOyuncu.kart.get(i).GUI_ekle(mainFrame);

            bot.kart.get(i).butonAyarla("",
                    kartKonumu1[i][0], kartKonumu1[i][1], kartKonumu1[i][2],
                    kartKonumu1[i][3]);
            bot.kart.get(i).GUI_ekle(mainFrame);
        }

        int botunSectigiKart = 0;
        int gercekOyuncuKart = -1;
        int randomIndex;
        int gOHasar;
        int botHasar;

        for (i = 0; i < 5; i++) {
            botDurum.setText("Bot Kart Seçiyor...");
            Thread.sleep(1000);
            botunSectigiKart = bot.kartSec();// bot kart secip index dondurecek.
            bot.kart.get(botunSectigiKart).GUI_cikar(mainFrame);
            bot.kart.get(botunSectigiKart).butonAyarla("", arenaBot[0],
                    arenaBot[1], arenaBot[2], arenaBot[3]);
            bot.kart.get(botunSectigiKart).GUI_ekle(mainFrame);
            botDurum.setText("");//botun durumu temizleniyor...
            playerDurum.setText("Lütfen bir kart seçin !");
            while (gercekOyuncuKart == -1) {
                gercekOyuncuKart = gercekOyuncu.kartSec();
                Thread.sleep(100);// cpu ya yuk indirmemek icin 100 ms bekletildi.
            }
            playerDurum.setText("");
            gercekOyuncu.kart.get(gercekOyuncuKart).GUI_cikar(mainFrame);
            gercekOyuncu.kart.get(gercekOyuncuKart).butonAyarla("",
                    arenaGercek[0], arenaGercek[1], arenaGercek[2], arenaGercek[3]);
            gercekOyuncu.kart.get(gercekOyuncuKart).GUI_ekle(mainFrame);

            gOHasar = gercekOyuncu.kart.get(gercekOyuncuKart).hasarPuaniGoster();
            botHasar = bot.kart.get(botunSectigiKart).hasarPuaniGoster();
            //Skor islemleri
            if (gOHasar > botHasar) {
                playerDurum.setText(gercekOyuncu.kart.get(gercekOyuncuKart).getPokemonAdi()
                        + " Kazandi. ");
                Thread.sleep(500);
                gercekOyuncu.SkoruArtir();
                skorGercekOyuncu.setText("Skor: " + Integer.toString(gercekOyuncu.SkorGoster()));
                Thread.sleep(1000);
                playerDurum.setText("");

            } else if (gOHasar == botHasar) {
                playerDurum.setText("Berabere Kalındı.");
                botDurum.setText("Berabere Kalındı.");

            } else {
                botDurum.setText(bot.kart.get(botunSectigiKart).getPokemonAdi()
                        + " Kazandı.");
                bot.SkoruArtir();
                Thread.sleep(500);
                skorBilgisayar.setText("Skor: " + Integer.toString(bot.SkorGoster()));
                Thread.sleep(1000);
                botDurum.setText("");

            }

            Thread.sleep(1000);// 1sn bekleme yapacak.

            bot.kart.get(botunSectigiKart).GUI_cikar(mainFrame);
            gercekOyuncu.kart.get(gercekOyuncuKart).GUI_cikar(mainFrame);
            bot.kart.remove(bot.kart.get(botunSectigiKart));
            gercekOyuncu.kart.remove(gercekOyuncu.kart.get(gercekOyuncuKart));

            // desteden yeni kartlar dağıtılıyor.
            if (deste.size() > 0) {
                randomIndex = random.nextInt(deste.size());// desteden rastgale bir kart sececek.
                gercekOyuncu.kart.add(gercekOyuncuKart, deste.get(randomIndex));
                deste.remove(randomIndex);
                randomIndex = random.nextInt(deste.size());// desteden rastgale bir kart sececek.
                bot.kart.add(botunSectigiKart, deste.get(randomIndex)); // botun sectigi kartaki index .
                deste.remove(randomIndex);

                gercekOyuncu.kart.get(gercekOyuncuKart).butonAyarla("",
                        kartKonumu2[gercekOyuncuKart][0], kartKonumu2[gercekOyuncuKart][1],
                        kartKonumu2[gercekOyuncuKart][2], kartKonumu2[gercekOyuncuKart][3]);
                gercekOyuncu.kart.get(gercekOyuncuKart).GUI_ekle(mainFrame);

                bot.kart.get(botunSectigiKart).butonAyarla("",
                        kartKonumu1[botunSectigiKart][0], kartKonumu1[botunSectigiKart][1],
                        kartKonumu1[botunSectigiKart][2], kartKonumu1[botunSectigiKart][3]);
                bot.kart.get(botunSectigiKart).GUI_ekle(mainFrame);
            }

            gercekOyuncuKart = -1;//gercek oyuncunun tekerar kart seçmesi sağlanacak.

        }
        // Kazanan Oyuncu belirleniyor.
        if (gercekOyuncu.SkorGoster() > bot.SkorGoster()) {
            kazananOyuncu = gercekOyuncu.getOyuncuAdi();
        } else if (gercekOyuncu.SkorGoster() < bot.SkorGoster()) {
            kazananOyuncu = bot.getOyuncuAdi();
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
            exitFrame.setSize(350, 120);
        } else {
            exitFrame.setSize(495, 120);
        }

        exitFrame.setLocationRelativeTo(null);// mesaj kutusunu merkeze almayi sagliyor.
        exitFrame.setLayout(new FlowLayout(FlowLayout.CENTER));
        exitFrame.setVisible(true);

        cikis.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                exitFrame.dispose();
                mainFrame.dispose();
                programSonlansinMi = true;
                dongudenCikilsinMi = true;

            }
        });
        anaMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                anaMenuyeDonulsunMu = true;
                dongudenCikilsinMi = true;
                exitFrame.dispose();
                mainFrame.dispose();
                flag = 4;// tekrar ana menüde islem yapilmasini sagladik.

            }
        });
        tekrarOyna.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // savas fonksiyonu yazilacak.
                tekrarOynansinMi = true;
                dongudenCikilsinMi = true;
                exitFrame.dispose();
                mainFrame.dispose();

            }
        });

    }
}
