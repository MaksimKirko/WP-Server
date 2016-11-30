CREATE TABLE "ticket" (
	"id" serial NOT NULL,
	"violation_id" bigint,
	"license_plate" character varying(128),
	"address" character varying(256),
	"location" character varying(128) NOT NULL,
	"date" TIMESTAMP NOT NULL,
	"comment" character varying(512),
	CONSTRAINT ticket_pk PRIMARY KEY ("id")
) WITH (
OIDS=FALSE
);



CREATE TABLE "violation" (
	"id" serial NOT NULL,
	"type" character varying(128) NOT NULL UNIQUE,
	"description" character varying(512) NOT NULL,
	"fee" float4 NOT NULL,
	CONSTRAINT violation_pk PRIMARY KEY ("id")
) WITH (
OIDS=FALSE
);



CREATE TABLE "action" (
	"id" serial NOT NULL,
	"type" character varying(128) NOT NULL UNIQUE,
	"description" character varying(512),
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
	"role_id" bigint NOT NULL,
	"is_logged_in" BOOLEAN NOT NULL,
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



CREATE TABLE "violation_2_action" (
	"violation_id" bigint NOT NULL,
	"action_id" bigint NOT NULL
) WITH (
OIDS=FALSE
);



CREATE TABLE "role" (
	"id" serial NOT NULL,
	"type" character varying(128) NOT NULL UNIQUE,
	CONSTRAINT role_pk PRIMARY KEY ("id")
) WITH (
OIDS=FALSE
);



ALTER TABLE "ticket" ADD CONSTRAINT "ticket_fk0" FOREIGN KEY ("violation_id") REFERENCES "violation"("id");




ALTER TABLE "ticket_2_photo" ADD CONSTRAINT "ticket_2_photo_fk0" FOREIGN KEY ("ticket_id") REFERENCES "ticket"("id");
ALTER TABLE "ticket_2_photo" ADD CONSTRAINT "ticket_2_photo_fk1" FOREIGN KEY ("photo_id") REFERENCES "photo"("id");

ALTER TABLE "user" ADD CONSTRAINT "user_fk0" FOREIGN KEY ("role_id") REFERENCES "role"("id");

ALTER TABLE "user_2_ticket" ADD CONSTRAINT "user_2_ticket_fk0" FOREIGN KEY ("user_id") REFERENCES "user"("id");
ALTER TABLE "user_2_ticket" ADD CONSTRAINT "user_2_ticket_fk1" FOREIGN KEY ("ticket_id") REFERENCES "ticket"("id");

ALTER TABLE "violation_2_action" ADD CONSTRAINT "violation_2_action_fk0" FOREIGN KEY ("violation_id") REFERENCES "violation"("id");
ALTER TABLE "violation_2_action" ADD CONSTRAINT "violation_2_action_fk1" FOREIGN KEY ("action_id") REFERENCES "action"("id");

