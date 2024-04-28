import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class login extends javax.swing.JFrame {

    /**
     * Creates new form login
     */
    public login() {
        initComponents();
        setupFrameChangeButtons();
        // Example of adding action listener to the login button
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminLogin();
                userLogin();
            }
        });
    }
    
    private void adminLogin() {
        String email = emailTextField.getText();
        String password = new String(passwordTextField.getPassword());
    
        SimpleDBConnect dbConnect = new SimpleDBConnect();
        boolean isSuccess = dbConnect.login(email, password);
    
        if (isSuccess) {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    JOptionPane.showMessageDialog(null, "Login Successful", "Success", JOptionPane.INFORMATION_MESSAGE);
                    dispose(); // Dispose of the login window
                    AdminHome adminHome = new AdminHome(); 
                    adminHome.setVisible(true); // Make sure it's visible (if not already handled in the constructor)
                }
            });
        } else {
            JOptionPane.showMessageDialog(this, "Login Failed. Please check your credentials.", "Login Failed", JOptionPane.ERROR_MESSAGE);
        }
    }
    
private void userLogin() {
    String email = emailTextField.getText();
    String password = new String(passwordTextField.getPassword());

    SimpleDBConnect dbConnect = new SimpleDBConnect();
    User user = dbConnect.userLogin1(email, password); // This should return a User object or null

    if (user != null) {
        SessionManager.getInstance().login(user); // Use the getInstance() method to get the SessionManager instance
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JOptionPane.showMessageDialog(null, "Login Successful", "Success", JOptionPane.INFORMATION_MESSAGE);
                dispose(); // Dispose of the login window
                userHomePage userHomePage = new userHomePage();
                userHomePage.setVisible(true); // Make sure it's visible (if not already handled in the constructor)
            }
        });
    } else {
        JOptionPane.showMessageDialog(this, "Login Failed. Please check your credentials.", "Login Failed", JOptionPane.ERROR_MESSAGE);
    }
}



   
    // Method to set up action listeners for buttons responsible for opening different JFrames
    private void setupFrameChangeButtons() {
        addActionListenerToButton(signUpButton, this::showSignUpDialog);
        addActionListenerToButton(forgotPasswordButton, this::showResetPasswordDialog);

    }

    // Method to add an action listener to a button to open a specific JFrame
    private void addActionListenerToButton(JButton button, Class<? extends JFrame> frameClass) {
        button.addActionListener(e -> openFrameAndCloseCurrent(frameClass));
        
    }
    
    // Method to add an action listener to a button with a specific action
    private void addActionListenerToButton(JButton button, Runnable action) {
        button.addActionListener(e -> action.run());
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
    
    // Method to display the threshold dialog and add action listener to updateThresholdButton
    private void showResetPasswordDialog() {
        // Pack the dialog to fit its contents
        forgotPasswordDialog.pack();
        // Center the dialog on the screen
        forgotPasswordDialog.setLocationRelativeTo(this);
        // Make the dialog visible to the user
        forgotPasswordDialog.setVisible(true);
        // Add action listener to updateThresholdButton to set thresholds
        addActionListenerToButton(resetPasswordButton, this::resetPassword);
    }
    
        // Method to display the threshold dialog and add action listener to updateThresholdButton
    private void showSignUpDialog() {
        // Pack the dialog to fit its contents
        signUpDialog.pack();
        // Center the dialog on the screen
        signUpDialog.setLocationRelativeTo(this);
        // Make the dialog visible to the user
        signUpDialog.setVisible(true);
        // Add action listener to updateThresholdButton to set thresholds
        addActionListenerToButton(registerButton, this::onSignUpButtonPressed);
    }
    
    public void onSignUpButtonPressed() {
    System.out.println("Register button was pressed");
    // Get the data from the text fields
    String forename = forenameTextField.getText(); // Get the forename from the text field
    String surname = surnameTextField.getText(); // Note that the field name has '1' appended
    String email = emailAddressTextField.getText(); // Ensure that the field name matches the actual variable name
    String password = new String(passwordSignupTextField.getPassword()); // getPassword returns a char array
    String address = homeAddressTextField.getText(); // Get the address from the text field
    String mobile = mobileTextField.getText(); // Get the mobile from the text field

    // Clear the text fields after reading the values
    forenameTextField.setText("");
    surnameTextField.setText("");
    emailAddressTextField.setText("");
    passwordSignupTextField.setText("");
    homeAddressTextField.setText("");
    mobileTextField.setText("");

    // Create a new instance of SimpleDBConnect and sign up the user
    SimpleDBConnect dbConnect = new SimpleDBConnect();
    boolean success = dbConnect.signUpNewUser(forename, surname, email, password, address, mobile);

    if (success) {
        // If signUpNewUser returns true, sign-up was successful
        JOptionPane.showMessageDialog(signUpDialog, "User registration successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
        signUpDialog.setVisible(false); // Close the dialog
        signUpDialog.dispose(); // Dispose of the dialog window
        // You might want to transition to another screen or update the UI here
    } else {
        // If signUpNewUser returns false, sign-up failed (likely email already exists)
        JOptionPane.showMessageDialog(signUpDialog, "User registration failed. Email may already exist.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

   
    public void resetPassword() {
    SimpleDBConnect dbConnect = new SimpleDBConnect();
    String email = emailField.getText(); // Assuming there's a JTextField for email input in your dialog
    String newPassword = passwordField.getText(); // Assuming there's a JTextField for new password input in your dialog

    if (email.isEmpty() || newPassword.isEmpty()) {
        JOptionPane.showMessageDialog(forgotPasswordDialog, "Email and Password fields cannot be empty.", "Input Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    if (!email.contains("@")) {
        JOptionPane.showMessageDialog(forgotPasswordDialog, "Invalid email domain. Must be @carservicecompanion.ie.", "Domain Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    if (dbConnect.updatePassword(email, newPassword)) {
        JOptionPane.showMessageDialog(forgotPasswordDialog, "Password has been successfully reset.", "Success", JOptionPane.INFORMATION_MESSAGE);
        forgotPasswordDialog.setVisible(false);
        
    } else {
        JOptionPane.showMessageDialog(forgotPasswordDialog, "Failed to reset password. Please check the details and try again.", "Update Error", JOptionPane.ERROR_MESSAGE);
    }
}

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        forgotPasswordDialog = new javax.swing.JDialog();
        emailLabel = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        resetPasswordButton = new javax.swing.JButton();
        signUpDialog = new javax.swing.JDialog();
        forenameLabel = new javax.swing.JLabel();
        surnameLabel = new javax.swing.JLabel();
        registerButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        signupTitleLabel = new javax.swing.JLabel();
        homeAddressLabel = new javax.swing.JLabel();
        mobileLabel = new javax.swing.JLabel();
        emailAddressLabel = new javax.swing.JLabel();
        passwordSignupLabel = new javax.swing.JLabel();
        passwordSignupTextField = new javax.swing.JPasswordField();
        forenameTextField = new javax.swing.JTextField();
        surnameTextField = new javax.swing.JTextField();
        mobileTextField = new javax.swing.JTextField();
        homeAddressTextField = new javax.swing.JTextField();
        emailAddressTextField = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        Right = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Left = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        emailTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        passwordTextField = new javax.swing.JPasswordField();
        loginButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        signUpButton = new javax.swing.JButton();
        forgotPasswordButton = new javax.swing.JButton();

        forgotPasswordDialog.setBackground(new java.awt.Color(100, 118, 135));
        forgotPasswordDialog.setFocusTraversalPolicyProvider(true);

        emailLabel.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        emailLabel.setText("Email Address:");

        passwordLabel.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        passwordLabel.setText("New Password:");

        resetPasswordButton.setBackground(new java.awt.Color(153, 153, 255));
        resetPasswordButton.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        resetPasswordButton.setText("Reset Password");

        javax.swing.GroupLayout forgotPasswordDialogLayout = new javax.swing.GroupLayout(forgotPasswordDialog.getContentPane());
        forgotPasswordDialog.getContentPane().setLayout(forgotPasswordDialogLayout);
        forgotPasswordDialogLayout.setHorizontalGroup(
            forgotPasswordDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(forgotPasswordDialogLayout.createSequentialGroup()
                .addGroup(forgotPasswordDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(forgotPasswordDialogLayout.createSequentialGroup()
                        .addComponent(emailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(forgotPasswordDialogLayout.createSequentialGroup()
                        .addComponent(passwordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(resetPasswordButton))
                .addContainerGap(137, Short.MAX_VALUE))
        );
        forgotPasswordDialogLayout.setVerticalGroup(
            forgotPasswordDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(forgotPasswordDialogLayout.createSequentialGroup()
                .addGroup(forgotPasswordDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(emailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(forgotPasswordDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(passwordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(resetPasswordButton)
                .addContainerGap(156, Short.MAX_VALUE))
        );

        signUpDialog.setBackground(new java.awt.Color(100, 118, 135));
        signUpDialog.setFocusTraversalPolicyProvider(true);

        forenameLabel.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        forenameLabel.setText("Forename");

        surnameLabel.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        surnameLabel.setText("Surname");

        registerButton.setBackground(new java.awt.Color(153, 153, 255));
        registerButton.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        registerButton.setForeground(new java.awt.Color(255, 255, 255));
        registerButton.setText("Register");

        jPanel3.setBackground(new java.awt.Color(102, 153, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 12, Short.MAX_VALUE)
        );

        signupTitleLabel.setBackground(new java.awt.Color(153, 153, 255));
        signupTitleLabel.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        signupTitleLabel.setForeground(new java.awt.Color(153, 153, 255));
        signupTitleLabel.setText("Signup");

        homeAddressLabel.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        homeAddressLabel.setText("Home Address");

        mobileLabel.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        mobileLabel.setText("Mobile Number");

        emailAddressLabel.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        emailAddressLabel.setText("Email Address");

        passwordSignupLabel.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        passwordSignupLabel.setText("Password");

        passwordSignupTextField.setText("jPasswordField1");

        javax.swing.GroupLayout signUpDialogLayout = new javax.swing.GroupLayout(signUpDialog.getContentPane());
        signUpDialog.getContentPane().setLayout(signUpDialogLayout);
        signUpDialogLayout.setHorizontalGroup(
            signUpDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(signUpDialogLayout.createSequentialGroup()
                .addGroup(signUpDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(signUpDialogLayout.createSequentialGroup()
                        .addGap(183, 183, 183)
                        .addComponent(signupTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(signUpDialogLayout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(registerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(signUpDialogLayout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addGroup(signUpDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(passwordSignupTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                            .addComponent(passwordSignupLabel, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(emailAddressLabel, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mobileLabel, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(forenameLabel, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(surnameLabel, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(homeAddressLabel, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(forenameTextField)
                            .addComponent(surnameTextField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mobileTextField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(homeAddressTextField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(emailAddressTextField, javax.swing.GroupLayout.Alignment.LEADING))))
                .addContainerGap(125, Short.MAX_VALUE))
        );
        signUpDialogLayout.setVerticalGroup(
            signUpDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(signUpDialogLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(signupTitleLabel)
                .addGap(1, 1, 1)
                .addComponent(forenameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(forenameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(surnameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(surnameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(mobileLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mobileTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(homeAddressLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(homeAddressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(emailAddressLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(emailAddressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordSignupLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordSignupTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(registerButton)
                .addGap(0, 17, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LOGIN");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setToolTipText("");
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel1.setLayout(null);

        Right.setBackground(new java.awt.Color(153, 153, 255));
        Right.setMinimumSize(new java.awt.Dimension(400, 500));
        Right.setPreferredSize(new java.awt.Dimension(400, 500));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/car.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("CarServiceCompanion");

        jLabel7.setBackground(new java.awt.Color(204, 204, 204));
        jLabel7.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("copyright @ carservicecompanion All rights reserved");

        javax.swing.GroupLayout RightLayout = new javax.swing.GroupLayout(Right);
        Right.setLayout(RightLayout);
        RightLayout.setHorizontalGroup(
            RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightLayout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RightLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RightLayout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49))))
            .addGroup(RightLayout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addComponent(jLabel5)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        RightLayout.setVerticalGroup(
            RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightLayout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(66, 66, 66))
        );

        jPanel1.add(Right);
        Right.setBounds(0, 0, 390, 500);

        Left.setMinimumSize(new java.awt.Dimension(400, 500));
        Left.setPreferredSize(new java.awt.Dimension(400, 500));

        jLabel1.setBackground(new java.awt.Color(153, 153, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 255));
        jLabel1.setText("  LOGIN");

        jLabel2.setBackground(new java.awt.Color(102, 102, 102));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Email");

        emailTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        emailTextField.setForeground(new java.awt.Color(102, 102, 102));
        emailTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailTextFieldActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(102, 102, 102));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Password");

        loginButton.setBackground(new java.awt.Color(153, 153, 255));
        loginButton.setForeground(new java.awt.Color(255, 255, 255));
        loginButton.setText("Login");

        jLabel4.setText("Not a Member?");

        signUpButton.setForeground(new java.awt.Color(0, 51, 255));
        signUpButton.setText("Sign Up");

        forgotPasswordButton.setForeground(new java.awt.Color(0, 102, 255));
        forgotPasswordButton.setText("Forgot Password?");

        javax.swing.GroupLayout LeftLayout = new javax.swing.GroupLayout(Left);
        Left.setLayout(LeftLayout);
        LeftLayout.setHorizontalGroup(
            LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LeftLayout.createSequentialGroup()
                .addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LeftLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3)
                            .addGroup(LeftLayout.createSequentialGroup()
                                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(forgotPasswordButton))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passwordTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
                            .addComponent(emailTextField)
                            .addGroup(LeftLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(signUpButton))))
                    .addGroup(LeftLayout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        LeftLayout.setVerticalGroup(
            LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LeftLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LeftLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(forgotPasswordButton))
                    .addGroup(LeftLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(signUpButton))
                .addContainerGap(106, Short.MAX_VALUE))
        );

        jPanel1.add(Left);
        Left.setBounds(390, 0, 420, 500);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void emailTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailTextFieldActionPerformed

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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Left;
    private javax.swing.JPanel Right;
    private javax.swing.JLabel emailAddressLabel;
    private javax.swing.JTextField emailAddressTextField;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JLabel forenameLabel;
    private javax.swing.JTextField forenameTextField;
    private javax.swing.JButton forgotPasswordButton;
    private javax.swing.JDialog forgotPasswordDialog;
    private javax.swing.JLabel homeAddressLabel;
    private javax.swing.JTextField homeAddressTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton loginButton;
    private javax.swing.JLabel mobileLabel;
    private javax.swing.JTextField mobileTextField;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel passwordSignupLabel;
    private javax.swing.JPasswordField passwordSignupTextField;
    private javax.swing.JPasswordField passwordTextField;
    private javax.swing.JButton registerButton;
    private javax.swing.JButton resetPasswordButton;
    private javax.swing.JButton signUpButton;
    private javax.swing.JDialog signUpDialog;
    private javax.swing.JLabel signupTitleLabel;
    private javax.swing.JLabel surnameLabel;
    private javax.swing.JTextField surnameTextField;
    // End of variables declaration//GEN-END:variables
}
