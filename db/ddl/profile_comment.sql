CREATE TABLE profile_comment 
(
    comment_id INT IDENTITY(1,1) PRIMARY KEY,
    profile_id INT NOT NULL,
    commenter_id INT NOT NULL,
    comment TEXT NOT NULL,
    edited CHAR DEFAULT 'N',
    last_updated DATE DEFAULT(GETUTCDATE()),
    CONSTRAINT profile_comment__profile_id_fk FOREIGN KEY (profile_id)
        REFERENCES app_user (user_id)
            ON DELETE NO ACTION,
    CONSTRAINT profile_comment__commenter_id_fk FOREIGN KEY (commenter_id) 
        REFERENCES app_user (user_id)
            ON DELETE CASCADE
)

-- ADDED