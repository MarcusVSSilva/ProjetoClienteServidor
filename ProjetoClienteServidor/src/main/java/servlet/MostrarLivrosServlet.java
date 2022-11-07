package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

//import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MostrarLivrosServlet
 */
@WebServlet("/MostrarLivrosServlet")
public class MostrarLivrosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	
       
    public MostrarLivrosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		PrintWriter out = response.getWriter();
		//String categoria = request.getParameter("categoria");		
	
		LivroDao dao = new LivroDao();
				
		List<Livro> livros = dao.getLista();
				
		for(Livro livro : livros) {
			out.println("Código: " + livro.getCodlivro());
			out.println("Titulo: " + livro.getTitulo());
			out.println("Autor: " + livro.getAutor());
			out.println("Categoria: " + livro.getCategoria());
			out.println("Valor R$: " + livro.getValor());
			out.println("\n");
		}
	}

}
