<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" contentType="text/html;charset=utf-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CLASSFEED | 회원가입</title>

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap" rel="stylesheet">

    <script src="https://kit.fontawesome.com/5a210d3256.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="../css/common.css">
    <link rel="stylesheet" href="../css/sign.css">
    <script src="../js/common.js"></script>
    <script src="../js/sign.js"></script>
</head>

<body>
<div class="signBoxWrap" style="width: 350px;">
    <div class="signBox">
        <div class="logoWrap">
            <p class="title">회원가입</p>

            <img src="../img/classfeedLogo.png" class="logo">
        </div>
        <form action="sign_up.do" method="post" class="signUpForm">
            <div class="stepWrap stepWrap1" style="margin-top:15px; margin-left:-">
                <p>회원종류를 선택해주세요.</p>
                <div class="memCheckWrap">
                    <input type="hidden" class="formData" name="type">
                    <label class="memCheck" data-val="teacher">
                        <i class="fas fa-chalkboard-teacher"></i>
                        <p><i class="fas fa-check"></i>선생님</p>
                    </label>
                    <label class="memCheck" data-val="student">
                        <i class="fas fa-user-edit"></i>
                        <p><i class="fas fa-check"></i>학생</p>
                    </label>
                </div>
                <p class="actionBtn nextBtn off">다음</p>
                <a href="../" class="otherBtn">돌아가기</a>
            </div>
            <div class="stepWrap stepWrap2">

                <div class="inpWrap">
                    <input type="text" class="inp formData" name="name" placeholder="이름" id="nameInp">
                    <div class="inpBar"></div>
                </div>

                <div class="inpWrap">
                    <input type="text" class="inp formData" name="email" id="emailInp" placeholder="이메일">
                    <input type="hidden" id="emailCheck" value="0">
                    <div class="inpBar"></div>
                    <div class="emailNumSend inpInnerBtn">인증번호 발송</div>
                </div>
                <p class="emailMsg signMsg">이메일 형식을 확인해주세요.</p>

                <div class="inpWrap checkNumWrap" style="margin-top:10px;">
                    <input type="text" class="inp" id="numCheckInp" placeholder="인증번호 (4자리)">
                    <div class="inpBar"></div>
                    <div class="emailNumCheck inpInnerBtn">확인</div>
                    <div class="emailNumCheck2 inpInnerBtn on" style="display: none;">재발송</div>
                </div>
                <p class="numCheckMsg signMsg">인증번호가 일치하지 않습니다.</p>

                <div class="br"></div>

                <div class="inpWrap">
                    <input type="password" class="inp formData" name="password" id="passwordInp" placeholder="비밀번호">
                    <div class="inpBar"></div>
                </div>
                <div class="inpWrap">
                    <input type="password" class="inp" id="passwordInp2" placeholder="비밀번호 확인">
                    <div class="inpBar"></div>
                </div>
                <p class="passwordMsg signMsg">비밀번호가 일치하지 않습니다.</p>

                <button type="submit" value="student" class="actionBtn" id="completeBtn">가입완료</button>
                <p class="otherBtn prevBtn">이전</p>
            </div>
        </form>
    </div>
    <p class="copy">Copyright © 2021 CLASSFEED.</p>
</div>
</body>
<script>




</script>
</html>
