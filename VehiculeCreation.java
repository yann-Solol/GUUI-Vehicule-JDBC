package fr.ocr.ihm;

import fr.ocr.sql.DAOMarque;
import fr.ocr.sql.DAOMoteur;
import fr.ocr.sql.DAOOption;
import fr.ocr.sql.HsqldbConnection;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import voiture.Marque;
import voiture.Vehicule;
import voiture.moteur.Moteur;
import voiture.option.Option;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class VehiculeCreation extends JDialog {
    private boolean dataSent;
    Vehicule vehicule;
    private JPanel nom, prix,marque,moteur,options,prixTotal;
    private JTextField nomFil, prixFil;
    private JComboBox marqueBox;
    private JComboBox moteurBox;
    private ButtonGroup optionsRad;
    private JLabel nomLab, prixLab ,marqueLabel,moteurLabel,prixTotalLabel;
    private JFrame parent;

    public VehiculeCreation(JFrame parent,String title) throws SQLException {
        super(parent,"Creation de vehicule ");
        this.parent = parent;
        this.setSize(new Dimension(600, 400));
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

    public void initComponent() throws SQLException {
        nom = new JPanel();
        nom.setBackground(Color.white);
        nom.setPreferredSize(new Dimension(250,80));
        nomFil = new JTextField();
        nomFil.setPreferredSize(new Dimension(90,35));
        nom.setBorder(BorderFactory.createTitledBorder("Nom :"));
        nom.add(nomFil);
        nom.setVisible(true);

        prix = new JPanel();
        prix.setBackground(Color.white);
        prix.setPreferredSize(new Dimension(250,80));
        prixFil = new JTextField();
        prixFil.setPreferredSize(new Dimension(90,35));
        prix.setBorder(BorderFactory.createTitledBorder("Prix du modele :"));
        prix.add(prixFil);
        prix.setVisible(true);

        marque = new JPanel();
        marque.setBackground(Color.white);
        marque.setPreferredSize(new Dimension(200,75));
        marque.setBorder(BorderFactory.createTitledBorder("Marque : "));
        marqueBox = new JComboBox();
        java.util.List<Marque> m = new DAOMarque().getAlls();
        for(Marque mrq : m){
            marqueBox.addItem(mrq.getId() + " : " + mrq.getNom());
        }
        marque.add(marqueBox );
        marque.setVisible(true);

        moteur = new JPanel();
        moteur.setBackground(Color.white);
        moteur.setPreferredSize(new Dimension(200, 75));
        moteur.setBorder(BorderFactory.createTitledBorder("Moteur : "));
        moteurBox = new JComboBox();
        java.util.List<Moteur> mtrs = new DAOMoteur().getAlls();
        for(Moteur mtr : mtrs){
            moteurBox.addItem(mtr.getId() + " : " + mtr.toString());
        }
        moteur.add(moteurBox);
        moteur.setVisible(true);

        options = new JPanel();
        options.setBackground(Color.white);
        options.setPreferredSize(new Dimension(500,100 ));
        options.setBorder(BorderFactory.createTitledBorder("Options : "));
        java.util.List<Option> opts = new DAOOption().getAlls();
        optionsRad = new ButtonGroup();
        for(Option op : opts){
            JRadioButton tmp = new JRadioButton(op.getPrix() + op.toString());
            optionsRad.add(tmp);
            options.add(tmp);
        }
        options.setVisible(true);

        prixTotal = new JPanel();
        prixTotal.setBackground(Color.white);
        prixTotal.setPreferredSize(new Dimension(350,60));
        prixTotal.setBorder(BorderFactory.createTitledBorder("Prix Total du vehicule : "));
        prixTotal.add(new JLabel("Prix TOT"));
        prixTotalLabel = new JLabel("Calcul du prix avec options : ");
        prixTotal.add(prixTotalLabel);
        prixTotal.setVisible(true);

        JPanel content = new JPanel();
        content.setBackground(Color.gray);
        content.setPreferredSize(new Dimension(600,400));
        content.add(nom);
        content.add(prix);
        content.add(marque);
        content.add(moteur);
        content.add(options);
        content.add(prixTotal);

        //JPanel control = new JPanel();
        //JButton ok = new JButton("OK");
        //JButton cnc = new JButton("Annuler");

        content.setVisible(true);
        //control.setVisible(true);

        this.add(content);
        //this.add(control);
        this.setVisible(true);

    }
}
