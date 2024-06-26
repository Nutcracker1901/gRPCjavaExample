# Протокол gRPC

Для работы приложения надо выполнить maven compile

## Введение

gRPC (gRPC Remote Procedure Calls) — это современный, высокопроизводительный RPC (Remote Procedure Call) фреймворк,
разработанный Google. gRPC позволяет клиентам и серверам обмениваться сообщениями через сетевые вызовы с использованием
протокола HTTP/2 и сериализации данных с помощью Protocol Buffers (protobuf).

## История RPC

RPC (Удаленный вызов процедур) — это протокол, который позволяет программе выполнять процедуры на удаленном сервере так,
как будто они выполняются локально. Концепция RPC была представлена в начале 1980-х годов. На протяжении десятилетий
было разработано множество реализаций RPC, включая следующие:

- **Sun RPC (ONC RPC)**: Один из первых широко распространенных RPC протоколов, разработанный Sun Microsystems.
- **CORBA (Common Object Request Broker Architecture)**: Протокол, который обеспечивает взаимодействие между различными
  объектами в распределенной системе.
- **DCE/RPC (Distributed Computing Environment / Remote Procedure Calls)**: Протокол, разработанный Open Software
  Foundation.
- **XML-RPC и SOAP**: Протоколы, которые используют XML для кодирования вызовов процедур и данных, отправляемых по HTTP.

## Что такое gRPC?

gRPC был разработан Google и выпущен как проект с открытым исходным кодом в 2015 году. Он предназначен для
высокопроизводительных, низколатентных распределенных вычислений и широко используется в облачных сервисах,
микросервисах и мобильных приложениях.

### Основные характеристики gRPC

- **HTTP/2**: Использует HTTP/2 для транспортировки данных, обеспечивая преимущества, такие как мультиплексирование
  потоков, сжатие заголовков и управление потоком.
- **Protocol Buffers**: Использует Protocol Buffers (protobuf) для сериализации данных, обеспечивая компактное и
  эффективное представление данных.
- **Многоязычная поддержка**: gRPC поддерживает множество языков программирования, включая Java, C++, Python, Go, Ruby и
  другие.
- **Двусторонняя потоковая передача**: Поддерживает различные типы вызовов, включая однонаправленные и двусторонние
  потоковые вызовы.

## Сравнение gRPC и REST

| Характеристика                | gRPC                                                               | REST                               |
|-------------------------------|--------------------------------------------------------------------|------------------------------------|
| Транспортный протокол         | HTTP/2                                                             | HTTP/1.1                           |
| Формат сообщений              | Protocol Buffers                                                   | JSON                               |
| Сериализация                  | Бинарная, компактная                                               | Текстовая, более громоздкая        |
| Поддержка языков              | Широкая (Java, C++, Python, Go, и др.)                             | Широкая (практически все языки)    |
| Типы вызовов                  | Unary, Server Streaming, Client Streaming, Bidirectional Streaming | Только Unary                       |
| Скорость и производительность | Высокая                                                            | Средняя                            |
| Модели данных                 | Строго определенные схемы (protobuf)                               | Свободно определенные схемы (JSON) |
| Генерация кода                | Да                                                                 | Нет                                |
| Поддержка версионности API    | Встроенная (через protobuf)                                        | Нужно реализовывать вручную        |

#

![](https://habrastorage.org/r/w1560/getpro/habr/upload_files/b59/c23/fa4/b59c23fa49a6144899ef5c7ede4bd64d.png)

#

#

![](https://habrastorage.org/r/w1560/getpro/habr/upload_files/6fd/ef9/d0f/6fdef9d0fc621a393675f29a0d1effda.png)

#

#

![](https://habrastorage.org/r/w1560/getpro/habr/upload_files/cbc/ca1/5af/cbcca15af298e128b807a8d4c38dd16b.png)

#

### Плюсы и минусы gRPC

#### Плюсы:

- Высокая производительность и низкая задержка благодаря HTTP/2 и бинарной сериализации.
- Поддержка двусторонней потоковой передачи данных.
- Сильная типизация данных через Protocol Buffers.
- Генерация кода клиента и сервера, что ускоряет разработку.
- Хорошая поддержка множественных языков.

#### Минусы:

- Более сложная настройка по сравнению с REST.
- Бинарный формат сообщений (protobuf) сложнее отлаживать без специальных инструментов.
- Меньшая совместимость с браузерами, так как gRPC требует HTTP/2.

### Плюсы и минусы REST

#### Плюсы:

- Простота и широкая известность среди разработчиков.
- Легкая отладка и тестирование благодаря использованию текстового формата JSON.
- Широкая совместимость с браузерами и веб-технологиями.
- Большое количество библиотек и инструментов для разработки.

#### Минусы:

- Более высокая задержка и меньшая производительность по сравнению с gRPC.
- Ограниченные возможности для потоковой передачи данных.
- Меньшая строгость типизации, что может привести к ошибкам на этапе выполнения.
- Отсутствие встроенных механизмов для генерации кода клиента и сервера.

## Заключение

gRPC представляет собой мощный инструмент для создания высокопроизводительных распределенных систем и микросервисов. Он
предлагает множество преимуществ по сравнению с традиционными RESTful сервисами, включая повышенную производительность,
строгую типизацию данных и поддержку двусторонней потоковой передачи. Однако, его сложность и требования к настройке
могут потребовать дополнительных усилий со стороны разработчиков.

REST, с другой стороны, остается популярным выбором благодаря своей простоте, совместимости и легкости в использовании.
Выбор между gRPC и REST зависит от конкретных требований вашего проекта и целей, которые вы ставите перед собой.
