/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import project.Product;
import java.util.*;
/**
 *
 * @author Sean
 */
public class User implements java.io.Serializable
{
    private final String userName;
    private final String password;
    private ShoppingCart cart = new ShoppingCart();
    private boolean isOwner = false;
    private double profit = 0;
    private double revenue = 0;
    private double costs = 0;
    
    //Constructor for buyer
    /**
     *
     * @param s
     * @param s2
     */
        public User(String s, String s2)
    {
        userName = s;
        password = s2;
    }
    
    //Constructor for seller
    /**
     *
     * @param s
     * @param s2
     * @param u
     */
        public User(String s, String s2, boolean u)
    {
        userName = s;
        password = s2;
        isOwner = u;
    }
    
    //Used by a buyer
    //Provides access to the instance variable ShoppingCart in order to add a product to the shopping cart
    /**
     *
     * @param p
     * @param q
     */
        public void addProduct(Product p, int q)
    {
        
        //p.quantity = q;
        Product p1 = new Product(p.getName(), p.getSellerCost(), p.getPrice(), p.getDescription(), q, p.getID());
        this.cart.addToCart(p1, q);
        
    }
    
    //User by a seller
    //Provides access to the seller's inventory in order to add new products
    /**
     *
     * @param p
     */
        public void addProduct(Product p)
    {
        cart.addToCart(p);
    }
        
    //Accessor for instance variable userName
    /**
     *
     * @return
     */
        public String getUsername()
    {
        return userName;
    }
    
    //Accessor for instance variable password
    /**
     *
     * @return
     */
        public String getPassword()
    {
        return password;
    }
    
    //Accessor for instance variable isOwner
    /**
     *
     * @return
     */
        public boolean getIsOwner()
    {
        return isOwner;
    }
    
    //Accessor for instance variable cart
    /**
     *
     * @return
     */
        public LinkedList<Product> getProductList()
    {
        return cart.getList();
    }
    
    //Provides access to the instance variable cart to make changes
    /**
     *
     * @param p
     * @param q
     */
        public void updateQuantity(Product p, int q)
    {
        cart.updateProductList(p, q);
    }
    
    //Provides access to the instance variable profit to make changes
    /**
     *
     * @param p
     * @param q
     */
        public void updateProfit(Product p, int q)
    {
        this.profit += q * (p.getPrice() - p.getSellerCost());
    }
    
    //Accesor for instance variable profit
    /**
     *
     * @return
     */
        public double getProfit()
    {
        return profit;
    }
    
    //Provides access to the instance variable cart to erase data
    /**
     *
     */
        public void removeCart()
    {
        cart.refreshCart();
        
    }
    
    //provides access to the instance variable cart to update
    /**
     *
     * @param pID
     * @param name
     * @param desc
     * @param quantity
     * @param cost
     * @param price
     */
        public void updateProduct(int pID, String name, String desc, int quantity, double cost, double price)
    {
        cart.updateProduct(pID, name, desc, quantity, cost, price);
    }
    
    //accessor for instance variable total
    /**
     *
     * @return
     */
        public double getTotal()
    {
        return cart.getTotal();
    }
    
    //accessor for instance variable costs
    /**
     *
     * @return
     */
        public double getCosts()
    {
        return costs;
    }
    
    //accessor for instance variable revenue
    /**
     *
     * @return
     */
        public double getRevenue()
    {
        return revenue;
    }
    
    //provides access to instance variable costs to update
    /**
     *
     * @param p
     * @param q
     */
        public void updateCosts(Product p, int q)
    {
        costs += (p.getSellerCost() * q);
    }
    
    //provides access to instance variable revenue to update
    /**
     *
     * @param p
     * @param q
     */
        public void updateRevenue(Product p, int q)
    {
        revenue += (p.getPrice() * q);
    }
    
    //provides access to instance variable cart to update a product quantity
    /**
     *
     * @param name
     * @param q
     */
        public void updateCartQuantity(String name, int q)
    {
        cart.updateCartQuantity(name, q);
    }
}
