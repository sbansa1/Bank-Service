package com.example;

//import com.sun.tools.internal.xjc.Driver;

import java.sql.*;
import java.util.Properties;
import com.mysql.cj.jdbc.Driver;
//import com.sun.javafx.collections.MappingChange;
//import com.sun.xml.internal.xsom.impl.scd.Iterators;
import java.util.*;

public class BankDatabase {

    private Connection connection;

    public BankDatabase() {
        try {


            String connectionURL = "jdbc:mysql://localhost:3306/Bank?useSSL=false";
            connectionURL = "jdbc:mysql://us-cdbr-iron-east-01.cleardb.net:3306/heroku_77529bb8a159cbb?useSSL=false";
            Driver d = new Driver();
            DriverManager.registerDriver(d);
            Properties p = new Properties();
            p.setProperty("user", "b15e88e572c814");
            p.setProperty("password", "a39ed036");

            this.connection = d.connect(connectionURL, p);
        } catch (Exception e) {

        }
    }


    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public BankModel getBank(String ifscCode) {

        BankModel bm = null;

        try {

            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("Select * from  bank_details where bank_ifsc = '" + ifscCode + "'");

            while (rs.next()) {
                bm = new BankModel(rs.getInt("bank_id"),rs.getString("bank_name"), rs.getString("bank_city"), rs.getString("bank_branch"), rs.getString("bank_state"), rs.getString("bank_district"), rs.getString("bank_address"));
            }


        } catch (SQLException e) {
            System.out.println(e);
        }


        return bm;
    }

    public List <BankModel> getBankDetails(String city, String bankName) {

        ArrayList <BankModel> list = new ArrayList <>();
        BankModel bm;

        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("Select * from bank_details where bank_city = '" + city + "' AND " + "bank_name = '" + bankName + "'");


            while (rs.next()) {
                bm = new BankModel(rs.getInt("bank_id"),rs.getString("bank_name"), rs.getString("bank_city"), rs.getString("bank_branch"), rs.getString("bank_state"), rs.getString("bank_district"), rs.getString("bank_address"));
                list.add(bm);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return list;
    }


}

