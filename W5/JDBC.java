import java.sql.*;

public class JDBC {
    public static void main(String[] args) {
        // DB connection details
        String url = "jdbc:mysql://localhost:3306/mydb"; // Replace 'mydb' with your database name
        String user = "root"; // Replace with your MySQL username
        String password = "MYSQL"; // Replace with your MySQL password

        // JDBC objects
        Connection conn = null;
        Statement stmt = null;

        try {
            // 1. Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Connect to database
            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();

            System.out.println("Connected to the database!");

            // 3. Create table if not exists
            String createTable = "CREATE TABLE IF NOT EXISTS student (" +
                                 "id INT PRIMARY KEY AUTO_INCREMENT, " +
                                 "name VARCHAR(100), " +
                                 "age INT)";
            stmt.executeUpdate(createTable);
            System.out.println(" Table created or already exists.");

            // 4. Insert a student
            String insert = "INSERT INTO student (name, age) VALUES ('Alice', 20)";
            stmt.executeUpdate(insert);
            System.out.println(" Inserted a student.");

            // 5. Update student
            String update = "UPDATE student SET age = 21 WHERE name = 'Alice'";
            stmt.executeUpdate(update);
            System.out.println("Updated student age.");

            // 6. Select and print students
            String select = "SELECT * FROM student";
            ResultSet rs = stmt.executeQuery(select);

            System.out.println(" Student Table:");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                System.out.println(id + " | " + name + " | " + age);
            }

            // 7. Close ResultSet
            rs.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 8. Clean up JDBC resources
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
