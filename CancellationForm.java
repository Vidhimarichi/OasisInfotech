package OasisInfobyte;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

public class CancellationForm extends JFrame implements ActionListener {

    JTextField pnrField;
    JTextArea detailsArea;
    JButton searchButton, cancelButton;

    HashMap<String, String> reservationData;

    public CancellationForm() {
        setTitle("Cancellation Form");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // Simulated PNR database
        reservationData = new HashMap<>();
        reservationData.put("PNR001", "Name: Arman\nTrain: Express Line\nFrom: Delhi\nTo: Mumbai\nDate: 10-06-2025");
        reservationData.put("PNR002", "Name: Sara\nTrain: Mountain Express\nFrom: Shimla\nTo: Manali\nDate: 12-06-2025");

        JLabel heading = new JLabel("Cancel Reservation");
        heading.setFont(new Font("Arial", Font.BOLD, 18));
        heading.setBounds(150, 10, 250, 30);
        add(heading);

        JLabel pnrLabel = new JLabel("Enter PNR Number:");
        pnrLabel.setBounds(50, 60, 150, 25);
        add(pnrLabel);

        pnrField = new JTextField();
        pnrField.setBounds(200, 60, 180, 25);
        add(pnrField);

        searchButton = new JButton("Search");
        searchButton.setBounds(200, 100, 80, 25);
        searchButton.addActionListener(this);
        add(searchButton);

        detailsArea = new JTextArea();
        detailsArea.setBounds(50, 140, 380, 120);
        detailsArea.setEditable(false);
        detailsArea.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        add(detailsArea);

        cancelButton = new JButton("Cancel Ticket");
        cancelButton.setBounds(180, 280, 130, 30);
        cancelButton.addActionListener(e -> confirmCancellation());
        cancelButton.setEnabled(false);  // only active after PNR found
        add(cancelButton);
    }

    public void actionPerformed(ActionEvent e) {
        String pnr = pnrField.getText().trim().toUpperCase();

        if (reservationData.containsKey(pnr)) {
            detailsArea.setText("Reservation Found:\n\n" + reservationData.get(pnr));
            cancelButton.setEnabled(true);
        } else {
            detailsArea.setText("No reservation found for PNR: " + pnr);
            cancelButton.setEnabled(false);
        }
    }

    private void confirmCancellation() {
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to cancel this ticket?", "Confirm Cancellation", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            String pnr = pnrField.getText().trim().toUpperCase();
            reservationData.remove(pnr);
            detailsArea.setText("Reservation for PNR " + pnr + " has been cancelled.");
            cancelButton.setEnabled(false);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CancellationForm().setVisible(true));
    }
}

