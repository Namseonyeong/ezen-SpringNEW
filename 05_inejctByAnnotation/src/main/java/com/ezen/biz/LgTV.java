package com.ezen.biz;

import javax.annotation.Resource;
import org.springframework.stereotype.Component;


//@이 포함된 문자열 : 어노테이션(Annotation)
@Component("tv")

public class LgTV implements TV{
	
	// 컨테이너에 등록된 객체를 찾아서 자동으로 할당
	//@Autowired  
	//@Qualifier("bose")
	@Resource(name="bose")
	private Speaker speaker; // 스피커 객체
	
	
	public LgTV() {
		System.out.println("===> LgTV 객체 생성");
	}

	@Override
	public void powerOn() {
		System.out.println("LgTV -- 전원을 켜다.");
	}

	@Override
	public void powerOff() {
		System.out.println("LgTV -- 전원을 끈다.");
	}

	@Override
	public void volumeUp() {
		speaker.volumeUp(); //객체 생성을 안하면 nullpointException 발생 
	}

	@Override
	public void volumeDown() {
		speaker.volumeDown();
	}
}
