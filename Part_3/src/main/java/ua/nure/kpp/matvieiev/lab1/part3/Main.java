package ua.nure.kpp.matvieiev.lab1.part3;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        IsomorphicStrings iso;
        iso = new IsomorphicStrings();
        String flag;
        Scanner sc = new Scanner(System.in);
        do {
            iso.setWords();
            iso.isomorphic();
            System.out.print("\nWould you like to repeat? n\\y... ");
            flag = sc.next();
            System.out.print("\n");
        } while (flag.equals("y") || flag.equals("Y"));
    }
}