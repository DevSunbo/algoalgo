package src;
import java.util.Locale;
import java.util.regex.*;

/**
 * 아이디의 길이는 3자 이상 15자 이하여야 합니다.
 * 아이디는 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.) 문자만 사용할 수 있습니다.
 * 단, 마침표(.)는 처음과 끝에 사용할 수 없으며 또한 연속으로 사용할 수 없습니다.
 */
public class KAKAONewID {
    public String solution(String new_id) {
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
            new_id = new_id.toLowerCase(); // 1단계 모두 소문자로 만들기
            String[] str = new_id.split("");
            if(str[0].equals(".")) str[0] = "X"; // 4단계 마침표(.)가 처음이나 끝에 위치한다면 제거합니다. X로 바꾸고 아래 for문 2단계 실행에서 제거
            if(str[str.length-1].equals(".")) str[str.length-1] = "X"; // 4단계 마침표(.)가 처음이나 끝에 위치한다면 제거합니다. X로 바꾸고 아래 for문 2단계 실행에서 제거
            boolean doubleDot = false;
            for(int i =0;i<str.length;++i){
                Matcher matcher = patternCheck.matcher(str[i]);
                if(str[i].equals(".")){ // 3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
                    if(doubleDot)
                        str[i] = "X"; // 2단계 실행에서 제거
                    else
                        doubleDot = true; // 마침표 연속인지 확인하기 위해 1개 체크
                }
                else
                    doubleDot = false; // 마침표가 연속이 아닐 경우 체크 해제

                if(matcher.find() ){ // 2단계 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.) 말고 없애기

                }
            }


        }
        return answer;
    }
}
