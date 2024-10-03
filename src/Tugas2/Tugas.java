package Tugas2;

import java.awt.event.*;
import javax.swing.*;

public class Tugas extends JFrame {

    private boolean checkBoxSelected;
    private JList<String> listTabungan;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private JSpinner transaksiSpinner;
    private JSpinner tanggalLahirSpinner;

    public Tugas() {
        this.checkBoxSelected = false;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Label Nama
        JLabel labelNama = new JLabel("Nama:");
        labelNama.setBounds(15, 40, 350, 10);

        // Text field untuk nama
        JTextField textNama = new JTextField("");
        textNama.setBounds(15, 60, 350, 30);

        // Label Telepon
        JLabel labelTelepon = new JLabel("No Telepon:");
        labelTelepon.setBounds(15, 100, 350, 10);

        // Text field untuk nomor telepon
        JTextField textTelepon = new JTextField("");
        textTelepon.setBounds(15, 120, 350, 30);

        // Label Jenis Kelamin
        JLabel labelRadio = new JLabel("Jenis kelamin");
        labelRadio.setBounds(15, 160, 350, 10);

        // Radio button untuk jenis kelamin
        JRadioButton radioButton1 = new JRadioButton("Laki-Laki", true);
        radioButton1.setBounds(15, 175, 350, 30);

        JRadioButton radioButton2 = new JRadioButton("Perempuan");
        radioButton2.setBounds(15, 205, 350, 30);

        ButtonGroup bg = new ButtonGroup();
        bg.add(radioButton1);
        bg.add(radioButton2);

        // Checkbox WNA
        JCheckBox checkBox = new JCheckBox("Warga Negara Asing (WNA)");
        checkBox.setBounds(15, 235, 350, 30);

        // JList untuk memilih jenis tabungan
        JLabel labelTabungan = new JLabel("Jenis Tabungan:");
        labelTabungan.setBounds(15, 270, 350, 10);

        String[] tabunganOptions = {"Tabungan Pendidikan", "Tabungan Haji", "Tabungan Masa Depan", "Tabungan Berjangka"};
        listTabungan = new JList<>(tabunganOptions);
        listTabungan.setBounds(15, 290, 350, 60);
        listTabungan.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // JSpinner untuk jumlah frekuensi transaksi
        JLabel labelTransaksi = new JLabel("Frekuensi Transaksi per Bulan:");
        labelTransaksi.setBounds(15, 360, 350, 10);

        transaksiSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));
        transaksiSpinner.setBounds(15, 380, 100, 30);

        // JSpinner untuk tanggal lahir
        JLabel labelTanggalLahir = new JLabel("Tanggal Lahir:");
        labelTanggalLahir.setBounds(15, 420, 350, 10);

        tanggalLahirSpinner = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(tanggalLahirSpinner, "dd/MM/yyyy");
        tanggalLahirSpinner.setEditor(dateEditor);
        tanggalLahirSpinner.setBounds(15, 440, 200, 30);

        // Password fields
        JLabel labelPassword = new JLabel("Password:");
        labelPassword.setBounds(15, 480, 350, 10);
        
        passwordField = new JPasswordField();
        passwordField.setBounds(15, 500, 200, 30);

        JLabel labelConfirmPassword = new JLabel("Confirm Password:");
        labelConfirmPassword.setBounds(15, 540, 350, 10);
        
        confirmPasswordField = new JPasswordField();
        confirmPasswordField.setBounds(15, 560, 200, 30);

        // Button Simpan
        JButton button = new JButton("Simpan");
        button.setBounds(15, 600, 100, 40);

        // TextArea untuk output
        JTextArea txtOutput = new JTextArea("");
        txtOutput.setBounds(15, 650, 350, 100);

        // Action listener untuk button
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String jenisKelamin = radioButton1.isSelected() ? "Laki-Laki" : "Perempuan";
                String nama = textNama.getText();
                String telepon = textTelepon.getText();
                boolean isWna = checkBoxSelected;
                String jenisTabungan = listTabungan.getSelectedValue();
                int frekuensiTransaksi = (int) transaksiSpinner.getValue();

                // Password validation
                char[] password = passwordField.getPassword();
                char[] confirmPassword = confirmPasswordField.getPassword();
                String passwordMessage = (String.valueOf(password).equals(String.valueOf(confirmPassword))) 
                    ? "Password cocok" : "Password tidak cocok";

                txtOutput.append("Hello " + nama + "\n");
                txtOutput.append("No Telepon: " + telepon + "\n");
                txtOutput.append("Jenis Kelamin: " + jenisKelamin + "\n");
                txtOutput.append("WNA: " + (isWna ? "Ya" : "Tidak") + "\n");
                txtOutput.append("Jenis Tabungan: " + jenisTabungan + "\n");
                txtOutput.append("Frekuensi Transaksi: " + frekuensiTransaksi + "\n");
                txtOutput.append(passwordMessage + "\n\n");
                txtOutput.append("===============================================\n");

                // Reset input
                textNama.setText("");
                textTelepon.setText("");
                passwordField.setText("");
                confirmPasswordField.setText("");
            }
        });

        // Checkbox listener
        checkBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                checkBoxSelected = (e.getStateChange() == ItemEvent.SELECTED);
            }
        });

        // Menu Bar
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Options");
        
        JMenuItem resetItem = new JMenuItem("Reset");
        resetItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Reset all fields
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

        // Adding components to the frame
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
        this.add(transaksiSpinner);
        this.add(labelTransaksi);
        this.add(labelTanggalLahir);
        this.add(tanggalLahirSpinner);
        this.add(labelPassword);
        this.add(passwordField);
        this.add(labelConfirmPassword);
        this.add(confirmPasswordField);

        // Frame size and layout
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
