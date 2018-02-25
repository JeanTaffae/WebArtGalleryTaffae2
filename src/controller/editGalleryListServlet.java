package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GalleryPiece;

/**
 * Servlet implementation class editGalleryListServlet
 */
@WebServlet("/editGalleryListServlet")
public class editGalleryListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public editGalleryListServlet() {
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
		String act = request.getParameter("doThisToPiece");

		if (act == null) {
			// no button has been selected
			getServletContext().getRequestDispatcher("/viewAllPiecesServlet").forward(request, response);

		} else if (act.equals("Delete Selected Piece")) {
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			GalleryPiece pieceToDelete = gph.searchForItemById(tempId);
			gph.deletePiece(pieceToDelete);

			getServletContext().getRequestDispatcher("/viewAllPiecesServlet").forward(request, response);

		} else if (act.equals("Edit Selected Piece")) {
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			GalleryPiece itemToEdit = gph.searchForItemById(tempId);
			request.setAttribute("itemToEdit", itemToEdit);
			getServletContext().getRequestDispatcher("/edit-piece.jsp").forward(request, response);

		} else if (act.equals("Add New Piece")) {
			getServletContext().getRequestDispatcher("/addPiece.html").forward(request, response);

		}
	}

}
