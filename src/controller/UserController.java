package controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import database.Connect;
import model.User;

public class UserController {
	Connect connect = Connect.getInstance();
			
	public void register(String email, String name, String password, String role) {
		String query = "INSERT INTO users "
				+ "VALUES ('0', '" + name + "', '" + email + "', '" + password + "', '" + role + "')";
		connect.execUpdate(query);
	}
	
	public boolean login(String email, String password) {
        String query = "SELECT * FROM users WHERE user_email = '" + email + "' AND user_password = '" + password + "'";
        ResultSet rs = connect.execQuery(query);
        try {
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
	
	public User getUserByEmail(String email) {
		 String query = "SELECT * FROM users WHERE user_email = '" + email + "'";
		 ResultSet rs = connect.execQuery(query);
		 try {
			if (rs.next()) {
				 return new User(
					 rs.getString("user_id"),
					 rs.getString("user_name"),
					 rs.getString("user_email"),
					 rs.getString("user_password"),
					 rs.getString("user_role")
				 );
			 }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
    }
	
	public User getUserByUsername(String name) {
		String query = "SELECT * FROM users WHERE user_name = '" + name + "'";
		 ResultSet rs = connect.execQuery(query);
		 try {
			if (rs.next()) {
				 return new User(
					 rs.getString("user_id"),
					 rs.getString("user_name"),
					 rs.getString("user_email"),
					 rs.getString("user_password"),
					 rs.getString("user_role")
				 );
			 }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String checkRegisterInput(String email, String name, String password) {
        if (email.isEmpty() || name.isEmpty() || password.isEmpty()) {
            return "Fields cannot be empty.";
        }
        if (password.length() < 5) {
            return "Password must be at least 5 characters.";
        }
        if (getUserByEmail(email) != null) {
            return "Email is already registered.";
        }
        if (getUserByUsername(name) != null) {
            return "Username is already taken.";
        }
        return "";
    }
	
}
