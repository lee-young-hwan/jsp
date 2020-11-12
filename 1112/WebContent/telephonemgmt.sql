CREATE TABLE Telephone
(
	seq           INT    AUTO_INCREMENT   PRIMARY KEY,
	kind          TINYINT      NOT NULL,
	tel           CHAR(8)      NOT NULL,
	NAME          VARCHAR(20)  NOT NULL,
	quantity      SMALLINT     NOT NULL,
	defaultfee    INT,
	fee           INT,
	tax           INT,
	total         INT
)