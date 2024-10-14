package pertemuan4;

import javax.swing.*;
import java.awt.event.*;

public class WindowListenerExample {
  public static void main(String[] args) {
    JFrame frame = new JFrame("WindowListener Example");
    JLabel label = new JLabel("Lakukan operasi pada jendela");
    label.setBounds(50, 50, 300, 30);

    frame.addWindowListener(new WindowListener() {

      public void windowOpened(WindowEvent e) {
        label.setText("Window opened");
      }

      public void windowClosing(WindowEvent e) {
        label.setText("Window closing");
      }

      public void windowClosed(WindowEvent e) {
        label.setText("Window closed");
      }

      // Correct method name for window minimized event
      public void windowIconified(WindowEvent e) {
        label.setText("Window minimized");
      }

      public void windowDeiconified(WindowEvent e) {
        label.setText("Window restored");
      }

      public void windowActivated(WindowEvent e) {
        label.setText("Window activated");
      }

      public void windowDeactivated(WindowEvent e) {
        label.setText("Window deactivated");
      }
    });

    frame.add(label);
    frame.setSize(400, 200);
    frame.setLayout(null);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
