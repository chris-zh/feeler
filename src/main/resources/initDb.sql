--user表
create table user(
id int unsigned not null auto_increment primary key,
name text not null,
password text not null
);


--oracle版本
create table tmp_user(
id number,
name varchar2(100),
password varchar2(100)
);
