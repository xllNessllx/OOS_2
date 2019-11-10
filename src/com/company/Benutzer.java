package com.company;

public class Benutzer {

    String userId;
    char[] passWort;


    Benutzer() {
        userId = "";
    }

    Benutzer(String n_userId, char[] n_passWort){
        userId = n_userId;
        passWort = n_passWort;
    }

    public boolean equals(Benutzer benutzer){
        String pw = new String();
        String pw2 = new String();
        pw.copyValueOf(this.passWort);
        pw2.copyValueOf(benutzer.passWort);
        if(this.userId.equals(benutzer.userId) && pw.equals(pw2)){
            return true;
        }
        return false;
    }

     public String toString(){
        String pw = new String();
        pw.copyValueOf(passWort);
        return "User: " + userId + ", PW: " + pw;
    }

}

