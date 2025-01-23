CREATE TABLE list_questions__user 
(
    list_questions__user_id INT IDENTITY(1,1) PRIMARY KEY,
    user_id INT NOT NULL,
    list_id INT NOT NULL,
    time_taken TIME,
    CONSTRAINT list_questions__user__user_id_fk FOREIGN KEY (user_id)
        REFERENCES app_user (user_id)
            ON DELETE CASCADE
)   

-- ADDED
-- CORRECT2