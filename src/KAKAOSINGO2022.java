package src;
import java.util.*;



public class KAKAOSINGO2022 {
    public static void main(String[] args) {
        String[] id_list = {"con", "Ryan"};
        String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
        int k = 3;
        solution(id_list, report, k);
    }
    public static int[] solution(String[] id_list, String[] report, int k) {
        HashMap<String,ArrayList<String>> singo = new HashMap<>();
        HashMap<String,Integer> mail = new HashMap<>();
        int[] answer = new int[id_list.length];
        for(String id : id_list){
            singo.put(id, null); // 아이디를 Hashmap에 매핑, 신고받은 횟수 기록용
            mail.put(id,0);
        }
        for(String name : report){
            String[] s = name.split(" "); // 신고한 사람과 신고 받은 사람 분리
            if(singo.get(s[1]) != null) {
                if (singo.get(s[1]).contains(s[0])) { // 신고 받은 사람(키 값) 을 신고한 사람(value) 가 중복인지 확인
                    continue;
                }
                else{
                    singo.get(s[1]).add(s[0]);
                }
            }
            else{
                ArrayList<String> src = new ArrayList<>();
                src.add(s[0]);
                singo.put(s[1], src);
            }

        }

        singo.forEach((key, v) ->{
            if(v != null && (v.size() >= k)){
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
