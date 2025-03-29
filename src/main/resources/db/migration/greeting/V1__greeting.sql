create table Greeting (
    id bigint not null, 
    name varchar(255), 
    primary key (id)
    );
create sequence Greeting_SEQ start with 1 increment by 50;
