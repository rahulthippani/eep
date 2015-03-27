package model;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class ListEmp {

	public ArrayList<Emp> execute() {
		ArrayList<Emp> ret = new ArrayList<Emp>();
		try {
			Connection connection = Connectionprovider.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM employee");
			while (rs.next()) {
				Emp e = new Emp();
				e.setId(rs.getInt("id"));
				e.setName(rs.getString("name"));
				e.setPosition(rs.getString("pos"));
				e.setGender(rs.getString("gender"));
				e.setEmail(rs.getString("email"));
				ret.add(e);
			}
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}
	public static void main(String args[])
	{
		ListEmp list=new ListEmp();
		list.execute();
	}
}