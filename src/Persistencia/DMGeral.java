package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DMGeral {
	protected static Connection connection;

	public static Connection getConnection() {	
		return connection;	
	}

	public void conectaDataBase(String dataBase, String userName, String password) {	
		String url = "jdbc:mysql://localhost/"+dataBase+"?serverTimezone=UTC";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		   	connection = DriverManager.getConnection(url,userName,password);
			System.out.println("Conexao ao banco de dados feita com sucesso!");
		} 
		catch (ClassNotFoundException cnfex) {	
			System.err.println("Falha ao abrir o driver JDBC/ODBC");
			cnfex.printStackTrace();
			System.exit(1);
		}
		catch (SQLException sqlex) {	
			System.err.println("Impossivel conectar");
			sqlex.printStackTrace();
		}
	}
	
	public void shutDown() {	
		try {	
			connection.close();	
		}
		catch (SQLException sqlex) {	
			System.err.println("Impossivel desconectar");
		  	sqlex.printStackTrace();
		}
	}

	public abstract void incluir(Object obj); 
	public abstract Object consultar(Object obj);
	public abstract void excluir(Object obj);
	public abstract void alterar(Object obj);
}