#drop table product;

-- product cat_id:称为外键,它参照的是另外一张表的主键
create table product
(
   id                  int not null auto_increment,
   name                varchar(20),
   price               decimal(8,2),
   remark              longtext,
   date                timestamp default CURRENT_TIMESTAMP, 
   primary key (id)
);


/* 数据入库测试*/
insert into product (name,price,remark) values ('computer',3000.00,'test....');
insert into product (name,price,remark) values ('computer',2000.00,'text....');

select * from product;