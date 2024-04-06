package ua.nure.kpp.lab1_2;

public class ArraySorterShell implements ArraySorter {

    @Override
    public void sort(int[] mas, boolean asc) {
        // todo only asc sort order is support

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
}
