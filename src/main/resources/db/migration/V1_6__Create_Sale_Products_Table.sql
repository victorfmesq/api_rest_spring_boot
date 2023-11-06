-- public.tb_sale_products definition

-- Drop table

-- DROP TABLE public.tb_sale_products;

CREATE TABLE public.tb_sale_products (
	sale_id int8 NOT NULL,
	products_id int8 NOT NULL,
	CONSTRAINT uk_as1tma8smol50l7g43eajqnc0 UNIQUE (products_id)
);


-- public.tb_sale_products foreign keys

ALTER TABLE public.tb_sale_products ADD CONSTRAINT fkgk35bo47w4fjvg4sq15m9o2ah FOREIGN KEY (sale_id) REFERENCES public.tb_sale(id);
ALTER TABLE public.tb_sale_products ADD CONSTRAINT fkqiea9lwopxwqp688ttaqphyw1 FOREIGN KEY (products_id) REFERENCES public.tb_product(id);