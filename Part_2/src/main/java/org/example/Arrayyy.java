package org.example;
import java.util.Scanner;

public class Arrayyy {
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

    public void BubbleSort(){
        if(Flag() == 0) {
            for (int i = 0; i < mas.length - 1; ++i) {
                for (int j = i + 1; j < mas.length; ++j) {
                    if (mas[i] > mas[j]) {
                        int tmp = mas[i];
                        mas[i] = mas[j];
                        mas[j] = tmp;
                    }
                }
            }
        }
        else {
            for (int i = 0; i < mas.length - 1; ++i) {
                for (int j = i + 1; j < mas.length; ++j) {
                    if (mas[i] < mas[j]) {
                        int tmp = mas[i];
                        mas[i] = mas[j];
                        mas[j] = tmp;
                    }
                }
            }
        }
    }

    public void ShellSort() {
        int step = mas.length / 2;
        while(step > 0) {
            for(int i = step; i < mas.length; i++) {
                for(int j = i; j >= step && mas[j] > mas[j - step]; j -= step) {
                    int tmp = mas[j];
                    mas[j] = mas[j - step];
                    mas[j - step] = tmp;
                }
            }
            step = step / 2;
        }
    }

    public void MergeSort(int[] arr) {
        int size = arr.length;
        if(size == 1) return;

        int mid = size / 2;
        int[] l = new int[mid];
        int[] r = new int[size - mid];

        for(int i = 0; i < mid; i++)
            l[i] = arr[i];
        for(int i = mid; i < size; i++)
            r[i - mid] = arr[i];

        MergeSort(l);
        MergeSort(r);
        if(flag == -1)
            Merge(arr, l, r, Flag());
        else
            Merge(arr, l, r, flag);
    }

    private void Merge(int[] arr, int[] l, int[] r, int flag) {
        int left = l.length;
        int right = r.length;
        int i = 0;
        int j = 0;
        int idx = 0;


        if(flag == 0) {
            while(i < left && j < right) {
                if(l[i] > r[j]) {
                    arr[idx] = l[i];
                    i++;
                }
                else {
                    arr[idx] = r[j];
                    j++;
                }
                idx++;
            }
        }
        else {
            while(i < left && j < right) {
                if(l[i] < r[j]) {
                    arr[idx] = l[i];
                    i++;
                }
                else {
                    arr[idx] = r[j];
                    j++;
                }
                idx++;
            }
        }

        for(int ll = i; ll < left; ll++) {
            arr[idx++] = l[ll];
        }
        for(int rr = j; rr < right; rr++) {
            arr[idx++] = r[rr];
        }
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

        if(typeOfSort == 1)
            BubbleSort();
        else if (typeOfSort == 2)
            ShellSort();
        else
            MergeSort(mas);
    }

}

