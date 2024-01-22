package Model;

public class Book {
	private Customer c;private Theater th;private Payment pay; private Movie m;

    /**
     *
     * @param c
     * @param th
     * @param m
     */
    public Book(Customer c, Theater th, Movie m ,Payment pay) {
		this.c = c;
		this.th = th;
                this.m=m;
                this.pay = pay;
	}

	@Override
	public String toString() {
            String u="";
	String out=	c.toString() + "," + th.toString() +","+ m.toString()+"," + pay.toString();
        
        for(String x:out.split("\n")){
            u+=x;
        }
            return u+"\n";
                    
	}

}
