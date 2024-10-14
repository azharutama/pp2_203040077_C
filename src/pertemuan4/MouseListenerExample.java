package pertemuan4;

import javax.swing.*;
import java.awt.event.*;

public class MouseListenerExample {
    public static void main(String[] args) {
        // Membuat frame
        JFrame frame = new JFrame("MouseListener Example");

        // Membuat label untuk menampilkan perintah
        JLabel label = new JLabel("Arahkan dan klik mouse");
        label.setBounds(50, 50, 300, 30);

        // Menambahkan MouseListener ke label
        label.addMouseListener(new MouseListener() {
            // Dijalankan ketika mouse diklik
            public void mouseClicked(MouseEvent e) {
                label.setText("Mouse Clicked");
            }

            // Dijalankan ketika mouse ditekan
            public void mousePressed(MouseEvent e) {
                label.setText("Mouse Pressed");
            }

            // Dijalankan ketika mouse dilepas
            public void mouseReleased(MouseEvent e) {
                label.setText("Mouse Released");
            }

            // Dijalankan ketika mouse masuk
            public void mouseEntered(MouseEvent e) {
                label.setText("Mouse Entered the area.");
            }

            // Dijalankan ketika mouse keluar dari area komponen
            public void mouseExited(MouseEvent e) {
                label.setText("Mouse Exited the area.");
            }
        });

        // Menambahkan label ke frame
        frame.add(label);

        // Setting frame
        frame.setSize(400, 200);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
