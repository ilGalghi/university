import javax.swing.*;
import java.awt.*;

public class Main_Finestra {

    public static void main(String[] args) {
    	
        // Imposta il look and feel di Windows 10
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        JFrame finestra = new JFrame("Applicazione Windows 10");
        JButton uno = new JButton("DAJE");
        finestra.setLayout(new BorderLayout());

        finestra.add(uno, BorderLayout.NORTH);

        Listener_Finestra risp = new Listener_Finestra();
        uno.addActionListener(risp);

        JTextArea testo = new JTextArea(10, 10);
        risp.testo = testo;

        JScrollPane scroll = new JScrollPane(testo);
        scroll.setPreferredSize(new Dimension(450, 110));

        JButton due = new JButton("FORZA");
        finestra.add(due, BorderLayout.SOUTH);
        due.addActionListener(risp);

        finestra.add(scroll, BorderLayout.CENTER);

        testo.append("Scrivi qualcosa:\n");

        finestra.pack();
        finestra.setLocationRelativeTo(null); // Imposta la posizione al centro dello schermo
        finestra.setVisible(true);
        finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        System.out.println("fine");
    }

    
}
