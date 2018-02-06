package cn.zhouyafeng.itchat4j.dao.base;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.DruidPooledConnection;
import org.apache.ibatis.io.Resources;

import java.sql.SQLException;

public class Connection {

	private static DruidDataSource dataSource;

	private Connection() {
	}

	public static void init() throws Exception {
//		if (factory == null) factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("db_config.xml"));
		if (dataSource == null)
			dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(Resources.getResourceAsProperties("db_config.properties"));
	}

	public static DruidPooledConnection getConnection() throws SQLException {
		try {
			init();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataSource.getConnection();
	}
}
