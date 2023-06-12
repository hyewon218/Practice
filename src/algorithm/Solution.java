package algorithm;

import java.util.ArrayList;
import java.util.List;

public class Solution {
// 배열 arr을 ArrayList에 담아주고
// delete_list와 비교하면서 값이 같으면 answer에 arr[i]값을 지워주기
    public List solution(int[] arr, int[] delete_list) {
        List<Integer> answer = new ArrayList<>();

        for (int array: arr) {
            answer.add(array);
        }
        for (int array : arr) {
            for (int deleteList : delete_list) {
                if (array == deleteList) {
                    answer.remove(Integer.valueOf(array));
                    //에러
                    //answer.remove(array);
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Solution array = new Solution();
        //array.solution(new int[]{293, 1000, 395, 678, 94}, new int[]{94, 777, 104, 1000, 1, 12});
        System.out.println(array.solution(new int[]{293, 1000, 395, 678, 94}, new int[]{94, 777, 104, 1000, 1, 12}));
    }
}
