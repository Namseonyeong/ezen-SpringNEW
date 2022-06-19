//0608 결합도가 높은 프로그램 실습 (다형성)
package polymorphism;

public class LgTV implements TV {
	
	@Override
	public void powerOn() {
		System.out.println("LgTV -- 전원을 켠다.");
	
	}
	
	@Override
	public void powerOff() {
		System.out.println("LgTV -- 전원을 끈다.");
	}
	
	@Override
	public void volumeUp() {
		System.out.println("LgTV -- 소리를 올린다.");
	}
	
	@Override
	public void volumeDown() {
		System.out.println("LgTV -- 소리를 내린다.");
	}
}

