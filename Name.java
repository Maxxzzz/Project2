import java.util.Scanner;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.*;
import java.util.*;
import java.lang.Object;
public class Name {
	public static void main(String args []) {
		Scanner scan = new Scanner(System.in);
        String exit = "Exit";
        String name = "";
        while(name != exit){
            int count  = 0;
            System.out.print("Name of the person (or Exit to quit:) ");
            name = scan.next();
            System.out.print("Enter Gender: ");
            String gender = scan.next();
            String directory = "/Users/maxxmuramoto/Desktop/cs245/project2/namesbystate";
            System.out.print("State of birth (two-letter state code): ");
            String state = scan.next(); 
            String tempstate = state.toUpperCase();
            List<String> names = new ArrayList<String>();
            try (BufferedReader list = new BufferedReader(new FileReader(directory + "/" + tempstate + ".TXT")))
            {   
                String values;
                while ((values = list.readLine()) != null) {
                    String[] value = values.split(",");
                    names.add(value[0]);
                    names.add(value[1]);
                    names.add(value[2]);
                    names.add(value[3]);
                    names.add(value[4]);
                }

            } 
            catch (IOException e) {
                System.out.println("Error file not found");
            }
            for (int i = 0; i < names.size(); i++){
                if(names.contains(name)){
                    while(count == 0){
                        count++;
                        int a = names.indexOf(name);
                        int b = a - 2;
                        String temp = names.get(b);
                        if(temp.equals(gender)){
                            int c = b + 3;
                            int d = b + 1;
                            String age = names.get(c);
                            String year = names.get(d);
                            System.out.println(name + " born in " + tempstate + " is most likely around " + age + " years old.");
                            System.out.println("The most popular year for the name " + name + " is " + year + ".");
                    }
                    }
                }   
            }
    }
    System.out.println("Thanks for using");
}
}