package fr.ocr.ihm.listener;

import fr.ocr.ihm.VehiculeCreation;
import fr.ocr.sql.DAOMarque;
import fr.ocr.sql.DAOMoteur;
import fr.ocr.sql.DAOVehicule;
import fr.ocr.sql.HsqldbConnection;
import sun.awt.shell.ShellFolder;
import voiture.Marque;
import voiture.Vehicule;
import voiture.moteur.Moteur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.*;

public class NewVehiculeListener implements ActionListener {

	private JFrame frame = new JFrame();


	public NewVehiculeListener(JFrame f) {
		frame = f;
	}

	public void actionPerformed(ActionEvent e) {
		JFrame jf = new JFrame();
		VehiculeCreation vh = null;
		try {
			vh = new VehiculeCreation(jf, "Cr");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		vh.setVisible(true);
	}
}
/**
	    Scanner scanner = new Scanner(System.in);
		System.out.println(" Nom : ");
		while (! scanner.hasNext()){
			scanner.nextLine();
		}
		String nom = scanner.nextLine();
		System.out.println("prix : ");
		double prix = scanner.nextInt();
		System.out.println("Marque : ");
		Marque marque = null;
		Connection conn = HsqldbConnection.getInstance();
		int id = 0;
		try {
			conn.setAutoCommit(false);
			ResultSet nextID = conn.prepareStatement("CALL NEXT VALUE FOR seq_vehicule_id").executeQuery();
			if (nextID.next()){
				id = nextID.getInt(1);
			}
			marque = new DAOMarque(scanner.nextInt()).getFirst();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		System.out.println("Moteur ");
		Moteur moteur = null;
		try {
			moteur = new DAOMoteur(scanner.nextInt()).getFirst();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		Vehicule vehicule = new Vehicule(id, nom, marque, moteur, prix);
		try {
			new DAOVehicule().create(vehicule);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		scanner.close();
		/*
		 
		 Vous devez d�finir cette m�thode afin d'afficher
		 une popup personnalis�e pour ainsi pouvoir cr�er un nouveau v�hicule
		 

	}
}
 */