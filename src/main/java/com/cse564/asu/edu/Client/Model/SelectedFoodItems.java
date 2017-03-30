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
public class SelectedFoodItems {
    
@XmlElement
private List<Integer> FoodItemId;

    public List<Integer> getFoodItemId() {
        return FoodItemId;
    }

    public void setFoodItemId(List<Integer> FoodItemId) {
        this.FoodItemId = FoodItemId;
    }

}
