package HW1118;

public class Main {
    public static void main(String[] args) {
        Animal Tiger = new Animal("토끼");
        System.out.println("먹은 것 : " + Tiger.getFeed());

        Fish Shark = new Fish("참치", 30);
        Shark.show();
    }
}
