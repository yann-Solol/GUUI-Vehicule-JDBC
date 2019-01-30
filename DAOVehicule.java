package fr.ocr.sql;

import voiture.Marque;
import voiture.Vehicule;
import voiture.moteur.Moteur;
import voiture.moteur.TypeMoteur;
import voiture.option.Option;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DAOVehicule extends DAO<Vehicule>{

    public DAOVehicule(){
        super(DatabaseTable.VEHICULE);
    }
    public DAOVehicule(int v){
        super(DatabaseTable.VEHICULE, v);
    }

    @Override
    public String getValueSQL(Vehicule obj) {
        return "(" + obj.getMarque().getId() + ", " + obj.getMoteur().getId() + ", " +
                obj.getPrix() + ", '" + obj.getNom() + "', " + this.id + ")";
    }

    @Override
    public Vehicule getObj(ResultSet res) throws SQLException {
        int motor = res.getInt("MOTEUR");
        Moteur moteur = new DAOMoteur(motor).getFirst();
        int mrq = res.getInt("MARQUE");
        Marque marque = new DAOMarque(mrq).getFirst();
        double prix = res.getInt("PRIX");
        String nom = res.getString("NOM");
        List<Option> options = (List<Option>) new DAOVehiculeOption(this.id).getAll(this.id);
        return new Vehicule(id, nom, marque, moteur, options, prix);
    }

}
