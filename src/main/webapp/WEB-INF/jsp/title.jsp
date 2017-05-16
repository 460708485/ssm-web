<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="common/tag.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>藏宝图首页</title>
<%@include file="common/head.jsp"%>
<title>标题列表</title>
</head>
<body>
	<!-- 代码部分begin -->
<div class="wapper">
	<div class="header-widht w735 clearFloat pt15 pb10">
		<div style="margin:500 0 0 100" >
			<ul class="clearFloat">
				<ul >
					<c:forEach var="title" items="${titlelist}">
						<tr style="margin:500 0 0 100">
							<td >${title.content}</td>
						</tr>	
					</c:forEach>
				</ul>
			</ul>
		</div>
		
		<div
			<c:forEach var="content" items="${contentList}">
						<tr style="margin:500 0 0 100">
							<td >${content.title}</td>
							<td>${content.content}</td>
						</tr>	
			</c:forEach>>

		</div>
		</div>
	</div>
<script src="js/jquery-1.7.2.min.js"></script>
<script src="js/lanren.js"></script>
<!-- 代码部分end -->
</body>
</html>