Общая сборка клиент-серверного приложения. 
Технологии - javaFX, PostgreSQL, Spring boot, gradle 

Собрать проект - gradle clean build 
Упаковать клиент - gradle jfxJar
Собрать проект если не установлен gradle на машине - ./gradlew clean build (unix)
gradlew.bat clean build (windows)

Можно не собирать, если собраные jar-архивы в гитовом репозитории


Для запуска сервера нужна База Данных 
порт - 5432(стандартный)
имя бд - bars
user/password - postgres(поправить в server/src/main/resources/application.yml)
запуск сервера - java -jar server/build/libs/server.jar
запуск клиента - java -jar client/build/jfx/app/client.jar

Логин/пароль для демонстрации - 123/123(В SecurityConfig прописан)
