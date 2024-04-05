import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author D21124318
 */
public class ManageVehicles extends javax.swing.JFrame {
    
    /**
     * Creates new form ManageVehicles
     */
    public ManageVehicles() {
        initComponents();
        populateComboBoxes();
        // Add ActionListener to SearchCars button
        SearchCars.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchCars();
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Dashboard = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        AllModels = new javax.swing.JComboBox<>();
        MaxYear = new javax.swing.JComboBox<>();
        MinYear = new javax.swing.JComboBox<>();
        MaxPrice = new javax.swing.JComboBox<>();
        MinPrice = new javax.swing.JComboBox<>();
        Condition = new javax.swing.JComboBox<>();
        SearchCars = new javax.swing.JButton();
        AllMakes = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        NavigationMenu = new javax.swing.JPanel();
        DashboardButton = new javax.swing.JButton();
        UsersButton = new javax.swing.JButton();
        VehiclesButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        Dashboard.setBackground(new java.awt.Color(255, 255, 255));
        Dashboard.setMinimumSize(new java.awt.Dimension(804, 520));
        Dashboard.setName(""); // NOI18N

        AllModels.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        AllModels.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All Models" }));

        MaxYear.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MaxYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Max Year" }));

        MinYear.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MinYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Min Year" }));

        MaxPrice.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MaxPrice.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Max Price" }));

        MinPrice.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MinPrice.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Min Price" }));

        Condition.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Condition.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Condition" }));

        SearchCars.setAction(SearchCars.getAction());
        SearchCars.setText("Search");

        AllMakes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        AllMakes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All Makes" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AllMakes, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AllModels, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MinPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SearchCars, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(MaxPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MinYear, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MaxYear, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Condition, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AllMakes, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AllModels, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MinPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MaxPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MinYear, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MaxYear, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Condition, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SearchCars, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(8, Short.MAX_VALUE))
        );
        DashboardLayout.setVerticalGroup(
            DashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashboardLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(Dashboard);
        Dashboard.setBounds(60, 0, 850, 520);

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

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    private void searchCars() {
        String selectedMake = AllMakes.getSelectedItem().toString();
        String selectedModel = AllModels.getSelectedItem().toString();
        String minYear = MinYear.getSelectedItem().toString();
        String maxYear = MaxYear.getSelectedItem().toString();
        String minPrice = MinPrice.getSelectedItem().toString();
        String maxPrice = MaxPrice.getSelectedItem().toString();
        String selectedCondition = Condition.getSelectedItem().toString();

        // Call the searchCars function in DBConnection with selected options
        DefaultTableModel model = DBConnection.searchCars(selectedMake, selectedModel, minYear, maxYear, minPrice, maxPrice, selectedCondition);
        // Create a new JTable with the populated model
        JTable newTable = new JTable(model);
        // Add the table to the JScrollPane
        jScrollPane1.setViewportView(newTable);
        // Refresh the GUI to reflect the changes
        this.revalidate();
        this.repaint();
}
    
    private void populateComboBoxes() {
        DBConnection.populateComboBox(AllMakes, "CarMake", "Vehicles");
        DBConnection.populateComboBox(AllModels, "CarModel", "Vehicles");
        DBConnection.populateComboBox(MinYear, "CarYear", "Vehicles");
        DBConnection.populateComboBox(MaxYear, "CarYear", "Vehicles");
        DBConnection.populateComboBox(MinPrice, "RentalPrice", "Vehicles");
        DBConnection.populateComboBox(MaxPrice, "RentalPrice", "Vehicles");
        DBConnection.populateComboBox(Condition, "Availability", "Vehicles");
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
            java.util.logging.Logger.getLogger(ManageVehicles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageVehicles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageVehicles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageVehicles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageVehicles().setVisible(true);
            }
        });
    }
    
    
    
    
    
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> AllMakes;
    private javax.swing.JComboBox<String> AllModels;
    private javax.swing.JComboBox<String> Condition;
    private javax.swing.JPanel Dashboard;
    private javax.swing.JButton DashboardButton;
    private javax.swing.JComboBox<String> MaxPrice;
    private javax.swing.JComboBox<String> MaxYear;
    private javax.swing.JComboBox<String> MinPrice;
    private javax.swing.JComboBox<String> MinYear;
    private javax.swing.JPanel NavigationMenu;
    private javax.swing.JButton SearchCars;
    private javax.swing.JButton UsersButton;
    private javax.swing.JButton VehiclesButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
