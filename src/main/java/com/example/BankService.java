package com.example;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;

@Path("/BankService")
public class BankService {



    @GET
    @Path("/banks/{IfscCode}")
    @Produces(MediaType.APPLICATION_XML)
    public BankModel getBankDetails(@PathParam("IfscCode") String ifsc_Code) {

        //int code = Integer.IfscCode;
         BankModel bank = null;

         BankDatabase1 ds = new BankDatabase1();


        try {
            bank = ds.getBank(ifsc_Code);
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }

        System.out.println(bank);
        return bank;
    }


}













