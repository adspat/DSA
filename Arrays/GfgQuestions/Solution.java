import java.util.*;


// GFG rearrangeArray :

class RearrangeArray {
    public int[] rearrangeArray(int[] arr) {
        
        Arrays.sort(arr);

        for (int i = 2; i < arr.length; i = i + 2) {
            int temp = arr[i];
            arr[i] = arr[i - 1];
            arr[i - 1] = temp;
        }

        return arr;
    }
}


//  Missing And Repeating element in array :

class MissingAndRepeating{

    public ArrayList<Integer> findTwoElement(int arr[]) {
        int n = arr.length;
        Set<Integer> set = new HashSet<>();
        ArrayList<Integer> ans = new ArrayList<>();
        int repeatingEle = -1;
        for(int i = 0; i < n; i++) {
            if(set.contains(arr[i])) {
                repeatingEle = arr[i];
            } else {
                set.add(arr[i]);
            }
        }
        long totalSum = (long)n * (n + 1) / 2;
        long arraySum = 0;
        for(int x : set) {
            arraySum += x;
        }
        long missingEle = totalSum - arraySum;
        ans.add(repeatingEle);
        ans.add((int)missingEle);
        return ans;
    }
}

public class Solution {
    public static void main(String[] args) {
        System.out.println("Here Run all the Solutions");
    }
}