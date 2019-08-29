package Persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import Modelo.Animal;
import Modelo.Cirurgia;
import Modelo.Funcionario;

public class DMCirurgia extends DMGeral
{
	public void incluir(Object obj) {
		Cirurgia objCir = (Cirurgia) obj;
		try {   
			Statement statement = getConnection().createStatement();
            String incluirSQL = "INSERT INTO cirurgia (data, hora, grau_urgencia, situacao, duracao, id_funcionario, id_animal)"
            					+ " VALUES ('" +
                                objCir.getData() + "', '" +
                                objCir.getHora() + "', '" +
                                objCir.getUrgencia() + "', '" +
                                objCir.getSituacao() + "', "+
                                objCir.getDuracao() + ", "+
                                objCir.getVeterinario().getIdFunc() + ", "+
                                objCir.getAnimal().getIdAnimal() + ")";
            System.out.println("Enviando codigo SQL: " + getConnection().nativeSQL(incluirSQL) + "\n");
            int result = statement.executeUpdate(incluirSQL);
            if (result == 1) {   
            	System.out.println("\nCirurgia marcada com sucesso!");
            	JOptionPane.showMessageDialog(null, "Cirurgia marcada com sucesso!");
            } else {   
            	System.out.println("\nErro ao marcar cirurgia!");
            	objCir.setData("");
                objCir.setHora("");
                objCir.setUrgencia(0);
                objCir.setSituacao("");
                objCir.setDuracao(0);
                objCir.setVeterinario(null);
                objCir.setAnimal(null);
            }
            statement.close();
        }
        catch (SQLException e) { 
        	System.out.println("Problemas com o SQL de inclusão de Cirurgia!"); 
        }
    }

	public Object consultar(Object obj) {
		Cirurgia objCir = (Cirurgia) obj;
		try {   
			Statement statement = getConnection().createStatement();
            String CirurgiarSQL = "SELECT * FROM Cirurgia WHERE (data = '"+objCir.getData()+"' AND hora = '"+objCir.getHora()+"')";
            System.out.println("Enviando código SQL: " + getConnection().nativeSQL(CirurgiarSQL));
            ResultSet result = statement.executeQuery(CirurgiarSQL);
            if (result.next()) {
            	System.out.println("\nCirurgia encontrado!");
            	objCir.setIdCirurgia(result.getInt("id_Cirurgia"));
            	objCir.setData(result.getString("data"));
            	objCir.setHora(result.getString("hora"));
            	objCir.setUrgencia(result.getInt("grau_urgencia"));
            	objCir.setSituacao(result.getString("situacao"));
            	objCir.setDuracao(result.getInt("duracao"));
            	objCir.setAnimal(new Animal(result.getInt("id_animal")).findById());
            	objCir.setVeterinario(new Funcionario(result.getInt("id_funcionario")).findById());
                result.close();
            } else {   
            	System.out.println("\nCirurgia não encontrado!");
                objCir = null;
            }
            statement.close();
        }
        catch (SQLException e) { 
        	System.out.println("Problemas com o SQL de Cirurgia de Cliente!"); 
        }
		return objCir;
	}

	public void excluir(Object obj) {
		Cirurgia objCir = (Cirurgia) obj;
        try
        {   
        	Statement statement = getConnection().createStatement();
            String excluirSQL = "DELETE FROM Cirurgia WHERE (data = '"+objCir.getData()+"'AND hora = '"+objCir.getHora()+"')";
            System.out.println("Enviando código SQL: " + getConnection().nativeSQL(excluirSQL) + "\n");
            int result = statement.executeUpdate(excluirSQL);
            if (result == 1)
            {   
            	System.out.println("\nCirurgia excluído com sucesso");
            }
            else
            {   
            	System.out.println("\nErro ao excluir Cirurgia");
                objCir = null;
            }
           statement.close();
        }
        catch (SQLException e)
        { 
        	System.out.println("Problemas com o SQL de exclusão do Cirurgia !"); 
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
