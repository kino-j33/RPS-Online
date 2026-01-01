<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>結果</title>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/common.css">

<%@ taglib prefix="c" uri="jakarta.tags.core"%>
</head>

<body>
	<main>
		<h1>RPSオンライン</h1>
		<p>最初はグー、じゃんけん・・・ぽん</p>

		<!-- ユーザーとコンピュータの手を表示 -->
		<div class="layout-row">
			<!-- ユーザーの手 -->
			<div class="choice-item">
				<p class="t-center">あなたの手</p>
				<c:set var="userHand" value="${handDto.userHand}" />
				<img src="${pageContext.request.contextPath}${userHand.url}" alt="${userHand.name}" class="hand-img">
				<p class="choice-text">${userHand.name}</p>
			</div>

			<!-- コンピュータの手 -->
			<div class="choice-item">
				<p class="t-center">コンピュータの手</p>
				<c:set var="computerHand" value="${handDto.computerHand}" />
				<img src="${pageContext.request.contextPath}${computerHand.url }" alt="${computerHand.name }" class="hand-img">
				<p class="choice-text">${computerHand.name }</p>
			</div>
		</div>

		<!-- 勝敗結果の表示 -->
		<div class="result-message">
			<p>${wld.winLossDrawMessage1}</p>
			<p>${wld.winLossDrawMessage2}</p>
		</div>

		<p><a href="${pageContext.request.contextPath}/PlayInit">もう一度遊ぶ</a></p>
	</main>
</body>
</html>
