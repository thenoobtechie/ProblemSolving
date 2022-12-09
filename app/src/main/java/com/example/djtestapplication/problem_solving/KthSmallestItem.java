package com.example.djtestapplication.problem_solving;

import java.util.HashSet;
import java.util.Random;
import java.util.TreeSet;

public class KthSmallestItem {

    //Using TreeSet
    public static int findKthSmallestNumber(int[] arr, int l, int r, int k) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for(int i = l; i <= r; i++) {
            treeSet.add(arr[i]);
        }

        int counter = 1;
        for(int item: treeSet) {
            if(counter > r) break;
            if(counter == k) return item;
            counter++;
        }
        return -1;
    }

    //Using Quick select algorithm
    void swap(int arr[], int l, int r){
        int tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
    }

    int randomPartition(int arr[], int l, int r){
        int n = r-l+1;
        Random rd = new Random();
        int pivot = rd.nextInt(n);
        swap(arr, l + pivot, r);
        return partition(arr, l, r);
    }

    int kthSmallest(int arr[], int l, int r, int k)
    {
        // If k is smaller than number of elements in array
        if (k > 0 && k <= r - l + 1)
        {
            // find a position for random partition
            int pos = randomPartition(arr, l, r);

            // if this pos gives the kth smallest element, then return
            if (pos-l == k-1)
                return arr[pos];

            // else recurse for the left and right half accordingly
            if (pos-l > k-1)
                return kthSmallest(arr, l, pos-1, k);
            return kthSmallest(arr, pos+1, r, k-pos+l-1);
        }

        return Integer.MAX_VALUE;
    }

    int partition(int arr[], int l, int r)
    {
        int x = arr[r], i = l;
        for (int j = l; j <= r - 1; j++)
        {
            if (arr[j] <= x)
            {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, r);
        return i;
    }
}
