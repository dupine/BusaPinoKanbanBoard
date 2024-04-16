CREATE TABLE task(
    id int AUTO_INCREMENT primary key,
    titolo varchar(50) NOT NULL,
    descrizione TEXT NOT NULL,
    assegnatario  varchar(30) NOT NULL,
    stato ENUM('nuovo', 'in lavorazione', 'completato'),
    priorita INT CHECK( priorita  BETWEEN 1 AND 10) NOT NULL
);