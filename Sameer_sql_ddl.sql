// DDL command for creating product table

create table product(p_id integer primary key ,
					p_name varchar(50) ,
					p_discription varchar(50) ,
					category varchar(50) , 
					sub_category varchar(50) , 
					qty_in_hand integer , 
					p_cost DOUBLE PRECISION , 
					p_price DOUBLE PRECISION );

// DDL command for creating Customer table

create table Customer(c_id integer primary key ,
					c_first_name varchar(50) ,
					c_middle_name varchar(50),
					c_last_name varchar(50),
					c_DOB Date ,
					c_mobile_number integer , 
					c_email_address varchar(50) , 
					c_address varchar(100) , 
					c_city varchar(50) , 
					c_zipcode integer,
					 c_state varchar(50));

// DDL command for creating Customer_Order table

create table Customer_Order(o_id integer primary key ,
					p_id integer references product(p_id) ,
					c_id integer references Customer(c_id),
					o_date date,
					total_item integer ,
					total_price double precision , 
					payment_method varchar(50) );
                    
//DDL command for creating Shipment_order table

CREATE TABLE IF NOT EXISTS public.order_shipment
(
    shipment_id integer NOT NULL,
    o_id integer,
    c_id integer,
    dispatch_date date,
    order_status character varying(50) COLLATE pg_catalog."default",
    received_date date,
    CONSTRAINT order_shipment_c_id_fkey FOREIGN KEY (c_id)
        REFERENCES public.customer (c_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT order_shipment_o_id_fkey FOREIGN KEY (o_id)
        REFERENCES public.customer_order (o_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
