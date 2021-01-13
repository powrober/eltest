<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, member.model.vo.Member"%>
<%
	ArrayList<Member> list = (ArrayList<Member>) request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>first</title>
<script type="text/javascript">
	function changeLogin(element) {
		//선택한 radio 의 name 속성 값에서 userid 만 분리 추출함
		var userid = element.name.substring(8); //name="loginok_아이디"
		alert("userid : " + userid);

		if (element.checked == true && element.value == "false") {
			alert("로그인 제한 체크함");
			location.href = "/first/loginOK?userid=" + userid + "&ok=false";
		} else {
			alert("로그인 제한 해제함");
			location.href = "/first/loginOK?userid=" + userid + "&ok=true";
		}
	}
</script>
</head>
<body>

	<%-- <%@ include file="../common/header.jsp" %> --%>
	<jsp:includ page="../common/header.jsp" />

	<hr>
	<h1 align="center">회원 전체 조회 and 관리 페이지</h1>
	<h2 align="center">
		현재 가입 회원수 : ${ list }
		<%=list.size()%>
		명
	</h2>
	<br>
	<table align="center" border="1" cellspacing="0" cellpadding="3">
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>성별</th>
			<th>나이</th>
			<th>전화번호</th>
			<th>이메일</th>
			<th>취미</th>
			<th>하고 싶은 말</th>
			<th>가입날짜</th>
			<th>마지막 수정날짜</th>
			<th>로그인 제한 여부</th>
		</tr>
		<c:forEach var="m" items="list">
			<tr>
				<td>${ m.userId }</td>
				<td>${ m.userNm }</td>
				<td>${ m.gender ep 'M' ? "남자" : "여자" }</td>
				<td>${ m.age }</td>
				<td>${ m.phone }</td>
				<td>${ m.email }</td>
				<td>${ m.etc }</td>
				<td><c:if test="${ m.userLock eq 'Y' }">
						<input type="radio" name="loginok_${ m.userId }"
							onchange="changeLogin(this);" value="true" checked> 가능 
				 <input type="radio" name="loginok_${ m.userId }"
							onchange="changeLogin(this);" value="false"> 제한
				</c:if> <c:if test="${ m.userLock ne 'Y' }">
						<input type="radio" name="loginok_${ m.userId }"
							onchange="changeLogin(this);" value="true"> 가능
				<input type="radio" name="loginok_${ m.userId }"
							onchange="changeLogin(this);" value="false" checked> 제한
				</c:if></td>
			</tr>
		</c:forEach>
	</table>


	<hr>

	<%-- <%@ include file="../common/footer.jsp" %> --%>

</body>
</html>