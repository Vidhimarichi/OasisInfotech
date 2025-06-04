package OasisInfobyte;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

public class ReservationForm extends JFrame implements ActionListener {

    JTextField nameField, trainNumberField, trainNameField, fromField, toField, dateField;
    JComboBox<String> classTypeBox;
    JButton submitButton;

    // Simulated train number-to-name mapping
    HashMap<String, String> trainData = new HashMap<>();

    public ReservationForm() {
        setTitle("Reservation Form");
        setSize(450, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // Dummy train data
        trainData.put("12345", "Express Line");
        trainData.put("54321", "Mountain Express");
        trainData.put("11111", "City Runner");

        JLabel heading = new JLabel("Train Reservation");
        heading.setFont(new Font("Arial", Font.BOLD, 18));
        heading.setBounds(130, 10, 200, 30);
        add(heading);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 60, 100, 25);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(180, 60, 180, 25);
        add(nameField);

        JLabel trainNumLabel = new JLabel("Train Number:");
        trainNumLabel.setBounds(50, 100, 100, 25);
        add(trainNumLabel);

        trainNumberField = new JTextField();
        trainNumberField.setBounds(180, 100, 180, 25);
        trainNumberField.addFocusListener(new FocusAdapter() {
            public void focusLost(FocusEvent e) {
                String trainNo = trainNumberField.getText();
                String trainName = trainData.getOrDefault(trainNo, "Unknown Train");
                trainNameField.setText(trainName);
            }
        });
        add(trainNumberField);

        JLabel trainNameLabel = new JLabel("Train Name:");
        trainNameLabel.setBounds(50, 140, 100, 25);
        add(trainNameLabel);

        trainNameField = new JTextField();
        trainNameField.setBounds(180, 140, 180, 25);
        trainNameField.setEditable(false);
        add(trainNameField);

        JLabel classLabel = new JLabel("Class Type:");
        classLabel.setBounds(50, 180, 100, 25);
        add(classLabel);

        String[] classes = {"Sleeper", "AC", "First Class", "Second Class"};
        classTypeBox = new JComboBox<>(classes);
        classTypeBox.setBounds(180, 180, 180, 25);
        add(classTypeBox);

        JLabel dateLabel = new JLabel("Date of Journey:");
        dateLabel.setBounds(50, 220, 120, 25);
        add(dateLabel);

        dateField = new JTextField("DD-MM-YYYY");
        dateField.setBounds(180, 220, 180, 25);
        add(dateField);

        JLabel fromLabel = new JLabel("From:");
        fromLabel.setBounds(50, 260, 100, 25);
        add(fromLabel);

        fromField = new JTextField();
        fromField.setBounds(180, 260, 180, 25);
        add(fromField);

        JLabel toLabel = new JLabel("To:");
        toLabel.setBounds(50, 300, 100, 25);
        add(toLabel);

        toField = new JTextField();
        toField.setBounds(180, 300, 180, 25);
        add(toField);

        submitButton = new JButton("Insert");
        submitButton.setBounds(180, 340, 100, 30);
        submitButton.addActionListener(this);
        add(submitButton);
    }

    public void actionPerformed(ActionEvent e) {
        // You can expand this to save to file or database
        JOptionPane.showMessageDialog(this, "Reservation submitted successfully!");
        clearForm();
    }

    private void clearForm() {
        nameField.setText("");
        trainNumberField.setText("");
        trainNameField.setText("");
        dateField.setText("DD-MM-YYYY");
        fromField.setText("");
        toField.setText("");
        classTypeBox.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ReservationForm().setVisible(true));
    }
}
