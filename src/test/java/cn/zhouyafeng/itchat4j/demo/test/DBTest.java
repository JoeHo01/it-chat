package cn.zhouyafeng.itchat4j.demo.test;

import cn.zhouyafeng.itchat4j.dao.base.Connection;
import cn.zhouyafeng.itchat4j.dao.base.SQL;
import org.apache.ibatis.session.SqlSession;

public class DBTest {
	public static void main(String[] args) {
		new SQL().select("select * from msg");
	}
}
