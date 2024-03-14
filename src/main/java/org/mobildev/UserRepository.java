package org.mobildev;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class UserRepository{
	
	
	public String savePerson(PersonEntity personEntity) throws ClassNotFoundException, SQLException {
		String sqlState = "";
		Connection connection = DbPersonContext.getInstance();
		System.out.println("Deneme");
		try {
			PreparedStatement statement = connection.prepareStatement("insert into person(name,lastname,email,password) values(?,?,?,?)");
			statement.setString(1, personEntity.getAd());
			statement.setString(2, personEntity.getSoyad());
			statement.setString(3, personEntity.getEmail());
			statement.setString(4, personEntity.getPassword());
			statement.execute();
			connection.close();
			sqlState= "success";
		}catch (Exception e) {
			System.err.println(e.getMessage());
			sqlState="fail";
		}finally {
			System.out.println("Finally method");
			connection.close();
		}
		return sqlState;
	}

	public List<PersonEntity> getUsers() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
		Connection connection = DbPersonContext.getInstance();
		List<PersonEntity> personEntities = new ArrayList();
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery("select id,name,lastname,email,password from person");
			while (result.next()) {
				PersonEntity personEntity = new PersonEntity(result.getString(2), result.getString(3), result.getString(4), result.getString(5));
				personEntity.setUuid(String.valueOf(result.getInt(1)));
				personEntities.add(personEntity);
			}
			result.close();
			connection.close();
			return personEntities;
		}catch (Exception e) {
			System.err.println(e.getMessage());
		}finally {
			connection.close();
		}
		return null;
	}
	
	public String deletePerson(int id) throws SQLException, ClassNotFoundException {
		String sqlState = "";
		Connection connection = DbPersonContext.getInstance();
		try {
			PreparedStatement statement = connection.prepareStatement("delete from person where id = ?");
			statement.setInt(1, id);
			if(statement.executeUpdate()>0) {
				connection.close();
				sqlState = "success";
			}
		}catch (Exception e) {
			System.err.println(e.getMessage());
			sqlState = "fail";
		}finally {
			connection.close();
		}
		return sqlState;
	}
	
	

}
