-- CREATE DATABASE main_db;
USE main_db;
SET time_zone = "+00:00";

drop table if exists votes;
drop table if exists reports;
drop table if exists initiatives;
drop table if exists users;


CREATE TABLE users (user_id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY, email VARCHAR(255), login VARCHAR(255),
						password VARCHAR(255), status enum('USER', 'ADMIN'));

CREATE TABLE initiatives (init_id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY, name VARCHAR(255), 
						description VARCHAR(2000), user_id INT UNSIGNED, voting_days_left INT, implem_start_date DATE,
                        budget INT, votes_num INT, status enum('pre_vote','voting','implem','ended'),
                        FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE);
		
CREATE TABLE reports (report_id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY, init_id INT UNSIGNED, 
						description VARCHAR(1000), implem_end_date DATE, end_budget INT,
                        FOREIGN KEY (init_id) REFERENCES initiatives(init_id) ON DELETE CASCADE);
                        
CREATE TABLE votes (vote_id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY, init_id INT UNSIGNED, user_id INT UNSIGNED,
						FOREIGN KEY (init_id) REFERENCES initiatives(init_id) ON DELETE CASCADE,
                        FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE);

