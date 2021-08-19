// James와 Tomas는 각각 버스와 지하철을 타고 학교에 갑니다.
// James는 5000원을 가지고 있었고, 100번 버스를 타면서 1000원을 지불합니다.
// Tomas는 10000원을 가지고 있었고, 초록색 지하철을 타면서 1200원을 지불합니다.

// 두 학생이 버스와 지하철을 타는 상황을 구현해 봅시다.

class Student{
    private String name;
    private int money;
    private boolean onBus; // default value is false. 
    private boolean onSubway;

    Student(String name, int money) {
        this.name = name;
        this.money = money;
    }

    void takeBus(Bus bus) {
        this.money -= bus.take();
        this.onBus = true;
        System.out.println(this.name + " get on the bus number:" + bus.getBusNum());
    }

    void takeSubway(Subway subway) {
        this.money -= subway.take();
        this.onSubway = true;
        System.out.println(this.name + " get on the subway line:" + subway.getSubwayLine());
    }

    void getOffBus(Bus bus) {
        bus.getOff();
        this.onBus = false;
        System.out.println(this.name + " get off the bus number:" + bus.getBusNum());
    }

    void getOffSubway(Subway subway) {
        subway.getOff();
        this.onSubway = false;
        System.out.println(this.name + " get off the subway line:" + subway.getSubwayLine());
    }

    void showStudentInfo() {
        if(onSubway) System.out.println(this.name + " is in the Subway. He has " + this.money + "won.");
        else if(onBus) System.out.println(this.name + " is in the Bus. He has " + this.money + "won.");
        else System.out.println(this.name + " is walking... He has " + this.money + "won.");
    }
}