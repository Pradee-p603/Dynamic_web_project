package in.co.rays.util;
	import java.sql.Connection;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.ResourceBundle;

	import com.mchange.v2.c3p0.ComboPooledDataSource;

	public final class JdbcDataSource {
		private static JdbcDataSource jds = null;
		private ComboPooledDataSource ds = null;
        private ResourceBundle rb = null;
		private JdbcDataSource() {
			try {
				ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.bundle.app");
				ds = new ComboPooledDataSource();
				ds.setDriverClass(rb.getString("Driver"));
				ds.setJdbcUrl(rb.getString("Url"));
				ds.setUser(rb.getString("User"));
				ds.setPassword(rb.getString("Password"));
				ds.setInitialPoolSize(Integer.parseInt(rb.getString("initial")));
				ds.setAcquireIncrement(Integer.parseInt(rb.getString("incriment")));
				ds.setMaxPoolSize(Integer.parseInt(rb.getString("maxpool")));

			} catch (Exception e) {
				e.printStackTrace();

			}
		} 

		public static JdbcDataSource getinstance() {
			if (jds == null) {
				jds = new JdbcDataSource();
			}
			return jds;
		}

		public static Connection getConnection() {
			try {
				return getinstance().ds.getConnection();

			} catch (SQLException e) {
				return null;
			}
		}

		public static void CloseConnection(Connection conn, Statement stmt, ResultSet rs) {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();

			} catch (Exception e) {
				e.printStackTrace();

			}
		}

		public static void CloseConnection(Connection conn, Statement stmt) {
			CloseConnection(conn, stmt, null);

		}

		public static void CloseConnection(Connection conn) {
			CloseConnection(conn, null, null);
		}
	}



