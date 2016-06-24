--user表
create table user(
id int unsigned not null auto_increment primary key,
name text not null,
password text not null,
salt text
);


-- Create table
create table post
(
  id          int not null auto_increment primary key,
  title       text,
  content     text,
  create_time timestamp ,
  author_id   int
)

create table comment(
id int not null auto_increment primary key,
content text,
create_time timestamp ,
author_id int,
post_id int
);

ALTER TABLE qb.`user` ADD avatar text NULL;
ALTER TABLE qb.`user` ADD create_time TIMESTAMP NULL;
