package Control;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import Model.*;
import java.util.HashMap;


public class FileAccess {

    
	public ArrayList<Customer> readCust(){
		ArrayList<Customer> cs=new ArrayList<>();
		try{
			Scanner sc=new Scanner(new File("Customer.csv"));
			while(sc.hasNextLine()){String i=sc.nextLine();
			cs.add(new Customer(
					i.split(",")[0],
					i.split(",")[1],
					Long.parseLong(i.split(",")[2]) 
					)
					);
			}
		} catch(Exception ex){
		}return cs;
	}

	public ArrayList<Theater> readtheater(){
		ArrayList<Theater> cs=new ArrayList<>();
		try{
			Scanner sc=new Scanner(new File("Theater.csv"));
                        String[] q=null;
			while(sc.hasNextLine()){String i=sc.nextLine();
//                        if(!("none".equals(i.split(",")[2]))){
//                            q=new String[i.split(",")[2].split("-").length];
//                            for(int w=0;w<i.split(",")[2].split("-").length;w++){
//                                
//                            q[w]=i.split(",")[2].split("-")[w];
//                        }
//                        }
			cs.add(
					new Theater(
							i.split(",")[0].toCharArray()[0] ,//id
							Integer.parseInt(i.split(",")[1]) ,//capacity
                                                        q,//taken array
							i.split(",")[3] //sctime
							)
					);
			}
		} catch(Exception ex){}
		return cs;}

	public ArrayList<Payment> readpays(){
		ArrayList<Payment> cs=new ArrayList<>();
		try{
			Scanner sc=new Scanner(new File("Payment.csv"));
			while(sc.hasNextLine()){String i=sc.nextLine();
			cs.add(new Payment(
					i.split(",")[0],
					Double.parseDouble(i.split(",")[1])	,//price
					i.split(",")[2] 
					)
					);
			}
		} catch(Exception ex){
		}return cs;
	}

	public ArrayList<Manager> readmng(){
		ArrayList<Manager> cs=new ArrayList<>();
		try{
			Scanner sc=new Scanner(new File("Manager.csv"));
			while(sc.hasNextLine()){String i=sc.nextLine();
			cs.add(new Manager(
					i.split(",")[0],
					i.split(",")[1] 
					)
					);
			}
		} catch(Exception ex){
		}return cs;
	}
        public HashMap readScreenInverse(){
		HashMap mp=new HashMap();
               try{
                   Scanner sc=new Scanner(new File("Screen.csv"));
                   
                   while(sc.hasNextLine()){
                       String[] i=sc.nextLine().split(",");
                              
                   mp.put(i[1], i[0]);
                   }
               }catch(Exception e){
                   
               }
                return mp;
	}
        public HashMap<String,String> readScreen(){
		HashMap mp=new HashMap();
               try{
                   Scanner sc=new Scanner(new File("Screen.csv"));
                 
                   while(sc.hasNextLine()){ String[] i=sc.nextLine().split(",");
                   mp.put(i[0], i[1]);
                   }
               }catch(Exception e){
                   
               }
                return mp;
	}
        

        public ArrayList<Movie> readmovie(){
            ArrayList<Movie> arm=new ArrayList<>();
            try{
			Scanner sc=new Scanner(new File("Movie.csv"));
                     	while(sc.hasNextLine()){String i=sc.nextLine();
                          arm.add( new Movie(
                                                        i.split(",")[0],//name
                                                        i.split(",")[1],//description
							Double.parseDouble(i.split(",")[2]),//price
							new File(i.split(",")[3]))// image
                                  
                          );
                        }
                        
            }catch(Exception e){
                
            }
            return arm;
        }
//	public ArrayList<Book> readbook(){
//		ArrayList<Book> cs=new ArrayList<>();
//		try{
//			Scanner sc=new Scanner(new File("Book.csv"));
//			while(sc.hasNextLine()){String i=sc.nextLine();
//                        String te=i.split(",")[5];
//                        String[] tek=te.split("-");
//                        String t[]=new String[tek.length];
//                        for(int q=0;q<t.length;q++){
//                            t[q]=tek[q];
//                        }
//			cs.add(new Book(
//					new Customer(
//							i.split(",")[0],//name
//							i.split(",")[1],//pass
//							Long.parseLong(i.split(",")[2])//card 
//							),
//					new Theater(
//							i.split(",")[3].toCharArray()[0] ,//ID
//							Integer.parseInt(i.split(",")[4]) ,//capacity
//                                                        t,
//							i.split(",")[6] //sctime
//							),
//                                        new Movie(
//                                                        i.split(",")[7],//name
//                                                        i.split(",")[8],//description
//							Double.parseDouble(i.split(",")[9]),//price
//							new File(i.split(",")[10])),
//					new Payment(
//							
//							Double.parseDouble(i.split(",")[11]),//amount
//							i.split(",")[12] //time
//							)
//					)
//					);
//			}
//		} catch(Exception ex){
//		}return cs;
//	}

	//writers
	public void Write(String file,String in){
		try {
			FileWriter fw=new FileWriter(file+".csv",true);
			fw.write(in);
			fw.close();
		}catch(Exception ex) {

		}

	}
	public void resetf(String file) {
		try {
			FileWriter fw=new FileWriter(file+".csv");
			fw.close();
		}catch(Exception ex) {

		}
	}
}
