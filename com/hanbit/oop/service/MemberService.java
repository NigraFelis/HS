package com.hanbit.oop.service;

import com.hanbit.oop.domain.MemberBean;

public class MemberService {
	MemberBean session;
	public MemberService(){
		session = new MemberBean();
	}

	public String getGender(MemberBean member){
		String gender="";
		char ch = member.getSSN().charAt(7);
		switch (ch){
			case '1' :
				gender = "male";
			break;
			case '2' :
				gender = "female";
			break;
			case '3' :
				gender = "male";
			break;
			case '4' :
				gender = "female";
			break;
			case '5' :
				gender = "foreigner";
			break;
			case '6' :
				gender = "foreigner";
			break;
			default: 
				gender = "error";
			break;
		}
		return gender;
	}
		
	public String getAge(MemberBean member){
		
		int age = 0;
		int year = Integer.parseInt(member.getSSN().substring(0,2));
		
		if(17-year>=0){
			age = (17-year);
		}
		else {
			age = (2017-1900-year);
		}
		return String.valueOf(age);
	}
	
	public String join(MemberBean memberBean){
		String result = "회원가입 성공!";
		// session에 회원가입시 입력한 정보를 저장하는 소스
		session = memberBean; 
		// 객체지향 (객체로 "주소"값을 전달하고 받는다. 객체 자체를 똑같이 카피해둔다. 
		// But, 값 copy가 아니라서 member가 바뀌면 session이 갱신된다.)
		return result;
	}
	
	public String login(MemberBean memberBean, MemberBean temp) {
		String login = "", gender = getGender(memberBean), age = getAge(memberBean);
		if (temp.getId().equals(session.getId())) {
			if (temp.getPassword().equals(session.getPassword())) {
				login = memberBean.toString(gender, age);
			} else {
				login = "비밀번호가 일치하지 않습니다.\n";	
			}
		} else {
			login = "아이디를 확인해주세요.\n";
		}
		return login;
	}
	
}
