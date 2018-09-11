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
            String connectionURL = "jdbc:mysql://localhost:3306/Bank";
            Driver d = new Driver();
            DriverManager.registerDriver(d);
            Properties p = new Properties();
            p.setProperty("user", "root");
            p.setProperty("password", "Root@0012");

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
                bm = new BankModel(rs.getString("bank_name"), rs.getString("bank_city"), rs.getString("bank_branch"), rs.getString("bank_state"), rs.getString("bank_district"), rs.getString("bank_address"));
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
                bm = new BankModel(rs.getString("bank_name"), rs.getString("bank_city"), rs.getString("bank_branch"), rs.getString("bank_state"), rs.getString("bank_district"), rs.getString("bank_address"));
                list.add(bm);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return list;
    }


    public Map<Long, BankModel> allgetBankDetails() {

        ArrayList <BankModel> list = new ArrayList <>();
        BankModel bm;

        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("Select * from bank_details");


            while (rs.next()) {
                bm = new BankModel(rs.getString("bank_name"), rs.getString("bank_city"), rs.getString("bank_branch"), rs.getString("bank_state"), rs.getString("bank_district"), rs.getString("bank_address"));
                list.add(bm);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return (Map <Long, BankModel>) list;


    }

}
