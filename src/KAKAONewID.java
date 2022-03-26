package src;
import java.util.Locale;
import java.util.regex.*;

/**
 * 아이디의 길이는 3자 이상 15자 이하여야 합니다.
 * 아이디는 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.) 문자만 사용할 수 있습니다.
 * 단, 마침표(.)는 처음과 끝에 사용할 수 없으며 또한 연속으로 사용할 수 없습니다.
 */
public class KAKAONewID {
    public static void main(String[] args) {
        String new_id = "...!@BaT#*..y.abcdefghijklm";
        solution(new_id);
    }
    public static String solution(String new_id) {
        String answer = "";
        String patternLength = "^.\\S{3,15}$"; // 공백 없이 3~15글자
        String pattern = "^[a-z0-9-_]*[a-z0-9-_.]?[a-z0-9-_]*$"; //아이디는 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.) 문자만 사용할 수 있습니다. & 마침표(.)는 처음과 끝에 사용할 수 없으며 또한 연속으로 사용할 수 없습니다.
        Pattern patternCheck = Pattern.compile("[a-z0-9-_.]"); // 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)
        boolean regexLength = Pattern.matches(patternLength, new_id);
        boolean regexPattern = Pattern.matches(pattern,new_id);

        if(regexLength && regexPattern){
            answer = new_id;
        }
        else{
            if(new_id.isEmpty()){
                new_id = "a"; // 만약 시작부터 빈 문자열이라면 5단계 실행
            }
            new_id = new_id.toLowerCase(); // 1단계 모두 소문자로 만들기
            String[] str = new_id.split("");
            String str2 = "";

            boolean doubleDot = false;
            for(int i =0;i<str.length;++i){
                Matcher matcher = patternCheck.matcher(str[i]);
                if(matcher.find() ){ // 2단계 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.) 말고 없애기
                    str2 += str[i];
                }
            }
            str = str2.split(""); // 2단계를 거친 String 으로 다시 만든다
            for(int i =0;i<str.length;++i){
                if(str[i].equals(".")){ // 3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
                    if(doubleDot)
                        str[i] = "X"; // 2단계 실행에서 제거
                    else
                        doubleDot = true; // 마침표 연속인지 확인하기 위해 1개 체크
                }
                else
                    doubleDot = false; // 마침표가 연속이 아닐 경우 체크 해제
            }
            if(str[0].equals(".")) str[0] = "X"; // 4단계 마침표(.)가 처음이나 끝에 위치한다면 제거합니다. X로 바꾸고 아래 for문 2단계 실행에서 제거

            for(int i =0;i<str.length;++i){ // 3,4 단계에서 제거해야할 것들 제거
                Matcher matcher = patternCheck.matcher(str[i]);
                if(matcher.find() ){ // 2단계 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.) 말고 없애기
                    str2 += str[i];
                }
            }
            //TODO: 2단계 X 제거가 잘 안이루어지는듯 - 03.24
            //TODO: 내일은 꼭 마무리 한다 - 03.25
            //TODO: 내일은 꼭 마무리 한다 - 03.26
            str = str2.split(""); // 2단계를 거친 String 으로 다시 만든다
            if(str.length == 0){
                //5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
                //7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
                answer = "aaa"; // 5단계와 7단계 동시에 처리
                return answer;
            }
            if(str.length >15){
                for(int j = 0;j<15;++j){
                    if(j == 14 && str[j] == "."){
                        break; //만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
                    }
                    answer += str[j]; // 6단계 6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
                }
            }
        }
        return answer;
    }
}
