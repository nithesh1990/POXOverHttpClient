/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cse564.asu.edu.Client.Model;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author nithesh
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class RetrievedFoodItems {
    
    @XmlElement
    private List<FoodItem> FoodItem;
    
    @XmlElement
    private List<InvalidFoodItem> InvalidFoodItem;

    public List<InvalidFoodItem> getInvalidFoodItem() {
        return InvalidFoodItem;
    }

    public void setInvalidFoodItem(List<InvalidFoodItem> InvalidFoodItem) {
        this.InvalidFoodItem = InvalidFoodItem;
    }

    public List<FoodItem> getFoodItem() {
        return FoodItem;
    }

    public void setFoodItem(List<FoodItem> FoodItem) {
        this.FoodItem = FoodItem;
    }
}
