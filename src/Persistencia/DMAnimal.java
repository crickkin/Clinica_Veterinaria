package Persistencia;

import Modelo.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class DMAnimal extends DMGeral {
	public void incluir(Object obj) {
		Animal objAni = (Animal) obj;
		try {   
			Statement statement = getConnection().createStatement(); 
			System.out.println();
			String incluirSQL = "INSERT INTO animal (nome, raca, especie, sexo, id_cliente)"
  					+ " VALUES ('" +
                      objAni.getNome() + "', '" +
                      objAni.getRaca() + "', '" +
                      objAni.getEspecie() + "', '" +
                      objAni.getSexo() + "', '" +
                      objAni.getProprietario().getIdCliente() + "')";
            System.out.println("Enviando codigo SQL: " + getConnection().nativeSQL(incluirSQL) + "\n");
            int result = statement.executeUpdate(incluirSQL);
            if (result == 1) {   
            	JOptionPane.showMessageDialog(null,"Animal cadastrado com sucesso!","Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } else {   
            	JOptionPane.showMessageDialog(null,"Erro ao cadastrar Animal!","Erro", JOptionPane.ERROR_MESSAGE);
            	objAni.setNome("");
                objAni.setRaca("");
                objAni.setEspecie("");
                objAni.setSexo(' ');
            }
            statement.close();
        }
        catch (SQLException e) { 
        	System.out.println("Problemas com o SQL de inclusao de Animal!"); 
        }
    }

	public Object consultar(Object obj) {
		Animal objAni = (Animal) obj;
		System.out.println(objAni.getNome());
		try {   
			Statement statement = getConnection().createStatement();
            String consultarSQL = "SELECT * FROM animal JOIN cliente ON animal.id_cliente = cliente.id_cliente WHERE (animal.nome = '"+objAni.getNome()+"' AND cliente.cpf = '"+objAni.getProprietario().getCpf()+"')";
            System.out.println("Enviando codigo SQL: " + getConnection().nativeSQL(consultarSQL));
            ResultSet result = statement.executeQuery(consultarSQL);
            if (result.next()) {
            	System.out.println("\nAnimal encontrado");
            	objAni.setIdAnimal(result.getInt("id_animal"));
            	objAni.setNome(result.getString("nome"));
            	objAni.setRaca(result.getString("raca"));
            	objAni.setEspecie(result.getString("especie"));
            	objAni.setSexo(result.getString("sexo").charAt(0));
                result.close();
            } else {   
            	System.out.println("\nAnimal não encontrado");
                objAni = null;
            }
            statement.close();
        }
        catch (SQLException e) { 
        	System.out.println("Problemas com o SQL de consulta de Animal!"); 
        }
		return objAni;
	}
	
	public Object consultaID(Object obj) {
		Animal objAni = (Animal) obj;
		System.out.println(objAni.getNome());
		try {   
			Statement statement = getConnection().createStatement();
            String consultarSQL = "SELECT * FROM animal WHERE (animal.id_animal = '"+objAni.getIdAnimal()+"')";
            System.out.println("Enviando codigo SQL: " + getConnection().nativeSQL(consultarSQL));
            ResultSet result = statement.executeQuery(consultarSQL);
            if (result.next()) {
            	System.out.println("\nAnimal encontrado");
            	objAni.setIdAnimal(result.getInt("id_animal"));
            	objAni.setNome(result.getString("nome"));
            	objAni.setRaca(result.getString("raca"));
            	objAni.setEspecie(result.getString("especie"));
            	objAni.setSexo(result.getString("sexo").charAt(0));
                result.close();
            } else {   
            	System.out.println("\nAnimal não encontrado");
                objAni = null;
            }
            statement.close();
        }
        catch (SQLException e) { 
        	System.out.println("Problemas com o SQL de consulta de Animal!"); 
        }
		return objAni;
	}

	public void excluir(Object obj)
	{
		Animal objAni = (Animal) obj;
        try
        {   
        	Statement statement = getConnection().createStatement();
            String excluirSQL = "DELETE FROM animal WHERE (animal.nome = '"+objAni.getNome()+"' AND id_animal = '"+objAni.getIdAnimal()+"')";
            System.out.println("Enviando código SQL: " + getConnection().nativeSQL(excluirSQL) + "\n");
            int result = statement.executeUpdate(excluirSQL);
            if (result == 1)
            {   
            	System.out.println("\nAnimal excluído com sucesso");
            }
            else
            {   
            	System.out.println("\nErro ao excluir animal");
                objAni = null;
            }
           statement.close();
        }
        catch (SQLException e)
        { 
        	System.out.println("Problemas com o SQL de exclusão do cliente !"); 
        }
	}

	public void alterar(Object obj) {
		
	}

}
