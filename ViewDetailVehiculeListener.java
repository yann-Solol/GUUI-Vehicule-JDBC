package fr.ocr.ihm.listener;

import fr.ocr.ihm.VehiculeView;
import fr.ocr.sql.DAOVehicule;
import fr.ocr.sql.DAOVehiculeOption;
import voiture.Vehicule;
import voiture.option.Option;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ViewDetailVehiculeListener extends ButtonListener {
    JFrame jf;
    public void actionPerformed(ActionEvent e) {
        try {
            Vehicule vehicule = new DAOVehicule().getN(this.row);
            List<Option> opts = new DAOVehiculeOption(vehicule.getId()).getAll(vehicule.getId());
            vehicule.setListOptions(opts);
            VehiculeView vv = new VehiculeView(jf, "DETAILS DU VEHICULE", vehicule);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
	}
}
