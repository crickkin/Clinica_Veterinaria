package Persistencia;

import Modelo.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class DMFuncionario extends DMGeral {
	public void incluir(Object obj) {
		Funcionario objFun = (Funcionario) obj;
		try {   
			Statement statement = getConnection().createStatement();
            String incluirSQL = "INSERT INTO funcionario (nome, cpf, ctps, rg, dtNasc, genero, salario, dtContratacao)"
            					+ " VALUES ('" +
                                objFun.getNome() + "', '" +
                                objFun.getCpf() + "', '" +
                                objFun.getCtps() + "', '" +
                                objFun.getRg() + "', '" +
                                objFun.getDtNascimento() + "', '" +
                                objFun.getGenero() + "', '" +
                                objFun.getSalario() + "', '" +
                                objFun.getDtContratacao() + "')";
            System.out.println("Enviando codigo SQL: " + getConnection().nativeSQL(incluirSQL) + "\n");
            int result = statement.executeUpdate(incluirSQL);
            if (result == 1) {   
            	System.out.println("Funcionario cadastrado com sucesso!");
            	JOptionPane.showMessageDialog(null,"Funcionario cadastrado com sucesso!","Sucesso",JOptionPane.INFORMATION_MESSAGE);
            } else {   
            	System.out.println("Erro ao cadastrar Funcionario!");
            	JOptionPane.showMessageDialog(null,"Erro ao cadastrar Funcionario!","Erro",JOptionPane.ERROR_MESSAGE);
            	objFun.setNome("");
                objFun.setCpf("");
                objFun.setCtps("");
                objFun.setRg("");
                objFun.setDtNascimento("");
                objFun.setGenero("");
                objFun.setSalario(0.0);
                objFun.setDtContratacao("");;
            }
            statement.close();
        }
        catch (SQLException e) { 
        	System.out.println("Problemas com o SQL de inclusao de Funcionario!"); 
        }
    }

	public Object consultar(Object obj) {
		Funcionario objFun = (Funcionario) obj;
		try {   
			Statement statement = getConnection().createStatement();
            String consultarSQL = "SELECT * FROM funcionario WHERE (cpf = '"+objFun.getCpf()+"')";
            System.out.println("Enviando codigo SQL: " + getConnection().nativeSQL(consultarSQL));
            ResultSet result = statement.executeQuery(consultarSQL);
            if (result.next()) {
            	System.out.println("\nFuncionário encontrado!");
            	objFun.setIdFunc(result.getInt("id_func"));
            	objFun.setNome(result.getString("nome"));
            	objFun.setCpf(result.getString("cpf"));
            	objFun.setCtps(result.getString("ctps"));
            	objFun.setRg(result.getString("rg"));
            	objFun.setDtNascimento(result.getString("dtNasc"));
            	objFun.setGenero(result.getString("genero"));
            	objFun.setSalario(result.getDouble("salario"));
            	objFun.setDtContratacao(result.getString("dtContratacao"));	
                result.close();
            } else {   
            	System.out.println("Funcionário não encontrado");
                objFun = null;
            }
            statement.close();
        }
        catch (SQLException e) { 
        	System.out.println("Problemas com o SQL de consulta de Funcionário!"); 
        }
		return objFun;
	}
	
	public Object consultaID(Object obj) {
		Funcionario objFun = (Funcionario) obj;
		try {   
			Statement statement = getConnection().createStatement();
            String consultarSQL = "SELECT * FROM funcionario WHERE (id_func = '"+objFun.getIdFunc()+"')";
            System.out.println("Enviando codigo SQL: " + getConnection().nativeSQL(consultarSQL));
            ResultSet result = statement.executeQuery(consultarSQL);
            if (result.next()) {
            	System.out.println("\nFuncionário encontrado!");
            	objFun.setIdFunc(result.getInt("id_func"));
            	objFun.setNome(result.getString("nome"));
            	objFun.setCpf(result.getString("cpf"));
            	objFun.setCtps(result.getString("ctps"));
            	objFun.setRg(result.getString("rg"));
            	objFun.setDtNascimento(result.getString("dtNasc"));
            	objFun.setGenero(result.getString("genero"));
            	objFun.setSalario(result.getDouble("salario"));
            	objFun.setDtContratacao(result.getString("dtContratacao"));	
                result.close();
            } else {   
            	System.out.println("Funcionário não encontrado");
                objFun = null;
            }
            statement.close();
        }
        catch (SQLException e) { 
        	System.out.println("Problemas com o SQL de consulta de Funcionário!"); 
        }
		return objFun;
	}

	public void excluir(Object obj) {
		Funcionario objFun = (Funcionario) obj;
        try
        {   
        	Statement statement = getConnection().createStatement();
            String excluirSQL = "DELETE FROM funcionario WHERE (cpf = '"+objFun.getCpf()+"')";
            System.out.println("Enviando código SQL: " + getConnection().nativeSQL(excluirSQL) + "\n");
            int result = statement.executeUpdate(excluirSQL);
            if (result == 1)
            {   
            	System.out.println("\nFuncionário excluído com sucesso");
            }
            else
            {   
            	System.out.println("\nErro ao excluir Funcionário");
                objFun = null;
            }
           statement.close();
        }
        catch (SQLException e)
        { 
        	System.out.println("Problemas com o SQL de exclusão do Funcionário !"); 
        }
	}

	public void alterar(Object obj) {
		
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
