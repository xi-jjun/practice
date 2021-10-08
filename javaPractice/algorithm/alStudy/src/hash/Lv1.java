package hash;

import java.util.HashMap;
import java.util.Map;

// 완주하지 못한 선수
public class Lv1 {
    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> register = new HashMap<>();

        for (String part : participant) {
            if (register.containsKey(part)) register.replace(part, register.get(part) + 1);
            else register.put(part, 1);
        }

        for (String com : completion) {
            if (register.containsKey(com)) register.replace(com, register.get(com) - 1);
            else return com;
        }

        for (String key : register.keySet()) {
            if (register.get(key) == 1) return key;
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] participant = new String[]{"leo", "kiki", "eden"};
        String[] completion = new String[]{"kiki", "eden"};

        System.out.println(solution(participant, completion));
    }
}
