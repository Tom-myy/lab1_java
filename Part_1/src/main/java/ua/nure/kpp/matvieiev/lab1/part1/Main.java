package ua.nure.kpp.matvieiev.lab1.part1;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

/*                    TASK
Enter n numbers from the console. Find the shortest and
the longest number. Output the numbers and their length.*/

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int size = 0;

        do
        {
            System.out.print("Enter size of mas (>= 2): ");

            try {
                size = sc.nextInt();
            }

            catch (Exception ex) {
                System.out.println("Exception! Something went wrong...");

                if(size < 2)
                    sc.next();
            }

        } while(size < 2);

        int [] mas = new int [size];

        int countCheck = 0;

        do {
            System.out.println("Enter " + size + " values for mas in a row: ");

            try {
                for (int i = 0; i < size; ++i) {
                    mas[i] = sc.nextInt();
                    countCheck++;
                }
            }

            catch (Exception ex) {
                System.out.println("Exception! Something went wrong...");
                sc.nextLine();
                countCheck = 0;
            }

        }while(countCheck != size);


        //may be this checking isn't needed because we have checking for size of massive,
        // so as for me, it's not possible here to have massive with length 0
        int minLength = mas.length > 0 ? String.valueOf(mas[0]).length() : 0;
        int numberOfShortest  = mas.length > 0 ? mas[0] : 0;
        int maxLength = mas.length > 0 ? String.valueOf(mas[0]).length() : 0;
        int numberOfLongest  = mas.length > 0 ? mas[0] : 0;

        for(int i = 0; i < size; ++i){
            if(minLength > String.valueOf(mas[i]).length()) {
                minLength = String.valueOf(mas[i]).length();
                numberOfShortest = mas[i];
            }
            if(maxLength < String.valueOf(mas[i]).length()) {
                maxLength = String.valueOf(mas[i]).length();
                numberOfLongest = mas[i];
            }
        }

        System.out.print("Your mas: ");
        for(int i =0; i < size;++i){
            System.out.print(mas[i] + " ");
        }
        System.out.println();

        System.out.println("Value of shortest = " + numberOfShortest + ", his length = "+ minLength + "\n" +
                "Value of longest = " + numberOfLongest + ", his length = "+ maxLength);

        String [] mas2 = new String[size];

        for(int i =0; i < size;++i){
            mas2[i] = String.valueOf(mas[i]);
        }
    }
}