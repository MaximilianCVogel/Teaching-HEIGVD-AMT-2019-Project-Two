USE users;

-- Add admin --
INSERT INTO users(name, password, email, role) VALUES ('admin', 'goodpwd123', 'admin@boozify.com', 1);

-- Add users --
INSERT INTO users(name, password, email) VALUES ('Alan Desmund', 'pass123', 'alan.so.high@blaze.it'), ('Bobby Gerwitz', 'bobbycool', 'bobby.g@gmail.com');