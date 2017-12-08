/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package point.of.sale.system;

import java.io.FileReader;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author tyk54
 */
public class ReturnPage extends javax.swing.JFrame {
    private String tranID;
    /**
     * Creates new form ReturnPage
     */
    public ReturnPage(String tranID) {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        
        this.tranID = tranID;
        this.returnTrans(tranID);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    public void returnTrans(String transNum){
        JSONParser parser = new JSONParser();
	long appleNum=0,bananaNum=0,cherryNum=0;
        try {
			
		Object obj = parser.parse(new FileReader("/Users/hunk/Java WorkSpace/transaction/" + transNum+".json"));
			
		JSONObject jobj = (JSONObject)obj;
			
		 appleNum = (long) jobj.get("apple");
		 bananaNum = (long) jobj.get("banana");
		 cherryNum = (long) jobj.get("cherry");
            }
	catch(Exception e) {e.printStackTrace();}
        appleAmt.setText(appleNum+"");
        bananaAmt.setText(bananaNum+"");
        cherryAmt.setText(cherryNum+"");
        tranNum.setText("transaction: " +tranID);
        System.out.print(tranID);
        
    }
    
    public void updateInventory(){
        int appleNum = 0,bananaNum = 0,cherryNum = 0;
        long appleNum_inv =0,bananaNum_inv = 0,cherryNum_inv = 0;
        if((appleReturn.getText().matches("\\D+")) || appleReturn.getText().equals("")){
                JOptionPane.showMessageDialog(null, "input invalid", "WARNING_MESSAGE",JOptionPane.WARNING_MESSAGE);
            }
        else if((bananaReturn.getText().matches("\\D+")) || bananaReturn.getText().equals("")){
                JOptionPane.showMessageDialog(null, "input invalid", "WARNING_MESSAGE",JOptionPane.WARNING_MESSAGE);
            }
        else if((cherryReturn.getText().matches("\\D+")) || cherryReturn.getText().equals("")){
                JOptionPane.showMessageDialog(null, "input invalid", "WARNING_MESSAGE",JOptionPane.WARNING_MESSAGE);
            }
        else{
             appleNum = Integer.parseInt(appleReturn.getText());
              bananaNum = Integer.parseInt(bananaReturn.getText());
                  cherryNum = Integer.parseInt(cherryReturn.getText());
        
            JSONParser parser = new JSONParser();
            try {
			
                Object obj = parser.parse(new FileReader("/Users/hunk/Java WorkSpace/inventory/info.json"));	
		JSONObject jobj = (JSONObject)obj;	
                appleNum_inv = (long) jobj.get("apple");
		bananaNum_inv = (long) jobj.get("banana");
		cherryNum_inv = (long) jobj.get("cherry");
                    }
              catch(Exception e) {e.printStackTrace();}
        
             appleNum_inv = appleNum_inv + appleNum;
             bananaNum_inv = bananaNum_inv + bananaNum;
            cherryNum_inv = cherryNum_inv + cherryNum;
        
             JsonWR inventoryChange = new JsonWR();
            inventoryChange.inventoryWrite(inventoryChange.json_obj(appleNum_inv, bananaNum_inv, cherryNum_inv));
        }
        
    }
    
    public void updateTransaction(String transNum){
        int appleNum = 0,bananaNum = 0,cherryNum = 0;
        long appleNum_inv =0,bananaNum_inv = 0,cherryNum_inv = 0;
        if((appleReturn.getText().matches("\\D+")) || appleReturn.getText().equals("")){
                JOptionPane.showMessageDialog(null, "input invalid", "WARNING_MESSAGE",JOptionPane.WARNING_MESSAGE);
            }
        else if((bananaReturn.getText().matches("\\D+")) || bananaReturn.getText().equals("")){
                JOptionPane.showMessageDialog(null, "input invalid", "WARNING_MESSAGE",JOptionPane.WARNING_MESSAGE);
            }
        else if((cherryReturn.getText().matches("\\D+")) || cherryReturn.getText().equals("")){
                JOptionPane.showMessageDialog(null, "input invalid", "WARNING_MESSAGE",JOptionPane.WARNING_MESSAGE);
            }
        else{
             appleNum = Integer.parseInt(appleReturn.getText());
              bananaNum = Integer.parseInt(bananaReturn.getText());
                  cherryNum = Integer.parseInt(cherryReturn.getText());
        
            JSONParser parser = new JSONParser();
            try {
			
                Object obj = parser.parse(new FileReader("/Users/hunk/Java WorkSpace/transaction/" + transNum+".json"));	
		JSONObject jobj = (JSONObject)obj;	
                appleNum_inv = (long) jobj.get("apple");
		bananaNum_inv = (long) jobj.get("banana");
		cherryNum_inv = (long) jobj.get("cherry");
                }
              catch(Exception e) {e.printStackTrace();}
        
             appleNum_inv = appleNum_inv - appleNum;
             bananaNum_inv = bananaNum_inv - bananaNum;
            cherryNum_inv = cherryNum_inv - cherryNum;
        
             JsonWR transactionChange = new JsonWR();
            transactionChange.transactionWrite(transactionChange.json_obj(appleNum_inv, bananaNum_inv, cherryNum_inv),
                    "/Users/hunk/Java WorkSpace/transaction/", Integer.parseInt(transNum));
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tranNum = new javax.swing.JTextField();
        appleAmt = new javax.swing.JTextField();
        bananaAmt = new javax.swing.JTextField();
        cherryAmt = new javax.swing.JTextField();
        appleReturn = new javax.swing.JTextField();
        bananaReturn = new javax.swing.JTextField();
        cherryReturn = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 0, 36)); // NOI18N
        jLabel1.setText("Return Menu");

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel3.setText("apple   : ");

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel4.setText("banana :");

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel5.setText("cherry   :");

        tranNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tranNumActionPerformed(evt);
            }
        });

        appleAmt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                appleAmtActionPerformed(evt);
            }
        });

        cherryReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cherryReturnActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Amount");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Return Amt");

        jButton1.setText("Return");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Check Inventory");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(93, 93, 93)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(appleAmt))
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(appleReturn)
                                    .addComponent(bananaReturn)
                                    .addComponent(cherryReturn)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(bananaAmt, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                                    .addComponent(cherryAmt)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(33, 33, 33)
                                        .addComponent(jLabel3))
                                    .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(tranNum, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(tranNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(appleAmt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(appleReturn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(bananaAmt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bananaReturn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cherryReturn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cherryAmt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tranNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tranNumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tranNumActionPerformed

    private void cherryReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cherryReturnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cherryReturnActionPerformed

    private void appleAmtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_appleAmtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_appleAmtActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(Integer.parseInt(appleReturn.getText()) > Integer.parseInt(appleAmt.getText()) ||
           Integer.parseInt(bananaReturn.getText()) > Integer.parseInt(bananaAmt.getText()) ||
           Integer.parseInt(cherryReturn.getText()) > Integer.parseInt(cherryAmt.getText())){
            
           JOptionPane.showMessageDialog(null, "Return amount cannot exceed transcation amount","ERROR_MESSAGE",JOptionPane.ERROR_MESSAGE);
        }else{
             this.updateInventory();
             this.updateTransaction(tranID);
             this.returnTrans(tranID);
        }
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        InventoryList il = new InventoryList();
        il.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(ReturnPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReturnPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReturnPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReturnPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ReturnPage().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField appleAmt;
    private javax.swing.JTextField appleReturn;
    private javax.swing.JTextField bananaAmt;
    private javax.swing.JTextField bananaReturn;
    private javax.swing.JTextField cherryAmt;
    private javax.swing.JTextField cherryReturn;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField tranNum;
    // End of variables declaration//GEN-END:variables
}
