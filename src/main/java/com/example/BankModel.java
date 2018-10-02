package com.example;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity(name = "bank_details")
public class BankModel {

   @Id
    private int bank_id;

   @Column(name = "bank_name")
    private String bankName;

   @Column(name = "bank_ifsc")
   private String ifsc_Code;

    private String bank_city;

    private String bank_branch;

    @Column(name = "bank_state")
    private String bank_State;
    @Column(name = "bank_district")

    private String bank_District;
    @Column(name = "bank_address")

    private String bank_Address;



    public BankModel(){

    }

    public BankModel(String bank_branch){

        this.bank_branch = bank_branch;
        //this.ifsc_Code = ifsc_code;
    }


    public BankModel(int bank_id,String bankName, String bank_city, String bank_branch, String bank_State, String bank_District, String bank_Address) {

        this(bank_branch);
        this.bank_id = bank_id;
        this.bankName = bankName;
        this.bank_city = bank_city;
       // this.bank_branch = bank_branch;
        this.bank_State = bank_State;
        this.bank_District = bank_District;
        this.bank_Address = bank_Address;
    }



    public String getBank_branch() {
        return bank_branch;
    }

    public void setBank_branch(String bank_branch) {
        this.bank_branch = bank_branch;
    }

    public long getBank_id() {
        return bank_id;
    }

    public void setBank_id(int bank_id) {
        this.bank_id = bank_id;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getIfsc_Code() {
        return ifsc_Code;
    }

    public void setIfsc_Code(String ifsc_Code) {
        this.ifsc_Code = ifsc_Code;
    }


    public String getBank_city() {
        return bank_city;
    }

    public void setBank_city(String bank_city) {
        this.bank_city = bank_city;
    }


    public String getBank_State() {
        return bank_State;
    }

    public void setBank_State(String bank_State) {
        this.bank_State = bank_State;
    }

    public String getBank_District() {
        return bank_District;
    }

    public void setBank_District(String bank_District) {
        this.bank_District = bank_District;
    }

    public String getBank_Address() {
        return bank_Address;
    }

    public void setBank_Address(String bank_Address) {
        this.bank_Address = bank_Address;
    }
}
