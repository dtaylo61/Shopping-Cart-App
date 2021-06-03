/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.Random;

/**
 *
 * @author Sean
 */
public class Product implements java.io.Serializable
{
    
    private String name;
    private double sellerCost;
    private double price;
    private String description;
    private int quantity;
    private final int id;
    
    //Constructor
    /**
     *
     * @param s
     * @param d
     * @param d2
     * @param s2
     * @param q
     */
        public Product(String s, double d, double d2, String s2, int q)
    {
        name = s;
        sellerCost = d;
        price = d2;
        description = s2;
        quantity = q;
        Random ran = new Random();
        id = ran.nextInt(10000) + 10000;
    }
    
    //Secondary constructor in case a new product is needed that shares an ID with another product
    /**
     *
     * @param s
     * @param d
     * @param d2
     * @param s2
     * @param q
     * @param PID
     */
        public Product(String s, double d, double d2, String s2, int q, int PID)
    {
        name = s;
        sellerCost = d;
        price = d2;
        description = s2;
        quantity = q;
        id = PID;
    }
    
    //Accessor for instance variable name

    /**
     *
     * @return
     */
        public String getName()
    {
        return name;
    }
    
    //Accessor for instance variable sellerCost
    /**
     *
     * @return
     */
        public double getSellerCost()
    {
        return this.sellerCost;        
    }
    
    //Accessor for instance variable price
    /**
     *
     * @return
     */
        public double getPrice()
    {
        return price;
    }
    
    //Accessor for instance variable description
    /**
     *
     * @return
     */
        public String getDescription()
    {
        return description;
    }
    
    //Accessor for instance variable description
    /**
     *
     * @return
     */
        public int getQuantity()
    {
        return quantity;
    }
    
    //Accessor for instance variable id
    /**
     *
     * @return
     */
        public int getID()
    {
        return id;
    }
    
    //Provides access to instance variable quantity in order to update it
    /**
     *
     * @param q
     */
        public void changeQuantity(int q)
    {
        quantity = q;
    }
    
    /*public void chosenQuantity(int q)
    {
        quantity = q;
    }*/
    
    //Provides access to instance variable name in order to update it
    /**
     *
     * @param name
     */
        public void changeName(String name)
    {
        this.name = name;
    }
    
    //Provides access to instance variable description in order to update it      
    /**
     *
     * @param desc
     */
        public void changeDesciption(String desc)
    {
        this.description = desc;
    }
    
    //Provides access to instance variable quantity in order to update it
    /**
     *
     * @param q
     */
        public void updateQuantity(int q)
    {
        this.quantity = q;
    }
    
    //Provides access to instance variable cost in order to update it
    /**
     *
     * @param cost
     */
        public void changeCost(double cost)
    {
        this.sellerCost = cost;
    }
    
    //Provides access to instance variable price in order to update it
    /**
     *
     * @param price
     */
        public void changePrice(double price)
    {
        this.price = price;
    }
    
}
