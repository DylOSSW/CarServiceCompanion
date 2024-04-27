
import java.awt.Image;
import javax.swing.ImageIcon;

public class CarPane extends javax.swing.JPanel {

    /**
     * Creates new form CarPane
     */
    public CarPane() {
        initComponents();
    }
    
    // Method to set the car image with scaling
    public void setCarImageIcon(ImageIcon icon) {
        Image img = icon.getImage();
        Image scaledImg = img.getScaledInstance(300, -1, Image.SCALE_SMOOTH); // Scale width to 300px and preserve aspect ratio
        carImage.setIcon(new ImageIcon(scaledImg));
    }



    // Method to set the make and model label
    public void setMakeModelText(String text) {
        makeModelPane.setText(text);
    }

    // Method to set the price label
    public void setPriceText(String text) {
        priceLabel.setText(text);
    }

    // Method to set the year label
    public void setYearText(String text) {
        yearLabel.setText(text);
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        carImage = new javax.swing.JLabel();
        makeModelPane = new javax.swing.JLabel();
        priceLabel = new javax.swing.JLabel();
        yearLabel = new javax.swing.JLabel();

        carImage.setIcon(new javax.swing.ImageIcon("C:\\Users\\D21124331\\OneDrive - Technological University Dublin\\Desktop\\4th Year\\GUI\\Project\\CarServiceCompanion\\CarServiceCompanion\\src\\icon\\baby-car.png")); // NOI18N
        carImage.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        makeModelPane.setText("MakeModel");

        priceLabel.setText("Price");

        yearLabel.setText("Year");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(carImage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 234, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(makeModelPane)
                    .addComponent(priceLabel)
                    .addComponent(yearLabel))
                .addGap(34, 34, 34))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(makeModelPane)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(priceLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(yearLabel))
                    .addComponent(carImage, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel carImage;
    private javax.swing.JLabel makeModelPane;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JLabel yearLabel;
    // End of variables declaration//GEN-END:variables
}
