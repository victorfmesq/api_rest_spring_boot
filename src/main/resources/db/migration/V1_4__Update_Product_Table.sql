-- public.tb_product definition

-- Drop table

-- DROP TABLE public.tb_product;

CREATE TABLE public.tb_product (
	id bigserial NOT NULL,
	"name" varchar(100) NULL,
	value float4 NOT NULL,
	sale_id int8 NULL,
	CONSTRAINT tb_product_pkey PRIMARY KEY (id)
);


-- public.tb_product foreign keys

ALTER TABLE public.tb_product ADD CONSTRAINT fk4bq019ibqk24oxwi5pcgif3m9 FOREIGN KEY (sale_id) REFERENCES public.tb_sale(id);