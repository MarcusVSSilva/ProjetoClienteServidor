package servlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class LivroDao {

	private Connection connection;
	
	public LivroDao() {
			this.connection = new ConnectionFactory().getConnection();
	}
	
	//método para cadastrar novos livros
	public void adicionar(Livro livro) {
		String sql = "insert into tblivros " + "values(?,?,?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			//setar os valores
			stmt.setInt(1, livro.getCodlivro());
			stmt.setString(2, livro.getTitulo());
			stmt.setString(3, livro.getAutor());
			stmt.setString(4, livro.getCategoria());
			stmt.setFloat(5, livro.getValor());
			stmt.execute();
			stmt.close();	
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	//método para alterar livros
	public void alterar(Livro livro) {
		String sq = "update tblivros set titulo=?, autor=?, categoria=?, valor=? where codlivro=?";
		try {
			PreparedStatement stm = connection.prepareStatement(sq);
			stm.setString(1, livro.getTitulo());
			stm.setString(2, livro.getAutor());
			stm.setString(3, livro.getCategoria());
			stm.setFloat(4, livro.getValor());
			stm.setInt(5, livro.getCodlivro());
			
			stm.execute();
			stm.close();
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	//método para deletar
	public void remover(Livro livro) {
		String sl= "delete from tblivros where codlivro=?";
		try {
			PreparedStatement st = connection.prepareStatement(sl);
			st.setInt(1, livro.getCodlivro());
			st.execute();
			st.close();
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
		
	}
	
	
	//lista dos livros cadastrados 
	public List<Livro> getLista() {
		try {
			List<Livro> livros = new ArrayList<Livro>();
			PreparedStatement stamt = connection.prepareStatement("select * from tblivros");
			ResultSet rs = stamt.executeQuery();
			while (rs.next()) {
				Livro livro = new Livro();
				livro.setCodlivro(rs.getInt("codlivro"));
				livro.setTitulo(rs.getString("titulo"));
				livro.setAutor(rs.getString("autor"));
				livro.setCategoria(rs.getString("categoria"));
				livro.setValor(rs.getFloat("valor"));
				
				livros.add(livro);
				
			}
			rs.close();
			stamt.close();
			return livros;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
}

