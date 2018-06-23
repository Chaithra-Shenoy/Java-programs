package com.bridgelabz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * purpose Insert data into database using batch processing.
 * @author Chaithra-Shenoy
 * @version 1.0
 * @since 17-05-2018
 */
public class BatchInsert 
{
	public static void main(String[] args) 
	{
		Connection con = null;
		Statement stmt = null;
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			con.setAutoCommit(false);
			stmt = con.createStatement();
			stmt.addBatch("insert into bridgelabz.batch values(1,'karan','ec')");
			stmt.addBatch("insert into bridgelabz.batch values(2,'arjun','cs')");
			stmt.addBatch("insert into bridgelabz.batch values(3,'ramesh','cv')");
			stmt.addBatch("insert into bridgelabz.batch values(4,'suresh','me')");
			stmt.executeBatch();
			con.commit();
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		} 
		finally
		{
			if (stmt != null) 
			{
				try 
				{
					stmt.close();
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
			if(con!=null) 
			{
				try 
				{
					con.close();
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
}
