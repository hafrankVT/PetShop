package net.ddns.petrizoo.controllers;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import net.ddns.petrizoo.models.Gender;
import net.ddns.petrizoo.models.Pet;
import net.ddns.petrizoo.models.PetType;
import net.ddns.petrizoo.services.PetManager;

/**
 * Servlet implementation class AddPet
 */
@WebServlet("/AddPet")
@MultipartConfig

public class AddPet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	PetManager pm;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/add_pet.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Fun times! Let's retrieve all the info from the form!
		
		//Regular Stuff
		String petName = request.getParameter("pet_name");
		String petType = request.getParameter("pet_type");
		String petGender = request.getParameter("pet_gender");
		Double petCost = Double.parseDouble(request.getParameter("pet_cost"));
		boolean petFixed = Boolean.parseBoolean(request.getParameter("pet_fixed"));
		
		//Picture stuff (Maybe)
	    Part filePart = request.getPart("pet_pic"); // Retrieves <input type="file" name="file">
	    String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
	    InputStream fileContent = filePart.getInputStream();
		
		Pet p = new Pet();
		p.setCost(petCost);
		p.setFixed(petFixed);
		p.setName(petName);
		p.setGender(Gender.valueOf(petGender));
		p.setPetType(PetType.valueOf(petType));
		ByteArrayOutputStream petPic = new ByteArrayOutputStream();
		
		int reads = fileContent.read();
		
		while (reads != -1) {
			petPic.write(reads);
			reads = fileContent.read();
		}
		
		p.setPicture(petPic.toByteArray());
		
		System.out.println("created pet:");
		System.out.println(p);
		
		pm.addPet(p);
		
	}

}
