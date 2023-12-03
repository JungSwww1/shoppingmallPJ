CREATE DATABASE IF NOT EXISTS ssafit DEFAULT CHARACTER SET utf8mb4;

USE ssafit;

-- 물품 테이블
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
	`id` INT AUTO_INCREMENT,
	`itemNm` VARCHAR(20) NOT NULL,
	`price` INT NOT NULL,
	`stockNumber` INT NOT NULL, 
    `itemDetail` TEXT,
    `view_cnt` INT DEFAULT 0,
    `regTime` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updateTime` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `category` VARCHAR(20) DEFAULT NULL,
    `purchaseCnt` INT DEFAULT 0,
	`img` LONGTEXT DEFAULT NULL,
    `avg_rating` DOUBLE(3, 2),
    PRIMARY KEY(`id`)
);

-- 유저 테이블
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `user_seq` INT AUTO_INCREMENT,
  `id` varchar(40) NOT NULL,
  `password` varchar(40) NOT NULL,
  `name` varchar(40) NOT NULL,
  `address` TEXT,
  `email` VARCHAR(40),
  `number` VARCHAR(30),
  `admin` TINYINT(1) NOT NULL DEFAULT 0,
  `exist` TINYINT(1) NOT NULL DEFAULT 1,
  PRIMARY KEY (`user_seq`)
) ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;


-- 장바구니 테이블
CREATE TABLE `cart` (
  `id` INT AUTO_INCREMENT,
  `user_id` varchar(40) NOT NULL,
  `product_id` INT NOT NULL,
  `product_price` INT NOT NULL,
  `product_cnt` INT NOT NULL,
  FOREIGN KEY (`product_id`) REFERENCES product (`id`),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;

-- order 테이블
create table `order` (
	`order_id` INT AUTO_INCREMENT PRIMARY KEY,
    `user_id` VARCHAR(40),
    `orderTime` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    `address` VARCHAR(500)
);

-- order가 for문 돌려서 만든 product
CREATE TABLE `order_product` (
 `order_id` INT,
 `product_id` INT,
 `product_count` INT,
 `price` INT,
 `reviewCheck` TINYINT(1) DEFAULT 0 
);

-- review 테이블
CREATE TABLE `review` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `product_id` INT NOT NULL,
    `user_id` VARCHAR(40) NOT NULL,
    `content` TEXT,
    `reg_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    `rating` INT NOT NULL,
    FOREIGN KEY (`product_id`) REFERENCES product (`id`)
);

-- 물품 추가
INSERT INTO `product` (`itemNm`, `price`, `stockNumber`, `itemDetail`, `category`, `purchaseCnt`, `img`)
VALUES 
('티셔츠', 15000, 50, '여름용 티셔츠', '옷', 210, 'https://assets.burberry.com/is/image/Burberryltd/88A5E863-E59A-4034-A576-F33A9A71B036?$BBY_V3_SL_1$&wid=1501&hei=1500'),
('청바지', 30000, 40, '일자핏 청바지', '옷', 1234, 'https://kindame.co.kr/web/product/tiny/202304/e80ea31325b58ad2af0d78f4568db22c.jpg'),
('의자', 50000, 20, '목재 의자', '기구', 51233, 'https://www.westelm.co.kr/upload/goods/U80000362701/U80000362701_01_1_1000.jpg'),
('책상', 70000, 15, '스틸 책상', '기구', 12, 'https://i.namu.wiki/i/u8Qv8l2kwXCT7K_M5Vt2c_i_-O6UwVK470gwec4GcarM2KKRz5vV6SPylgG82Y2V6hvbLIaSnSGk5SF6Q7P3IQ.webp'),
('사과', 2000, 100, '신선한 사과', '음식', 34415, 'https://health.chosun.com/site/data/img_dir/2023/06/20/2023062002262_0.jpg'),
('치즈', 7000, 80, '고급 치즈', '음식', 231, 'https://src.hidoc.co.kr/image/lib/2023/5/19/1684461371654_0.jpg'),
('닭가슴살', 1000, 60, '닭가슴살 1kg', '프로틴', 4667, 'https://health.chosun.com/site/data/img_dir/2023/07/28/2023072802135_0.jpg'),
('헬스바', 300, 120, '단백질 바', '프로틴', 826, 'https://img.danawa.com/prod_img/500000/639/188/img/8188639_1.jpg?_v=20191227105122'),
('원피스', 25000, 30, '여름용 원피스', '옷', 4, 'https://qi-o.qoo10cdn.com/goods_image_big/7/6/6/0/9365797660_l.jpg'),
('반바지', 20000, 35, '시원한 반바지', '옷', 5463, 'https://cdn.011st.com/11dims/resize/600x600/quality/75/11src/product/4225846660/B.jpg?768000000'),
('책장', 60000, 25, '목재 책장', '기구', 45, 'https://m.brownfactory.co.kr/web/product/big/202010/26cfd77118a4904d222743a07e9aa20c.jpg'),
('책상의자세트', 120000, 10, '고급 책상의자세트', '기구', 1, 'https://naraegagu.com/web/product/big/201809/9caef6749ed317513803064bc236dcd9.jpg'),
('바나나', 3000, 90, '달콤한 바나나', '음식', 677, 'https://cdn.healthinnews.co.kr/news/photo/202307/39252_40878_352.jpg'),
('빵', 5000, 70, '신선한 빵', '음식', 234, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS5MQox-p4KrW9ulCjm-7HW8vEdp9J4A7EnVFf-c64XSBwyfFZlHsiRmMbBDaw8NwOwQH4&usqp=CAU'),
('와이어피트니스', 40000, 45, '와이어피트니스 장비', '기구', 925, 'https://cdn.011st.com/11dims/resize/600x600/quality/75/11src/product/4738039399/B.jpg?200000000'),
('단백질파우더', 25000, 55, '단백질 보충제', '프로틴', 754, 'https://usefulguide.net/wp-content/uploads/2023/08/%EC%8B%A0%ED%83%806.jpg.webp'),
('스커트', 18000, 25, '여성용 스커트', '옷', 234, 'https://atimg.sonyunara.com/files/attrangs/goods/61703/5f34f28326db8.jpg'),
('셔츠', 22000, 30, '남성용 셔츠', '옷', 211, 'https://i.namu.wiki/i/XZj1yqxeni8F9AeAAi8Hr0TaaEOlYPQRCplBmCKX5pBimrGy5w0zERQC900m9_NbA5SvPpMfKh3x7K_eFT2mbg.webp'),
('침대', 200000, 5, '킹사이즈 침대', '기구', 567, 'https://m.superhome.kr/web/product/big/202212/f0b78a427d2574aa01dc55b21dd73ab4.jpg'),
('거실장', 150000, 812, '거실에 잘 어울리는 장', '기구', 1232, 'https://www.emons.co.kr/brand/img/prdt/10198_04.jpg'),
('후리스', 15000, 8223, '스타일리시한 디자인의 후리스 제품입니다.', '옷', 0, 'https://saehan0915.cdn-nhncommerce.com/data/goods/20/12/51/8248/8248_detail_068.jpg'),
('가죽자켓', 70000, 214623, '어디에든 잘 어울리는 가죽 자켓으로 스타일리시한 룩을 연출할 수 있습니다.', '옷', 0, 'https://m.belivus.co.kr/web/product/big/202103/a6214b7bf3b82a4391bb5c6e0f6ad373.png'),
('패딩', 130000, 1235, '보온성이 뛰어나며 따뜻한 겨울을 보내기에 적합한 패딩 제품입니다.', '옷', 0, 'https://www.emons.co.kr/brand/img/prdt/10198_04.jpg'),
('가디건', 30000, 234, '간편하면서도 스타일리시한 가디건으로 다양한 스타일에 맞춰 입을 수 있습니다.', '옷', 0, 'https://m.urbanfranc.com/web/product/big/202101/32e9cf1286e1079e51f7a9bc68d58288.jpg'),
('맨투맨', 20000, 2, '편안하고 스타일리시한 맨투맨 제품입니다.', '옷', 0, 'https://static.discovery-expedition.com/images/goods/ec/X23FDXMT33034BES/thnail/67B07488919347A498DBD56C772590DF.png/dims/resize/828x1104'),
('연청바지', 40000, 100, '연청 디자인으로 스타일을 더해주는 바지 제품입니다.', '옷', 0, 'https://m.need-you.co.kr/web/product/big/202303/c7a9896fbb18754fa809a956b0d7198b.gif'),
('모자', 15000, 200, '다양한 스타일에 잘 어울리는 모자 제품입니다.', '옷', 0, 'https://iamcap.com/web/product/medium/201705/19157_shop1_468069.jpg');


-- 유저 추가
INSERT INTO `users` (`id`, `password`, `name`, `address`, `email`, `number`, `admin`)
VALUES 
('user1', '123', 'John Doe', '123 Main St, CityA, CountryA', 'john@example.com', '123-456-7890', 0),
('user2', '456', 'Jane Smith', '456 Elm St, CityB, CountryB', 'jane@example.com', '987-654-3210', 1),
('user3', '789', 'Alice Johnson', '789 Oak St, CityC, CountryC', 'alice@example.com', '555-123-4567', 0),
('user4', '321', 'Bob Brown', '321 Pine St, CityD, CountryD', 'bob@example.com', '333-333-3333', 0),
('user5', '654', 'Emily Davis', '654 Cedar St, CityE, CountryE', 'emily@example.com', '222-222-2222', 1),
('user6', '987', 'Chris Wilson', '987 Walnut St, CityF, CountryF', 'chris@example.com', '999-999-9999', 0),
('user7', '135', 'Olivia Martinez', '135 Birch St, CityG, CountryG', 'olivia@example.com', '777-777-7777', 0),
('user8', '246', 'William Anderson', '246 Maple St, CityH, CountryH', 'william@example.com', '888-888-8888', 1),
('user9', '789', 'Sophia Taylor', '789 Oak St, CityI, CountryI', 'sophia@example.com', '666-666-6666', 0),
('user10', '109', 'Daniel Thomas', '109 Pine St, CityJ, CountryJ', 'daniel@example.com', '444-444-4444', 0),
('user11', '112', 'Ava Hernandez', '112 Cedar St, CityK, CountryK', 'ava@example.com', '111-111-1111', 1),
('user12', '113', 'Michael Perez', '113 Walnut St, CityL, CountryL', 'michael@example.com', '000-000-0000', 0),
('user13', '114', 'Mia Gonzalez', '114 Birch St, CityM, CountryM', 'mia@example.com', '101-101-1010', 0),
('user14', '115', 'Alexander Carter', '115 Maple St, CityN, CountryN', 'alexander@example.com', '202-202-2020', 1),
('user15', '116', 'Sofia King', '116 Oak St, CityO, CountryO', 'sofia@example.com', '303-303-3030', 0),
('user16', '117', 'James Lee', '117 Pine St, CityP, CountryP', 'james@example.com', '404-404-4040', 0),
('user17', '118', 'Amelia Wood', '118 Cedar St, CityQ, CountryQ', 'amelia@example.com', '505-505-5050', 1),
('user18', '119', 'Ethan Scott', '119 Walnut St, CityR, CountryR', 'ethan@example.com', '606-606-6060', 0),
('user19', '120', 'Abigail Green', '120 Birch St, CityS, CountryS', 'abigail@example.com', '707-707-7070', 0),
('user20', '121', 'Charlotte Evans', '121 Maple St, CityT, CountryT', 'charlotte@example.com', '808-808-8080', 1);

--  insert into cart (user_id, product_id, product_price, product_cnt) VALUES (1, 1 , 100, 1);
select * from product;
 select * from cart;
 select * from users;
 select * from `order`;
 select * from order_product;
 select * from review;
 
commit;

