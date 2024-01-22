package Control;

import Model.Book;
import java.util.ArrayList;
import Model.Customer;
import Model.Manager;
import Model.Movie;
import Model.Payment;
import Model.Theater;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class AppControl {

    FileAccess fA;
    
    public AppControl() {
        fA = new FileAccess();
        
    }
//Movie related methods:

    public void addmovie(String name, String desc, double price, File img) {
        fA.Write("Movie", new Movie(name, desc, price, img).toString());
    }

    public Path storeImg(Path in, String name) {
        Path out = null;
        try {
            out = (Path) Paths.get("C:\\Users\\moudy\\Documents\\NetBeansProjects\\Movie_Booking\\" + name);
            Files.copy(in, out, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
        }
        return out;
    }

    public double getMoviePrice(String name) {
        return findMovie(name).getPrice();
    }

    public String getMoviename(Movie x) {
        return x.getName();
    }

    public String getMoviedesc(String x) {
        return findMovie(x).getDescription();
    }

    public String getMovieimg(Movie x) {
        return x.getImg().getAbsolutePath();
    }

    public int getnbofMovie() {
        return fA.readmovie().size();
    }

    public ArrayList<Movie> getallMovie() {
        return fA.readmovie();
    }

    public ImageIcon display(String x) {
        File f = findMovie(x).getImg();
        ImageIcon im = null;
        try {
            BufferedImage myPicture = ImageIO.read(f);
            if (myPicture.getHeight() <= 130 && myPicture.getWidth() <= 130) {
                im = new ImageIcon(myPicture);
            } else {
                JOptionPane.showMessageDialog(null, "picture is too big");
            }
        } catch (IOException e) {
        }
        return im;
    }

    public ImageIcon display(File f) {
        ImageIcon im = null;
        try {
            BufferedImage myPicture = ImageIO.read(f);
            if (myPicture.getHeight() <= 130 && myPicture.getWidth() <= 130) {
                im = new ImageIcon(myPicture);
            } else {
                myPicture = ImageIO.read(new File("errorr.png"));
                im = new ImageIcon(myPicture);
            }
        } catch (IOException e) {
        }
        return im;
    }

    public Movie findMovie(String name) {
        Movie m = null;
        ArrayList<Movie> arr = fA.readmovie();
        for (int i = 0; i < arr.size(); i++) {
            if (name.equals(arr.get(i).getName())) {
                m = arr.get(i);
            } else {
            }
        }
        return m;
    }

    public boolean delete(Movie m) {
        ArrayList<Movie> mng = fA.readmovie();
        boolean flag = false;
        for (int i = 0; i < mng.size(); i++) {
            if (mng.get(i).toString().equals(m.toString())) {
                mng.remove(i);
                flag = true;
                mng.get(i).getImg().delete();
            }
        }
        fA.resetf("Movie");
        for (Movie x : mng) {
            fA.Write("Movie", x.toString());
        }
        deleteScreen(m);

        return flag;
    }

    public Theater MovietoTheater(String name) {
        HashMap mp = fA.readScreenInverse();
        return findTheater(("" + mp.get("" + name)).toCharArray()[0]);
    }

    //Theater related methods
    public boolean delete(Theater m) {
        ArrayList<Theater> mng = fA.readtheater();
        boolean flag = false;
        for (int i = 0; i < mng.size(); i++) {
            if (mng.get(i).toString().equals(m.toString())) {
                mng.remove(i);
                flag = true;
            }
        }
        fA.resetf("Theater");
        for (Theater x : mng) {
            fA.Write("Theater", x.toString());
        }
        deleteScreen(m);
        return flag;
    }

    public Movie TheatertoMovie(String name) {
        HashMap mp = fA.readScreen();
        return findMovie(("" + mp.get("" + name)));
    }

    public String getTheatertime(Theater x) {
        return x.getSc();
    }

    public int getTheatercap(Theater x) {
        return x.getCapacity();
    }

    public void editTheaterTime(char chosen, String time) {
        ArrayList<Theater> th = fA.readtheater();
        int i = 0;
        for (i = 0; i < th.size(); i++) {
            if (th.get(i).getID() == chosen) {
                break;
            }
        }

        th.get(i).setSc(time);
        fA.resetf("Theater");
        for (Theater x : th) {
            fA.Write("Theater", x.toString());
        }
    }

    public Theater findTheater(char ID) {
        Theater m = null;
        ArrayList<Theater> arr = fA.readtheater();
        for (int i = 0; i < arr.size(); i++) {
            if (ID == (arr.get(i).getID())) {
                m = arr.get(i);
            } else {
                try {
                    throw new NullPointerException();
                } catch (NullPointerException e) {
                    System.out.println("Theater not found");
                }
            }
        }
        return m;
    }

    public ArrayList<String> gettakenseat(Theater x) {
        String[] fty = x.getTaken();
        ArrayList<String> toList = new ArrayList<>();
        if(fty!=null){
        for (int i = 0; i < fty.length; i++) {
            toList.add(fty[i]);
        }
        return toList;}
        return null;
    }

    public int gettakenseatnb(Theater x) {
        if (x.getTaken() != null) {
            return x.getTaken().length;
        } else {
            return 0;
        }
    }

    public void addtheater() {
        char h = (char) 64;
        ArrayList<Theater> mng = fA.readtheater();
        for (int i = 0; i < mng.size(); i++) {
            if (mng.get(i).getID() > h) {
                h = mng.get(i).getID();
            }
        }
        h++;
        fA.Write("Theater",
                new Theater(h, 30, "00:00").toString());
    }

    public Theater getTheater(char ID) {
        Theater ma = null;
        ArrayList<Theater> mng = fA.readtheater();
        for (int i = 0; i < mng.size(); i++) {
            if (mng.get(i).getID() == (ID)) {
                ma = mng.get(i);
            }
        }
        return ma;
    }

    public char getTheaterID(String x) {
        return getTheater(x.toCharArray()[0]).getID();
    }

    public char getTheaterID(Theater x) {
        return x.getID();
    }

    public void editTheaterTakenSeats(char chosen, String[] tek) {
        ArrayList<Theater> th = fA.readtheater();
        int i = 0;
        for (i = 0; i < th.size(); i++) {
            if (th.get(i).getID() == chosen) {
                break;
            }
        }

        th.get(i).addTaken(tek);
        th.get(i).setCapacity(th.get(i).getCapacity() - tek.length);
        fA.resetf("Theater");
        for (Theater x : th) {
            fA.Write("Theater", x.toString());
        }
    }

    public ArrayList<Theater> getallTheater() {
        return fA.readtheater();
    }

    public ArrayList<Character> getallTheaterID() {
        ArrayList<Character> out = new ArrayList<>();
        for (Theater x : fA.readtheater()) {
            out.add(x.getID());
        }

        return out;
    }
//Payment

    public String printallPayments() {
        String out = "";
        for (int i = 0; i < fA.readpays().size(); i++) {
            out += fA.readpays().get(i) + "\n";
        }

        return out;
    }

    public void addpay(String name, String amount) {
        Payment m = new Payment(name, Double.parseDouble(amount));
        fA.Write("Payment", m.toString());

    }
//Customer

    public void addcst(String user, String pass, long cc) {

        fA.Write("Customer", new Customer(user, pass, cc).toString());

    }

    public long getusercard(String user) {
        ArrayList<Customer> c = fA.readCust();
        for (int i = 0; i < c.size(); i++) {
            if (c.get(i).getName().equals(user)) {
                return c.get(i).getCard();
            }
        }
        return 0;
    }

    public String getCustomerName(Customer x) {
        return x.getName();
    }
//Manager

    public Manager getManager(String user) {
        Manager ma = null;
        ArrayList<Manager> mng = fA.readmng();
        for (int i = 0; i < mng.size(); i++) {
            if (mng.get(i).getUser().equals(user)) {
                ma = mng.get(i);
            }
        }
        return ma;
    }

    public String getmngname(Manager x) {
        return x.getUser();
    }

    public ArrayList<Manager> getallmng() {
        return fA.readmng();
    }

    public boolean delete(Manager m) {
        ArrayList<Manager> mng = fA.readmng();

        boolean flag = false;
        for (int i = 0; i < mng.size(); i++) {
            if (mng.get(i).toString().equals(m.toString())) {
                mng.remove(i);
                flag = true;
            }
        }
        fA.resetf("Manager");
        for (Manager x : mng) {
            fA.Write("Manager", x.toString());
        }
        return flag;

    }

    public void addmng(String m, String p) {
        fA.Write("Manager", new Manager(m, p).toString());
    }

    //Book
    public void addbook(String cname, String card,
            String ID, String capacity, String[] take, String sctime,
            String mname, String description, String price, String f,
            String amount) {
        fA.Write("Book", new Book(
                new Customer(
                        cname,
                        Long.parseLong(card)
                ),
                new Theater(
                        ID.toCharArray()[0],//ID
                        Integer.parseInt(capacity),//capacity
                        take,
                        sctime //sctime
                ),
                new Movie(
                        mname,//name
                        description,//description
                        Double.parseDouble(price),//price
                        new File(f)
                ),
                new Payment(
                        Double.parseDouble(amount)//amount

                )
        ).toString());
        editTheaterTakenSeats(ID.toCharArray()[0], take);
    }

    //Screen
    public int getScreennb() {
        return fA.readScreen().size();
    }

    public void addScreen(char y, String x) {

        fA.Write("Screen", "" + getTheaterID("" + y) + "," + x + "\n");
    }

    public HashMap getScreentheaters() {
        return fA.readScreen();
    }

    public ArrayList<Customer> getallCustomers() {
        return fA.readCust();
    }

    private void deleteScreen(Movie m) {
        HashMap<String, String> map = fA.readScreen();
        String f = "" + MovietoTheater(m.getName()).getID();
        map.remove(f);
        fA.resetf("Screen");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            fA.Write("Screen", entry.getKey() + "," + entry.getValue() + "\n");
        }
    }

    private void deleteScreen(Theater t) {

        HashMap<String, String> map = fA.readScreen();
        map.remove("" + t.getID());
        fA.resetf("Screen");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            fA.Write("Screen", entry.getKey() + "," + entry.getValue() + "\n");

        }
    }

    //other
    public int checkcreds(String u, String p) {
//       return sA.toserver(u+","+p);
        boolean flag = false;
        int in = -1;

        for (Customer x : fA.readCust()) {
            if (u.equals(x.getName()) && p.equals(x.getPass())) {
                flag = true;
                in = 0;
                break;
            }
        }
        if (!flag) {
            for (Manager x : fA.readmng()) {
                if (u.equals(x.getUser()) && p.equals(x.getPass())) {
                    flag = true;
                    in = 1;
                    break;
                }
            }
        }
        if (!flag) {
            if (u.equals("admin") && p.equals("admin")) {
                in = 2;
                flag = true;
            }
        }
        return in;
    }

    public ArrayList<String> removeDuplicates(ArrayList<String> original, ArrayList<String> links) {
        ArrayList<String> temp = new ArrayList<>(original);
        for (int a = 0; a < original.size(); a++) {
            for (int b = 0; b < links.size(); b++) {
                if (original.get(a).equals(links.get(b))) {
                    String f = original.get(a);
                    temp.remove(f);
                }
            }

        }
        return temp;
    }

}
