package fr.ocr.sql;

import voiture.moteur.TypeMoteur;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOTypeMoteur extends DAO<TypeMoteur> {

    public DAOTypeMoteur(int n){
        super(DatabaseTable.TYPEMOTEUR,n);
    }

    @Override
    public TypeMoteur getObj(ResultSet res) throws SQLException {
        String des = res.getString("Description");
        return new TypeMoteur(id,des);
    }

    @Override
    public String getValueSQL(TypeMoteur obj) {
        return "(" + obj.getId() + ", '" + obj.getNom() + "')";
    }
}
