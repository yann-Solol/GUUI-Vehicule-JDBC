package fr.ocr.ihm;

import voiture.Vehicule;
import voiture.option.Option;

import javax.swing.*;
import java.awt.*;

public class VehiculeView extends JDialog {
    private boolean dataSent;
    Vehicule vehicule;
    private JPanel nomLabel,marqueLabel,moteurLabel,prixLabel,optionsLabel,prixTotalLabel;
    private JFrame parent;

    public VehiculeView(JFrame parent,String title,Vehicule v){
        super(parent,title,true);
        this.vehicule = v;
        this.setSize(600,800);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.initComponent();
    }

    public void showVehicule(){
        if(dataSent){
            this.setVisible(true);
        }
    }


    public void initComponent(){
        nomLabel = new JPanel();
        nomLabel.setBackground(Color.white);
        nomLabel.setPreferredSize(new Dimension(250,50));
        nomLabel.setBorder(BorderFactory.createTitledBorder("Nom : "));
        if (! vehicule.equals(null)) {
            nomLabel.add(new JLabel(vehicule.getNom()));
        }
        nomLabel.setVisible(true);

        marqueLabel = new JPanel();
        marqueLabel.setBackground(Color.white);
        marqueLabel.setPreferredSize(new Dimension(250, 50));
        marqueLabel.setBorder(BorderFactory.createTitledBorder("Marque : "));
        if (! vehicule.equals(null)) {
            marqueLabel.add(new JLabel(vehicule.getMarque().getNom()));
        }
        marqueLabel.setVisible(true);

        moteurLabel = new JPanel();
        moteurLabel.setBackground(Color.white);
        moteurLabel.setPreferredSize(new Dimension(450, 80));
        moteurLabel.setBorder(BorderFactory.createTitledBorder("Motorisation : "));
        if (! vehicule.equals(null)) {
            moteurLabel.add(new JLabel(vehicule.getMoteur().toString()));
        }
        moteurLabel.setVisible(true);

        prixLabel = new JPanel();
        prixLabel.setBackground(Color.white);
        prixLabel.setPreferredSize(new Dimension(450,80));
        prixLabel.setBorder(BorderFactory.createTitledBorder("Prix sans les options : "));
        if(! vehicule.equals(null)){
            prixLabel.add(new JLabel(String.valueOf(vehicule.getPrix()) + " €"));
        }
        prixLabel.setVisible(true);

        optionsLabel = new JPanel();
        optionsLabel.setBackground(Color.white);
        optionsLabel.setPreferredSize(new Dimension(450, (1 + vehicule.getOptions().size()) * 10));
        optionsLabel.setBorder(BorderFactory.createTitledBorder("Options : "));
        if (! vehicule.equals(null)) {
            for (Option opt : vehicule.getOptions()) {
                optionsLabel.add(new JLabel(opt.toString()));
            }
        }
        optionsLabel.setVisible(true);

        prixTotalLabel = new JPanel();
        prixTotalLabel.setBackground(Color.gray);
        prixLabel.setFont(Font.getFont("Arial-Black"));
        prixTotalLabel.setForeground(Color.white);
        prixTotalLabel.setPreferredSize(new Dimension(450,80));
        prixTotalLabel.setBorder(BorderFactory.createTitledBorder("PRIX TOTAL : "));
        prixTotalLabel.add(new JLabel(vehicule.getPrixTotal() + " €"));
        prixTotalLabel.setVisible(true);

        JPanel content = new JPanel();
        content.setBackground(Color.LIGHT_GRAY);
        content.add(nomLabel);
        content.add(marqueLabel);
        content.add(moteurLabel);
        content.add(prixLabel);
        content.add(optionsLabel);
        content.add(prixTotalLabel);
        content.setVisible(true);

        this.add(content);

        this.dataSent = true;

        this.setVisible(true);
    }
}
