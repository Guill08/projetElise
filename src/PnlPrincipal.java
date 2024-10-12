import java.awt.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Sat Oct 12 14:26:13 CEST 2024
 */



/**
 * @author 33650
 */
public class PnlPrincipal extends JPanel {
    public PnlPrincipal() {
        initComponents();
    }

    private void createUIComponents() {
        ImageIcon icon1 = new ImageIcon("C:\\Users\\33650\\Pictures\\fototech\\ht_colore.png\\");
        ImageIcon scaledIcon1 = getImageIcon(icon1);

        ImageIcon icon2 = new ImageIcon("C:\\Users\\33650\\Pictures\\fototech\\milieu_colore.png\\");
        ImageIcon scaledIcon2= getImageIcon(icon2);


        ImageIcon icon3 = new ImageIcon("C:\\Users\\33650\\Pictures\\fototech\\bas_colore.png\\");
        ImageIcon scaledIcon3 = getImageIcon(icon3);


        // Créer un JLabel pour contenir l'image redimensionnée
      //  JLabel label = new JLabel(scaledIcon);
        // Créer un JLabel pour contenir l'image redimensionnée
        label3 = new JLabel(scaledIcon1);
        label4 = new JLabel(scaledIcon2);
        label5 = new JLabel(scaledIcon3);
        // TODO: add custom component creation code here
    }

    private static ImageIcon getImageIcon(ImageIcon icon) {
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

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        createUIComponents();

        panel1 = new JPanel();
        panel2 = new JPanel();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        setLayout(new BorderLayout());

        //======== panel1 ========
        {
            panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));

            //---- label3 ----
            label3.setText("text");
            label3.setPreferredSize(new Dimension(24, 150));
            label3.setMaximumSize(new Dimension(234, 150));
            panel1.add(label3);

            //---- label4 ----
            label4.setText("text");
            label4.setPreferredSize(new Dimension(24, 150));
            label4.setMaximumSize(new Dimension(234, 150));
            panel1.add(label4);

            //---- label5 ----
            label5.setText("text");
            label5.setPreferredSize(new Dimension(24, 150));
            label5.setMaximumSize(new Dimension(234, 150));
            panel1.add(label5);
        }
        add(panel1, BorderLayout.CENTER);

        //======== panel2 ========
        {
            panel2.setLayout(new FlowLayout());

            //---- button1 ----
            button1.setText("text");
            panel2.add(button1);

            //---- button2 ----
            button2.setText("text");
            panel2.add(button2);
        }
        add(panel2, BorderLayout.SOUTH);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel panel1;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JPanel panel2;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
