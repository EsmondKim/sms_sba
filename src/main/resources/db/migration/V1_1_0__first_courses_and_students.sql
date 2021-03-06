CREATE TABLE `courses` (
  `id` INT NOT NULL,
  `name` VARCHAR(50) NOT NULL,
  `instructor` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`));


insert into courses (id, name, instructor) values (1, 'English', 'Anderea Scamaden');
insert into courses (id, name, instructor) values (2, 'Mathematics', 'Eustace Niemetz');
insert into courses (id, name, instructor) values (3, 'Anatomy', 'Reynolds Pastor');
insert into courses (id, name, instructor) values (4, 'Organic Chemistry', 'Odessa Belcher');
insert into courses (id, name, instructor) values (5, 'Physics', 'Dani Swallow');
insert into courses (id, name, instructor) values (6, 'Digital Logic', 'Glenden Reilingen');
insert into courses (id, name, instructor) values (7, 'Object Oriented Programming', 'Giselle Ardy');
insert into courses (id, name, instructor) values (8, 'Data Structures', 'Carolan Stoller');
insert into courses (id, name, instructor) values (9, 'Politics', 'Carmita De Maine');
insert into courses (id, name, instructor) values (10, 'Art', 'Kingsly Doxsey');

CREATE TABLE `students` (
  `email` VARCHAR(50) NOT NULL,
  `name` VARCHAR(50) NOT NULL,
  `password` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`email`));

insert into students (email, name, password) values ('hluckham0@google.ru', 'Hazel Luckham', 'X1uZcoIh0dj');
insert into students (email, name, password) values ('sbowden1@yellowbook.com', 'Sonnnie Bowden', 'SJc4aWSU');
insert into students (email, name, password) values ('qllorens2@howstuffworks.com', 'Quillan Llorens', 'W6rJuxd');
insert into students (email, name, password) values ('cstartin3@flickr.com', 'Clem Startin', 'XYHzJ1S');
insert into students (email, name, password) values ('tattwool4@biglobe.ne.jp', 'Thornie Attwool', 'Hjt0SoVmuBz');
insert into students (email, name, password) values ('hguerre5@deviantart.com', 'Harcourt Guerre', 'OzcxzD1PGs');
insert into students (email, name, password) values ('htaffley6@columbia.edu', 'Holmes Taffley', 'xowtOQ');
insert into students (email, name, password) values ('aiannitti7@is.gd', 'Alexandra Iannitti', 'TWP4hf5j');
insert into students (email, name, password) values ('ljiroudek8@sitemeter.com', 'Laryssa Jiroudek', 'bXRoLUP');
insert into students (email, name, password) values ('cjaulme9@bing.com', 'Cahra Jaulme', 'FnVklVgC6r6');