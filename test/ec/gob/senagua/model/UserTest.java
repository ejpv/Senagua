/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.senagua.model;

import ec.gob.senagua.model.method.UserMethod;
import org.junit.Test;

/**
 *
 * @author alexander
 */
public class UserTest {

    public UserTest() {
    }

    @Test
    public void hello() {
        UserMethod user = new UserMethod(1000000, "Ana1980", "123", "0619823457", "0619823457", "0912356712", "Ana Carlota", "Peres Padilla", "Av Penipe", "acperes@hotmail.com");
        
        
        try {
            if(user.save()){
                System.out.println("Saved");
            }
        } catch (Exception e) {
            System.err.println("Error when save: " + e);
        }
        
        try {
            user.findById(1000000);
            System.out.println(user);
        } catch (Exception e) {
            System.err.println("Error when find: " + e);
        }

        try {
            user.setType("Acounter");
            if (user.update()) {
                System.out.println("Updated.");
            }
        } catch (Exception e) {
            System.err.println("Error when update: " + e);
        }

        try {
            if (user.delete()) {
                System.out.println("Deleted");
            }
        } catch (Exception e) {
            System.err.println("Error when delete: " + e);
        }
    }
}
