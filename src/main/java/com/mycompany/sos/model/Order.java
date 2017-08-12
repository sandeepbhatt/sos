
package com.mycompany.sos.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * {@link Order} class
 *
 * Order entity
 *
 * @author Sandeep Bhatt
 */
@Entity
@Table(name = "orders")
@NoArgsConstructor
@EqualsAndHashCode(exclude = { "customer", "items" })
@ToString(exclude = "customer")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private int orderId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id", nullable = false)
	private Customer customer;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "orders_items", joinColumns = {
			@JoinColumn(name = "order_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "item_id", nullable = false, updatable = false) })
	private Set<Item> items = new HashSet<>(0);

	/**
	 * @return the orderId
	 */
	public int getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId
	 *            the orderId to set
	 */
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer
	 *            the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * @return the items
	 */
	public Set<Item> getItems() {
		return items;
	}



}
