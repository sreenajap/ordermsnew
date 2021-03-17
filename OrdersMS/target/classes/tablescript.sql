drop database `orderManagement`;
create schema `orderManagement`;
use orderManagement;

drop table orderdetails;
drop table productsordered;

create table orderdetails(
ORDERID int primary key AUTO_INCREMENT,
BUYERID int not null,
AMOUNT decimal(10,2) not null,
DATE date,
ADDRESS varchar(100) not null,
STATUS varchar(60) not null);

create table productsordered(
BUYERID int,
PRODID int,
SELLERID int not null,
QUANTITY int not null,
primary key(BUYERID,PRODID));

show tables;

describe orderdetails;
describe productsordered;

INSERT INTO orderdetails (orderid,buyerid,amount,date,address,status)
VALUES (1,11,12345,'2020-01-28','HYD','ORDER_PLACED');
INSERT INTO orderdetails (orderid,buyerid,amount,date,address,status)
VALUES (2,12,999.00,'2020-02-28','Delhi','ORDER_PLACED');

INSERT INTO productsordered (buyerid,prodid,sellerid,quantity)
VALUES (11,1,4,1);
INSERT INTO productsordered (buyerid,prodid,sellerid,quantity)
VALUES (12,3,7,1);


select * from orderdetails;

select * from productsordered;