CREATE TABLE "ticket" (
	"id" serial NOT NULL,
	"violation_id" bigint,
	"license_plate" character varying(256),
	"address" character varying(256),
	"coords" character varying(128) NOT NULL,
	"date" TIMESTAMP NOT NULL,
	"comment" character varying(512),
	CONSTRAINT ticket_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "violations" (
	"id" serial NOT NULL,
	"type" character varying(256) NOT NULL UNIQUE,
	"description" character varying(512) NOT NULL,
	"fee" float4 NOT NULL,
	"action_id" bigint NOT NULL,
	CONSTRAINT violation_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "action" (
	"id" serial NOT NULL,
	"title" character varying(256) NOT NULL UNIQUE,
	CONSTRAINT action_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "photo" (
	"id" serial NOT NULL,
	"photo" bytea NOT NULL,
	CONSTRAINT photo_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "ticket_2_photo" (
	"ticket_id" bigint NOT NULL,
	"photo_id" bigint NOT NULL,
	CONSTRAINT ticket_2_photo_pk PRIMARY KEY ("ticket_id","photo_id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "user" (
	"id" serial NOT NULL,
	"login" character varying(128) NOT NULL UNIQUE,
	"password" character varying(128) NOT NULL,
	CONSTRAINT user_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "user_2_ticket" (
	"user_id" bigint NOT NULL,
	"ticket_id" bigint NOT NULL
) WITH (
  OIDS=FALSE
);



ALTER TABLE "ticket" ADD CONSTRAINT "ticket_fk0" FOREIGN KEY ("violation_id") REFERENCES "violations"("id");

ALTER TABLE "violations" ADD CONSTRAINT "violation_fk0" FOREIGN KEY ("action_id") REFERENCES "action"("id");



ALTER TABLE "ticket_2_photo" ADD CONSTRAINT "ticket_2_photo_fk0" FOREIGN KEY ("ticket_id") REFERENCES "ticket"("id");
ALTER TABLE "ticket_2_photo" ADD CONSTRAINT "ticket_2_photo_fk1" FOREIGN KEY ("photo_id") REFERENCES "photo"("id");


ALTER TABLE "user_2_ticket" ADD CONSTRAINT "user_2_ticket_fk0" FOREIGN KEY ("user_id") REFERENCES "user"("id");
ALTER TABLE "user_2_ticket" ADD CONSTRAINT "user_2_ticket_fk1" FOREIGN KEY ("ticket_id") REFERENCES "ticket"("id");
