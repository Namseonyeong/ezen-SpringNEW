// View 소스를 해석해준다 
package com.ezen.view.controller;

public class ViewResolver {
	private String prefix;  // prefix : View 이름 앞에 붙여지는 경로를 저장
	private String suffix; // suffix : View 확장자를 저장
	
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	
	/*
	 *  get View 메소드 : 응답을 보낼 View를 반환하는 메소드(return)
	 */
	public String getView(String viewName) {
		
		return prefix + viewName + suffix;
	}
}
