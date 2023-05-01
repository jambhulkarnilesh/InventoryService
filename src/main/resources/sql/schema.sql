create table color(
    color_id int not null PRIMARY key,
	color_name VARCHAR(30) not null,
	status_cd varchar(20) not null CONSTRAINT status_cd check(status_cd in ('A', 'I')),
	crte_user_id VARCHAR(20) not null,
	crte_ts TIMESTAMP not null DEFAULT CURRENT_TIMESTAMP,
	lst_updt_ts TIMESTAMP null,
	lst_updt_user_id VARCHAR(20) null
)

create table catagory(
    cata_id int not null PRIMARY key,
	cata_name VARCHAR(30) not null,
	status_cd varchar(20) not null CONSTRAINT status_cd check(status_cd in ('A', 'I')),
	crte_user_id VARCHAR(20) not null,
	crte_ts TIMESTAMP not null DEFAULT CURRENT_TIMESTAMP,
	lst_updt_ts TIMESTAMP null,
	lst_updt_user_id VARCHAR(20) null
)



create table sub_catagory(
    sub_cata_id int not null PRIMARY key,
    cata_id int,
	sub_cata_name VARCHAR(30) not null,
	status_cd varchar(20) not null CONSTRAINT status_cd check(status_cd in ('A', 'I')),
	crte_user_id VARCHAR(20) not null,
	crte_ts TIMESTAMP not null DEFAULT CURRENT_TIMESTAMP,
	lst_updt_ts TIMESTAMP null,
	lst_updt_user_id VARCHAR(20) null,
	CONSTRAINT fk_cata_id FOREIGN KEY(cata_id) REFERENCES catagory(cata_id)
)

create table brand(
    brand_id int not null PRIMARY key,
	brand_name VARCHAR(30) not null,
	status_cd varchar(20) not null CONSTRAINT status_cd check(status_cd in ('A', 'I')),
	crte_user_id VARCHAR(20) not null,
	crte_ts TIMESTAMP not null DEFAULT CURRENT_TIMESTAMP,
	lst_updt_ts TIMESTAMP null,
	lst_updt_user_id VARCHAR(20) null
)


create table unit_measures(
    um_id int not null PRIMARY key,
	um_name VARCHAR(30) not null,
	status_cd varchar(20) not null CONSTRAINT status_cd check(status_cd in ('A', 'I')),
	crte_user_id VARCHAR(20) not null,
	crte_ts TIMESTAMP not null DEFAULT CURRENT_TIMESTAMP,
	lst_updt_ts TIMESTAMP null,
	lst_updt_user_id VARCHAR(20) null
)


create table product(
    pro_id serial PRIMARY key ,
	pro_name VARCHAR(30) not null,
	color_id int,
	cata_id int,
	sub_cata_id int,
	um_id int,
	brand_id int,
	vendor_id int,
	pro_qty VARCHAR(30),
	pro_min_qty VARCHAR(30),
	pro_critical_qty VARCHAR(30),
	pro_desc VARCHAR(400),
    pro_bar_code varchar(50),
	pro_manu_date varchar(50),
	pro_exp_date varchar(50),
    pro_image varchar(100),
    pro_height varchar(30),
    pro_width  varchar(30),
    pro_price varchar(20),
    dis_per varchar(20),
    dis_rs varchar(20),
    pro_price_disc varchar(20),
    sgst_per varchar(20),
    sgst_rs varchar(20),
    cgst_per varchar(20),
    cgst_rs varchar(20),
    grand_total varchar(20),
	status_cd varchar(20) not null CONSTRAINT status_cd check(status_cd in ('A', 'I')),
	crte_user_id VARCHAR(20) ,
	crte_ts TIMESTAMP not null DEFAULT CURRENT_TIMESTAMP,
	lst_updt_ts TIMESTAMP null,
	lst_updt_user_id VARCHAR(20) null
)

--for brand
insert into brand (brand_id,brand_name,status_cd,crte_user_id) VALUES(1,'BMW','A','admin')
insert into brand (brand_id,brand_name,status_cd,crte_user_id) VALUES(2,'Mercedece','A','admin')

--for catagory
insert into catagory (cata_id,cata_name,status_cd,crte_user_id) VALUES(1,'Vechile','A','admin')
insert into catagory (cata_id,cata_name,status_cd,crte_user_id) VALUES(2,'Computer','A','admin')

--for subcatsgory
insert into sub_catagory (sub_cata_id,cata_id,sub_cata_name,status_cd,crte_user_id) VALUES(1, 1,'Two Wheeler','A','admin')
insert into sub_catagory (sub_cata_id,cata_id,sub_cata_name,status_cd,crte_user_id) VALUES(2, 1,'Three Wheeler','A','admin')
insert into sub_catagory (sub_cata_id,cata_id,sub_cata_name,status_cd,crte_user_id) VALUES(3, 1,'Four Wheeler','A','admin')

--for unit of measures
insert into unit_measures (um_id,um_name,status_cd,crte_user_id) VALUES(1,'Quantity','A','admin')
insert into unit_measures (um_id,um_name,status_cd,crte_user_id) VALUES(2,'KG','A','admin')
insert into unit_measures (um_id,um_name,status_cd,crte_user_id) VALUES(3,'Litter','A','admin')

--for color
insert into color (color_id,color_name,status_cd,crte_user_id) VALUES(1,'Red','A','admin')
insert into color (color_id,color_name,status_cd,crte_user_id) VALUES(2,'Green','A','admin')