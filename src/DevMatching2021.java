package src;

import java.util.*;

public class DevMatching2021 {
    public static void main(String[] args) {
        int[] lottos =  {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};
        solution(lottos, win_nums);
    }
    public static int[] solution(int[] lottos, int[] win_nums) {
        Arrays.sort(lottos);
        int[] temp = new int[lottos.length];
        int min= 7, max=7; // 0개와 1개는 모두 6등이기 때문
        for(int i = 0;i<lottos.length;++i){
            temp[i] = lottos[i];
        }
        lottos = temp; // Collection.reverse 안쓰고 내림차순

        for(int n : lottos){
            if(n == 0){
                // 아무 번호나 가능
                --min;
                continue;
            }
            for(int w : win_nums){
                if(n == w){
                    // 로또 번호가 존재한다면
                    --min;
                    --max;
                }

            }
        }
        if(min < 1) min = 1; // 다 맞으면 1등, 0개 또는 1개 맞으면 6등 케어
        if(max < 1) max = 1;
        if(min > 6) min = 6;
        if(max > 6) max = 6;

        int[] answer = {min, max};
        return answer;
    }
}
