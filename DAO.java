package fr.ocr.sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class DAO<T> {
    protected Connection conn = HsqldbConnection.getInstance();
    protected int id;
    protected String identifiant = "id";
    protected DatabaseTable dtb;

    public DAO(DatabaseTable dtb){
        this.dtb = dtb;
    }
    public DAO(DatabaseTable dtb, String identifiant){
        this.dtb = dtb;
        this.identifiant = identifiant;
    }
    public DAO(DatabaseTable dtb, int n){
        this.dtb = dtb;
        this.id = n;
    }
    public DAO(DatabaseTable dtb, String identifiant, int n){
        this.dtb = dtb;
        this.identifiant = identifiant;
        this.id = n;
    }

    public boolean create(T obj) throws SQLException {
        ResultSet res = conn.createStatement().executeQuery("INSERT INTO " + dtb + " VALUES" +
                this.getValueSQL(obj));
        return res.next();
    }
    public boolean delete() throws SQLException {
        ResultSet res = conn.createStatement().executeQuery("DELETE FROM " + dtb + " WHERE " +
                identifiant + " = " + id);
        return res.next();
    }
    public List<T> getAll(int n) throws SQLException {
        ArrayList<T> rep = new ArrayList<T>();
        ResultSet res = conn.createStatement().executeQuery("SELECT * FROM " + dtb + " WHERE " +
                identifiant + " = " +  n);
        while (res.next()){
            T tmp = this.getObj(res);
            rep.add(tmp);
        }
        return rep;
    }

    public ArrayList<T> getAlls() throws SQLException {
        ArrayList<T> rep = new ArrayList<T>();
        ResultSet res = conn.createStatement().executeQuery("SELECT * FROM " + dtb);
        while (res.next()) {
            T tmp = this.getObj(res);
            rep.add(tmp);
        }
        return rep;
    }

    public T getN(int n) throws SQLException {
        ResultSet res = conn.createStatement().executeQuery("SELECT * FROM " + dtb);
        for(int i = 0 ; i <= n ; i++){
            res.next();
        }
        return this.getObj(res);
    }

    public abstract T getObj(ResultSet res) throws SQLException;

    public T getFirst() throws SQLException {
        ResultSet res = conn.createStatement().executeQuery("SELECT * FROM " + dtb + " WHERE " +
                identifiant + " = " + id);
        if(res.next()){
            return this.getObj(res);
        }
        else {
            return null;
        }
    }

    public abstract String getValueSQL(T obj);


}
