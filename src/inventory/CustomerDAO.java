package inventory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerDAO {
	
	public CustomerDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() throws SQLException {
		Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/inventory?charaterEncoding=UTF-8",
				"root","admin");
		return c;
	}
	
	public void add(Customer customer) {
		
		
		String sql = "insert into customer (id, companyName, contactName, contactNumber, email, quantity, status, total)"
				+ "values(null,?,?,?,?,?,?,?)";
		try(Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
			
			
			ps.setString(1, customer.getCompanyName());
			ps.setString(2, customer.getContactName());
			ps.setString(3, customer.getContactNumber());
			ps.setString(4, customer.getEmail());
			ps.setInt(5, customer.getQuantity());
			ps.setString(6, customer.getStatus());
			ps.setInt(7, customer.getTotal());
			ps.execute();
			ResultSet rs = ps.getGeneratedKeys();
			
			while(rs.next()) {
				int id = rs.getInt(1);
				customer.setId(id);
			}
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void update(Customer customer) {
		String sql = "update customer set companyName = ?, contactName = ?, contactNumber = ?, email = ?, quantity = ?, status = ? , total = ? where id = ?";
		try(Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
			
			ps.setString(1, customer.getCompanyName());
			ps.setString(2, customer.getContactName());
			ps.setString(3, customer.getContactNumber());
			ps.setString(4, customer.getEmail());
			ps.setInt(5, customer.getQuantity());
			ps.setString(6, customer.getStatus());
			ps.setInt(7, customer.getTotal());
			ps.setInt(8, customer.getId());
			ps.execute();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(int id) {
		
		try(Connection c = getConnection(); Statement s = c.createStatement() ) {
			String sql = "delete from customer where id =" + id;
			s.execute(sql);
		} catch(SQLException e) {
			e.printStackTrace();
		}
	
	}
	
	public Customer get(int id) {
		
		Customer c = null;
		try(Connection connection = getConnection(); Statement s = connection.createStatement()) {
			
			String sql = "select * from customer where id = " + id;
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				c = new Customer();
				c.setId(id);
				c.setCompanyName(rs.getString(2));
				c.setContactName(rs.getString(3));
				c.setContactNumber(rs.getString(4));
				c.setEmail(rs.getString(5));
				c.setQuantity(rs.getInt(6));
				c.setStatus(rs.getString(7));
				c.setTotal(rs.getInt(8));
			}	
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
	public int getId(String companyName) {
		
		int id = 0;
		
		try(Connection connection =getConnection(); Statement s = connection.createStatement()) {
			
			String sql = "select * from customer where companyName ='"+ companyName + "'";
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				id = rs.getInt(1);
			}		
		} catch(SQLException e) {
			e.printStackTrace();
		}	
		return id;
	}
	
	public List<Customer> list() {
		return list(0, Short.MAX_VALUE);
	}
	
	public List<Customer> list(int start, int count) {
		
		String sql = "select * from customer order by id desc limit ?, ?";
		List<Customer> customerList = new ArrayList<Customer>();
		try(Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
			
			ps.setInt(1, start);
			ps.setInt(2, count);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Customer customer = new Customer();
				int id = rs.getInt(1);
				String companyName = rs.getString(2);
				String contactName = rs.getString(3);
				String contactNumber = rs.getString(4);
				String email = rs.getString(5);
				int quantity = rs.getInt(6);
				String status = rs.getString(7);
				int total = rs.getInt(8);
				customer.setId(id);
				customer.setCompanyName(companyName);
				customer.setContactName(contactName);
				customer.setContactNumber(contactNumber);
				customer.setEmail(email);
				customer.setQuantity(quantity);
				customer.setStatus(status);
				customer.setTotal(total);
				customerList.add(customer);
			}
			 ps.close();
			 c.close();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return customerList;
	}

	public List<Customer> listCustomerByStatus(String input) {
		
		List<Customer> customerList = new ArrayList<>();
		
		try(Connection c = getConnection(); Statement s = c.createStatement()) {
			
			String sql = "select * from customer where status='"+input + "'";
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				Customer customer = new Customer();
				int id = rs.getInt(1);
				String companyName = rs.getString(2);
				String contactName = rs.getString(3);
				String contactNumber = rs.getString(4);
				String email = rs.getString(5);
				int quantity = rs.getInt(6);
				String status = rs.getString(7);
				int total = rs.getInt(8);
				customer.setId(id);
				customer.setCompanyName(companyName);
				customer.setContactName(contactName);
				customer.setContactNumber(contactNumber);
				customer.setEmail(email);
				customer.setQuantity(quantity);
				customer.setStatus(status);
				customer.setTotal(total);
				customerList.add(customer);
			}
			 s.close();
			 c.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return customerList;
	}

	public List<Customer> listCustomerByCompanyName(String input) {
		
		List<Customer> customerList = new ArrayList<>();
		
		try(Connection c = getConnection(); Statement s = c.createStatement()) {
			
			String sql = "select * from customer where companyName='"+input + "'";
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				Customer customer = new Customer();
				int id = rs.getInt(1);
				String companyName = rs.getString(2);
				String contactName = rs.getString(3);
				String contactNumber = rs.getString(4);
				String email = rs.getString(5);
				int quantity = rs.getInt(6);
				String status = rs.getString(7);
				int total = rs.getInt(8);
				customer.setId(id);
				customer.setCompanyName(companyName);
				customer.setContactName(contactName);
				customer.setContactNumber(contactNumber);
				customer.setEmail(email);
				customer.setQuantity(quantity);
				customer.setStatus(status);
				customer.setTotal(total);
				customerList.add(customer);
			}
			 s.close();
			 c.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return customerList;
	}

	public List<Customer> listCustomerByContact(String input) {
		
		List<Customer> customerList = new ArrayList<>();
		
		try(Connection c = getConnection(); Statement s = c.createStatement()) {
			
			String sql = "select * from customer where contactName='"+input + "'";
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				Customer customer = new Customer();
				int id = rs.getInt(1);
				String companyName = rs.getString(2);
				String contactName = rs.getString(3);
				String contactNumber = rs.getString(4);
				String email = rs.getString(5);
				int quantity = rs.getInt(6);
				String status = rs.getString(7);
				int total = rs.getInt(8);
				customer.setId(id);
				customer.setCompanyName(companyName);
				customer.setContactName(contactName);
				customer.setContactNumber(contactNumber);
				customer.setEmail(email);
				customer.setQuantity(quantity);
				customer.setStatus(status);
				customer.setTotal(total);
				customerList.add(customer);
			}
			 s.close();
			 c.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return customerList;
	}
}