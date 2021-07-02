INSERT INTO account (username,phone_number,password,date_create,fullname,birthday,address,email,gender,github,facebook,twitter,roles,hobby,objective,add_information,reference,awards) VALUES 
('duongnh','0773314448','$2a$10$IDXaDhjrSSsbLPx9BqHvheodo8Yfex9dRxUmb7l77VD9ShveDL7vy','2020-12-23 10:50:21.0','NGO HUU DUONG','2001-08-30','137 To Hieu','duongnhqb082001@gmail.com',1,'https://github.com/duong-coder','https://www.facebook.com/duongngohuu.qb','https://twitter.com','ROLE_ADMIN','Coding, listening to music, playing game.','##### Short-term goal:
 - Learn how to do real projects.','Github: https://github.com/duong-coder','Mr. Nguyen Ngoc Anh - Instructor\\
Teacher at FPT Polytechnic College Danang\\
Email: anhnn4@fpt.edu.vn','* The first prize of Group B team in Hackathon organized by FPT Education Organization.
* 4 excellent students: SPRING 2020, SUMMER 2021, FALL 2020, SPRING 2021.
* 1 semester of good students: FALL 2019.');

INSERT INTO educations (name,description,gpa,date_start,date_end,sort_index,username) VALUES 
('FPT POLYTECHNIC COLLEGE ','Major: Information Technology - Software Application',3.6,'2019-09-15','2021-06-23',5,'duongnh')
;

INSERT INTO skills (username,skill,`level`,sort_index) VALUES 
('duongnh','HTML',2,1)
,('duongnh','CSS',5,2)
,('duongnh','JS',2,3)
;

INSERT INTO work_experience (company_or_app_name,title_or_position,description,date_start,date_end,sort_index,username) VALUES 
('STUDENT MANAGER','Java Core','\\- Description: Application used to manage students, running on the console.
\\- Team size: 1.','2019-10-01','2019-12-01',1,'duongnh')
;
