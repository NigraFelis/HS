package com.hanbit.oop.controller;

import com.hanbit.oop.domain.MemberBean;
import com.hanbit.oop.service.MemberService;
import javax.swing.*;

public class MemberController {
	public static void main(String[] args) {
		
		MemberService memberService = new MemberService();
		MemberBean memberBean = new MemberBean();

		while(true){
			switch(JOptionPane.showInputDialog("0.end 1.등록 .2로그인")) {
				case "0": 
					System.out.print("end");
				return;
				
				case "1":
					memberBean.setName(JOptionPane.showInputDialog("Name"));
					memberBean.setId(JOptionPane.showInputDialog("Id"));
					memberBean.setPassword(JOptionPane.showInputDialog("Password"));
					memberBean.setSNN(JOptionPane.showInputDialog("SSN"));
					JOptionPane.showMessageDialog(null, memberService.join(memberBean));
					
					break;

				case "2":
					MemberBean temp = new MemberBean();
					temp.setId(JOptionPane.showInputDialog("Id"));
					temp.setPassword(JOptionPane.showInputDialog("Pw"));
					JOptionPane.showMessageDialog(null, memberService.login(memberBean, temp));
					/*System.out.println(memberService.login(member));*/

					break;
				
				default:
					break;
			}
		}
	}
	
}
