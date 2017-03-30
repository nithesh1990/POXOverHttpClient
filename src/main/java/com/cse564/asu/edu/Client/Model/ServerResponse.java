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
public class ServerResponse {
    
    @XmlElement
    private int ResponseCode;

    @XmlElement
    private AddFoodResponse AddFoodResponse;

    public int getResponseCode() {
        return ResponseCode;
    }

    public void setResponseCode(int ResponseCode) {
        this.ResponseCode = ResponseCode;
    }

    public AddFoodResponse getAddFoodResponse() {
        return AddFoodResponse;
    }

    public void setAddFoodResponse(AddFoodResponse addFoodResponse) {
        this.AddFoodResponse = addFoodResponse;
    }

    public InvalidMessage getInvalidMessage() {
        return InvalidMessage;
    }

    public void setInvalidMessage(InvalidMessage invalidMessage) {
        this.InvalidMessage = invalidMessage;
    }

    public RetrievedFoodItems getRetreievedFoodItems() {
        return RetreievedFoodItems;
    }

    public void setRetreievedFoodItems(RetrievedFoodItems retreievedFoodItems) {
        this.RetreievedFoodItems = retreievedFoodItems;
    }
    
    @XmlElement
    private InvalidMessage InvalidMessage;
    
    @XmlElement
    private RetrievedFoodItems RetreievedFoodItems;
    
    

    
}
