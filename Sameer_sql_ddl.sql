// DDL command for creating product table

create table product(product_Id integer primary key ,
					product_Name varchar(50) ,
					product_Discription varchar(100) ,
					category varchar(50) , 
					sub_sategory varchar(100) , 
					qty_in_hand varchar(100) , 
					product_Cost varchar(100) , 
					product_Price varchar(100) );
                    
// DDL command for creating customer table
create table Customer(customer_Id integer primary key ,
					first_Name varchar(50) ,
					middle_Name varchar(50),
					last_Name varchar(50),
					gender varchar(50),
					date_ofBirth Date ,
					mobile_number integer , 
					email_address varchar(50) , 
					address varchar(100) , 
					city varchar(50) , 
					zipcode integer,
					 state varchar(50));

// DDL command for creating customer_order table
create table customer_Order(order_Id integer primary key ,
					product_Id integer references product(product_Id) ,
					ccustomer_Id integer references Customer(customer_Id),
					orderDate date,
					total_item integer ,
					total_price double precision , 
					payment_method varchar(50) );

// DDL command for creating orderShipment table
CREATE TABLE IF NOT EXISTS public.order_shipment
(
    shipment_id integer NOT NULL,
    order_Id integer references customer_Order(order_Id),
    customer_Id integer references Customer(customer_Id),
    dispatch_date date,
    order_status character varying(50) ,
    received_date date);