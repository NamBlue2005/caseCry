# caseCry
USE quanlybanhangcongnghe;

USE quanlybanhangcongnghe;

-- Bảng Sản phẩm
CREATE TABLE Product (
ProductID INT AUTO_INCREMENT PRIMARY KEY,
ProductName VARCHAR(255) NOT NULL,
ProductType VARCHAR(100),
Price DECIMAL(10, 2) NOT NULL,
StockQuantity INT NOT NULL,
ImageURL VARCHAR(255),
Description TEXT
);

-- Bảng Khách hàng
CREATE TABLE Customer (
CustomerID INT AUTO_INCREMENT PRIMARY KEY,
Name VARCHAR(255) NOT NULL,
Phone VARCHAR(20),
Email VARCHAR(100) UNIQUE,
Address TEXT,
Gender VARCHAR(10),
Password VARCHAR(255) NOT NULL
);

-- Bảng Giỏ hàng
CREATE TABLE Cart (
CartID INT AUTO_INCREMENT PRIMARY KEY,
CustomerID INT NOT NULL,
CreatedAt DATETIME DEFAULT CURRENT_TIMESTAMP,
UpdatedAt DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
FOREIGN KEY (CustomerID) REFERENCES Customer(CustomerID)
);

-- Bảng Chi tiết Giỏ hàng
CREATE TABLE CartItem (
CartItemID INT AUTO_INCREMENT PRIMARY KEY,
CartID INT NOT NULL,
ProductID INT NOT NULL,
Quantity INT NOT NULL DEFAULT 1,
Price DECIMAL(10, 2),
FOREIGN KEY (CartID) REFERENCES Cart(CartID),
FOREIGN KEY (ProductID) REFERENCES Product(ProductID)
);

-- Bảng Đơn hàng
CREATE TABLE Orders (
OrderID INT AUTO_INCREMENT PRIMARY KEY,
CustomerID INT NOT NULL,
OrderDate DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
TotalAmount DECIMAL(15, 2),
OrderStatus VARCHAR(50),
FOREIGN KEY (CustomerID) REFERENCES Customer(CustomerID)
);

-- Bảng Chi tiết Đơn hàng
CREATE TABLE OrderDetail (
OrderDetailID INT AUTO_INCREMENT PRIMARY KEY,
OrderID INT NOT NULL,
ProductID INT NOT NULL,
Quantity INT NOT NULL,
Price DECIMAL(10, 2) NOT NULL,
FOREIGN KEY (OrderID) REFERENCES Orders(OrderID),
FOREIGN KEY (ProductID) REFERENCES Product(ProductID)
);

-- Bảng Quản trị viên
CREATE TABLE Admin (
AdminID INT AUTO_INCREMENT PRIMARY KEY,
Username VARCHAR(100) NOT NULL UNIQUE,
Password VARCHAR(255) NOT NULL,
Email VARCHAR(100) UNIQUE
);

INSERT INTO Product (ProductName, ProductType, Price, StockQuantity, ImageURL, Description)
VALUES
('iPhone 14 Pro Max', 'Smartphone', 29999.99, 50, 'https://example.com/iphone14.jpg', 'Flagship smartphone by Apple'),
('MacBook Pro 16', 'Laptop', 59999.99, 30, 'https://example.com/macbook_pro.jpg', 'Professional laptop by Apple'),
('Apple Watch Series 8', 'Smartwatch', 9999.99, 100, 'https://example.com/apple_watch.jpg', 'Smartwatch with advanced health tracking'),
('AirPods Pro 2', 'True Wireless Earbuds', 4999.99, 200, 'https://example.com/airpods_pro.jpg', 'Noise-cancelling wireless earbuds'),
('iPad Air 5', 'Tablet', 15999.99, 20, 'https://example.com/ipad_air.jpg', 'Lightweight tablet with powerful features'),
('iMac 24', 'Desktop Computer', 39999.99, 15, 'https://example.com/imac.jpg', 'All-in-one desktop computer by Apple'),
('Apple TV 4K', 'Streaming Device', 3499.99, 70, 'https://example.com/apple_tv.jpg', '4K HDR streaming device by Apple'),
('HomePod Mini', 'Smart Speaker', 2999.99, 100, 'https://example.com/homepod_mini.jpg', 'Compact smart speaker for home'),
('MagSafe Charger', 'Charger', 999.99, 250, 'https://example.com/magsafe_charger.jpg', 'Magnetic wireless charger by Apple'),
('Apple Pencil 2', 'Accessory', 2999.99, 40, 'https://example.com/apple_pencil.jpg', 'Stylus for iPad Pro and iPad Air');

    INSERT INTO Customer (Name, Phone, Email, Address, Gender, Password)
VALUES
('Nguyen Van A', '0123456789', 'a@example.com', '123 Đường 1, TP Hồ Chí Minh', 'Male', 'password123'),
('Tran Thi B', '0987654321', 'b@example.com', '456 Đường 2, Hà Nội', 'Female', 'password123'),
('Le Van C', '0331234567', 'c@example.com', '789 Đường 3, Đà Nẵng', 'Male', 'password123'),
('Pham Thi D', '0776543210', 'd@example.com', '101 Đường 4, TP Hồ Chí Minh', 'Female', 'password123'),
('Nguyen Thi E', '0356789101', 'e@example.com', '202 Đường 5, Hà Nội', 'Female', 'password123'),
('Tran Van F', '0901234568', 'f@example.com', '303 Đường 6, Đà Nẵng', 'Male', 'password123'),
('Le Thi G', '0367890102', 'g@example.com', '404 Đường 7, TP Hồ Chí Minh', 'Female', 'password123'),
('Pham Van H', '0934567892', 'h@example.com', '505 Đường 8, Hà Nội', 'Male', 'password123'),
('Nguyen Van I', '0345678901', 'i@example.com', '606 Đường 9, Đà Nẵng', 'Male', 'password123'),
('Tran Thi J', '0778901234', 'j@example.com', '707 Đường 10, TP Hồ Chí Minh', 'Female', 'password123');

    INSERT INTO Admin (Username, Password, Email)
VALUES
('admin1', 'password123', 'admin1@apple.com'),
('admin2', 'password123', 'admin2@apple.com'),
('admin3', 'password123', 'admin3@apple.com');

    SELECT * FROM Cart;
    INSERT INTO Cart (CustomerID)
VALUES
(1), -- Tạo giỏ hàng cho Nguyen Van A (CustomerID = 1)
(2), -- Tạo giỏ hàng cho Tran Thi B (CustomerID = 2)
(3); -- Tạo giỏ hàng cho Le Van C (CustomerID = 3)