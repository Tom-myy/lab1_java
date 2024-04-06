package ua.nure.kpp.lab1_2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArraySorterBubbleTest {

    @Test
    public void sortsInAscendingOrder() {
        ArraySorterBubble sorter = new ArraySorterBubble();

        int[] arr = {1, -5, 4};
        sorter.sort(arr, true);

        assertArrayEquals(new int[] {-5, 1, 4}, arr);
    }

    @Test
    public void sortsInDescendingOrder() {
        ArraySorterBubble sorter = new ArraySorterBubble();

        int[] arr = {1, -5, 4};
        sorter.sort(arr, false);

        assertArrayEquals(new int[] {4, 1, -5}, arr);
    }

}
