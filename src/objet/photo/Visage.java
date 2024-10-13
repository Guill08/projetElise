package objet.photo;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

public class Visage extends Zone {
    public Visage(BufferedImage image) {
        super(image);
    }

    public  void ajouter(Zone zone) {




        // Vérifiez si les images ont été chargées correctement

        // Obtenir les dimensions de l'image combinée (assumons une disposition verticale)

        int width = image.getWidth();
        int height = image.getHeight();
        // Créer une nouvelle image combinée
        BufferedImage nouvelleImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        // Dessiner les images sur l'image combinée
        Graphics2D g2d = nouvelleImage.createGraphics();
        g2d.drawImage(image, 0, 0, null);
        g2d.drawImage(zone.getImage(), zone.getX(),zone.getY(), null);
        g2d.dispose();
        this.image = nouvelleImage;



        // Afficher l'image combinée dans un JLabel

    }
}