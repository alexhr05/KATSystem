/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connaccess;

import java.io.File;
import java.sql.*;
import static java.sql.DriverManager.println;
import java.util.ArrayList;


public class AddingEmployee extends javax.swing.JFrame {

    private ArrayList<Employee> employees = new ArrayList<>();
    private ArrayList<Postion> positions = new ArrayList<>();
   
    private int selectIndex;
    private Connectionn conncetionClass = new Connectionn();
    private Connection conn = null;
    private Statement stRsPosition = null;
    private Statement stRsEmployee = null;
    private Statement stRsUpdate = null;

    public AddingEmployee() {//Конструктор по подразбиране

        initComponents();

        try {//Прихващане на изключения

            conn =  conncetionClass.getConn();
            stRsPosition = (Statement) conn.createStatement();
            stRsEmployee = (Statement) conn.createStatement();
            stRsUpdate = (Statement) conn.createStatement();


  
            ResultSet rs = stRsPosition.executeQuery("SELECT * FROM Position ");
            ResultSet rsEmployee = stRsEmployee.executeQuery("SELECT * FROM Employee");
            int i = 0;
            while (rs.next()) {//обхождаме всички записи
                //добавим всички записи в него
                positions.add(new Postion(rs.getInt(1),rs.getString(2)));//използваме мутатора за да мутираме стойността на полето и да
                
                i++;
            }
            
            i = 0;
            while (rsEmployee.next()) {//обхождаме всички записи
                //добавим всички записи в него
                employees.add(new Employee(rsEmployee.getInt(1), rsEmployee.getString(2), rsEmployee.getString(3), rsEmployee.getInt(4)));//използваме мутатора за да мутираме стойността на полето и да
                System.out.println("Position-"+employees.get(i).getPosition());
                jComboBox1.addItem(employees.get(i).getPosition()+""); // Зареждане на текст в падащото меню
                
                i++;
            }

            

            txtNewRec.setText("");

        } catch (Exception ex) {//обработка при грешка
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
        lblTitle1 = new javax.swing.JLabel();
        txtNewRec1 = new javax.swing.JTextField();
        lblTitle2 = new javax.swing.JLabel();
        lblTitle3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
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

        lblTitle.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setText("Таблица за  добавяне на служители");

        lblTitle1.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle1.setText("Име:");

        txtNewRec1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNewRec1ActionPerformed(evt);
            }
        });

        lblTitle2.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle2.setText("Фамилия:");

        lblTitle3.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle3.setText("Позиция:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

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
                .addGap(124, 124, 124)
                .addComponent(lblTitle)
                .addGap(97, 136, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNewRec, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNewRec, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTitle2)
                    .addComponent(txtNewRec1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTitle3)
                    .addComponent(lblTitle1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(btnShowName1))
                .addGap(114, 114, 114))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(lblTitle)
                .addGap(18, 18, 18)
                .addComponent(btnShowName1)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblTitle1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNewRec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTitle2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNewRec1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblTitle3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnNewRec))
                    .addComponent(jLabel1))
                .addContainerGap(22, Short.MAX_VALUE))
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
        String name = txtNewRec.getText();//задаване на стойност на полето - взетата от txtNewRec
        String familiq = txtNewRec1.getText();//задаване на стойност на полето - взетата от txtNewRec

        String  pos = (String) jComboBox1.getSelectedItem();
        int position = 0;
        
        try {

            String query = "INSERT INTO Employee (Име, Фамилия, Позиция) VALUES('" + name + "', '" + familiq + " ', '" + pos + " ')";
            //Добавяща заявка на SQL

            stRsUpdate.executeUpdate(query);//Изпълняване на заявката
        } catch (Exception ex) {
            
            ex.printStackTrace();
        }

    }//GEN-LAST:event_btnNewRecActionPerformed


    private void txtNewRecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNewRecActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNewRecActionPerformed

    private void txtNewRec1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNewRec1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNewRec1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

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
            java.util.logging.Logger.getLogger(AddingEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddingEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddingEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddingEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddingEmployee().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNewRec;
    private javax.swing.JButton btnShowName1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTitle1;
    private javax.swing.JLabel lblTitle2;
    private javax.swing.JLabel lblTitle3;
    private javax.swing.JTextField txtNewRec;
    private javax.swing.JTextField txtNewRec1;
    // End of variables declaration//GEN-END:variables
}
