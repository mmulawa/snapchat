<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<t:layout>
	<jsp:body>
		<div class="container main-wrapper">
			<div class="row">
				<div class="panel panel-default messages-box">
					<ul class="list-unstyled">
						<c:forEach items="${list}" var="message">
							<li>
								<div style="color: blue;">
									<fmt:formatDate pattern="yyyy-MM-dd HH:mm"
										value="${message.getDate()}" />
								</div>
								<div>${message.getContent()}</div>
							</li>
						</c:forEach>
					</ul>
				</div>
			</div>
			<div class="row">
				<form action="" method="POST">
					<textarea></textarea>
					<input type="text" name="firstName"/>

					<button class="btn-primary pull-right">Wyślij</button>
				</form>
			</div>
		</div>
		<script type="text/javascript">

			function addMessage() {

				var data = {
					"content": $("textarea").val(),
					"firstName": $("input").val()
				};
				$.ajax({
					url: "",
					type: "POST",
					data: JSON.stringify(data),
					contentType: "application/json; charset=utf-8",
					dataType: "json",
					success: function (data, textStatus, jqXHR) {
						console.log(data);

						$("ul").append("<li> <div style='color: blue;'>" + data.date + "</div><div>" + data.content + "</div></li>")

						$(".messages-box").scrollTop($(".messages-box")[0].scrollHeight);

						$("textarea").val("");
					},
					error: function (jqXHR, textStatus, errorThrown) {

					}
				});
			}

			$(window).load(function() {
				$(".messages-box").scrollTop($(".messages-box")[0].scrollHeight);
				$("button").click(function (e) {
					e.preventDefault();
					addMessage();
				});
				console.log($("ul li:last-child div:first-child").html());
				
			    setInterval(function() {
			    	var data = {
							"date" : $.trim($("ul li:last-child div:first-child").html())
						};
						$.ajax({
							url : "new",
							type : "POST",
							data : JSON.stringify(data),
							contentType : "application/json; charset=utf-8",
							dataType : "json",
							success : function(data, textStatus, jqXHR) {
								console.log(data);
								if(data.length > 0){
									$.each( data, function( i, item ) {	
									$("ul").append("<li> <div style='color: blue;'>"+ item.date +"</div><div>"+ item.content + "</div></li>")
									});
								}
								$(".messages-box").scrollTop($(".messages-box")[0].scrollHeight);
							},
							error : function(jqXHR, textStatus, errorThrown) {

							}
						});
			    }, 5000);
			});
		</script>
	</jsp:body>
</t:layout>