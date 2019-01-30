package fr.ocr.sql;

import voiture.Marque;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DAOMarque extends DAO<Marque> {

    public DAOMarque() {super(DatabaseTable.MARQUE);}
    public DAOMarque(int m){
        super(DatabaseTable.MARQUE,m);
    }

    @Override
    public String getValueSQL(Marque obj) {
        return "(" + obj.getId() + ", '" + obj.getNom() + "')";
    }

    @Override
    public Marque getObj(ResultSet res) throws SQLException {
        int n = res.getInt("ID");
        String nm = res.getString("NOM");
        return new Marque(n,nm);
    }
}
