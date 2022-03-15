package src;
import java.util.*;



public class KAKAOSINGO2022 {
    public static void main(String[] args) {

    }
    public int[] solution(String[] id_list, String[] report, int k) {
        HashMap<String,ArrayList<String>> singo = new HashMap<>();
        HashMap<String,Integer> mail = new HashMap<>();
        int[] answer = {};
        for(String id : id_list){
            singo.put(id, null); // 아이디를 Hashmap에 매핑, 신고받은 횟수 기록용
            mail.put(id,0);
        }
        for(String name : report){
            String[] s = name.split(" "); // 신고한 사람과 신고 받은 사람 분리
            if(singo.get(s[1]).contains(s[0])){ // 신고 받은 사람(키 값) 을 신고한 사람(value) 가 중복인지 확인
                continue;
            }
            else{
                singo.get(s[1]).add(s[0]);
            }
        }

        singo.forEach((key, v) ->{
            if(v.size() >= k){
                v.forEach(ss -> {
                    int temp = mail.get(ss);
                    mail.put(ss, temp +1);
                });
            }
        });
        for(int i =0;i<id_list.length;i++){
            answer[i] = mail.get(id_list[i]);
        }

        return answer;
    }
}
