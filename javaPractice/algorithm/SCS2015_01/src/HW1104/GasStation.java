package HW1104;

public class GasStation {
    private int gas;

    public int getGas() {
        return gas;
    }

    public void setGas(int gas) {
        this.gas = gas;
    }

    public void show() {
        System.out.println("현재 재고량: "+this.gas+"L");
    }
}
