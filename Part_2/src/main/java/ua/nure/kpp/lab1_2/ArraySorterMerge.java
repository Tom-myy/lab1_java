package ua.nure.kpp.lab1_2;

public class ArraySorterMerge implements ArraySorter {

    @Override
    public void sort(int[] arr, boolean asc) {
        int size = arr.length;
        if(size == 1) return;

        int mid = size / 2;
        int[] l = new int[mid];
        int[] r = new int[size - mid];

        for(int i = 0; i < mid; i++)
            l[i] = arr[i];
        for(int i = mid; i < size; i++)
            r[i - mid] = arr[i];

        sort(l, asc);
        sort(r, asc);
        if(asc)
            Merge(arr, l, r, asc);
        else
            Merge(arr, l, r, asc);
    }

    private void Merge(int[] arr, int[] l, int[] r, boolean asc) {
        int left = l.length;
        int right = r.length;
        int i = 0;
        int j = 0;
        int idx = 0;


        if(asc) {
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
}
