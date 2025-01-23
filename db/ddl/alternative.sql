CREATE TABLE alternative 
(
    alternative_id INT IDENTITY(1,1) PRIMARY KEY,
    question_id INT NULL,
    alternative_character CHAR NOT NULL,
    alternative_description VARCHAR(255) NOT NULL,
    correct BIT NOT NULL,
    CONSTRAINT alternative__question_id_fk FOREIGN KEY (question_id)
        REFERENCES question (question_id) 
            ON DELETE CASCADE
)   

-- ADDED
-- CORRECT
