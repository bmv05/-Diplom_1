Первая часть дипломного проекта по курсу Автоматизатор тестирования на Java

**Юнит-тесты**

Программа, которая помогает заказать бургер в Stellar Burgers, покрыта юнит-тестами.
В работе выполнены следующие требования:
1. Покрыты тестами классы Bun, Burger, Ingredient, IngredientType. Процент покрытия = 100%
2. Подключены билиотеки Jacoco, Mockito, JUnit 4
3. Использованы моки, стабы и параметризация там, где нужно


В проекте использованы такие технологии, как:

* Java 11;
* junit 4.13.2;
* maven 4.0.0;
* mockito 3.12.4;
* jacoco 0.8.7;
* rest-assured 5.3.0;
* allure-junit4 2.23.0;
* 
Чтобы выполнить автотесты и сгенерировать отчет, необходимо запустить в консоли команду "mvn clean test" и "allure serve target/surefire-reports/"
