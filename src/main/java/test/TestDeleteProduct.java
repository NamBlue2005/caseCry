package test;

import repository.ProductRepository;

public class TestDeleteProduct {
    public static void main(String[] args) {
        ProductRepository.deleteProduct(1);
        System.out.println("Đã xóa sản phẩm có ProductID = 1.");
    }
}