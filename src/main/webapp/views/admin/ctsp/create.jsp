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
                <h1 style="align-items: center">Quản lý CTSP</h1>
            </div>
        </div>
        <div class="row">
            <div class="col-md-2"></div>
            <div class="col-md-8">
                <div class="mb-3">
                    <label class="form-label">ID SP </label>
                    <sf:select path="sanPham" name="sanPham" class="form-select">
                        <c:forEach items="${listSP}" var="sp">
                            <option selected hidden value="${sp.id}">${vm.sanPham.ten}</option>
                            <form:option value="${sp.id}">${sp.ten}</form:option>
                        </c:forEach>
                    </sf:select>
                </div>
            </div>
        </div>


        <div class="row">
            <div class="col-md-2"></div>
            <div class="col-md-8">
                <div class="mb-3">
                    <label class="form-label">ID NSX </label>
                    <sf:select path="nhaSanXuat" name="nhaSanXuat" class="form-select">
                        <c:forEach items="${listNSX}" var="nsx">
                            <option selected hidden value="${nsx.id}">${vm.nhaSanXuat.ten}</option>
                            <form:option value="${nsx.id}">${nsx.ten}</form:option>
                        </c:forEach>
                    </sf:select>
                </div>
            </div>
        </div>


        <div class="row">
            <div class="col-md-2"></div>
            <div class="col-md-8">
                <div class="mb-3">
                    <label class="form-label">ID Màu Sắc </label>
                    <sf:select path="mauSac" name="mauSac" class="form-select">
                        <c:forEach items="${listMS}" var="ms">
                            <option selected hidden value="${ms.id}">${vm.mauSac.ten}</option>
                            <form:option value="${ms.id}">${ms.ten}</form:option>
                        </c:forEach>
                    </sf:select>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-2"></div>
            <div class="col-md-8">
                <div class="mb-3">
                    <label class="form-label">ID Dòng SP </label>
                    <sf:select path="dongSP" name="dongSP" class="form-select">
                        <c:forEach items="${listDSP}" var="dsp">
                           <option selected hidden value="${dsp.id}">${vm.dongSP.ten}</option>
                            <form:option value="${dsp.id}">${dsp.ten}</form:option>
                        </c:forEach>
                    </sf:select>
                </div>
            </div>
        </div>



        <div class="row">
            <div class="col-md-2"></div>
            <div class="col-md-8">
                <div class="mb-3">
                    <label class="form-label">Năm BH</label>
                    <sf:input type="number" path="namBaoHanh" class="form-control"/>
                    <sf:errors path="namBaoHanh" cssStyle="color: red"/>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-2"></div>
            <div class="col-md-8">
                <div class="mb-3">
                    <label class="form-label">Số lượng tồn</label>
                    <sf:input type="number" path="soLuongTon" class="form-control"/>
                    <sf:errors path="soLuongTon" cssStyle="color: red"/>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-2"></div>
            <div class="col-md-8">
                <div class="mb-3">
                    <label class="form-label">Mô tả</label>
                    <sf:input path="moTa" class="form-control"/>
                    <sf:errors path="moTa" cssStyle="color: red"/>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-2"></div>
            <div class="col-md-8">
                <div class="mb-3">
                    <label class="form-label">Giá nhập</label>
                    <sf:input type="number" path="giaNhap" class="form-control"/>
                    <sf:errors path="giaNhap" cssStyle="color: red"/>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-2"></div>
            <div class="col-md-8">
                <div class="mb-3">
                    <label class="form-label">Giá bán</label>
                    <sf:input type="number" path="giaBan" class="form-control"/>
                    <sf:errors path="giaBan" cssStyle="color: red"/>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-5"></div>
            <div class="col-md-5">
                <div class="mb-3">
                    <button class="btn btn-primary">Thêm</button>
                </div>
            </div>
        </div>
    </div>
</sf:form>
<%@ include file="../../tieu_de/footer.jsp" %>
</body>
</html>