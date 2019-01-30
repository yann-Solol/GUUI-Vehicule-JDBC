package fr.ocr.sql;

import voiture.option.Option;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DAOOption extends DAO<Option>{

    public DAOOption(){
        super(DatabaseTable.OPTION);
    }
    public DAOOption(int n){
        super(DatabaseTable.OPTION, n);
    }

    @Override
    public Option getObj(ResultSet res) throws SQLException {
        String des = res.getString("DESCRIPTION");
        double p = res.getInt("PRIX");
        return new Option(id,des,p);
    }

    @Override
    public String getValueSQL(Option obj) {
        return "(" + obj.getId() + ", '" + obj.getNom() + "', " + obj.getPrix() + ")";
    }
}
