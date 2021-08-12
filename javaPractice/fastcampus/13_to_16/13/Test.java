// James와 Tomas는 각각 버스와 지하철을 타고 학교에 갑니다.
// James는 5000원을 가지고 있었고, 100번 버스를 타면서 1000원을 지불합니다.
// Tomas는 10000원을 가지고 있었고, 초록색 지하철을 타면서 1200원을 지불합니다.

// 두 학생이 버스와 지하철을 타는 상황을 구현해 봅시다.

class Test{
    public static void main(String[] args) {
        Student James = new Student("James", 5000);
        Student Tomas = new Student("Toams", 10000);
        Bus bus100 = new Bus(100);
        Subway subwayGreen = new Subway("Green");

        James.takeBus(bus100);
        Tomas.takeSubway(subwayGreen);

        System.out.println("");

        James.showStudentInfo();
        Tomas.showStudentInfo();

        System.out.println("");

        James.getOffBus(bus100);
        Tomas.getOffSubway(subwayGreen);

        System.out.println("");

        James.showStudentInfo();
        Tomas.showStudentInfo();
    }
}