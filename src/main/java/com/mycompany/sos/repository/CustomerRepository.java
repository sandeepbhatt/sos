
package com.mycompany.sos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mycompany.sos.model.Customer;

/**
 * {@link CustomerRepository} interface
 *
 * @author Sandeep Bhatt
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    /**
     * Finds the {@link Customer} by the customer name (i.e firstname + lastname)
     *
     * @return {@link Customer}
     */
    Customer findByFirstNameAndLastName(String firstName, String lastName);
}
