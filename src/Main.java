import objet.photo.Oeil;
import objet.photo.Visage;
import objet.photo.Zone;


import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Main extends JFrame {
    public Main() {
        Visage visage = new Visage(loadImage("C:\\Users\\33650\\Pictures\\fototech2\\visage.png"));

        setSize(visage.getImage().getWidth(), visage.getImage().getHeight());

        Oeil oeilDB = new Oeil(loadImage("C:\\Users\\33650\\Pictures\\fototech2\\odb.png"));
        oeilDB.setX(990);
        oeilDB.setY(981);

        Oeil oeilD = new Oeil(loadImage("C:\\Users\\33650\\Pictures\\fototech2\\od.png"));
        oeilD.setX(990);
        oeilD.setY(981);

        Oeil oeilG = new Oeil(loadImage("C:\\Users\\33650\\Pictures\\fototech2\\og.png"));
        oeilG.setX(318);
        oeilG.setY(999);

        Oeil oeilGV = new Oeil(loadImage("C:\\Users\\33650\\Pictures\\fototech2\\ogv.png"));
        oeilGV.setX(318);
        oeilGV.setY(999);

        ArrayList<Zone> collectionZone = new ArrayList<Zone>();
        collectionZone.add(oeilDB);
        collectionZone.add(oeilD);
        collectionZone.add(oeilG);
        collectionZone.add(oeilGV);




        JLabel label = new JLabel(getImageIcon(new ImageIcon(visage.getImage())));
        add(label);
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    Random rand = new Random();
                    int i = rand.nextInt(collectionZone.size());
                    visage.ajouter(collectionZone.get(i));
                    label.setIcon(getImageIcon(new ImageIcon(visage.getImage())));
                }
            }
        });
        // Configurer le cadre
        setTitle("Combiner Images en Disposition Verticale");

        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private BufferedImage initUI(Main combineImagesVertical) {
        // Charger les images
        BufferedImage image1a = loadImage("C:\\Users\\33650\\Pictures\\fototech\\ht.png");
        BufferedImage image2a = loadImage("C:\\Users\\33650\\Pictures\\fototech\\milieu.png");
        BufferedImage image3a = loadImage("C:\\Users\\33650\\Pictures\\fototech\\bas.png");
        BufferedImage image4a = loadImage("C:\\Users\\33650\\Pictures\\fototech\\ht_sf.png");
        BufferedImage image5a = loadImage("C:\\Users\\33650\\Pictures\\fototech\\milieu_sf.png");
        BufferedImage image6a = loadImage("C:\\Users\\33650\\Pictures\\fototech\\bas_sf.png");
        ArrayList<BufferedImage> collectedImages = new ArrayList<BufferedImage>();
        Random rand = new Random();
        collectedImages.add(image1a);
        collectedImages.add(image2a);
        collectedImages.add(image3a);
        collectedImages.add(image4a);
        collectedImages.add(image5a);
        collectedImages.add(image6a);
        BufferedImage image1 = collectedImages.get(rand.nextInt(6));
        BufferedImage image2 = collectedImages.get(rand.nextInt(6));
        BufferedImage image3 = collectedImages.get(rand.nextInt(6));

        // Vérifiez si les images ont été chargées correctement

        // Obtenir les dimensions de l'image combinée (assumons une disposition verticale)

        int width = Math.max(image1.getWidth(), image2.getWidth());
        int height = image1.getHeight() + image2.getHeight();
        // Créer une nouvelle image combinée
        BufferedImage combinedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        // Dessiner les images sur l'image combinée
        Graphics2D g2d = combinedImage.createGraphics();
        g2d.drawImage(image1, 0, 0, null);
        g2d.drawImage(image2, 0, image1.getHeight(), null);
        g2d.dispose();


        int width1 = Math.max(combinedImage.getWidth(), image3.getWidth());
        int height1 = combinedImage.getHeight() + image3.getHeight();

        BufferedImage combinedImage1 = new BufferedImage(width1, height1, BufferedImage.TYPE_INT_ARGB);

        // Dessiner les images sur l'image combinée
        Graphics2D g2d1 = combinedImage1.createGraphics();
        g2d1.drawImage(combinedImage, 0, 0, null);
        g2d1.drawImage(image3, 0, combinedImage.getHeight(), null);
        g2d1.dispose();
        setSize(width, height);
return combinedImage1;
        // Afficher l'image combinée dans un JLabel

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
            ex.setVisible(true);
        });
    }
}