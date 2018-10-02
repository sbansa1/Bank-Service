package com.example;


//import com.sun.tools.internal.xjc.Driver;

import com.mysql.cj.jdbc.Driver;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Query;
import java.util.ArrayList;
import java.util.*;
import java.util.Properties;
import java.sql.*;

//import com.sun.javafx.collections.MappingChange;
//import com.sun.xml.internal.xsom.impl.scd.Iterators;

public class BankDatabase1 {

    private Connection connection;
   private SessionFactory sessionFactory = null;

    private Session session = null;


    public BankDatabase1() {

       sessionFactory = new Configuration().configure().buildSessionFactory();
       session = sessionFactory.openSession();

    }


    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public BankModel getBank(String ifscCode) {



        BankModel bm = new BankModel();
        Query query = null;
        List<BankModel> row = null;



        try {

            session.beginTransaction();
            String queryString = "from  bank_details where bank_ifsc = :ifscCode" ;
            query = session.createQuery(queryString);

            query.setParameter("ifscCode",ifscCode);



            //row = query.list();

           // for(int i = 0; i<row.size();i++){
              //  int Id = (int) row.get(i).getBank_id();
              //  String name = row.get(i).getBankName();
              //  String city = row.get(i).getBank_city();
              //  String district = row.get(i).getBank_District();
              //  String state = row.get(i).getBank_State();
              //  String address = row.get(i).getBank_Address();
              //  String branch = row.get(i).getBank_branch();

              //  bm = new BankModel(Id, name, city, district, state
               // ,address,branch);
           // }

          bm = (BankModel) query.uniqueResult();








        } catch (Exception e) {
            System.out.println(e);
        }

        finally {
            session.close();
           // System.out.println("Session problems");
        }


        return bm;
    }

    public List <BankModel> getBankDetails(String city, String bankName) {

        List<BankModel> row = new ArrayList<>();

        BankModel bm;
        Query query = null;


        try {
            session.beginTransaction();
            String q = "from bank_details where bank_city = :city AND  bank_name = :bankName";
            query = session.createQuery(q);
            query.setParameter("city", city);
            query.setParameter("bankName" ,bankName);

            row = query.list();

            //for(int i = 0; i<row.size();i++){
               // int Id = (int) row.get(i).getBank_id();
               // String name = row.get(i).getBankName();
               // String city1 = row.get(i).getBank_city();
               // String district = row.get(i).getBank_District();
               // String state = row.get(i).getBank_State();
               // String address = row.get(i).getBank_Address();
               // String branch = row.get(i).getBank_branch();

               // bm = new BankModel(Id, name, city1, district, state
                  //      ,address,branch);
                //row.add(bm);
           // }




        } catch (Exception e) {
            e.printStackTrace();
        }

        finally {
            session.close();
        }


        return row;
    }


}
