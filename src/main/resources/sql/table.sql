CREATE TABLE travel (
                        id SERIAL PRIMARY KEY,
                        start_date DATE,
                        end_date DATE
);

CREATE TABLE employee (
                          id SERIAL PRIMARY KEY,
                          name VARCHAR(255),
                          surname VARCHAR(255),
                          position VARCHAR(255),
                          travel_id INTEGER,
                          FOREIGN KEY (travel_id) REFERENCES travel(id)
);