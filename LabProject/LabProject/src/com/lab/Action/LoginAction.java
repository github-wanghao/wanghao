/**
 * 
 */
package com.lab.Action;

import javax.annotation.Resource;
import com.lab.Service.UserService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Administrator
 * 
 */
public class LoginAction extends ActionSupport {
	
	@Resource
	private UserService userService;
	
	private String username;
	// �����¼��������
	private String password;

	// �����¼��������

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String execute() throws Exception {

		if (userService.searchUserByNameAndPW(username, password))
			return "success"; // ��¼�ɹ�����SUCCESS
		else
			return "login"; // ��¼ʧ�ܷ���LOGIN
	}


}
