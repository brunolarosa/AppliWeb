/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BRShop.repository;

import BRShop.modeles.Movie;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author brunolarosa
 */
@Stateless
@LocalBean
public class MoviesJavaDBRepository {

    @PersistenceContext
    private EntityManager em;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public Movie createMovie(String title, String description, double price, String picture, int quantity) {
        Movie m = new Movie(title, description, price, picture, quantity);
        System.out.println("Movie create : OK");
        em.persist(m);
        System.out.println("Movie create : OK");
        return m;
    }

    public void createTest() {
        createMovie("Matrix", "Ceci est une description", 19.99, "url", 2);
        createMovie("Matrix 2", "Ceci est une description", 19.99, "url", 1);
        System.out.println("Test create : OK");
    }

    /**
     * Return all Movie
     *
     * @return
     */
    public Collection<Movie> getAllMovies() {
        // Exécution d'une requête équivalente à un select *  
        Query q = em.createQuery("select m from Movie m");
        return q.getResultList();
    }

    public Movie getMovieForId(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
