package org.example.principal;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Principal extends JFrame {
    private JPanel panel1;
    private JPanel panelMain;
    private JPanel infoPanel;
    private JPanel midPanel;
    private JTable table1;
    private JLabel txtMain;
    private JLabel txtInfo;
    private JScrollPane scrollPane;
    private JPanel emailPane;
    private JPanel idiomaPane;
    private JPanel rolPane;
    private JTextArea emailTextArea;
    private JLabel emailLabel;
    private JLabel idiomaLabel;
    private JComboBox comboBox1;
    private JLabel rolLabel;
    private JCheckBox checkBox1;
    private JButton buttonConfirmar;
    private JButton butonBack;
    private JLabel imagenLabel;

    private DefaultTableModel model;


    public Principal(){
        String[] cabecera = {"Email","Idioma","Admin"};
        model = new DefaultTableModel(cabecera,0);
        table1.setModel(model);

        comboBox1.addItem("Español");
        comboBox1.addItem("Inglés");
        comboBox1.addItem("Francés");
        comboBox1.setSelectedItem("Español");

        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Gestos Usuarios");
        pack();
        setLocationRelativeTo(null);
        buttonConfirmar.addActionListener(e -> {
            String email = emailTextArea.getText();
            String idioma = (String) comboBox1.getSelectedItem();
            String rol = checkBox1.isSelected() ? "Administrador" : "Usuario";

            if (email.isEmpty() || idioma == null || idioma.isEmpty()) {
                txtInfo.setText("Falta algún campo por completar");
            } else {
                txtInfo.setText("");
                model.addRow(new Object[]{email, idioma, rol});
                String mensaje = "Correo Electrónico: " + email +
                        "\nIdioma: " + idioma +
                        "\nRol: " + rol;

                JOptionPane.showMessageDialog(this, mensaje, "Información del Usuario", JOptionPane.INFORMATION_MESSAGE);

            }
        });
    }
}
