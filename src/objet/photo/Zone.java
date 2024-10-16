package objet.photo;

import java.awt.image.BufferedImage;
import java.util.Random;

public abstract class Zone {
    protected BufferedImage image;
    protected int x;
    protected int y;
    protected int maxTaille =4;

    public Zone(BufferedImage image) {
        this.image = image;
    }

    public Zone() {
    }

    public BufferedImage getImage() {
        return image;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
    public static int genererNombnreAleatoire(int maxTaille) {
        Random random = new Random();
        return random.nextInt(maxTaille);
    }
}
