package ua.nure.kpp.lab1_2;

public class ArraySorterBubble implements ArraySorter {

    @Override
    public void sort(int[] mas, boolean asc) {
        if (asc) {
            for (int i = 0; i < mas.length - 1; ++i) {
                for (int j = i + 1; j < mas.length; ++j) {
                    if (mas[i] > mas[j]) {
                        int tmp = mas[i];
                        mas[i] = mas[j];
                        mas[j] = tmp;
                    }
                }
            }
        } else {
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

}
