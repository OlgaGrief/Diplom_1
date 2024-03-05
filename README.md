#Diplom_1

## ОПИСАНИЕ

Нужно протестировать программу, которая помогает заказать бургер в [Stellar Burgers](https://stellarburgers.nomoreparties.site/)
* Склонирован [репозиторий](https://github.com/yandex-praktikum/QA-java-diplom-1) с заготовкой кода.
* Покрыты тестами классы _Bun_, _Burger_, _Ingredient_, _IngredientType_, _Database_.
* Использованны моки и параметризация.

## ТЕХНОЛОГИИ и БИБЛИОТЕКИ В ПРОЕКТЕ
1. Java 11
2. Mockito 3.12.4
3. JUnit 4.13.2
4. Maven 3.8.1
5. Jacoco 0.8.7

## ЗАПУСК

* Команда для запуска тестов: `mvn clean test`.
* Команда для генерации отчета: `mvn verify`.
* Просмотр отчета: необходимо перейти в папку _target/site/jacoco_ и открыть файл _index.html_ через браузер.