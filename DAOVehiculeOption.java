package fr.ocr.sql;

import voiture.option.Option;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DAOVehiculeOption extends DAO<Option>{

    public DAOVehiculeOption(){
        super(DatabaseTable.VEHICULE_OPTION,"ID_VEHICULE");
    }
    public DAOVehiculeOption(int id){ super(DatabaseTable.VEHICULE_OPTION, "ID_VEHICULE", id);}
    @Override

    public String getValueSQL(Option obj) {
        return "(" + id + "," + obj.getId();
    }

    @Override
    public Option getObj(ResultSet res) throws SQLException {
        int opt = res.getInt("ID_OPTION");
        DAOOption tmp = new DAOOption();
        tmp.id = opt;
        return tmp.getFirst();
    }



}
