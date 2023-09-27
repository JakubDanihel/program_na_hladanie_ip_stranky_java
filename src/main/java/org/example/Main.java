package org.example;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.*;

public class Main extends JFrame implements ActionListener {
    JLabel label;
    JTextField field;
    JButton button;

    Main(){
        super("IP vyhladavac");
        label = new JLabel("Zadaj url: ");
        label.setBounds(50, 70, 150, 20);
        field = new JTextField();
        field.setBounds(50, 100, 200, 20);
        button = new JButton("Najdena IP: ");
        button.setBounds(50, 150, 80, 30);
        button.addActionListener(this);

        add(label);
        add(field);
        add(button);

        setSize(300, 300);
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        String url = field.getText();

        try {
            InetAddress ia = InetAddress.getByName(url);
            String ip = ia.getHostAddress();
            JOptionPane.showMessageDialog(this, ip);
        }catch (UnknownHostException e1){
            JOptionPane.showMessageDialog(this,e1.toString());
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}