package in.co.rays.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.bean.UserBean;
import in.co.rays.util.JdbcDataSource;

public class UserModel {
	public List search(UserBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/marksheets", "root", "root");
		StringBuffer sbf = new StringBuffer("select * from user where 1=1");
		if (bean != null) {
			if (bean.getId() > 0) {
				sbf.append("and id = " + bean.getId());

			}
			if (bean.getFirstName() != null && bean.getFirstName().length() > 0) {
				sbf.append("and Name like '" + bean.getFirstName() + "%'");

			}
			if (bean.getLastName() != null && bean.getLastName().length() > 0) {
				sbf.append("and lastName like '" + bean.getLastName() + "%'");

			}

		}
		PreparedStatement ps = conn.prepareStatement(sbf.toString());
		ResultSet rs = ps.executeQuery();

		ArrayList list = new ArrayList();

		while (rs.next()) {
			UserBean Bean = new UserBean();
			Bean.setId(rs.getInt(1));
			Bean.setFirstName(rs.getString(2));
			Bean.setLastName(rs.getString(3));
			Bean.setLoginId(rs.getString(4));
			Bean.setPassword(rs.getString(5));
			Bean.setAddress(rs.getString(6));

			list.add(Bean);
		}

		return list;

	}

	public UserBean findByPk(int id) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/marksheets", "root", "root");
		PreparedStatement ps = conn.prepareStatement("select * from user where id = ?");
		ps.setInt(1, id);

		ResultSet rs = ps.executeQuery();
		UserBean Bean = null;
		while (rs.next()) {
			Bean = new UserBean();
			Bean.setId(rs.getInt(1));
			Bean.setFirstName(rs.getString(2));
			Bean.setLastName(rs.getString(3));
			Bean.setLoginId(rs.getString(4));
			Bean.setPassword(rs.getString(5));
			Bean.setAddress(rs.getString(6));

		}
		return Bean;

	}

	public Integer nextPk() throws Exception {
		int pk = 0;
		Connection conn = JdbcDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("select max(id) from user");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			pk = rs.getInt(1);
		}

		return pk + 1;

	}

	public UserBean add(UserBean Bean) throws Exception {
		Connection conn = JdbcDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("insert into user values(?, ?, ?, ?, ?, ?)");
		ps.setInt(1, nextPk());
		ps.setString(2, Bean.getFirstName());
		ps.setString(3, Bean.getLastName());
		ps.setString(4, Bean.getLoginId());
		ps.setString(5, Bean.getPassword());
		ps.setString(6, Bean.getAddress());
		int i = ps.executeUpdate();
		System.out.println("Data inserted = " + i);
		conn.close();
		return Bean;
	}

	public void Delete(UserBean Bean) throws Exception {
		Connection conn = JdbcDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("delete from user where id = ?");
		ps.setInt(1, Bean.getId());
		int i = ps.executeUpdate();
		System.out.println("Data Deleted = " + i);

	}

	public UserBean Update(UserBean Bean) throws Exception {
		Connection conn = JdbcDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement(
				"update user set FirstName = ?, LastName = ?, LoginId = ?, Password = ?, Address = ? where id = ?");
		ps.setString(1, Bean.getFirstName());
		ps.setString(2, Bean.getLastName());
		ps.setString(3, Bean.getLoginId());
		ps.setString(4, Bean.getPassword());
		ps.setString(5, Bean.getAddress());
		ps.setInt(6, Bean.getId());
		int i = ps.executeUpdate();
		System.out.println("data updated = " + i);
		conn.close();
		ps.close();
		return Bean;
	}

	public UserBean findByname(String name) throws Exception {
		Connection conn = JdbcDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("select * from user where FirstName = ?");
		ps.setString(1, name);
		ResultSet rs = ps.executeQuery();
		UserBean Bean = null;
		while (rs.next()) {
			Bean = new UserBean();
			Bean.setId(rs.getInt(1));
			Bean.setFirstName(rs.getString(2));
			Bean.setLastName(rs.getString(3));
			Bean.setLoginId(rs.getString(4));
			Bean.setPassword(rs.getString(5));
			Bean.setAddress(rs.getString(6));
		}
		return Bean;

	}

	public UserBean authenticate(String loginId, String password) throws Exception {
		Connection conn = JdbcDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("select * from user where loginId = ? and password = ? ");
		ps.setString(1, loginId);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		UserBean bean = null;
		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLoginId(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setAddress(rs.getString(6));

		}
		return bean;

	}

	public List search() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/marksheets", "root", "root");
		PreparedStatement ps = conn.prepareStatement("select * from User");
		ResultSet rs = ps.executeQuery();

		ArrayList list = new ArrayList();

		while (rs.next()) {
			UserBean bean = new UserBean();

			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLoginId(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setAddress(rs.getString(6));

			list.add(bean);
		}

		return list;

	}

}
