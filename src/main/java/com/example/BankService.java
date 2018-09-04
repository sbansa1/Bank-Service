package com.example;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;

@Path("/BankService")
public class BankService {


    @GET
    @Path("/banks/{IfscCode}")
    @Produces(MediaType.APPLICATION_JSON)
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
        return bank;
    }
}













