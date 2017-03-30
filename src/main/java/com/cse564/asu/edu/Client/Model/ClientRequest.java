/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cse564.asu.edu.Client.Model;

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
public class ClientRequest {
    
    @XmlElement
    private int RequestCode;

    @XmlElement
    private NewFoodItems NewFoodItems;
    
    @XmlElement 
    private SelectedFoodItems SelectedFoodItems;
    
    
    public int getRequestCode() {
        return RequestCode;
    }

    public void setRequestCode(int RequestCode) {
        this.RequestCode = RequestCode;
    }

    public NewFoodItems getNewFoodItems() {
        return NewFoodItems;
    }

    public void setNewFoodItems(NewFoodItems newFoodItems) {
        this.NewFoodItems = newFoodItems;
    }

    public SelectedFoodItems getSelectedFoodItems() {
        return SelectedFoodItems;
    }

    public void setSelectedFoodItems(SelectedFoodItems selectedFoodItems) {
        this.SelectedFoodItems = selectedFoodItems;
    }
    
 }
