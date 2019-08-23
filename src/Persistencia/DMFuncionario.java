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
                                objFun.getDtNascimento() + "', '" +
                                objFun.getGenero() + "', '" +
                                objFun.getSalario() + "', '" +
                                objFun.getDtContratacao() + "')";
            System.out.println("Enviando codigo SQL: " + getConnection().nativeSQL(incluirSQL) + "\n");
            int result = statement.executeUpdate(incluirSQL);
            if (result == 1) {   
            	JOptionPane.showMessageDialog(null,"Funcionario cadastrado com sucesso!","Sucesso",JOptionPane.INFORMATION_MESSAGE);
            } else {   
            	JOptionPane.showMessageDialog(null,"Erro ao cadastrar Funcionario!","Erro",JOptionPane.ERROR_MESSAGE);
            	objFun.setNome("");
                objFun.setCpf("");
                objFun.setCtps("");
                objFun.setDtNascimento("");
                objFun.setGenero(' ');
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
            	String info = "Funcionario " + result.getString("id_func") + 
            				"\nNome: " + result.getString("nome") +
            				"\nCPF: " + result.getString("cpf") +
            				"\nCTPS: " + result.getString("ctps") +
            				"\nRG: " + result.getString("rg") + 
            				"\nData de nascimento: " + result.getString("dtNasc") +
            				"\nGenero: " + result.getString("genero") +
            				"\nSalario: " + result.getString("salario") +
            				"\nData de contratacao: " + result.getString("dtContratacao");
            	
            	JOptionPane.showMessageDialog(null, info, "Funcionario encontrado", JOptionPane.INFORMATION_MESSAGE);
                result.close();
            } else {   
            	JOptionPane.showMessageDialog(null, "Não há Funcionarios com esse número de CPF.", "Funcionario não encontrado", JOptionPane.ERROR_MESSAGE);
                objFun = null;
            }
            statement.close();
        }
        catch (SQLException e) { 
        	System.out.println("Problemas com o SQL de consulta de Funcionario!"); 
        }
		return objFun;
	}

	public void excluir(Object obj) {
		
	}

	public void alterar(Object obj) {
		
	}

}
