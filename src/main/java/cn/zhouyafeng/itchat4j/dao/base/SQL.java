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
		return result;
	}

	public List<Map<String, String>> select(String sql){
		try {
			connection = Connection.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		PreparedStatement preparedStatement = null;

		try {
			preparedStatement = connection.prepareStatement(sql);
 			ResultSet resultSet = preparedStatement.executeQuery();

 			while (resultSet.next()){
			    for (int i = 1; i < 6 ; i++) {
				    System.out.println(resultSet.getString(i));
			    }
		    }
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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
		return null;
	}
}
