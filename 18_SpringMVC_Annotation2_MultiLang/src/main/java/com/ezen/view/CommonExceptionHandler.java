//// 예외처리 클래스
//package com.ezen.view;
//
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.servlet.ModelAndView;
//
//@ControllerAdvice("com.ezen.view")
//public class CommonExceptionHandler {
//	@ExceptionHandler(ArithmeticException.class)
//	public ModelAndView handleArithmeticException(Exception e) {
//		ModelAndView mav = new ModelAndView();
//
//		mav.addObject("exception", e);
//		mav.setViewName("/common/arithmeticError.jsp");
//
//		return mav;
//	}
//
//	@ExceptionHandler(IllegalArgumentException.class)
//	public ModelAndView handleIllegalArgumentException(Exception e) {
//		ModelAndView mav = new ModelAndView();
//
//		mav.addObject("exception", e);
//		mav.setViewName("/common/argumentError.jsp");
//
//		return mav;
//	}
//	
//	@ExceptionHandler(NullPointerException.class)
//	public ModelAndView handleNullPointerException(Exception e) {
//		ModelAndView mav = new ModelAndView();
//
//		mav.addObject("exception", e);
//		mav.setViewName("/common/nullPointer.jsp");
//
//		return mav;
//	}
//	
//	@ExceptionHandler(Exception.class)
//	public ModelAndView handleException(Exception e) {
//		ModelAndView mav = new ModelAndView();
//
//		mav.addObject("exception", e);
//		mav.setViewName("/common/error.jsp");
//
//		return mav;
//	}
//}
