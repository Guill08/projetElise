import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import java.awt.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel( new FlatLightLaf() );
            } catch( Exception ex ) {
                System.err.println( "Failed to initialize LaF" );
            }
            FrmPrincipal frmPrincipal = new FrmPrincipal();
            frmPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frmPrincipal.setSize(800, 600); //

            PnlPrincipal pnlPrincipal = new PnlPrincipal(); // Créez une instance de FrmPrincipal
            frmPrincipal.add(pnlPrincipal, BorderLayout.CENTER); // Ajoutez le panneau au cadre

            frmPrincipal.setVisible(true); // Rendez le cadre visible
        });


    }
}