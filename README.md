Projekt zgodnie z wymaganiami zawiera dwa branche: master oraz review, na którym znajduje się rozwiązanie zadania rekrutacyjnego. W celu lokalnego uruchomienia kodu 
należy wykonać merge brancha review do master, a następnie sklonować repozytrium, bądź też sklonować bezpośrednio brach review przy pomocy polecenia 
git clone -b review https://github.com/Marcin-Bojanowski/nask-exercise.git

Budowanie programu
W celu zbudowanie aplikacji, należy przejeść do folderu głównego i uruchomić wiersz poleceń bądź inne podobne narzędzie,
a następnie posłużyć się komendą:
mvn clean install
w przybadku braku narzędzia maven można posłużyć się wersja dołączoną do projektu:
./mvnw clean install (mvnw clean install)
Następnie należy uruchomić aplikację przy pomocy polecenia mvn spring-boot:run lub 
./mvnw spring-boot:run (mvnw spring-boot:run)
Projekt można uruchomić również przy pomocy Dockera. W takim wypadku, po zbudowaniu projektu należy posłużyć się komendą:
docker-compose up --build
Po uruchmieniu projektu należy uruchomić przeglądarkę i przejść pod adres http://localhost:8080/swagger-ui/ , pod którym to dostępne są endpointy, za pomoca których można sprawdzić 
działanie aplikacji.
Jeśli projekt został uruchomiony za pomocą Dockera, to możliwe będzie również monitorowanie aplikacji za pomocą Prometheusa. W tym celu, za pomocą przeglądarki należe udać się 
pod adres http://localhost:9090/
