<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>手の選択画面</title>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/common.css">

<%@ taglib prefix="c" uri="jakarta.tags.core"%>
</head>

<body>
	<main>
		<h1>RPSオンライン</h1>
		<c:if test="${errMessage != null}">
			<p class="err-message">${errMessage}</p>
		</c:if>

		<p>最初はグー、じゃんけん・・・</p>
		<form action="${pageContext.request.contextPath}/JudgeServlet" method="get" onsubmit="submitForm();">
			<div class="form-container layout-row">

				<!-- 手の表示 -->
				<c:forEach var="rockPaperScissor" items="${rockPaperScissors}">
					<button type="submit" name="hand" class="choice-item js--submit" value="${rockPaperScissor.hand}">
						<img src="${pageContext.request.contextPath}${rockPaperScissor.url}" alt="${rockPaperScissor.name}" class="hand-img">
						<p class="choice-text">${rockPaperScissor.name}</p>
					</button>
				</c:forEach>

				<input type="hidden" name="hand" id="js--hand-input" value="">
			</div>
		</form>
	</main>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/common.js"></script>
</body>
</html>
