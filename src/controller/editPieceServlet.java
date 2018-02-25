package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GalleryPiece;

/**
 * Servlet implementation class editPieceServlet
 */
@WebServlet("/editPieceServlet")
public class editPieceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public editPieceServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		GalleryPieceHelper gph = new GalleryPieceHelper();

		String title = request.getParameter("title");
		String artistName = request.getParameter("artistName");
		String media = request.getParameter("media");
		String year = request.getParameter("year");
		String valueS = request.getParameter("value");
		Double value = Double.parseDouble(valueS);
		Integer tempId = Integer.parseInt(request.getParameter("id"));

		GalleryPiece itemToEdit = gph.searchForItemById(tempId);
		itemToEdit.setTitle(title);
		itemToEdit.setArtistName(artistName);
		itemToEdit.setMedia(media);
		itemToEdit.setYear(year);
		itemToEdit.setValue(value);

		gph.updatePiece(itemToEdit);

		getServletContext().getRequestDispatcher("/viewAllPiecesServlet").forward(request, response);

		doGet(request, response);
	}

}
