<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<t:layout>
	<jsp:body>
		<div class="container main-wrapper">
			<div class="row">
				<div class="panel panel-default messages-box">
					<ul class="list-unstyled">
						<li>Messages</li>
						<li>Messages</li>
						<li>Messages</li>
						<li>Messages</li>
					</ul>
				</div>
			</div>
			<div class="row">
				<form action="" method="POST">
					<textarea></textarea>
					<button class="btn-primary pull-right">Wyślij</button>
				</form>
			</div>
		</div>
	</jsp:body>
</t:layout>