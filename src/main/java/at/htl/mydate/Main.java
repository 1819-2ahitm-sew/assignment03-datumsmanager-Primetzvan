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


        while (!input.equals("quite")){ // 2018-11-04-HM: "quit" ... "quite" bedeutet "ziemlich"

            MyDate myDate = new MyDate(input);


            System.out.println("Date-Manager %d============%d"); // 2018-11-04-HM: sollte nur 1x beim Programmstart ausgegeben werden
            System.out.printf("%d ", counter++);
            input = scanner.nextLine(); // 2018-11-04-HM: Einlesen des Datums sollte erst nach der if-else-Anweisung erfolgen

            if (myDate.isYoungerThan()){ // 2018-11-04-HM: Hier sollte ein Vergleich mit aktdate stattfinden
                System.out.println("Jüngstes Datum: " + myDate.formatDate());
                aktdate = myDate.formatDate();
            }else {
                System.out.println("Jüngstes Datum: " + aktdate);
            }



        }



    }
}
