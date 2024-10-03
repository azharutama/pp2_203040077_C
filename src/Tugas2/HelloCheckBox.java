package Tugas2;
import java.awt.event.*;
import javax.swing.*;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class HelloCheckBox extends JFrame {
  
  private boolean checkBoxSelected;

  public HelloCheckBox() {
    this.checkBoxSelected =false;
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JLabel labelInput = new JLabel("input nama :");
    labelInput.setBounds(15, 40, 350, 10);

    JTextField textField = new JTextField("");
    textField.setBounds(15, 60, 350, 30);

    JCheckBox checkBox = new JCheckBox("saya menyetujui syarat yang berlaku");
    checkBox.setBounds(15, 100, 350, 30);

    JButton button = new JButton("simpan");
    button.setBounds(15, 150, 100, 40);

    JTextArea txtOutput = new JTextArea("");
    txtOutput.setBounds(15, 200, 350, 100);

    checkBox.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        checkBoxSelected = (e.getStateChange() == ItemEvent.SELECTED);
      }
      
    });

    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
          // Memeriksa apakah checkbox dipilih sebelum melanjutkan
          if (checkBoxSelected) {
              String nama = textField.getText();
              txtOutput.append("Hello " + nama + "\n");
              textField.setText("");
          } else {
              txtOutput.append("Anda tidak menyetujui persyaratan\n");
          }
      }
  });

    this.add(button);
    this.add(textField);
    this.add(checkBox);
    this.add(labelInput);
    this.add(txtOutput);

    this.setSize(400, 500);
    this.setLayout(null);

  }
  
  public static void main(String[] args) {
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      public void run(){
        HelloCheckBox h = new HelloCheckBox();
        h.setVisible(true);
      }
    });
  }



  
}
