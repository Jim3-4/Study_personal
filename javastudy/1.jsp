<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file = "/include.jspf" %>
<link rel="stylesheet" type="text/css" href="<%=contextPath %>/kor/css/common.css">
<script src="<%=contextPath %>/kor/js/common.js"></script>


<header class="header"><!-- 상단 고정 fixed 클래스 추가, 메뉴의 depth1 오버시 open 클래스 추가 -->

   <div class="headArea">
            <strong class="hLogo"><a href="/" class="logo" title="메인으로 이동"><img src="<%=contextPath %>/kor/images/common/logo.png" alt="맥도날드"></a></strong>
            <nav class="hMenu">
               <div class="menu">
                  <ul class="depth1">
                     <li><!-- li 오버시 on 클래스 추가 -->
                        <a href="javascript:gotoMenu(1);" class="dth1 ">Menu</a><!-- 현재페이지 메뉴에 current 클래스 추가 -->
                        <ul class="depth2">
                           <li><a href="javascript:gotoMenu(1);" class="dth2">버거</a></li>
                           <li><a href="javascript:gotoMenu(14);" class="dth2">맥런치</a></li>
                           <li><a href="javascript:gotoMenu(3);" class="dth2">맥모닝</a></li>
                           <li><a href="javascript:gotoMenu(15);" class="dth2">해피 스낵</a></li>
                           <li><a href="javascript:gotoMenu(7);" class="dth2">사이드 &amp; 디저트</a></li>
                           <li><a href="javascript:gotoMenu(9);" class="dth2">맥카페 &amp; 음료</a></li>
                           <li><a href="javascript:gotoMenu(5);" class="dth2">해피밀</a></li>
                           <!-- <li><a href="javascript:gotoMenu(11);" class="dth2">365일 즐거운 혜택</a></li> -->
                        </ul>
                     </li>
                     <li>
                        <a href="/kor/store/main.do" class="dth1 ">Store</a>
                        <ul class="depth2">
                           <li><a href="/kor/store/main.do" class="dth2">매장찾기</a></li>
                           <li><a href="/kor/store/mcdelivery.do" class="dth2">맥딜리버리</a></li>
                           <li><a href="/kor/store/mcdrive.do" class="dth2">맥드라이브</a></li>
                           <li><a href="/kor/store/rental.do" class="dth2">임차문의</a></li>
                        </ul>
                     </li>
                     <li>
                        <a href="/kor/promotion/list.do" class="dth1  ">What’s New</a>
                        <ul class="depth2">
                           <li><a href="/kor/promotion/list.do" class="dth2">프로모션</a></li>
                           <li><a href="/kor/news/list.do" class="dth2">새로운 소식</a></li>
                           <!--  li><a href="/kor/kitchen.do" class="dth2">주방공개의 날</a></li -->
                            <li><a href="/kor/happymeal/list.do" class="dth2">이달의 해피밀</a></li> 
                        </ul>
                     </li>
                     <li>
                        <a href="/kor/story/main.do" class="dth1  ">Story</a>
                        <ul class="depth2">
                           <li><a href="/kor/story/intro/brandintro.do" class="dth2">브랜드 소개</a></li>
                           <li><a href="/kor/story/society/list.do" class="dth2">사회적 책임과 지원</a></li>
                           <li><a href="/kor/story/competition/farmToRestaurant.do" class="dth2">맥도날드 품질 이야기</a></li>
                           <li><a href="/kor/story/people/crew.do" class="dth2">맥도날드 사람들</a></li>
                        </ul>
                     </li>
                  </ul>
               </div>
               <!-- //menu -->
               <form id="commonSearchForm" method="post">
               <div class="util">
                  <a href="/kor/store/rental.do" class="renter" title="임차문의로 이동">임차문의</a>               
                  <a href="/kor/story/people/recruit.do" class="recruit" title="인재채용으로 이동">RECRUIT</a>
                  <a href="/eng/main.do" class="lang" title="영문사이트로 이동">ENG</a>
                  <div class="topSearch"><!-- 검색 활성화인 경우 open 클래스 추가 -->
                     <button type="button" class="srch">검색 열기</button>
                     <fieldset class="srchField">
                        <legend>통합검색</legend>
                        <div class="form">
                           <input type="text" name="commonSearchWord" id="commonSearchWord" placeholder="매장 또는 메뉴정보를 검색하실 수 있습니다." title="검색어 입력" onkeypress="if( event.keyCode==13 ){gotoCommonSearch();}">
                           <button type="button" class="btnMC btnM" onclick="gotoCommonSearch()">검색하기</button>
                        </div>
                        <button type="button" class="close">검색 닫기</button>
                     </fieldset>
                  </div>
               </div>
               </form>
               <!-- //util -->
            </nav>
         </div>
      <form id="gotoMenuForm" method="post">
      <input type="hidden" name="sub_category_seq" id="gotoform_sub_category_seq">
      </form>
   <script>
         function gotoMenu(val){
            $("#gotoform_sub_category_seq").val(val);
            $("#gotoMenuForm").attr("action","/kor/menu/list.do");
            $("#gotoMenuForm").submit();
         }
         function gotoCommonSearch(){
            if($.trim($("#commonSearchWord").val())==""){
               alert("검색어을 입력해 주세요");
               $("#commonSearchWord").focus();
            }else{
               $("#commonSearchForm").attr("action","/kor/search.do");
               $("#commonSearchForm").submit();
            }
         }
   </script>
      </header>


</body></html>
