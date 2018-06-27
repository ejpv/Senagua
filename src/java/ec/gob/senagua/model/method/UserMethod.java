/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.senagua.model.method;

import ec.gob.senagua.dbconnection.DBConnection;
import ec.gob.senagua.dbconnection.DBObject;
import ec.gob.senagua.model.entity.UserEntity;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alexander
 */
public class UserMethod extends UserEntity {

    private final DBConnection DBC = new DBConnection();

    public UserMethod() {
    }

    public UserMethod(int id, String userName, String password, String type, String dni, String telephone, String firstName, String lastName, String address, String email) {
        super(id, userName, password, type, dni, telephone, firstName, lastName, address, email);
    }

    @Override
    public boolean save() throws Exception {
        boolean affected = false;
        String sql = "INSERT INTO public.users(username, password, type, dni, telephone, firstname, lastname, address, email) "
                + "VALUES (?, md5(?), ?, ?, ?, ?, ?, ?, ?);";
        List<DBObject> dbos = new ArrayList<>();
        dbos.add(new DBObject(1, this.getUserName()));
        dbos.add(new DBObject(2, this.getPassword()));
        dbos.add(new DBObject(3, this.getType()));
        dbos.add(new DBObject(4, this.getDni()));
        dbos.add(new DBObject(5, this.getTelephone()));
        dbos.add(new DBObject(6, this.getFirstName()));
        dbos.add(new DBObject(7, this.getLastName()));
        dbos.add(new DBObject(8, this.getAddress()));
        dbos.add(new DBObject(9, this.getEmail()));

        if (getId() != 0) {
            sql = "INSERT INTO public.users(username, password, type, dni, telephone, firstname, lastname, address, email, id) "
                    + "VALUES (?, md5(?), ?, ?, ?, ?, ?, ?, ?, ?);";
            dbos.add(new DBObject(10, getId()));
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
        String sql = "SELECT id, username, password, type, dni, telephone, firstname, lastname, address, email "
                + "FROM public.users where id = ?;";
        List<DBObject> dbos = new ArrayList<>();
        dbos.add(new DBObject(1, id));
        try {
            ResultSet result = DBC.queryGet(sql, dbos);
            while (result.next()) {
                this.setId(result.getInt("id"));
                this.setUserName(result.getString("username"));
                this.setPassword(result.getString("password"));
                this.setType(result.getString("type"));
                this.setDni(result.getString("dni"));
                this.setTelephone(result.getString("telephone"));
                this.setFirstName(result.getString("firstname"));
                this.setLastName(result.getString("lastname"));
                this.setAddress(result.getString("address"));
                this.setEmail(result.getString("email"));
            }
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public boolean update() throws Exception {
        boolean affected = false;
        String sql = "UPDATE public.users SET username=?, password=?, type=?, dni=?, "
                + "telephone=?, firstname=?, lastname=?, address=?, email=? WHERE id=?;";
        List<DBObject> dbos = new ArrayList<>();
        dbos.add(new DBObject(1, this.getUserName()));
        dbos.add(new DBObject(2, this.getPassword()));
        dbos.add(new DBObject(3, this.getType()));
        dbos.add(new DBObject(4, this.getDni()));
        dbos.add(new DBObject(5, this.getTelephone()));
        dbos.add(new DBObject(6, this.getFirstName()));
        dbos.add(new DBObject(7, this.getLastName()));
        dbos.add(new DBObject(8, this.getAddress()));
        dbos.add(new DBObject(9, this.getEmail()));
        dbos.add(new DBObject(10, this.getId()));
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

        String sql = "DELETE FROM users WHERE id=?;";
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
