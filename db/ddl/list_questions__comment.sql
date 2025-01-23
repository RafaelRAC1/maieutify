CREATE TABLE list_question__comment 
(
    list_question__comment_id INT IDENTITY(1,1) PRIMARY KEY,
    list_question_id INT NOT NULL,
    commenter_id INT NOT NULL,
    comment TEXT NOT NULL,
    edited CHAR DEFAULT 'N',
    last_updated DATE DEFAULT(GETUTCDATE()),
    CONSTRAINT list_question__comment_id__list_question_id_fk FOREIGN KEY (list_question_id)
        REFERENCES list_questions (list_id)
            ON DELETE NO ACTION,
    CONSTRAINT list_question__comment_id__commenter_id_fk FOREIGN KEY (commenter_id)
        REFERENCES app_user (user_id)
            ON DELETE CASCADE
)

-- ADDED