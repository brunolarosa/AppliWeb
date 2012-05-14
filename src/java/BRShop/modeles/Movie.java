/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BRShop.modeles;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author brunolarosa
 */
@Entity
public class Movie implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String title;
    private String description;
    private double price;
    private String picture;
    private int quantity;

 /* START GETTER AND SETTER */
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getPicture() {
        return picture;
    }
    public void setPicture(String picture) {
        this.picture = picture;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
 /* END GETTER AND SETTER */
    
 /* START CONSTRUCTOR */
    
    public Movie()
    {}
    
    /**
     * Create a new movie
     * @param title
     * @param description
     * @param price
     * @param picture
     * @param quantity 
     */
    public Movie( String title, String description, double price, String picture, int quantity)
    {
        this.title = title;
        this.description = description;
        this.price = price;
        this.picture = picture;
        this.quantity = quantity;
    }
 /* END CONSTRUCTOR */



    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movie)) {
            return false;
        }
        Movie other = (Movie) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BRShop.modeles.movie[ id=" + id + " ]";
    }
    
}
