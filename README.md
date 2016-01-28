# test-sample

1) Заходим в консоль
sudo -u postgres psql

2) Создаем базу
CREATE DATABASE sample_db;

3) Создаем пользователя
CREATE USER sample_user WITH password 'sample';

4) Даем права на базу
GRANT ALL privileges ON DATABASE sample_db TO sample_user;

5) Выходим из консоли, переходим в каталог с приложением и запускаем
mvn tomcat7:run-war

6) В браузере переходим по адресу
http://localhost:8080/test-sample/
