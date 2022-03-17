package src;

import java.util.*;

public class DevMatching2021 {
    public int[] solution(int[] lottos, int[] win_nums) {
        Arrays.sort(lottos);
        int[] temp = new int[lottos.length];
        for(int i = 0;i<lottos.length;++i){
            temp[i] = lottos[i];
        }
        lottos = temp; // Collection.reverse 안쓰고 내림차순

        for(int n : lottos){
            win_nums.stream().fi
        }


        int[] answer = {};
        return answer;
    }
}
