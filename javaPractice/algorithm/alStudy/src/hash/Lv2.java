package hash;

import java.util.*;

public class Lv2 {
    public static void main(String[] args) {
        String[] phoneBook1 = {"119", "114", "112", "123223123", "1231231234"};
        String[] phoneBook2 = {"123", "456", "789"};
        String[] phoneBook3 = {"12", "123", "1235", "567", "88"};

//        System.out.println("phoneBook3.hashCode() = " + phoneBook3[0].hashCode());
//        System.out.println("phoneBook3.hashCode() = " + phoneBook3[1].substring(0,2).hashCode() + " " + phoneBook3[1].substring(0,1));
//        System.out.println("phoneBook3.hashCode() = " + phoneBook3[2].hashCode());
//        System.out.println("phoneBook3.hashCode() = " + phoneBook3[3].hashCode());
//        System.out.println("phoneBook3.hashCode() = " + phoneBook3[4].hashCode());


        System.out.println("phoneBook1 = " + solution(phoneBook1));
        System.out.println("phoneBook2 = " + solution(phoneBook2));
        System.out.println("phoneBook3 = " + solution(phoneBook3));
    }

//    public static boolean solution1(String[] phone_book) {
//        boolean answer = true;
//
//        HashSet<Integer> checkedHash = new HashSet<Integer>();
//        HashSet<String> prefixHash = new HashSet<String>();
//        for (int i = 0; i < phone_book.length; i++) {
//            int length = phone_book[i].length();
//
//            if (checkedHash.contains(length))
//                continue;
//            else
//                checkedHash.add(length);
//
//            prefixHash.clear();
//            for (int j = 0; j < phone_book.length; j++) {
//                String phone = phone_book[j];
//                if (phone.length() < length)
//                    continue;
//
//                String prefix = phone.substring(0, length);
//                if (prefixHash.contains(prefix))
//                    return false;
//                else
//                    prefixHash.add(prefix);
//            }
//        }
//
//        return answer;
//    }

    public static boolean solution(String[] phone_book) {
        boolean answer = true;
        Map<String, String> book = new HashMap<>();
        Arrays.sort(phone_book, Comparator.comparingInt(String::length));
        int minLen = phone_book[0].length();

        for (String phone : phone_book) {
            if (book.containsKey(phone.substring(0, minLen))) {
                int index = 0;
                boolean ok = true;
                String str1 = book.get(phone.substring(0, minLen));

                for (String s1 : str1.split("")) {
                    if (s1.charAt(0) != phone.charAt(index++)) ok = false;
                }
                if (ok) return false;
            }
            book.put(phone.substring(0, minLen), phone);
        }

        return answer;
    }
}
