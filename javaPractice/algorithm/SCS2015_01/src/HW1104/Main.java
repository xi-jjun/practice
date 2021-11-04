package HW1104;

public class Main {
    public static void main(String[] args) {
        System.out.println("자동차와 주유소");
        Car SM5 = new Car();
        GasStation GS = new GasStation();

        SM5.setGas(10);
        GS.setGas(500);

        SM5.show();
        GS.show();

        SM5.fillGas(50, GS);
        SM5.show();
        GS.show();

        SM5.fillGas(460, GS);
    }
}
