<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>장사 TIP</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.13.1/font/bootstrap-icons.min.css">
    <link rel="stylesheet" href="../style/common.css">
    <link rel="stylesheet" href="../style/bizTip.css">
</head>
<body>
<div class="container-fluid page-wrap">
    <!-- 공통 Header -->
    <%@ include file="../common/header.jsp" %>

    <div class="content">
        <!-- 공통 Side Navigation -->
        <%@ include file="../common/sideNav.jsp" %>
        <!-- ==================== MAIN ==================== -->
        <main class="main-content mt-2">
            <div class="d-flex justify-content-between align-items-center">
                <h2 class="mb-0">장사 TIP</h2>
                <button type="button" class="btn btn-primary">작성하기</button>
            </div>
            
            <!-- 게시글 목록 -->
            <div class="table-responsive mt-4">
                <table class="table table-hover text-center align-middle">
                    <tr class="table-light">
                        <th scope="col">제목</th>
                        <th scope="col">작성자</th>
                        <th scope="col">작성일</th>
                        <th scope="col">조회수</th>
                        <th scope="col">추천</th>
                    </tr>
                    <tr>
                        <td class="text-start">
                            <a href="#" class="text-decoration-none text-dark">오픈초기 마케팅 비용 아끼지마세요</a>
                            <span class="comment-count">[212]</span>
                        </td>
                        <td>신중동 불주먹</td>
                        <td>2026.09.23</td>
                        <td>1615</td>
                        <td>111</td>
                    </tr>
                </table>
            </div>

            <!-- 하단 -->
            <div class="bottom-area">
                <!-- 페이지네이션 -->
                <nav aria-label="게시판 페이지">
                    <ul class="pagination justify-content-center">
                        <li class="page-item"><a class="page-link" href="#">&lt;</a></li>
                        <li class="page-item active"><a class="page-link" href="#">1</a></li>
                        <li class="page-item"><a class="page-link" href="#">2</a></li>
                        <li class="page-item"><a class="page-link" href="#">3</a></li>
                        <li class="page-item"><a class="page-link" href="#">4</a></li>
                        <li class="page-item"><a class="page-link" href="#">5</a></li>
                        <li class="page-item"><a class="page-link" href="#">&gt;</a></li>
                    </ul>
                </nav>

                <!-- 검색 -->
                <div class="board-search">
                    <div class="input-group">
                        <select class="form-select search-select">
                            <option value="title">제목</option>
                            <option value="author">작성자</option>
                            <option value="content">내용</option>
                            <option value="titleContent">제목+내용</option>
                        </select>
                        <input type="text" class="form-control" placeholder="검색어 입력">
                        <button type="button" class="btn btn-outline-secondary">검색</button>
                    </div>
                </div>
            </div>
        </main>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>