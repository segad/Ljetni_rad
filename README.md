Ljetni rad EDUNOVA
Mini blagajna

Aplikacija ima sljedeće stavke:
1.Kupci
2.Artikli
3.Narudžbe
4.GitHub
5.Izlaz iz aplikacije

Mogućnosti aplikacije:
*KUPCI*
1. Pregled kupaca
2. Unos kupaca
	- ime
	- prezime
	- telefon
	- adresa
	- ID kupca (automatski ga dodijeljuje kako bi svaki kupac imao jedinstven ID)

3. Izmjena kupaca
	- moguće je izmjeniti svaku stavku zasebno osim ID-a

4. Brisanje kupaca 
5. Povratak u glavni izbornik

*ARTIKLI*
1. Pregled artikala
2. Unos artikla
	- naziv
	- dobavljač
	- mjerna jedinica (kom, m, l, kg)
	- stanje artikla (misli se na količinu)
	- cijena artikla
	- šifra artika (autmatski se dodijeljuje kako bi svaki artikl imao jedinstvenu šifru)
3. Izmjena artikla
	- moguće je izmjeniti svaku stavku zasebno osim šifre artikla
4. Brisanje artikla
5. Povratak u glavni izbornik

*NARUDŽBE*
1. Pregled narudžbi
	- ispisuju se broj narudžbe te kupac
	- za detalje mora se unjeti broj narudžbe
	- ispisuje se kupac, artikl, količina, jedinična cijena, količina, te suma svake stavke
	te na kraju ukupan iznos 
2. Unos narudžbe
	- ispisuju se kupci unešeni u bazu. Korisnik mora odabrati jednog kupca od ponuđenog
	- ispisuju se artikli koji su unešeni u bazu. Korisnik mora odabrati šifru artikla
	te količinu koju korisnik unosi.
	- postavlja se pitanje želi li dodati još artikala (da/ne)
	- ukoliko se odabere opcija da, ispisuju se artikli te se ponavlja procedura
	- ukoliko se odabere opcija ne, narudžba je završena te se vraća natrag u izbornik narudžbi
Dodatno: svaka narudžba ima svoj jedinstveni ID koji se ne može mijenjati
3. Brisanje narudžbi
	- izlistaju se sve narudžbe te korisnik mora odabrati broj narudžbe
	- postavlja se sigurnosno pitanje da li je korisnik siguran u svoj odabir
	- narudžba se briše
4. Povratak u glavni izbornik

*GitHUB*
	- otvara se GitHUB sa kodom aplikacje

*Izlaz iz aplikacije*
	- program se završava

Dodatno:
	- svi unosi sadrže kontrolu unosa. Nije moguće unjeti neispravan unos.
	- nedostaje ER dijagram baze podataka koji će biti kreiran kasnije.
