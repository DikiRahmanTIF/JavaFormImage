package com.DRTIF.FormImage;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class FormWithImage {
    public  String imageFileName;
    private JPanel rootPanel;
    private JTextField NomorKartu;
    private JComboBox JenisATM;
    private JComboBox Bank;
    private JTextField NamaPemilik;
    private JButton SaveButton;
    private JTextArea textArea1;
    private JButton browseFileButton;
    private JPanel ImagePreview;
    private JLabel previewimage;

    public FormWithImage() {
        SaveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String noKartu=NomorKartu.getText();

                String jenisATM=(String)JenisATM.getSelectedItem();

                String bank=(String)Bank.getSelectedItem();

                String namaPemilik=NamaPemilik.getText();

                panel user=new panel();
                user.setNomorKartu(noKartu);
                user.setJenisATM(jenisATM);
                user.setBank(bank);
                user.setNamaPemilik(namaPemilik);

                textArea1.setText("");

                String result = String.format("\nNomor Kartu : %s\nJenis ATM : %s\nNama Bank : %s\nNama Pemilik : %s\nFile Gambar : %s",noKartu, jenisATM, bank, namaPemilik, imageFileName);
                textArea1.append(result);
                try {
                    FileWriter fw = new FileWriter("src/Data.txt",true);
                    fw.write(result);
                    fw.close();
                }catch(IOException eya){
                    throw new RuntimeException(eya);
                }
                JOptionPane.showMessageDialog(null, "Data Tersimpan!");
            }
        });
        browseFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
                jfc.setDialogTitle("Select an image");
                jfc.setAcceptAllFileFilterUsed(false);
                FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG and JPEG images", "png", "jpeg", "jpg");
                jfc.addChoosableFileFilter(filter);

                int choosenAct = jfc.showSaveDialog(null);
                if (choosenAct == JFileChooser.APPROVE_OPTION) {
                    imageFileName = jfc.getSelectedFile().getName();

                    // Mendisplay sebuah Image
                    previewimage.setBounds(6, 30, 400, 400);
                    previewimage.setIcon(new ImageIcon(jfc.getSelectedFile().getAbsolutePath()));
                    previewimage.setText("");

                    // Menyimpan Sebuah Image
                    String pathsrc = jfc.getSelectedFile().getAbsolutePath();
                    String destsrc = System.getProperty("user.dir") + "/src/ImageDbs/" + jfc.getSelectedFile().getName();

                    File src = new File(pathsrc);
                    File dest = new File(destsrc);
                    try {
                        Files.copy(src.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    } catch (IOException eya) {
                        throw new RuntimeException(eya);
                    }
                }
            }
        });
    }
    public JPanel getRootPanel() {
        return rootPanel;
    }
}
