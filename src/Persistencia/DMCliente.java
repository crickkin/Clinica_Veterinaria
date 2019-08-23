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
            	JOptionPane.showMessageDialog(null,"Cliente cadastrado com sucesso!","Sucesso",JOptionPane.INFORMATION_MESSAGE);
            } else {   
            	JOptionPane.showMessageDialog(null,"Erro ao cadastrar Cliente!","Erro",JOptionPane.ERROR_MESSAGE);
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
            	String info = "Cliente " + result.getString("id_cliente") + 
            				"\nNome: " + result.getString("nome") +
            				"\nCPF: " + result.getString("cpf") +
            				"\nTelefone: " + result.getString("telefone") +
            				"\nEmail: " + result.getString("email");
//            	JOptionPane.showMessageDialog(null, info, "Cliente encontrado", JOptionPane.INFORMATION_MESSAGE);
                result.close();
            } else {   
//            	JOptionPane.showMessageDialog(null, "N�o h� clientes com esse n�mero de CPF.", "Cliente n�o encontrado", JOptionPane.ERROR_MESSAGE);
                objCli = null;
            }
            statement.close();
        }
        catch (SQLException e) { 
        	System.out.println("Problemas com o SQL de consulta de Cliente!"); 
        }
		return objCli;
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
            	id = result.getInt("id_animal");
            	result.close();
            } else {   
            	id = 0;
            }
            statement.close();
        }
        catch (SQLException e) { 
        	System.out.println("Problemas com o SQL de consulta de Cliente!"); 
        }
		return id;
	}

	public void excluir(Object obj) {
		
	}

	public void alterar(Object obj) {
		
	}

}
