/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author moudy
 */
public class Customer {
    private String name, pass;private long card;
    public Customer(String name,String pass,long card){
        this.name=name;this.pass=pass;this.card=card;
    }
    public Customer(String name,long card){
        this.name=name;this.card=card;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        
        return  pass==null?(name + "," + card+"\n"):(name + "," + pass + "," + card+"\n") ;
    }

    public String getPass() {
        return pass;
    }

    public long getCard() {
        return card;
    }
}
