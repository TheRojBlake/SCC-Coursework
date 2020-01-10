package shares_system_client_application;

import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import de.vogella.xml.jaxb.model.Shares;
import de.vogella.xml.jaxb.model.SharesList;
import de.vogella.xml.jaxb.model.SharePrice;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class Shares_Add_Page extends javax.swing.JFrame
{
    public Shares_Add_Page()
    {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Save_Record_Button = new javax.swing.JButton();
        Reset_Page_Button = new javax.swing.JButton();
        Company_Symbol_Text_Field = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Company_Name_Text_Field = new javax.swing.JTextField();
        Share_Amount_Text_Field = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Shares_Currency_Text_Field = new javax.swing.JTextField();
        Share_Update_Date_Chooser = new com.toedter.calendar.JCalendar();
        Share_Price_Value_Text_Field = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel5.setText("Please enter the currency of the share:");

        jLabel6.setText("Please enter the value of the share:");

        jLabel7.setText("Please enter last share update:");

        Save_Record_Button.setText("Save Record");
        Save_Record_Button.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                Save_Record_ButtonActionPerformed(evt);
            }
        });

        Reset_Page_Button.setText("Reset Page");

        Company_Symbol_Text_Field.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                Company_Symbol_Text_FieldKeyTyped(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Shares Entry");

        jLabel2.setText("Please enter company name:");

        jLabel3.setText("Please enter company symbol:");

        Company_Name_Text_Field.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                Company_Name_Text_FieldKeyTyped(evt);
            }
        });

        Share_Amount_Text_Field.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                Share_Amount_Text_FieldKeyTyped(evt);
            }
        });

        jLabel4.setText("Please enter num of shares:");

        Shares_Currency_Text_Field.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                Shares_Currency_Text_FieldKeyTyped(evt);
            }
        });

        Share_Price_Value_Text_Field.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                Share_Price_Value_Text_FieldKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Company_Name_Text_Field, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Share_Amount_Text_Field, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Company_Symbol_Text_Field, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addComponent(Shares_Currency_Text_Field, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(Save_Record_Button)
                                .addGap(82, 82, 82)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(Reset_Page_Button)
                                .addGap(74, 74, 74))
                            .addComponent(Share_Price_Value_Text_Field, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Share_Update_Date_Chooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)))
                .addGap(41, 41, 41))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(215, 215, 215))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Company_Name_Text_Field, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(Company_Symbol_Text_Field, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(Share_Amount_Text_Field, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(Shares_Currency_Text_Field, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(Share_Price_Value_Text_Field, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addGap(85, 85, 85))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(Share_Update_Date_Chooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Save_Record_Button)
                    .addComponent(Reset_Page_Button))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Save_Record_ButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_Save_Record_ButtonActionPerformed
    {//GEN-HEADEREND:event_Save_Record_ButtonActionPerformed
        if ((Company_Name_Text_Field.getText().isEmpty() == true) || 
                (Company_Symbol_Text_Field.getText().isEmpty() == true) ||
                (Share_Amount_Text_Field.getText().isEmpty() == true) || 
                (Shares_Currency_Text_Field.getText().isEmpty() == true) ||
                (Share_Price_Value_Text_Field.getText().isEmpty() == true))
        {
            String titleBar = "save button";
            String infoMessage = "One of your strings are empty. Please correct this and try again.";
            JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
        }
        
        else
        {                                         
            File Shares_File = new File("Shares_Data.xml");
            
            ArrayList<Shares> shareList = new ArrayList<Shares>();

            // create books
            Shares share1 = new Shares();
            SharePrice share1_2 = new SharePrice();
            share1.setCompanyName(Company_Name_Text_Field.getText());
            share1.setCompanySymbol(Company_Symbol_Text_Field.getText());
            
            int nos = Integer.parseInt(Share_Amount_Text_Field.getText());
            share1.setNumOfShares(nos);

            Date date = Share_Update_Date_Chooser.getDate();
            share1.setLastShareUpdate(date);
            
            share1_2.setCurrency(Shares_Currency_Text_Field.getText());
            
            String a = Share_Price_Value_Text_Field.getText();//Create a string to store the incoming data
            float f = Float.parseFloat(a);// to cast the data
            share1_2.setValue(f);
            share1.setSharePrice(share1_2);

            //Add 1st new entry to book list
            shareList.add(share1);
            
            SharesList sharelist = new SharesList();
            sharelist.setBookList(shareList);

            //Marshelling code
            try 
            {   
                //The JAXBContext class provides the client's entry point to the JAXB API
                JAXBContext context = JAXBContext.newInstance(SharesList.class);
                Marshaller m = context.createMarshaller();
                m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);                     
                
                Unmarshaller um = context.createUnmarshaller();
                SharesList sharelist2 = (SharesList) um.unmarshal(Shares_File);
                ArrayList<Shares> unmarshlist = sharelist2.getBooksList();
        
                shareList.addAll(unmarshlist);
                
                m.marshal(sharelist, Shares_File);
                 
                System.out.println("Record has been added");
            }

            catch (javax.xml.bind.JAXBException ex) 
            {            
                java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex); //NOI18N
                Logger.getLogger(Shares_Add_Page.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }//GEN-LAST:event_Save_Record_ButtonActionPerformed

    private void Company_Name_Text_FieldKeyTyped(java.awt.event.KeyEvent evt)//GEN-FIRST:event_Company_Name_Text_FieldKeyTyped
    {//GEN-HEADEREND:event_Company_Name_Text_FieldKeyTyped
        String Entered_Text =  Company_Name_Text_Field.getText();
        int Text_Length = Entered_Text.length();
        
        char c = evt.getKeyChar();       
        
        if (!(Character.isLetter(c)) || (c==KeyEvent.VK_BACK_SPACE) || 
                (c==KeyEvent.VK_DELETE) || (Text_Length >= 30))
        {
            evt.consume();
        }         
    }//GEN-LAST:event_Company_Name_Text_FieldKeyTyped

    private void Company_Symbol_Text_FieldKeyTyped(java.awt.event.KeyEvent evt)//GEN-FIRST:event_Company_Symbol_Text_FieldKeyTyped
    {//GEN-HEADEREND:event_Company_Symbol_Text_FieldKeyTyped
        String Entered_Text =  Company_Name_Text_Field.getText();
        int Text_Length = Entered_Text.length();
        
        char c = evt.getKeyChar();       
        
        if (!(Character.isLetter(c)) || (c==KeyEvent.VK_BACK_SPACE) || 
                (c==KeyEvent.VK_DELETE) || (Text_Length >= 30))
        {
            evt.consume();
        }
    }//GEN-LAST:event_Company_Symbol_Text_FieldKeyTyped

    private void Share_Amount_Text_FieldKeyTyped(java.awt.event.KeyEvent evt)//GEN-FIRST:event_Share_Amount_Text_FieldKeyTyped
    {//GEN-HEADEREND:event_Share_Amount_Text_FieldKeyTyped
        char c = evt.getKeyChar();
        
        if (!(Character.isDigit(c)) || (c==KeyEvent.VK_BACK_SPACE) || 
                (c==KeyEvent.VK_DELETE))
        {
            evt.consume();           
        }
        
        String Entered_Text =  Share_Amount_Text_Field.getText();
        int Text_Length = Entered_Text.length();
        
        if (Text_Length >= 5)
        {
            evt.consume();
        } 
        
    }//GEN-LAST:event_Share_Amount_Text_FieldKeyTyped

    private void Shares_Currency_Text_FieldKeyTyped(java.awt.event.KeyEvent evt)//GEN-FIRST:event_Shares_Currency_Text_FieldKeyTyped
    {//GEN-HEADEREND:event_Shares_Currency_Text_FieldKeyTyped
        String Entered_Text =  Shares_Currency_Text_Field.getText();
        int Text_Length = Entered_Text.length();
        
        char c = evt.getKeyChar();       
        
        if (!(Character.isLetter(c)) || (c==KeyEvent.VK_BACK_SPACE) || 
                (c==KeyEvent.VK_DELETE) || (Text_Length >= 20))
        {
            evt.consume();
        }
    }//GEN-LAST:event_Shares_Currency_Text_FieldKeyTyped

    private void Share_Price_Value_Text_FieldKeyTyped(java.awt.event.KeyEvent evt)//GEN-FIRST:event_Share_Price_Value_Text_FieldKeyTyped
    {//GEN-HEADEREND:event_Share_Price_Value_Text_FieldKeyTyped
        String Entered_Text =  Share_Price_Value_Text_Field.getText();
        int Text_Length = Entered_Text.length();
        
        char c = evt.getKeyChar();       
        
        if (Character.isLetter(c) || (c==KeyEvent.VK_BACK_SPACE) || 
                (c==KeyEvent.VK_DELETE) || (Text_Length >= 8))
        {
            evt.consume();
        }
    }//GEN-LAST:event_Share_Price_Value_Text_FieldKeyTyped

    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Shares_Add_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Shares_Add_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Shares_Add_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Shares_Add_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new Shares_Add_Page().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Company_Name_Text_Field;
    private javax.swing.JTextField Company_Symbol_Text_Field;
    private javax.swing.JButton Reset_Page_Button;
    private javax.swing.JButton Save_Record_Button;
    private javax.swing.JTextField Share_Amount_Text_Field;
    private javax.swing.JFormattedTextField Share_Price_Value_Text_Field;
    private com.toedter.calendar.JCalendar Share_Update_Date_Chooser;
    private javax.swing.JTextField Shares_Currency_Text_Field;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables
}
