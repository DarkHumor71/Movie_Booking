/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author moudy
 */
public class Theater {
	
	 private char ID;
                private int capacity=-100;
                private String [] taken=null;
	private String sc;
	public Theater( char ID, int capacity,String sctime) {
		
		this.ID = ID;
                sc=sctime;
		this.capacity = capacity;
	}
        public Theater( char ID, int capacity,String taken[],String sctime) {
		this.taken=taken;
		this.ID = ID;
                sc=sctime;
		this.capacity = capacity;
	}
        public Theater( char ID,String taken[],String sctime) {
		this.taken=taken;
		this.ID = ID;
                sc=sctime;
		this.capacity = capacity;
	}

    public void setTaken(String[] taken) {
        this.taken = taken;
    }
     public void addTaken(String[] taken) {
        {
 int length = this.taken.length + taken.length; //add the length of firstArray into secondArray  
String[] mergedArray = new String[length];    //resultant array  
int pos = 0;  
for (String element : this.taken) //copying elements of secondArray using for-each loop  
{  
mergedArray[pos] = element;  
pos++;              //increases position by 1  
}  
for (String element : taken) //copying elements of firstArray using for-each loop  
{  
mergedArray[pos] = element;  
pos++;  
}  
this.taken=mergedArray;
         }
     }
    public String[] getTaken() {
        
        return taken;
    }
        
    public String getSc() {
        return sc;
    }

    public void setSc(String sc) {
        this.sc = sc;
    }

	public char getID() {
		return ID;
	}

	public int getCapacity() {
		return capacity;
	}

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

	@Override
	public String toString() {
            String tken="0";
            if(taken!=null){
                tken="";
            for(int x=0;x<taken.length;x++){
                if(x==taken.length-1){
                tken+=""+taken[x];
                
                }
                else {
                
                tken+=""+taken[x]+"-";
                }
            }
            }
            if(capacity==-100){
                return ID + "," +30+  tken+","+sc+"\n";
            }
		return   ID + "," + capacity+"," + tken+","+sc+"\n";
	}
//        public String toBookString(){
//            return   ID + "," + capacity+","+sc+"\n";
//        }
}
