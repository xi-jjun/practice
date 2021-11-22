package HWexe;

public class Main {
    public static void main(String[] args) {
        TV samsungTv = new TV("샘숭TV");
        Bixby aiSpeaker = new Bixby("빅스비"); // 사용자가 스피커의 이름을 '빅스비'로 설정.

        String userCommand = "빅스비"; // 스피커 call 하는 사용자 음성.
        aiSpeaker.wakeUp(userCommand); // 사용자가 빅스비 호출.
        userCommand = "TV on";
        aiSpeaker.controlTv(userCommand, samsungTv); // 사용자가 TV 켜달라고 요청
        System.out.println("");

        // 사용자가 TV의 채널을 1만큼 증가시키고 싶음.
        userCommand = "TV Plus";
        aiSpeaker.controlTv(userCommand, samsungTv);
        System.out.println("");

        // 사용자가 TV의 채널을 1만큼 감소시키고 싶음.
        userCommand = "TV Minus";
        aiSpeaker.controlTv(userCommand, samsungTv);
        System.out.println("");

        // 사용자가 TV의 채널을 46으로 이동하고 싶음.
        userCommand = "TV 46";
        aiSpeaker.controlTv(userCommand, samsungTv);
        System.out.println("");
    }
}
