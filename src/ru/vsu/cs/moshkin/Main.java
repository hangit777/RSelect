package ru.vsu.cs.moshkin;

public class Main {

    public static void main(String[] args) {
        int[] array = {10, 5, 1, 8, 3, 6, 2, 4, 9, 7};
        System.out.println("Тест 1:");
        print(array);

        int[] array1 = {99, 31, 85, 24, 32, 11, 56, 20, 91, 44, 77, 13, 36};
        System.out.println("Тест 2:");
        print(array1);

        int[] array2 = {29, 305, 4, 723, 15, 218, 1036, 18, 81, 5471};
        System.out.println("Тест 3:");
        print(array2);
    }

    static void print(int[] array) {
        for (int i = 0; i < 2; i++) {
        System.out.print("[");
        for (int j = 0; j < array.length; j++) {
            if (j > 0) {
                System.out.print(", ");
            }
            if (i == 0) {
                System.out.print(array[j]);
            } else {
                System.out.print(rSelect(array, 0, array.length - 1, j));
            }
        }
        System.out.print("]\n");
    }
}

    static int rSelect(int[] array, int low, int high, int i) {
        if (low == high) {
            return array[low];
        }
        int pivotIndex = randomPivot(low, high);
        pivotIndex = partition(array, low, high, pivotIndex);
        if (i == pivotIndex) {
            return array[i];
        } else if (i < pivotIndex) {
            return rSelect(array, low, pivotIndex - 1, i);
        } else {
            return rSelect(array, pivotIndex + 1, high, i);
        }
    }

    static int randomPivot(int low, int high) {
        return (int)(Math.random() * (high - low + 1)) + low;
    }

    static int partition(int[] array, int low, int high, int pivotIndex) {
        int pivot = array[pivotIndex];
        int leftIndex = low;
        int temp = array[pivotIndex];
        array[pivotIndex] = array[high];
        array[high] = temp;
        for (int j = low; j <= high; j++) {
            if (array[j] < pivot) {
                int x = array[leftIndex];
                array[leftIndex] = array[j];
                array[j] = x;
                leftIndex++;
            }
        }
        int k = array[high];
        array[high] = array[leftIndex];
        array[leftIndex] = k;
        return leftIndex;
    }
}