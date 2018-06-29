/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.senagua.model.entity.interfaces;

import java.sql.ResultSet;

/**
 *
 * @author Usuario
 */
public interface RecordsPersonInterface {

    public abstract boolean save() throws Exception;

    public abstract void findById(int id) throws Exception;

    public abstract ResultSet find() throws Exception;

    public abstract boolean update() throws Exception;

    public abstract boolean delete() throws Exception;
}
