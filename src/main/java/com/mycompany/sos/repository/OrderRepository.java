
package com.mycompany.sos.repository;

import com.mycompany.sos.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * {@link OrderRepository} interface
 *
 * @author Sandeep Bhatt
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
