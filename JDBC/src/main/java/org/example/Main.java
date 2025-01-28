package org.example;
import com.mysql.jdbc.Driver;
import java.sql.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        String url = "jdbc:mysql://localhost:3306/jdbc";
        String usn = "root";
        String pass = "Saurav@1";
        String query = "SELECT * FROM student";
        String insertQuery = "INSERT INTO student VALUES (111, '" + "Sarthak" + "')";
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, usn, pass);
        Statement st = con.createStatement();

        int col1 = st.executeUpdate(insertQuery);


        //prepared statements;
        String prepInsertQuery = "INSERT INTO student VALUES (?,?)";
        PreparedStatement pst = con.prepareStatement(prepInsertQuery);
        pst.setInt(1, 112);
        pst.setString(2, "Arpit");

        int col2 = pst.executeUpdate();

        ResultSet rs = st.executeQuery(query);
        rs.next();

        System.out.println((col1 + col2) + " rows affected");

        while (rs.next()) {
            String name = rs.getString("name");
            int rollNo = rs.getInt("rollno");
            System.out.println(rollNo + " " + name);

        }

        st.close();
        con.close();
    }
}