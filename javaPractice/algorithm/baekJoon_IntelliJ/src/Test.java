import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        int rand = (int) (Math.random() * 3) + 1;
        Map<Integer, String> list = new HashMap<>();
        list.put(1, "경제목"); // Team Jang
        list.put(2, "김재준");
        list.put(3, "홍석주");
        System.out.println("팀장 : " + list.get(rand));
    }
}
