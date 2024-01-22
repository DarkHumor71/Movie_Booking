/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author moudy
 */
public class Manager {
    private String user,pass;

    @Override
    public String toString() {
        return  user + "," + pass+"\n" ;
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }

    public Manager(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }
    
}
