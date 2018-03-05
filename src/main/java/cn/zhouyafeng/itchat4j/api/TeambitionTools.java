package cn.zhouyafeng.itchat4j.api;

import cn.zhouyafeng.itchat4j.core.Core;
import cn.zhouyafeng.itchat4j.utils.HttpUtil;
import cn.zhouyafeng.itchat4j.utils.MyHttpClient;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import java.util.*;

public class TeambitionTools {

	private static final String url = "https://www.teambition.com/appstore/api/developer/chats/message";

	private static final String organizationId = "5a30c1688a4d91000158ce4f";

	private static final String projects = "5a672d36494dac156ccca5c2";

	private static final String messageType = "text";

	private static final String X_API_KEY = "e84d537d25fc3a0978bd0c76b732b366";

	private static final String CONTENT_TYPE = "application/json";




	public static void sendMessage(String groupName, String memberName, String message){

		if (groupName == null){
			groupName = "私信";
		}

		String text = "来自: " + groupName + "#" + memberName + " :" + message;

		Map<String, String> headers = new HashMap<>();
		headers.put("x-api-key", X_API_KEY);
		headers.put("Content-Type", CONTENT_TYPE);

		String data = "{\"_organizationId\":\"" + organizationId + "\"," +"\"projects\":[\""+ projects +"\"]," +"\"messageType\":\""+ messageType +"\"," +	"\"text\":\"" + text + "\"}";

		HttpEntity entity = new StringEntity(data, ContentType.create("text/json", "UTF-8"));
		HttpResponse post = HttpUtil.post(headers, url, entity, null, 200);
		System.out.println(post);
	}
}
