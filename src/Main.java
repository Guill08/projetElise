import com.formdev.flatlaf.FlatLightLaf;
import objet.photo.*;
import org.ietf.jgss.Oid;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Main {
    public static ArrayList<Zone> collectionVisage = new ArrayList<Zone>();
    public static ArrayList<Zone> collectionNez = new ArrayList<Zone>();
    public static ArrayList<Zone> collectionBouche = new ArrayList<Zone>();
    public static ArrayList<Zone> collectionOeil = new ArrayList<Zone>();
    public static ArrayList<Zone> collectionOreille = new ArrayList<Zone>();

    public Main() {
        chargeListeVisage(Main.collectionVisage);
        chargeListeBouche(Main.collectionBouche);
        chargeListeNez(Main.collectionNez);
        chargeListeOreille(Main.collectionOreille);
        chargeListeOeil(Main.collectionOeil);
        Portrait portrait = genererPortrait();

        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(new FlatLightLaf());
            } catch (Exception ex) {
                System.err.println("Failed to initialize LaF");
            }
            FrmPrincipal frmPrincipal = new FrmPrincipal();
            frmPrincipal.setSize(portrait.getImage().getWidth(), portrait.getImage().getHeight());
            JLabel label = new JLabel(getImageIcon(new ImageIcon(portrait.getImage())));
            frmPrincipal.getButton1().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Portrait portrait = genererPortrait();
                    label.setIcon(getImageIcon(new ImageIcon(portrait.getImage())));

                }
            });
            frmPrincipal.add(label, BorderLayout.CENTER);
            frmPrincipal.setTitle("Auto#Portrait@");

            frmPrincipal.setLocationRelativeTo(null);
            frmPrincipal.setDefaultCloseOperation(EXIT_ON_CLOSE);
            frmPrincipal.setVisible(true);
        });


    }

    private Portrait genererPortrait() {
        Bouche bouche = (Bouche) collectionBouche.get(Zone.genererNombnreAleatoire(6));
        bouche.setX(108);
        bouche.setY(317);
        Oeil oeilD = (Oeil) collectionOeil.get(Zone.genererNombnreAleatoire(12));
        oeilD.setX(143);
        oeilD.setY(151);
        Oeil oeilG = (Oeil) collectionOeil.get(Zone.genererNombnreAleatoire(12));
        oeilG.setX(36);
        oeilG.setY(143);
        Oreille oreilleD = (Oreille) collectionOreille.get(Zone.genererNombnreAleatoire(12));
        oreilleD.setX(237);
        oreilleD.setY(204);
        Oreille oreilleG = (Oreille) collectionOreille.get(Zone.genererNombnreAleatoire(12));
        oreilleG.setX(8);
        oreilleG.setY(204);
        Nez nez = (Nez) collectionNez.get(Zone.genererNombnreAleatoire(7));
        nez.setX(126);
        nez.setY(208);
        Visage visage = (Visage) collectionVisage.get(Zone.genererNombnreAleatoire(4));
        visage.setX(0);
        visage.setY(0);
        return new Portrait(nez, bouche, oeilD, oeilG, oreilleD, oreilleG, visage);
    }

    private void chargeListeOeil(ArrayList<Zone> collectionOeil) {
        File directory = new File("photos_modeles/oeil/");
        File[] filesList = directory.listFiles((dir, name) -> new File(dir, name).isFile());
        if (filesList != null) {
            for (File file : filesList) {
                Oeil oeil = new Oeil(loadImage(file.getPath()));
                collectionOeil.add(oeil);
            }
        }
    }

    private void chargeListeOreille(ArrayList<Zone> collectionOreille) {
        File directory = new File("photos_modeles/oreille/");
        File[] filesList = directory.listFiles((dir, name) -> new File(dir, name).isFile());
        if (filesList != null) {
            for (File file : filesList) {
                Oreille oreille = new Oreille(loadImage(file.getPath()));
                collectionOreille.add(oreille);
            }
        }
    }

    private void chargeListeNez(ArrayList<Zone> collectionNez) {
        File directory = new File("photos_modeles/nez/");
        File[] filesList = directory.listFiles((dir, name) -> new File(dir, name).isFile());
        if (filesList != null) {
            for (File file : filesList) {
                Nez nez = new Nez(loadImage(file.getPath()));
                collectionNez.add(nez);
            }
        }
    }

    private void chargeListeBouche(ArrayList<Zone> collectionBouche) {
        File directory = new File("photos_modeles/bouche/");
        File[] filesList = directory.listFiles((dir, name) -> new File(dir, name).isFile());
        if (filesList != null) {
            for (File file : filesList) {
                Bouche bouche = new Bouche(loadImage(file.getPath()));
                collectionBouche.add(bouche);
            }
        }
    }

    private void chargeListeVisage(ArrayList<Zone> collectionVisage) {
        File directory = new File("photos_modeles/visage/");
        File[] filesList = directory.listFiles((dir, name) -> new File(dir, name).isFile());
        if (filesList != null) {
            for (File file : filesList) {
                Visage visage = new Visage(loadImage(file.getPath()));
                collectionVisage.add(visage);
            }
        }


    }

    private void chargeListeZone(String dossier, ArrayList<Zone> collectionVisage) {

    }


    // Méthode utilitaire pour charger une image à partir du disque
    private BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ImageIcon getImageIcon(ImageIcon icon) {
        Image originalImage = icon.getImage();

        // Obtenir les dimensions originales de l'image
        int originalWidth = icon.getIconWidth();
        int originalHeight = icon.getIconHeight();

        // Définir la taille souhaitée tout en conservant les proportions
        int targetWidth = 400;  // Par exemple, largeur cible
        int targetHeight = (targetWidth * originalHeight) / originalWidth;

        // Redimensionner l'image tout en conservant les proportions
        Image scaledImage = originalImage.getScaledInstance(targetWidth, targetHeight, Image.SCALE_SMOOTH);

        // Créer un nouvel ImageIcon avec l'image redimensionnée
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        return scaledIcon;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Main ex = new Main();

        });
    }
}