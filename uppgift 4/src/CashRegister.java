import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.*;



public class CashRegister implements ActionListener {


    JFrame frame;
    JTextArea receipt;
    JButton kaffeButton;
    JButton nalleButton;
    JButton muggButton;
    JButton chipsButton;
    JButton vaniljYoghurtButton;
    JButton daimButton;
    JTextArea inputProductName;
    JTextArea inputCount;
    JButton addToReceiptButton;
    JButton payButton;

    // produkterna, en för varje knapp
    Produkt kaffe = new Produkt("Kaffe", 51);
    Produkt nalle = new Produkt("Nallebjörn", 110);
    Produkt mugg = new Produkt("Mugg", 89);
    Produkt chips = new Produkt("Chips", 25);
    Produkt yoghurt = new Produkt("Vaniljyoghurt", 22.5);
    Produkt daim = new Produkt("Daim", 12);

    Produkt valdProdukt; // den man klickat på senast
    Kvitto kvitto = new Kvitto(); // heter kvitto för receipt är redan textrutan


    public CashRegister(){
        frame = new JFrame("IOT24 POS");


        createReceiptArea();
        createQuickButtonsArea();
        createAddArea();

        frame.getContentPane().setBackground(Color.BLACK);
        frame.setSize(1000,800);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(null);

        frame.setVisible(true);


    }

    private void createAddArea(){
        inputProductName = new JTextArea();
        inputProductName.setBounds(20,650,300,30);
        inputProductName.setFont(new Font("Arial Black", Font.BOLD, 18));
        frame.add(inputProductName);

        JLabel label = new JLabel("Antal");
        label.setBounds(340,625,300,30);
        label.setForeground(Color.WHITE);
        frame.add(label);

        inputCount = new JTextArea();
        inputCount.setBounds(330,650,50,30);
        inputCount.setFont(new Font("Arial Black", Font.BOLD, 18));
        frame.add(inputCount);


        addToReceiptButton = new JButton("Add");
        addToReceiptButton.setBounds(400,640,70,50);
        addToReceiptButton.setFont(new Font("Arial Black", Font.PLAIN, 14));
        addToReceiptButton.addActionListener(this);
        frame.add(addToReceiptButton);


        payButton = new JButton("Pay");
        payButton.setBounds(480,640,70,50);
        payButton.setFont(new Font("Arial Black", Font.PLAIN, 14));
        payButton.addActionListener(this);
        frame.add(payButton);


    }

    private void createQuickButtonsArea() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEADING, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        panel.setBackground(Color.green);
        panel.setPreferredSize(new Dimension(600, 600));

        kaffeButton = new JButton("Kaffe");
        kaffeButton.addActionListener(this);
        panel.add(kaffeButton);

        nalleButton = new JButton("Nalle");
        nalleButton.addActionListener(this);
        panel.add(nalleButton);

        muggButton = new JButton("Mugg");
        muggButton.addActionListener(this);
        panel.add(muggButton);

        chipsButton = new JButton("Chips");
        chipsButton.addActionListener(this);
        panel.add(chipsButton);

        vaniljYoghurtButton = new JButton("Yoghurt");
        vaniljYoghurtButton.addActionListener(this);
        panel.add(vaniljYoghurtButton);


        daimButton = new JButton("Daim");
        daimButton.addActionListener(this);
        panel.add(daimButton);




        panel.setBounds(0, 0, 600, 600);

        frame.add(panel);
    }

    private void createReceiptArea() {
        receipt = new JTextArea();
        receipt.setSize(400,400);
        receipt.setLineWrap(true);
        receipt.setEditable(false);
        receipt.setVisible(true);
        receipt.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));

        JScrollPane scroll = new JScrollPane (receipt);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setBounds(600, 0, 400, 1000);

        frame.add(scroll);
    }

    public void run(){
        receipt.setText(""); // kvittot ska va tomt när man startar
    }

    // när man klickar på en produkt
    private void valjProdukt(Produkt p){
        valdProdukt = p;
        inputProductName.setText(p.getName());
    }

    // när man trycker på add
    private void add(){
        // kollar så man har valt en produkt först
        if(valdProdukt == null){
            JOptionPane.showMessageDialog(frame, "Välj en produkt först");
            return;
        }

        int antal = 0;
        // try catch så det inte kraschar om man skriver bokstäver eller inget
        try{
            antal = Integer.parseInt(inputCount.getText());
        }
        catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(frame, "Antal måste vara en siffra!");
            return;
        }

        // kan inte köpa 0 eller minus
        if(antal <= 0){
            JOptionPane.showMessageDialog(frame, "Antal måste vara mer än 0");
            return;
        }

        kvitto.addRow(valdProdukt, antal);
        receipt.setText(kvitto.getText()); // visar kvittot i rutan

        // tömmer rutorna
        valdProdukt = null;
        inputProductName.setText("");
        inputCount.setText("");
    }

    // när man trycker på pay
    private void pay(){
        if(kvitto.getTotal() == 0){
            JOptionPane.showMessageDialog(frame, "Det finns inget på kvittot");
            return;
        }
        kvitto.pay();
        receipt.setText(kvitto.getText());
        kvitto.clear(); // rensar så nästa kund får ett nytt kvitto
    }

    // alla knappar hamnar här när man klickar, getSource kollar vilken knapp det va
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == kaffeButton){
            valjProdukt(kaffe);
        }
        if(e.getSource() == nalleButton){
            valjProdukt(nalle);
        }
        if(e.getSource() == muggButton){
            valjProdukt(mugg);
        }
        if(e.getSource() == chipsButton){
            valjProdukt(chips);
        }
        if(e.getSource() == vaniljYoghurtButton){
            valjProdukt(yoghurt);
        }
        if(e.getSource() == daimButton){
            valjProdukt(daim);
        }
        if(e.getSource() == addToReceiptButton){
            add();
        }
        if(e.getSource() == payButton){
            pay();
        }
    }


}
