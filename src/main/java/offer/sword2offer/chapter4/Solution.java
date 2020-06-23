package offer.sword2offer.chapter4;

import java.util.ArrayList;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().GetLeastNumbers_Solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 4));
    }
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        // 快排思想 确定一个数的最终位置 k-1 
        ArrayList<Integer> res = new ArrayList<>();
        if(input == null || k < 1){
            return res;
        }
        int len = input.length-1;
        int start = 0;
        int end = len;
        int index = partition(input,start,end);
        while (index != k-1){
            if(index < k-1){
                start = index+1;
            }else{
                end = index -1;
            }
            index = partition(input,start,end);
        }
        for(int i = 0; i<k; i++){
            res.add(input[i]);
        }
        return res;
        // 大根堆
    }
    private int partition(int[] input, int begin, int end){

        if(begin > end){
            return -1;
        }
        int i = begin;
        int j = end;
        int base = input[begin];
        while(i<j){
            while(i<j && input[j] >= base){
                j--;
            }
            while(i<j && input[i] <= base){
                i++;
            }
            swap(input,i,j);
        }
        swap(input,begin,i);
        return i;
    }

    private void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
