
package com.mycompany.sos.service;

import com.mycompany.sos.model.Order;

import java.util.List;

/**
 * {@link OrderService} interface
 *
 * @author Sandeep Bhatt
 */
public interface OrderService {

	/**
	 * Adds a new order
	 *
	 * @param order the new order to add
	 * @return true if successfully added false otherwise
	 */
	boolean addOrder(Order order);

	/**
	 * Gets a list of orders
	 *
	 * @return list of orders
	 */
	List<Order> getOrders();
}
