package baidu;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LRK
 * @project_name LeetCode
 * @package_name baidu
 * @date 2019/4/1 18:16
 * @description God Bless, No Bug!
 */
public class Sub_01WordListOrder {
    public static void main(String[] args) {

        System.out.println(canArrangeWords2(new String[]{"abc","cde","efg","ghi","ijk","klm"}));
    }

    /**
     * 回溯法
     * @param arr
     * @return
     */
    static int flag = -1;
    public  static int canArrangeWords2(String[] arr){

        int n = arr.length;
        fun(arr,n,0);
        return flag;
    }

    private static void fun(String[] arr, int n, int k) {
        if (n==k){
            flag = 1;
            return;
        }
        for (int i = k; i < n; i++) {

            if (k>0 && arr[k-1].charAt(arr[k-1].length()-1) == arr[i].charAt(0)){
                swap(arr,k,i);
                fun(arr,n,k+1);
                swap(arr,k,i);
            }
            // 第一个可以是任意的字符串
            else if (k==0){
                swap(arr,k,i);
                fun(arr,n,k+1);
                swap(arr,k,i);
            }
        }
    }

    private static void swap(String[] arr, int i, int j) {

        String tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     *
     * @param arr
     * @return
     */
    public static int canArrangeWords(String[] arr)
    {
        // INSERT YOUR CODE HERE
        Map<Character,Character> map = new HashMap<>(16);
        int len = arr.length;
        for (int i=0;i<len ;i++ ){

            Character first = arr[i].charAt(0);
            Character last = arr[i].charAt(arr[i].length()-1);
            map.put(first,last);
        }
        int cnt = 0;

        for(Character key : map.keySet()){
            Character c = key;
            while(cnt < len){
                if(cnt == len-1) {
                    return 1;
                }
                Character value = map.get(c);
                if(!map.containsKey(value) && cnt!=len-1){
                    break;
                }
                cnt++;
                c = value;
            }
            cnt = 0;
        }
        return -1;
    }
}
