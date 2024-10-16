import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
/*
 * Created by JFormDesigner on Sat Oct 12 14:38:59 CEST 2024
 */



/**
 * @author 33650
 */
public class FrmPrincipal extends JFrame {
    public FrmPrincipal() {
        initComponents();
    }

    public JButton getButton1() {
        return button1;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        button1 = new JButton();

        //======== this ========
        setTitle("FotoTech");
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //---- button1 ----
        button1.setText("Reboot");
        contentPane.add(button1, BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
