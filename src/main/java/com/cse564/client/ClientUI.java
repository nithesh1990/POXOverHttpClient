/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cse564.client;
import com.cse564.asu.edu.Client.Model.FoodItem;
import com.cse564.asu.edu.Client.Model.FoodItemAdded;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nithesh
 */
public class ClientUI {
    
    public static void main(String[] args){
        //1.Add food Item
        FoodItem foodItem = new FoodItem();
        foodItem.setCategory("Dinner");
        foodItem.setCountry("GB");
        foodItem.setName("Cornish Pasty");
        foodItem.setDescription("Tender cubes of steak, potatoes and swede wrapped in flakey short crust pastry.  Seasoned with lots of pepper.  Served with mashed potatoes, peas and a side of gravy");
        foodItem.setPrice("15.95");
        List<FoodItem> foodsList = new ArrayList<FoodItem>();
        foodsList.add(foodItem);
        List<Integer> foodIds = addFoodItems(foodsList);
        
        //2. Get added food item
         getFoodItems(foodIds);
        
         //3. Add same food item again
        foodsList = new ArrayList<FoodItem>();
        foodItem = new FoodItem();
        foodItem.setCategory("Dinner");
        foodItem.setCountry("GB");
        foodItem.setName("Cornish Pasty");
        foodItem.setDescription("Tender cubes of steak, potatoes and swede wrapped in flakey short crust pastry.  Seasoned with lots of pepper.  Served with mashed potatoes, peas and a side of gravy");
        foodItem.setPrice("15.95");
        foodsList = new ArrayList<FoodItem>();
        foodsList.add(foodItem);
        addFoodItems(foodsList);
        
        //4. Add 2 new food items
        FoodItem foodItem2 = new FoodItem();
        foodItem.setCategory("Dinner");
        foodItem.setCountry("GB");
        foodItem.setName("Steak and Kidney Pie");
        foodItem.setDescription("Tender cubes of steak, with tender lamb kidney is succulent rich gravy.  Served with a side of mashed potatoes and peas.");
        foodItem.setPrice("15.95");

        FoodItem foodItem3 = new FoodItem();
        foodItem.setCategory("Lunch");
        foodItem.setCountry("GB");
        foodItem.setName("Halal Sandwich");
        foodItem.setDescription("Tender cubes of steak, with tender lamb kidney is succulent rich gravy.  Served with a side of mashed potatoes and peas.");
        foodItem.setPrice("10.95");

        List<FoodItem> foodsList3 = new ArrayList<>();
        foodsList3.add(foodItem);
        foodsList3.add(foodItem2);
        foodsList3.add(foodItem3);
        
        List<Integer> foodIds2 = addFoodItems(foodsList3);
        
        //5. Get valid food items along with invalid food ids
        foodIds2.add(350);
        getFoodItems(foodIds2);
        
//        FoodItem foodItem = new FoodItem();
//        foodItem.setCategory("Indian");
//        foodItem.setCountry("India");
//        foodItem.setName("Paneer masala");
//        List<FoodItem> foodsList = new ArrayList<FoodItem>();
//        foodsList.add(foodItem);
//        addFoodItems(foodsList);
//        Integer foodId = new Integer("156");
//        List<Integer> foodIds = new ArrayList<Integer>();
//        foodIds.add(foodId);
//        getFoodItems(foodIds);
//        
//        FoodItem foodItem = new FoodItem();
//        foodItem.setCategory("Indian");
//        foodItem.setCountry("India");
//        foodItem.setName("Paneer masala");
//        List<FoodItem> foodsList = new ArrayList<FoodItem>();
//        foodsList.add(foodItem);
//        addFoodItems(foodsList);
//        Integer foodId = new Integer("156");
//        List<Integer> foodIds = new ArrayList<Integer>();
//        foodIds.add(foodId);
//        getFoodItems(foodIds);
                
    }
    
    
    public static void getFoodItems(List<Integer> foodIds){
        ClientInterface clientInterface = ClientInterface.getInstance();
        clientInterface.getFoodItems(foodIds);
        
    }
    
    public static List<Integer> addFoodItems(List<FoodItem> foodItems){
        
        List<Integer> foodIdsList = new ArrayList<>();
        ClientInterface clientInterface = ClientInterface.getInstance();
        List<FoodItemAdded> addedFoodsList = clientInterface.addFoodItems(foodItems);
        if(addedFoodsList != null && addedFoodsList.size()>0){
            for(FoodItemAdded foodAdded : addedFoodsList){
                foodIdsList.add(foodAdded.getFoodItemId());
            }
        }
        return foodIdsList;
    }
}
