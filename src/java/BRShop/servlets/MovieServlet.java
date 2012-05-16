/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BRShop.servlets;

import BRShop.interfaces.IMoviesRepository;
import BRShop.modeles.Movie;
import BRShop.repository.MoviesJavaDBRepository;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author brunolarosa
 */
@WebServlet(name = "MovieServlet", urlPatterns = {"/Movie"})
public class MovieServlet extends HttpServlet {
    @EJB
    private MoviesJavaDBRepository moviesRepository = new MoviesJavaDBRepository();

    /* GETTER and SETTER */
    public MoviesJavaDBRepository getMoviesRepository() {
        return moviesRepository;
    }


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
        /*
         * TODO output your page here. You may use following sample code.
         */

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String action = request.getParameter("action");
        String forwardTo = "index.jsp?action=home";
        String message = "";
        
        if (null != action){
            
            if(action.equals("movieInfo")){
                Movie movie = moviesRepository.getMovieForId(Integer.getInteger(request.getParameter("movie")));
                request.setAttribute("movie", movie);
                forwardTo = "index.jsp?action=movieInfo";
            }
            else if (action.equals("allMovies")){
                Collection<Movie> moviesList = moviesRepository.getAllMovies();
                request.setAttribute("moviesList", moviesList);
                forwardTo = "index.jsp?action=listMovies";
            }
            else if (action.equals("createTest")){
                this.moviesRepository.createTest();
            }
        
        }

        RequestDispatcher dp = request.getRequestDispatcher(forwardTo);
        dp.forward(request, response);
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
