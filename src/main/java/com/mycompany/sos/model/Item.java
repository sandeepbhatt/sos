
package com.mycompany.sos.model;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * {@link Item} class
 *
 * Item entity
 *
 * @author Sandeep Bhatt
 */
@Entity
@Table(name = "items")
@ToString(exclude = "orders")
@EqualsAndHashCode(exclude = "orders")
@NoArgsConstructor
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "item_id")
	private int itemId;

	@NotNull(message = "{error.null.itemName}")
	@Column(name = "item_name", nullable = false, length = 255)
	private String itemName;

	@NotNull(message = "{error.null.itemPrice}")
	@Column(name = "item_price", nullable = false)
	private BigDecimal itemPrice;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "items")
	private Set<Order> orders = new HashSet<>();

	/**
	 * @return the itemId
	 */
	public int getItemId() {
		return itemId;
	}

	/**
	 * @param itemId
	 *            the itemId to set
	 */
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	/**
	 * @return the itemName
	 */
	public String getItemName() {
		return itemName;
	}

	/**
	 * @param itemName
	 *            the itemName to set
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	/**
	 * @return the itemPrice
	 */
	public BigDecimal getItemPrice() {
		return itemPrice;
	}

	/**
	 * @param itemPrice
	 *            the itemPrice to set
	 */
	public void setItemPrice(BigDecimal itemPrice) {
		this.itemPrice = itemPrice;
	}

	/**
	 * @return the orders
	 */
	public Set<Order> getOrders() {
		return orders;
	}



}
