package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GalleryPiece;

/**
 * Servlet implementation class addPieceServlet
 */
@WebServlet("/addPieceServlet")
public class addPieceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addPieceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String title = request.getParameter("title");
		String artistName = request.getParameter("artistName");
		String media = request.getParameter("media");
		String year = request.getParameter("year");
		String valueS = request.getParameter("value");
		Double value = Double.parseDouble(valueS);
		
		GalleryPiece gp = new GalleryPiece(title, artistName, media, year, value);		
		GalleryPieceHelper gph = new GalleryPieceHelper();
		gph.insertItem(gp);
		
		getServletContext().getRequestDispatcher("/addPiece.html").forward(request, response);
	}

}
