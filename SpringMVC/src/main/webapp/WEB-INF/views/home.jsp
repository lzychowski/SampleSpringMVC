<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<P>  The time on the server is ${serverTime}. </P>
<P>  First company's name is: ${companyName}. </P>
<P>  First company's code is ${companyCode}. </P>

<c:forEach var="company" items="${companyList}">
	<p>
	Company Name: ${company.getCompanyName()}
	<br />
	Company Code: ${company.getCompanyCode()}
	</p>
</c:forEach>

</body>
</html>
