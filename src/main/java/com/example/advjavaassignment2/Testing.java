package com.example.advjavaassignment2;

public class Testing {
    //TEST THE API
    public static void main(String[] args) {
        try {
            APIUtility.recieveAPI("charizard");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
