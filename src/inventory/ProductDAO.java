package inventory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import inventory.DateUtil;

import java.util.ArrayList;
import java.util.Date;

import inventory.CustomerDAO;
import inventory.Customer;

public class ProductDAO {
	
	public ProductDAO() {
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
	
	public void add(Product product) {
		
		String sql = "insert into product (id, productName, type, createDate, MACaddr, status, password, comment)"
				+ " values(null,?,?,?,?,?,?,?)";
		try(Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
			
			ps.setString(1, product.getProductName());
			ps.setString(2, product.getType());		
			ps.setTimestamp(3, DateUtil.d2t(product.getCreateDate()));
			ps.setString(4, product.getmacAddr());
			ps.setString(5, product.getStatus());
			ps.setString(6, product.getPassword());
			ps.setString(7, product.getComment());
			ps.execute();
			ResultSet rs = ps.getGeneratedKeys();
			
			while(rs.next()) {
				int id = rs.getInt(1);
				product.setId(id);
			}
			System.out.println("A new product is inserted");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void update(Product product) {
		
		String sql = "update product set productName = ?, type = ?, MACaddr = ?, status = ?, soldDate = ?, cid = ?, password = ?, comment = ? where id = ?";
		try(Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
			
			ps.setString(1, product.getProductName());
			ps.setString(2, product.getType());
			//ps.setTimestamp(3, DateUtil.d2t(product.getCreateDate()));
			ps.setString(3, product.getmacAddr());
			ps.setString(4, product.getStatus());
			ps.setString(5,product.getSoldDate());
			ps.setInt(6, product.getCid());
			ps.setString(7, product.getPassword());
			ps.setString(8, product.getComment());
			ps.setInt(9, product.getId());
			ps.execute();
			System.out.println(product.getSoldDate());
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(int id) {
		
		try(Connection c = getConnection(); Statement s = c.createStatement() ) {
			String sql = "delete from product where id =" + id;
			s.execute(sql);
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Product get(int id) {
		
		Product p = null;
		try(Connection c = getConnection(); Statement s = c.createStatement()) {
			
			String sql = "select * from product where id = " + id;
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				int cid = rs.getInt(8); 
				p = new Product();
				p.setId(id);
				p.setProductName(rs.getString(2));
				p.setType(rs.getString(3));
				p.setCreateDate(DateUtil.t2d(rs.getTimestamp(4)));
				p.setMACAddr(rs.getString(5));
				p.setStatus(rs.getString(6));
				//p.setSoldDate(DateUtil.t2d(rs.getTimestamp(7)));
				p.setCid(cid);
				p.setPassword(rs.getString(9));
				p.setComment(rs.getString(10));	
				p.setCustomer(new CustomerDAO().get(cid));
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return p;
	}
	
	public Product scan(String macAddr) {
		
		Product p = null;
		try(Connection c = getConnection(); Statement s = c.createStatement()) {
			
			String sql = "select * from product where macAddr = '" + macAddr+"'";
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				int cid = rs.getInt(8);
				p = new Product();
				p.setId(rs.getInt(1));
				p.setProductName(rs.getString(2));
				p.setType(rs.getString(3));
				p.setCreateDate(DateUtil.t2d(rs.getTimestamp(4)));
				p.setMACAddr(macAddr);
				p.setStatus(rs.getString(6));
				//p.setSoldDate(DateUtil.t2d(rs.getTimestamp(7)));
				p.setCid(cid);
				p.setPassword(rs.getString(9));
				p.setComment(rs.getString(10));	
				p.setCustomer(new CustomerDAO().get(cid));
				
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return p;
	}
	public List<Product> list() {
		return list(0,Short.MAX_VALUE);
	}
	
	public List<Product> list(int start, int count) {
			
		Customer company = new Customer();
		CustomerDAO customerDAO = new CustomerDAO();
		String sql = "select * from product order by id desc limit ?, ?";
		List<Product> productList = new ArrayList<Product>();
		try(Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
			
			ps.setInt(1, start);
			ps.setInt(2, count);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Product p = new Product();
			
				int id = rs.getInt(1);
				String productName = rs.getString(2);
				String type = rs.getString(3);
				Date createDate = DateUtil.t2d(rs.getTimestamp(4));
				String macAddr = rs.getString(5);
				String status = rs.getString(6);
				String soldDate = rs.getString(7);			
				int cid = rs.getInt(8);
				company = customerDAO.get(cid);
				String password = rs.getString(9);
				String comment = rs.getString(10);
				p.setId(id);
				p.setProductName(productName);
				p.setType(type);
				p.setCreateDate(createDate);
				p.setMACAddr(macAddr);
				p.setStatus(status);
				p.setSoldDate(soldDate);
				p.setCid(cid);
				p.setCustomer(company);
				p.setPassword(password);
				p.setComment(comment);
				productList.add(p);
			}
			 ps.close();
			 c.close();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return productList;
	}
	
	public List<Product> listProductByProductName(String input) {	
		
		Customer company = new Customer();
		CustomerDAO customerDAO = new CustomerDAO();
		List<Product> products = new ArrayList<>();
		String sql = "select * from product where productName ='"+input + "'";
		
		try(Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {	
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Product p = new Product();
				int id = rs.getInt(1);
				String productName = rs.getString(2);
				String type = rs.getString(3);
				Date createDate = DateUtil.t2d(rs.getTimestamp(4));
				String macAddr = rs.getString(5);
				String status = rs.getString(6);
				String soldDate = rs.getString(7);			
				int cid = rs.getInt(8);
				company = customerDAO.get(cid);
				String password = rs.getString(9);
				String comment = rs.getString(10);
				p.setId(id);
				p.setProductName(productName);
				p.setType(type);
				p.setCreateDate(createDate);
				p.setMACAddr(macAddr);
				p.setStatus(status);
				p.setSoldDate(soldDate);
				p.setCid(cid);
				p.setCustomer(company);
				p.setPassword(password);
				p.setComment(comment);
				products.add(p);
			}	
			 ps.close();
			 c.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return products;
	}
	
	public List<Product> listProductByCompanyId(int input) {	
		
		Customer company = new Customer();
		CustomerDAO customerDAO = new CustomerDAO();
		List<Product> products = new ArrayList<>();
		String sql = "select * from product where cid ="+input;
		
		try(Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {	
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Product p = new Product();
				int id = rs.getInt(1);
				String productName = rs.getString(2);
				String type = rs.getString(3);
				Date createDate = DateUtil.t2d(rs.getTimestamp(4));
				String macAddr = rs.getString(5);
				String status = rs.getString(6);
				String soldDate = rs.getString(7);			
				int cid = input;
				company = customerDAO.get(cid);
				String password = rs.getString(9);
				String comment = rs.getString(10);
				p.setId(id);
				p.setProductName(productName);
				p.setType(type);
				p.setCreateDate(createDate);
				p.setMACAddr(macAddr);
				p.setStatus(status);
				p.setSoldDate(soldDate);
				p.setCid(cid);
				p.setCustomer(company);
				p.setPassword(password);
				p.setComment(comment);
				products.add(p);
			}	
			 ps.close();
			 c.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return products;
	}
	
	public List<Product> listProductByStatus(String input) {	
		
		Customer company = new Customer();
		CustomerDAO customerDAO = new CustomerDAO();
		List<Product> products = new ArrayList<>();
		String sql = "select * from product where status ='"+input + "'";
		
		try(Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {	
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Product p = new Product();
				int id = rs.getInt(1);
				String productName = rs.getString(2);
				String type = rs.getString(3);
				Date createDate = DateUtil.t2d(rs.getTimestamp(4));
				String macAddr = rs.getString(5);
				String status = rs.getString(6);
				String soldDate = rs.getString(7);			
				int cid = rs.getInt(8);
				company = customerDAO.get(cid);
				String password = rs.getString(9);
				String comment = rs.getString(10);
				p.setId(id);
				p.setProductName(productName);
				p.setType(type);
				p.setCreateDate(createDate);
				p.setMACAddr(macAddr);
				p.setStatus(status);
				p.setSoldDate(soldDate);
				p.setCid(cid);
				p.setCustomer(company);
				p.setPassword(password);
				p.setComment(comment);
				products.add(p);
			}	
			 ps.close();
			 c.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return products;
	}

	public List<Product> listCustomerByContact(String key) {
		// TODO Auto-generated method stub
		return null;
	}
}
