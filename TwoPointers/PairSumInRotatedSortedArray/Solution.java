package TwoPointers.PairSumInRotatedSortedArray;

class Solution {
    public boolean pairInSortedRotated(int[] arr, int target) {
        int n = arr.length;

        // Find the index of the smallest element (pivot)
        int pivot = 0;

        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                pivot = i + 1;
                break;
            }
        }

        // Smallest element
        int left = pivot;

        // Largest element
        int right = (pivot - 1 + n) % n;

        // Two pointer search
        while (left != right) {

            int sum = arr[left] + arr[right];

            if (sum == target) {
                return true;
            }

            if (sum < target) {
                left = (left + 1) % n;
            } else {
                right = (right - 1 + n) % n;
            }
        }

        return false;
    }
}