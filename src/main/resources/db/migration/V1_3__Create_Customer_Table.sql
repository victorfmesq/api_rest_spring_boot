CREATE TABLE public.tb_customer (
	id bigserial NOT NULL,
	"name" varchar(100) NULL,
	cpf varchar(11) NULL,
	CONSTRAINT tb_customer_pkey PRIMARY KEY (id),
	CONSTRAINT uk_1r2x5kcodv7u39r4k8jfk78b8 UNIQUE (cpf)
);