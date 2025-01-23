CREATE TABLE user_answer 
(
    user_answer_id INT IDENTITY(1,1) PRIMARY KEY,
    list_questions__user_id INT NOT NULL,
    question_id INT NOT NULL,
    alternative_id INT NOT NULL,
    CONSTRAINT user_answer__question_id_fk FOREIGN KEY (question_id)
        REFERENCES question (question_id)
            ON DELETE NO ACTION,
    CONSTRAINT user_answer__alternative_id_fk FOREIGN KEY (alternative_id)
        REFERENCES alternative (alternative_id)
            ON DELETE NO ACTION,
    CONSTRAINT user_answer__list_questions__user_id_fk FOREIGN KEY (list_questions__user_id)
        REFERENCES list_questions__user (list_questions__user_id)
            ON DELETE CASCADE
)

-- added
-- CORRECT2