<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>符計算アプリ(仮)</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/stylesheet.css">
</head>
<body>
	<h1 class="title">符計算アプリ(仮)</h1>

	<div class="parent">
		<div class="main">
			ここはメインページ
			<form action="./MainServlet" method="post"  class="tileGroups">
				<div class="tileGroup">
					<input type="submit"  name="tileName"  value="一萬" class="tileMember">
					<input type="submit"  name="tileName"  value="二萬" class="tileMember">
					<input type="submit"  name="tileName"  value="三萬" class="tileMember">
					<input type="submit"  name="tileName"  value="四萬" class="tileMember">
					<input type="submit"  name="tileName"  value="五萬" class="tileMember">
					<input type="submit"  name="tileName"  value="六萬" class="tileMember">
					<input type="submit"  name="tileName"  value="七萬" class="tileMember">
					<input type="submit"  name="tileName"  value="八萬" class="tileMember">
					<input type="submit"  name="tileName"  value="九萬" class="tileMember">
				</div>
				<div class="tileGroup">
					<input type="submit"  name="tileName"  value="一索" class="tileMember">
					<input type="submit"  name="tileName"  value="二索" class="tileMember">
					<input type="submit"  name="tileName"  value="三索" class="tileMember">
					<input type="submit"  name="tileName"  value="四索" class="tileMember">
					<input type="submit"  name="tileName"  value="五索" class="tileMember">
					<input type="submit"  name="tileName"  value="六索" class="tileMember">
					<input type="submit"  name="tileName"  value="七索" class="tileMember">
					<input type="submit"  name="tileName"  value="八索" class="tileMember">
					<input type="submit"  name="tileName"  value="九索" class="tileMember">
				</div>
				<div class="tileGroup">
					<input type="submit"  name="tileName"  value="一筒" class="tileMember">
					<input type="submit"  name="tileName"  value="二筒" class="tileMember">
					<input type="submit"  name="tileName"  value="三筒" class="tileMember">
					<input type="submit"  name="tileName"  value="四筒" class="tileMember">
					<input type="submit"  name="tileName"  value="五筒" class="tileMember">
					<input type="submit"  name="tileName"  value="六筒" class="tileMember">
					<input type="submit"  name="tileName"  value="七筒" class="tileMember">
					<input type="submit"  name="tileName"  value="八筒" class="tileMember">
					<input type="submit"  name="tileName"  value="九筒" class="tileMember">
				</div>
				<div class="tileGroup">
					<input type="submit"  name="tileName" value="東" class="tileMember">
					<input type="submit"  name="tileName" value="南" class="tileMember tileMember_south">
					<input type="submit"  name="tileName" value="西" class="tileMember tileMember_west">
					<input type="submit"  name="tileName" value="北" class="tileMember tileMember_north">
				</div>
				<div class="tileGroup">
					<input type="submit"  name="tileName" value="白" class="tileMember">
					<input type="submit"  name="tileName" value="撥" class="tileMember tileMember_green">
					<input type="submit"  name="tileName" value="中" class="tileMember tileMember_red">
				</div>
				<div class="btnGroup">
					<input type="submit" name="reset" value="リセット" class="btnRed">
				</div>
				<div class="tileDisplay">
					<ul>
						<c:forEach var="value" items="${selectedTileList}" varStatus="status">
							<li>${value}<br><input type="radio" name="change" value="${status.index}"></li>
						</c:forEach>
					</ul>
					<ul class="tileDisplay_tsumo">
						<c:if test="${selectedTileList.size() == 13}">
							<li>${tsumo}<br>ツモ</li> <%-- セッションスコープに保存されたインスタンスをJSTLで呼ぶときはキーを使うこと  --%>
						</c:if>
					</ul>
				</div>
			</form>
		</div>

		<div class="point">
			ここに点数を入れる。
		</div>
	</div>




</body>
</html>