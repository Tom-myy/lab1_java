package org.example;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        IsomorphicStrings iso = new IsomorphicStrings();
        String flag;
        Scanner sc = new Scanner(System.in);
        do {
            iso.setWords();
            iso.Isomorphic();
            System.out.print("\nWould you like to repeat? n\\y... ");
            flag = sc.next();
            System.out.print("\n");
        } while (flag.equals("y") || flag.equals("Y"));
    }
}