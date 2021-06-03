package project;

import ProjectInterface.Home;
import project.Product;
import project.User;
import project.Users;
import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.*;

/**
 *
 * @author Sean
 */
public class GoShop {

    /**
     *
     * @param args
     */
    public static void main (String [] args) {
      

        /*Users s = new Users();
        User sean = new User("sean", "kotowich", true);
        s.addUser(sean);
        s.saveInstance();
        
        
        Product p = new Product("Cup", 2.45, 3.13, "Small 7oz cup", 6);
        s.updateUser(sean ,p, p.getQuantity());
        p = new Product("Saw", 8.17, 15.89, "Durable steel saw", 4);
        s.updateUser(sean ,p, p.getQuantity());
  
        User sean1 = new User("sean1", "kotowich", false);
        s.addUser(sean1);
        s.saveInstance();*/
        
        
        
        
        
        new Home();
    }
}
