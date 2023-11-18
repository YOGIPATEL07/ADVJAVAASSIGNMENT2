package com.example.advjavaassignment2;

import com.google.gson.annotations.SerializedName;

public class Pokemon {
    @SerializedName("Id")
    private String id;
    @SerializedName("Name")
    private String name;
    @SerializedName("Supertype")
    private String supertype;
    @SerializedName("Level")
    private String level;
    @SerializedName("Hp")
    private String hp;

    public String getId(){return id;}
    public String getName(){return name;}
    public String getSupertype(){return supertype;}
    public String getLevel(){return level;}
    public String getHp(){return hp;}
}
