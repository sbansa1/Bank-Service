package com.example;


import jersey.repackaged.com.google.common.collect.BiMap;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/BankService")
public class BankService {



    @GET
    @Path("/banks/{IfscCode}")
    @Produces(MediaType.APPLICATION_XML)
    public BankModel getBankDetails(@PathParam("IfscCode") String ifsc_Code) {

        //int code = Integer.IfscCode;
        BankModel bank = null;

         BankDatabase ds = new BankDatabase();


        try {
            bank = ds.getBank(ifsc_Code);
            System.out.print(ds.getConnection().getSchema());
            //System.out.println(banklist);
        } catch (SQLException e) {
            System.out.println(e.getSQLState());
        }

        System.out.println(bank);
        return bank;
    }
}













