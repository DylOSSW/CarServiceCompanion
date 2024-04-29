/**
 * Name:           Dylan Holmwood and Kristers Martukans
 * Student Number: D21124331 and D21124318
 * Date:           29th April 2024
 * Module Title:   GUI Design and Database Connectivity
 * Module Code:    COMP4604
 * Lecturer:       Lejla Rovcanin
 * Assignment:     Team Project
 * Project:        CarServiceCompanion
 */

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class testingCarView extends javax.swing.JFrame {

    /**
     * Constructor for TestingCarView class.
     */
    public testingCarView() {
        initComponents(); 
        setupFrameChangeButtons(); // Set up action listeners for frame change buttons
        setupLogoutButton(); // Set up logout button
        populateComboBoxes(); // Populate combo boxes with data

        // Set scrolling step size
        carScrollPane.getVerticalScrollBar().setUnitIncrement(16);
        carScrollPane.getHorizontalScrollBar().setUnitIncrement(16);

        // Set layout with gaps between components
        scrollJPanel.setLayout(new BoxLayout(scrollJPanel, BoxLayout.Y_AXIS));
        int panelSpacing = 10; // Space between panels

        // Add compound border to scrollJPanel for spacing between panels and edges
        scrollJPanel.setBorder(BorderFactory.createCompoundBorder(
            scrollJPanel.getBorder(), 
            BorderFactory.createEmptyBorder(panelSpacing, panelSpacing, panelSpacing, panelSpacing)
        ));

        // Add ActionListener to SearchCars button
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchCars(); // Perform car search
            }
        });
        
        // Use getInstance() to call methods on SessionManager
        SessionManager sessionManager = SessionManager.getInstance();
        if (sessionManager.isLoggedIn()) {
            User user = sessionManager.getCurrentUser();
        }
    }

    /**
     * Populate combo boxes with data.
     */
    private void populateComboBoxes() {
        SimpleDBConnect DBConnection = new SimpleDBConnect();
        // Populate combo boxes with data from database
        DBConnection.populateComboBox(makeComboBox, "CarMake", "Vehicles");
        DBConnection.populateComboBox(modelComboBox, "CarModel", "Vehicles");
        DBConnection.populateComboBox(minYearComboBox, "CarYear", "Vehicles");
        DBConnection.populateComboBox(maxYearComboBox, "CarYear", "Vehicles");
        DBConnection.populateComboBox(minPriceComboBox, "RentalPrice", "Vehicles");
        DBConnection.populateComboBox(maxPriceComboBox, "RentalPrice", "Vehicles");
        DBConnection.populateComboBox(conditionComboBox, "Availability", "Vehicles");
    }

    /**
     * Perform car search.
     */
    private void searchCars() {
        SimpleDBConnect DBConnection = new SimpleDBConnect();
        // Get selected options from combo boxes
        String selectedMake = makeComboBox.getSelectedItem().toString();
        String selectedModel = modelComboBox.getSelectedItem().toString();
        String minYear = minYearComboBox.getSelectedItem().toString();
        String maxYear = maxYearComboBox.getSelectedItem().toString();
        String minPrice = minPriceComboBox.getSelectedItem().toString();
        String maxPrice = maxPriceComboBox.getSelectedItem().toString();
        String selectedCondition = conditionComboBox.getSelectedItem().toString();

        // Call the searchCars function in DBConnection with selected options
        List<Car> cars = DBConnection.searchCars2(selectedMake, selectedModel, minYear, maxYear, minPrice, maxPrice, selectedCondition);

        // Populate the scroll view with cars
        populateScrollView(cars);
    }




    /**
    * Populate the scroll view with car panels.
    */
    private void populateScrollView(List<Car> cars) {
        // Clear the existing content in the scroll view
        scrollJPanel.removeAll();

        // Set the layout with gaps between components
        scrollJPanel.setLayout(new BoxLayout(scrollJPanel, BoxLayout.Y_AXIS));
        int panelSpacing = 10; // Space between panels

        // Iterate over the cars and populate the scroll view
        for (Car car : cars) {
            CarPanel carPane = new CarPanel(); // Create a new car panel
        
            // Set car image icon
            ImageIcon imageIcon = new ImageIcon(car.getImagePath()); // Assuming car.getImagePath() returns a String pointing to the image file
            carPane.setCarImageIcon(imageIcon);

            // Set make/model text
            String makeModel = car.getCarMake() + " " + car.getCarModel();
            carPane.setMakeModelText(makeModel);

            // Set price text
            String priceText = String.format("$%.2f", car.getPurchasePrice());
            carPane.setPriceText(priceText);
        
            // Set year text
            String yearText = Integer.toString(car.getCarYear());
            carPane.setYearText(yearText);

            int carID = car.getCarID(); // Get car ID
        
            // Add action listener to Buy button
            carPane.getBuyButton().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Open a JDialog when the "Buy" button is clicked
                    JDialog buyDialog = new JDialog(testingCarView.this, "Purchase Car", true);
                    buyDialog.setLayout(new FlowLayout());
                
                    // Add a button to confirm the purchase
                    JButton confirmButton = new JButton("Confirm Purchase");
                    confirmButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            // Perform purchase confirmation
                            SimpleDBConnect DBConnection = new SimpleDBConnect();
                            boolean wasPurchased = DBConnection.confirmPurchase(carID);
                            if (wasPurchased) {
                                JOptionPane.showMessageDialog(testingCarView.this, "Purchase successful!");
                            } else {
                                JOptionPane.showMessageDialog(testingCarView.this, "Purchase failed. Please try again.");
                            }
                            buyDialog.dispose(); // Close the dialog
                        }
                    });
                
                    // Add confirm button to the dialog
                    buyDialog.add(confirmButton);
                
                    // Set the dialog size and make it visible
                    buyDialog.setSize(300, 200);
                    buyDialog.setLocationRelativeTo(testingCarView.this);
                    buyDialog.setVisible(true);
                }
            });

            // Add carPane to the JScrollPane
            scrollJPanel.add(carPane);
        }

        scrollJPanel.revalidate(); // Revalidate the scroll panel
        scrollJPanel.repaint(); // Repaint the scroll panel
    }


    /**
    * Method to set up action listeners for buttons responsible for opening different JFrames.
    */
    private void setupFrameChangeButtons() {
        addActionListenerToButton(homeButton, userHomePage.class);
        addActionListenerToButton(carsButton, testingCarView.class);
        addActionListenerToButton(accountButton, account.class);
        addActionListenerToButton(logoutButton, login.class);
    }

    /**
    * Method to add an action listener to a button to open a specific JFrame.
    */
    private void addActionListenerToButton(JButton button, Class<? extends JFrame> frameClass) {
        button.addActionListener(e -> openFrameAndCloseCurrent(frameClass));
    }

    /**
    * Method to set up the logout button.
    */
    private void setupLogoutButton() {
        logoutButton.addActionListener(e -> logoutAndOpenLogin());
    }

    /**
    * This method will handle the logout process and switch to the login screen.
    */
    private void logoutAndOpenLogin() {
        // Logout the user
        SessionManager.getInstance().logout();

        // Close the current frame
        this.dispose();

        // Open the login screen
        JFrame loginFrame = new login();
        loginFrame.setVisible(true);
    }

    /**
    * Method to open a new JFrame and close the current one.
    */
    private void openFrameAndCloseCurrent(Class<? extends JFrame> frameClass) {
        try {
            JFrame frame = frameClass.getDeclaredConstructor().newInstance();
            frame.setVisible(true);
            this.dispose(); // Close the current frame
        } catch (Exception e) {
            e.printStackTrace();
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

        carPanel = new javax.swing.JPanel();
        carImage = new javax.swing.JLabel();
        makeModelLabel = new javax.swing.JLabel();
        priceLabel = new javax.swing.JLabel();
        yearLabel = new javax.swing.JLabel();
        carViewDialog = new javax.swing.JDialog();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        carImage1 = new javax.swing.JLabel();
        makeModelLabel1 = new javax.swing.JLabel();
        priceLabel1 = new javax.swing.JLabel();
        yearLabel1 = new javax.swing.JLabel();
        confirmButton = new javax.swing.JButton();
        rentButton = new javax.swing.JButton();
        purchasePriceLabel = new javax.swing.JLabel();
        rentalPriceLabel = new javax.swing.JLabel();
        conditionLabel = new javax.swing.JLabel();
        Account = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        accountButton = new javax.swing.JButton();
        logoutButton = new javax.swing.JButton();
        homeButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        carsButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        modelComboBox = new javax.swing.JComboBox<>();
        makeComboBox = new javax.swing.JComboBox<>();
        maxYearComboBox = new javax.swing.JComboBox<>();
        minYearComboBox = new javax.swing.JComboBox<>();
        maxPriceComboBox = new javax.swing.JComboBox<>();
        minPriceComboBox = new javax.swing.JComboBox<>();
        conditionComboBox = new javax.swing.JComboBox<>();
        searchButton = new javax.swing.JButton();
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

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.LINE_AXIS));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 255), 6, true));
        jPanel5.setMaximumSize(new java.awt.Dimension(370, 150));
        jPanel5.setMinimumSize(new java.awt.Dimension(370, 150));
        jPanel5.setName(""); // NOI18N

        carImage1.setIcon(new javax.swing.ImageIcon("C:\\Users\\D21124331\\OneDrive - Technological University Dublin\\Desktop\\4th Year\\GUI\\Project\\CarServiceCompanion\\CarServiceCompanion\\src\\icon\\baby-car.png")); // NOI18N
        carImage1.setBorder(new javax.swing.border.MatteBorder(null));

        makeModelLabel1.setText("Make/ Model");

        priceLabel1.setText("Price");

        yearLabel1.setText("Year");

        confirmButton.setBackground(new java.awt.Color(153, 153, 255));
        confirmButton.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        confirmButton.setForeground(new java.awt.Color(255, 255, 255));
        confirmButton.setText("Buy");

        rentButton.setBackground(new java.awt.Color(153, 153, 255));
        rentButton.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        rentButton.setForeground(new java.awt.Color(255, 255, 255));
        rentButton.setText("Rent");

        purchasePriceLabel.setText("Purchase Price");

        rentalPriceLabel.setText("Rental Price");

        conditionLabel.setText("Condition");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(carImage1, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(priceLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(makeModelLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(yearLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(conditionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(confirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(purchasePriceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(rentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rentalPriceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(carImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(makeModelLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(priceLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(yearLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(conditionLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(confirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(purchasePriceLabel))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rentalPriceLabel))))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout carViewDialogLayout = new javax.swing.GroupLayout(carViewDialog.getContentPane());
        carViewDialog.getContentPane().setLayout(carViewDialogLayout);
        carViewDialogLayout.setHorizontalGroup(
            carViewDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(carViewDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(carViewDialogLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        carViewDialogLayout.setVerticalGroup(
            carViewDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(carViewDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(carViewDialogLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Account.setBackground(new java.awt.Color(255, 255, 255));
        Account.setToolTipText("");
        Account.setPreferredSize(new java.awt.Dimension(800, 500));
        Account.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));
        jPanel2.setMinimumSize(new java.awt.Dimension(800, 60));

        accountButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        accountButton.setText("Account");
        accountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accountButtonActionPerformed(evt);
            }
        });

        logoutButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        logoutButton.setText("Logout");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        homeButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        homeButton.setText("Home");
        homeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeButtonActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("CarServiceCompanion");

        carsButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        carsButton.setText("Cars");
        carsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(homeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(carsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(accountButton, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(accountButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(homeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(carsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        Account.add(jPanel2);
        jPanel2.setBounds(0, 0, 780, 60);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Refine your search");

        modelComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        modelComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All Models", " " }));

        makeComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        makeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All Makes", " " }));

        maxYearComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        maxYearComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Max Year", " " }));

        minYearComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        minYearComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Min Year", " " }));

        maxPriceComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        maxPriceComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Max Price", " " }));

        minPriceComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        minPriceComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Min Price", " " }));

        conditionComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        conditionComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Condition", " " }));

        searchButton.setBackground(new java.awt.Color(102, 153, 255));
        searchButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        searchButton.setForeground(new java.awt.Color(255, 255, 255));
        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(minYearComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(makeComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(minPriceComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(conditionComboBox, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(modelComboBox, 0, 118, Short.MAX_VALUE)
                    .addComponent(maxYearComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(maxPriceComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(searchButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(modelComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(makeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(maxYearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(minYearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(minPriceComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(maxPriceComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(conditionComboBox, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(searchButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        makeComboBox.setSelectedIndex(0); // Sets the first item in the model to be selected
        makeComboBox.setSelectedIndex(0); // Sets the first item in the model to be selected
        makeComboBox.setSelectedIndex(0); // Sets the first item in the model to be selected
        makeComboBox.setSelectedIndex(0); // Sets the first item in the model to be selected
        makeComboBox.setSelectedIndex(0); // Sets the first item in the model to be selected
        makeComboBox.setSelectedIndex(0); // Sets the first item in the model to be selected
        makeComboBox.setSelectedIndex(0); // Sets the first item in the model to be selected

        carScrollPane.setBackground(new java.awt.Color(255, 255, 255));
        carScrollPane.setBorder(null);
        carScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        carScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        carScrollPane.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        scrollJPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout scrollJPanelLayout = new javax.swing.GroupLayout(scrollJPanel);
        scrollJPanel.setLayout(scrollJPanelLayout);
        scrollJPanelLayout.setHorizontalGroup(
            scrollJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 413, Short.MAX_VALUE)
        );
        scrollJPanelLayout.setVerticalGroup(
            scrollJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 347, Short.MAX_VALUE)
        );

        carScrollPane.setViewportView(scrollJPanel);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(carScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(carScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
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

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_homeButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchButtonActionPerformed

    private void accountButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accountButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_accountButtonActionPerformed

    private void carsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carsButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_carsButtonActionPerformed

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
    private javax.swing.JButton accountButton;
    private javax.swing.JLabel carImage;
    private javax.swing.JLabel carImage1;
    private javax.swing.JPanel carPanel;
    private javax.swing.JScrollPane carScrollPane;
    private javax.swing.JDialog carViewDialog;
    private javax.swing.JButton carsButton;
    private javax.swing.JComboBox<String> conditionComboBox;
    private javax.swing.JLabel conditionLabel;
    private javax.swing.JButton confirmButton;
    private javax.swing.JButton homeButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JButton logoutButton;
    private javax.swing.JComboBox<String> makeComboBox;
    private javax.swing.JLabel makeModelLabel;
    private javax.swing.JLabel makeModelLabel1;
    private javax.swing.JComboBox<String> maxPriceComboBox;
    private javax.swing.JComboBox<String> maxYearComboBox;
    private javax.swing.JComboBox<String> minPriceComboBox;
    private javax.swing.JComboBox<String> minYearComboBox;
    private javax.swing.JComboBox<String> modelComboBox;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JLabel priceLabel1;
    private javax.swing.JLabel purchasePriceLabel;
    private javax.swing.JButton rentButton;
    private javax.swing.JLabel rentalPriceLabel;
    private javax.swing.JPanel scrollJPanel;
    private javax.swing.JButton searchButton;
    private javax.swing.JLabel yearLabel;
    private javax.swing.JLabel yearLabel1;
    // End of variables declaration//GEN-END:variables
}
