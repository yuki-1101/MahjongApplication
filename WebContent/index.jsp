<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tile Caluculator</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/stylesheet.css">
</head>
<body class="body" style="background-image: url(image/top6.jpg);">
	<div class="title" style="background-image: url(image/top3.png);">
		<div class="innerBlack">
			<h1>Tile Caluculator</h1>
		</div>

	</div>

	<div class="main">
		<form action="./MainServlet" method="post" class="tileGroups">
			<div class="mainBody">
				<div class="tileArea">
					<div class="tileGroup">
						<button type="submit" name="tileName" value="11"><img src="image/011m.png" alt="" class="tileMember"></button>
						<button type="submit" name="tileName" value="12"><img src="image/012m.png" alt="" class="tileMember"></button>
						<button type="submit" name="tileName" value="13"><img src="image/013m.png" alt="" class="tileMember"></button>
						<button type="submit" name="tileName" value="14"><img src="image/014m.png" alt="" class="tileMember"></button>
						<button type="submit" name="tileName" value="15"><img src="image/015m.png" alt="" class="tileMember"></button>
						<button type="submit" name="tileName" value="16"><img src="image/016m.png" alt="" class="tileMember"></button>
						<button type="submit" name="tileName" value="17"><img src="image/017m.png" alt="" class="tileMember"></button>
						<button type="submit" name="tileName" value="18"><img src="image/018m.png" alt="" class="tileMember"></button>
						<button type="submit" name="tileName" value="19"><img src="image/019m.png" alt="" class="tileMember"></button>
					</div>
					<div class="tileGroup">
						<button type="submit" name="tileName" value="21"><img src="image/101s.png" alt="" class="tileMember"></button>
						<button type="submit" name="tileName" value="22"><img src="image/102s.png" alt="" class="tileMember"></button>
						<button type="submit" name="tileName" value="23"><img src="image/103s.png" alt="" class="tileMember"></button>
						<button type="submit" name="tileName" value="24"><img src="image/104s.png" alt="" class="tileMember"></button>
						<button type="submit" name="tileName" value="25"><img src="image/105s.png" alt="" class="tileMember"></button>
						<button type="submit" name="tileName" value="26"><img src="image/106s.png" alt="" class="tileMember"></button>
						<button type="submit" name="tileName" value="27"><img src="image/107s.png" alt="" class="tileMember"></button>
						<button type="submit" name="tileName" value="28"><img src="image/108s.png" alt="" class="tileMember"></button>
						<button type="submit" name="tileName" value="29"><img src="image/109s.png" alt="" class="tileMember"></button>
					</div>
					<div class="tileGroup">
						<button type="submit" name="tileName" value="31"><img src="image/111p.png" alt="" class="tileMember"></button>
						<button type="submit" name="tileName" value="32"><img src="image/112p.png" alt="" class="tileMember"></button>
						<button type="submit" name="tileName" value="33"><img src="image/113p.png" alt="" class="tileMember"></button>
						<button type="submit" name="tileName" value="34"><img src="image/114p.png" alt="" class="tileMember"></button>
						<button type="submit" name="tileName" value="35"><img src="image/115p.png" alt="" class="tileMember"></button>
						<button type="submit" name="tileName" value="36"><img src="image/116p.png" alt="" class="tileMember"></button>
						<button type="submit" name="tileName" value="37"><img src="image/117p.png" alt="" class="tileMember"></button>
						<button type="submit" name="tileName" value="38"><img src="image/118p.png" alt="" class="tileMember"></button>
						<button type="submit" name="tileName" value="39"><img src="image/119p.png" alt="" class="tileMember"></button>
					</div>
					<div class="tileGroup">
						<button type="submit" name="tileName" value="41"><img src="image/121ton.png" alt="" class="tileMember"></button>
						<button type="submit" name="tileName" value="42"><img src="image/122nan.png" alt="" class="tileMember"></button>
						<button type="submit" name="tileName" value="43"><img src="image/123sya.png" alt="" class="tileMember"></button>
						<button type="submit" name="tileName" value="44"><img src="image/124pe.png" alt="" class="tileMember"></button>
						<button type="submit" name="tileName" value="45"><img src="image/125haku.png" alt="" class="tileMember"></button>
						<button type="submit" name="tileName" value="46"><img src="image/126hatu.png" alt="" class="tileMember"></button>
						<button type="submit" name="tileName" value="47"><img src="image/127tyun.png" alt="" class="tileMember"></button>
					</div>
				</div>
				<div class="mathArea">
					<table border="1">
						<tr>
							<th noWrap>点数</th>
							<td>18000</td>
						</tr>
						<tr>
							<th>役</th>
							<td>
								<c:forEach var="value" items="${stc.getRoleName()}">
									${value}
								</c:forEach>
							</td>
						</tr>
						<tr>
							<th>符</th>
							<td>30符</td>
						</tr>
						<tr>
							<th>翻</th>
							<td></td>
						</tr>

					</table>

				</div>
			</div>

			<div class="btnGroup">
				<input type="submit" name="reset" value="リセット" class="btnRed">
				<input type="submit" name="reset" value="リセット" class="btnRed">
				<input type="submit" name="reset" value="リセット" class="btnRed">
				<input type="submit" name="reset" value="リセット" class="btnRed">
				<input type="submit" name="reset" value="リセット" class="btnRed">
				<input type="submit" name="reset" value="リセット" class="btnRed">
				<input type="submit" name="reset" value="リセット" class="btnRed">
			</div>
			<div class="tileDisplay">
				<ul>
					<c:forEach var="value" items="${stc.getTehaiImageList()}" varStatus="status">
						<li><img src="${value}" alt="" class="tileMember_tehai"><br><input type="radio" name="change" value="${status.index}"></li>
					</c:forEach>
				</ul>
				<ul class="tileDisplay_tsumo">
					<c:if test="${stc.getTsumo() != null}">
						<li><img src="${stc.getTsumo()}" alt="" class="tileMember_tsumo"><br>ツモ</li> <%-- セッションスコープに保存されたインスタンスをJSTLで呼ぶときはキーを使うこと  --%>
					</c:if>
				</ul>
			</div>
		</form>
	</div>









</body>
</html>