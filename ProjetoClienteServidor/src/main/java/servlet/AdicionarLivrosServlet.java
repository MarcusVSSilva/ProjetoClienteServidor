package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AdicionarLivrosServlet")
public class AdicionarLivrosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdicionarLivrosServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		//Quando os metódos "doPost", "doPut" e "doDelete" são descomentados, os botões não correspondem aos seus métodos, fazendo com que um botão realize as 3 ações.
		
		//Ao deixar apenas um método comentado, todos os 3 funcionarão.
		
		
		doPost(request, response);
		//doPut(request, response);
		//doDelete(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		
		PrintWriter out = response.getWriter();
		
		int codlivro = Integer.parseInt(request.getParameter("codlivro"));
		String titulo = request.getParameter("titulo");
		String autor = request.getParameter("autor");
		String categoria = request.getParameter("categoria");
		float valor = Float.parseFloat(request.getParameter("valor"));
				
		Livro livro = new Livro();
		livro.setCodlivro(codlivro);
		livro.setTitulo(titulo);
		livro.setAutor(autor);
		livro.setCategoria(categoria);
		livro.setValor(valor);
					
		try {
			LivroDao livro1 = new LivroDao();
			livro1.adicionar(livro);
					
			out.println("Livro foi adicionado");
					
		}catch(Throwable e) {
			out.println("Deu ERRO");
			e.printStackTrace();
		}
	}
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        int codlivro = Integer.parseInt(request.getParameter("codlivro")); 
        String titulo = request.getParameter("titulo");
        String autor = request.getParameter("autor");
        String categoria = request.getParameter("categoria");
        float valor = Float.parseFloat(request.getParameter("valor"));

        Livro li = new Livro();
        li.setCodlivro(codlivro);
        li.setTitulo(titulo);
        li.setAutor(autor);
        li.setCategoria(categoria);
        li.setValor(valor);

        LivroDao dao = new LivroDao();

        dao.alterar(li);
        out.println("Alterado!");
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
        PrintWriter out = response.getWriter();
        int codlivro = Integer.parseInt(request.getParameter("codlivro"));

        Livro li = new Livro();
        li.setCodlivro(codlivro);

        LivroDao dao = new LivroDao();
        dao.remover(li);

        out.println("Registro removido com sucesso");
    }
		
}
