package Tugas2;

import java.awt.event.*;
import javax.swing.*;

public class HelloFinal extends JFrame {

  private boolean checkBoxSelected;
  
  public HelloFinal() {
    this.checkBoxSelected =false;
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JLabel labelNama = new JLabel("Nama:");
    labelNama.setBounds(15, 40, 350, 10);

    JTextField textNama= new JTextField("");
    textNama.setBounds(15, 60, 350, 30);

    JLabel labelTelepon = new JLabel("No Telepon:");
    labelTelepon.setBounds(15, 100, 350, 10);

    JTextField textTelepon = new JTextField("");
    textTelepon.setBounds(15, 120, 350, 30);

    JLabel labelRadio = new JLabel("Jenis kelamin");
    labelRadio.setBounds(15, 160, 350, 10);

    JRadioButton radioButton1 = new JRadioButton("Laki-Laki", true);
    radioButton1.setBounds(15, 175, 350, 30);

    JRadioButton radioButton2 = new JRadioButton("Perempuan");
    radioButton2.setBounds(15, 205, 350, 30);

   
    ButtonGroup bg = new ButtonGroup();
    bg.add(radioButton1);
    bg.add(radioButton2);

    JCheckBox checkBox = new JCheckBox("Warga Negara Asing (WNA)");
    checkBox.setBounds(15, 235, 350, 30);

    JButton button = new JButton("simpan");
    button.setBounds(15, 275, 100, 40);

    JTextArea txtOutput = new JTextArea("");
    txtOutput.setBounds(15, 325, 350, 100);
    
    checkBox.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        checkBoxSelected = (e.getStateChange() == ItemEvent.SELECTED);
      }
      
    });

    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
  
          String jenisKelamin = "";
          if (radioButton1.isSelected()) {
              jenisKelamin = radioButton1.getText();
          } else if (radioButton2.isSelected()) {
              jenisKelamin = radioButton2.getText();
          }
  
          // Tetap menampilkan output meskipun checkbox tidak dicentang
          String nama = textNama.getText();
          String telepon = textTelepon.getText();  // Mengubah long ke String untuk menghindari error
          boolean isWna = checkBoxSelected;
  
          txtOutput.append("Hello " + nama + "\n");
          txtOutput.append("No Telepon: " + telepon + "\n");
          txtOutput.append("Jenis Kelamin: " + jenisKelamin + "\n");
          txtOutput.append("WNA: " + (isWna ? "Ya" : "Tidak") + "\n\n");
          txtOutput.append("===============================================\n");
  
          // Reset input setelah submit
          textNama.setText("");
          textTelepon.setText("");
      }
  });



       
       

       


     
    this.add(button);
    this.add(textNama);
    this.add(textTelepon);
    this.add(labelRadio);
    this.add(radioButton1);
    this.add(radioButton2);
    this.add(checkBox);
    this.add(labelNama);
    this.add(labelTelepon);
    this.add(txtOutput);

    this.setSize(400, 500);
    this.setLayout(null);
  }

  public static void main(String[] args) {
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        HelloFinal h = new HelloFinal();
        h.setVisible(true);
      }
    });
  }
}
