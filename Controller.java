/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;


import ProjectInterface.*;
import java.util.ListIterator;

/**
 *
 * @author Rahu;
 */
public class Controller {
    
    

    
    /**
     *    This method checks if the provided username and password correspond
            to a matching user
     * @param username
     * @param password
     */
           public void signIn(String username, String password)
    {
        Users s = Users.findInstance();
        boolean isUser = s.checkUser(username, password);
        boolean isOwner = s.checkIfOwner(username, password);
        if(isOwner)
        {
            User thisUser = s.getUser(username, password);
            new SellerInventory(thisUser);
        }
        else if(isUser)
        {
            User thisUser = s.getUser(username, password);
            new MainShop(thisUser);
                 
        }
    }
    
    //This method adds a new user to a list of users
    /**
     *
     * @param username
     * @param password
     */
        public void newUser(String username, String password)
    {
        Users s = Users.findInstance();
        
        
        User newUser = new User(username, password);
        s.addUser(newUser);
        
        s.saveInstance();
                
        new Home();
    }
    
    //This method creates a new window to review cart information
    /**
     *
     * @param username
     */
        public void reviewCart(String username)
    {
        Users s = Users.findInstance();
        User b = s.getUser(username);
        new ReviewCart(b);
    }
    
    //This method adds a product to the user's shopping cart
    /**
     *
     * @param username
     * @param quantity
     * @param productID
     */
        public void addToCart(String username, int quantity, int productID)
    {
        Users a = Users.findInstance();
        User s = a.getOwner();
        User b = a.getUser(username);
        int q = quantity;
        ListIterator<Product> iter = s.getProductList().listIterator();
        while(iter.hasNext())
        {
            Product p = iter.next();
            int key = productID;
            int PID = p.getID();
            if(PID == key)
            {
                a.updateUser(b, p, q);
                        
                //a.updateSeller(s, p, q);
            }
                        
        }
        new MainShop(b);
    }
    
    //This method creates a window that allows a seller to add a product to their inventory

    /**
     *
     */
        public void addProductForm()
    {
        new AddForm();
    }
    
    //This method takes the data that was input into the AddForm and creates a new product to add to inventory
    /**
     *
     * @param name
     * @param desc
     * @param quantity
     * @param sellerCost
     * @param sellerPrice
     */
        public void addProductToShop(String name, String desc, int quantity, double sellerCost, double sellerPrice)
    {
        Users a = Users.findInstance();
        User s = a.getOwner();
        Product p = new Product(name, sellerCost, sellerPrice, desc, quantity);
        a.addProductToShop(s, p);
        a.saveInstance();
        new SellerInventory(s);
    }
    
    
    //This method creates a window that allows the seller to remove/update a product

    /**
     *
     */
        public void removeProductForm()
    {
        new RemoveForm();
    }
    
    //This method takes the data that was input into the RemoveForm and updates the product for inventory
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
        Users a = Users.findInstance();
        User s = a.getOwner();
        a.updateProduct(s, pID, name, desc, quantity, cost, price);
        a.saveInstance();
        new SellerInventory(s);
    }
    
    //This method creates a new form that allows the user to update products in their shopping cart

    /**
     *
     * @param username
     */
        public void updateCart(String username)
    {
        Users a = Users.findInstance();
        User b = a.getUser(username);
        new UpdateForm(b);
    }
    
    //This method opens a new window that allows the seller to check his/her profits

    /**
     *
     */
            public void checkProfit()
    {
        Users a = Users.findInstance();
        User s = a.getOwner();
        new ProfitForm(s);
    }
    
    //This method sends the user to a checkout page to suppply payment information
    /**
     *
     * @param username
     */
        public void checkout(String username)
    {
        Users s = Users.findInstance();
        User b = s.getUser(username);
        new CheckOut(b);
    }
    
    //This method completes the transaction based on data provided for checkout
    /**
     *
     * @param username
     */
        public void completeTransaction(String username)
    {
        Users a = Users.findInstance();
        User s = a.getOwner();
        User b = a.getUser(username);
        ListIterator<Product> iter = b.getProductList().listIterator();
        while(iter.hasNext())
        {
            Product p = iter.next();
            int quantity = p.getQuantity();
            a.updateSeller(s, p, quantity);
            
        }
        new Receipt(b);
        a.flushCart(b);
    }
    
    //This method updates the users cart with a new provided quantity
    /**
     *
     * @param b
     * @param name
     * @param q
     */
        public void updateCart(User b, String name ,int q)
    {
        Users a = Users.findInstance();
        a.updateCart(b, name, q);
        a.saveInstance();
    }
        
}
