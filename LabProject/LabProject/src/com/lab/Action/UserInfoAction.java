package com.lab.Action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.mail.Session;

import org.apache.struts2.interceptor.SessionAware;

import com.lab.Entity.Users;
import com.lab.Service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class UserInfoAction extends ActionSupport implements SessionAware{
	@Resource
	private UserService userService;
	private Users user;
	Map<String, Object> session;
	private String Sex;
	
	

	public String getSex() {
		return Sex;
	}


	public void setSex(String sex) {
		Sex = sex;
	}


	public UserService getUserService() {
		return userService;
	}


	public void setUserService(UserService userService) {
		this.userService = userService;
	}


	public Users getUser() {
		return user;
	}


	public void setUser(Users user) {
		this.user = user;
	}

	public String Select() throws Exception{
		List<Users> userList = userService.SelectUserInfo(session.get("UserID").toString());
		System.out.println(userList.toString());
		if(userList.size()!= 0){			
			return "success"; 
		}	
		else
			return "login"; 
	}	
	public String Update() throws Exception{
		if(this.Sex.equals("ÄÐ")){
			user.setUserSex(0);
			userService.updateUser(session.get("UserID").toString(), user);
			return "success";
		}else if(this.Sex.equals("Å®")){
			user.setUserSex(1);
			userService.updateUser(session.get("UserID").toString(), user);
			return "success";
		}else{
			return "login";
		}
		
		
	}


	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = session;
	}	
}
