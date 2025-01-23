CREATE TABLE app_user 
(
    user_id INT IDENTITY(1,1) PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    user_password VARCHAR(255) NOT NULL,
    pfp VARCHAR(255),
    display_name VARCHAR(255) NOT NULL,
    registration_date DATE NOT NULL,
    tags VARCHAR(255),
    bio TEXT
)

-- added