package com.company;

import java.util.ArrayList;

//=======ситуация=======
public class Situation {
    ArrayList<Situation> direction;
    String subject,text;
    int dK,dA,dR;
    public Situation (String subject, String text, int dk,int da,int dr) {
        this.subject=subject;
        this.text=text;
        dK=dk;
        dA=da;
        dR=dr;
        direction=new ArrayList<>();
    }
}