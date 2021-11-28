package HWexe;

public class Bixby {
    private String name;
    private boolean wakedUp;
    private final String[] bye = {
            "불러주셔서 고마워요!",
            "좋은 하루 되세요!",
            "감사합니다",
            "언제든지 다시 불러주세요"
    };

    public Bixby() {
    }

    public Bixby(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void getSleep() {
        int index = (int) (Math.random() * 4);
        System.out.println(bye[index]);
        this.wakedUp = false;
    }

    public void wakeUp(String userCall) {
        if(userCall.equals(this.name)) {
            System.out.println("네? 부르셨나요?");
            this.wakedUp = true;
        }
    }

    public void controlTv(String userCommand, TV tv) {
        if (wakedUp) {
            System.out.println(userCommand + " 명령어가 실행됩니다");
            String[] cmd = userCommand.split(" ");
            if (userCommand.contains("TV") && userCommand.contains("on")) tv.turnOn();
            if (userCommand.contains("off")) tv.turnOff();
            if (userCommand.contains("Plus")) tv.channelPlus();
            if (userCommand.contains("Minus")) tv.channelMinus();
            if (48 <= cmd[1].charAt(0) && cmd[1].charAt(0) <= 57) tv.goChannel(Integer.parseInt(cmd[1]));
        } else System.out.println("무반응");

        getSleep();
    }
}
