package test;

import repository.CustomerRepository;

public class TestDeleteCustomer {
    public static void main(String[] args) {
        CustomerRepository.deleteCustomer(1);

        // Kiểm tra xem có Errors hoặc Exceptions nào xuất hiện trong console không
        System.out.println("Đã thử xóa CustomerID = 1.");
    }
}