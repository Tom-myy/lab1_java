package ua.nure.kpp.matvieiev.lab1.part2;

public class ArraySorterBubble implements ArraySorter {
    @Override
    public void sort(int[] mas, boolean asc) {
        for (int i = 0; i < mas.length - 1; ++i) {
            for (int j = i + 1; j < mas.length; ++j) {
                if (asc ? mas[i] > mas[j] : mas[i] < mas[j]) {
                    int tmp = mas[i];
                    mas[i] = mas[j];
                    mas[j] = tmp;
                }
            }
        }
    }
}
