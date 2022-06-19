//0608 결합도가 높은 프로그램 실습 (다형성)
package design_pattern;
		// implements 는 TV(인터페이스)파일의 메소드 가져온것
public class SamsungTV implements TV {
	
	@Override
	public void powerOn() {
		System.out.println("SamsungTV -- 전원을 켠다.");
	
	}
	
	@Override
	public void powerOff() {
		System.out.println("SamsungTV -- 전원을 끈다.");
	}
	
	@Override
	public void volumeUp() {
		System.out.println("SamsungTV -- 소리를 올린다.");
	}
	
	@Override
	public void volumeDown() {
		System.out.println("SamsungTV -- 소리를 내린다.");
	}
	
}
