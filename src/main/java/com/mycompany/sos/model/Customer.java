
package com.mycompany.sos.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * {@link Customer} class
 *
 * Customer entity
 *
 * @author Sandeep Bhatt
 */
@Entity
@Table(name = "customer")
@NoArgsConstructor
@EqualsAndHashCode(exclude = "orders")
@ToString
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private int customerId;

	@NotNull(message = "{error.null.firstname}")
	@NotBlank(message = "{error.blank.firstname}")
	@NotEmpty(message = "{error.empty.firstname}")
	@Pattern(regexp = "[a-zA-Z]*", message = "{error.invalid.firstname}")
	@Column(name = "customer_firstname", nullable = false, length = 50)
	private String firstName;

	@NotNull(message = "{error.null.lastname}")
	@NotBlank(message = "{error.blank.lastname}")
	@NotEmpty(message = "{error.empty.lastname}")
	@Pattern(regexp = "[a-zA-Z]*", message = "{error.invalid.lastname}")
	@Column(name = "customer_lastname", nullable = false, length = 50)
	private String lastName;

	@NotNull(message = "{error.null.dob}")
	@Past(message = "{error.past.dob}")
	@Temporal(TemporalType.DATE)
	@Column(name = "customer_date_of_birth", nullable = false)
	private Date dateOfBirth;

	@NotNull(message = "{error.null.email}")
	@NotBlank(message = "{error.blank.email}")
	@NotEmpty(message = "{error.empty.email}")
	@Email(message = "{error.email}")
	@Lob
	@Column(name = "customer_email_address", nullable = false, columnDefinition = "TEXT")
	private String email;

	// M : 1
	@Valid
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "customer_address_id")
	private Address address;

	// 1 : 1
	@Valid
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "customer", cascade = { CascadeType.ALL })
	private CustomerPaymentDetail customerPaymentDetail;

	// 1 : M
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer", cascade = { CascadeType.ALL })
	private Set<Order> orders = new HashSet<>(0);

	
	/**
	 * @return the customerId
	 */
	public int getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId
	 *            the customerId to set
	 */
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the dateOfBirth
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth
	 *            the dateOfBirth to set
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}



	/**
	 * @return the customerPaymentDetail
	 */
	public CustomerPaymentDetail getCustomerPaymentDetail() {
		return customerPaymentDetail;
	}

	

	/**
	 * @return the orders
	 */
	public Set<Order> getOrders() {
		return orders;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * @param customerPaymentDetail the customerPaymentDetail to set
	 */
	public void setCustomerPaymentDetail(CustomerPaymentDetail customerPaymentDetail) {
		this.customerPaymentDetail = customerPaymentDetail;
	}

	/**
	 * @param orders the orders to set
	 */
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	

	




}
