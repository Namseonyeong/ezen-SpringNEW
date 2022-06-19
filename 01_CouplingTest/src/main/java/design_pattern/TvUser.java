//0608 결합도를 낮추는 방법 (디자인 패턴 이용)
// 결합도를 낮춘다 - 프로그래머가 소스코드를 많이 손 안대고 최대한 짧게 수정하는것
package design_pattern;

public class TvUser {

	public static void main(String[] args) {
		BeanFactory factory = new BeanFactory();
		
		TV tv = (TV)factory.getBean(args[0]);  //args를 통해 들어오는 내용으로 실행하겠다. args[0]
		
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
	}

}
