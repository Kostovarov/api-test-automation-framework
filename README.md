# API Test Automation Framework

Учебный проект для автоматизированного тестирования REST API.

## Стек

- Java 17
- REST Assured
- TestNG
- Maven
- Allure
- Jackson
- AssertJ
- Lombok

## Структура проекта

- `config` — конфигурация тестового окружения
- `dto` — request/response модели
- `service` — работа с API
- `steps` — переиспользуемые шаги
- `assertions` — проверки ответов
- `tests` — тестовые сценарии
- `utils` — вспомогательные классы

## Что реализовано

- позитивные и негативные API-тесты
- проверка HTTP status-кодов
- проверка тела ответа
- сериализация и десериализация JSON
- работа с тестовыми данными
- конфигурация через properties
- Allure-отчётность
- запуск тестов через Maven

## Запуск тестов

```bash
mvn clean test
```

## Allure отчёт

```bash
allure serve target/allure-results
```