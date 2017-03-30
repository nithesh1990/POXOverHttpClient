/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cse564.client;

import com.cse564.asu.edu.Client.Model.ClientRequest;
import com.cse564.asu.edu.Client.Model.ServerResponse;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author nithesh
 */
public class RESTRequest {

    private static WebResource webResource;
    
    private static Client client;
    
    private final static String BASE_URI = "http://localhost:8080/POX-FoodMenu-nrangasw/FoodItems/webapi/inventory";
    
    private static RESTRequest sInstance;
    
    public static RESTRequest getInstance(){
        if(sInstance == null){
            sInstance = new RESTRequest();
        }
        
        return sInstance;
    }
    
    private RESTRequest(){
        client = Client.create();
        webResource = client.resource(BASE_URI);
    }
    
    public ServerResponse getFoodItems(ClientRequest clientRequest){
        ClientResponse postResponse = webResource.type(MediaType.APPLICATION_XML).accept(MediaType.APPLICATION_XML).post(ClientResponse.class, clientRequest);
        ServerResponse serverResponse = postResponse.getEntity(ServerResponse.class);
        return serverResponse;
    }
    
    public ServerResponse addFoodItems(ClientRequest clientRequest){
        ClientResponse postResponse = webResource.type(MediaType.APPLICATION_XML).accept(MediaType.APPLICATION_XML).post(ClientResponse.class, clientRequest);
        ServerResponse serverResponse = postResponse.getEntity(ServerResponse.class);
        return serverResponse;
    }
    
    
    
    
}
