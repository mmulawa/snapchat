<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@attribute name="header" fragment="true"%>
<%@attribute name="footer" fragment="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
<title><spring:message code="layout.title" /></title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="<c:url value="/assets/bootstrap-3.3.6-dist/css/bootstrap.min.css" />"
	rel="stylesheet">
<link
	href="<c:url value="/assets/bootstrap-3.3.6-dist/css/bootstrap-theme.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/assets/custom.css" />" rel="stylesheet">
<meta name="_csrf" content="${_csrf.token}" />
<!-- default header name is X-CSRF-TOKEN -->
<meta name="_csrf_header" content="${_csrf.headerName}" />
<c:url value="/assets/jquery.js"  var="script"/>
<script src="${script}" type="text/javascript" ></script>
</head>
<body>
	<div id="body" class="fenige-padding">
		<jsp:doBody />
	</div>
	<footer>
	</footer>
</body>
</html>
