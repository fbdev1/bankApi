DROP TABLE IF EXISTS PUBLIC.CLIENTS;

CREATE TABLE PUBLIC.CLIENTS (
                                ID         INTEGER      NOT NULL AUTO_INCREMENT,
                                NAME       VARCHAR(255) NOT NULL,
                                SURNAME       VARCHAR(255) NOT NULL,
                                EMAIL       VARCHAR(255) NOT NULL,
                                CONSTRAINT CLIENTS_PRIMARY_KEY PRIMARY KEY (ID)
);

INSERT INTO PUBLIC.CLIENTS (ID, NAME, SURNAME, EMAIL) VALUES (1, 'Petr', 'Petrov', 'petr@mail.com');
INSERT INTO PUBLIC.CLIENTS (ID, NAME, SURNAME, EMAIL) VALUES (2, 'Oleg', 'Kotov', 'koto@mail.com');


DROP TABLE IF EXISTS PUBLIC.CL_ACCOUNTS;

CREATE TABLE PUBLIC.CL_ACCOUNTS (
                                    ID          INTEGER      NOT NULL AUTO_INCREMENT,
                                    AC_NUMBER VARCHAR(255) NOT NULL UNIQUE ,
                                    BALANCE DOUBLE(255),
                                    CLIENT_ID     INTEGER      NOT NULL,
                                    CONSTRAINT CL_ACCOUNTS_PRIMARY_KEY PRIMARY KEY (ID),
                                    CONSTRAINT CLIENTS_FOREIGN_KEY FOREIGN KEY (CLIENT_ID) REFERENCES CLIENTS (ID) ON DELETE CASCADE
);
INSERT INTO PUBLIC.CL_ACCOUNTS (ID, AC_NUMBER, BALANCE, CLIENT_ID) VALUES (1, '12431243', 1243, 1);
INSERT INTO PUBLIC.CL_ACCOUNTS (ID, AC_NUMBER, BALANCE, CLIENT_ID) VALUES (2, '12431244', 4312, 1);
INSERT INTO PUBLIC.CL_ACCOUNTS (ID, AC_NUMBER, BALANCE, CLIENT_ID) VALUES (3, '43214321', 4322, 2);

DROP TABLE IF EXISTS PUBLIC.CARDS;
CREATE TABLE PUBLIC.CARDS (
                              ID          INTEGER      NOT NULL AUTO_INCREMENT,
                              CARD_NUMBER VARCHAR(255) NOT NULL UNIQUE ,
                              CL_ACCOUNT_ID     INTEGER      NOT NULL,
                              CONSTRAINT CARDS_PRIMARY_KEY PRIMARY KEY (ID),
                              CONSTRAINT CL_ACCOUNTS_FOREIGN_KEY FOREIGN KEY (CL_ACCOUNT_ID) REFERENCES CL_ACCOUNTS (ID) ON DELETE CASCADE
);
INSERT INTO PUBLIC.CARDS (ID, CARD_NUMBER, CL_ACCOUNT_ID) VALUES (1, '1243 1243', 1);
INSERT INTO PUBLIC.CARDS (ID, CARD_NUMBER, CL_ACCOUNT_ID) VALUES (2, '4324 2344', 1);
INSERT INTO PUBLIC.CARDS (ID, CARD_NUMBER, CL_ACCOUNT_ID) VALUES (3, '5324 4352', 2);
INSERT INTO PUBLIC.CARDS (ID, CARD_NUMBER, CL_ACCOUNT_ID) VALUES (4, '1234 5234', 2);
INSERT INTO PUBLIC.CARDS (ID, CARD_NUMBER, CL_ACCOUNT_ID) VALUES (5, '4523 3455', 3);



DROP TABLE IF EXISTS PUBLIC.COMPANIES;
CREATE TABLE PUBLIC.COMPANIES (
                                ID         INTEGER      NOT NULL AUTO_INCREMENT,
                                NAME       VARCHAR(255) NOT NULL,
                                CONSTRAINT COMPANIES_PRIMARY_KEY PRIMARY KEY (ID)
);
INSERT INTO PUBLIC.COMPANIES (NAME) VALUES ('GAZPROM');
INSERT INTO PUBLIC.COMPANIES (NAME) VALUES ('LUKOIL');
INSERT INTO PUBLIC.COMPANIES (NAME) VALUES ('SBERBANK');
INSERT INTO PUBLIC.COMPANIES (NAME) VALUES ('TELECOM');

DROP TABLE IF EXISTS PUBLIC.COMP_ACCOUNTS;
CREATE TABLE PUBLIC.COMP_ACCOUNTS (
                                    ID          INTEGER      NOT NULL AUTO_INCREMENT,
                                    AC_NUMBER VARCHAR(255) NOT NULL UNIQUE ,
                                    BALANCE DOUBLE(255),
                                    COMP_ID     INTEGER      NOT NULL,
                                    CONSTRAINT COMP_ACCOUNTS_PRIMARY_KEY PRIMARY KEY (ID),
                                    CONSTRAINT COMPANIES_FOREIGN_KEY FOREIGN KEY (COMP_ID) REFERENCES COMPANIES (ID) ON DELETE CASCADE
);
INSERT INTO PUBLIC.COMP_ACCOUNTS (AC_NUMBER, BALANCE, COMP_ID) VALUES ('123456789', 999999999, 1);
INSERT INTO PUBLIC.COMP_ACCOUNTS (AC_NUMBER, BALANCE, COMP_ID) VALUES ('987654321', 8888888888, 2);
INSERT INTO PUBLIC.COMP_ACCOUNTS (AC_NUMBER, BALANCE, COMP_ID) VALUES ('181818188', 777777777, 3);
INSERT INTO PUBLIC.COMP_ACCOUNTS (AC_NUMBER, BALANCE, COMP_ID) VALUES ('757575757', 666666666, 4);