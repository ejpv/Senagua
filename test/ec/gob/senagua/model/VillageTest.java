/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.senagua.model;

import ec.gob.senagua.model.method.VillageMethod;
import org.junit.Test;

/**
 *
 * @author alexander
 */
public class VillageTest {

    public VillageTest() {
    }

    @Test
    public void hello() {
        VillageMethod village = new VillageMethod(1000000,"BaYoUsHig");
        
        try {
            if(village.save()){
                System.out.println("Saved");
            }
        } catch (Exception e) {
            System.err.println("Error when save: " + e);
        }
        
        try {
            village.findById(1000000);
            System.out.println(village);
        } catch (Exception e) {
            System.err.println("Error when find: " + e);
        }

        try {
            village.setName("Bayushig");
            if (village.update()) {
                System.out.println("Updated.");
            }
        } catch (Exception e) {
            System.err.println("Error when update: " + e);
        }

        try {
            if (village.delete()) {
                System.out.println("Deleted");
            }
        } catch (Exception e) {
            System.err.println("Error when delete: " + e);
        }
    }
}
