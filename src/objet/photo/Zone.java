package objet.photo;

import java.awt.image.BufferedImage;

public abstract class Zone {
    protected BufferedImage image;
    protected int x;
    protected int y;

    public Zone(BufferedImage image) {
        this.image = image;
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
}
