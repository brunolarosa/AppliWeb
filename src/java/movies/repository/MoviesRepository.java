/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package movies.repository;

import java.util.Collection;  
import javax.ejb.Stateless;  
import javax.persistence.EntityManager;  
import javax.persistence.PersistenceContext;  
import javax.persistence.Query;  

import movies.modeles.*;

/**
 *
 * @author brunolarosa
 */
@Stateless
public class MoviesRepository {
    
    // Ici injection de code : on n'initialise pas. L'entity manager sera créé  
    // à partir du contenu de persistence.xml  
    @PersistenceContext  
    private EntityManager em;
    
    public Movie createMovie(String title, String description, double price, String picture, int quantity)
    {
        Movie m = new Movie(title, description, price, picture, quantity);
        em.persist(m);
        return m;
    }
    
    public void createTest()
    {
        createMovie("Matrix", "Ceci est une description", 19.99, "url", 2);
        createMovie("Matrix 2", "Ceci est une description", 19.99, "url", 1);
    }
    
    /**
     * Return all Movie
     * @return 
     */
    public Collection<Movie> getAllMovie() {  
        // Exécution d'une requête équivalente à un select *  
        Query q = em.createQuery("select m from Movie m");  
        return q.getResultList();  
    } 
    
}
