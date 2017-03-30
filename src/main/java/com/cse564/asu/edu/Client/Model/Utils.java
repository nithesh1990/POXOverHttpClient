/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cse564.asu.edu.Client.Model;

/**
 *
 * @author nithesh
 */
public class Utils {
       public abstract class ResponseCodes {
       
       public static final int ADD_FOOD_ITEM = 1001;

       public static final int GET_FOOD_ITEM = 1003;

       public static final int INVALID_MESSAGE = 1010;
        
    }
    
    public abstract class RequestCodes {
        public static final int ADD_FOOD_ITEM = 2001;
        
        public static final int GET_FOOD_ITEM = 2002;
    }

    
}
