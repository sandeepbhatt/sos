
package com.mycompany.sos.repository;

import com.mycompany.sos.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * {@link ItemRepository} interface
 *
 * @author Sandeep Bhatt
 */
@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

}
