package com.nit;

import org.slf4j.Logger;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.slf4j.LoggerFactory;



public class SelectTest {
	private static final String GET_QUERY = "select empno,ename,job,sal,deptno from emp";
	private static Logger logger = LoggerFactory.getLogger(SelectTest.class);
	private static Properties props;
	static {
		//loads properties file
		try(FileInputStream fis = new FileInputStream("log4j.properties");) {
			logger.info("Properties file is loaded");
			//write properties file content to java.util.Properties class obj
			props = new Properties();
			props.load(fis);
			logger.info("properties file content to java.util.Properties class obj");
		} catch (Exception e) {
			logger.error("Problem in loading the properties file {}",e.getMessage());
		}
	}
	public static void main(String[] args) {
		logger.debug("main method started");
		try(Connection con = DriverManager.getConnection(props.getProperty("db.url"),props.getProperty("db.username"),props.getProperty("db.password"));
				
			PreparedStatement ps = con.prepareStatement(GET_QUERY);
			ResultSet rs = ps.executeQuery();
			){
			logger.info("Connection object is created");
			logger.debug("PreparedStatement object is created");
			logger.debug("ResultSet object is created");
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getDouble(4)+rs.getInt(5));
			}
			logger.warn("for Sal rs.getDouble is used rather then rs.getdouble");
			logger.debug("ResultSet Object is Processed");
			logger.trace("Connection, PreparedStatement,ResultSet object are closed automatically at the end of try with resource");
			
		}
		catch (SQLException se) {
			logger.error("Know db Problem : {}",se.getMessage());
		}
		catch (Exception e) {
			logger.error("UnKnow db Problem : {}",e.getMessage());
			e.printStackTrace();
		}
		logger.debug("End of the main()");
	}
}
