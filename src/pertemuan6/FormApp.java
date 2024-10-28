package pertemuan6;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Dictionary;
import java.util.Hashtable;

public class FormApp extends JFrame {
    // Deklarasi komponen input dan tabel
    private JTextField nameField;
    private JTextArea descArea;
    private JRadioButton maleButton, femaleButton;
    private JCheckBox hobbySports, hobbyReading, hobbyWriting;
    private JComboBox<String> provinceBox;
    private JList<String> languageList;
    private JSlider ageSlider;
    private JSpinner experienceSpinner;
    private JTable dataTable;
    private DefaultTableModel tableModel;
    private ButtonGroup genderGroup;
    private JPanel mainPanel;
    private JPanel formPanel;
    private JPanel tablePanel;

    public FormApp() {
        setTitle("Formulir Data Pengguna"); // Judul jendela
        setSize(800, 600); // Ukuran jendela
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Menutup aplikasi saat jendela ditutup

        // Setup Menu Bar
        JMenuBar menuBar = new JMenuBar(); // Membuat menu bar

        // Membuat menu "File" dan "View"
        JMenu fileMenu = new JMenu("File");
        JMenu viewMenu = new JMenu("View");

        // Menambahkan item "Reset Form" dan "Exit" ke dalam menu "File"
        JMenuItem resetFormItem = new JMenuItem("Reset Form");
        JMenuItem exitItem = new JMenuItem("Exit");
        fileMenu.add(resetFormItem); // Tambahkan item "Reset Form" ke menu "File"
        fileMenu.addSeparator(); // Menambahkan garis pemisah
        fileMenu.add(exitItem); // Tambahkan item "Exit" ke menu "File"

        // Menambahkan item "Form View" dan "Table View" ke dalam menu "View"
        JMenuItem formViewItem = new JMenuItem("Form View");
        JMenuItem tableViewItem = new JMenuItem("Table View");
        viewMenu.add(formViewItem);
        viewMenu.add(tableViewItem);

        // Menambahkan menu "File" dan "View" ke menu bar
        menuBar.add(fileMenu);
        menuBar.add(viewMenu);
        setJMenuBar(menuBar); // Mengatur menu bar ke jendela

        // Main Panel dengan CardLayout
        mainPanel = new JPanel(new CardLayout());
        add(mainPanel); // Menambahkan mainPanel ke jendela utama

        // Form Panel untuk komponen input data
        formPanel = new JPanel(new GridBagLayout()); // Mengatur tata letak formPanel dengan GridBagLayout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL; // Mengatur agar komponen melebar horizontal
        gbc.insets = new Insets(5, 5, 5, 5); // Menambahkan margin antara komponen

        // Inisialisasi komponen input
        nameField = new JTextField(20); // Field untuk input nama
        descArea = new JTextArea(3, 20); // Area teks untuk deskripsi diri

        // Radio button untuk memilih jenis kelamin
        maleButton = new JRadioButton("Pria");
        femaleButton = new JRadioButton("Wanita");
        genderGroup = new ButtonGroup(); // Mengelompokkan radio button
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);

        // Checkbox untuk memilih hobi
        hobbySports = new JCheckBox("Olahraga");
        hobbyReading = new JCheckBox("Membaca");
        hobbyWriting = new JCheckBox("Menulis");

        // Dropdown untuk memilih provinsi
        provinceBox = new JComboBox<>(new String[]{"Jawa Barat", "Jawa Tengah", "Jawa Timur"});

        // Daftar pilihan bahasa
        languageList = new JList<>(new String[]{"Indonesia", "Inggris", "Jepang", "Mandarin"});

        // Slider untuk memilih usia dengan rentang 10 - 60 tahun
        ageSlider = new JSlider(10, 60);
        ageSlider.setMajorTickSpacing(10); // Interval tanda utama setiap 10 tahun
        ageSlider.setMinorTickSpacing(1); // Interval tanda kecil setiap 1 tahun
        ageSlider.setPaintTicks(true); // Menampilkan tanda pada slider
        ageSlider.setPaintLabels(true); // Menampilkan label pada tanda

        // Label tambahan untuk slider usia
        Dictionary<Integer, JLabel> labelTable = new Hashtable<>();
        labelTable.put(10, new JLabel("10"));
        labelTable.put(20, new JLabel("20"));
        labelTable.put(30, new JLabel("30"));
        labelTable.put(40, new JLabel("40"));
        labelTable.put(50, new JLabel("50"));
        labelTable.put(60, new JLabel("60"));
        ageSlider.setLabelTable(labelTable); // Mengatur label ke slider

        // Spinner untuk memilih pengalaman kerja (tahun)
        experienceSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 40, 1));

        // Menambahkan komponen ke dalam formPanel
        gbc.gridx = 0; gbc.gridy = 0;
        formPanel.add(new JLabel("Nama:"), gbc); // Label Nama
        gbc.gridx = 1;
        formPanel.add(nameField, gbc); // Field Nama

        gbc.gridx = 0; gbc.gridy = 1;
        formPanel.add(new JLabel("Deskripsi Diri:"), gbc); // Label Deskripsi Diri
        gbc.gridx = 1;
        formPanel.add(new JScrollPane(descArea), gbc); // Area Teks Deskripsi Diri

        gbc.gridx = 0; gbc.gridy = 2;
        formPanel.add(new JLabel("Jenis Kelamin:"), gbc); // Label Jenis Kelamin
        gbc.gridx = 1;
        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT)); // Panel untuk radio button jenis kelamin
        genderPanel.add(maleButton);
        genderPanel.add(femaleButton);
        formPanel.add(genderPanel, gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        formPanel.add(new JLabel("Hobi:"), gbc); // Label Hobi
        gbc.gridx = 1;
        JPanel hobbyPanel = new JPanel(new FlowLayout(FlowLayout.LEFT)); // Panel untuk checkbox hobi
        hobbyPanel.add(hobbySports);
        hobbyPanel.add(hobbyReading);
        hobbyPanel.add(hobbyWriting);
        formPanel.add(hobbyPanel, gbc);

        gbc.gridx = 0; gbc.gridy = 4;
        formPanel.add(new JLabel("Provinsi:"), gbc); // Label Provinsi
        gbc.gridx = 1;
        formPanel.add(provinceBox, gbc); // Dropdown Provinsi

        gbc.gridx = 0; gbc.gridy = 5;
        formPanel.add(new JLabel("Bahasa:"), gbc); // Label Bahasa
        gbc.gridx = 1;
        formPanel.add(new JScrollPane(languageList), gbc); // List Bahasa

        gbc.gridx = 0; gbc.gridy = 6;
        formPanel.add(new JLabel("Usia:"), gbc); // Label Usia
        gbc.gridx = 1;
        formPanel.add(ageSlider, gbc); // Slider Usia

        gbc.gridx = 0; gbc.gridy = 7;
        formPanel.add(new JLabel("Pengalaman Kerja (tahun):"), gbc); // Label Pengalaman
        gbc.gridx = 1;
        formPanel.add(experienceSpinner, gbc); // Spinner Pengalaman

        gbc.gridx = 1; gbc.gridy = 8;
        JButton saveButton = new JButton("Simpan"); // Tombol Simpan
        formPanel.add(saveButton, gbc);

        mainPanel.add(new JScrollPane(formPanel), "Form"); // Menambahkan formPanel ke mainPanel dengan CardLayout

        // Table Panel untuk menampilkan data dalam bentuk tabel
        tableModel = new DefaultTableModel(); // Model tabel
        tableModel.setColumnIdentifiers(new String[]{"Nama", "Deskripsi", "Jenis Kelamin", "Hobi", "Provinsi", "Bahasa", "Usia", "Pengalaman"});
        dataTable = new JTable(tableModel); // Tabel data
        tablePanel = new JPanel(new BorderLayout());
        tablePanel.add(new JScrollPane(dataTable), BorderLayout.CENTER); // Tambahkan tabel ke dalam JScrollPane

        mainPanel.add(tablePanel, "Table"); // Menambahkan tablePanel ke mainPanel dengan CardLayout

        // Event Listeners
        exitItem.addActionListener(e -> System.exit(0)); // Listener untuk item "Exit" yang menutup aplikasi

        saveButton.addActionListener(new ActionListener() { // Listener untuk tombol "Simpan"
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mengambil data dari input dan menambahkannya ke tabel
                String name = nameField.getText();
                String desc = descArea.getText();
                String gender = maleButton.isSelected() ? "Pria" : (femaleButton.isSelected() ? "Wanita" : "");

                StringBuilder hobbies = new StringBuilder();
                if (hobbySports.isSelected()) hobbies.append("Olahraga ");
                if (hobbyReading.isSelected()) hobbies.append("Membaca ");
                if (hobbyWriting.isSelected()) hobbies.append("Menulis ");

                String province = (String) provinceBox.getSelectedItem();
                String languages = String.join(", ", languageList.getSelectedValuesList());
                int age = ageSlider.getValue();
                int experience = (int) experienceSpinner.getValue();

                tableModel.addRow(new Object[]{name, desc, gender, hobbies.toString().trim(), province, languages, age, experience});

                // Reset form setelah data disimpan
                nameField.setText("");
                descArea.setText("");
                genderGroup.clearSelection();
                hobbySports.setSelected(false);
                hobbyReading.setSelected(false);
                hobbyWriting.setSelected(false);
                provinceBox.setSelectedIndex(0);
                languageList.clearSelection();
                ageSlider.setValue(10);
                experienceSpinner.setValue(0);
            }
        });

        resetFormItem.addActionListener(e -> { // Listener untuk item "Reset Form" yang mereset semua input
            nameField.setText("");
            descArea.setText("");
            genderGroup.clearSelection();
            hobbySports.setSelected(false);
            hobbyReading.setSelected(false);
            hobbyWriting.setSelected(false);
            provinceBox.setSelectedIndex(0);
            languageList.clearSelection();
            ageSlider.setValue(10);
            experienceSpinner.setValue(0);
        });

        formViewItem.addActionListener(e -> { // Listener untuk item "Form View" yang menampilkan formPanel
            CardLayout cl = (CardLayout) (mainPanel.getLayout());
            cl.show(mainPanel, "Form");
        });

        tableViewItem.addActionListener(e -> { // Listener untuk item "Table View" yang menampilkan tablePanel
            CardLayout cl = (CardLayout) (mainPanel.getLayout());
            cl.show(mainPanel, "Table");
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FormApp app = new FormApp();
            app.setVisible(true); // Menampilkan aplikasi
        });
    }
}
