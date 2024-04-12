package ua.nure.kpp.matvieiev.lab1.part2;

import java.util.Scanner;

public class WorkWithConsoleForMasAndSorting {
    Scanner sc = new Scanner(System.in);

    private int size;
    private int mas[];
    private boolean asc = true;
    private int typeOfSort = -1;

    private void setSize() {
        int tmpSize = 0;

        do {
            System.out.print("Enter size of mas (>= 2): ");

            try {
                tmpSize = sc.nextInt();
            } catch (Exception ex) {
                System.out.println("Exception! Something went wrong...");

                if (tmpSize < 2)
                    sc.next();
            }

        } while (tmpSize < 2);

        size = tmpSize;
    }

    public int[] getMas() {
        return mas;
    }

    private boolean isAscending() {
        int tmp = -1;
        do {
            System.out.print("For sort in descending order enter 0, for sort in ascending order enter 1: ");
            try {
                tmp = sc.nextInt();
            } catch (Exception ex) {
                System.out.println("Exception! Something went wrong...");

                if (tmp != 0 && tmp != 1)
                    sc.next();
            }
        }
        while (tmp != 0 && tmp != 1);

        asc = (tmp == 1) ? true : false;
        return asc;
    }

    public void createMas() {
        setSize();
        if (size > 1) {
            mas = new int[size];
            filling();
        } else {
            System.out.println("You didn't enter size");
        }
    }

    private void filling() {
        int countCheck = 0;

        do {
            System.out.println("Enter " + size + " values for mas in a row: ");

            try {
                for (int i = 0; i < size; ++i) {
                    mas[i] = sc.nextInt();
                    countCheck++;
                }
            } catch (Exception ex) {
                System.out.println("Exception! Something went wrong...");
                sc.nextLine();
                countCheck = 0;
            }

        } while (countCheck != size);
    }

    public void printMas() {
        System.out.println("Your mas:");
        for (int i = 0; i < size; ++i) {
            System.out.print(mas[i] + " ");
        }
        System.out.println();
    }

    private void chooseSort() {
        System.out.println("Which sort would you like to use?\n" +
                "BubbleSort - 1\n" +
                "ShellSort - 2\n" +
                "MergeSort - 3");
        do {
            System.out.print("Your chose - ");
            try {
                typeOfSort = sc.nextInt();
            } catch (Exception ex) {
                System.out.println("Exception! Something went wrong...");
                sc.next();
            }
        }
        while (typeOfSort != 1 && typeOfSort != 2 && typeOfSort != 3);
    }

    public void sort() {
        chooseSort();
        isAscending();

        ArraySorter sorter;

        if (typeOfSort == 1)
            sorter = new ArraySorterBubble();
        else if (typeOfSort == 2)
            sorter = new ArraySorterShell();
        else
            sorter = new ArraySorterMerge();

        sorter.sort(mas, asc);
    }
}