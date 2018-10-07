package at.htl.mydate;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {

        int counter = 1;
        String input;
        String aktdate = "";

        System.out.println("Date-Manager %d============%d");
        System.out.printf("%d. Datum: ", counter);
        input = scanner.nextLine();


        while (!input.equals("quite")){

            MyDate myDate = new MyDate(input);

            System.out.println("Date-Manager %d============%d");
            System.out.printf("%d ", counter++);
            input = scanner.nextLine();

            if (myDate.isYoungerThan()){
                System.out.println("Jüngstes Datum: " + myDate.formatDate());
                aktdate = myDate.formatDate();
            }else {
                System.out.println("Jüngstes Datum: " + aktdate);
            }

        }



    }
}
