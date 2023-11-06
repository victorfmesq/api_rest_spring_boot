CREATE TABLE public.tb_product (
	id bigserial NOT NULL,
	"name" varchar(100) NULL,
	value float4 NOT NULL,
	CONSTRAINT tb_product_pkey PRIMARY KEY (id)
);