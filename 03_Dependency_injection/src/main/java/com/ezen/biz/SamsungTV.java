//0609
package com.ezen.biz;
		// implements 는 TV(인터페이스)파일의 메소드 가져온것
public class SamsungTV implements TV {
	private BoseSpeaker speaker;
	private int price;
	
	public SamsungTV() {
	}
	
	public SamsungTV(BoseSpeaker speaker) {
		this.speaker = speaker;
	}
	
	
	
	

	public SamsungTV(BoseSpeaker speaker, int price) {
		super();
		this.speaker = speaker;
		this.price = price;
	}

	@Override
	public void powerOn() {
		System.out.println("SamsungTV -- 전원을 켠다.");
		System.out.println("price = " + price);
	
	}
	
	@Override
	public void powerOff() {
		System.out.println("SamsungTV -- 전원을 끈다.");
	}
	
	@Override
	public void volumeUp() {
//		System.out.println("SamsungTV -- 소리를 올린다.");
		speaker.volumeUp();
	}
	
	@Override
	public void volumeDown() {
//		System.out.println("SamsungTV -- 소리를 내린다.");
		speaker.volumeDown();
	}
	
}
