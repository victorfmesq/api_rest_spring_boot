CREATE TABLE public.tb_sale (
	id bigserial NOT NULL,
	sale_date timestamp(6) NULL,
	total float4 NOT NULL,
	customer_id int8 NULL,
	CONSTRAINT tb_sale_pkey PRIMARY KEY (id)
);


ALTER TABLE public.tb_sale ADD CONSTRAINT fknvkerbbjm0mjwwg7jht52yoba FOREIGN KEY (customer_id) REFERENCES public.tb_customer(id);