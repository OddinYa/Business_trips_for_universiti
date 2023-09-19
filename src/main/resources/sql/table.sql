CREATE TABLE trip (
                        id SERIAL PRIMARY KEY,
                        start_date DATE,
                        end_date DATE,
                        city varchar(255)
);

CREATE TABLE employee (
                          id SERIAL PRIMARY KEY,
                          name VARCHAR(255),
                          surname VARCHAR(255),
                          position VARCHAR(255),
                          trip_id INTEGER,
                          FOREIGN KEY (trip_id) REFERENCES trip(id)
);