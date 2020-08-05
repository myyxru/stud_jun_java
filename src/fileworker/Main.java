package fileworker;

import java.io.*;
import java.nio.file.*;

import java.util.Scanner;

public class Main {
    public static void main (String [] args){

        Main main = new Main();
        String command =  main.console();
        Scanner sc = new Scanner(System.in);

        if (command.equals("write")) {
            String str = sc.nextLine();
            int quant = sc.nextInt();
            String findsymbol = sc.nextLine();
            main.commandwrite(str,quant,findsymbol);
        }
        else if (command == "read"){
            main.commandread();
        }



    }
    public String console() {
        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine();
        return command;
    }
    public void commandwrite (String str, int quant, String findsymbol)  {
        File newFile = new File("C://test//1.txt");
        try
        {
            boolean created = newFile.createNewFile();
            if(created)
                System.out.println("File has been created");
        }
        catch(IOException ex){

            ex.printStackTrace();
        }

    }

    public void commandread (){

    }


}
