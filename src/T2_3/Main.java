package T2_3;

public class Main {
    public static void main(String[] args) {
    String expres = new String();
    expres = "2 * 3 - 5 / 6 + 9";
    ParsExp pars = new ParsExp();
    String [] tt = pars.ParsExp(expres);
        for (String i:tt) {
            System.out.println(i);
        }
        Twolink link = new Twolink(tt);
    int a=1;
    int b=4;
   int z= a+b;
    }
    }

