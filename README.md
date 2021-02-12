# ISA projekat

> U repozitorijumu ISA se nalazi projekat
> koji simulira sistem apoteka.
> ISA predstavlja predmetni
> projekat, istoimenog predmeta na 
> Fakultetu tehničkih nauka u Novom Sadu,
> za školsku godinu 2020/2021.

Heroku: https://pharmacy-25-frontend.herokuapp.com/

Trello: https://trello.com/b/M5fKYB1P/isa-pharmacy

Sonar: https://sonarcloud.io/dashboard?id=majastamenic_ISA

Travis: https://travis-ci.com/github/majastamenic/ISA

### Tim 25 čine:
| Uloga | Student |
| ------ | ------ |
| Student 1 | Gojko Novčić RA 208/2017| 
| Student 2 | Nastasja Damjanac RA 38/2017| 
| Student 3 | Marija Milanović RA 197/2017|
| Student 4 | Maja Stamenić RA 65/2017|


Tehnologije:

  - Spring-boot
  - Angular
  - Postgre

# Pokretanje projekta
- Potrebno je skinuti projekat sa linka https://github.com/majastamenic/ISA

Baza podataka: Postgresql
  - Baza se nalazi na portu 5432
  - Potrebno je kreirati bazu pod nazivom isa
  - Takodje, šifra za bazu je: isa, a username: postgres
  - U sklopu foldera pharmacy/src/main/resources nalazi se skripta import.sql koje se pokreće pokretanjem backend projekta.
    
Backend:
  - U intellij-u otvorite folder pharmacy
  - Intellij će sam da importuje potrebne fajlove
  - U desnom ivici programa ima toolbar. Otvorite Maven, zatim Lifecycle i pokrenite compile.
  - Backend se nalazi na portu 8081.
  
Frontend:
  - Morate instalirati angular. Uputstvo:  https://cli.angular.io/
  - Otvorite Vaš Visual Studio Code i importujte folder pharmacy-frontend
  - Terminal pozicionirajte u folder pharmacy-frontend uz pomoć komand cd naziv_foldera
  - Zatim u terminal unesite komande:
```sh
                                $ npm install
                                $ ng serve
```

- Frontend ce biti pokrenut na portu `4200`. Ukoliko želite da frontend pokrenete na nekom drugom portu potrebno je umesto ng serve, izvršiti komandu ng serve --port željeni_port. Primer: `ng serve --port 8080`
- Takodje frontend možete pokrenuti i uz pomoć komande - `npm start`

### Komunikacija sa bolnicama
Ovaj projekat Vam nudi komunikaciju sa bolnicom putem:
* Http protokola 
* Sftp protokola
* gRPC protokola
* rabbitMq

Više informacija možete dobiti ukoliko pogledate sledeće videe:
- https://www.youtube.com/watch?v=74IY0mNCusE&feature=youtu.be
- https://www.youtube.com/watch?v=Tlyp3X1_Tak&feature=youtu.be

### Pozdrav, tim 25







