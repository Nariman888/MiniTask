CREATE TABLE roles(
                      id SERIAL PRIMARY KEY NOT NULL,
                      role VARCHAR NOT NULL
);

CREATE TABLE users(
                      id SERIAL PRIMARY KEY NOT NULL,
                      email VARCHAR NOT NULL,
                      password VARCHAR NOT NULL,
                      full_name VARCHAR NOT NULL
);

CREATE TABLE users_roles(
                            users_id INT DEFAULT 0,
                            roles_id INT DEFAULT 0,
                            FOREIGN KEY (users_id) REFERENCES users (id),
                            FOREIGN KEY (roles_id) REFERENCES roles (id)
);
CREATE TABLE company(
                         id SERIAL PRIMARY KEY NOT NULL,
                         name VARCHAR NOT NULL
);
CREATE TABLE specialty(
                         id SERIAL PRIMARY KEY NOT NULL,
                         name VARCHAR NOT NULL
);
CREATE TABLE questionnaire(
                      id SERIAL PRIMARY KEY NOT NULL,
                      user_name VARCHAR NOT NULL,
                      user_surname VARCHAR NOT NULL,
                      user_date VARCHAR NOT NULL,
                      skill TEXT NOT NULL,
                      company_id INT DEFAULT 0,
                      CONSTRAINT fk_questionnaire_company
                          FOREIGN KEY (company_id)
                              REFERENCES  company (id),
                      specialty_id INT DEFAULT 0,
                      CONSTRAINT fk_questionnaire_specialty
                          FOREIGN KEY (specialty_id)
                              REFERENCES specialty (id),
                      user_id INT DEFAULT 0,
                      CONSTRAINT fk_questionnaire_user
                          FOREIGN KEY (user_id)
                              REFERENCES users (id)
);