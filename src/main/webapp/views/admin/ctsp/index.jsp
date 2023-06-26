<%@ page language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>SD17306</title>
    <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
    <%@ taglib prefix="f" uri="jakarta.tags.functions" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.0.17/dist/sweetalert2.all.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/sweetalert2@11.0.17/dist/sweetalert2.min.css">
    <style>
        nav{
            padding-bottom: 200px;
        }
    </style>
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
        integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"
        integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD"
        crossorigin="anonymous"></script>

<%@ include file="../../tieu_de/header.jsp" %>
<br>
<div class="row">
    <div class="col-md-3"></div>
    <div class="col-md-6">
        <form class="d-flex" role="search" action="/chi-tiet-san-pham/search">
            <input name="keyword" class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success" type="submit">Search</button>
        </form>
    </div>
</div>
<br>

<c:if test="${f:length(data.content) == 0}">
    <h1 style="text-align: center">không có dữ liệu</h1>
    <a class="btn btn-primary" href="/chi-tiet-san-pham/create">Thêm mới</a>
</c:if>


<c:if test="${f:length(data.content) != 0}">
    <div class="container">
        <div class="row">
            <div class="col-md-5"></div>
            <div class="col-md-5">
                <h1 style="align-items: center">Quản lý CTSP</h1>
            </div>
        </div>
        <a class="btn btn-primary" href="/chi-tiet-san-pham/create">Thêm mới</a>
        <table class="table">
            <thead>
            <th scope="col">ID SP</th>
            <th scope="col">ID NSX</th>
            <th scope="col">ID DongSP</th>
            <th scope="col">ID Màu sắc</th>
            <th scope="col">Năm BH</th>
            <th scope="col">Mô tả</th>
            <th scope="col">Số lượng tồn</th>
            <th scope="col">Giá nhập</th>
            <th scope="col">Giá bán</th>
            <th colspan="2">Thao tác</th>
            </thead>
            <tbody>
            <c:forEach items="${ data.content }" var="ctsp">
                <tr>
                    <td>${ ctsp.sanPham.ten }</td>
                    <td>${ ctsp.nhaSanXuat.ten }</td>
                    <td>${ ctsp.mauSac.ten }</td>
                    <td>${ ctsp.dongSP.ten }</td>
                    <td>${ ctsp.namBaoHanh }</td>
                    <td>${ ctsp.moTa }</td>
                    <td>${ ctsp.soLuongTon }</td>
                    <td>${ ctsp.giaNhap }</td>
                    <td>${ ctsp.giaBan }</td>

                    <td>
                        <a class="btn btn-warning" href="/chi-tiet-san-pham/edit/${ctsp.id}">Cập nhật</a>
                        <a class="btn btn-danger" href="/chi-tiet-san-pham/delete/${ctsp.id}" onclick="return confirm('Bạn có chắc chắn muốn xóa?')">Xóa</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>

        </table>

        <nav aria-label="Page navigation example">
            <ul class="pagination">
                <c:forEach begin="0" end="${ data.totalPages -1}" varStatus="loop">
                    <li class="page-item">
                        <a class="page-link" href="/chi-tiet-san-pham/index?page=${loop.begin + loop.count - 1}">
                                ${loop.begin + loop.count }
                        </a>
                    </li>
                </c:forEach>
            </ul>
        </nav>
    </div>

</c:if>
<%@ include file="../../tieu_de/footer.jsp" %>
</body>
</html>