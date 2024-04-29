import javax.swing.JFrame;
import javax.swing.JButton;

public class userHomePage extends javax.swing.JFrame {

    /**
     * Creates new form userHomePage
     */
    public userHomePage() {
        initComponents();
        setupFrameChangeButtons();
        setupLogoutButton();
        populateComboBoxes();


    }
    
    private void populateComboBoxes() {
        SimpleDBConnect DBConnection = new SimpleDBConnect();
        DBConnection.populateComboBox(makeComboBox, "CarMake", "Vehicles");
        DBConnection.populateComboBox(modelComboBox, "CarModel", "Vehicles");
        DBConnection.populateComboBox(minYearComboBox, "CarYear", "Vehicles");
        DBConnection.populateComboBox(maxYearComboBox, "CarYear", "Vehicles");
        DBConnection.populateComboBox(minPriceComboBox, "RentalPrice", "Vehicles");
        DBConnection.populateComboBox(maxPriceComboBox, "RentalPrice", "Vehicles");
        DBConnection.populateComboBox(conditionComboBox, "Availability", "Vehicles");
    }
    
    // Method to set up action listeners for buttons responsible for opening different JFrames
    private void setupFrameChangeButtons() {
        addActionListenerToButton(homeButton, userHomePage.class);
        addActionListenerToButton(carsButton, testingCarView.class);
        addActionListenerToButton(searchButton, testingCarView.class);
        addActionListenerToButton(accountDetailsButton, account.class);
        addActionListenerToButton(logoutButton, login.class);
    }

    // Method to add an action listener to a button to open a specific JFrame
    private void addActionListenerToButton(JButton button, Class<? extends JFrame> frameClass) {
        button.addActionListener(e -> openFrameAndCloseCurrent(frameClass));
    }
    
    // Call this method in the constructor or initialization block to set up the logout button
    private void setupLogoutButton() {
        logoutButton.addActionListener(e -> logoutAndOpenLogin());
    }
    

    // This method will handle the logout process and switch to the login screen
    private void logoutAndOpenLogin() {
        // Logout the user
        SessionManager.getInstance().logout();


        // Close the current frame
        this.dispose();

        // Open the login screen
        JFrame loginFrame = new login();
        loginFrame.setVisible(true);
    }

    // Method to open a new JFrame and close the current one
    private void openFrameAndCloseCurrent(Class<? extends JFrame> frameClass) {
        try {
            JFrame frame = frameClass.getDeclaredConstructor().newInstance();
            frame.setVisible(true);
            this.dispose(); // Close the current frame
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        userHomePagePanel = new javax.swing.JPanel();
        userHomePageNavBar = new javax.swing.JPanel();
        accountDetailsButton = new javax.swing.JButton();
        logoutButton = new javax.swing.JButton();
        carsButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        homeButton = new javax.swing.JButton();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jPanel5 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        modelComboBox = new javax.swing.JComboBox<>();
        makeComboBox = new javax.swing.JComboBox<>();
        maxYearComboBox = new javax.swing.JComboBox<>();
        minYearComboBox = new javax.swing.JComboBox<>();
        maxPriceComboBox = new javax.swing.JComboBox<>();
        minPriceComboBox = new javax.swing.JComboBox<>();
        searchButton = new javax.swing.JButton();
        conditionComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Home Page");

        userHomePagePanel.setBackground(new java.awt.Color(255, 255, 255));
        userHomePagePanel.setToolTipText("");
        userHomePagePanel.setPreferredSize(new java.awt.Dimension(800, 500));
        userHomePagePanel.setLayout(null);

        userHomePageNavBar.setBackground(new java.awt.Color(153, 153, 255));
        userHomePageNavBar.setMinimumSize(new java.awt.Dimension(800, 60));

        accountDetailsButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        accountDetailsButton.setText("Account");
        accountDetailsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accountDetailsButtonActionPerformed(evt);
            }
        });

        logoutButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        logoutButton.setText("Logout");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        carsButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        carsButton.setText("Cars");
        carsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carsButtonActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("CarServiceCompanion");

        homeButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        homeButton.setText("Home");
        homeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout userHomePageNavBarLayout = new javax.swing.GroupLayout(userHomePageNavBar);
        userHomePageNavBar.setLayout(userHomePageNavBarLayout);
        userHomePageNavBarLayout.setHorizontalGroup(
            userHomePageNavBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, userHomePageNavBarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(homeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(carsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(accountDetailsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );
        userHomePageNavBarLayout.setVerticalGroup(
            userHomePageNavBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, userHomePageNavBarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(userHomePageNavBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(accountDetailsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(carsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(homeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        userHomePagePanel.add(userHomePageNavBar);
        userHomePageNavBar.setBounds(0, 0, 810, 60);

        jLayeredPane1.setBackground(new java.awt.Color(255, 153, 153));

        jPanel5.setPreferredSize(new java.awt.Dimension(732, 369));

        jLabel33.setIcon(new javax.swing.ImageIcon("C:\\Users\\D21124331\\OneDrive - Technological University Dublin\\Desktop\\4th Year\\GUI\\Project\\CarServiceCompanion\\CarServiceCompanion\\src\\icon\\banner4.jpg")); // NOI18N
        jLabel33.setText("jLabel1");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 726, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel6.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel6.setText("Search for cars");

        modelComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        modelComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All Models", " " }));

        makeComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        makeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All Makes", " " }));

        maxYearComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        maxYearComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Max Year", " " }));

        minYearComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        minYearComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2024 ", " " }));

        maxPriceComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        maxPriceComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Max Price" }));
        maxPriceComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maxPriceComboBoxActionPerformed(evt);
            }
        });

        minPriceComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        minPriceComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Min Price" }));

        searchButton.setBackground(new java.awt.Color(102, 153, 255));
        searchButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        searchButton.setForeground(new java.awt.Color(255, 255, 255));
        searchButton.setText("Search");

        conditionComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        conditionComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Condition", "New", "Used", " " }));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(minYearComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(makeComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(minPriceComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(conditionComboBox, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(modelComboBox, 0, 118, Short.MAX_VALUE)
                            .addComponent(maxYearComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(maxPriceComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(36, 36, 36))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(searchButton)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modelComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(makeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(maxYearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(minYearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(minPriceComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(maxPriceComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchButton)
                    .addComponent(conditionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        makeComboBox.setSelectedIndex(0); // Sets the first item in the model to be selected
        makeComboBox.setSelectedIndex(0); // Sets the first item in the model to be selected
        makeComboBox.setSelectedIndex(0); // Sets the first item in the model to be selected
        makeComboBox.setSelectedIndex(0); // Sets the first item in the model to be selected
        makeComboBox.setSelectedIndex(0); // Sets the first item in the model to be selected
        makeComboBox.setSelectedIndex(0); // Sets the first item in the model to be selected
        makeComboBox.setSelectedIndex(0); // Sets the first item in the model to be selected

        jLayeredPane1.setLayer(jPanel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jPanel7, javax.swing.JLayeredPane.MODAL_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 720, Short.MAX_VALUE)
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 717, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 3, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(433, Short.MAX_VALUE)))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 3, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(24, Short.MAX_VALUE)))
        );

        userHomePagePanel.add(jLayeredPane1);
        jLayeredPane1.setBounds(30, 90, 720, 360);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 786, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(userHomePagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 786, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 468, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(userHomePagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void accountDetailsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accountDetailsButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_accountDetailsButtonActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void carsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carsButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_carsButtonActionPerformed

    private void maxPriceComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maxPriceComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maxPriceComboBoxActionPerformed

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_homeButtonActionPerformed

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
            java.util.logging.Logger.getLogger(userHomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(userHomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(userHomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(userHomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new userHomePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton accountDetailsButton;
    private javax.swing.JButton carsButton;
    private javax.swing.JComboBox<String> conditionComboBox;
    private javax.swing.JButton homeButton;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JButton logoutButton;
    private javax.swing.JComboBox<String> makeComboBox;
    private javax.swing.JComboBox<String> maxPriceComboBox;
    private javax.swing.JComboBox<String> maxYearComboBox;
    private javax.swing.JComboBox<String> minPriceComboBox;
    private javax.swing.JComboBox<String> minYearComboBox;
    private javax.swing.JComboBox<String> modelComboBox;
    private javax.swing.JButton searchButton;
    private javax.swing.JPanel userHomePageNavBar;
    private javax.swing.JPanel userHomePagePanel;
    // End of variables declaration//GEN-END:variables
}
