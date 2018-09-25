INSERT INTO SCB_TEAM (team_id, name, leader_id) VALUES(200, 'Trading Team', 'leader');
INSERT INTO SCB_TEAM (team_id, name, leader_id) VALUES(100, 'Admin Team', 'adminleader');

INSERT INTO SCB_USER (id, firstname, lastname, user_Id, onboarddate, team_id, role_id) VALUES(1, 'john', 'doe','leader', null,200,2);
INSERT INTO SCB_USER (id, firstname, lastname, user_Id, onboarddate, team_id, role_id) VALUES(2, 'm1', '','member1', null,200,3);
INSERT INTO SCB_USER (id, firstname, lastname, user_Id, onboarddate, team_id, role_id) VALUES(3, 'm2', '','member2', null,200,3);

INSERT INTO SCB_USER (id, firstname, lastname, user_Id, onboarddate, team_id, role_id) VALUES(4, 'adminleader', '','adminleader', null,100,1);
INSERT INTO SCB_USER (id, firstname, lastname, user_Id, onboarddate, team_id, role_id) VALUES(5, 'admin', '','admin', null,100,1);


INSERT INTO SCB_AUTHENTICATE (user_Id, password) VALUES('leader', 'leader');
INSERT INTO SCB_AUTHENTICATE (user_Id, password) VALUES('member1', 'member1');
INSERT INTO SCB_AUTHENTICATE (user_Id, password) VALUES('member2', 'member2');
INSERT INTO SCB_AUTHENTICATE (user_Id, password) VALUES('admin', 'admin');
INSERT INTO SCB_AUTHENTICATE (user_Id, password) VALUES('adminleader', 'adminleader');

INSERT INTO SCB_ROLE (role_Id, role, permission) VALUES(1, 'admin', 'READ_ALL');
INSERT INTO SCB_ROLE (role_Id, role, permission) VALUES(2, 'leader', 'TEAM_EDIT');
INSERT INTO SCB_ROLE (role_Id, role, permission) VALUES(3, 'user', 'TEAM_READ');

INSERT INTO SCB_TICKET (ticket_id, team_Id, apply_date, amount) VALUES(1, 100, '2018-09-01', 5);
INSERT INTO SCB_TICKET (ticket_id, team_Id, apply_date, amount) VALUES(2, 200, '2018-09-01', 10);