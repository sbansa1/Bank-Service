package com.example;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;


@Path("/BankService")
public class BankDetailService {


    @GET
    @Path("bankDetails/{bank_name}/{bank_city}")
    @Produces(MediaType.APPLICATION_XML)
    public List<BankModel> getBankBranchDetails(@PathParam("bank_name") String bank_name, @PathParam("bank_city") String bank_city) {

        List<BankModel> banklist = new ArrayList <>();
        BankDatabase1 ds = new BankDatabase1();
        banklist =  ds.getBankDetails(bank_city,bank_name);
        return banklist;
    }
}

