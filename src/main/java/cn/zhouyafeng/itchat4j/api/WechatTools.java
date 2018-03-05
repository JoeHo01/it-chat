package cn.zhouyafeng.itchat4j.api;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;

import cn.zhouyafeng.itchat4j.core.Core;
import cn.zhouyafeng.itchat4j.utils.enums.StorageLoginInfoEnum;
import cn.zhouyafeng.itchat4j.utils.enums.URLEnum;

/**
 * 微信小工具，如获好友列表等
 * 
 * @author https://github.com/yaphone
 * @date 创建时间：2017年5月4日 下午10:49:16
 * @version 1.0
 *
 */
public class WechatTools {
	private static Logger LOG = LoggerFactory.getLogger(WechatTools.class);

	private static Core core = Core.getInstance();

	public static boolean webWxLogout() {
		String url = String.format(URLEnum.WEB_WX_LOGOUT.getUrl(),
				core.getLoginInfo().get(StorageLoginInfoEnum.url.getKey()));
		List<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();
		params.add(new BasicNameValuePair("redirect", "1"));
		params.add(new BasicNameValuePair("type", "1"));
		params.add(
				new BasicNameValuePair("skey", (String) core.getLoginInfo().get(StorageLoginInfoEnum.skey.getKey())));
		try {
			HttpEntity entity = core.getHttpService().doGet(url, params, false, null);
			String text = EntityUtils.toString(entity, Consts.UTF_8); // 无消息
			return true;
		} catch (Exception e) {
			LOG.debug(e.getMessage());
		}
		return false;
	}

	public static void setUserInfo() {
		for (JSONObject o : core.getContactList()) {
			core.getUserInfoMap().put(o.getString("NickName"), o);
			core.getUserInfoMap().put(o.getString("UserName"), o);
		}
	}
}
