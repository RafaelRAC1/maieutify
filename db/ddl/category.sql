CREATE TABLE category 
(
    category_id INT IDENTITY(1,1) PRIMARY KEY,
    category_name VARCHAR(50) UNIQUE
)

-- added