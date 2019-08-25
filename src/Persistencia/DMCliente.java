package Persistencia;

import Modelo.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class DMCliente extends DMGeral {
	public void incluir(Object obj) {
		Cliente objCli = (Cliente) obj;
		try {   
			Statement statement = getConnection().createStatement();
            String incluirSQL = "INSERT INTO cliente (nome, cpf, telefone, email)"
            					+ " VALUES ('" +
                                objCli.getNome() + "', '" +
                                objCli.getCpf() + "', '" +
                                objCli.getTelefone() + "', '" +
                                objCli.getEmail() + "')";
            System.out.println("Enviando codigo SQL: " + getConnection().nativeSQL(incluirSQL) + "\n");
            int result = statement.executeUpdate(incluirSQL);
            if (result == 1) {   
//            	JOptionPane.showMessageDialog(null,"Cliente cadastrado com sucesso!","Sucesso",JOptionPane.INFORMATION_MESSAGE);
            	System.out.println("\nCliente cadastrado com sucesso!");
            } else {   
//            	JOptionPane.showMessageDialog(null,"Erro ao cadastrar Cliente!","Erro",JOptionPane.ERROR_MESSAGE);
            	System.out.println("\nErro ao cadastrar cliente!");
            	objCli.setNome("");
                objCli.setCpf("");
                objCli.setTelefone("");
                objCli.setEmail("");
            }
            statement.close();
        }
        catch (SQLException e) { 
        	System.out.println("Problemas com o SQL de inclusao de Cliente!"); 
        }
    }

	public Object consultar(Object obj) {
		Cliente objCli = (Cliente) obj;
		try {   
			Statement statement = getConnection().createStatement();
            String consultarSQL = "SELECT * FROM cliente WHERE (cpf = '"+objCli.getCpf()+"')";
            System.out.println("Enviando codigo SQL: " + getConnection().nativeSQL(consultarSQL));
            ResultSet result = statement.executeQuery(consultarSQL);
            if (result.next()) {
            	System.out.println("\nCliente encontrado!");
                result.close();
            } else {   
            	System.out.println("\nCliente nao encontrado!");
                objCli = null;
            }
            statement.close();
        }
        catch (SQLException e) { 
        	System.out.println("Problemas com o SQL de consulta de Cliente!"); 
        }
		return objCli;
	}
	
	public String buscar(String cpf) {
		String info = "";
		try {   
			Statement statement = getConnection().createStatement();
            String consultarSQL = "SELECT * FROM cliente WHERE (cpf = '"+cpf+"')";
            System.out.println("Enviando codigo SQL: " + getConnection().nativeSQL(consultarSQL));
            ResultSet result = statement.executeQuery(consultarSQL);
            if (result.next()) {
            	info = "Cliente " + result.getString("id_cliente") + 
            				"\nNome: " + result.getString("nome") +
            				"\nCPF: " + result.getString("cpf") +
            				"\nTelefone: " + result.getString("telefone") +
            				"\nEmail: " + result.getString("email");
            	System.out.println("\nCliente encontrado!");
                result.close();
            } else {   
            	System.out.println("\nCliente nao encontrado!");
            }
            statement.close();
        }
        catch (SQLException e) { 
        	System.out.println("Problemas com o SQL de consulta de Cliente!"); 
        }
		return info;
	}
	
	public int temAnimal(Object obj) {
		Cliente objCli = (Cliente) obj;
		int id;
		try {   
			Statement statement = getConnection().createStatement();
			String consultarSQL = "SELECT * FROM cliente, animal WHERE (cpf = '"+objCli.getCpf()+"' and cliente.id_cliente=animal.id_cliente)";
            System.out.println("Enviando codigo SQL: " + getConnection().nativeSQL(consultarSQL));
            ResultSet result = statement.executeQuery(consultarSQL);
            if (result.next()) {
            	System.out.println("\nCliente tem animal cadastrado");
            	id = result.getInt("id_animal");
            	result.close();
            } else {  
            	System.out.println("\nCliente nao tem animal cadastrado");
            	id = 0;
            	objCli = null;
            }
            statement.close();
        }
        catch (SQLException e) { 
        	System.out.println("Problemas com o SQL de consulta de Cliente!"); 
        	id = 0;
        }
		return id;
	}

	public void excluir(Object obj) {
		Cliente objCli = (Cliente) obj;
        try
        {   
        	Statement statement = getConnection().createStatement();
            String excluirSQL = "DELETE FROM cliente WHERE (cpf = '"+objCli.getCpf()+"')";
            System.out.println("Enviando c�digo SQL: " + getConnection().nativeSQL(excluirSQL) + "\n");
            int result = statement.executeUpdate(excluirSQL);
            if (result == 1)
            {   
            	System.out.println("\nCliente excluido com sucesso");
            }
            else
            {   
            	System.out.println("\nErro ao excluir cliente");
                objCli = null;
            }
           statement.close();
        }
        catch (SQLException e)
        { 
        	System.out.println("Problemas com o SQL de exclus�o do cliente !"); 
        }
	}

	public void alterar(Object obj) {
		Cliente objCli = (Cliente) obj;
        try
        {   
        	Statement statement = getConnection().createStatement();
            String alterarSQL = "UPDATE clientes SET cpf = '"+objCli.getCpf()+"' ,"+
                                "nome = '"+objCli.getNome()+"' ,"+
                                "telefone = '"+objCli.getTelefone()+"'"+
                                "email = '"+objCli.getEmail()+"'"+
                                "WHERE (cpf = '"+objCli.getCpf()+"')";
            int result = statement.executeUpdate(alterarSQL);
            if (result == 1)
            { 
            	System.out.println( "\nCliente alterado com sucesso!"); 
            }
            else
            {   
            	System.out.println( "\nErro ao alterar cliente !\n" );
                objCli = null;
            }
        }
        catch (SQLException e)
        { 
        	System.out.println("Problemas com o SQL de atualiza��o do cliente !"); 
        }
	}
	
	public void shutDown()
    {   try
        { 
    		getConnection().close(); 
    	}
        catch (SQLException sqlex)
        {   
        	System.err.println("Problemas ao desconectar !");
            sqlex.printStackTrace();
        }
    }

}
