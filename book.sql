-- auto-generated definition
create table book
(
    id          int           not null
        primary key,
    name        varchar(50)   not null,
    poster      varchar(80)   not null comment '封面路径',
    create_time datetime      not null,
    update_time datetime      not null,
    price       decimal(4, 2) not null,
    score       int           not null comment '图书评分'
);
INSERT INTO book.book (name, poster, create_time, update_time, price, score, c_id) VALUES ('前端入门', '/upload/a7d1098a-bb27-4a58-81f9-90a22a59166e_Java.jpg', '2021-04-11 18:57:18', '2021-04-11 18:57:22', 23.45, 4, 3);
INSERT INTO book.book (name, poster, create_time, update_time, price, score, c_id) VALUES ('JavaScript指南', '/upload/a7d1098a-bb27-4a58-81f9-90a22a59166e_Java.jpg', '2021-04-12 15:33:47', '2021-04-12 15:33:52', 12.23, 5, 3);
INSERT INTO book.book (name, poster, create_time, update_time, price, score, c_id) VALUES ('Java深入浅出', '/upload/a7d1098a-bb27-4a58-81f9-90a22a59166e_Java.jpg', '2021-04-12 15:34:56', '2021-04-12 15:35:01', 12.44, 3, 2);
INSERT INTO book.book (name, poster, create_time, update_time, price, score, c_id) VALUES ('serlet ', '/upload/a7d1098a-bb27-4a58-81f9-90a22a59166e_Java.jpg', '2021-04-12 18:21:02', '2021-04-12 18:21:02', 1.00, 1, 2);
INSERT INTO book.book (name, poster, create_time, update_time, price, score, c_id) VALUES ('mysql 指南', '/upload/39f2f867-2246-4de1-ab9d-3e2060d54201_Java.jpg', '2021-04-12 18:23:59', '2021-04-12 18:23:59', 12.00, 3, 5);
INSERT INTO book.book (name, poster, create_time, update_time, price, score, c_id) VALUES ('servless 入门', '/upload/ab413e81-61e6-4a83-a069-d3d9fd1f0081_Java.jpg', '2021-04-12 18:52:52', '2021-04-12 18:52:52', 12.00, 4, 7);
-- auto-generated definition
create table category
(
    id      int auto_increment
        primary key,
    book_id int          not null comment '图书id',
    c_name  varchar(100) not null comment '分类名称',
    create_time datetime      not null,
    update_time datetime      not null
);

INSERT INTO book.category (c_name, create_time, update_time) VALUES ('java', '2021-04-12 09:38:08', '2021-04-12 09:38:11');
INSERT INTO book.category (c_name, create_time, update_time) VALUES ('前端', '2021-04-12 09:30:04', '2021-04-12 09:30:12');
INSERT INTO book.category (c_name, create_time, update_time) VALUES ('数据库', '2021-04-12 12:24:18', '2021-04-12 12:24:18');
INSERT INTO book.category (c_name, create_time, update_time) VALUES ('云计算', '2021-04-12 12:28:45', '2021-04-12 12:28:45');
INSERT INTO book.category (c_name, create_time, update_time) VALUES ('运维', '2021-04-12 12:44:13', '2021-04-12 12:44:13');
INSERT INTO book.category (c_name, create_time, update_time) VALUES ('大数据', '2021-04-12 15:57:34', '2021-04-12 15:57:34');