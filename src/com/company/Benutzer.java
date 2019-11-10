package com.company;

public class Benutzer {

    String userId;
    char[] passWort;


    Benutzer() {
        userId = "";
        passWort = "".toCharArray();
    }

    Benutzer(String n_userId, char[] n_passWort){
        userId = n_userId;
        passWort = n_passWort;
    }

    public boolean equals(Object benutzer){
        if(benutzer == null || !(benutzer instanceof Benutzer)){
            return false;
        }
        String pw = new String();
        String pw2 = new String();
        pw.copyValueOf(this.passWort);
        pw2.copyValueOf(((Benutzer) benutzer).passWort);
        if(this.userId.equals(((Benutzer) benutzer).userId) && pw.equals(pw2)){
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

