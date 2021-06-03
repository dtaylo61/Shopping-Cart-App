/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import project.User;
import project.Product;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;
/**
 *
 * @author Sean
 */
public class Users implements java.io.Serializable
{
    private LinkedList<User> list = new LinkedList<>();
    
    /**
     *
     */
    public Users()
    {
        
    }
    
    //Used for serializing the class Users
    /**
     *
     */
        public void saveInstance()
    {
        try
                {
                    FileOutputStream fileout = new FileOutputStream("users.ser");
                    ObjectOutputStream out = new ObjectOutputStream(fileout);
                    out.writeObject(this);
                    out.flush();
                    out.close();
                    fileout.close();
                }catch(IOException i)
                {
                
                }
    }
    
    //Used for deserializing the class Users
    /**
     *
     * @return
     */
        public static Users findInstance()
    {
        Users s = null;
        try
        {
            FileInputStream fileIn = new FileInputStream("users.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            s = (Users) in.readObject();
            in.close();
            fileIn.close();
            }catch(IOException | ClassNotFoundException i)
            {
                System.out.println(i);
            }
        return s;
    }
    
    //determines if the login credentials match an existing user
    /**
     *
     * @param s
     * @param s1
     * @return
     */
        public boolean checkUser(String s, String s1)
    {
              
        
        ListIterator<User> listIterator = list.listIterator();
        String username;
        String password;
        while(listIterator.hasNext())
        {
            User user = listIterator.next();
            username = user.getUsername();
            password = user.getPassword();
            if((username.equals(s)) && (password.equals(s1)))
            {
                return true;
            }
        }
        return false;
    }
    
    //determines if the user is an owner
    /**
     *
     * @param s
     * @param s1
     * @return
     */
        public boolean checkIfOwner(String s, String s1)
    {
        ListIterator<User> listIterator = list.listIterator();
        String username;
        String password;
        while(listIterator.hasNext())
        {
            User user = listIterator.next();
            username = user.getUsername();
            password = user.getPassword();
            if((username.equals(s)) && (password.equals(s1)) && user.getIsOwner())
            {
                return true;
            }
        }
        return false;
    }
    
    //retrieves a User based on username and password
    /**
     *
     * @param s
     * @param s1
     * @return
     */
        public User getUser(String s, String s1)
    {
        ListIterator<User> listIterator = list.listIterator();
        String username;
        String password;
        while(listIterator.hasNext())
        {
            User user = listIterator.next();
            username = user.getUsername();
            password = user.getPassword();
            if((username.equals(s)) && (password.equals(s1)))
            {
                return user;
            }
            
        }
        return null;
    }
    
    //retrieves a User based on username
    /**
     *
     * @param s
     * @return
     */
        public User getUser(String s)
    {
        ListIterator<User> listIterator = list.listIterator();
        String username;
        while(listIterator.hasNext())
        {
            User user = listIterator.next();
            username = user.getUsername();
            if((username.equals(s)))
            {
                return user;
            }
            
        }
        return null;        
    }
    
    //Retrieves the User that is also the owner of the shop
    /**
     *
     * @return
     */
        public User getOwner()
    {
        ListIterator<User> listIterator = list.listIterator();
        String name = "sean";
        while(listIterator.hasNext())
        {
            User user = listIterator.next();
            if(name.equals(user.getUsername()))
            {
                return user;
            }
        }
        return null;
    }
    
    //adds user credentials to the list of users
    /**
     *
     * @param u
     */
        public void addUser(User u)
    {
        list.add(u);
    }
    
    //provides the ability to update a users cart with new products
    /**
     *
     * @param u
     * @param p
     * @param q
     */
        public void updateUser(User u, Product p, int q)
    {
        //p.chosenQuantity(q);
        u.addProduct(p, q);
        saveInstance();
    }
    
    //provides the ability to update the sellers inventory based on purchases
    /**
     *
     * @param u
     * @param p
     * @param q
     */
        public void updateSeller(User u, Product p, int q)
    {
        ListIterator<Product> iter = u.getProductList().listIterator();
        while(iter.hasNext())
        {
            Product p1 = iter.next();
            if(p1.getID() == p.getID())
            {
                u.updateQuantity(p1, q);
                u.updateProfit(p1, q);
                u.updateCosts(p1, q);
                u.updateRevenue(p1, q);
                saveInstance();
            }
        }

    }
    
    //Provides access to the owner in order to acquire their earned profits
    /**
     *
     * @param u
     */
        public void getProfit(User u)
    {
        u.getProfit();
    }
    
    //Refreshes the user's cart after purchase is completed
    /**
     *
     * @param u
     */
        public void flushCart(User u)
    {
        u.removeCart();        
        saveInstance();
    }
    
    //Allows the owner to add a product to their inventory
    /**
     *
     * @param s
     * @param p
     */
        public void addProductToShop(User s, Product p)
    {
        s.addProduct(p);
    }
    
    //Allows the owner to update their products in inventory
    /**
     *
     * @param s
     * @param pID
     * @param name
     * @param desc
     * @param quantity
     * @param cost
     * @param price
     */
        public void updateProduct(User s, int pID, String name, String desc, int quantity, double cost, double price)
    {
        s.updateProduct(pID, name, desc, quantity, cost, price);
        saveInstance();
    }
    
    //Allows a buyer to update products in their cart (quantity)
    /**
     *
     * @param b
     * @param name
     * @param q
     */
        public void updateCart(User b, String name, int q)
    {
        b.updateCartQuantity(name, q);
        
    }
            
    
 
    
    
    
    
}
