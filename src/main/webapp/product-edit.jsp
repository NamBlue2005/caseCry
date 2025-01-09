<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Sửa Sản Phẩm</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h1 class="text-center mb-4">Sửa Sản Phẩm</h1>
    <form action="editProduct" method="POST" class="p-4 border rounded">
        <input type="hidden" name="id" value="${param.id}">
        <div class="mb-3">
            <label for="name" class="form-label">Tên Sản Phẩm</label>
            <input type="text" class="form-control" id="name" name="name" value="${param.name}" required>
        </div>
        <div class="mb-3">
            <label for="type" class="form-label">Loại</label>
            <input type="text" class="form-control" id="type" name="type" value="${param.type}" required>
        </div>
        <div class="mb-3">
            <label for="price" class="form-label">Giá</label>
            <input type="number" step="0.01" class="form-control" id="price" name="price" value="${param.price}" required>
        </div>
        <div class="mb-3">
            <label for="stockQuantity" class="form-label">Số Lượng Trong Kho</label>
            <input type="number" class="form-control" id="stockQuantity" name="stockQuantity" value="${param.stockQuantity}" required>
        </div>
        <div class="mb-3">
            <label for="imageUrl" class="form-label">URL Hình Ảnh</label>
            <input type="url" class="form-control" id="imageUrl" name="imageUrl" value="${param.imageUrl}" required>
        </div>
        <div class="mb-3">
            <label for="description" class="form-label">Mô Tả</label>
            <textarea class="form-control" id="description" name="description" rows="3" required>${param.description}</textarea>
        </div>
        <button type="submit" class="btn btn-primary">Cập Nhật</button>
        <a href="products" class="btn btn-secondary">Hủy</a>
    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>