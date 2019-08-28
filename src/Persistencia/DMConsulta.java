package Persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Modelo.Consulta;

public class DMConsulta extends DMGeral
{
	public void incluir(Object obj) {
		Consulta objCon = (Consulta) obj;
		try {   
			Statement statement = getConnection().createStatement();
            String incluirSQL = "INSERT INTO cliente (data, hora, sintomas, diagnostico, id_funcionario, id_animal)"
            					+ " VALUES ('" +
                                objCon.getData() + "', '" +
                                objCon.getHora() + "', '" +
                                objCon.getSintomas() + "', '" +
                                objCon.getDiagnostico() + "', '"+
                                objCon.getVeterinario().getIdFunc() + "', '"+
                                objCon.getAnimal().getIdAnimal() + "')";
            System.out.println("Enviando codigo SQL: " + getConnection().nativeSQL(incluirSQL) + "\n");
            int result = statement.executeUpdate(incluirSQL);
            if (result == 1) {   
            	System.out.println("\nConsulta marcada com sucesso!");
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
		Consulta objCli = (Consulta) obj;
		try {   
			Statement statement = getConnection().createStatement();
            String consultarSQL = "SELECT * FROM cliente WHERE (cpf = '"+objCli.getCpf()+"')";
            System.out.println("Enviando código SQL: " + getConnection().nativeSQL(consultarSQL));
            ResultSet result = statement.executeQuery(consultarSQL);
            if (result.next()) {
            	System.out.println("\nCliente encontrado!");
            	/*objCli.setIdCliente(result.getInt("id_cliente"));
            	objCli.setNome(result.getString("nome"));
            	objCli.setCpf(result.getString("cpf"));
            	objCli.setTelefone(result.getString("telefone"));
            	objCli.setEmail(result.getString("email"));*/
                result.close();
            } else {   
            	System.out.println("\nCliente não encontrado!");
                objCli = null;
            }
            statement.close();
        }
        catch (SQLException e) { 
        	System.out.println("Problemas com o SQL de consulta de Cliente!"); 
        }
		return objCli;
	}
	
//	public String buscar(Object obj) {
//		Cliente objCli = (Cliente) obj;
//		String info = "";
//		try {   
//			Statement statement = getConnection().createStatement();
//            String consultarSQL = "SELECT * FROM cliente WHERE (cpf = '"+objCli.getCpf()+"')";
//            System.out.println("Enviando codigo SQL: " + getConnection().nativeSQL(consultarSQL));
//            ResultSet result = statement.executeQuery(consultarSQL);
//            if (result.next()) {
//            	info = "Cliente " + result.getString("id_cliente") + 
//            				"\nNome: " + result.getString("nome") +
//            				"\nCPF: " + result.getString("cpf") +
//            				"\nTelefone: " + result.getString("telefone") +
//            				"\nEmail: " + result.getString("email");
//            	System.out.println("\nCliente encontrado!");
//                result.close();
//            } else {   
//            	System.out.println("\nCliente nao encontrado!");
//            }
//            statement.close();
//        }
//        catch (SQLException e) { 
//        	System.out.println("Problemas com o SQL de consulta de Cliente!"); 
//        }
//		return info;
//	}
	
	public int temAnimal(Object obj) {
		/*Consulta objCli = (Consulta) obj;
		int id;
		try {   
			Statement statement = getConnection().createStatement();
			String consultarSQL = "SELECT * FROM cliente, animal WHERE (cpf = '"+objCli.getCpf()+"' and cliente.id_cliente=animal.id_cliente)";
            System.out.println("Enviando código SQL: " + getConnection().nativeSQL(consultarSQL));
            ResultSet result = statement.executeQuery(consultarSQL);
            if (result.next()) {
            	System.out.println("\nCliente tem animal cadastrado");
            	id = result.getInt("id_animal");
            	result.close();
            } else {  
            	System.out.println("\nCliente não tem animal cadastrado");
            	id = 0;
            	objCli = null;
            }
            statement.close();
        }
        catch (SQLException e) { 
        	System.out.println("Problemas com o SQL de consulta de Cliente!"); 
        	id = 0;
        }
		return id;*/
	}

	public void excluir(Object obj) {
		/*Cliente objCli = (Cliente) obj;
        try
        {   
        	Statement statement = getConnection().createStatement();
            String excluirSQL = "DELETE FROM cliente WHERE (cpf = '"+objCli.getCpf()+"')";
            System.out.println("Enviando código SQL: " + getConnection().nativeSQL(excluirSQL) + "\n");
            int result = statement.executeUpdate(excluirSQL);
            if (result == 1)
            {   
            	System.out.println("\nCliente excluído com sucesso");
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
        	System.out.println("Problemas com o SQL de exclusão do cliente !"); 
        }*/
	}

	public void alterar(Object obj) {
//		Cliente objCli = (Cliente) obj;
//        try
//        {   
//        	System.out.println(objCli.getNome());
//        	Statement statement = getConnection().createStatement();
//            String alterarSQL = "UPDATE clientes SET cpf = '"+objCli.getCpf()+"' ,"+
//                                "nome = '"+objCli.getNome()+"' ,"+
//                                "telefone = '"+objCli.getTelefone()+"'"+
//                                "email = '"+objCli.getEmail()+"'"+
//                                "WHERE (cpf = '"+objCli.getCpf()+"')";
//            System.out.println("Enviando cï¿½digo SQL: " + getConnection().nativeSQL(alterarSQL) + "\n");
//            int result = statement.executeUpdate(alterarSQL);
//            if (result == 1)
//            { 
//            	System.out.println( "\nCliente alterado com sucesso!"); 
//            }
//            else
//            {   
//            	System.out.println( "\nErro ao alterar cliente !\n" );
//                objCli = null;
//            }
//        }
//        catch (SQLException e)
//        { 
//        	System.out.println("Problemas com o SQL de atualizaï¿½ï¿½o do cliente !"); 
//        }
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
