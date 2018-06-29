/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.senagua.model.method;

import ec.gob.senagua.dbconnection.DBConnection;
import ec.gob.senagua.dbconnection.DBObject;
import ec.gob.senagua.model.entity.interfaces.*;
import ec.gob.senagua.model.entity.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alexander
 */
public class PwsTypeMethod extends PwsTypeEntity implements PwsTypeInterace {

    private final DBConnection DBC = new DBConnection();

    public PwsTypeMethod() {
    }

    public PwsTypeMethod(int id, Boolean isActive, String name, int baseVolume, Double basePrice, Double extraPrice) {
        super(id, isActive, name, baseVolume, basePrice, extraPrice);
    }

    @Override
    public boolean save() throws Exception {
        boolean affected = false;
        String sql = "INSERT INTO public.pwstype(isactive, name, basevolume, baseprice, extraprice) VALUES (?, ?, ?, ?, ?)";
        List<DBObject> dbos = new ArrayList<>();
        dbos.add(new DBObject(1, this.getIsActive()));
        dbos.add(new DBObject(2, this.getName()));
        dbos.add(new DBObject(3, this.getBaseVolume()));
        dbos.add(new DBObject(4, this.getBasePrice()));
        dbos.add(new DBObject(5, this.getExtraPrice()));
        if (getId() != 0) {
            sql = "INSERT INTO public.pwstype(isactive, name, basevolume, baseprice, extraprice, id) VALUES (?, ?, ?, ?, ?, ?)";
            dbos.add(new DBObject(6, getId()));
        }
        try {
            if (DBC.querySet(sql, dbos)) {
                affected = true;
            }
        } catch (Exception e) {
            throw e;
        }
        return affected;
    }

    @Override
    public void findById(int id) throws Exception {
        String sql = "SELECT id, isactive, name, basevolume, baseprice, extraprice FROM public.pwstype where id = ?;";
        List<DBObject> dbos = new ArrayList<>();
        dbos.add(new DBObject(1, id));
        try {
            ResultSet result = DBC.queryGet(sql, dbos);
            while (result.next()) {
                this.setId(result.getInt("id"));
                this.setIsActive(result.getBoolean("isactive"));
                this.setName(result.getString("name"));
                this.setBaseVolume(result.getInt("basevolume"));
                this.setBasePrice(result.getDouble("baseprice"));
                this.setExtraPrice(result.getDouble("extraprice"));
            }
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public ResultSet find() throws Exception {
        String sql = "SELECT id, isactive, name, basevolume, baseprice, extraprice FROM public.pwstype;";
        ResultSet rs = null;
        try {
            rs = DBC.queryGet(sql);
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        }
        return rs;
    }

    @Override
    public boolean update() throws Exception {
        boolean affected = false;
        String sql = "update public.pwstype set isactive=?, name=?, basevolume=?, baseprice=?, extraprice=? where id=?;";
        List<DBObject> dbos = new ArrayList<>();
        dbos.add(new DBObject(1, getIsActive()));
        dbos.add(new DBObject(2, getName()));
        dbos.add(new DBObject(3, getBaseVolume()));
        dbos.add(new DBObject(4, getBasePrice()));
        dbos.add(new DBObject(5, getExtraPrice()));
        dbos.add(new DBObject(6, getId()));
        try {
            if (DBC.querySet(sql, dbos)) {
                affected = true;
            }
        } catch (Exception e) {
            throw e;
        }
        return affected;
    }

    @Override
    public boolean delete() throws Exception {
        boolean affected = false;
        String sql = "DELETE FROM public.pwstype WHERE id=?;";
        List<DBObject> dbos = new ArrayList<>();
        dbos.add(new DBObject(1, getId()));
        try {
            if (DBC.querySet(sql, dbos)) {
                affected = true;
            }
        } catch (Exception e) {
            throw e;
        }
        return affected;
    }

}
