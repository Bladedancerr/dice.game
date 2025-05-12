CREATE TABLE users (
    id BINARY(16) NOT NULL PRIMARY KEY,
    username VARCHAR(255),
    password VARCHAR(255),
    email VARCHAR(255),
    phone_number VARCHAR(50),
    created_at DATETIME
);

CREATE TABLE tables (
    id BINARY(16) NOT NULL PRIMARY KEY,
    host_id BINARY(16),
    guest_id BINARY(16),
    host_username VARCHAR(30),
    guest_username VARCHAR(30),
    status VARCHAR(50),

    CONSTRAINT fk_host FOREIGN KEY (host_id) REFERENCES users(id),
    CONSTRAINT fk_guest FOREIGN KEY (guest_id) REFERENCES users(id)
);
