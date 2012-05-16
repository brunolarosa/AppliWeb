/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BRShop.interfaces;

import java.util.Collection;
import BRShop.modeles.Movie;

/**
 *
 * @author brunolarosa
 */
public interface IMoviesRepository
{
    public Movie createMovie(String title, String description, double price, String picture, int quantity);
    public void createTest();
    public Collection<Movie> getAllMovies();
    public Movie getMovieForId(int id);
}
