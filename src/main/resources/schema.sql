DROP TABLE products IF EXISTS;

CREATE TABLE products (

    id                  integer identity primary key,
    name                varchar(255) not null,
    sku                 varchar(255) not null,
    short_description   varchar(200) null,
    description         varchar(255) null,
    price               decimal not null,

);