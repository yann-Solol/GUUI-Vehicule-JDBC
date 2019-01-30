package fr.ocr.sql;

import voiture.moteur.Moteur;
import voiture.moteur.TypeMoteur;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOMoteur extends DAO<Moteur> {

    public DAOMoteur() {super(DatabaseTable.MOTEUR);}
    public DAOMoteur(int t){
        super(DatabaseTable.MOTEUR, t);
    }

    @Override
    public String getValueSQL(Moteur obj) {
        return "(" + obj.getId() + ", '" + obj.getCylindre() + "', " + obj.getType().getId() +
                ", " + obj.getPrix() +")";
    }

    @Override
    public Moteur getObj(ResultSet res) throws SQLException {
        int typ = res.getInt("MOTEUR");
        TypeMoteur typeMoteur = new DAOTypeMoteur(typ).getFirst();
        String cyl = res.getString("CYLINDRE");
        double pr = res.getInt("PRIX");
        return new Moteur(id, typeMoteur, cyl, pr);
    }
}
