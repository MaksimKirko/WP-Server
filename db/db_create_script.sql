CREATE TABLE "ticket" (
  "id" serial NOT NULL,
  "type" character varying(128) NOT NULL,
  "violation_id" bigint,
  "license_plate" character varying(128) NOT NULL,
  "address" character varying(256) NOT NULL,
  "location" character varying(128),
  "date" TIMESTAMP NOT NULL,
  "comment" character varying(1024),
  CONSTRAINT ticket_pk PRIMARY KEY ("id")
) WITH (
OIDS=FALSE
);



CREATE TABLE "violation" (
  "id" serial NOT NULL,
  "type" character varying(128) NOT NULL UNIQUE,
  "description" character varying(1024) NOT NULL,
  "fee" float4 NOT NULL,
  CONSTRAINT violation_pk PRIMARY KEY ("id")
) WITH (
OIDS=FALSE
);



CREATE TABLE "action" (
  "id" serial NOT NULL,
  "type" character varying(128) NOT NULL UNIQUE,
  "description" character varying(1024),
  CONSTRAINT action_pk PRIMARY KEY ("id")
) WITH (
OIDS=FALSE
);



CREATE TABLE "photo" (
  "id" serial NOT NULL,
  "photo" bytea NOT NULL,
  "ticket_id" bigint NOT NULL,
  CONSTRAINT photo_pk PRIMARY KEY ("id")
) WITH (
OIDS=FALSE
);



CREATE TABLE "user" (
  "id" serial NOT NULL,
  "first_name" character varying(128) NOT NULL,
  "last_name" character varying(128) NOT NULL,
  "login" character varying(128) NOT NULL UNIQUE,
  "password" character varying(128) NOT NULL,
  "email" character varying(256) NOT NULL,
  "role_id" bigint NOT NULL,
  "state" character varying(128) NOT NULL,
  CONSTRAINT user_pk PRIMARY KEY ("id")
) WITH (
OIDS=FALSE
);



CREATE TABLE "ticket_2_action" (
  "ticket_id" bigint NOT NULL,
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



ALTER TABLE "photo" ADD CONSTRAINT "photo_fk0" FOREIGN KEY ("ticket_id") REFERENCES "ticket"("id");

ALTER TABLE "user" ADD CONSTRAINT "user_fk0" FOREIGN KEY ("role_id") REFERENCES "role"("id");

ALTER TABLE "ticket_2_action" ADD CONSTRAINT "ticket_2_action_fk0" FOREIGN KEY ("ticket_id") REFERENCES "ticket"("id");
ALTER TABLE "ticket_2_action" ADD CONSTRAINT "ticket_2_action_fk1" FOREIGN KEY ("action_id") REFERENCES "action"("id");



-- TABLES FILLING --
INSERT INTO ROLE (type) VALUES ('ADMIN');
INSERT INTO ROLE (type) VALUES ('USER');
INSERT INTO ROLE (type) VALUES ('GUEST');

INSERT INTO "user" (first_name, last_name, login, password, email, role_id, state) VALUES
  ('Maxim', 'Kirko', 'badgatsby', '$2a$10$npBwHbk/OqaBbMm3XStL8ubD/WnVKC4KwAN6oKdxDURkZktrqewSa',
   'kirko_ma_14@mf.grsu.by', 1, 'Active');

INSERT INTO "user" (first_name, last_name, login, password, email, role_id, state) VALUES
  ('Pavel', 'Bulay', 'pavel', '$2a$10$cBHW3PAg/kxMsysS42ChEevXDs1IX6.Ijn3WrUalVeRTAd/IyGJ4q', 'bulay.pasha@mail.ru', 1,
   'Active');

INSERT INTO action (type, description)
VALUES ('CallATowTruck', 'Вызвать эвакуатор и перевезти автомобиль нарушителя на штраф-стоянку.');
INSERT INTO action (type, description) VALUES ('WheelsBlock', 'Заблокировать колёса автомобиля.');
INSERT INTO action (type, description) VALUES ('AssignFee', 'Выписать штраф.');

INSERT INTO violation (type, description, fee) VALUES ('ParkingUnderSign',
                                                       '143. Остановка и стоянка транспортных средств запрещаются: 143.1. в зоне действия соответственно дорожных знаков «Остановка запрещена», «Стоянка запрещена», «Стоянка запрещена по нечетным числам месяца», «Стоянка запрещена по четным числам месяца» и (или) линий горизонтальной дорожной разметки 1.4, 1.10;',
                                                       25);

INSERT INTO violation (type, description, fee) VALUES ('ParkingOnCrossing',
                                                       '143. Остановка и стоянка транспортных средств запрещаются: 143.4. на перекрестках и ближе 15 метров от края пересекаемой проезжей части дороги (кроме жилых зон), за исключением стороны напротив бокового проезда трехсторонних перекрестков, имеющих сплошную линию горизонтальной дорожной разметки или сплошную разделительную полосу;
                                                       ', 35);

INSERT INTO violation (type, description, fee) VALUES ('ParkingAtBusStop',
                                                       '143. Остановка и стоянка транспортных средств запрещаются: 143.5. на остановочных пунктах маршрутных транспортных средств и ближе 15 метров от них, кроме случаев остановки для посадки (высадки) пассажиров, если это не создаст препятствия для движения маршрутных транспортных средств;
                                                       ', 30);

INSERT INTO violation (type, description, fee) VALUES ('ParkingOnBridge',
                                                       '143. Остановка и стоянка транспортных средств запрещаются: 143.6. на мостах, путепроводах, эстакадах и под ними, кроме специально оборудованных мест для стоянки;
                                                       ', 30);

INSERT INTO violation (type, description, fee) VALUES ('ParkingNearRailroad',
                                                       '143. Остановка и стоянка транспортных средств запрещаются: 143.8. на железнодорожных переездах и ближе 50 метров от них в обе стороны;
                                                       ', 50);

INSERT INTO violation (type, description, fee) VALUES ('ParkingOnLeftSide',
                                                       '143. Остановка и стоянка транспортных средств запрещаются: 143.11. на левой стороне дороги, за исключением случаев, указанных в подпункте 138.3 пункта 138 настоящих Правил;
                                                       ', 20);

INSERT INTO violation (type, description, fee) VALUES ('ParkingOnWalkway',
                                                       '143. Остановка и стоянка транспортных средств запрещаются: 143.14. на тротуарах, кроме специально отведенных мест, обозначенных дорожным знаком «Место стоянки» («Место стоянки такси»).
                                                       Допускается остановка транспортных средств дорожно-эксплуатационной и коммунальной служб, автомобилей с наклонной белой полосой на бортах, а также других транспортных средств, обслуживающих торговые и другие организации, расположенные непосредственно у тротуаров, на время выполнения работ либо загрузки (разгрузки) транспортного средства при условии обеспечения безопасности дорожного движения;
                                                       ', 40);

INSERT INTO violation (type, description, fee) VALUES ('ParkingOnGrass',
                                                       '143. Остановка и стоянка транспортных средств запрещаются: 143.15. на газонах и других участках с зелеными насаждениями;
                                                       ', 40);

INSERT INTO violation (type, description, fee) VALUES ('ParkingNearShop',
                                                       '143. Остановка и стоянка транспортных средств запрещаются: 143.18. ближе 10 метров от служебных дверей магазинов, через которые производятся погрузочно-разгрузочные работы, закрытых ворот, в том числе ворот гаражей.
                                                       ', 35);

