package com.example.learningfun.Model;

public class GridView1 {
    private int photo;
    private String name;

    public GridView1() {
    }

    public GridView1(int photo, String name) {
        this.photo = photo;
        this.name = name;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
