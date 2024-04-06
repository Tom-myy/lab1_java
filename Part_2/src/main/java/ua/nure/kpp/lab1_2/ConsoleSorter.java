package ua.nure.kpp.lab1_2;
import java.util.Scanner;

public class ConsoleSorter {
    Scanner sc = new Scanner(System.in);

    private int size;
    private int mas[];
    private int flag = -1;
    private int typeOfSort = -1;

    private void SetSize(){
        int tmpSize = 0;

        do
        {
            System.out.print("Enter size of mas (>= 2): ");

            try {
                tmpSize = sc.nextInt();
            }

            catch (Exception ex) {
                System.out.println("Exception! Something went wrong...");

                if(tmpSize < 2)
                    sc.next();
            }

        } while(tmpSize < 2);

        size = tmpSize;
    }

    public int[] GetMas(){
        return mas;
    }
    private int Flag(){
        do {
            System.out.print("For increase sorting enter 0, for digress enter 1: ");
            try {
                flag = sc.nextInt();
            }
            catch (Exception ex) {
                System.out.println("Exception! Something went wrong...");

                if(flag != 0 && flag != 1)
                    sc.next();
            }
        }
        while (flag != 0 && flag != 1);

        return flag;
    }

    public void CreateMas() {
        SetSize();
        if(size > 1) {
            mas = new int[size];
            Filling();
        }
        else {
            System.out.println("You didn't enter size");
        }
    }

    private void Filling(){
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

        } while(countCheck != size);
    }

    public void PrintMas(){
        System.out.println("Your mas:");
        for(int i = 0; i < size; ++i) {
            System.out.print(mas[i] + " ");
        }
        System.out.println();
    }

    private void ChooseSort(){
        System.out.println("Which sort would you like to use?\n" +
                "BubbleSort - 1\n" +
                "ShellSort - 2\n" +
                "MergeSort - 3");
        do {
            System.out.print("Your chose - ");
            try {
                typeOfSort = sc.nextInt();
            }
            catch (Exception ex) {
                System.out.println("Exception! Something went wrong...");
                    sc.next();
            }
        }
        while (typeOfSort != 1 && typeOfSort != 2 && typeOfSort != 3);
    }

    public void Sort(){
        ChooseSort();

        ArraySorter sorter;
        if(typeOfSort == 1)
            sorter = new ArraySorterBubble();
        else if (typeOfSort == 2)
            sorter = new ArraySorterShell();
        else
            sorter = new ArraySorterMerge();

        sorter.sort(mas, flag == 0);
    }

}

