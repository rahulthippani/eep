package model;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CreateEmp {

	public String execute(Emp ep) {
  
		try {
			Connection connection = Connectionprovider.getConnection();
			PreparedStatement stmt = connection
					.prepareStatement("INSERT INTO employee(name, position,gender,email) VALUES(?, ?, ?, ? ) Returning id");
			stmt.setString(1, ep.getName());
			stmt.setString(2, ep.getPosition());
			stmt.setString(3, ep.getGender());
			stmt.setString(4, ep.getEmail());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				return rs.getString("id");
			}

		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "-1";
	}
	public staic void main(String args[])
	{
		CreateEmp demo=new CreateEmp();
	}
	
	
}
