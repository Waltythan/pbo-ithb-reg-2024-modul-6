package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Properties;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import controller.PendudukController;
import model.KTP;

public class PerekamanKTP {
    private JFrame frame;
    private File photoFile;
    private File signatureFile;

    public PerekamanKTP() {
        inputPerekaman();
    }

    public void inputPerekaman() {
        frame = new JFrame();
        frame.setBounds(50, 50, 800, 1000);
        frame.setTitle("Perekaman KTP");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.GRAY);
        frame.setLayout(null);

        JLabel labelTitle = new JLabel("FORM INPUT KTP");
        labelTitle.setBounds(145, 10, 145, 40);
        labelTitle.setBackground(Color.LIGHT_GRAY);
        labelTitle.setOpaque(true);
        frame.add(labelTitle);

        // NIK
        JLabel labelNIK = new JLabel("NIK : ");
        labelNIK.setBounds(40, 60, 60, 40);
        frame.add(labelNIK);

        JTextField fieldNIK = new JTextField();
        fieldNIK.setBounds(150, 60, 130, 30);
        frame.add(fieldNIK);

        // Nama
        JLabel labelNama = new JLabel("Nama : ");
        labelNama.setBounds(40, 100, 60, 40);
        frame.add(labelNama);

        JTextField fieldNama = new JTextField();
        fieldNama.setBounds(150, 100, 130, 30);
        frame.add(fieldNama);

        // Tempat lahir
        JLabel labelTempatLahir = new JLabel("Tempat Lahir : ");
        labelTempatLahir.setBounds(40, 140, 90, 40);
        frame.add(labelTempatLahir);

        JTextField fieldTempatLahir = new JTextField();
        fieldTempatLahir.setBounds(150, 140, 130, 30);
        frame.add(fieldTempatLahir);

        // Tanggal lahir
        JLabel tglLahirLabel = new JLabel("Tanggal Lahir : ");
        tglLahirLabel.setBounds(40, 180, 200, 50);
        frame.add(tglLahirLabel);

        UtilDateModel tglLahir = new UtilDateModel();
        Properties tglLahirProperties = new Properties();
        JDatePanelImpl tglLahirPanel = new JDatePanelImpl(tglLahir, tglLahirProperties);
        JDatePickerImpl tglLahirPicker = new JDatePickerImpl(tglLahirPanel, new DateLabelFormatter());
        tglLahirPicker.setBounds(150, 180, 150, 30);
        frame.add(tglLahirPicker);

        // Golongan Darah
        JLabel LabelGolDarah = new JLabel("Golongan Darah : ");
        LabelGolDarah.setBounds(40, 220, 200, 50);
        frame.add(LabelGolDarah);

        JRadioButton radioA = new JRadioButton();
        radioA.setText("A");
        radioA.setBounds(150, 220, 40, 40);

        JRadioButton radioB = new JRadioButton();
        radioB.setText("B");
        radioB.setBounds(190, 220, 40, 40);

        JRadioButton radioO = new JRadioButton();
        radioO.setText("O");
        radioO.setBounds(230, 220, 40, 40);

        JRadioButton radioAB = new JRadioButton();
        radioAB.setText("AB");
        radioAB.setBounds(270, 220, 45, 40);

        ButtonGroup bloodGroup = new ButtonGroup();
        bloodGroup.add(radioA);
        bloodGroup.add(radioB);
        bloodGroup.add(radioO);
        bloodGroup.add(radioAB);

        radioA.setActionCommand("A");
        radioB.setActionCommand("B");
        radioO.setActionCommand("O");
        radioAB.setActionCommand("AB");

        frame.add(radioA);
        frame.add(radioB);
        frame.add(radioO);
        frame.add(radioAB);

        // Alamat
        JLabel labelAlamat = new JLabel("Alamat : ");
        labelAlamat.setBounds(40, 280, 90, 40);
        frame.add(labelAlamat);

        JTextField fieldAlamat = new JTextField();
        fieldAlamat.setBounds(150, 280, 130, 30);
        frame.add(fieldAlamat);

        // RT/RW
        JLabel labelRTRW = new JLabel("RT/RW : ");
        labelRTRW.setBounds(40, 320, 90, 40);
        frame.add(labelRTRW);

        JTextField fieldRTRW = new JTextField();
        fieldRTRW.setBounds(150, 320, 130, 30);
        frame.add(fieldRTRW);

        // Kel/Desa
        JLabel labelKelDesa = new JLabel("Kel/Desa : ");
        labelKelDesa.setBounds(40, 360, 90, 40);
        frame.add(labelKelDesa);

        JTextField fieldKelDesa = new JTextField();
        fieldKelDesa.setBounds(150, 360, 130, 30);
        frame.add(fieldKelDesa);

        JLabel labelKecamatan = new JLabel("Kecamatan : ");
        labelKecamatan.setBounds(40, 400, 90, 40);
        frame.add(labelKecamatan);

        JTextField fieldKecamatan = new JTextField();
        fieldKecamatan.setBounds(150, 400, 130, 30);
        frame.add(fieldKecamatan);

        // AGAMA
        JLabel labelAgama = new JLabel("Agama : ");
        labelAgama.setBounds(40, 440, 90, 40);
        frame.add(labelAgama);

        String listAgama[] = { "KRISTEN", "KATHOLIK", "ISLAM", "HINDU", "KONGHUCU", "BUDDHA" };
        JComboBox<String> comboAgama = new JComboBox<>();
        comboAgama.addItem("KRISTEN");
        comboAgama.addItem("KATHOLIK");
        comboAgama.addItem("ISLAM");
        comboAgama.addItem("HINDU");
        comboAgama.addItem("BUDDHA");
        comboAgama.addItem("KONGHUCU");
        comboAgama.setBounds(150, 440, 130, 30);

        frame.add(comboAgama);

        // status perkawinan
        JLabel labelPerkawinan = new JLabel("Status Perkawinan : ");
        labelPerkawinan.setBounds(40, 480, 120, 40);
        frame.add(labelPerkawinan);

        JComboBox<String> comboPerkawinan = new JComboBox<>();
        comboPerkawinan.addItem("BELUM MENIKAH");
        comboPerkawinan.addItem("MENIKAH");
        comboPerkawinan.addItem("JANDA");
        comboPerkawinan.addItem("DUDA");
        comboPerkawinan.setBounds(170, 480, 130, 30);
        frame.add(comboPerkawinan);

        // Pekerjaan
        JLabel labelPekerjaan = new JLabel("Pekerjaan : ");
        labelPekerjaan.setBounds(40, 520, 120, 40);
        frame.add(labelPekerjaan);

        JCheckBox checkKaryawanStasta = new JCheckBox();
        checkKaryawanStasta.setText("Karyawan Swasta");
        checkKaryawanStasta.setBounds(150, 520, 150, 40);

        JCheckBox checkPNS = new JCheckBox();
        checkPNS.setText("PNS");
        checkPNS.setBounds(300, 520, 150, 40);

        JCheckBox checkAkademisi = new JCheckBox();
        checkAkademisi.setText("Akademisi");
        checkAkademisi.setBounds(150, 550, 150, 40);

        JCheckBox checkWiraswasta = new JCheckBox();
        checkWiraswasta.setText("Wiraswasta");
        checkWiraswasta.setBounds(300, 550, 150, 40);

        JCheckBox checkPengangguran = new JCheckBox();
        checkPengangguran.setText("Pengangguran");
        checkPengangguran.setBounds(150, 590, 150, 40);

        frame.add(checkKaryawanStasta);
        frame.add(checkPNS);
        frame.add(checkAkademisi);
        frame.add(checkWiraswasta);
        frame.add(checkPengangguran);

        checkPengangguran.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (checkPengangguran.isSelected()) {

                    checkKaryawanStasta.setEnabled(false);
                    checkPNS.setEnabled(false);
                    checkAkademisi.setEnabled(false);
                    checkWiraswasta.setEnabled(false);

                    checkKaryawanStasta.setSelected(false);
                    checkPNS.setSelected(false);
                    checkAkademisi.setSelected(false);
                    checkWiraswasta.setSelected(false);

                } else {

                    checkKaryawanStasta.setEnabled(true);
                    checkPNS.setEnabled(true);
                    checkWiraswasta.setEnabled(true);
                    checkAkademisi.setEnabled(true);

                }
            }
        });

        // Kewarganegaraan
        JLabel labelKewarganegaraan = new JLabel("Kewarganegaraan : ");
        labelKewarganegaraan.setBounds(40, 640, 130, 30);
        frame.add(labelKewarganegaraan);

        JRadioButton radioWNI = new JRadioButton("WNI");
        radioWNI.setBounds(150, 640, 50, 40);

        JRadioButton radioWNA = new JRadioButton("WNA");
        radioWNA.setBounds(200, 640, 55, 40);

        ButtonGroup KewarganegaraanGroup = new ButtonGroup();

        radioWNI.setActionCommand("WNI");
        radioWNA.setActionCommand("WNA");

        KewarganegaraanGroup.add(radioWNA);
        KewarganegaraanGroup.add(radioWNI);

        frame.add(radioWNA);
        frame.add(radioWNI);

        JLabel countryLabel = new JLabel("ASAL NEGARA :");
        countryLabel.setBounds(270, 640, 300, 50);
        countryLabel.setVisible(false); // SET VISIBLE FALSE -> DEFAULT
        frame.add(countryLabel);

        JTextField citizenshipField = new JTextField();
        citizenshipField.setBounds(360, 650, 150, 30);
        citizenshipField.setVisible(false); // SET VISIBLE FALSE -> DEFAULT
        frame.add(citizenshipField);

        radioWNA.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                countryLabel.setVisible(true);
                citizenshipField.setVisible(true);

            }

        });

        radioWNI.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                countryLabel.setVisible(false);
                citizenshipField.setVisible(false);
                citizenshipField.setText("");

            }

        });
        // Foto

        JLabel labelfoto = new JLabel("FOTO");
        labelfoto.setBounds(40, 700, 55, 40);
        frame.add(labelfoto);

        JButton buttonFoto = new JButton("Upload Photo");
        buttonFoto.setBounds(150, 700, 150, 40);
        frame.add(buttonFoto);

        buttonFoto.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

                JFileChooser fileChooser = new JFileChooser();

                int returnValue = fileChooser.showOpenDialog(null);

                if (returnValue == JFileChooser.APPROVE_OPTION) {

                    photoFile = fileChooser.getSelectedFile();

                }

            }

        });

        // jenis kelamin
        JLabel labelKelamin = new JLabel("Jenis Kelamin : ");
        labelKelamin.setBounds(40, 750, 190, 40);
        frame.add(labelKelamin);

        JRadioButton radioPria = new JRadioButton("Pria");
        radioPria.setBounds(150, 750, 60, 30);
        JRadioButton radioWanita = new JRadioButton("Wanita");
        radioWanita.setBounds(210, 750, 90, 30);

        ButtonGroup groupKelamin = new ButtonGroup();
        groupKelamin.add(radioWanita);
        groupKelamin.add(radioPria);

        radioPria.setActionCommand("Pria");
        radioWanita.setActionCommand("Wanita");

        frame.add(radioPria);
        frame.add(radioWanita);

        JLabel labelTTD = new JLabel("Tanda Tangan : ");
        labelTTD.setBounds(40, 790, 120, 40);
        frame.add(labelTTD);

        JButton buttonTTD = new JButton("Upload Tanda Tangan");
        buttonTTD.setBounds(150, 790, 170, 40);
        frame.add(buttonTTD);

        buttonTTD.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

                JFileChooser fileChooser = new JFileChooser();

                int returnValue = fileChooser.showOpenDialog(null);

                if (returnValue == JFileChooser.APPROVE_OPTION) {

                    signatureFile = fileChooser.getSelectedFile();

                }

            }

        });

        JLabel labelBerlaku = new JLabel("Berlaku hingga : ");
        labelBerlaku.setBounds(40, 830, 100, 40);
        frame.add(labelBerlaku);

        JTextField fieldBerlaku = new JTextField();
        fieldBerlaku.setBounds(150, 840, 150, 30);
        frame.add(fieldBerlaku);

        JLabel labelKotaPembuatan = new JLabel("Kota Pembuatan : ");
        labelKotaPembuatan.setBounds(40, 880, 130, 40);
        frame.add(labelKotaPembuatan);

        JTextField fieldKotaPembuatan = new JTextField();
        fieldKotaPembuatan.setBounds(150, 880, 150, 30);
        frame.add(fieldKotaPembuatan);

        JLabel labelTglPembuatan = new JLabel("Tanggal Pembuatan : ");
        labelTglPembuatan.setBounds(40, 920, 130, 40);
        frame.add(labelTglPembuatan);

        UtilDateModel tglPembuatanmodel = new UtilDateModel();
        Properties tglPembuatanProperties = new Properties();
        JDatePanelImpl tglPembuatanPanel = new JDatePanelImpl(tglPembuatanmodel, tglPembuatanProperties);
        JDatePickerImpl tglPembuatanPicker = new JDatePickerImpl(tglPembuatanPanel, new DateLabelFormatter());
        tglPembuatanPicker.setBounds(170, 920, 150, 30);
        frame.add(tglPembuatanPicker);

        JButton submitButton = new JButton("SUBMIT");
        submitButton.setBounds(350, 920, 150, 30);
        frame.add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nik = fieldNIK.getText();
                String nama = fieldNama.getText();
                String tempatLahir = fieldTempatLahir.getText();

                Date tanggalLahir = (Date) tglLahirPicker.getModel().getValue();
                LocalDate tanggalLahirlocalDate = tanggalLahir.toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDate();
                String tanggalLahirlocalDateFormatted = tanggalLahirlocalDate
                        .format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

                String jenisKelamin = radioPria.isSelected() ? "PRIA" : "WANITA";

                String golDarah = bloodGroup.getSelection().getActionCommand();
                String alamat = fieldAlamat.getText();
                String rtRw = fieldRTRW.getText();
                String kelDesa = fieldKelDesa.getText();
                String kecamatan = fieldKecamatan.getText();
                String agama = String.valueOf(comboAgama.getSelectedItem());
                String statusPerkawinan = String.valueOf(comboPerkawinan.getSelectedItem());
                String pekerjaan = PendudukController.getSelectedJobs(checkKaryawanStasta, checkPNS, checkWiraswasta,
                        checkAkademisi, checkPengangguran);
                String wargaNegaraAsal = radioWNA.isSelected() ? citizenshipField.getText() : null;
                String kewarganegaraan = PendudukController.getCitizenship(KewarganegaraanGroup.getSelection().getActionCommand(),
                        wargaNegaraAsal);
                String berlakuHingga = fieldBerlaku.getText();
                String kotaPembuatan = fieldKotaPembuatan.getText();

                Date tanggalPembuatan = (Date) tglPembuatanPicker.getModel().getValue();
                LocalDate tanggalPembuatanlocalDate = tanggalPembuatan.toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDate();
                String tanggalPembuatanlocalDateFormatted = tanggalPembuatanlocalDate
                        .format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

                KTP ktp = PendudukController.createKTP(nik, nama, tempatLahir, tanggalLahirlocalDateFormatted, jenisKelamin,
                        golDarah, alamat, rtRw, kelDesa, kecamatan, agama, statusPerkawinan,
                        pekerjaan, kewarganegaraan, wargaNegaraAsal, photoFile, signatureFile, berlakuHingga,
                        kotaPembuatan, tanggalPembuatanlocalDateFormatted);

                frame.dispose();

                JOptionPane.showMessageDialog(frame, "Berhasil edit data!", "Notifikasi",
                        JOptionPane.INFORMATION_MESSAGE);

                new PrintKTP(ktp);
            }
        });
        frame.setVisible(true);

    }
}