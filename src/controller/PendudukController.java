package controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import org.jdatepicker.impl.JDatePickerImpl;

import model.KTP;

public class PendudukController {
    public static boolean checkInput(
            JTextField nikField, JTextField namaField, JTextField tempatLahirField, JDatePickerImpl datePicker,
            ButtonGroup genderGroup, ButtonGroup bloodGroup, JTextField alamatField, JTextField rtField,
            JTextField rwField, JTextField kelurahanField, JTextField kecamatanField, JComboBox<String> agamaComboBox,
            JComboBox<String> perkawinanBox, JCheckBox karyawanSwastaCheck, JCheckBox pnsCheck,
            JCheckBox wiraswastaCheck, JCheckBox akademisiCheck, JCheckBox pengangguranCheck,
            ButtonGroup citizenshipGroup, JTextField citizenshipField, File photoFile, File signatureFile,
            JTextField tglBerlakuField, JTextField kotaPembuatanField, JDatePickerImpl tglPembuatanPicker) {

        if (nikField.getText().trim().isEmpty()
                || namaField.getText().trim().isEmpty()
                || tempatLahirField.getText().trim().isEmpty()
                || datePicker.getModel().getValue() == null
                || genderGroup.getSelection() == null
                || bloodGroup.getSelection() == null
                || alamatField.getText().trim().isEmpty()
                || rtField.getText().trim().isEmpty()
                || rwField.getText().trim().isEmpty()
                || kelurahanField.getText().trim().isEmpty()
                || kecamatanField.getText().trim().isEmpty()
                || agamaComboBox.getSelectedIndex() == -1
                || perkawinanBox.getSelectedIndex() == -1
                || (!karyawanSwastaCheck.isSelected()
                        && !pnsCheck.isSelected()
                        && !wiraswastaCheck.isSelected()
                        && !akademisiCheck.isSelected()
                        && !pengangguranCheck.isSelected())
                || citizenshipGroup.getSelection() == null
                || (citizenshipGroup.getSelection().getActionCommand().equals("WNA")
                        && citizenshipField.getText().trim().isEmpty())
                || photoFile == null
                || signatureFile == null
                || tglBerlakuField.getText().trim().isEmpty()
                || kotaPembuatanField.getText().trim().isEmpty()
                || tglPembuatanPicker.getModel().getValue() == null) {

            return false;

        } else {

            return true;

        }
    }

    public static String getSelectedJobs(JCheckBox karyawanSwastaCheck, JCheckBox pnsCheck, JCheckBox wiraswastaCheck,
            JCheckBox akademisiCheck, JCheckBox pengangguranCheck) {

        List<String> listJob = new ArrayList<>();
        String job = "";

        if (pengangguranCheck.isSelected()) {
            job = "PENGANGGURAN";
        } else {
            if (karyawanSwastaCheck.isSelected()) {
                listJob.add("KARYAWAN SWASTA");
            }
            if (pnsCheck.isSelected()) {
                listJob.add("PNS");
            }
            if (wiraswastaCheck.isSelected()) {
                listJob.add("WIRASWASTA");
            }
            if (akademisiCheck.isSelected()) {
                listJob.add("AKADEMISI");
            }
        }

        if (listJob.size() > 1) {
            for (int i = 0; i < listJob.size() - 1; i++) {
                job += listJob.get(i) + ", ";
            }
        }
        job += listJob.get(listJob.size() - 1);

        return job;
    }

    public static String getCitizenship(String citizen, String country) {
        String citizenship = "";
        if (citizen.equalsIgnoreCase("WNI")) {
            citizenship = "WNI";
        } else {
            citizenship = "WNA(" + country + ")";
        }

        return citizenship;
    }

    public static KTP createKTP(String nik, String nama, String tempatLahir, String tanggalLahir,
            String jenisKelamin, String golDarah, String alamat, String rtRW, String kelDesa,
            String kecamatan,
            String agama, String statusPerkawinan, String pekerjaan, String kewarganegaraan,
            String wargaNegaraAsal, File photoFile, File signatureFile, String berlakuHingga, String kotaPembuatan,
            String tanggalPembuatan) {

        KTP ktp = new KTP(nik, nama, tempatLahir, tanggalLahir, jenisKelamin, golDarah, alamat, rtRW, kelDesa,
                kecamatan,
                agama, statusPerkawinan, pekerjaan, kewarganegaraan, wargaNegaraAsal, photoFile,
                signatureFile, berlakuHingga, kotaPembuatan, tanggalPembuatan);

        return ktp;
    }
}