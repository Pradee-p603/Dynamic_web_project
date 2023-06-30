package in.co.rays.test;

import java.util.Iterator;
import java.util.List;
import in.co.rays.bean.UserBean;
import in.co.rays.model.UserModel;

public class TestUser {

	public static void main(String[] args) throws Exception {
		// testSearch();
		// testFindById();
		
		// testDelete();
		// testUpdate();
		testfindByName();
	}

	private static void testfindByName() throws Exception {

		UserModel Model = new UserModel();
		UserBean Bean = Model.findByname("AAA");
		if (Bean != null) {
			System.out.println(Bean.getId());
			System.out.print("\t" + Bean.getFirstName());
			System.out.print("\t" + Bean.getLastName());
			System.out.print("\t" + Bean.getLoginId());
			System.out.print("\t" + Bean.getPassword());
			System.out.println("\t"  + Bean.getAddress());

		} else {
			System.out.println("no such name found");
		}

	}

	private static void testUpdate() throws Exception {
		UserBean Bean = new UserBean();
		Bean.setFirstName("Dynamic");
		Bean.setLastName("Pawan");
		Bean.setLoginId("123456");
		Bean.setPassword("567890");
		Bean.setAddress("khandwa");
		UserModel Model = new UserModel();
		Model.add(Bean);

	}

	private static void testDelete() throws Exception {
		UserBean Bean = new UserBean();
		Bean.setId(2);
		UserModel Model = new UserModel();
		Model.Delete(Bean);

	}

	private static void testadd() throws Exception {
		UserBean Bean = new UserBean();
		Bean.setFirstName("Dynamic");
		Bean.setLastName("Shivam");
		Bean.setLoginId("123456");
		Bean.setPassword("1234567");
		Bean.setAddress("Raiibatpura");
		UserModel model = new UserModel();
		model.add(Bean);

	}

	private static void testFindById() throws Exception {
		UserModel model = new UserModel();
		UserBean bean = model.findByPk(1);
		if (bean != null) {
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getLoginId());
			System.out.print("\t" + bean.getPassword());
			System.out.println("\t" + bean.getAddress());

		} else {
			System.out.println("Id does not exits.......!!!!");
		}

	}

	private static void testSearch() throws Exception {
		UserBean bean = new UserBean();

		UserModel model = new UserModel();
		List List = model.search(bean);

		Iterator it = List.iterator();

		while (it.hasNext()) {

			bean = (UserBean) it.next();
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getLoginId());
			System.out.print("\t" + bean.getPassword());
			System.out.println("\t" + bean.getAddress());

		}

	}

}
