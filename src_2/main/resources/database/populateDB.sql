USE main_db;

INSERT INTO users(email, login, password, status) VALUES("probe@gmail.com","name","qwerty",'USER');
INSERT INTO initiatives(name, description, user_id, budget, votes_num, status) VALUES('name','description',1,5000,0,'pre_vote');
INSERT INTO reports(init_id, description, implem_end_date, end_budget) VALUES(1,'done','2008-7-04',50000);
INSERT INTO votes(init_id, user_id) VALUES(1,1);