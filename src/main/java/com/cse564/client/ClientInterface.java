/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cse564.client;

import com.cse564.asu.edu.Client.Model.AddFoodResponse;
import com.cse564.asu.edu.Client.Model.ClientRequest;
import com.cse564.asu.edu.Client.Model.FoodItem;
import com.cse564.asu.edu.Client.Model.FoodItemAdded;
import com.cse564.asu.edu.Client.Model.FoodItemExists;
import com.cse564.asu.edu.Client.Model.InvalidMessage;
import com.cse564.asu.edu.Client.Model.NewFoodItems;
import com.cse564.asu.edu.Client.Model.RetrievedFoodItems;
import com.cse564.asu.edu.Client.Model.SelectedFoodItems;
import com.cse564.asu.edu.Client.Model.ServerResponse;
import com.cse564.asu.edu.Client.Model.Utils;
import java.io.File;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;

/**
 *
 * @author nithesh
 */
public class ClientInterface {
    
    private static ClientInterface sInstance;
    
    public static ClientInterface getInstance(){
        if(sInstance == null){
            sInstance = new ClientInterface();
        }
        return sInstance;
    }
    
    public int getFoodItems(List<Integer> foodIds){
        SelectedFoodItems selectedFoodItems = new SelectedFoodItems();
        selectedFoodItems.setFoodItemId(foodIds);
        
        ClientRequest clientRequest = new ClientRequest();
        clientRequest.setRequestCode(Utils.RequestCodes.GET_FOOD_ITEM);
        clientRequest.setSelectedFoodItems(selectedFoodItems);

        System.out.println("Request Message: ");
        
        printObjectinXml(SelectedFoodItems.class, clientRequest.getSelectedFoodItems());
        
        RESTRequest restRequest = RESTRequest.getInstance();
        ServerResponse serverResponse = restRequest.getFoodItems(clientRequest);
        int responseCode = serverResponse.getResponseCode();
        switch(responseCode){
            case Utils.ResponseCodes.GET_FOOD_ITEM :
                 RetrievedFoodItems retrievedItems = serverResponse.getRetreievedFoodItems();
                 System.out.println("Response Message: ");

                 printObjectinXml(RetrievedFoodItems.class, retrievedItems);
                 break;
                 
            case Utils.ResponseCodes.INVALID_MESSAGE :
                printObjectinXml(InvalidMessage.class, new InvalidMessage());
                 
                 
                 
        }
        return responseCode;
    } 
    
    public List<FoodItemAdded> addFoodItems(List<FoodItem> foodItems){
        NewFoodItems newFoodItems = new NewFoodItems();
        newFoodItems.setFoodItem(foodItems);
        
        ClientRequest clientRequest = new ClientRequest();
        clientRequest.setRequestCode(Utils.RequestCodes.ADD_FOOD_ITEM);
        clientRequest.setNewFoodItems(newFoodItems);

        System.out.println("Request Message: ");

        printObjectinXml(NewFoodItems.class, clientRequest.getNewFoodItems());
        
        RESTRequest restRequest = RESTRequest.getInstance();
        ServerResponse serverResponse = restRequest.addFoodItems(clientRequest);
        
        int responseCode = serverResponse.getResponseCode();
        switch(responseCode){
            case Utils.ResponseCodes.ADD_FOOD_ITEM :
                AddFoodResponse addFoodResponse = serverResponse.getAddFoodResponse();
                if(addFoodResponse != null){
                        List<FoodItemAdded> addedList = addFoodResponse.getFoodItemAdded();
                        if(addedList != null && addedList.size()>0){
                            System.out.println("Response Message: ");

                            for(FoodItemAdded foodAdded : addedList){
                                printObjectinXml(FoodItemAdded.class, foodAdded);
                            }
                        }

                        List<FoodItemExists>  existsList = addFoodResponse.getFoodItemExists();
                        if(existsList != null && existsList.size()>0){
                            System.out.println("Response Message: ");

                            for(FoodItemExists foodExist : existsList){
                                 printObjectinXml(FoodItemExists.class, foodExist);
                            }
                        }
                   return  addedList;    
                }else{
                    break;
                }
                
            
            case Utils.ResponseCodes.INVALID_MESSAGE :
                printObjectinXml(InvalidMessage.class, new InvalidMessage());
                break;
                 
         }
        return null;
        
    }
    
    public void printObjectinXml(Class<?> classType, Object instance){
        try{
            JAXBContext contextObj = JAXBContext.newInstance(classType);  

            Marshaller marshaller = contextObj.createMarshaller();  
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            //File responseFile = new File("response.xml");

            //marshaller.marshal(classType.cast(instance), responseFile);
            marshaller.marshal(classType.cast(instance), System.out);
            System.out.println();
            System.out.println();

        }catch(JAXBException e){
               e.printStackTrace();
        }
     }
}
