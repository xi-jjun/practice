package HW1104;

public class Car {
    private int gas;

    public int getGas() {
        return gas;
    }

    public void setGas(int gas) {
        this.gas = gas;
    }

    public void fillGas(int gas, GasStation gasStation) {
        if (gasStation.getGas() < gas) {
            System.out.println("주유실패");
            return;
        }
        this.gas += gas;
        gasStation.setGas(gasStation.getGas() - gas);
    }

    public void show() {
        System.out.println("현재 주유량: " + this.gas + "L");
    }
}
