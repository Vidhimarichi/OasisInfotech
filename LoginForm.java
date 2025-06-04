package OasisInfobyte;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginForm extends JFrame implements ActionListener {

    JLabel userLabel, passLabel, titleLabel;
    JTextField userField;
    JPasswordField passField;
    JButton loginButton;
    JLabel messageLabel;

    public LoginForm() {
        setTitle("Online Reservation System - Login");
        setSize(400, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        titleLabel = new JLabel("Login to Reservation System");
        titleLabel.setBounds(80, 10, 250, 30);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(titleLabel);

        userLabel = new JLabel("Username:");
        userLabel.setBounds(50, 60, 80, 25);
        add(userLabel);

        userField = new JTextField();
        userField.setBounds(150, 60, 150, 25);
        add(userField);

        passLabel = new JLabel("Password:");
        passLabel.setBounds(50, 100, 80, 25);
        add(passLabel);

        passField = new JPasswordField();
        passField.setBounds(150, 100, 150, 25);
        add(passField);

        loginButton = new JButton("Login");
        loginButton.setBounds(150, 140, 80, 25);
        loginButton.addActionListener(this);
        add(loginButton);

        messageLabel = new JLabel("");
        messageLabel.setBounds(50, 180, 300, 25);
        add(messageLabel);
    }

    public void actionPerformed(ActionEvent e) {
        String user = userField.getText();
        String pass = String.valueOf(passField.getPassword());

        // Hardcoded credentials (can be replaced with DB check)
        if (user.equals("admin") && pass.equals("admin123")) {
            messageLabel.setForeground(Color.GREEN);
            messageLabel.setText("Login successful!");

            // Proceed to the reservation system (placeholder)
            JOptionPane.showMessageDialog(this, "Welcome to the Online Reservation System!");

            // Close login and open main system window (to be implemented)
            dispose();
            new MainDashboard().setVisible(true);
            // new ReservationForm(); // For example

        } else {
            messageLabel.setForeground(Color.RED);
            messageLabel.setText("Invalid username or password.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginForm().setVisible(true));
    }
}
