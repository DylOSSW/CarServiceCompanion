
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author D21124318
 */
public class ManageOverdueAccounts extends javax.swing.JFrame {
     private SimpleDBConnect DBConnection = new SimpleDBConnect();
    
    private JTable overdueTable;

    /**
     * Creates new form ManageOverdueAccounts
     */
    public ManageOverdueAccounts() {
        initComponents();
        populateComboBoxes();
        setupLogoutButton();
        setupActionListeners();
        searchOverdue();
        
        
        // Use getInstance() to call non-static methods on SessionManager
        SessionManager sessionManager = SessionManager.getInstance();
        if (sessionManager.adminLoggedIn()) {
            Admin currentAdmin = sessionManager.getCurrentAdmin();
            
                        // Extract user information
            int adminID = currentAdmin.getID();
            //String email = currentUser.getEmail();
            String adminEmail = currentAdmin.getEmail();
            

            // Set text fields with user information
            //String currentText = greetingText.getText();
            //String updatedText = currentText + adminEmail;
            String currentidText = currentID.getText();
            String updatedidText = currentidText + adminID;
            //greetingText.setText(updatedText);
            currentID.setText(updatedidText);

        }
        
    }
    // Call this method in the constructor or initialization block to set up the logout button
    private void setupLogoutButton() {
        LogoutBtn.addActionListener(e -> logoutAndOpenLogin());
    }
    // This method will handle the logout process and switch to the login screen
    private void logoutAndOpenLogin() {
        // Logout the user
        SessionManager.getInstance().adminlogout();


        // Close the current frame
        this.dispose();

        // Open the login screen
        JFrame loginFrame = new login();
        loginFrame.setVisible(true);
    }
    
     // Method to set up action listeners for various buttons related to functionality
    private void setupActionListeners() {
        addActionListenerToButton(SearchOverdue, this::searchOverdue);
        addActionListenerToButton(closeOverDueDialog, () -> overDueAccountInfo.setVisible(false));
        
        addActionListenerToButton(DashboardButton, this::openAdminHome);
        addActionListenerToButton(UsersButton, this::openManageCustomers);
        addActionListenerToButton(VehiclesButton, this::openManageVehicles);
        addActionListenerToButton(OverdueAccountsButton, this::openOverdueAccounts);
        
        
    }
    // Method to add an action listener to a button with a specific action
    private void addActionListenerToButton(JButton button, Runnable action) {
        button.addActionListener(e -> action.run());
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        overDueAccountInfo = new javax.swing.JDialog();
        Forename = new javax.swing.JTextField();
        Surname = new javax.swing.JTextField();
        Email = new javax.swing.JTextField();
        Mobile = new javax.swing.JTextField();
        Address = new javax.swing.JTextField();
        CarModel = new javax.swing.JTextField();
        CarMake = new javax.swing.JTextField();
        CarYear = new javax.swing.JTextField();
        OverDueBy = new javax.swing.JTextField();
        closeOverDueDialog = new javax.swing.JButton();
        Dashboard = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        RentalIDComboBox = new javax.swing.JComboBox<>();
        AccountStatusComboBox = new javax.swing.JComboBox<>();
        OverDueToComboBox = new javax.swing.JComboBox<>();
        OverDueFromComboBox = new javax.swing.JComboBox<>();
        SearchOverdue = new javax.swing.JButton();
        UserIDComboBox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        NavigationMenu = new javax.swing.JPanel();
        filler7 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(32767, 10));
        currentID = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 220), new java.awt.Dimension(0, 10), new java.awt.Dimension(32767, 140));
        DashboardButton = new javax.swing.JButton();
        filler6 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 20), new java.awt.Dimension(0, 20), new java.awt.Dimension(32767, 140));
        UsersButton = new javax.swing.JButton();
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 5), new java.awt.Dimension(0, 20));
        VehiclesButton = new javax.swing.JButton();
        filler5 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 20));
        OverdueAccountsButton = new javax.swing.JButton();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 50), new java.awt.Dimension(32767, 140));
        LogoutBtn = new javax.swing.JButton();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(32767, 20));

        overDueAccountInfo.setModal(true);

        Forename.setText("jTextField1");

        Surname.setText("jTextField1");

        Email.setText("jTextField1");

        Mobile.setText("jTextField1");

        Address.setText("jTextField1");

        CarModel.setText("jTextField1");

        CarMake.setText("jTextField1");

        CarYear.setText("jTextField1");

        OverDueBy.setText("jTextField1");

        closeOverDueDialog.setText("Close");

        javax.swing.GroupLayout overDueAccountInfoLayout = new javax.swing.GroupLayout(overDueAccountInfo.getContentPane());
        overDueAccountInfo.getContentPane().setLayout(overDueAccountInfoLayout);
        overDueAccountInfoLayout.setHorizontalGroup(
            overDueAccountInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(overDueAccountInfoLayout.createSequentialGroup()
                .addGroup(overDueAccountInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(overDueAccountInfoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(overDueAccountInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(overDueAccountInfoLayout.createSequentialGroup()
                                .addComponent(Forename, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(CarMake, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(overDueAccountInfoLayout.createSequentialGroup()
                                .addComponent(Surname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(CarModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(OverDueBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Mobile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(overDueAccountInfoLayout.createSequentialGroup()
                                .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(CarYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(overDueAccountInfoLayout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(closeOverDueDialog)))
                .addContainerGap(145, Short.MAX_VALUE))
        );
        overDueAccountInfoLayout.setVerticalGroup(
            overDueAccountInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(overDueAccountInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(overDueAccountInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Forename, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CarMake, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(overDueAccountInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Surname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CarModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OverDueBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(overDueAccountInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CarYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Mobile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(closeOverDueDialog)
                .addContainerGap(119, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(885, 530));
        getContentPane().setLayout(null);

        Dashboard.setBackground(new java.awt.Color(255, 255, 255));
        Dashboard.setMinimumSize(new java.awt.Dimension(804, 520));
        Dashboard.setName(""); // NOI18N
        Dashboard.setPreferredSize(new java.awt.Dimension(810, 500));

        jPanel1.setPreferredSize(new java.awt.Dimension(850, 98));

        RentalIDComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        RentalIDComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "RentalID" }));

        AccountStatusComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        AccountStatusComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Status" }));

        OverDueToComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        OverDueToComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "OverDueTo" }));

        OverDueFromComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        OverDueFromComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "OverDueFrom" }));

        SearchOverdue.setText("Search");

        UserIDComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        UserIDComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "UserID" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(UserIDComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(RentalIDComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(OverDueFromComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(OverDueToComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(SearchOverdue, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(111, 111, 111)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AccountStatusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(159, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UserIDComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RentalIDComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OverDueFromComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OverDueToComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AccountStatusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SearchOverdue, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout DashboardLayout = new javax.swing.GroupLayout(Dashboard);
        Dashboard.setLayout(DashboardLayout);
        DashboardLayout.setHorizontalGroup(
            DashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashboardLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 798, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        DashboardLayout.setVerticalGroup(
            DashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashboardLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(Dashboard);
        Dashboard.setBounds(60, 0, 810, 500);

        NavigationMenu.setBackground(new java.awt.Color(33, 116, 177));
        NavigationMenu.setPreferredSize(new java.awt.Dimension(60, 500));
        NavigationMenu.setLayout(new javax.swing.BoxLayout(NavigationMenu, javax.swing.BoxLayout.Y_AXIS));
        NavigationMenu.add(filler7);

        currentID.setText("ID: ");
        NavigationMenu.add(currentID);
        NavigationMenu.add(filler1);

        DashboardButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/home_35.png"))); // NOI18N
        DashboardButton.setBorderPainted(false);
        DashboardButton.setContentAreaFilled(false);
        NavigationMenu.add(DashboardButton);
        NavigationMenu.add(filler6);

        UsersButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/manageusers_35.png"))); // NOI18N
        UsersButton.setBorderPainted(false);
        UsersButton.setContentAreaFilled(false);
        NavigationMenu.add(UsersButton);
        NavigationMenu.add(filler4);

        VehiclesButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/managevehicles_35.png"))); // NOI18N
        VehiclesButton.setBorderPainted(false);
        VehiclesButton.setContentAreaFilled(false);
        NavigationMenu.add(VehiclesButton);
        NavigationMenu.add(filler5);

        OverdueAccountsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/overdue_35.png"))); // NOI18N
        OverdueAccountsButton.setBorderPainted(false);
        OverdueAccountsButton.setContentAreaFilled(false);
        NavigationMenu.add(OverdueAccountsButton);
        NavigationMenu.add(filler2);

        LogoutBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logout_35.png"))); // NOI18N
        LogoutBtn.setBorderPainted(false);
        LogoutBtn.setContentAreaFilled(false);
        NavigationMenu.add(LogoutBtn);
        NavigationMenu.add(filler3);

        getContentPane().add(NavigationMenu);
        NavigationMenu.setBounds(0, 0, 60, 500);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
     private void openAdminHome() {
        AdminHome adminHome = new AdminHome();
        adminHome.setVisible(true);
        adminHome.setLocationRelativeTo(null);
        this.setVisible(false);
    }
    
    private void openManageVehicles() {
        ManageVehicles manageVehicles = new ManageVehicles();
        manageVehicles.setVisible(true);
        manageVehicles.setLocationRelativeTo(null);
        this.setVisible(false);
    }
    
    private void openManageCustomers() {
        ManageCustomers manageCustomers = new ManageCustomers();
        manageCustomers.setVisible(true);
        manageCustomers.setLocationRelativeTo(null);
        this.setVisible(false);
    }
    
    private void openOverdueAccounts() {
        ManageOverdueAccounts manageOverdue = new ManageOverdueAccounts();
        manageOverdue.setVisible(true);
        manageOverdue.setLocationRelativeTo(null);
        this.setVisible(false);
    }
    
    private void populateComboBoxes() {
        //SimpleDBConnect DBConnection = new SimpleDBConnect();
        DBConnection.populateComboBox(UserIDComboBox, "UserID", "OverdueAccounts");
        DBConnection.populateComboBox(RentalIDComboBox, "RentalID", "OverdueAccounts");
        DBConnection.populateDateComboBox(OverDueFromComboBox, "OverDueDate", "OverdueAccounts");
        DBConnection.populateDateComboBox(OverDueToComboBox, "OverDueDate", "OverdueAccounts");
    }
    
    private void searchOverdue() {
        //SimpleDBConnect DBConnection = new SimpleDBConnect();
        String selectedUserID = UserIDComboBox.getSelectedItem().toString();
        String selectedRentalID = RentalIDComboBox.getSelectedItem().toString();
        String selectedOverDueFrom = OverDueFromComboBox.getSelectedItem().toString();
        String selectedOverDueTo = OverDueToComboBox.getSelectedItem().toString();
        //String selectedMobile = MobileComboBox.getSelectedItem().toString();
        //String selectedStatus = AccountStatusComboBox.getSelectedItem().toString();

        // Call the searchCars function in DBConnection with selected options
        DefaultTableModel model = DBConnection.searchOverdue(selectedUserID, selectedRentalID, selectedOverDueFrom, selectedOverDueTo);
        // Create a new JTable with the populated model
        if(overdueTable == null) {
            overdueTable = new JTable(model);
            jScrollPane1.setViewportView(overdueTable);
            // Attach the MouseListener
            configureTableListeners();
        } else {
            overdueTable.setModel(model);
        }
        
        this.revalidate();
        this.repaint();
}
    
    private void configureTableListeners() {
        System.out.println("Configuringlistener");
        overdueTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2 && !e.isConsumed()) {
                    e.consume();
                    int selectedRow = overdueTable.getSelectedRow();
                    if (selectedRow >= 0) {
                        int userID = Integer.parseInt(overdueTable.getValueAt(selectedRow, 0).toString());
                        int rentalID = Integer.parseInt(overdueTable.getValueAt(selectedRow, 1).toString());
                        System.out.println("Double-clicked row: " + selectedRow + " UserID: " + userID + " RentalID: " + rentalID);
                        showOverdueDialog();
                        // Optionally open a detail dialog
                    }
                }
            }
        });
    }
    
    private void showOverdueDialog() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                int selectedRow = overdueTable.getSelectedRow();
                int userID = Integer.parseInt(overdueTable.getValueAt(selectedRow, 0).toString());
                int rentalID = Integer.parseInt(overdueTable.getValueAt(selectedRow, 1).toString());
                if (selectedRow == -1) {
                System.out.println("Please select an account to view by double clicking");
                return; // Exit if no row is selected
                }

                if (!overDueAccountInfo.isVisible()) {
                    //populateFieldsForEditing(selectedRow);
                    populateOverdueInfo(userID, rentalID);
                    
                    overDueAccountInfo.pack();
                    overDueAccountInfo.setLocationRelativeTo(null);
                    overDueAccountInfo.setVisible(true);
                }
            }
        });
    }
    
    public void populateOverdueInfo(int userID, int rentalID) {
        Map<String, String> data = DBConnection.fetchOverdueAccountDetails(userID, rentalID);
        Forename.setText(data.getOrDefault("Forename", ""));
        Surname.setText(data.getOrDefault("Surname", ""));
        Email.setText(data.getOrDefault("Email", ""));
        Address.setText(data.getOrDefault("Address", ""));
        Mobile.setText(data.getOrDefault("Mobile", ""));
        CarMake.setText(data.getOrDefault("CarMake", ""));
        CarModel.setText(data.getOrDefault("CarModel", ""));
        CarYear.setText(data.getOrDefault("CarYear", ""));
        OverDueBy.setText(data.getOrDefault("ReturnDate", ""));
}
    
    
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
            java.util.logging.Logger.getLogger(ManageOverdueAccounts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageOverdueAccounts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageOverdueAccounts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageOverdueAccounts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageOverdueAccounts().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> AccountStatusComboBox;
    private javax.swing.JTextField Address;
    private javax.swing.JTextField CarMake;
    private javax.swing.JTextField CarModel;
    private javax.swing.JTextField CarYear;
    private javax.swing.JPanel Dashboard;
    private javax.swing.JButton DashboardButton;
    private javax.swing.JTextField Email;
    private javax.swing.JTextField Forename;
    private javax.swing.JButton LogoutBtn;
    private javax.swing.JTextField Mobile;
    private javax.swing.JPanel NavigationMenu;
    private javax.swing.JTextField OverDueBy;
    private javax.swing.JComboBox<String> OverDueFromComboBox;
    private javax.swing.JComboBox<String> OverDueToComboBox;
    private javax.swing.JButton OverdueAccountsButton;
    private javax.swing.JComboBox<String> RentalIDComboBox;
    private javax.swing.JButton SearchOverdue;
    private javax.swing.JTextField Surname;
    private javax.swing.JComboBox<String> UserIDComboBox;
    private javax.swing.JButton UsersButton;
    private javax.swing.JButton VehiclesButton;
    private javax.swing.JButton closeOverDueDialog;
    private javax.swing.JLabel currentID;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler4;
    private javax.swing.Box.Filler filler5;
    private javax.swing.Box.Filler filler6;
    private javax.swing.Box.Filler filler7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JDialog overDueAccountInfo;
    // End of variables declaration//GEN-END:variables
}
