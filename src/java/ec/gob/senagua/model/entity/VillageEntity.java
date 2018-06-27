/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.senagua.model.entity;

/**
 *
 * @author alexander
 */
public abstract class VillageEntity {
    
    private int id;
    private String name;

    public VillageEntity() {
    }

    public VillageEntity(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return name;
    }
    
    public abstract boolean save() throws Exception;

    public abstract void findById(int id) throws Exception;

    public abstract boolean update() throws Exception;

    public abstract boolean delete() throws Exception;
    
}
