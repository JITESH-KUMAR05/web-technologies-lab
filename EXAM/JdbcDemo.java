import java.sql.*;

public class SimpleJDBC {
    
    public static void main(String[] args) {
        
        // Database connection details
        String url = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String password = "your_password";  // Change this
        
        try {
            // Step 1: Load JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded!");
            
            // Step 2: Connect to MySQL
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to MySQL!");
            
            Statement stmt = con.createStatement();
            
            // Step 3: Create Database
            stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS CollegeDB");
            System.out.println("Database created!");
            
            // Connect to the database
            con = DriverManager.getConnection(url + "CollegeDB", user, password);
            stmt = con.createStatement();
            
            // ========================================
            // TABLE CREATION (DDL)
            // ========================================
            
            System.out.println("\n--- TABLE CREATION ---");
            
            String createTable = "CREATE TABLE IF NOT EXISTS Student (" +
                               "ID INT PRIMARY KEY, " +
                               "Name VARCHAR(50), " +
                               "Age INT, " +
                               "Marks INT)";
            
            stmt.executeUpdate(createTable);
            System.out.println("Table created successfully!");
            
            
            // ========================================
            // DATA MANIPULATION (DML)
            // ========================================
            
            // 1. INSERT DATA
            System.out.println("\n--- INSERT DATA ---");
            
            stmt.executeUpdate("INSERT INTO Student VALUES (1, 'Raj', 20, 85)");
            stmt.executeUpdate("INSERT INTO Student VALUES (2, 'Priya', 21, 90)");
            stmt.executeUpdate("INSERT INTO Student VALUES (3, 'Amit', 19, 78)");
            
            System.out.println("Data inserted successfully!");
            
            
            // 2. SELECT DATA (Display all records)
            System.out.println("\n--- SELECT DATA ---");
            
            ResultSet rs = stmt.executeQuery("SELECT * FROM Student");
            
            System.out.println("ID\tName\tAge\tMarks");
            System.out.println("--------------------------------");
            
            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("Name");
                int age = rs.getInt("Age");
                int marks = rs.getInt("Marks");
                
                System.out.println(id + "\t" + name + "\t" + age + "\t" + marks);
            }
            
            
            // 3. UPDATE DATA
            System.out.println("\n--- UPDATE DATA ---");
            
            stmt.executeUpdate("UPDATE Student SET Marks = 95 WHERE ID = 2");
            System.out.println("Data updated successfully!");
            
            // Display updated data
            rs = stmt.executeQuery("SELECT * FROM Student WHERE ID = 2");
            if (rs.next()) {
                System.out.println("Updated: " + rs.getString("Name") + 
                                 " - Marks: " + rs.getInt("Marks"));
            }
            
            
            // 4. DELETE DATA
            System.out.println("\n--- DELETE DATA ---");
            
            stmt.executeUpdate("DELETE FROM Student WHERE ID = 3");
            System.out.println("Data deleted successfully!");
            
            // Display remaining data
            rs = stmt.executeQuery("SELECT COUNT(*) FROM Student");
            if (rs.next()) {
                System.out.println("Total records remaining: " + rs.getInt(1));
            }
            
            
            // Step 4: Close connections
            rs.close();
            stmt.close();
            con.close();
            
            System.out.println("\n✓ All operations completed!");
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}