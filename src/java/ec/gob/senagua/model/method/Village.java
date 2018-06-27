/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.senagua.model.method;

import ec.gob.senagua.dbconnection.DBConnection;
import ec.gob.senagua.dbconnection.DBObject;
import ec.gob.senagua.model.entity.VillageEntity;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alexander
 */
public class VillageMethod extends VillageEntity {

    private final DBConnection DBC = new DBConnection();

    public VillageMethod() {
    }

    public VillageMethod(int id, String name) {
        super(id, name);
    }
    

    @Override
    public boolean save() throws Exception {
        boolean affected = false;
        String sql = "insert into village(name) values(?)";
        List<DBObject> dbos = new ArrayList<>();
        dbos.add(new DBObject(1, this.getName()));
        if (getId() != 0) {
            sql = "insert into village(name,id) values(?, ?)";
            dbos.add(new DBObject(2, getId()));
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
        String sql = "SELECT id, name	FROM public.village where id = ?;";
        List<DBObject> dbos = new ArrayList<>();
        dbos.add(new DBObject(1, id));
        try {
            ResultSet result = DBC.queryGet(sql, dbos);
            while (result.next()) {
                this.setId(result.getInt("id"));
                this.setName(result.getString("name"));
            }
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public boolean update() throws Exception {
        boolean affected = false;
        String sql = "update village set name=? where id=?;";
        List<DBObject> dbos = new ArrayList<>();
        dbos.add(new DBObject(1, getName()));
        dbos.add(new DBObject(2, getId()));
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
        String sql = "DELETE FROM village WHERE id=?;";
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
