package com.data.structures.practice.sorting.problems;

public class KthElementInStream {

    class KthLargest {
    int size = 0;
    int k;
    int[] nums;

    public KthLargest(int k, int[] nums) {

        this.k = k;
        this.nums = new int[20001];
        for (int i : nums) {
            this.nums[size++] = i;
        }

        heapSort();

        //  System.out.println();
    }

    public void heapSort() {
      /*  System.out.println("befor");
        for (int i = 0; i < size; i++) {
            System.out.print(this.nums[i] + " ");
        }
        System.out.println();*/
        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(this.nums, size, i);
        }

        for (int i = size - 1; i > 0; i--) {

            //if (i == (size - 1 - k))
            //  return nums[0];
            swap(nums, 0, i);
            heapify(nums, i, 0);//make sure to pass in i

        }
        /*System.out.println("after");

        for (int i = 0; i < size; i++) {
            System.out.print(this.nums[i] + " ");
        }
        System.out.println();*/
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void heapify(int[] nums, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && nums[left] > nums[largest]) {
            largest = left;
        }

        if (right < n && nums[right] > nums[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(nums, i, largest);
            heapify(nums, n, largest);
        }
    }

    public int add(int val) {

        nums[size++] = val;

        heapSort();

        /* for (int i = size - 1; i > 0; i--) {
            if (i == (size - 1 - k))
                return nums[0];
            swap(nums, 0, i);
            heapify(nums, 0, i);
        }*/

        return nums[size - k];
    }
}
}
