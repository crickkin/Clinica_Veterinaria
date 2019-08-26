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
			String incluirSQL = "INSERT INTO animal (nome, raca, especie, sexo, id_cliente)"
  					+ " VALUES ('" +
                      objAni.getNome() + "', '" +
                      objAni.getRaca() + "', '" +
                      objAni.getEspecie() + "', '" +
                      objAni.getSexo() + "', '" +
                      "')";
            System.out.println("Enviando codigo SQL: " + getConnection().nativeSQL(incluirSQL) + "\n");
            int result = statement.executeUpdate(incluirSQL);
            if (result == 1) {   
            	JOptionPane.showMessageDialog(null,"Animal cadastrado com sucesso!","Sucesso",JOptionPane.INFORMATION_MESSAGE);
            } else {   
            	JOptionPane.showMessageDialog(null,"Erro ao cadastrar Animal!","Erro",JOptionPane.ERROR_MESSAGE);
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
		try {   
			Statement statement = getConnection().createStatement();
            String consultarSQL = "SELECT * FROM animal WHERE (nome = '"+objAni.getNome()+"' AND id_cliente = '"+/*ID_CLIENTE+*/"')";
            System.out.println("Enviando codigo SQL: " + getConnection().nativeSQL(consultarSQL));
            ResultSet result = statement.executeQuery(consultarSQL);
            if (result.next()) {
            	String info = "Animal " + result.getString("id_animal") + 
            				"\nNome: " + result.getString("nome") +
            				"\nRaca: " + result.getString("raca") +
            				"\nEspecie: " + result.getString("especie") +
            				"\nSexo: " + result.getString("sexo");
            	
            	JOptionPane.showMessageDialog(null, info, "Animal encontrado", JOptionPane.INFORMATION_MESSAGE);
                result.close();
            } else {   
            	JOptionPane.showMessageDialog(null, "N�o h� animais com esse n�mero de CPF.", "Animal n�o encontrado", JOptionPane.ERROR_MESSAGE);
                objAni = null;
            }
            statement.close();
        }
        catch (SQLException e) { 
        	System.out.println("Problemas com o SQL de consulta de Animal!"); 
        }
		return objAni;
	}

	public void excluir(Object obj) {
		
	}

	public void alterar(Object obj) {
		
	}

}
