-- add user 1
INSERT INTO app_user VALUES ('rafarac', '123', '', 'Rafael Correa', GETUTCDATE(), 'history; geek; nerd;', 'I am Rafael, only...')

-- add user 2
INSERT INTO app_user VALUES ('somebody', '444', 'link', 'LilSom123', GETUTCDATE(), 'games', 'I am new here, hello!')


-- add profile comment
INSERT INTO profile_comment VALUES (1, 2, 'Hey, Rafael, I am new here! I ve enjoy all of your quizzes so far!', 'N', GETUTCDATE())

-- add categories for quizzes
INSERT INTO category VALUES ('history'), ('games'), ('chemistry'), ('general')

-- add quiz 
INSERT INTO list_questions VALUES (1, GETUTCDATE(), GETUTCDATE(), '1.4', 'Computer Evolution', 'A quiz about computers', '', 1)

-- add question
INSERT INTO question VALUES (1, 'What was ENIAC?', 'Created in the 40s', 1)

-- add alternatives
INSERT INTO alternative VALUES (1, 'a', 'A record vehicle used in Le Mans.', 0), (1, 'b', 'None of the alternatives.', 0), (1, 'c', 'A super computer developed for a NASA program.', 0), (1, 'd', 'The first major computer.', 1)

-- add user start a quiz
INSERT INTO list_questions__user VALUES (1, 1, '00:00')

-- user answer first question on his first try - wrong alternative
INSERT INTO user_answer VALUES (1, 1, 3)

-- user comment about quiz
INSERT INTO list_question__comment VALUES (1, 2, 'Ayo, your quiz is so tuff! Lmao', 'N', GETUTCDATE())