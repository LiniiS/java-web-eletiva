package br.com.asantos.gerenciador.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class BaseDao {
	private static final String USUARIO = "root";
	private static final String SENHA = "";
	private static final String URL = "jdbc:mariadb://localhost~/nomeDoBD";
	private static final String DRIVER = "org.mariadb.jdbc.Driver";
	
	private Connection conn;
	
	public Connection getConn() {
		return conn;
	}
	
	public void open() throws Exception{
		Class.forName(DRIVER);
		conn = DriverManager.getConnection(URL, USUARIO, SENHA);
	}
	
	public void close()throws Exception {
		Class.forName(DRIVER);
		this.getConn().close();
	}
	

}
