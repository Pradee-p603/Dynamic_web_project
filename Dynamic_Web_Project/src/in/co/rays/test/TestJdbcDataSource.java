package in.co.rays.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.co.rays.bean.UserBean;
import in.co.rays.util.JdbcDataSource;

public class TestJdbcDataSource {
	public static void main(String[] args) throws Exception {
		
		testDCP();
	}

	private static void testDCP()throws Exception {
		Connection conn = JdbcDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("select * from Marksheet where id = 1");
	  ResultSet rs =	ps.executeQuery();
	  UserBean Bean = null;
	  while(rs.next()) {
		  Bean = new UserBean();
		  System.out.print( rs.getInt(1));
		  System.out.print("\t = "+ rs.getString(2));
		  System.out.print("\t = "+ rs.getString(3));
		  System.out.print("\t = "+ rs.getString(4));
		  System.out.print("\t = "+ rs.getString(5));
		  System.out.println("\t = "+ rs.getString(6));
		  
		  
	  }
	}

}
