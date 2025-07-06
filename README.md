# 🧪 API-Тесты для Swagger Petstore

Проект содержит автоматизированные **REST API** тесты для [Swagger Petstore API](https://petstore.swagger.io), реализованные с использованием **Java 17**, **JUnit 5**, **Citrus** и **Gradle**.

---

## 🛠 Используемый стек

<p align="center">
<a href="https://www.jetbrains.com/idea/"><img width="10%" title="IntelliJ IDEA" src="media/logo/Intelij_IDEA.svg"></a>
<a href="https://www.java.com/"><img width="10%" title="Java" src="media/logo/Java.svg"></a>
<a href="https://gradle.org/"><img width="10%" title="Gradle" src="media/logo/Gradle.svg"></a>
<a href="https://junit.org/junit5/"><img width="10%" title="JUnit5" src="media/logo/JUnit5.svg"></a>
<a href="https://rest-assured.io/"><img width="10%" title="RestAssured" src="media/logo/Citrus.svg"></a>
</p>

<div align="center">

 **Java 17** (Toolchain)  
 **Citrus 3.3.0** (Integration Testing Framework)  
 **JUnit 5** (JUnit Jupiter)  
 **Gradle** (build automation)  
 **Swagger Petstore API**

</div>

---

## 🚀 Обновление: переход на Citrus Framework

Проект был переработан и теперь использует **Citrus** — мощный фреймворк для интеграционного тестирования API. Это позволило:

- отказаться от жёсткой привязки к Rest-assured;
- улучшить читаемость и поддержку сценариев;
- реализовать гибкую работу с переменными и валидацией;
- использовать как позитивные, так и негативные проверки в одном стиле.

---

## 🧩 Что изменилось

### 🆕 Citrus вместо Rest-assured

- ✅ Все тесты были переписаны с использованием **Citrus DSL** (Java, JUnit 5).
- ✅ Поддерживаются `POST`, `GET`, `DELETE` операции.
- ✅ Используется `TestRunner` и аннотация `@CitrusTest`.

### 📁 Конфигурация клиента

Вместо XML-файла используется Java-конфигурация:

```java
// src/test/java/config/CitrusConfig.java
@Configuration
public class CitrusConfig {
    @Bean
    public HttpClient restClient() {
        return CitrusEndpoints.http()
            .client()
            .requestUrl("http://localhost:8080")
            .build();
    }
}
```

Она подключается в каждом тесте через:

```java
@ContextConfiguration(classes = {CitrusConfig.class})
```

---

## ✅ Тесты в проекте

| Класс                         | Сценарий                                |
|------------------------------|------------------------------------------|
| `CreateUserPositiveTest`     | Успешное создание пользователя           |
| `GetUserPositiveTest`        | Получение существующего пользователя     |
| `DeleteUserPositiveTest`     | Удаление существующего пользователя      |
| `GetUserNegativeTest`        | Получение несуществующего пользователя   |
| `DeleteUserNegativeTest`     | Повторное удаление удалённого пользователя |

---

## 📦 Структура тестов

```
src
└── test
    ├── java
    │   ├── config
    │   │   └── CitrusConfig.java
    │   └── User.actions
    │       ├── positive
    │       │   ├── CreateUserPositiveTest.java
    │       │   ├── GetUserPositiveTest.java
    │       │   └── DeleteUserPositiveTest.java
    │       └── negative
    │           ├── GetUserNegativeTest.java
    │           └── DeleteUserNegativeTest.java
```

---

## ▶ Запуск

Выполнить все тесты:

```bash
./gradlew test
```

Запустить конкретный тест:

```bash
./gradlew test --tests "User.actions.positive.CreateUserPositiveTest"
```

---

## 📊 Просмотр отчётов

Открой файл:

```
build/reports/tests/test/index.html
```

Чтобы просмотреть результаты всех тестов в браузере.
