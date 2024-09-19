INSERT INTO MY_USER_DETAILS(USERNAME, PASSWORD, ROLES) -- SQL statement to insert user details if the user does not already exist.
SELECT 'bob', 'pass', 'USER' -- Values to insert: username 'bob', password 'pass', and role 'USER'.
WHERE NOT EXISTS -- Condition to check if the user does not already exist.
(SELECT 1 FROM MY_USER_DETAILS WHERE USERNAME= 'bob'); -- Subquery to check if a user with the username 'bob' already exists.
INSERT INTO BOOK(TITLE, AUTHORS) -- SQL statement to insert book details
SELECT 'The Great Gatsby', 'F. Scott Fitzgerald'; -- Values to insert: title 'The Great Gatsby' and authors 'F. Scott Fitzgerald'.