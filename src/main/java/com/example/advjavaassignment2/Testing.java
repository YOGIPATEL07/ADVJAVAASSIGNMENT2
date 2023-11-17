package com.example.advjavaassignment2;

public class Testing {
    public static void main(String[] args) {
        try {
            APIUtility.recieveAPI("charizard");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
