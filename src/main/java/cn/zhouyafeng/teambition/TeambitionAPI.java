package cn.zhouyafeng.teambition;

public class TeambitionAPI {
	private static final String base = "https://www.teambition.com";

	public static final String sendMessage = base + "/appstore/api/developer/chats/message";

	public static final String getProjectTags = base + "/api/organizations/{}/projecttags";
}
