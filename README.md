Основная функциональность
Реализована система ETL (Extract-Transform-Load) для обработки больших данных: загрузка сырых данных, их очистка/трансформация и выгрузка в аналитическую БД. Часто это сервис мониторинга фильмов/музыки с API, дашбордами и микросервисами (Movie ETL, API Gateway, PostgreSQL).
​
Используемый стек
Backend: Python + FastAPI (или Flask) для REST API

Базы данных: PostgreSQL (основная), ClickHouse (аналитика), Redis (кэш)

ETL: Apache Airflow для оркестрации задач

Контейнеры: Docker Compose

Мониторинг: Prometheus + Grafana, ELK-stack (логи)

Тестирование: Pytest
