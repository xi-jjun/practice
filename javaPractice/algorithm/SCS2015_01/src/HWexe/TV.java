package HWexe;

public class TV {
    private String name;
    private boolean power;
    private int channel;
    private final int MAX_CHANNEL = 100;
    private final int MIN_CHANNEL = 1;

    public TV() {
        this.channel = 1;
    }

    public TV(String name) {
        this.name = name;
        this.channel = 1;
    }

    public int getChannel() {
        return channel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPower() {
        return power;
    }

    public void goChannel(int channel) {
        this.channel = channel;
        System.out.println("현재 채널은 " + this.channel + " 입니다");
    }

    public void channelPlus() {
        if(power) {
            this.channel++;
            if (channel > MAX_CHANNEL) channel = 1;
            System.out.println("현재 채널은 " + this.channel + " 입니다");
        } else System.out.println("전원이 꺼져있습니다");
    }

    public void channelMinus() {
        if(power) {
            this.channel--;
            if (this.channel < MIN_CHANNEL) this.channel = 100;
            System.out.println("현재 채널은 " + this.channel + " 입니다");
        } else System.out.println("전원이 꺼져있습니다");
    }

    public void turnOn() {
        this.power = true;
        System.out.println("현재 " + this.name + " 이 켜졌습니다");
    }

    public void turnOff() {
        System.out.println(this.name + " 이 종료됩니다");
        this.power = false;
    }
}
