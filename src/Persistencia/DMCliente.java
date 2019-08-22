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
//            	System.out.println("Pessoa F�sica existente !" );
//                System.out.println("Pessoa F�sica");
//                System.out.println("Cpf.............: "+ result.getString("cpf"));
//                System.out.println("Nome...............: "+ result.getString("nome"));
//                System.out.println("Data de Nascimento.: "+ result.getString("dataNascimento"));
                result.close();
            }
            else
            {   
//            	System.out.println( "Pessoa F�sica n�o encontrada !\n" );
                objCli = null;
            }
            statement.close();
        }
        catch (SQLException e)
        { 
        	System.out.println("Problemas com o SQL de consulta de Cliente!"); 
        }
		return objCli;
	}

	public void excluir(Object obj) {
		
	}

	public void alterar(Object obj) {
		
	}

}
