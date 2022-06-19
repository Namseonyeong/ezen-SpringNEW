//0608 결합도가 높은 프로그램 실습 (다형성)
package polymorphism;

public class TvUser {

	public static void main(String[] args) {
//		TV tv = new SamsungTV();

//		 SamsungTV 객체 대신 LgTV객체를 사용할 경우 
		TV tv = new LgTV();
		
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
	}

}
