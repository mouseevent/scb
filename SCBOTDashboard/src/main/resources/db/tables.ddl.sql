DROP TABLE IF EXISTS SCB_AUTHENTICATE;
DROP TABLE IF EXISTS SCB_ROLE;
DROP TABLE IF EXISTS SCB_TEAM;
DROP TABLE IF EXISTS SCB_USER;
DROP TABLE IF EXISTS SCB_TICKET;

CREATE TABLE SCB_USER (
	id int,
	firstName varchar(200),
	lastName varchar(200),
	user_id varchar(200),
	onBoardDate Date,
	team_id int,
	role_id int,
	PRIMARY KEY (`id`)
);

CREATE TABLE SCB_TEAM (
	team_id int,
	name varchar(200),
	leader_id varchar(200),
	PRIMARY KEY (`team_id`)
);

CREATE TABLE SCB_AUTHENTICATE (
	id int,
	user_id varchar(200),
	password varchar(200)
);

CREATE TABLE SCB_ROLE (
	role_id int,
	role varchar(200),
	permission varchar(200)
);

CREATE TABLE SCB_TICKET (
	ticket_id int,
	team_id int,
	apply_date Date,
	amount int,
	PRIMARY KEY (`ticket_id`)
);