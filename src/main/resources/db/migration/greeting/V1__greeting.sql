create table Greeting (
    id bigint GENERATED ALWAYS AS IDENTITY, 
    name varchar(255), 
    primary key (id)
    );
