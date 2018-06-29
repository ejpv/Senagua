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
public class PwsTypeEntity {
    
    private int id;
    private Boolean isActive;
    private String name;
    private int baseVolume;
    private Double basePrice;
    private Double extraPrice;

    public PwsTypeEntity() {
    }

    public PwsTypeEntity(int id, Boolean isActive, String name, int baseVolume, Double basePrice, Double extraPrice) {
        this.id = id;
        this.isActive = isActive;
        this.name = name;
        this.baseVolume = baseVolume;
        this.basePrice = basePrice;
        this.extraPrice = extraPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBaseVolume() {
        return baseVolume;
    }

    public void setBaseVolume(int baseVolume) {
        this.baseVolume = baseVolume;
    }

    public Double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Double basePrice) {
        this.basePrice = basePrice;
    }

    public Double getExtraPrice() {
        return extraPrice;
    }

    public void setExtraPrice(Double extraPrice) {
        this.extraPrice = extraPrice;
    }

    @Override
    public String toString() {
        return name;
    }
    
}
