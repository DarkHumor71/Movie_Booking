/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.File;

/**
 *
 * @author moudy
 */
public class Movie {
    
    private double price;
    private String name,description;
    private File img;

    public String getDescription() {
        return description;
    }

    public File getImg() {
        return img;
    }
    

    public Movie(String name,String desc,double price,File img) {
        this.price = price;
        this.description=desc;
        this.name=name;
        this.img=img;
        
    }

    @Override
    public String toString() {
        return name+","+ description+  "," + price+","+img.getPath()+"\n" ;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

}
