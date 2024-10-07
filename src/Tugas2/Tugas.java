package Tugas2;

import java.awt.event.*;
import javax.swing.*;

public class Tugas extends JFrame {

    private boolean checkBoxSelected;
    private JList<String> listTabungan;

    public Tugas() {
        this.checkBoxSelected = false;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel labelNama = new JLabel("Nama:");
        labelNama.setBounds(15, 15, 350, 20);

        JTextField textNama = new JTextField("");
        textNama.setBounds(15, 40, 350, 30);

        JLabel labelTelepon = new JLabel("No Telepon:");
        labelTelepon.setBounds(15, 80, 350, 20);

        JTextField textTelepon = new JTextField("");
        textTelepon.setBounds(15, 105, 350, 30);

        JLabel labelRadio = new JLabel("Jenis kelamin:");
        labelRadio.setBounds(15, 145, 350, 20);

        JRadioButton radioButton1 = new JRadioButton("Laki-Laki", true);
        radioButton1.setBounds(15, 170, 100, 30);

        JRadioButton radioButton2 = new JRadioButton("Perempuan");
        radioButton2.setBounds(125, 170, 100, 30);

        ButtonGroup bg = new ButtonGroup();
        bg.add(radioButton1);
        bg.add(radioButton2);

        JCheckBox checkBox = new JCheckBox("Warga Negara Asing (WNA)");
        checkBox.setBounds(15, 200, 350, 30);

        JLabel labelTabungan = new JLabel("Jenis Tabungan:");
        labelTabungan.setBounds(15, 235, 350, 20);

        String[] tabunganOptions = {"Bronze", "Silver", "Gold", "Platinum"};
        listTabungan = new JList<>(tabunganOptions);
        listTabungan.setBounds(15, 260, 350, 80);
        listTabungan.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JLabel labelTransaksi = new JLabel("Frekuensi Transaksi per Bulan:");
        labelTransaksi.setBounds(15, 340, 350, 20);

        JSlider transaksiSlider = new JSlider(JSlider.HORIZONTAL, 1, 100, 1);
        transaksiSlider.setBounds(15, 360, 300, 50);
        transaksiSlider.setMajorTickSpacing(10);
        transaksiSlider.setMinorTickSpacing(1);
        transaksiSlider.setPaintTicks(true);
        transaksiSlider.setPaintLabels(true);

        transaksiSlider.addChangeListener(e -> {
            int frekuensiTransaksi = transaksiSlider.getValue();
        });

        JLabel labelTanggalLahir = new JLabel("Tanggal Lahir:");
        labelTanggalLahir.setBounds(15, 410, 350, 20);

        JSpinner tanggalLahirSpinner = new JSpinner(new SpinnerDateModel());
        tanggalLahirSpinner.setBounds(15, 430, 200, 30);
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(tanggalLahirSpinner, "dd/MM/yyyy");
        tanggalLahirSpinner.setEditor(dateEditor);

        JLabel labelPassword = new JLabel("Password:");
        labelPassword.setBounds(15, 480, 350, 20);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(15, 505, 200, 30);

        JLabel labelConfirmPassword = new JLabel("Confirm Password:");
        labelConfirmPassword.setBounds(15, 545, 350, 20);

        JPasswordField confirmPasswordField = new JPasswordField();
        confirmPasswordField.setBounds(15, 570, 200, 30);

        JButton button = new JButton("Simpan");
        button.setBounds(15, 610, 100, 40);

        JTextArea txtOutput = new JTextArea("");
        txtOutput.setBounds(15, 660, 350, 100);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                char[] password = passwordField.getPassword();
                char[] confirmPassword = confirmPasswordField.getPassword();

                if (!String.valueOf(password).equals(String.valueOf(confirmPassword))) {
                    JOptionPane.showMessageDialog(null, "Password dan Confirm Password tidak cocok!",
                             "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                String jenisKelamin = radioButton1.isSelected() ? "Laki-Laki" : "Perempuan";
                String nama = textNama.getText();
                String telepon = textTelepon.getText();
                boolean isWna = checkBoxSelected;
                String jenisTabungan = listTabungan.getSelectedValue();
                int frekuensiTransaksi = transaksiSlider.getValue();

                txtOutput.append("Hello " + nama + "\n");
                txtOutput.append("No Telepon: " + telepon + "\n");
                txtOutput.append("Jenis Kelamin: " + jenisKelamin + "\n");
                txtOutput.append("WNA: " + (isWna ? "Ya" : "Tidak") + "\n");
                txtOutput.append("Jenis Tabungan: " + jenisTabungan + "\n");
                txtOutput.append("Frekuensi Transaksi: " + frekuensiTransaksi + "\n");
                txtOutput.append("Password cocok\n\n");
                txtOutput.append("===============================================\n");

                textNama.setText("");
                textTelepon.setText("");
                passwordField.setText("");
                confirmPasswordField.setText("");
            }
        });

        checkBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                checkBoxSelected = (e.getStateChange() == ItemEvent.SELECTED);
            }
        });

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Options");

        JMenuItem resetItem = new JMenuItem("Reset");
        resetItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textNama.setText("");
                textTelepon.setText("");
                passwordField.setText("");
                confirmPasswordField.setText("");
                txtOutput.setText("");
            }
        });

        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        menu.add(resetItem);
        menu.add(exitItem);
        menuBar.add(menu);
        setJMenuBar(menuBar);

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
        this.add(listTabungan);
        this.add(labelTabungan);
        this.add(transaksiSlider);
        this.add(labelTransaksi);
        this.add(labelTanggalLahir);
        this.add(tanggalLahirSpinner);
        this.add(labelPassword);
        this.add(passwordField);
        this.add(labelConfirmPassword);
        this.add(confirmPasswordField);

        this.setSize(400, 850);
        this.setLayout(null);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Tugas t = new Tugas();
                t.setVisible(true);
            }
        });
    }
}
