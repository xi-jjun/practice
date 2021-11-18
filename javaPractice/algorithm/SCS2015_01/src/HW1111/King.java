package HW1111;

public class King {
    private String name;
    private int seq;

    public King() {
    }

    public King(String name, int seq) {
        this.name = name;
        this.seq = seq;
    }

    public void showInfo() {
        System.out.println("조선 " + seq + "대 왕 " + name);
    }
}
