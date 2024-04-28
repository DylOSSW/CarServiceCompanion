
import javax.swing.JButton;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author D21124318
 */
public class AdminHome extends javax.swing.JFrame {

    /**
     * Creates new form AdminHome
     */
    public AdminHome() {
        initComponents();
        setupActionListeners();
    }

    // Method to set up action listeners for various buttons related to functionality
    private void setupActionListeners() {
        addActionListenerToButton(DashboardButton, this::openAdminHome);
        addActionListenerToButton(UsersButton, this::openManageCustomers);
        addActionListenerToButton(VehiclesButton, this::openManageVehicles);
        
        
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

        NavigationMenu = new javax.swing.JPanel();
        DashboardButton = new javax.swing.JButton();
        UsersButton = new javax.swing.JButton();
        VehiclesButton = new javax.swing.JButton();
        Dashboard = new javax.swing.JPanel();
        TotalVehicles = new javax.swing.JPanel();
        TotalUsers = new javax.swing.JPanel();
        AvailableVehicles = new javax.swing.JPanel();
        OverdueAccounts = new javax.swing.JScrollPane();
        RentedVehicles = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(910, 468));
        setResizable(false);
        getContentPane().setLayout(null);

        NavigationMenu.setBackground(new java.awt.Color(102, 102, 102));

        DashboardButton.setText("jButton1");

        UsersButton.setText("jButton1");

        VehiclesButton.setText("jButton1");

        javax.swing.GroupLayout NavigationMenuLayout = new javax.swing.GroupLayout(NavigationMenu);
        NavigationMenu.setLayout(NavigationMenuLayout);
        NavigationMenuLayout.setHorizontalGroup(
            NavigationMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NavigationMenuLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(NavigationMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(UsersButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(DashboardButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(VehiclesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        NavigationMenuLayout.setVerticalGroup(
            NavigationMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NavigationMenuLayout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(DashboardButton)
                .addGap(96, 96, 96)
                .addComponent(UsersButton)
                .addGap(86, 86, 86)
                .addComponent(VehiclesButton)
                .addContainerGap(164, Short.MAX_VALUE))
        );

        getContentPane().add(NavigationMenu);
        NavigationMenu.setBounds(0, 0, 60, 520);

        Dashboard.setBackground(new java.awt.Color(255, 255, 255));
        Dashboard.setMinimumSize(new java.awt.Dimension(804, 520));
        Dashboard.setName(""); // NOI18N
        Dashboard.setPreferredSize(new java.awt.Dimension(804, 520));

        javax.swing.GroupLayout TotalVehiclesLayout = new javax.swing.GroupLayout(TotalVehicles);
        TotalVehicles.setLayout(TotalVehiclesLayout);
        TotalVehiclesLayout.setHorizontalGroup(
            TotalVehiclesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );
        TotalVehiclesLayout.setVerticalGroup(
            TotalVehiclesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout TotalUsersLayout = new javax.swing.GroupLayout(TotalUsers);
        TotalUsers.setLayout(TotalUsersLayout);
        TotalUsersLayout.setHorizontalGroup(
            TotalUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        TotalUsersLayout.setVerticalGroup(
            TotalUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout AvailableVehiclesLayout = new javax.swing.GroupLayout(AvailableVehicles);
        AvailableVehicles.setLayout(AvailableVehiclesLayout);
        AvailableVehiclesLayout.setHorizontalGroup(
            AvailableVehiclesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        AvailableVehiclesLayout.setVerticalGroup(
            AvailableVehiclesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout DashboardLayout = new javax.swing.GroupLayout(Dashboard);
        Dashboard.setLayout(DashboardLayout);
        DashboardLayout.setHorizontalGroup(
            DashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashboardLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TotalVehicles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TotalUsers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AvailableVehicles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                .addGroup(DashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(OverdueAccounts, javax.swing.GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE)
                    .addComponent(RentedVehicles))
                .addGap(20, 20, 20))
        );
        DashboardLayout.setVerticalGroup(
            DashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashboardLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(DashboardLayout.createSequentialGroup()
                        .addComponent(TotalVehicles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(TotalUsers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(AvailableVehicles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(DashboardLayout.createSequentialGroup()
                        .addComponent(RentedVehicles, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(OverdueAccounts, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        getContentPane().add(Dashboard);
        Dashboard.setBounds(60, 0, 850, 520);

        pack();
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
            java.util.logging.Logger.getLogger(AdminHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AvailableVehicles;
    private javax.swing.JPanel Dashboard;
    private javax.swing.JButton DashboardButton;
    private javax.swing.JPanel NavigationMenu;
    private javax.swing.JScrollPane OverdueAccounts;
    private javax.swing.JScrollPane RentedVehicles;
    private javax.swing.JPanel TotalUsers;
    private javax.swing.JPanel TotalVehicles;
    private javax.swing.JButton UsersButton;
    private javax.swing.JButton VehiclesButton;
    // End of variables declaration//GEN-END:variables
}
