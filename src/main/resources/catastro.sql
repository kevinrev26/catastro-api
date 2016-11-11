/*==============================================================*/
/* DBMS name:      PostgreSQL 9.x                               */
/* Created on:     10/11/2016 10:37:34 p.m.                     */
/*==============================================================*/


drop index CONTRIBUYENTE_PK;

drop table CONTRIBUYENTE;

drop index IMPUESTO_PK;

drop table IMPUESTO;

drop index GENERA_FK;

drop index POSEE_FK;

drop index INMUEBLE_PK;

drop table INMUEBLE;

drop index SOLICITUD_PK;

drop table SOLICITUD;

drop index TASA_PK;

drop table TASA;

/*==============================================================*/
/* Table: CONTRIBUYENTE                                         */
/*==============================================================*/
create table CONTRIBUYENTE (
   ID_CONTRIBUYENTE     SERIAL               not null,
   NOMBRE               VARCHAR(250)         not null,
   APELLIDO             VARCHAR(250)         not null,
   NIT                  VARCHAR(14)          not null,
   TELEFONO             VARCHAR(8)           not null,
   EMAIL                VARCHAR(250)         null,
   constraint PK_CONTRIBUYENTE primary key (ID_CONTRIBUYENTE)
);

/*==============================================================*/
/* Index: CONTRIBUYENTE_PK                                      */
/*==============================================================*/
create unique index CONTRIBUYENTE_PK on CONTRIBUYENTE (
ID_CONTRIBUYENTE
);

/*==============================================================*/
/* Table: IMPUESTO                                              */
/*==============================================================*/
create table IMPUESTO (
   DESCRIPCION          VARCHAR(255)         not null,
   _VALOR               FLOAT8               not null,
   IDENTIFICADOR_IMPUESTO SERIAL                 not null,
   constraint PK_IMPUESTO primary key (IDENTIFICADOR_IMPUESTO)
);

/*==============================================================*/
/* Index: IMPUESTO_PK                                           */
/*==============================================================*/
create unique index IMPUESTO_PK on IMPUESTO (
IDENTIFICADOR_IMPUESTO
);

/*==============================================================*/
/* Table: INMUEBLE                                              */
/*==============================================================*/
create table INMUEBLE (
   ID_CONTRIBUYENTE     INT4                 null,
   CLAVE_CATASTRAL      VARCHAR(50)          not null,
   IDENTIFICADOR_IMPUESTO INT4                 null,
   DIRECCION            VARCHAR(250)         not null,
   TIPO_INMUEBLE        VARCHAR(100)         not null,
   TIPO_ALUMBRADO       VARCHAR(1)           not null,
   COMERCIO             BOOL                 not null,
   VALOR                FLOAT8               not null,
   METROS               FLOAT8               not null,
   SUPERFICIE           FLOAT8               not null,
   OBSERVACIONES        VARCHAR(250)         null,
   constraint PK_INMUEBLE primary key (CLAVE_CATASTRAL)
);

/*==============================================================*/
/* Index: INMUEBLE_PK                                           */
/*==============================================================*/
create unique index INMUEBLE_PK on INMUEBLE (
CLAVE_CATASTRAL
);

/*==============================================================*/
/* Index: POSEE_FK                                              */
/*==============================================================*/
create  index POSEE_FK on INMUEBLE (
ID_CONTRIBUYENTE
);

/*==============================================================*/
/* Index: GENERA_FK                                             */
/*==============================================================*/
create  index GENERA_FK on INMUEBLE (
IDENTIFICADOR_IMPUESTO
);

/*==============================================================*/
/* Table: SOLICITUD                                             */
/*==============================================================*/
create table SOLICITUD (
   NUMERO               VARCHAR(50)          not null,
   NOMBRE_SOLICITANTE   VARCHAR(255)         not null,
   NUMERO_CONT_SOLICITANTE INT4                 not null,
   NIT_SOLICITANTE      VARCHAR(14)          not null,
   FECHA                DATE                 not null,
   ESTADO               VARCHAR(50)          null,
   constraint PK_SOLICITUD primary key (NUMERO)
);

/*==============================================================*/
/* Index: SOLICITUD_PK                                          */
/*==============================================================*/
create unique index SOLICITUD_PK on SOLICITUD (
NUMERO
);

/*==============================================================*/
/* Table: TASA                                                  */
/*==============================================================*/
create table TASA (
   ID_TASA              VARCHAR(100)         not null,
   DESCRIPCION_TASA     VARCHAR(250)         not null,
   TIPO                 VARCHAR(100)         not null,
   INICIO               INT4                 not null,
   FIN                  INT4                 not null,
   constraint PK_TASA primary key (ID_TASA)
);

/*==============================================================*/
/* Index: TASA_PK                                               */
/*==============================================================*/
create unique index TASA_PK on TASA (
ID_TASA
);

alter table INMUEBLE
   add constraint FK_INMUEBLE_GENERA_IMPUESTO foreign key (IDENTIFICADOR_IMPUESTO)
      references IMPUESTO (IDENTIFICADOR_IMPUESTO)
      on delete restrict on update restrict;

alter table INMUEBLE
   add constraint FK_INMUEBLE_POSEE_CONTRIBU foreign key (ID_CONTRIBUYENTE)
      references CONTRIBUYENTE (ID_CONTRIBUYENTE)
      on delete restrict on update restrict;

