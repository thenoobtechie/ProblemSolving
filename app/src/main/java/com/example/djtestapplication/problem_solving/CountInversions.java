package com.example.djtestapplication.problem_solving;

public class CountInversions {

    static long inversions = 0;
    static long inversionCount(long arr[], long N)
    {
        mergeSort(arr, 0, N-1);

        System.out.println("Inversions count: " + inversions);
        return inversions;
    }

    static void mergeSort(long[] arr, long start, long end) {

        if(start < end) {

            long mid = ((end-1)+start) / 2;

            mergeSort(arr, start, mid);
            mergeSort(arr, mid+1, end);
            merge(arr, start, mid, end);
        }
    }

    static void merge(long[] arr, long start, long mid, long end) {

        long leftArrLength = mid - start + 1;
        long rightArrLength = end - mid;

        long[] tempLeftArr = new long[(int) leftArrLength];
        long[] tempRightArr = new long[(int) rightArrLength];

        for(int i=0; i < leftArrLength; ++i)
            tempLeftArr[i] = arr[(int) (start + i)];

        for(int i=0; i < rightArrLength; ++i)
            tempRightArr[i] = arr[(int) (mid + 1 + i)];

        int i = 0, j = 0;
        int k = (int) start;
        while(i < leftArrLength && j < rightArrLength) {

            if(tempLeftArr[i] <= tempRightArr[j]) {
                arr[k] = tempLeftArr[i];
                i++;
            }
            else {
                inversions++;
                arr[k] = tempRightArr[j];
                j++;
            }
            k++;
        }

        while(i < leftArrLength) {
            arr[k] = tempLeftArr[i];
            i++;
            k++;
        }

        while(j < rightArrLength) {
            arr[k] = tempRightArr[j];
            j++;
            k++;
        }
    }
}
