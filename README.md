# Бэкенд для онлайн редактора визуальных новелл

### Установка проекта

Убедитесь, что у вас установлен [JDK версии 17](https://www.oracle.com/java/technologies/downloads/).

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
