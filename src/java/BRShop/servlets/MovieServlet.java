/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BRShop.servlets;

import BRShop.interfaces.IMoviesRepository;
import BRShop.repository.MoviesJavaDBRepository;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import BRShop.modeles.Movie;

/**
 *
 * @author brunolarosa
 */
public class MovieServlet extends HttpServlet {

    @EJB
    private IMoviesRepository moviesRepository = new MoviesJavaDBRepository();

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String action = request.getParameter("action");
        String forwardTo = "";
        String message = "";
        /*
         * TODO output your page here. You may use following sample code.
         */
        if (action != null) {
            System.out.println("Action exist");
            if (action.equals("moviesList")) {
                System.out.println("MovieList");
                Collection<Movie> moviesList = moviesRepository.getAllMovies();
                request.setAttribute("moviesList", moviesList);
                forwardTo = "index.jsp?action=listMovies";
            }
            if(action.equals("createExemple"))
            {
                moviesRepository.createTest();
                System.out.println("Test ok");
                forwardTo = "Movie?action=moviesList";
            }
        } else {
        }
        
        RequestDispatcher dp = request.getRequestDispatcher(forwardTo + "&message=" + message);
        dp.forward (request, response);
    // Après un forward, plus rien ne peut être exécuté après !

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
