package cn.zhouyafeng.itchat4j;

import cn.zhouyafeng.itchat4j.controller.LoginController;

public class Wechat {

	public Wechat(String qrPath) {
		System.setProperty("jsse.enableSNIExtension", "false"); // 防止SSL错误

		// 登陆
		LoginController login = new LoginController();
		login.login(qrPath);
	}
}
