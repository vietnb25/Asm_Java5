<%@ page language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>SD17306</title>
    <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
    <%@ taglib prefix="f" uri="jakarta.tags.functions" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.0.17/dist/sweetalert2.all.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/sweetalert2@11.0.17/dist/sweetalert2.min.css">
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
<sf:form action="${action}" method="post"
         modelAttribute="vm">
    <div class="container">
        <div class="row">
            <div class="col-md-5"></div>
            <div class="col-md-5">
                <h1 style="align-items: center">Quản lý Khách hàng</h1>
            </div>
        </div>
        <div class="row">
            <div class="col-md-2"></div>
            <div class="col-md-8">
                <div class="mb-3">
                    <label class="form-label">Mã</label>
                    <sf:input type="text" path="ma" class="form-control"/>
                    <sf:errors path="ma" cssStyle="color: red"/>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-2"></div>
            <div class="col-md-8">
                <div class="mb-3">
                    <label>Tên</label>
                    <sf:input path="ten" class="form-control"/>
                    <sf:errors path="ten" cssStyle="color: red"/>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-2"></div>
            <div class="col-md-8">
                <div class="mb-3">
                    <label>Tên Đệm</label>
                    <sf:input path="tenDem" class="form-control"/>
                    <sf:errors path="tenDem" cssStyle="color: red"/>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-2"></div>
            <div class="col-md-8">
                <div class="mb-3">
                    <label>Họ</label>
                    <sf:input path="ho" class="form-control"/>
                    <sf:errors path="ho" cssStyle="color: red"/>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-2"></div>
            <div class="col-md-8">
                <div class="mb-3">
                    <label>Ngày sinh</label>
                    <sf:input type="date" path="ngaySinh" class="form-control"/>
                    <sf:errors path="ngaySinh" cssStyle="color: red"/>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-2"></div>
            <div class="col-md-8">
                <div class="mb-3">
                    <label>Địa chỉ</label>
                    <sf:input path="diaChi" class="form-control"/>
                    <sf:errors path="diaChi" cssStyle="color: red"/>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-2"></div>
            <div class="col-md-8">
                <div class="mb-3">
                    <div>
                        <label>sdt</label>
                        <sf:input path="sdt" class="form-control"/>
                        <sf:errors path="sdt" cssStyle="color: red"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-2"></div>
            <div class="col-md-8">
                <div class="mb-3">
                    <label>Thành phố</label>
                    <sf:input path="thanhPho" class="form-control"/>
                    <sf:errors path="thanhPho" cssStyle="color: red"/>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-2"></div>
            <div class="col-md-8">
                <div class="mb-3">
                    <label>Quốc gia</label>
                    <sf:input path="quocGia" class="form-control"/>
                    <sf:errors path="quocGia" cssStyle="color: red"/>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-2"></div>
            <div class="col-md-8">
                <div class="mb-3">
                    <label>matKhau</label>
                    <sf:input path="matKhau" class="form-control"/>
                    <sf:errors path="matKhau" cssStyle="color: red"/>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6"></div>
            <div class="col-md-6">
                <div class="mb-3">
                    <button class="btn btn-primary">Thêm</button>
                </div>
            </div>
        </div>



    </div>
    <%@ include file="../../tieu_de/footer.jsp" %>
</sf:form>

</body>
</html>