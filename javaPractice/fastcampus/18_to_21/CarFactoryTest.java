public class CarFactoryTest {

	public static void main(String[] args) {
		CarFactory factory = CarFactory.getInstance();
		Car sonata = factory.makingCar("Sonata", "White");
		Car volvo = factory.makingCar("Volvo", "Black");
        Car genesis = factory.makingCar("Genesis", "Black");
		
		sonata.thisCarInfo();     //10001 출력
		volvo.thisCarInfo();   //10002 출력
        genesis.thisCarInfo();
	}
}
