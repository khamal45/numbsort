package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class heap {


        private static int N;

        /**
         * Time Complexity: Total n elements, each element calls max heapify once,
         * hence total complexity is (n log n).
         */
        public static void sort(int arr[]) {

            // build the heap
            heapify(arr);

            for (int i = N; i > 0; i--) {
                // Get the root element which is maximum value from the Heap.
                // Remove root element by swapping with the last element.
                swap(arr, 0, i);
                N = N - 1;
                // Again heapify to maintain the max heap property.
                maxheap(arr, 0);
            }
        }

        /**
         * Function to build a heap.
         * Observe that the elements of heap are :
         * A([n/2]+1), A([n/2]+2), A([n/2]+3) ... A(n) are all leaves.
         * here n is the length of heap (heap size).
         * Any index after (n/2) will have left(i) and right(i) greater than n.
         * Also parent for a given index i is floor of i/2.
         */
        public static void heapify(int arr[]) {
            N = arr.length - 1;
            // Go from the bottom non-leaf nodes of the binary tree, hence i--.
            // The max non-leaf nodes of a binary tree with n nodes is n/2.
            for (int i = N / 2; i >= 0; i--)
                maxheap(arr, i);
        }


        public static void maxheap(int arr[], int i) {



            int left = 2 * i; // left child of i which is 2i
            int right = 2 * i + 1; // right child of i which is 2i + 1
            int max = i;


            if (left <= N && arr[left] > arr[i])
                max = left;

            if (right <= N && arr[right] > arr[max])
                max = right;


            if (max != i) {
                swap(arr, i, max);
                maxheap(arr, max);
            }
        }


        public static void swap(int arr[], int i, int j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }

        public static void main(String[] args) {

            Scanner masuk = new Scanner(System.in);
            System.out.printf("Jumlah Angak yang mau di urutkan : ");
            int jumlah = masuk.nextInt();
            int[] array = new int[jumlah];
            for (int a = 0 ; a < jumlah ; a++){
                System.out.print("Masukan Angka ke " + (a+1)+": ");
                array[a]= masuk.nextInt();
            }
            System.out.printf("Angka sebelum di urutkan :");
            System.out.println(Arrays.toString(array));

            sort(array);
            System.out.println("Heap Sort: " + Arrays.toString(array));
        }
    }

