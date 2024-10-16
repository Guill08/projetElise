package objet.photo;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Portrait {
    private Nez nez;
    private Bouche bouche;
    private Oeil oeilDroit;
    private Oeil oeilGauche;
    private Oreille oreilleDroit;
    private Oreille oreilleGauche;
    private Visage visage;
    private BufferedImage image;
    public Portrait(Nez nez, Bouche bouche, Oeil oeilDroit, Oeil oeilGauche, Oreille oreilleDroit, Oreille oreilleGauche, Visage visage) {
        this.nez = nez;
        this.bouche = bouche;
        this.oeilDroit = oeilDroit;
        this.oeilGauche = oeilGauche;
        this.oreilleDroit = oreilleDroit;
        this.oreilleGauche = oreilleGauche;
        this.visage = visage;
        image = visage.getImage();
        ajouter(nez);
        ajouter(bouche);
        ajouter(oeilDroit);
        ajouter(oeilGauche);
        ajouter(oreilleDroit);
        ajouter(oreilleGauche);
      //  ajouter(visage);
    }

    public BufferedImage getImage() {
        return image;
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
