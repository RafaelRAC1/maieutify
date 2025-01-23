CREATE TABLE list_questions 
(
    list_id INT IDENTITY(1,1) PRIMARY KEY,
    creator_id INT NOT NULL,
    creation_date DATE NOT NULL,
    last_updated DATE NOT NULL,
    difficulty FLOAT CHECK(difficulty BETWEEN 0 AND 5),
    title VARCHAR(255) NOT NULL,
    list_description TEXT NOT NULL,
    list_image VARCHAR(255),
    category_id INT NOT NULL,
    CONSTRAINT list_questions__creator_fk FOREIGN KEY (creator_id)
        REFERENCES app_user (user_id)
            ON DELETE CASCADE,
    CONSTRAINT list_questions__category_fk FOREIGN KEY (category_id)
        REFERENCES category (category_id)
)

-- added
-- CORRECT2