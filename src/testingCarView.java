import javax.swing.*;
import java.util.List;

public class testingCarView extends javax.swing.JFrame {

    public testingCarView() {
        initComponents(); // NetBeans GUI Builder initializes components here
        populateCars();
    }

    private void populateCars() {
        SimpleDBConnect dbConnect = new SimpleDBConnect();
        List<Car> cars = dbConnect.getCarsFromDatabase();
        
        // You should add the CarPane instances to a JPanel, and then set that JPanel to the viewport view of a JScrollPane.
        JPanel containerPanel = new JPanel();
        containerPanel.setLayout(new BoxLayout(containerPanel, BoxLayout.Y_AXIS));
        int verticalGap = 10; // Vertical space between the CarPanes
        int horizontalGap = 10; // Horizontal space on the sides of the CarPanes

        containerPanel.setBorder(BorderFactory.createCompoundBorder(
                containerPanel.getBorder(),
                BorderFactory.createEmptyBorder(verticalGap, horizontalGap, verticalGap, horizontalGap)));

        for (Car car : cars) {
            CarPane carPane = new CarPane();

            // Set the car details in the CarPane
            carPane.setMakeModelText(car.getCarMake() + " " + car.getCarModel());
            carPane.setPriceText(String.format("€%,.2f", car.getPurchasePrice()));
            carPane.setYearText("Year: " + car.getCarYear());

            // Set the car image
            ImageIcon icon = getCarImageIcon(car.getImagePath());
            if (icon != null) {
                carPane.setCarImageIcon(icon);
            } else {
                carPane.setCarImageIcon(new ImageIcon("path/to/default/image")); // Replace with your default image path
            }

            carPane.setBorder(BorderFactory.createEmptyBorder(verticalGap, 0, verticalGap, 0));

            containerPanel.add(carPane);
        }

        carScrollPane.setViewportView(containerPanel);
        carScrollPane.revalidate();
        carScrollPane.repaint();
    }


    // Helper method to get the ImageIcon
    private ImageIcon getCarImageIcon(String imagePath) {
        // Your logic to create an ImageIcon from the image path
        return new ImageIcon(imagePath); // Placeholder
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        carPanel = new javax.swing.JPanel();
        carImage = new javax.swing.JLabel();
        makeModelLabel = new javax.swing.JLabel();
        priceLabel = new javax.swing.JLabel();
        yearLabel = new javax.swing.JLabel();
        Account = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        allmodels2 = new javax.swing.JComboBox<>();
        makeComboBox = new javax.swing.JComboBox<>();
        maxyear2 = new javax.swing.JComboBox<>();
        minyear2 = new javax.swing.JComboBox<>();
        maxprice2 = new javax.swing.JComboBox<>();
        minprice2 = new javax.swing.JComboBox<>();
        condition2 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        carScrollPane = new javax.swing.JScrollPane();
        scrollJPanel = new javax.swing.JPanel();

        carPanel.setBackground(new java.awt.Color(255, 255, 255));

        carImage.setIcon(new javax.swing.ImageIcon("C:\\Users\\D21124331\\OneDrive - Technological University Dublin\\Desktop\\4th Year\\GUI\\Project\\CarServiceCompanion\\CarServiceCompanion\\src\\icon\\baby-car.png")); // NOI18N
        carImage.setBorder(new javax.swing.border.MatteBorder(null));

        makeModelLabel.setText("MakeModel");

        priceLabel.setText("Price");

        yearLabel.setText("Year");

        javax.swing.GroupLayout carPanelLayout = new javax.swing.GroupLayout(carPanel);
        carPanel.setLayout(carPanelLayout);
        carPanelLayout.setHorizontalGroup(
            carPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(carPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(carImage, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                .addGroup(carPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(makeModelLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(priceLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yearLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        carPanelLayout.setVerticalGroup(
            carPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(carPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(carPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(carPanelLayout.createSequentialGroup()
                        .addComponent(makeModelLabel)
                        .addGap(12, 12, 12)
                        .addComponent(priceLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(yearLabel))
                    .addComponent(carImage, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Account.setBackground(new java.awt.Color(255, 255, 255));
        Account.setToolTipText("");
        Account.setPreferredSize(new java.awt.Dimension(800, 500));
        Account.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));
        jPanel2.setMinimumSize(new java.awt.Dimension(800, 60));

        jButton6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton6.setText("Account Details");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton7.setText("Logout");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton8.setText("Home");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("CarServiceCompanion");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(108, 108, 108)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap())
        );

        Account.add(jPanel2);
        jPanel2.setBounds(0, 0, 780, 60);

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Refine your search");

        allmodels2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        allmodels2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All Models", " " }));

        makeComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        makeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All Makes", "Volkswagen", "Audi", "BMW", "Toyota", " " }));

        maxyear2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        maxyear2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Max Year", "2024 ", "2023 ", "2022 ", "2021 ", "2020 ", "2019 ", "2018 ", "2017 ", "2016 ", "2015 ", "2014 ", "2013 ", "2012", "2011 ", "2010 ", "2009 ", "2008 ", "2007 ", "2006 ", "2005 ", "2004, ", "2003 ", "2002 ", "2001 ", "2000 ", "1999 ", "1998 ", "1997 ", "1996 ", "1995 ", "1994 ", "1993", "1992 ", "1991 ", "1990" }));

        minyear2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        minyear2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Min Year", "2024 ", "2023 ", "2022 ", "2021 ", "2020 ", "2019 ", "2018 ", "2017 ", "2016 ", "2015 ", "2014 ", "2013 ", "2012", "2011 ", "2010 ", "2009 ", "2008 ", "2007 ", "2006 ", "2005 ", "2004, ", "2003 ", "2002 ", "2001 ", "2000 ", "1999 ", "1998 ", "1997 ", "1996 ", "1995 ", "1994 ", "1993", "1992 ", "1991 ", "1990" }));

        maxprice2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        maxprice2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Max Price", "€100", "€500", "€1,000", "€1,500", "€2000", "€2,500", "€3,000", "€3,500", "€4,000", "€4,500", "€5,000", "€5,500", "€6,000", "€6,500", "€7,000", "€7,500", "€8,000", "€8,500 ", "€9,000", "€9,500", "€10,000", "€12,500", "€15,000", "€17,500", "€20,000", "€22,500", "€25000", "€27,500", "€30,000", "€40,000", "€45,000", "€50,000", "€60,000", "€70,000", "€80,000", "€90,000", "€100,000", "€125,000" }));

        minprice2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        minprice2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Min Price", "€100", "€500", "€1,000", "€1,500", "€2000", "€2,500", "€3,000", "€3,500", "€4,000", "€4,500", "€5,000", "€5,500", "€6,000", "€6,500", "€7,000", "€7,500", "€8,000", "€8,500 ", "€9,000", "€9,500", "€10,000", "€12,500", "€15,000", "€17,500", "€20,000", "€22,500", "€25000", "€27,500", "€30,000", "€40,000", "€45,000", "€50,000", "€60,000", "€70,000", "€80,000", "€90,000", "€100,000", "€125,000" }));

        condition2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        condition2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Condition", "New", "Used" }));

        jButton1.setBackground(new java.awt.Color(102, 153, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(minyear2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(makeComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(minprice2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(condition2, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(allmodels2, 0, 118, Short.MAX_VALUE)
                    .addComponent(maxyear2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(maxprice2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(36, 36, 36))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(allmodels2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(makeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(maxyear2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(minyear2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(minprice2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(maxprice2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(condition2, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        makeComboBox.setSelectedIndex(0); // Sets the first item in the model to be selected
        makeComboBox.setSelectedIndex(0); // Sets the first item in the model to be selected
        makeComboBox.setSelectedIndex(0); // Sets the first item in the model to be selected
        makeComboBox.setSelectedIndex(0); // Sets the first item in the model to be selected
        makeComboBox.setSelectedIndex(0); // Sets the first item in the model to be selected
        makeComboBox.setSelectedIndex(0); // Sets the first item in the model to be selected
        makeComboBox.setSelectedIndex(0); // Sets the first item in the model to be selected

        scrollJPanel.setBackground(new java.awt.Color(204, 204, 255));
        scrollJPanel.setPreferredSize(new java.awt.Dimension(430, 3000));

        javax.swing.GroupLayout scrollJPanelLayout = new javax.swing.GroupLayout(scrollJPanel);
        scrollJPanel.setLayout(scrollJPanelLayout);
        scrollJPanelLayout.setHorizontalGroup(
            scrollJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 430, Short.MAX_VALUE)
        );
        scrollJPanelLayout.setVerticalGroup(
            scrollJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3000, Short.MAX_VALUE)
        );

        carScrollPane.setViewportView(scrollJPanel);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(carScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(carScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        Account.add(jPanel3);
        jPanel3.setBounds(30, 90, 720, 390);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Account, javax.swing.GroupLayout.PREFERRED_SIZE, 766, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Account, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(testingCarView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(testingCarView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(testingCarView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(testingCarView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new testingCarView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Account;
    private javax.swing.JComboBox<String> allmodels2;
    private javax.swing.JLabel carImage;
    private javax.swing.JPanel carPanel;
    private javax.swing.JScrollPane carScrollPane;
    private javax.swing.JComboBox<String> condition2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JComboBox<String> makeComboBox;
    private javax.swing.JLabel makeModelLabel;
    private javax.swing.JComboBox<String> maxprice2;
    private javax.swing.JComboBox<String> maxyear2;
    private javax.swing.JComboBox<String> minprice2;
    private javax.swing.JComboBox<String> minyear2;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JPanel scrollJPanel;
    private javax.swing.JLabel yearLabel;
    // End of variables declaration//GEN-END:variables
}