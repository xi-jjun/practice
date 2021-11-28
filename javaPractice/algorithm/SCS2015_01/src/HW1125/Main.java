package HW1125;

public class Main {
    public static void main(String[] args) {
        Quiz quiz = new Quiz();
        System.out.println("제한속도= " + quiz.speedLimit() + "km");

        String source = "The old man and the sea";
        System.out.println(quiz.count(source, "he"));
    }
}
