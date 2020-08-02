
package prolab.pkg2;

import java.awt.Font;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Prolab2 {

    public static int flag = -5;    //eger static fonksiyon taniimlasaydik ImageIcon fonksiyonu calismayacakti.
    public static String gercekOyuncuAdi = "";
    public static int gercekOyuncuId;
    static boolean cikayimMi = false;

    public void PrepareHomePage() { // classin methodu olmsasi icin static yaptik.

        JFrame homePage = new JFrame("Pokemon Oyunu");
        ImageIcon icon = new ImageIcon(this.getClass().getResource("frameIcon.png"));
        homePage.setIconImage(icon.getImage());
        JLabel resim = new JLabel(new ImageIcon(this.getClass().getResource("pokemon-logo.png")));  //not düş
        JPanel panel = new JPanel();
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JButton bilgisayarVSBilgisayar = new JButton("Bilgisayar VS Bilgisayar");
        JButton bilgisayarVSOyuncu = new JButton("Bilgisayar VS Oyuncu  ");
        JButton cikis = new JButton("Oyundan Çıkış");
        resim.setBounds(0, 10, 401, 401);
        panel.setBounds(200, 200, 200, 200);
        panel1.setBounds(200, 200, 200, 200);
        panel2.setBounds(200, 200, 200, 200);
        bilgisayarVSBilgisayar.setFont(new java.awt.Font("Arial", Font.BOLD, 24));
        bilgisayarVSOyuncu.setFont(new java.awt.Font("Arial", Font.BOLD, 24));
        cikis.setFont(new java.awt.Font("Arial", Font.BOLD, 24));
        panel.add(bilgisayarVSBilgisayar);
        panel1.add(bilgisayarVSOyuncu);
        panel2.add(cikis);

        homePage.setSize(700, 600);
        homePage.setLocationRelativeTo(null);// mesaj kutusunu merkeze almayi sagliyor.
        homePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        homePage.add(resim);
        homePage.add(panel);
        homePage.add(panel1);
        homePage.add(panel2);
        homePage.setLayout(new FlowLayout(FlowLayout.CENTER));
        homePage.setVisible(true);
        homePage.setResizable(false); // framin tekrar boyutlanmaini istemiyoruz

        /**
         * *************************************
         * giris sayfasi olustutuldu. butonlara eylem atamasi yapilacak.
         */
        bilgisayarVSBilgisayar.addActionListener(new ActionListener() {
            // buton tiklanirsa.
            public void actionPerformed(ActionEvent e) {

                flag = 0;
                homePage.dispose();

            }
        });
        bilgisayarVSOyuncu.addActionListener(new ActionListener() {
            // buton tiklanirsa.
            public void actionPerformed(ActionEvent e) {

                flag = 1;
                homePage.dispose();

            }
        });
        cikis.addActionListener(new ActionListener() {
            // buton tiklanirsa.
            public void actionPerformed(ActionEvent e) {

                flag = 3;
                homePage.dispose();

            }
        });

    }

    public static void yenile(JFrame f) {
        f.repaint();

    }

    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        Prolab2 main = new Prolab2();

        main.PrepareHomePage();

        while (true) {

            if (flag == 1) {

                JFrame oyuncuBilgileri = new JFrame();
                JTextField isim = new JTextField();
                JTextField id = new JTextField();
                JLabel isimLabel = new JLabel("İsminiz :");
                JLabel idLabel = new JLabel("ID :");
                JButton tamam = new JButton("Tamam");
                isimLabel.setBounds(50, 50, 100, 20);
                idLabel.setBounds(50, 80, 100, 20);
                isim.setBounds(110, 50, 150, 20);
                id.setBounds(110, 80, 150, 20);
                tamam.setBounds(50, 110, 100, 20);
                oyuncuBilgileri.add(isimLabel);
                oyuncuBilgileri.add(idLabel);
                oyuncuBilgileri.add(tamam);
                oyuncuBilgileri.add(id);
                oyuncuBilgileri.add(isim);
                oyuncuBilgileri.setSize(300, 220);
                oyuncuBilgileri.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                oyuncuBilgileri.setLocationRelativeTo(null);
                oyuncuBilgileri.setLayout(null);
                oyuncuBilgileri.setVisible(true);
                //oyuncuBilgileri.setDefaultCloseOperation();

                tamam.addActionListener(new ActionListener() {
                    // buton tiklanirsa.
                    public void actionPerformed(ActionEvent e) {

                        gercekOyuncuAdi = isim.getText();
                        String temp = id.getText();
                        try { // eger kullanici int yerine string girerse hata verir.
                            gercekOyuncuId = Integer.parseInt(temp);
                        } catch ( java.lang.NumberFormatException tamamNumberFormatException) {
                           String mesaj = tamamNumberFormatException.getMessage();  
                           JOptionPane.showMessageDialog(oyuncuBilgileri,mesaj +
                                   " Oyuncu id tam sayi olmak zorundadır.","Alert",JOptionPane.WARNING_MESSAGE);                            
                           gercekOyuncuId = 0;
                           
                        }
                        
                        cikayimMi = true;
                        oyuncuBilgileri.dispose();

                    }
                });
                while (cikayimMi == false) {

                    Thread.sleep(100);
                }
                cikayimMi =false; // tekrar oynama başladığımızda beklemek için
                ComputerVsPlayerGUI computerVsPlayer = new ComputerVsPlayerGUI(gercekOyuncuAdi, gercekOyuncuId);
                computerVsPlayer.PrepareGUI();
                computerVsPlayer.Savas();
                while (computerVsPlayer.DongudenCikilsinMi() == false) {
                    Thread.sleep(100);
                }
                if (computerVsPlayer.AnaMenuyeDonulsunMu()) {
                    main.PrepareHomePage();
                }
                computerVsPlayer.setDongudenCikilsinMi(false);

                if (computerVsPlayer.ProgramSonlansinMi()) {
                    return;//eger program sonlandirilmisa basilmissa oyundan cikilacak.
                }

            } else if (flag == 0) {

                ComputerVsComputerGUI computerVsComputer = new ComputerVsComputerGUI();
                computerVsComputer.Savas();
                while (computerVsComputer.DongudenCikilsinMi() == false) {
                    Thread.sleep(200);
                }
                if (computerVsComputer.AnaMenuyeDonulsunMu()) {
                    main.PrepareHomePage();
                }
                computerVsComputer.setDongudenCikilsinMi(false);

                if (computerVsComputer.ProgramSonlansinMi()) {
                    return;//eger program sonlandirilmisa basilmissa oyundan cikilacak.
                }
            } else if (flag == 3) {
                return;
            }

            Thread.sleep(200);
        }

    }

}
