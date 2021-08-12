// James와 Tomas는 각각 버스와 지하철을 타고 학교에 갑니다.
// James는 5000원을 가지고 있었고, 100번 버스를 타면서 1000원을 지불합니다.
// Tomas는 10000원을 가지고 있었고, 초록색 지하철을 타면서 1200원을 지불합니다.

// 두 학생이 버스와 지하철을 타는 상황을 구현해 봅시다.

class Bus{
    private int busNum;
    private int passenger;
    private final int busFare = 1000;

    Bus(int busNum) {
        this.busNum = busNum;
        this.passenger = 0;
    }

    int getBusNum(){
        return this.busNum;
    }

    int take() {
        this.passenger++;
        return busFare;
    }

    void getOff() {
        this.passenger--;
        System.out.println(this.passenger + " passengers are left in bus.");
    }
}