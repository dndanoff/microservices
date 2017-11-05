DELETE FROM auth.USER;

INSERT INTO auth.USER (user_id, username, password, enabled) VALUES 
	(default, 'denis.danov@dreamix.eu', '$2a$10$D4OLKI6yy68crm.3imC9X.P2xqKHs5TloWUcr6z5XdOqnTrAK84ri', true);