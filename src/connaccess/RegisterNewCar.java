/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connaccess;

import java.io.File;
import static java.lang.Float.parseFloat;
import java.sql.*;
import static java.sql.DriverManager.println;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RegisterNewCar extends javax.swing.JFrame {

    private ArrayList<Owner> owner = new ArrayList<>();
    private ArrayList<Car> car = new ArrayList<>();
    private ArrayList<Office> office = new ArrayList<>();
    private ArrayList<Employee> employee = new ArrayList<>();

    //private ArrayList<Car> volumeEngine = new ArrayList<>();
    
    private int selectIndex;
    private Connectionn conncetionClass = new Connectionn();
    private Connection conn = null;
    private Statement stRsOwnerOfCar = null;
    private Statement stRsCar = null;
    private Statement stRsOffice = null;
    private Statement stRsEmployee = null;
    private Statement stRsUpdate = null;

    public RegisterNewCar() {//Конструктор по подразбиране

        initComponents();
        
        try {//Прихващане на изключения
            conn =  conncetionClass.getConn();
            stRsOwnerOfCar = (Statement) conn.createStatement();
            stRsCar = (Statement) conn.createStatement();
            stRsOffice = (Statement) conn.createStatement();
            stRsEmployee = (Statement) conn.createStatement();
            stRsUpdate = (Statement) conn.createStatement();
            
            File dbFile = new File("src/DB/KAT.accdb");
            String path = dbFile.getAbsolutePath();//Взимане на абсолютния път
            

            ResultSet rs = stRsOwnerOfCar.executeQuery("SELECT * FROM OwnerOfCar");
//указваме пътя до базата данни. Има и възможност да вземете "абсолютния" път на файла.

            ResultSet rsCar = stRsCar.executeQuery("SELECT * FROM Car");
            ResultSet rsOffice = stRsOffice.executeQuery("SELECT * FROM Office");
            ResultSet rsEmployee = stRsEmployee.executeQuery("SELECT * FROM Employee");

            //Селектираща заявка на SQL, където в квадратните скоби са "Име" - колоната която искаме и "Потребител" - таблицата
            int i = 0;
            while (rs.next()) {//обхождаме всички записи
                owner.add(new Owner(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6)));//използваме мутатора за да мутираме стойността на полето и да
                //добавим всички записи в него
                System.out.println(owner.get(i).getName());

                jComboBox4.addItem(owner.get(i).getName()); // Зареждане на текст в падащото меню
                i++;
            }
            System.out.println(owner.toString());
            i = 0;
            while (rsCar.next()) {//обхождаме всички записи
                car.add(new Car(rsCar.getInt(1), rsCar.getInt(2), rsCar.getInt(3), rsCar.getInt(4), rsCar.getInt(5)));//използваме мутатора за да мутираме стойността на полето и да
                //добавим всички записи в него

                jComboBox5.addItem(car.get(i).getId() + ""); // Зареждане на текст в падащото меню
                i++;
            }
                        System.out.println(car.toString());
            i = 0;

            while (rsOffice.next()) {//обхождаме всички записи
                office.add(new Office(rsOffice.getInt(1), rsOffice.getString(2), rsOffice.getInt(3)));//използваме мутатора за да мутираме стойността на полето и да
                //добавим всички записи в него

                jComboBox3.addItem(office.get(i).getName()); // Зареждане на текст в падащото меню
                i++;
            }
                        System.out.println(owner.toString());
            i = 0;

            while (rsEmployee.next()) {//обхождаме всички записи
                employee.add(new Employee(rsEmployee.getInt(1), rsEmployee.getString(2), rsEmployee.getString(3), rsEmployee.getInt(4)));//използваме мутатора за да мутираме стойността на полето и да
                //добавим всички записи в него

                jComboBox6.addItem(employee.get(i).getName()); // Зареждане на текст в падащото меню
                i++;
            }
            System.out.println(employee.toString());



        } catch (Exception ex) {//обработка при грешка
            lblError.setText(String.format("Exception: %s", ex.getMessage()));
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
        btnNewRec = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        lblError = new javax.swing.JLabel();
        lblTitle1 = new javax.swing.JLabel();
        lblTitle2 = new javax.swing.JLabel();
        lblTitle3 = new javax.swing.JLabel();
        lblTitle4 = new javax.swing.JLabel();
        txtNewRec2 = new javax.swing.JTextField();
        jComboBox3 = new javax.swing.JComboBox<>();
        lblTitle5 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jComboBox5 = new javax.swing.JComboBox<>();
        txtNewRec3 = new javax.swing.JTextField();
        lblTitle6 = new javax.swing.JLabel();
        jComboBox6 = new javax.swing.JComboBox<>();
        btnNewRec1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnShowName1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Blue"));

        jPanel1.setBackground(new java.awt.Color(51, 102, 255));

        btnNewRec.setText("Запиши резултат");
        btnNewRec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewRecActionPerformed(evt);
            }
        });

        lblTitle.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setText("Таблица за регистрация на коли");

        lblTitle1.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle1.setText("Собственик:");

        lblTitle2.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle2.setText("Кола:");

        lblTitle3.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle3.setText("Дата на регистрация:");

        lblTitle4.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle4.setText("Цена на регистрация:");

        txtNewRec2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNewRec2ActionPerformed(evt);
            }
        });

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {  }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        lblTitle5.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle5.setText("Офис на КАТ:");

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {  }));
        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {  }));
        jComboBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox5ActionPerformed(evt);
            }
        });

        txtNewRec3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNewRec3ActionPerformed(evt);
            }
        });

        lblTitle6.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle6.setText("Служител:");

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {  }));
        jComboBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox6ActionPerformed(evt);
            }
        });

        btnNewRec1.setText("Изтрий");
        btnNewRec1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewRec1ActionPerformed(evt);
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnNewRec, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(20, 20, 20)
                        .addComponent(btnNewRec1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNewRec2, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTitle5)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTitle2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNewRec3, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblTitle4)
                                    .addComponent(lblTitle3)
                                    .addComponent(lblTitle6)
                                    .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblTitle1))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnShowName1)
                            .addComponent(jLabel1))
                        .addGap(35, 35, 35))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblTitle)
                        .addGap(48, 48, 48)
                        .addComponent(lblTitle1))
                    .addComponent(btnShowName1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTitle2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTitle3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNewRec3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTitle4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNewRec2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTitle5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(lblTitle6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(lblError, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnNewRec))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnNewRec1)))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewRecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewRecActionPerformed
        String date = txtNewRec3.getText();//задаване на стойност на полето - взетата от txtNewRec
        double price = Double.parseDouble(txtNewRec2.getText());//задаване на стойност на полето - взетата от txtNewRec
        String  own = (String) jComboBox4.getSelectedItem();
        int ownerr = 0;
        int  c = Integer.parseInt( (String)jComboBox5.getSelectedItem());
        String  kat = (String) jComboBox3.getSelectedItem();
        int KAT = 0;
        String  emp = (String) jComboBox6.getSelectedItem();
        int empl = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1=new Date(0,0,0);
        try {  
             date1 = (Date) sdf.parse(date);
        } catch (ParseException ex) {
            Logger.getLogger(RegisterNewCar.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            for(int i = 0; i < owner.size(); i++){
                if(owner.get(i).getName() == own){
                    ownerr = owner.get(i).getId();
                }
            }
            for(int i = 0; i < office.size(); i++){
                if(office.get(i).getName() == kat){
                    KAT = owner.get(i).getId();
                }
            }
            for(int i = 0; i < employee.size(); i++){
                if(employee.get(i).getName() == emp){
                    empl = employee.get(i).getId();
                }
            }            
            String query = "INSERT INTO RegistrationOfCar (OwnerOfCar_id, car_id, Дата на регистрация, Цена на регистрация, Офис на КАТ, Служител) VALUES('" + ownerr + "', '" + c + " ', '" + date1 + " ', '" + price + " ', '" + KAT + " ', '" + empl + " ')";
            //Добавяща заявка на SQL
            stRsUpdate.executeUpdate(query);//Изпълняване на заявката
            int x = stRsUpdate.executeUpdate(query);
            if (x > 0)            
                lblError.setText("Successfull");            
            
            //lblError.setText("Successfull");//Ако е изпълнена - изведи текст на потребителя, че всичко е наред
        } catch (Exception ex) {
            lblError.setText(String.format("Exception: %s", ex.getMessage()));
        }

    }//GEN-LAST:event_btnNewRecActionPerformed

    private void txtNewRec2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNewRec2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNewRec2ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox4ActionPerformed

    private void jComboBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox5ActionPerformed

    private void txtNewRec3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNewRec3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNewRec3ActionPerformed

    private void jComboBox6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox6ActionPerformed

    private void btnNewRec1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewRec1ActionPerformed
        int  c = Integer.parseInt( (String)jComboBox5.getSelectedItem());
        String query = String.format("DELETE FROM RegistrationOfCar WHERE car_id = %s", c);
        try {
            int x = stRsUpdate.executeUpdate(query);//Изпълняване на заявката
            if (x > 0)            
                lblError.setText("Successfull Delete");            
        } catch (SQLException ex) {
            System.out.print(ex);
        }
    }//GEN-LAST:event_btnNewRec1ActionPerformed

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
            java.util.logging.Logger.getLogger(RegisterNewCar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterNewCar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterNewCar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterNewCar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterNewCar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNewRec;
    private javax.swing.JButton btnNewRec1;
    private javax.swing.JButton btnShowName1;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTitle1;
    private javax.swing.JLabel lblTitle2;
    private javax.swing.JLabel lblTitle3;
    private javax.swing.JLabel lblTitle4;
    private javax.swing.JLabel lblTitle5;
    private javax.swing.JLabel lblTitle6;
    private javax.swing.JTextField txtNewRec2;
    private javax.swing.JTextField txtNewRec3;
    // End of variables declaration//GEN-END:variables
}
