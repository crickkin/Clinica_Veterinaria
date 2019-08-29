package Persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import Modelo.Animal;
import Modelo.Consulta;
import Modelo.Funcionario;

public class DMCirurgia extends DMGeral
{
	public void incluir(Object obj) {
		Consulta objCon = (Consulta) obj;
		try {   
			Statement statement = getConnection().createStatement();
            String incluirSQL = "INSERT INTO consulta (data, hora, sintomas, diagnostico, id_funcionario, id_animal)"
            					+ " VALUES ('" +
                                objCon.getData() + "', '" +
                                objCon.getHora() + "', '" +
                                objCon.getSintomas() + "', '" +
                                objCon.getDiagnostico() + "', "+
                                objCon.getVeterinario().getIdFunc() + ", "+
                                objCon.getAnimal().getIdAnimal() + ")";
            System.out.println("Enviando codigo SQL: " + getConnection().nativeSQL(incluirSQL) + "\n");
            int result = statement.executeUpdate(incluirSQL);
            if (result == 1) {   
            	System.out.println("\nConsulta marcada com sucesso!");
            	JOptionPane.showMessageDialog(null, "Consulta marcada com sucesso!");
            } else {   
            	System.out.println("\nErro ao marcar consulta!");
            	objCon.setData("");
                objCon.setHora("");
                objCon.setSintomas("");
                objCon.setDiagnostico("");
                objCon.setVeterinario(null);
                objCon.setAnimal(null);
            }
            statement.close();
        }
        catch (SQLException e) { 
        	System.out.println("Problemas com o SQL de inclusão de Consulta!"); 
        }
    }

	public Object consultar(Object obj) {
		Consulta objCon = (Consulta) obj;
		try {   
			Statement statement = getConnection().createStatement();
            String consultarSQL = "SELECT * FROM consulta WHERE (data = '"+objCon.getData()+"' AND hora = '"+objCon.getHora()+"')";
            System.out.println("Enviando código SQL: " + getConnection().nativeSQL(consultarSQL));
            ResultSet result = statement.executeQuery(consultarSQL);
            if (result.next()) {
            	System.out.println("\nConsulta encontrado!");
            	objCon.setIdConsulta(result.getInt("id_consulta"));
            	objCon.setData(result.getString("data"));
            	objCon.setHora(result.getString("hora"));
            	objCon.setSintomas(result.getString("sintomas"));
            	objCon.setDiagnostico(result.getString("diagnostico"));
            	objCon.setAnimal(new Animal(result.getInt("id_animal")).findById());
            	objCon.setVeterinario(new Funcionario(result.getInt("id_funcionario")).findById());
                result.close();
            } else {   
            	System.out.println("\nConsulta não encontrado!");
                objCon = null;
            }
            statement.close();
        }
        catch (SQLException e) { 
        	System.out.println("Problemas com o SQL de consulta de Cliente!"); 
        }
		return objCon;
	}

	public void excluir(Object obj) {
		Consulta objCon = (Consulta) obj;
        try
        {   
        	Statement statement = getConnection().createStatement();
            String excluirSQL = "DELETE FROM consulta WHERE (data = '"+objCon.getData()+"'AND hora = '"+objCon.getHora()+"')";
            System.out.println("Enviando código SQL: " + getConnection().nativeSQL(excluirSQL) + "\n");
            int result = statement.executeUpdate(excluirSQL);
            if (result == 1)
            {   
            	System.out.println("\nConsulta excluído com sucesso");
            }
            else
            {   
            	System.out.println("\nErro ao excluir consulta");
                objCon = null;
            }
           statement.close();
        }
        catch (SQLException e)
        { 
        	System.out.println("Problemas com o SQL de exclusão do consulta !"); 
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

	public void alterar(Object obj) {
		// TODO Auto-generated method stub
	}
}
