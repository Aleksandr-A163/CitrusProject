# 🧪 API-Тесты для Swagger Petstore

Проект содержит автоматизированные **REST API** тесты для [Swagger Petstore API](https://petstore.swagger.io), реализованные с использованием **Java 17**, **JUnit 5**, **Rest-assured** и **Gradle**.

---

## 🛠 Используемый стек

<p align="center">
<a href="https://www.jetbrains.com/idea/"><img width="10%" title="IntelliJ IDEA" src="media/logo/Intelij_IDEA.svg"></a>
<a href="https://www.java.com/"><img width="10%" title="Java" src="media/logo/Java.svg"></a>
<a href="https://gradle.org/"><img width="10%" title="Gradle" src="media/logo/Gradle.svg"></a>
<a href="https://junit.org/junit5/"><img width="10%" title="JUnit5" src="media/logo/JUnit5.svg"></a>
<a href="https://junit.org/junit5/"><img width="10%" title="JUnit5" src="media/logo/RestAssured.svg"></a>

</p>

<div align="center">

 **Java 17** (Toolchain)  
 **Rest-assured 5.4.0**  
 **JUnit 5** (junit-jupiter)  
 **Gradle** (build automation)  
 **Swagger Petstore API**

</div>

---

## 📦 Структура проекта

```
VanillaRestAssured/
├─ src/
│  ├─ main/java/
│  │  └─ services/        # Класс API взаимодействия (PetStoreApi)
│  ├─ test/java/
│  │  └─ User/actions/    # API-тесты (CreateUserTest, DeleteUserTest, GetUserTest)
├─ build.gradle
├─ settings.gradle
└─ README.md
```

---

## 🚀 Как запустить

1. **Склонировать проект**

```bash
git clone https://github.com/your-user/VanillaRestAssured.git
cd VanillaRestAssured
```

2. **Запуск всех тестов**

```bash
./gradlew clean test
```

3. **Запуск конкретного теста**

```bash
./gradlew test --tests "User.actions.positive.CreateUserPositiveTest"
```

4. **Просмотр отчёта**

Открой `build/reports/tests/test/index.html` в браузере после завершения тестов.

---


## ✅ Реализованные сценарии

### CreateUser
**Позитивные тесты:**
- Успешное создание пользователя с валидными данными (`CreateUserPositiveTest`)

**Негативные тесты:**
- Создание пользователя без поля username (ожидается 400) (`CreateUserNegativeTest`)

### DeleteUser
**Позитивные тесты:**
- Успешное удаление существующего пользователя (`DeleteUserPositiveTest`)

**Негативные тесты:**
- Удаление несуществующего пользователя (ожидается 404) (`DeleteUserNegativeTest`)

### GetUser
**Позитивные тесты:**
- Получение существующего пользователя (`GetUserPositiveTest`)

**Негативные тесты:**
- Попытка получить несуществующего пользователя (ожидается 404) (`GetUserNegativeTest`)


## 📌 Особенности реализации

✔️ Используется Rest-assured DSL для описания запросов  
✔️ Обработка положительных и негативных сценариев  
✔️ Проверки status code и тела ответа  
✔️ API-методы вынесены в `PetStoreApi` (service-layer)

---

## 📧 Автор

**Aleksandr Anosov**  
GitHub: [@Aleksandr-A163](https://github.com/Aleksandr-A163)
