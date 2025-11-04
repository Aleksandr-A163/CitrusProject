# 🚀 Запуск тестов CitrusProject через Selenoid

## 📦 Установка и запуск Selenoid

```bash
docker-compose up -d
```

- Панель управления: [http://localhost:8080](http://localhost:8080)
- Эндпоинт Selenium: `http://localhost:4444/wd/hub`

## 🧪 Запуск тестов

### Обычный Chrome
```bash
./gradlew clean test -Dbrowser=chrome
```

### Мобильный Chrome (эмуляция iPhone X)
```bash
./gradlew clean test -Dbrowser=chromeMobile
```

## ⚙️ Параллельный запуск
В `build.gradle` добавлен параметр:
```groovy
test {
    useJUnitPlatform()
    maxParallelForks = Runtime.runtime.availableProcessors().intdiv(2) ?: 1
}
```
