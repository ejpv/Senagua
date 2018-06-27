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
public abstract class UserEntity {

    private int id;
    private String userName;
    private String password;
    private String type;
    private String dni;
    private String telephone;
    private String firstName;
    private String lastName;
    private String address;
    private String email;

    public UserEntity() {
    }

    public UserEntity(int id, String userName, String password, String type, String dni, String telephone, String firstName, String lastName, String address, String email) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.type = type;
        this.dni = dni;
        this.telephone = telephone;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return lastName + " " + firstName;
    }

    public abstract boolean save() throws Exception;

    public abstract void findById(int id) throws Exception;

    public abstract boolean update() throws Exception;

    public abstract boolean delete() throws Exception;

}
