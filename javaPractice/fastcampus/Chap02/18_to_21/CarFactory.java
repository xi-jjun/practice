// 자동차 공장이 있습니다. 자동차 공장은 유일한 객체이고, 이 공장에서 생산되는 자동차는 제작될 때마다 고유의 번호가 부여됩니다. 
// 자동차 번호가 10001부터 시작되어 자동차가 생산될 때마다 10002, 10003 이렇게 번호가 붙도록 자동차 공장 클래스, 자동차 클래스를 구현하세요
// 다음 CarFactoryTest.java 테스트 코드가 수행 되도록 합니다.

class CarFactory{
    private static CarFactory instance = new CarFactory();
    private static int makeCount = 0;

    private CarFactory() { }

    public static CarFactory getInstance() {
        if(instance == null) {
            instance = new CarFactory();
        }
        return instance;
    }

    Car makingCar(String carName, String carColor) {
        Car makedCar = new Car(carName, carColor);
        makeCount++;
        return makedCar;
    }

    void factoryInfo() {
        System.out.println("The factory make " + makeCount + " cars.");
    }
}