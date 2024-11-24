package Lab10;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class LoginRegistrationApp {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/sys";
    private static final String DB_USER = "root"; 
    private static final String DB_PASSWORD = "sli19181"; 
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginRegistrationApp().showLoginPage());
    }

    public Connection connectToDatabase() {
        try {
            return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void showLoginPage() {
        JFrame frame = new JFrame("Login");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JLabel usernameLabel = new JLabel("Username:");
        JTextField usernameField = new JTextField(20);
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField(20);
        JButton loginButton = new JButton("Login");
        JButton registerButton = new JButton("Register");

        frame.add(usernameLabel);
        frame.add(usernameField);   
        frame.add(passwordLabel);
        frame.add(passwordField);
        frame.add(loginButton);
        frame.add(registerButton);

        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            if (login(username, password)) {
                JOptionPane.showMessageDialog(frame, "Login successful!");
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid username or password!");
            }
        });

        registerButton.addActionListener(e -> {
            showRegistrationPage();
        });

        frame.setVisible(true);
    }

    public void showRegistrationPage() {
        JFrame frame = new JFrame("Register");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JLabel usernameLabel = new JLabel("Username:");
        JTextField usernameField = new JTextField(20);
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField(20);
        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField(20);
        JButton registerButton = new JButton("Register");

        frame.add(usernameLabel);
        frame.add(usernameField);
        frame.add(passwordLabel);
        frame.add(passwordField);
        frame.add(emailLabel);
        frame.add(emailField);
        frame.add(registerButton);

        registerButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            String email = emailField.getText();

            if (register(username, password, email)) {
                JOptionPane.showMessageDialog(frame, "Registration successful!");
                frame.dispose();
                showLoginPage(); 
            } else {
                JOptionPane.showMessageDialog(frame, "Error: Could not register user!");
            }
        });

        frame.setVisible(true);
    }

    public boolean login(String username, String password) {
        try (Connection conn = connectToDatabase()) {
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();
            return rs.next(); 
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean register(String username, String password, String email) {
        try (Connection conn = connectToDatabase()) {
            String checkQuery = "SELECT * FROM users WHERE username = ?";
            PreparedStatement checkStmt = conn.prepareStatement(checkQuery);
            checkStmt.setString(1, username);

            ResultSet rs = checkStmt.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Username already exists!");
                return false;
            }

            String insertQuery = "INSERT INTO users (username, password, email) VALUES (?, ?, ?)";
            PreparedStatement insertStmt = conn.prepareStatement(insertQuery);
            insertStmt.setString(1, username);
            insertStmt.setString(2, password);
            insertStmt.setString(3, email);

            int rowsAffected = insertStmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
