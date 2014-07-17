package com.halldata;

import com.halldata.user.bo.UserBo;

public class UserBean{
 
	//later inject in faces-config.xml
	UserBo userBo;

	public void setUserBo(UserBo userBo) {
		this.userBo = userBo;
	}

	public String printMsgFromSpring() {
		return userBo.getMessage();
	}
}