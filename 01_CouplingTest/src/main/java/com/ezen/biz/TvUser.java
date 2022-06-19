package com.ezen.biz;

public class TvUser {

	public static void main(String[] args) {
		/*SamsungTV tv = new SamsungTV();
		 *
		 * tv.powerOn(); 
		 * tv.volumeUp(); 
		 * tv.volumeDown(); 
		 * tv.powerOff();
		 * 
		 * tv 객체가 SamsungTV에서 LgTV로 바뀔경우 
		 * 객체 생성과 메소드 호출 모두 변경 필요
		 */
		
		
		LgTV tv = new LgTV();
		
		tv.turnOn();
		tv.soundUp();
		tv.soundUp();
		tv.turnOff();
		
		
		
	}

}
