/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BRShop.repository;

import BRShop.interfaces.ICustomersRepository;
import BRShop.modeles.Customer;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author brunolarosa
 */
@Stateless
@LocalBean
public class CustomersJavaDBRepository implements ICustomersRepository{
    
    // Ici injection de code : on n'initialise pas. L'entity manager sera créé  
    // à partir du contenu de persistence.xml  
    @PersistenceContext  
    private EntityManager em;

    @Override
    public Customer createCustomer(String login, String password, String mail, String lastName, String firstName, String phone) {
        Customer customer = new Customer(login, password, mail, lastName, firstName, phone);
        em.persist(customer);
        return customer;
    }

    @Override
    public Collection<Customer> getAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Customer getForId(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Customer getForLogin(String login) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
}
