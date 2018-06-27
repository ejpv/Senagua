/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.senagua.model.entity;

import ec.gob.senagua.model.method.UserMethod;

/**
 *
 * @author alexander
 */
public abstract class RecordsPersonEntity {

    private int id;
    private UserMethod user;

    public RecordsPersonEntity() {
    }

    public RecordsPersonEntity(int id, UserMethod user) {
        this.id = id;
        this.user = user;
    }

    public UserMethod getUser() {
        return user;
    }

    public void setUser(UserMethod user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return user.toString();
    }

    public abstract boolean save() throws Exception;

    public abstract void findById(int id) throws Exception;

    public abstract boolean update() throws Exception;

    public abstract boolean delete() throws Exception;
}
