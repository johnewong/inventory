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

import inventory.DateUtil;

public class ItemDAO {

	public ItemDAO() {
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
	
	public void add(Item item) {
		
		String sql = "insert into item values(null,?,?,?,?,?,?,?,?)";
		try(Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
			
			ps.setString(1, item.getName());
			ps.setString(2, item.getDesc());
			ps.setString(3, item.getCategory());
			ps.setString(4, item.getStatus());
			ps.setInt(5, item.getSafetyStock());
			ps.setInt(6, item.getStock());
			ps.setInt(7, item.getPrice());
			ps.setTimestamp(8, DateUtil.d2t(item.getCreateDate()));
			ps.execute();
			ResultSet rs = ps.getGeneratedKeys();
			while(rs.next()) {
				int id = rs.getInt(1);
				item.setId(id);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void update(Item item) {
		String sql = "update item set name = ?, description = ?, category = ?, status = ?, safetyStock = ?, stock = ?, price = ? where id = ?";
		try(Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
			
			ps.setString(1, item.getName());
			ps.setString(2, item.getDesc());
			ps.setString(3, item.getCategory());
			ps.setString(4, item.getStatus());
			ps.setInt(5, item.getSafetyStock());
			ps.setInt(6, item.getStock());
			ps.setInt(7, item.getPrice());
			ps.setInt(8, item.getId());
			ps.execute();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(int id) {
		try(Connection c = getConnection(); Statement s = c.createStatement()) {
			String sql = "delete from item where id = " + id;
			s.execute(sql);
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Item get(int id) {
		
		Item i = null;
		try(Connection c = getConnection(); Statement s = c.createStatement()) {
			
			String sql = "select * from item where id = " + id;
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				i = new Item();
				i.setId(id);
				i.setName(rs.getString(2));
				i.setDesc(rs.getString(3));
				i.setCategory(rs.getString(4));
				i.setStatus(rs.getString(5));
				i.setSafetyStock(rs.getInt(6));
				i.setStock(rs.getInt(7));
				i.setPrice(rs.getInt(8));
				i.setCreateDate(DateUtil.t2d(rs.getTimestamp(9)));
			}
	
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	
	public List<Item> list() {
		return list(0, Short.MAX_VALUE);
	}
	
	public List<Item> list(int start, int count) {
		
		String sql = "select * from item order by id desc limit ?, ?";
		List<Item> itemList = new ArrayList<>();
		try(Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
			
			ps.setInt(1, start);
			ps.setInt(2, count);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Item i = new Item();
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String desc = rs.getString(3);
				String cate = rs.getString(4);
				String status = rs.getString(5);
				int safetyStock = rs.getInt(6);
				int stock = rs.getInt(7);
				int price = rs.getInt(8);
				Date createDate = DateUtil.t2d(rs.getTimestamp(9));
				i.setId(id);
				i.setName(name);
				i.setDesc(desc);
				i.setCategory(cate);
				i.setStatus(status);
				i.setSafetyStock(safetyStock);
				i.setStock(stock);
				i.setPrice(price);
				i.setCreateDate(createDate);
				itemList.add(i);
			}
				ps.close();
				c.close();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return itemList;
	}
	
	
}
