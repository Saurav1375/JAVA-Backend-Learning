package org.example;

import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class JDBCWithDao {
    public static void main(String[] args){
        StudentsDao dao = new StudentsDao();
        Student s = dao.getStudentByRollNo(101);
        System.out.println("Student: " +  s.name);

        Student s1 = new Student(125, "Rohit");
        boolean result = dao.addStudent(s1);

        if(result) System.out.println("Student added Successfully");
        else System.out.println("Fail to add Student");

        Student s2 = dao.getStudentByRollNo(125);
        System.out.println("Student: " +  s2.name);

    }
}

class Student {


    int rollNo;
    String name;
    public Student(){}

    public Student(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
    }
}
class StudentsDao {
    public Student getStudentByRollNo(int rollNo) {
        Student s = new Student();
        s.rollNo = rollNo;
        String query = "SELECT * FROM student WHERE rollNo=" + rollNo;

        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/jdbc",
                    "root",
                    "Saurav@1"
            );
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.next();
            s.name = rs.getString(2);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return s;

    }

    public boolean addStudent(Student s) {
        String query = "INSERT INTO student VALUES (" + s.rollNo + ", '" + s.name + "')";
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/jdbc",
                    "root",
                    "Saurav@1"
            );
            Statement st = con.createStatement();
            int rs = st.executeUpdate(query);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }
}
