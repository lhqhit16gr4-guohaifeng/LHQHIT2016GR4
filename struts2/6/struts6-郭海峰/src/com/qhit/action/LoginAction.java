package com.qhit.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.qhit.bean.User;

public class LoginAction  extends ActionSupport{
	private User user;
	public String login(){
		if(user.getUsername().equals("admin")&&user.getPassword().equals("123456")){
			ActionContext.getContext().getSession().put("user", user);
			return SUCCESS;
		}
		addActionError("用户名或密码错误，请重新输入");
		return INPUT;
	}
	@Override
	public void validate() {
		if(user==null){
			addFieldError("login.formInput", "未填写用户名或密码");
		}else if(user.getUsername()==null||user.getUsername().length()<3){
			addFieldError("login.username", "用户名长度必须大于3");
		}else if(user.getPassword()==null||user.getPassword().length()<5){
			addFieldError("login.password", "密码长度必须大于5");
		}
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
