package HWexe;

public class Bixby {
    private String name;
    private boolean wakedUp;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Bixby(){}

    public Bixby(String name) {
        this.name = name;
    }

    public void wakeUp(String userSentence) {
        System.out.println("네? 부르셨나요?");
        this.wakedUp = true;
    }

    public void controlTv(String userCommand, TV tv) {
        if(wakedUp) {
            System.out.println(userCommand + " 명령어가 실행됩니다");
            if (userCommand.contains("TV") && userCommand.contains("on")) tv.turnOn();
            if (userCommand.contains("off")) tv.turnOff();
            if (userCommand.contains("Plus")) tv.channelPlus();
            if (userCommand.contains("Minus")) tv.channelMinus();
            if (userCommand.contains("0")) tv.goChannel(10);
        } else System.out.println("무반응");
    }
}
