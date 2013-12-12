--SEQUENCES
CREATE SEQUENCE SEQ_OPTION;
CREATE SEQUENCE SEQ_ANSWER;
CREATE SEQUENCE SEQ_QUESTION;
CREATE SEQUENCE SEQ_QUESTIONARY;
CREATE SEQUENCE SEQ_USER;

--TABLES
CREATE TABLE "ANSWER" 
   (	"ID_ANSWER" NUMBER NOT NULL ENABLE, 
	"ID_USER" NUMBER NOT NULL ENABLE, 
	"ID_OPTION" NUMBER NOT NULL ENABLE, 
	 CONSTRAINT "ANSWER_PK" PRIMARY KEY ("ID_ANSWER");

CREATE TABLE "OPTION" 
   (	"ID_OPTION" NUMBER NOT NULL ENABLE, 
	"OPTION_CONTENT" VARCHAR2(100 BYTE) NOT NULL ENABLE, 
	 CONSTRAINT "OPTION_PK" PRIMARY KEY ("ID_OPTION");

CREATE TABLE "QUESTION" 
   (	"QUESTION_CONTENT" VARCHAR2(150 BYTE) NOT NULL ENABLE, 
	"ID_QUESTION" NUMBER NOT NULL ENABLE, 
	"ID_QUESTIONARY" NUMBER NOT NULL ENABLE, 
	 CONSTRAINT "QUESTION_PK" PRIMARY KEY ("ID_QUESTION");

CREATE TABLE "QUESTIONARY" 
   (	"ID_QUESTIONARY" NUMBER NOT NULL ENABLE, 
	"NAME" VARCHAR2(150 BYTE) NOT NULL ENABLE, 
	 CONSTRAINT "QUESTIONARY_PK" PRIMARY KEY ("ID_QUESTIONARY");

CREATE TABLE "TUSER" 
   (	"ID_USER" NUMBER NOT NULL ENABLE, 
	"NAME" VARCHAR2(150 BYTE), 
	 CONSTRAINT "TUSER_PK" PRIMARY KEY ("ID_USER");

--FOREIGN KEYS
alter table "ANSWER" 
add constraint FK_ANSWER_OPTION 
foreign key("ID_OPTION") references "OPTION"("ID_OPTION")
 
alter table "ANSWER" 
ADD CONSTRAINT "ANSWER_FK_USER" FOREIGN KEY ("ID_USER")
	  REFERENCES "TUSER" ("ID_USER")

alter table "QUESTION" 
ADD CONSTRAINT "QUESTION_FK_QUESTIONARY" FOREIGN KEY ("ID_QUESTIONARY")
	  REFERENCES "QUESTIONARY" ("ID_QUESTIONARY")

--TRIGGERS
create or replace trigger TG_ANSWER  
   before insert on "ANSWER" 
   for each row 
begin  
   if inserting then 
      if :NEW."ID_ANSWER" is null then 
         select SEQ_ANSWER.nextval into :NEW."ID_ANSWER" from dual; 
      end if; 
   end if; 
end;

create or replace trigger TG_OPTION  
   before insert on "OPTION" 
   for each row 
begin  
   if inserting then 
      if :NEW."ID_OPTION" is null then 
         select SEQ_OPTION.nextval into :NEW."ID_OPTION" from dual; 
      end if; 
   end if; 
end;

create or replace trigger TG_QUESTION  
   before insert on "QUESTION" 
   for each row 
begin  
   if inserting then 
      if :NEW."ID_QUESTION" is null then 
         select SEQ_QUESTION.nextval into :NEW."ID_QUESTION" from dual; 
      end if; 
   end if; 
end;

create or replace trigger TG_QUESTIONARY  
   before insert on "QUESTIONARY" 
   for each row 
begin  
   if inserting then 
      if :NEW."ID_QUESTIONARY" is null then 
         select SEQ_QUESTIONARY.nextval into :NEW."ID_QUESTIONARY" from dual; 
      end if; 
   end if; 
end;

create or replace trigger TG_TUSER  
   before insert on "TUSER" 
   for each row 
begin  
   if inserting then 
      if :NEW."ID_USER" is null then 
         select SEQ_USER.nextval into :NEW."ID_USER" from dual; 
      end if; 
   end if; 
end;