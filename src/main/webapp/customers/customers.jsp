<%@ taglib prefix="datatables" uri="http://github.com/dandelion/datatables" %>
<%@ include file="/common/taglibs.jsp" %>
<jsp:include page="/common/header.jsp"></jsp:include>
<jsp:include page="/common/nav.jsp"></jsp:include>
<div class="content">
	<br />
	<button id="createCustomerButton" onclick="location.href='http://localhost:8080/online-application/customers/create'">
		Create Customer
	</button>
	<br />
	
	<table>
	<thead>
	<tr>
	<th>Name</th><th>Date Of Birth</th><th>Email Address</th><th>Address</th><th>Delete</th><th>Edit</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="customer" items="${customers}">
	<tr>
	<td><a href="customer/${customer.customerId}">${customer.firstName} ${customer.lastName}</a></td>
	<td>${customer.dateOfBirth}</td>
	<td>${customer.email}</td>
	<td>${customer.address.houseFlatNo}, ${customer.address.street}, ${customer.address.city}, ${customer.address.postCode}, ${customer.address.country}</td>
	<td><a href="customers/delete/${customer.customerId}" style="color: red;">Delete</a></td>
	<td><a href="customers/${customer.customerId}" style="color: red;">Edit</a></td>
	</tr>
	</c:forEach>
	</tbody>
	</table>
	

	

	<%-- 	<datatables:table id="customerList" data="${customers}" 
										sortable="true"
										displayLength="20" 
										export="csv,pdf" 
										cssStripes="myOdd,myEven"
										row="customer">
		<datatables:column title="#"><c:out value="${customer_rowIndex}"></c:out></datatables:column>
		<datatables:column title="Name"><a href="customer/${customer.customerId}">${customer.firstName} ${customer.lastName}</a></datatables:column>
		<datatables:column title="Date Of Birth">${customer.dateOfBirth}</datatables:column>
		<datatables:column title="Email Address">${customer.email}</datatables:column>
		<datatables:column title="Address">
			${customer.address.houseFlatNo}, ${customer.address.street}, ${customer.address.city}, ${customer.address.postCode}, ${customer.address.country}
		</datatables:column>
		<datatables:column title="#"><a href="customers/delete/${customer.customerId}" style="color: red;">Delete</a></datatables:column>
		<datatables:column title="Edit"><a href="customers/${customer.customerId}" style="color: red;">Edit</a></datatables:column> 
	</datatables:table> --%>
	
</div>
<jsp:include page="/common/footer.jsp"></jsp:include>
