import javax.swing.*;
import java.awt.*;
import javax.swing.border.BevelBorder;

public class CarPanel extends JPanel {
    private JLabel makeModelLabel;
    private JLabel priceLabel;
    private JLabel yearLabel;
    private JLabel imageLabel; // Label to hold the car image

    public CarPanel(Car car) {
        setLayout(new BorderLayout(10, 10));
        
        // Adjust these dimensions to fit your layout requirements
        setPreferredSize(new Dimension(350, 150)); // Slightly increased for padding
        setMaximumSize(getPreferredSize());

        // Panel for car details including the image
        JPanel detailsPanel = new JPanel();
        detailsPanel.setLayout(new BoxLayout(detailsPanel, BoxLayout.LINE_AXIS)); // Changed to BoxLayout
        detailsPanel.setBackground(Color.WHITE);
        detailsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Ensure padding inside the panel

        // Create and add the image label with scaled image
        ImageIcon icon = scaleImageIcon(car.getImagePath(), 90, 90); // Slightly smaller to ensure padding
        imageLabel = new JLabel();
        imageLabel.setPreferredSize(new Dimension(100, 100)); // Set preferred size for uniformity
        imageLabel.setAlignmentY(Component.TOP_ALIGNMENT); // Align to the top
        if (icon != null) {
            imageLabel.setIcon(icon);
        } else {
            // Log error or add a placeholder
            imageLabel.setText("No image");
        }
        detailsPanel.add(imageLabel);

        // Vertical panel to hold text details
        JPanel textDetailsPanel = new JPanel();
        textDetailsPanel.setLayout(new BoxLayout(textDetailsPanel, BoxLayout.PAGE_AXIS)); // Align text top-down
        textDetailsPanel.setOpaque(false); // Transparent to inherit detailsPanel color

        makeModelLabel = new JLabel(car.getCarMake() + " " + car.getCarModel());
        priceLabel = new JLabel("Purchase Price: " + String.format("€%,.2f", car.getPurchasePrice()));
        yearLabel = new JLabel("Year: " + car.getCarYear());

        textDetailsPanel.add(makeModelLabel);
        textDetailsPanel.add(priceLabel);
        textDetailsPanel.add(yearLabel);

        detailsPanel.add(Box.createRigidArea(new Dimension(10, 0))); // Spacer between image and text
        detailsPanel.add(textDetailsPanel);

        add(detailsPanel, BorderLayout.CENTER);
        setBorder(BorderFactory.createSoftBevelBorder(BevelBorder.RAISED));
    }

    private ImageIcon scaleImageIcon(String imagePath, int width, int height) {
        if (imagePath != null && !imagePath.isEmpty()) {
            ImageIcon originalIcon = new ImageIcon(imagePath);
            Image originalImage = originalIcon.getImage();
            Image scaledImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            return new ImageIcon(scaledImage);
        } else {
            return null;
        }
    }
}


