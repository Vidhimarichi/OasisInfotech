package OasisInfobyte;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainDashboard extends JFrame implements ActionListener {

    JButton reserveButton, cancelButton, logoutButton;

    public MainDashboard() {
        setTitle("Online Reservation Dashboard");
        setSize(400, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel heading = new JLabel("Welcome to Reservation System");
        heading.setFont(new Font("Arial", Font.BOLD, 16));
        heading.setBounds(60, 20, 300, 30);
        add(heading);

        reserveButton = new JButton("Reservation Form");
        reserveButton.setBounds(100, 70, 180, 30);
        reserveButton.addActionListener(this);
        add(reserveButton);

        cancelButton = new JButton("Cancellation Form");
        cancelButton.setBounds(100, 110, 180, 30);
        cancelButton.addActionListener(this);
        add(cancelButton);

        logoutButton = new JButton("Logout / Exit");
        logoutButton.setBounds(100, 150, 180, 30);
        logoutButton.addActionListener(this);
        add(logoutButton);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == reserveButton) {
            new ReservationForm().setVisible(true);
        } else if (e.getSource() == cancelButton) {
            new CancellationForm().setVisible(true);
        } else if (e.getSource() == logoutButton) {
            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Exit", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                dispose();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainDashboard().setVisible(true));
    }
}
