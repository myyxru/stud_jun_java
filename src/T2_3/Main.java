package T2_3;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
    String expres = new String();
    expres = "2 * 3 - 5 / 6 + 9";
    ParsExp pars = new ParsExp();
    String [] tt = pars.ParsExp(expres);
        Twolink link = new Twolink(tt);
        link.sout(link);
        link.sout(link, 4);
    }
    }

