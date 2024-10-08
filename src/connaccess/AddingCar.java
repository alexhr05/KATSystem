/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connaccess;

import java.io.File;
import static java.lang.Integer.parseInt;
import java.sql.*;
import static java.sql.DriverManager.println;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class AddingCar extends javax.swing.JFrame {

    private ArrayList<Car> cars = new ArrayList<>();
    private ArrayList<BrandCar> brands = new ArrayList<>();
    private ArrayList<ModelOfCar> models = new ArrayList<>();

    
    private int selectIndex;
    private Connectionn conncetionClass = new Connectionn();
    private Connection conn = null;
    private Statement stRsModelOfCar = null;
    private Statement stRsBrandCar = null;
    private Statement stRsCar = null;
    private Statement stRsUpdate = null;
    

    public AddingCar() {//Конструктор по подразбиране

        initComponents();
        
        try {//Прихващане на изключения
            conn =  conncetionClass.getConn();
            stRsModelOfCar = (Statement) conn.createStatement();
            stRsBrandCar = (Statement) conn.createStatement();
            stRsCar = (Statement) conn.createStatement();
            stRsUpdate = (Statement) conn.createStatement();
            

            ResultSet rs = stRsModelOfCar.executeQuery("SELECT * FROM ModelOfCar");
            ResultSet rsBrand = stRsBrandCar.executeQuery("SELECT * FROM BrandCar");
            ResultSet rsCar = stRsCar.executeQuery("SELECT * FROM Car");
            System.out.println("vlzia1");

            //Селектираща заявка на SQL, където взима информация от ModelOfCar
            int i = 0;
            while (rs.next()) {//обхождаме всички записи
                models.add(new ModelOfCar(rs.getInt(1),rs.getString(2)));//използваме мутатора за да мутираме стойността на полето и да
                //добавим всички записи в него
 
                jComboBox3.addItem(models.get(i).getName()); // Зареждане на текст в падащото меню
                i++;
            }

            i = 0;
            while (rsBrand.next()) {//обхождаме всички записи
                brands.add(new BrandCar(rsBrand.getInt(1), rsBrand.getString(2)));//използваме мутатора за да мутираме стойността на полето и да
                //добавим всички записи в него

                jComboBox2.addItem(brands.get(i).getName()); // Зареждане на текст в падащото меню
                i++;
            }
            i = 0;

            while (rsCar.next()) {//обхождаме всички записи
                cars.add(new Car(rsCar.getInt(1), rsCar.getInt(2), rsCar.getInt(3), rsCar.getInt(4), rsCar.getInt(5)));//използваме мутатора за да мутираме стойността на полето и да
                i++;
            }
            txtNewRec.setText("");
        } catch (Exception ex) {//обработка при грешка
           System.out.println(String.format("Exception: %s", ex.getMessage()));
            //извеждане на грешката като текст в скрия label
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

        jPanel1 = new javax.swing.JPanel();
        txtNewRec = new javax.swing.JTextField();
        btnNewRec = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        lblError = new javax.swing.JLabel();
        lblTitle1 = new javax.swing.JLabel();
        txtNewRec1 = new javax.swing.JTextField();
        lblTitle2 = new javax.swing.JLabel();
        lblTitle3 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        lblTitle5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnShowName1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Blue"));

        jPanel1.setBackground(new java.awt.Color(51, 102, 255));

        txtNewRec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNewRecActionPerformed(evt);
            }
        });

        btnNewRec.setText("Запиши резултат");
        btnNewRec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewRecActionPerformed(evt);
            }
        });

        lblTitle.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setText("Таблица за модифициране на колите");

        lblTitle1.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle1.setText("Конски сили:");

        txtNewRec1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNewRec1ActionPerformed(evt);
            }
        });

        lblTitle2.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle2.setText("Обем на двигателя:");

        lblTitle3.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle3.setText("Марка:");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {  }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {  }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        lblTitle5.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle5.setText("Модел:");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/connaccess/KATPoliceLogoBigger.png"))); // NOI18N

        btnShowName1.setText("Към главно меню");
        btnShowName1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowName1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(lblTitle))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTitle3)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTitle2)
                            .addComponent(txtNewRec1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNewRec, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTitle5)
                            .addComponent(btnNewRec, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTitle1))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(btnShowName1)))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblError, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblTitle1)
                        .addGap(13, 13, 13)
                        .addComponent(txtNewRec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTitle2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNewRec1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblTitle3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblTitle5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(btnNewRec))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnShowName1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblError, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewRecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewRecActionPerformed
        int power = parseInt(txtNewRec.getText());
        int volume = parseInt(txtNewRec1.getText());
        String  br = (String) jComboBox2.getSelectedItem();
        int brand = 0;

        String mod = (String) jComboBox3.getSelectedItem();      
        int model = 0;

        try {
            for(int i = 0; i < brands.size(); i++){
                if(brands.get(i).getName() == br){
                    brand = brands.get(i).getId();
                }

            }
            for(int i = 0; i < models.size(); i++){
                if(models.get(i).getName() == mod){
                    model = models.get(i).getId();
                }
            }
            
            String query = "INSERT INTO Car (Power, Volume, Brand_id, Model_id"
                    + ") VALUES('" + power + "', '" + volume + " ', '" + brand + " ', '" + model + " ')";
            //Добавяща заявка на SQL
            stRsUpdate.executeUpdate(query);//Изпълняване на заявката
            //lblError.setText("Successfull");//Ако е изпълнена - изведи текст на потребителя, че всичко е наред
            conn.close();
        } catch (Exception ex) {
            System.out.println(String.format("Exception: %s", ex.getMessage()));
        }

    }//GEN-LAST:event_btnNewRecActionPerformed

    private void txtNewRecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNewRecActionPerformed
        // TODO add your handling code here:
        String textField = txtNewRec.getText();
        Pattern pattern = Pattern.compile("(?i)\\\\b(select|update|delete|drop|insert|where|or|and|union|like)\\\\b");
        Matcher matcher = pattern.matcher(textField);
        boolean matchFound = matcher.matches();
        if(matchFound) {
          System.out.println("Match found");
        } else {
          System.out.println("Match not found");
        }
    }//GEN-LAST:event_txtNewRecActionPerformed

    private void txtNewRec1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNewRec1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNewRec1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void btnShowName1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowName1ActionPerformed
        this.dispose();
        new MainMenu().setVisible(true);
    }//GEN-LAST:event_btnShowName1ActionPerformed

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
            java.util.logging.Logger.getLogger(AddingCar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddingCar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddingCar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddingCar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddingCar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNewRec;
    private javax.swing.JButton btnShowName1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTitle1;
    private javax.swing.JLabel lblTitle2;
    private javax.swing.JLabel lblTitle3;
    private javax.swing.JLabel lblTitle5;
    private javax.swing.JTextField txtNewRec;
    private javax.swing.JTextField txtNewRec1;
    // End of variables declaration//GEN-END:variables
}
