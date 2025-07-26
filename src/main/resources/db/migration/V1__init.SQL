CREATE SEQUENCE sq_order_number START WITH 1 INCREMENT BY 1;

CREATE TABLE public.tb_customer (
    id UUID NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL CONSTRAINT uka9xeibptr987g1od1c430m1w9 UNIQUE,
    cpf VARCHAR(255) NOT NULL CONSTRAINT uk1r2x5kcodv7u39r4k8jfk78b8 UNIQUE,
    created_at TIMESTAMP(6) WITH TIME ZONE NOT NULL,
    updated_at TIMESTAMP(6) WITH TIME ZONE NOT NULL
);

ALTER TABLE public.tb_customer OWNER TO fastfood;

CREATE TABLE public.tb_product (
    id UUID NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    category VARCHAR(255) NOT NULL CONSTRAINT tb_product_category_check CHECK (
        (category)::TEXT = ANY (
            ARRAY[
                'SNACK'::VARCHAR,
                'SIDE_DISHES'::VARCHAR,
                'DRINK'::VARCHAR,
                'DESSERT'::VARCHAR
                ]::TEXT[]
            )
        ),
    price NUMERIC(38, 2) NOT NULL,
    image_path VARCHAR(255),
    created_at TIMESTAMP(6) WITH TIME ZONE NOT NULL,
    updated_at TIMESTAMP(6) WITH TIME ZONE NOT NULL
);

ALTER TABLE public.tb_product OWNER TO fastfood;

CREATE TABLE public.tb_order (
    id UUID NOT NULL PRIMARY KEY,
    customer_id UUID,
    number BIGINT NOT NULL CONSTRAINT ukaa9kfaca2r31rv3yi2jsxytfs UNIQUE,
    order_date TIMESTAMP(6) WITH TIME ZONE NOT NULL,
    finished_date TIMESTAMP(6) WITH TIME ZONE,
    status VARCHAR(255) NOT NULL CONSTRAINT tb_order_status_check CHECK (
        (status)::TEXT = ANY (
            ARRAY[
                'RECEIVED'::VARCHAR,
                'IN_PROGRESS'::VARCHAR,
                'READY'::VARCHAR,
                'FINISHED'::VARCHAR
                ]::TEXT[]
            )
        ),
    created_at TIMESTAMP(6) WITH TIME ZONE NOT NULL,
    updated_at TIMESTAMP(6) WITH TIME ZONE NOT NULL
);

ALTER TABLE public.tb_order OWNER TO fastfood;

CREATE TABLE public.tb_order_item (
    id UUID NOT NULL PRIMARY KEY,
    order_id UUID NOT NULL,
    quantity INTEGER NOT NULL,
    product_id UUID NOT NULL CONSTRAINT fk4h5xid5qehset7qwe5l9c997x REFERENCES public.tb_product,
    created_at TIMESTAMP(6) WITH TIME ZONE NOT NULL,
    updated_at TIMESTAMP(6) WITH TIME ZONE NOT NULL
);

ALTER TABLE public.tb_order_item OWNER TO fastfood;



CREATE OR REPLACE FUNCTION set_order_number()
    RETURNS TRIGGER AS $$
BEGIN
    NEW.number
        := nextval('sq_order_number');
    RETURN NEW;
END;
$$
    LANGUAGE plpgsql;

CREATE TRIGGER order_number_trigger
    BEFORE INSERT
    ON tb_order
    FOR EACH ROW
EXECUTE FUNCTION set_order_number();

