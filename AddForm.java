/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectInterface;

import project.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Sean
 */
public class AddForm {
    Controller controller = new Controller();
    JFrame faddForm = new JFrame("Add Product Form");
    JPanel paddForm = new JPanel();
    
       

    /**
     * Constructor
     */
        public AddForm()
    {
        paddForm.setLayout(new GridLayout(6, 0));
        
        final JTextField productName = new JTextField("Product Name"); 
        final JTextField productDescription = new JTextField("Product Description"); 
        final JTextField productQuantity = new JTextField("Product Quantity");        
        final JTextField productSellerPrice = new JTextField("Product Cost");
        final JTextField productPrice = new JTextField("Product selling Price");
        JButton submitBtn = new JButton("Submit Changes");
        
        submitBtn.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e)
            {   
                faddForm.setVisible(false);
                controller.addProductToShop(productName.getText(), productDescription.getText(), Integer.parseInt(productQuantity.getText()), Double.parseDouble(productSellerPrice.getText()), Double.parseDouble(productPrice.getText()));
                
            }
        });
        
        
        paddForm.add(productName);
        paddForm.add(productDescription);
        paddForm.add(productQuantity);
        paddForm.add(productSellerPrice);
        paddForm.add(productPrice);
        paddForm.add(submitBtn);
        
        faddForm.add(paddForm);

        faddForm.pack();
        faddForm.setBackground(Color.white);
        faddForm.setVisible(true);
    }
    
    
}
