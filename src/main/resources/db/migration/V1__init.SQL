create table public.tb_customer
(
    id         uuid         not null
        primary key,
    name       varchar(255) not null,
    email      varchar(255) not null
        constraint uka9xeibptr987g1od1c430m1w9
            unique,
    cpf        varchar(255) not null
        constraint uk1r2x5kcodv7u39r4k8jfk78b8
            unique,
    created_at timestamp(6) with time zone,
    updated_at timestamp(6) with time zone
);

alter table public.tb_customer
    owner to fastfood;

create table public.tb_product
(
    id          uuid           not null
        primary key,
    name        varchar(255)   not null,
    description varchar(255)   not null,
    category    varchar(255)   not null
        constraint tb_product_category_check
            check ((category)::text = ANY
        ((ARRAY ['SNACK'::character varying, 'SIDE_DISHES'::character varying, 'DRINK'::character varying, 'DESSERT'::character varying])::text[])),
    price       numeric(38, 2) not null,
    image_path  varchar(255),
    created_at  timestamp(6) with time zone,
    updated_at  timestamp(6) with time zone
);

alter table public.tb_product
    owner to fastfood;

