# Бэкенд для онлайн редактора визуальных новелл

### Установка проекта

Убедитесь, что у вас установлен [JDK версии 17](https://www.oracle.com/java/technologies/downloads/) и база данных [MySQL](https://dev.mysql.com/downloads/installer/)

На Windows: убедитесь, что запущена служба MySQL80 (Диспетчер задач -> Службы)

По-умолчанию:

user - mysql

password - 1232
```
create database onlinevn;
grant all on onlinevn.* to mysql;
```

```
./mvnw dependency:resolve
```

### Компиляция и запуск сервера для разработки

```
./mvnw spring-boot:run
```

### Создание JAR файла

```
./mvnw clean package
java -jar target/[название].jar
```

### REST API
Каждый объект имеет целочисленное id. Создавая объекты, можно не указывать id.

Ассеты (Asset):
```
Integer id
String filename
String type
Integer novelId
```
```
GET /asset?novelId=...&type=...
GET /asset/{id}
POST /asset?file=...
PUT /asset/{id}
DELETE /asset/{id}
```

Отображаемые объекты (Item):
```
Integer id
Integer coordX
Integer coordY
Integer assetId
```
```
GET /item
GET /item/{id}
POST /item
PUT /item/{id}
DELETE /item/{id}
```
Фреймы (Frame):
```
Integer id
Integer novelId
Integer frameType
String text
String name
Integer nextFrame
Integer prevFrame
List<Integer> items
```
```
GET /frame
GET /frame/{id}
POST /frame
PUT /frame/{id}
PATCH /frame/{id}?itemId=...
DELETE /frame/{id}?itemId=...
```
Новеллы (Novel):
```
Integer id
String name
String description
Integer genre
Integer status
Integer viewCount
Integer firstFrame
```
```
GET /novel?genre=...
GET /novel/{id}
POST /novel
PUT /novel/{id}
PATCH /novel/{id}
DELETE /novel/{id}
```





