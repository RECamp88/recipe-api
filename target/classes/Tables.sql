drop table if exists recipe;
drop table if exists account;

create table account (
    account_id int primary key auto_increment,
    username varchar(255) unique,
    password varchar(255)
);
create table recipe (
    recipe_id int primary key auto_increment,
    posted_by int,
    recipe_name varchar(255),
    main_ingredient varchar(25),
    foreign key (posted_by) references account(account_id)
);