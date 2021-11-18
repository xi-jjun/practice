package HW1118;

public class Fish extends Animal {
    private int nowDepth;

    public Fish(String feed, int nowDepth) {
        super(feed);
        this.nowDepth = nowDepth;
    }

    public void show() {
        System.out.println("먹은 것 : " + super.getFeed() + ", 현재 수심 : " + this.nowDepth + "m");
    }
}
