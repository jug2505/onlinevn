# Бэкенд для онлайн редактора визуальных новелл

### Установка проекта

Убедитесь, что у вас установлен [JDK версии 17](https://www.oracle.com/java/technologies/downloads/).

БД Mysql

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

При создании объекта, хранящего в себе другой объект (пример: Item хранит Asset) не указывайте id,
если хотите создать новый вложеный объект (Asset из примера). При указании id будет происходить поиск существующего
объекта в БД.


Ассеты (Asset):
```
String filename
String type
```
```
GET /asset
GET /asset/{id}
POST /asset
PUT /asset
```

Отображаемые объекты (Item):
```
Integer coordX
Integer coordY
Asset asset
```
```
GET /item
GET /item/{id}
POST /item
PUT /item
```

Новеллы (Novel):
```
String name
String description
Integer genre
Integer status
Integer viewCount
Integer firstFrame
```
```
GET /novel
GET /novel/{id}
POST /novel
PUT /novel
```

Фреймы (Frame):
```
Integer novel
Integer frameType
String text
String name
Integer nextFrame
Integer prevFrame
List<Item> items
```
```
GET /frame
GET /frame/{id}
POST /frame
PUT /frame
```



