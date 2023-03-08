--h2 is typically used to setup a test database, not a prod database.
--first, drop your tables (to reset your database for testing)
--then create your tables
drop table if exists account;
create table account (
    account_id int primary key auto_increment,
    username varchar(255) unique,
    password varchar(255)
);