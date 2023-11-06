CREATE TABLE public.tb_user (
	id bigserial NOT NULL,
	email varchar(255) NULL,
	login varchar(255) NULL,
	"name" varchar(100) NULL,
	"password" varchar(255) NULL,
	CONSTRAINT tb_user_pkey PRIMARY KEY (id),
	CONSTRAINT uk_4vih17mube9j7cqyjlfbcrk4m UNIQUE (email),
	CONSTRAINT uk_qht682qvopcx5f41dc2rbs5jf UNIQUE (login)
);