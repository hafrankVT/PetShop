package net.ddns.petrizoo.controllers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.ddns.petrizoo.models.Pet;
import net.ddns.petrizoo.services.PetManager;
import sun.misc.IOUtils;

/**
 * Servlet implementation class Media
 */
@WebServlet("/Media")
public class Media extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	PetManager pm;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Media() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		//Retrieve a pet by ID, and return that pet's picture value as an image.
		//Add in error check so that if invalid ID it doesn't crash the system.
		
		Pet p = pm.getPetById(request.getParameter("id"));
		if (p.getPicture().length != 0) {
			System.out.println(p.getPicture());
		response.setHeader("Content-Disposition", "inline;filename=" + p.getName() + "");
		
		//Try to write the file
		OutputStream out = response.getOutputStream();
		response.setContentType(".jpg");
		response.setContentLength(p.getPicture().length);
		out.write(p.getPicture());
		} else {
			response.sendRedirect("resources/NoPic.jpg");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
