package servlet;

import model.Customer;
import repository.CustomerRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterCustomerServlet", urlPatterns = {"/registerCustomer"})
public class RegisterCustomerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Thiết lập mã hóa UTF-8 để hỗ trợ tiếng Việt
        request.setCharacterEncoding("UTF-8");

        // Lấy dữ liệu từ form đăng ký
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String gender = request.getParameter("gender");
        String password = request.getParameter("password");

        String registerError = null;

        // Kiểm tra dữ liệu đầu vào
        if (name == null || name.trim().isEmpty()) {
            registerError = "Tên không được để trống!";
        } else if (email == null || email.trim().isEmpty()) {
            registerError = "Email không được để trống!";
        } else if (CustomerRepository.isEmailDuplicate(email)) {
            registerError = "Email đã tồn tại!";
        } else if (phone == null || phone.trim().isEmpty()) {
            registerError = "Số điện thoại không được để trống!";
        } else if (CustomerRepository.isPhoneDuplicate(phone)) {
            registerError = "Số điện thoại đã tồn tại!";
        }

        // Nếu có lỗi
        if (registerError != null) {
            request.setAttribute("registerError", registerError);
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }

        // Nếu dữ liệu hợp lệ, tạo đối tượng khách hàng
        Customer customer = new Customer(0, name, phone, email, address, gender, password);

        // Gọi repository để thêm khách hàng vào cơ sở dữ liệu
        try {
            CustomerRepository.addCustomer(customer);
            // Chuyển hướng đến trang welcome nếu đăng ký thành công
            response.sendRedirect("welcome.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            // Xử lý lỗi khi lưu khách hàng
            request.setAttribute("registerError", "Đã xảy ra lỗi trong quá trình đăng ký. Vui lòng thử lại!");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("register.jsp").forward(request, response);
    }
}