//0608 결합도를 낮추는 방법 (디자인 패턴 이용) / 요청한 문자열을 가지고 리턴해주는 메소드
package design_pattern;

public class BeanFactory {
	
	/*
	 * 매개변수 :
	 * 		beanName - 요청하는 객체명 (Samsung, Lg)
	 */
	public Object getBean(String beanName) {

		if (beanName.equals("Samsung")) {
			return new SamsungTV();
		} else if (beanName.equals("Lg")) {
			return new LgTV();
		}

		return null;
	}

}
