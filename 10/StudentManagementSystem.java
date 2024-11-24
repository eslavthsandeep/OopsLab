package Lab10;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class StudentManagementSystem implements ActionListener {
    private JFrame frame;
    private JTextField studentIdField, nameField, ageField, genderField, departmentField;
    private JButton addButton, updateButton, deleteButton, viewButton;
    private JTable studentTable;
    private DefaultTableModel tableModel;
    private Connection connection;

    public StudentManagementSystem() {
        frame = new JFrame("Student Management System");
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        connectToDatabase();

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(6, 2, 10, 10));

        formPanel.add(new JLabel("Student ID:"));
        studentIdField = new JTextField();
        formPanel.add(studentIdField);

        formPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        formPanel.add(nameField);

        formPanel.add(new JLabel("Age:"));
        ageField = new JTextField();
        formPanel.add(ageField);

        formPanel.add(new JLabel("Gender:"));
        genderField = new JTextField();
        formPanel.add(genderField);

        formPanel.add(new JLabel("Department:"));
        departmentField = new JTextField();
        formPanel.add(departmentField);

        addButton = new JButton("Add");
        addButton.addActionListener(this);
        formPanel.add(addButton);

        updateButton = new JButton("Update");
        updateButton.addActionListener(this);
        formPanel.add(updateButton);

        deleteButton = new JButton("Delete");
        deleteButton.addActionListener(this);
        formPanel.add(deleteButton);

        viewButton = new JButton("View");
        viewButton.addActionListener(this);
        formPanel.add(viewButton);

        frame.add(formPanel, BorderLayout.NORTH);

        tableModel = new DefaultTableModel();
        tableModel.addColumn("Student ID");
        tableModel.addColumn("Name");
        tableModel.addColumn("Age");
        tableModel.addColumn("Gender");
        tableModel.addColumn("Department");

        studentTable = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(studentTable);
        frame.add(tableScrollPane, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private void connectToDatabase() {
        try {
            String url = "jdbc:mysql://localhost:3306/sys";
            String username = "root";
            String password = "sli19181";    

            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(frame, "Failed to connect to database: " + e.getMessage());
        }
    }

    private void addStudent() {
        try {
            String sql = "INSERT INTO students (student_id, name, age, gender, department) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, Integer.parseInt(studentIdField.getText()));
            preparedStatement.setString(2, nameField.getText());
            preparedStatement.setInt(3, Integer.parseInt(ageField.getText()));
            preparedStatement.setString(4, genderField.getText());
            preparedStatement.setString(5, departmentField.getText());

            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(frame, "Student added successfully.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(frame, "Error adding student: " + e.getMessage());
        }
    }

    private void updateStudent() {
        try {
            String sql = "UPDATE students SET name = ?, age = ?, gender = ?, department = ? WHERE student_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, nameField.getText());
            preparedStatement.setInt(2, Integer.parseInt(ageField.getText()));
            preparedStatement.setString(3, genderField.getText());
            preparedStatement.setString(4, departmentField.getText());
            preparedStatement.setInt(5, Integer.parseInt(studentIdField.getText()));

            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(frame, "Student updated successfully.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(frame, "Error updating student: " + e.getMessage());
        }
    }

    private void deleteStudent() {
        try {
            String sql = "DELETE FROM students WHERE student_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, Integer.parseInt(studentIdField.getText()));

            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(frame, "Student deleted successfully.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(frame, "Error deleting student: " + e.getMessage());
        }
    }

    private void viewStudents() {
        try {
            String sql = "SELECT * FROM students";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            tableModel.setRowCount(0);

            while (resultSet.next()) {
                Object[] row = new Object[5];
                row[0] = resultSet.getInt("student_id");
                row[1] = resultSet.getString("name");
                row[2] = resultSet.getInt("age");
                row[3] = resultSet.getString("gender");
                row[4] = resultSet.getString("department");

                tableModel.addRow(row);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(frame, "Error fetching student data: " + e.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            addStudent();
        } else if (e.getSource() == updateButton) {
            updateStudent();
        } else if (e.getSource() == deleteButton) {
            deleteStudent();
        } else if (e.getSource() == viewButton) {
            viewStudents();
        }
    }

    public static void main(String[] args) {
        new StudentManagementSystem();
    }
}