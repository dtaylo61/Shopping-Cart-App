package ProjectInterface;

import project.Controller;
import project.Users;
import project.User;
import project.Product;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 *
 * @author Donte'
 */
public class MainShop {
    Controller controller = new Controller();
    Product[] productArray;
    Product p;
    JTextField[] quantityArray;
    JFrame fMainShop = new JFrame("G19 Shopping: Main Shop");
    JPanel pMainShop = new JPanel();
    JLabel headerMS = new JLabel("G19 Shopping");
    JLabel lMainShop = new JLabel("Products");
    JLabel prod = new JLabel("Product Name");
    JLabel desc = new JLabel("Description");
    JLabel prodID = new JLabel("Product ID");
    JLabel qtyInStk = new JLabel("Quantity in Stock");
    JLabel prc = new JLabel("Price");
    JLabel tot = new JLabel("TOTAL");
    int i2;
    
    final JTextField addToCartText = new JTextField("product id", 20);
    final JTextField quantityToAddText = new JTextField("quantity", 20);
    JTextField quantity;
    
    
    //JButton addBtn = new JButton("Add to Cart");
    JButton checkoutBtn = new JButton("Review Cart/Checkout");
    JButton logout = new JButton("Logout");
    JButton addBtn = new JButton("Add");
    
    /**
     *
     * @param me
     */
    public MainShop(User me) {
        
       


        
        
        
        pMainShop.setLayout(new GridBagLayout());
        GridBagConstraints cMainShop = new GridBagConstraints();
        cMainShop.fill = GridBagConstraints.HORIZONTAL;
        cMainShop.insets = new Insets(20, 20, 20, 20);
        
        cMainShop.gridwidth = 5;
        cMainShop.gridx = 0;
        cMainShop.gridy = 0;
        headerMS.setHorizontalAlignment(JLabel.CENTER);
        headerMS.setFont(new Font("Arial", Font.BOLD, 70));
        pMainShop.add(headerMS, cMainShop);
        
        cMainShop.gridwidth = 5;
        cMainShop.gridx = 0;
        cMainShop.gridy = 1;
        lMainShop.setHorizontalAlignment(JLabel.CENTER);
        lMainShop.setFont(new Font("Arial", Font.PLAIN, 50));
        pMainShop.add(lMainShop, cMainShop); 
        
        cMainShop.gridwidth = 0;
        cMainShop.gridx = 0;
        cMainShop.gridy = 1;
        final JLabel userName = new JLabel (me.getUsername());
        cMainShop.anchor = GridBagConstraints.NORTHWEST;
        userName.setFont(new Font("Arial", Font.PLAIN, 40));
        pMainShop.add(userName, cMainShop);
        
        cMainShop.gridwidth = 1;
        cMainShop.gridx = 0;
        cMainShop.gridy = 2;
        addToCartText.setHorizontalAlignment(JLabel.CENTER);
        addToCartText.setFont(new Font("Arial", Font.PLAIN, 30));
        //pMainShop.add(addToCartText, cMainShop); 
        
        cMainShop.gridwidth = 1;
        cMainShop.gridx = 0;
        cMainShop.gridy = 3;
        quantityToAddText.setHorizontalAlignment(JLabel.CENTER);
        quantityToAddText.setFont(new Font("Arial", Font.PLAIN, 30));
        //pMainShop.add(quantityToAddText, cMainShop); 
        
        cMainShop.gridwidth = 1;
        cMainShop.gridheight = 2;
        cMainShop.gridx = 1;
        cMainShop.gridy = 2;
        cMainShop.ipady = 65;
        addBtn.setHorizontalAlignment(JLabel.CENTER);
        addBtn.setFont(new Font("Arial", Font.PLAIN, 40));
        /*pMainShop.add(addBtn, cMainShop); 
        addBtn.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e)
            {
                fMainShop.setVisible(false);
                controller.addToCart(userName.getText(), Integer.parseInt(quantityToAddText.getText()), Integer.parseInt(addToCartText.getText()));
                
            }
            });
        */
        cMainShop.gridwidth = 1;
        cMainShop.gridx = 2;
        cMainShop.gridy = 2;
        tot.setHorizontalAlignment(JLabel.CENTER);
        tot.setFont(new Font("Arial", Font.BOLD, 30));
        pMainShop.add(tot, cMainShop);
        
        cMainShop.gridwidth = 1;
        cMainShop.gridx = 2;
        cMainShop.gridy = 3;
        JLabel total = new JLabel("$" + me.getTotal());
        total.setHorizontalAlignment(JLabel.CENTER);
        total.setFont(new Font("Arial", Font.BOLD, 30));
        pMainShop.add(total, cMainShop);
        
        cMainShop.gridwidth = 1;
        cMainShop.gridheight = 1;
        cMainShop.gridx = 3;
        cMainShop.gridy = 3;
        cMainShop.ipady = 65;
        checkoutBtn.setHorizontalAlignment(JLabel.CENTER);
        checkoutBtn.setFont(new Font("Arial", Font.PLAIN, 16));
        pMainShop.add(checkoutBtn, cMainShop);
        checkoutBtn.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e)
            {
                controller.reviewCart(userName.getText());
                fMainShop.setVisible(false);
            }
            });
        
        cMainShop.gridwidth = 1;
        cMainShop.gridx = 0;
        cMainShop.gridy = 4;
        prod.setHorizontalAlignment(JLabel.CENTER);
        prod.setFont(new Font("Arial", Font.BOLD, 25));
        pMainShop.add(prod, cMainShop);
        
        cMainShop.gridwidth = 1;
        cMainShop.gridx = 1;
        cMainShop.gridy = 4;
        desc.setHorizontalAlignment(JLabel.CENTER);
        desc.setFont(new Font("Arial", Font.BOLD, 25));
        pMainShop.add(desc, cMainShop);
        /*
        cMainShop.gridwidth = 1;
        cMainShop.gridx = 2;
        cMainShop.gridy = 4;
        prodID.setHorizontalAlignment(JLabel.CENTER);
        prodID.setFont(new Font("Arial", Font.BOLD, 25));
        pMainShop.add(prodID, cMainShop);
        */
        cMainShop.gridwidth = 1;
        cMainShop.gridx = 2;
        cMainShop.gridy = 4;
        qtyInStk.setHorizontalAlignment(JLabel.CENTER);
        qtyInStk.setFont(new Font("Arial", Font.BOLD, 25));
        pMainShop.add(qtyInStk, cMainShop);
        
        cMainShop.gridwidth = 1;
        cMainShop.gridx = 3;
        cMainShop.gridy = 4;
        prc.setHorizontalAlignment(JLabel.CENTER);
        prc.setFont(new Font("Arial", Font.BOLD, 25));
        pMainShop.add(prc, cMainShop);
        
        Users a = Users.findInstance();
        User s = a.getOwner();
        int size = s.getProductList().size();
        
        quantityArray = new JTextField[size];
        for(int i = 0; i < size; i++)
        {
            quantityArray[i] = new JTextField("Quantity");
            quantityArray[i].setMinimumSize(new Dimension(50, 10));
        }
        
        ListIterator<Product> iter = s.getProductList().listIterator();
        productArray = new Product[size];
        for(int i = 0; i < size; i++)
        {
            
            Product p1 = iter.next();
            productArray[i] = p1;

        }
        
        
        JButton[] addArray = new JButton[size];
        for(int i = 0; i < size; i ++)
        {
            final int i1 = i;
            addArray[i] = new JButton("add");
            addArray[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e)
                {   
                    Product p = productArray[i1];
                    controller.addToCart(userName.getText(), Integer.parseInt(quantityArray[i1].getText()), productArray[i1].getID() );
                    fMainShop.setVisible(false);
                }
                });
        }
        
        

                
      

        ListIterator<Product> listIterator = s.getProductList().listIterator();
        int x = 0;
        int y = 5;
        int i = 0;
        while(listIterator.hasNext())
        {
            final LinkedList<Product> list = s.getProductList();
            
            p = listIterator.next();
            
            if(p.getQuantity() > 0)
            {
                JLabel productName = new JLabel(p.getName());
                JLabel productDescription = new JLabel(p.getDescription());
                JLabel productID = new JLabel(Integer.toString(p.getID()));
                JLabel productQuantity = new JLabel(Integer.toString(p.getQuantity()));
                JLabel productPrice = new JLabel(Double.toString(p.getPrice()));
                          
                cMainShop.gridwidth = 1;
                cMainShop.gridx = x;
                cMainShop.gridy = y;
                productName.setHorizontalAlignment(JLabel.CENTER);
                productName.setFont(new Font("Arial", Font.PLAIN, 25));
                pMainShop.add(productName, cMainShop);
                x++;
                
                cMainShop.gridwidth = 1;
                cMainShop.gridx = x;
                cMainShop.gridy = y;
                productDescription.setHorizontalAlignment(JLabel.CENTER);
                productDescription.setFont(new Font("Arial", Font.PLAIN, 25));
                pMainShop.add(productDescription, cMainShop);
                x++;  
                
                /*cMainShop.gridwidth = 1;
                cMainShop.gridx = x;
                cMainShop.gridy = y;
                productID.setHorizontalAlignment(JLabel.CENTER);
                productID.setFont(new Font("Arial", Font.PLAIN, 25));
                pMainShop.add(productID, cMainShop);
                x++;*/
                
                cMainShop.gridwidth = 1;
                cMainShop.gridx = x;
                cMainShop.gridy = y;
                productQuantity.setHorizontalAlignment(JLabel.CENTER);
                productQuantity.setFont(new Font("Arial", Font.PLAIN, 25));
                pMainShop.add(productQuantity, cMainShop);
                x++;
                
                cMainShop.gridwidth = 1;
                cMainShop.gridx = x;
                cMainShop.gridy = y;
                productPrice.setHorizontalAlignment(JLabel.CENTER);
                productPrice.setFont(new Font("Arial", Font.PLAIN, 25));
                pMainShop.add(productPrice, cMainShop);
                x++;
                
                cMainShop.gridwidth = 1;
                cMainShop.gridheight = 1;
                cMainShop.gridx = x;
                cMainShop.gridy = y;
                quantity = new JTextField("Quantity");
                pMainShop.add(quantityArray[i], cMainShop);
                x++;
                
             
                cMainShop.gridwidth = 1;
                cMainShop.gridx = x;
                cMainShop.gridy = y;
                pMainShop.add(addArray[i], cMainShop);

                y++;
                i++;
                x=0;
            }
        }
        
        cMainShop.gridx = 5;
        cMainShop.gridy = 1;
        logout.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e)
            {   
                fMainShop.setVisible(false);
                Users a = Users.findInstance();
                a.saveInstance();
                new Home();
                
            }
        });
        
        
   
        
        
        
        
        pMainShop.setBackground(Color.yellow);
        
        /* For JFrame */
        pMainShop.add(logout);
        fMainShop.add(pMainShop);

        fMainShop.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fMainShop.setSize(2000, 1000);;
        fMainShop.setBackground(Color.white);
        fMainShop.setVisible(true);    
    }
}
