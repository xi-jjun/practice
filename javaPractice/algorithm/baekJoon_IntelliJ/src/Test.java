import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
//        int rand = (int) (Math.random() * 3) + 1;
//        Map<Integer, String> list = new HashMap<>();
//        list.put(1, "경제목"); // Team Jang
//        list.put(2, "김재준");
//        list.put(3, "홍석주");
//        System.out.println("팀장 : " + list.get(rand));
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        int a = list.remove(list.size()-1);
        System.out.println("a = " + a);
    }
}
