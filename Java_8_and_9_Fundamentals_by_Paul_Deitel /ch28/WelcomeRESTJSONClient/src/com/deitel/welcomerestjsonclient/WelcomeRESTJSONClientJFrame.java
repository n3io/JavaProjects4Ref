// Fig. 31.15: WelcomeRESTJSONClientJFrame.java
// Client that consumes the WelcomeRESTJSON service.
package com.deitel.welcomerestjsonclient;

import com.google.gson.Gson; // converts POJO to JSON and back again
import java.io.InputStreamReader;
import java.net.URL;
import javax.swing.JOptionPane;

public class WelcomeRESTJSONClientJFrame extends javax.swing.JFrame
{
   // no-argument constructor
    public WelcomeRESTJSONClientJFrame()
    {
        initComponents();
    } // end constructor

   // The initComponents method is autogenerated by NetBeans and is called
   // from the constructor to initialize the GUI. This method is not shown
   // here to save space. Open WelcomeRESTJSONClientJFrame.java in this
   // example's folder to view the complete generated code.
    @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      nameJLabel = new javax.swing.JLabel();
      nameJTextField = new javax.swing.JTextField();
      submitJButton = new javax.swing.JButton();

      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

      nameJLabel.setText("Enter your name:");
      nameJLabel.setName("nameJLabel\n"); // NOI18N

      submitJButton.setText("Submit");
      submitJButton.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            submitJButtonActionPerformed(evt);
         }
      });

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                  .addGap(10, 10, 10)
                  .addComponent(nameJLabel)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                  .addComponent(nameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addGroup(layout.createSequentialGroup()
                  .addGap(71, 71, 71)
                  .addComponent(submitJButton)))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(nameJLabel)
               .addComponent(nameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(submitJButton)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );

      pack();
   }// </editor-fold>//GEN-END:initComponents

   // call the web service with the supplied name and display the message
   private void submitJButtonActionPerformed(//GEN-FIRST:event_submitJButtonActionPerformed
      java.awt.event.ActionEvent evt)
   {//GEN-HEADEREND:event_submitJButtonActionPerformed
      String name = nameJTextField.getText(); // get name from JTextField

      // retrieve the welcome string from the web service
      try
      {
         // the URL of the web service
         String url = "http://localhost:8080/WelcomeRESTJSON/" +
            "webresources/welcome/" + name;

         // open URL, using a Reader to convert bytes to chars
         InputStreamReader reader =
            new InputStreamReader(new URL(url).openStream());

         // parse the JSON back into a TextMessage
         TextMessage message =
            new Gson().fromJson(reader, TextMessage.class); 

         // display message to the user
         JOptionPane.showMessageDialog(this, message.getMessage(),
            "Welcome", JOptionPane.INFORMATION_MESSAGE);
      } 
      catch(Exception exception)
      {
         exception.printStackTrace(); // show exception details
      } 
   }//GEN-LAST:event_submitJButtonActionPerformed

   // main method begins execution
   public static void main(String args[])
   {
      java.awt.EventQueue.invokeLater(
         new Runnable()
         {
            public void run()
            {
               new WelcomeRESTJSONClientJFrame().setVisible(true);
            } 
         } 
      );
   } 

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JLabel nameJLabel;
   private javax.swing.JTextField nameJTextField;
   private javax.swing.JButton submitJButton;
   // End of variables declaration//GEN-END:variables
} 

// private class that contains the message we are receiving
class TextMessage
{
   private String message; // message we're receiving

   // returns the message
   public String getMessage()
   {
      return message;
   } 

   // sets the message
   public void setMessage(String value)
   {
      message = value;
   } 
} 

/**************************************************************************
 * (C) Copyright 1992-2014 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/


