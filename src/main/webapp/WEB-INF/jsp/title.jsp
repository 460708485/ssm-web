<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="common/tag.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>标题列表</title>
<%@include file="common/head.jsp"%>
</head>
<body>
	<div class="container">
		<div class="panel panel-default">
			<div class="panel-heading text-center">
				<h2>用户列表</h2>
			</div>
			<div class="panel-body">
				<c:forEach var="title" items="${titleList}">
					<tr>
						<li>${title.content}</a></li>
					</tr>
				</c:forEach>
			</div>
		</div>
	</div>
</body>
</html>