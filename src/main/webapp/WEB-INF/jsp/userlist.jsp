<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="common/tag.jsp"%>
<!DOCTYPE html>
<html>
<head>
<style>
header {
	background-color: white;
	color: black;
	text-align: center;
	padding: 5px;
}

nav {
	line-height: 30px;
	background-color: #eeeeee;
	height: 300px;
	width: 100px;
	float: left;
	padding: 5px;
}

section {
	width: 350px;
	float: left;
	padding: 10px;
}

footer {
	background-color: white;
	color: black;
	clear: both;
	text-align: center;
	padding: 5px;
}
</style>
</head>

<body>

	<header>
		<h1>City Gallery</h1>
	</header>

	<nav>
		<ul>
			<c:forEach var="title" items="${titlelist}">
				<li>${title.content}></li>
			</c:forEach>
		</ul>
	</nav>

	<section>
		<p>
			<c:forEach var="content" items="${contentList}">
				<div class="firstreed">
					<div class="reed">
						<div class="read-more">
							<a rel="nofollow" href="http://www.68jn.cn/post/12.html"
								title="【藏宝网】藏宝网项目简述 ">阅读全文</a>
						</div>
						<!-- baidu_tc block_begin: {"action": "DELETE"} -->
						<div class="riqiding">顶</div>
						<!-- baidu_tc block_end -->
						<h2>
							<a id="content" target="_blank" value=${content.id} title=${content.title}>${content.title}</a>
						</h2>
						<h6>
							发布 : 微信wly3191 | 分类 : <a
								href="http://www.68jn.cn/category-0.html"
								title="查看 藏宝网项目简介 的全部文章">藏宝网项目简介</a> | 评论 : 0人 | 浏览 : <span
								id="spn12"></span>
							次
							<div class="clear"></div>
						</h6>
						<div class="jieshao">
							<span id="zhaiyaotu"><a
								href="http://www.68jn.cn/post/12.html" target="_blank"
								title="【藏宝网】藏宝网项目简述 "><img
									src="http://www.68jn.cn/zb_users/upload/2017/5/2017051544578201_mini.jpg"
									alt="【藏宝网】藏宝网项目简述 " /></a></span>
							<p>【藏宝网】藏宝网项目简述</p>
						</div>
					</div>
			</c:forEach>

		</p>
	</section>

	<footer> Copyright W3Schools.com </footer>
</body>
</html>
