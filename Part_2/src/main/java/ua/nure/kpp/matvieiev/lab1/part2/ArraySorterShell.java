package ua.nure.kpp.matvieiev.lab1.part2;

public class ArraySorterShell implements ArraySorter {
    @Override
    public void sort(int[] mas, boolean asc) {
        int step = mas.length / 2;

        while (step > 0) {
            for (int i = step; i < mas.length; i++) {
                for (int j = i; j >= step && (asc ? mas[j] < mas[j - step] : mas[j] > mas[j - step]); j -= step) {
                    int tmp = mas[j];
                    mas[j] = mas[j - step];
                    mas[j - step] = tmp;
                }
            }
            step = step / 2;
        }
    }
}
