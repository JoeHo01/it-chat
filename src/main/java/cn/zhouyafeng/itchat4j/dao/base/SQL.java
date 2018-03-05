package cn.zhouyafeng.itchat4j.dao.base;

import com.alibaba.druid.pool.DruidPooledConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class SQL {

	private DruidPooledConnection connection;

	public int update(String sql) {
		try {
			connection = Connection.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		PreparedStatement preparedStatement = null;
		int result = 0;
		try {
			preparedStatement = connection.prepareStatement(sql);
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(preparedStatement);
		}
		return result;
	}

	private void close(PreparedStatement preparedStatement){
		try {
			if (null != preparedStatement) {
				preparedStatement.close();
			}
			if (null != connection) {
				connection.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
