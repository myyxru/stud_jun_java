package MainTask3;

public class Output implements Paramforoutconsole{

    public void output (int [] arr){
        Newpageconsole newpage = new Newpageconsole();
        int countersimbol = 0;
        int countline = 0;
        for (int a: arr) {
            System.out.print(a + " ");
            countersimbol += String.valueOf(a).length() + 1;
            if (countersimbol >= countsimbolonline) {
                // Переход на новую строку
                System.out.println();
                countersimbol = 0;
                countline++;
            }
            if (countline >= maxlineonpage) {
                newpage.newpage();
                countline = 0;
            }
        }
    }

}
