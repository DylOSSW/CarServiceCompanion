import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author D21124318
 */
public class ManageVehicles extends javax.swing.JFrame {
    
    private boolean isListenersAdded = false;

    
    /**
     * Creates new form ManageVehicles
     */
    public ManageVehicles() {
        initComponents();
        setupActionListeners();
        populateComboBoxes();
        searchCars();
        // Add ActionListener to SearchCars button
        SearchCars.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchCars();
            }
        });
    }

    // Method to set up action listeners for various buttons related to functionality
    private void setupActionListeners() {
        addActionListenerToButton(AddBtn, this::showAddVehicleDialog);
        addActionListenerToButton(EditBtn, this::showEditVehicleDialog);
        
        
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

        addVehicleDialog = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        setCarMake = new javax.swing.JTextField();
        setCarModel = new javax.swing.JTextField();
        setCarYear = new javax.swing.JTextField();
        setRentalPrice = new javax.swing.JTextField();
        setPurchasePrice = new javax.swing.JTextField();
        setCondition = new javax.swing.JTextField();
        setImagePath = new javax.swing.JTextField();
        AddVehicle = new javax.swing.JButton();
        CancelAddVehicle = new javax.swing.JButton();
        editVehicleDialog = new javax.swing.JDialog();
        jPanel3 = new javax.swing.JPanel();
        updateCarMake = new javax.swing.JTextField();
        updateCarModel = new javax.swing.JTextField();
        updateCarYear = new javax.swing.JTextField();
        updateRentalPrice = new javax.swing.JTextField();
        updatePurchasePrice = new javax.swing.JTextField();
        updateCondition = new javax.swing.JTextField();
        updateImagePath = new javax.swing.JTextField();
        EditVehicle = new javax.swing.JButton();
        CancelEditVehicle = new javax.swing.JButton();
        rmvVehicleDialog = new javax.swing.JDialog();
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
        AddBtn = new javax.swing.JButton();
        EditBtn = new javax.swing.JButton();
        RemoveBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        NavigationMenu = new javax.swing.JPanel();
        DashboardButton = new javax.swing.JButton();
        UsersButton = new javax.swing.JButton();
        VehiclesButton = new javax.swing.JButton();

        addVehicleDialog.setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        addVehicleDialog.setModal(true);
        addVehicleDialog.setPreferredSize(new java.awt.Dimension(400, 450));
        addVehicleDialog.setSize(new java.awt.Dimension(400, 450));

        setCarMake.setText("CarMake");

        setCarModel.setText("CarModel");

        setCarYear.setText("CarYear");

        setRentalPrice.setText("RentalPrice");

        setPurchasePrice.setText("PurchasePrice");

        setCondition.setText("Condition");

        setImagePath.setText("ImagePath");

        AddVehicle.setText("Add");

        CancelAddVehicle.setText("Cancel");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(setCarMake, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(setRentalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(setCarModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(setPurchasePrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(setImagePath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(setCarYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(setCondition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(AddVehicle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CancelAddVehicle)))
                .addContainerGap(130, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(setCarMake, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(setRentalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(setCarModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(setPurchasePrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(setImagePath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(setCarYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(setCondition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddVehicle)
                    .addComponent(CancelAddVehicle))
                .addContainerGap(259, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout addVehicleDialogLayout = new javax.swing.GroupLayout(addVehicleDialog.getContentPane());
        addVehicleDialog.getContentPane().setLayout(addVehicleDialogLayout);
        addVehicleDialogLayout.setHorizontalGroup(
            addVehicleDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addVehicleDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        addVehicleDialogLayout.setVerticalGroup(
            addVehicleDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addVehicleDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        updateCarMake.setText("CarMake");

        updateCarModel.setText("CarModel");

        updateCarYear.setText("CarYear");

        updateRentalPrice.setText("RentalPrice");
        updateRentalPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateRentalPriceActionPerformed(evt);
            }
        });

        updatePurchasePrice.setText("PurchasePrice");

        updateCondition.setText("Condition");

        updateImagePath.setText("ImagePath");

        EditVehicle.setText("Edit");

        CancelEditVehicle.setText("Cancel");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(updateCarMake, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(updateRentalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(updateCarModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(updatePurchasePrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(updateImagePath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(updateCarYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(updateCondition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(EditVehicle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CancelEditVehicle)))
                .addContainerGap(130, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateCarMake, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateRentalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateCarModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updatePurchasePrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateImagePath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateCarYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateCondition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EditVehicle)
                    .addComponent(CancelEditVehicle))
                .addContainerGap(109, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout editVehicleDialogLayout = new javax.swing.GroupLayout(editVehicleDialog.getContentPane());
        editVehicleDialog.getContentPane().setLayout(editVehicleDialogLayout);
        editVehicleDialogLayout.setHorizontalGroup(
            editVehicleDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editVehicleDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        editVehicleDialogLayout.setVerticalGroup(
            editVehicleDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editVehicleDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout rmvVehicleDialogLayout = new javax.swing.GroupLayout(rmvVehicleDialog.getContentPane());
        rmvVehicleDialog.getContentPane().setLayout(rmvVehicleDialogLayout);
        rmvVehicleDialogLayout.setHorizontalGroup(
            rmvVehicleDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        rmvVehicleDialogLayout.setVerticalGroup(
            rmvVehicleDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(890, 500));
        getContentPane().setLayout(null);

        Dashboard.setBackground(new java.awt.Color(255, 255, 255));
        Dashboard.setMinimumSize(new java.awt.Dimension(804, 520));
        Dashboard.setName(""); // NOI18N
        Dashboard.setPreferredSize(new java.awt.Dimension(810, 500));

        jPanel1.setPreferredSize(new java.awt.Dimension(850, 98));

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
        SearchCars.setToolTipText("");

        AllMakes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        AllMakes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All Makes" }));

        AddBtn.setText("Add");

        EditBtn.setText("Edit");

        RemoveBtn.setText("Remove");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AllMakes, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AllModels, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EditBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RemoveBtn)
                    .addComponent(MinPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addContainerGap(15, Short.MAX_VALUE))
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SearchCars, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(AddBtn)
                        .addComponent(EditBtn)
                        .addComponent(RemoveBtn)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout DashboardLayout = new javax.swing.GroupLayout(Dashboard);
        Dashboard.setLayout(DashboardLayout);
        DashboardLayout.setHorizontalGroup(
            DashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashboardLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 798, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        DashboardLayout.setVerticalGroup(
            DashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashboardLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        getContentPane().add(Dashboard);
        Dashboard.setBounds(60, 0, 810, 500);

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
                .addContainerGap(144, Short.MAX_VALUE))
        );

        getContentPane().add(NavigationMenu);
        NavigationMenu.setBounds(0, 0, 60, 500);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void updateRentalPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateRentalPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateRentalPriceActionPerformed
    
    
    private void searchCars() {
        SimpleDBConnect DBConnection = new SimpleDBConnect();
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
        //newTable.setRowSelectionAllowed(true);
        //newTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        // Add the table to the JScrollPane
        jScrollPane1.setViewportView(newTable);
        // Refresh the GUI to reflect the changes
        this.revalidate();
        this.repaint();
}
    
    private void populateComboBoxes() {
        SimpleDBConnect DBConnection = new SimpleDBConnect();
        DBConnection.populateComboBox(AllMakes, "CarMake", "Vehicles");
        DBConnection.populateComboBox(AllModels, "CarModel", "Vehicles");
        DBConnection.populateComboBox(MinYear, "CarYear", "Vehicles");
        DBConnection.populateComboBox(MaxYear, "CarYear", "Vehicles");
        DBConnection.populateComboBox(MinPrice, "RentalPrice", "Vehicles");
        DBConnection.populateComboBox(MaxPrice, "RentalPrice", "Vehicles");
        DBConnection.populateComboBox(Condition, "Availability", "Vehicles");
    }
    
    private void showAddVehicleDialog() {
        SwingUtilities.invokeLater(new Runnable() {
        public void run() {
            if (!addVehicleDialog.isVisible()) {
                addVehicleDialog.pack();
                addVehicleDialog.setLocationRelativeTo(null);
                if (!isListenersAdded){
                    addActionListenerToButton(AddVehicle, ManageVehicles.this::AddNewVehicle);
                    addActionListenerToButton(CancelAddVehicle, () -> addVehicleDialog.setVisible(false));
                    isListenersAdded = true;
                }
                addVehicleDialog.setVisible(true);
            }
        }
    });
    }
    
    //Method to update DB with new Vehicle
    private void AddNewVehicle() {
        System.out.println("Vehicle Added");
        addVehicleDialog.setVisible(false);
    }
    
    private void showEditVehicleDialog() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                if (!editVehicleDialog.isVisible()) {
                editVehicleDialog.pack();
                editVehicleDialog.setLocationRelativeTo(null);
                addActionListenerToButton(EditVehicle, ManageVehicles.this::EditVehicle);
                addActionListenerToButton(CancelEditVehicle, () -> editVehicleDialog.setVisible(false));
                editVehicleDialog.setVisible(true);
            }
            }
        });
    }
    
    //Method to update vehicle info in DB
    private void EditVehicle() {
        System.out.println("Vehicle Editted");
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
    private javax.swing.JButton AddBtn;
    private javax.swing.JButton AddVehicle;
    private javax.swing.JComboBox<String> AllMakes;
    private javax.swing.JComboBox<String> AllModels;
    private javax.swing.JButton CancelAddVehicle;
    private javax.swing.JButton CancelEditVehicle;
    private javax.swing.JComboBox<String> Condition;
    private javax.swing.JPanel Dashboard;
    private javax.swing.JButton DashboardButton;
    private javax.swing.JButton EditBtn;
    private javax.swing.JButton EditVehicle;
    private javax.swing.JComboBox<String> MaxPrice;
    private javax.swing.JComboBox<String> MaxYear;
    private javax.swing.JComboBox<String> MinPrice;
    private javax.swing.JComboBox<String> MinYear;
    private javax.swing.JPanel NavigationMenu;
    private javax.swing.JButton RemoveBtn;
    private javax.swing.JButton SearchCars;
    private javax.swing.JButton UsersButton;
    private javax.swing.JButton VehiclesButton;
    private javax.swing.JDialog addVehicleDialog;
    private javax.swing.JDialog editVehicleDialog;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JDialog rmvVehicleDialog;
    private javax.swing.JTextField setCarMake;
    private javax.swing.JTextField setCarModel;
    private javax.swing.JTextField setCarYear;
    private javax.swing.JTextField setCondition;
    private javax.swing.JTextField setImagePath;
    private javax.swing.JTextField setPurchasePrice;
    private javax.swing.JTextField setRentalPrice;
    private javax.swing.JTextField updateCarMake;
    private javax.swing.JTextField updateCarModel;
    private javax.swing.JTextField updateCarYear;
    private javax.swing.JTextField updateCondition;
    private javax.swing.JTextField updateImagePath;
    private javax.swing.JTextField updatePurchasePrice;
    private javax.swing.JTextField updateRentalPrice;
    // End of variables declaration//GEN-END:variables
}
