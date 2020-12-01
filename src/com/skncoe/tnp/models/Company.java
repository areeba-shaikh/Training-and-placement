/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skncoe.tnp.models;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;

public class Company {

    private int ID;
    private String name;
    private String type;

    public Company(int companyID, String companyName, String Type) {
        this.ID = companyID;
        this.name = companyName;
        this.type = Type;
    }

    public Integer getcompid() {
        return ID;
    }

    public String getcompname() {
        return name;
    }

    public String gettype() {
        return type;
    }
}
