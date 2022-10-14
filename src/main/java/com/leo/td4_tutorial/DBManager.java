package com.leo.td4_tutorial;

import javax.xml.transform.Result;
import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class DBManager {

    public List<Student> loadStudents() {
        List<Student> studentAll = new ArrayList<Student>();
        Connection myConn = this.Connector();
        try{
            Statement myStmt = myConn.createStatement();
            String sql = "SELECT * FROM studenttable";

            ResultSet myRs = myStmt.executeQuery(sql);

            while (myRs.next()){
                Student student = new Student(myRs.getInt("id"), myRs.getString("name"), myRs.getString("gender"));
                studentAll.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Connection Connector(){
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root", "root");
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void Close(Connection myConn, Statement myStmt, ResultSet myRs) throws SQLException {
        try {
            if (myRs != null) {
                myRs.close();
            }
            if (myStmt != null) {
                myStmt.close();
            }
            if (myConn != null) {
                myConn.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
