# Список покупок
## Web-сервис “Shoplist”.
  
Данные по покупателям и продуктам хранятся в БД в виде 2-х таблиц items, roles. 
item относится к role как многие к одному.


**ПО:**
-   Java 17
-   Maven
-   Spring boot
-   Hibernate
-   REST
-   Thymeleaf
-   Docker-compouse
-   БД PostgreSQL
-   AspectJ
-   Javadoc
-   JUnit 5
-   H2

  
**Описание endpoints:**

 
**GET /roles** – получение списка ролей/покупателей <br>
Данный endpoint выводит в браузере список ролей/покупателей

**GET /items/{roleid}** – получение списка продуктов у роли с roleid <br>
Данный endpoint выводит список продуктов у конкретной роли.

**GET /itemadd/{id}** – форма добавления продукта<br>
Данный endpoint добавляет новый продукт в список продуктов для роли c выбранным id.

**GET /updateItem/{id}** – изменение существующего продукта<br>
Данный endpoint обновляет существующий продукт в списоке продуктов для роли c выбранным id.

**POST /saveitem/{roleid}** - сохранениее продукта<br>
Данный endpoint созраняет в БД изменение продукта.

**GET /addrole** ввод данных для новой роли<br>
Данный endpoint выводит страницу с полями для ввода новой роли. 

**POST /saverole** сохранение роли<br>
Данный endpoint сохраниеняет новую роль в БД

**GET /deleteitem/{id}** удаление продукта по id<br>
Данный endpoint удаляет продукт из БД.

**GET /deleteRole/{id}** удаление роли по id<br>
Данный endpoint удаляет роль из БД.

### Запуск

1. Клонировать репозиторий
   ```sh
   git clone git@github.com:RedPlanet3/shoplist.git
   ```
3. Убедитесь что докер [docker](https://www.docker.com/) установлен и запущен
4. В папке проекта запустить команду
      ```sh
      docker-compose up
      ```

<!-- USAGE -->
## Использование

После запуска проекта перейти по адресу
`https://localhost`

