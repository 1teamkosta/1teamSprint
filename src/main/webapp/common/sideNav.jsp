<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<nav class="nav">
          <div class="bord">
            <div class="boardTitle">자유게시판</div>
            <ul>
              <li class="bordCard"><a href="#">자유수다</a></li>
            </ul>
          </div>

          <div class="bord">
            <div class="boardTitle">공지사항</div>
            <ul>
              <li class="bordCard"><a href="#">공지사항</a></li>
              <li class="bordCard"><a href="#">문의</a></li>
              <li class="bordCard"><a href="#">신고</a></li>
            </ul>
          </div>

          <div class="bord">
            <div class="boardTitle">정보공유</div>
            <ul>
              <li class="bordCard"><a href="#">장사TIP</a></li>
              <li class="bordCard"><a href="Controller?cmd=qnaListAction&page=1">Q&A</a></li>
              <li class="bordCard"><a href="#">동네소식</a></li>
            </ul>
          </div>

          <div class="bord">
            <div class="boardTitle">중고거래</div>
            <ul>
              <li class="bordCard"><a href="Controller?cmd=tradeListUI&page=1">중고거래</a></li>
            </ul>
          </div>

          <div class="navSearchBar">
            <input type="text" class="searchInput" />
            <button class="searchBtn">검색</button>
          </div>
        </nav>