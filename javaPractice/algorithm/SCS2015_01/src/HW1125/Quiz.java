package HW1125;

public class Quiz {
    private int speedLimit;

    public int speedLimit() {
        this.speedLimit = (int) (Math.random() * 5) + 6;
        while (speedLimit == 9) {
            speedLimit = (int) (Math.random() * 5) + 6;
        }
        return speedLimit * 10;
    }

    public long count(String source, String data) {
        String line = source.replaceAll(data, "");
//        return line.chars()
//                .filter(c -> c == '+')
//                .count();
        return (source.length() - line.length()) / data.length();
    }
}
