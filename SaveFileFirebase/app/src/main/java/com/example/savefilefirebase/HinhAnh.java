package com.example.savefilefirebase;

public class HinhAnh {
    String Name;
    String LinkImage;

    public HinhAnh() {
    }

    public HinhAnh(String name, String linkImage) {
        Name = name;
        LinkImage = linkImage;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLinkImage() {
        return LinkImage;
    }

    public void setLinkImage(String linkImage) {
        LinkImage = linkImage;
    }
}
