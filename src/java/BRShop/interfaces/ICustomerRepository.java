/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BRShop.interfaces;

import BRShop.modeles.Customer;
import java.util.Collection;

/**
 *
 * @author brunolarosa
 */
public interface ICustomerRepository {
    
    
    public void createCustomer();
    
    /* Modify */
    
    
    /* Get */
    
    /**
     * Return all customers
     * @return 
     */
    public Collection<Customer> getAll();
    
    /**
     * Return the customer for an 'id'
     * @param id
     * @return 
     */
    public Customer getForId(int id);
    
    /**
     * Return the customer for an 'login'
     * @param login
     * @return 
     */
    public Customer getForLogin(String login);
    
    
    
}
