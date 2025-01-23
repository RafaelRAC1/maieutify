CREATE TABLE question
(
    question_id INT IDENTITY(1,1) PRIMARY KEY,
    list_questions_id INT NOT NULL,
    statment TEXT NOT NULL,
    hint TEXT,
    question_number INT NOT NULL,
    CONSTRAINT question__list_questions_id_fk FOREIGN KEY (list_questions_id)
        REFERENCES list_questions (list_id)
            ON DELETE CASCADE
)

-- added
-- CORRECT