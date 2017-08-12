<%@ taglib prefix="datatables" uri="http://github.com/dandelion/datatables" %>
<%@ include file="/common/taglibs.jsp" %>
<jsp:include page="/common/header.jsp"></jsp:include>
<jsp:include page="/common/nav.jsp"></jsp:include>
<div class="content">
	<br />
		
	<datatables:table id="ordersList" data="${orders}" 
										sortable="true"
										displayLength="20" 
										cssStripes="myOdd,myEven"
										row="order">
		<datatables:column title="S No."><c:out value="${order_rowIndex}"></c:out></datatables:column>
		<datatables:column title="Order No."><c:out value="${order.orderId}"></c:out></datatables:column>orderId
		<datatables:column title="Customer">${order.customer.firstName} ${order.customer.lastName}</datatables:column>
		<datatables:column title="Address">
		${order.customer.address.houseFlatNo}, ${order.customer.address.street}, ${order.customer.address.city}, ${order.customer.address.postCode}, ${order.customer.address.country}
		</datatables:column>
	</datatables:table>
	
</div>

<jsp:include page="/common/footer.jsp"></jsp:include>
