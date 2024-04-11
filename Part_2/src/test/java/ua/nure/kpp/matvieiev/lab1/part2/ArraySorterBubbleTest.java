package ua.nure.kpp.matvieiev.lab1.part2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArraySorterBubbleTest {
    @Test
    public void sortsInAscendingOrder() {
        ArraySorterBubble sorter = new ArraySorterBubble();
        int[] arr = {3, -2, 12, 0};
        sorter.sort(arr, true);

        assertArrayEquals(new int[]{-2, 0, 3, 12}, arr);
    }

    @Test
    public void sortsInDescendingOrder() {
        ArraySorterBubble sorter = new ArraySorterBubble();
        int[] arr = {3, -2, 12, 0};
        sorter.sort(arr, false);

        assertArrayEquals(new int[]{12, 3, 0, -2}, arr);
    }
}