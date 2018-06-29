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
public class BeneficiaryEntity {
    
    private int id;
    private String dni;
    private String lastName;
    private String firstName;
    private String address;
    private String references;
    private VillageEntity village;

    public BeneficiaryEntity() {
    }

    public BeneficiaryEntity(int id, String dni, String lastName, String firstName, String address, String references, VillageEntity village) {
        this.id = id;
        this.dni = dni;
        this.lastName = lastName;
        this.firstName = firstName;
        this.address = address;
        this.references = references;
        this.village = village;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getReferences() {
        return references;
    }

    public void setReferences(String references) {
        this.references = references;
    }

    public VillageEntity getVillage() {
        return village;
    }

    public void setVillage(VillageEntity village) {
        this.village = village;
    }
    
    
    @Override
    public String toString() {
        return lastName+" "+firstName;
    }
    
}
