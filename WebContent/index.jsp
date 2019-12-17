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
					<input type="image" src="image/1m.png" alt="" name="tileName"  value="0" class="tileMember">
					<input type="image" src="image/2m.png" alt="" name="tileName"  value="1" class="tileMember">
					<input type="image" src="image/3m.png" alt="" name="tileName"  value="2" class="tileMember">
					<input type="image" src="image/4m.png" alt="" name="tileName"  value="3" class="tileMember">
					<input type="image" src="image/5m.png" alt="" name="tileName"  value="4" class="tileMember">
					<input type="image" src="image/6m.png" alt="" name="tileName"  value="5" class="tileMember">
					<input type="image" src="image/8m.png" alt="" name="tileName"  value="6" class="tileMember">
					<input type="image" src="image/7m.png" alt="" name="tileName"  value="7" class="tileMember">
					<input type="image" src="image/9m.png" alt="" name="tileName"  value="8" class="tileMember">
				</div>
				<div class="tileGroup">
					<input type="image" src="image/1s.png" alt="" name="tileName"  value="9" class="tileMember">
					<input type="image" src="image/2s.png" alt="" name="tileName"  value="10" class="tileMember">
					<input type="image" src="image/3s.png" alt="" name="tileName"  value="11" class="tileMember">
					<input type="image" src="image/4s.png" alt="" name="tileName"  value="12" class="tileMember">
					<input type="image" src="image/5s.png" alt="" name="tileName"  value="13" class="tileMember">
					<input type="image" src="image/6s.png" alt="" name="tileName"  value="14" class="tileMember">
					<input type="image" src="image/7s.png" alt="" name="tileName"  value="15" class="tileMember">
					<input type="image" src="image/8s.png" alt="" name="tileName"  value="16" class="tileMember">
					<input type="image" src="image/9s.png" alt="" name="tileName"  value="17" class="tileMember">
				</div>
				<div class="tileGroup">
					<input type="image" src="image/1p.png" alt="" name="tileName"  value="18" class="tileMember">
					<input type="image" src="image/2p.png" alt="" name="tileName"  value="19" class="tileMember">
					<input type="image" src="image/3p.png" alt="" name="tileName"  value="20" class="tileMember">
					<input type="image" src="image/4p.png" alt="" name="tileName"  value="21" class="tileMember">
					<input type="image" src="image/5p.png" alt="" name="tileName"  value="22" class="tileMember">
					<input type="image" src="image/6p.png" alt="" name="tileName"  value="23" class="tileMember">
					<input type="image" src="image/7p.png" alt="" name="tileName"  value="24" class="tileMember">
					<input type="image" src="image/8p.png" alt="" name="tileName"  value="25" class="tileMember">
					<input type="image" src="image/9p.png" alt="" name="tileName"  value="26" class="tileMember">
				</div>
				<div class="tileGroup">
					<input type="image" src="image/ton.png" alt="" name="tileName" value="27" class="tileMember">
					<input type="image" src="image/nan.png" alt="" name="tileName" value="28" class="tileMember tileMember_south">
					<input type="image" src="image/sya.png" alt="" name="tileName" value="29" class="tileMember tileMember_west">
					<input type="image" src="image/pe.png" alt="" name="tileName" value="30" class="tileMember tileMember_north">
					<input type="image" src="image/haku.png" alt="" name="tileName" value="31" class="tileMember">
					<input type="image" src="image/hatu.png" alt="" name="tileName" value="32" class="tileMember tileMember_green">
					<input type="image" src="image/tyun.png" alt="" name="tileName" value="33" class="tileMember tileMember_red">
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

							<li>${tsumo}<br>ツモ</li> <%-- セッションスコープに保存されたインスタンスをJSTLで呼ぶときはキーを使うこと  --%>

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