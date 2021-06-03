/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import project.Product;
import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Sean
 */
public class ShoppingCart implements java.io.Serializable
{
    private LinkedList<Product> cartList = new LinkedList<>();
    private double total = 0;
    
    ShoppingCart()
    {
        
    }
    
    //Allows user to add a Product to their shopping cart while updating the total
    /**
     *
     * @param p
     * @param q
     */
        public void addToCart(Product p, int q)
    {
        
        
        this.cartList.add(p);
        total += q*p.getPrice();
        JOptionPane.showMessageDialog(null, "Added " + q + " " + p.getName(), "Success", JOptionPane.WARNING_MESSAGE );
        
        
    }
 
    //Accessor to instance variable total
    /**
     *
     * @return
     */
        public double getTotal()
    {
        return total;
    }
    
    //Accessor to instance variable cartList
    /**
     *
     * @return
     */
        public LinkedList<Product> getList()
    {
        return cartList;
    }
    
    //Provides access to products contained in the cartList for updating
    /**
     *
     * @param p
     * @param q
     */
        public void updateProductList(Product p, int q)
    {
        p.changeQuantity(q);
    }
    
    //Deletes all elements in the cartList after transaction is completed
    /**
     *
     */
        public void refreshCart()
    {
       while(!cartList.isEmpty())
       {
           cartList.removeFirst();
       }
       
       total = 0;
       
    }
    
    /**
     *
     * @param p
     */
    public void addToCart(Product p)
    {
        cartList.add(p);
        total += p.getPrice();
    }
    
    //finds the product that needs updating and calls another method
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
        Iterator<Product> iter = cartList.listIterator();
        while(iter.hasNext())
        {
            Product p = iter.next();
            if(p.getID() == pID)
            {
                updateFoundProduct(p, name, desc, quantity, cost, price);
            }
            
        }
    }
    
    //provides access to the cartList in order to make adjustments
    /**
     *
     * @param p
     * @param name
     * @param desc
     * @param quantity
     * @param cost
     * @param price
     */
        public void updateFoundProduct(Product p, String name, String desc, int quantity, double cost, double price)
    {
        if(name != null)
        {
            p.changeName(name);
        }
        if(desc != null)
        {
            p.changeDesciption(desc);
        }
        if(quantity >= 0)
        {
            p.updateQuantity(quantity);
        }
        if(cost >= 0)
        {
            p.changeCost(cost);
        }
        if(price >= 0)
        {
            p.changePrice(price);
        }
    }
    
    //Provides access to the cartList to change an elements quantity
    /**
     *
     * @param name
     * @param q
     */
        public void updateCartQuantity(String name, int q)
    {
        Iterator<Product> iter = cartList.listIterator();
        while(iter.hasNext())
        {
            Product p1 = iter.next();
            if(p1.getName().equals(name))
            {
                p1.changeQuantity(q);
                total -= (p1.getQuantity() * p1.getPrice());
            }
        }
    }
}
