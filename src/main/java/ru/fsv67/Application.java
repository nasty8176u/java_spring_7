package ru.fsv67;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//1. Подключить OpenAPI 3 и swagger к проекту с библиотекой
//2. Описать все контроллеры, эндпоинты и возвращаемые тела с помощью аннотаций OpenAPI 3
//3. В качестве результата, необходимо прислать скриншот(ы) страницы swagger (с ручками)
//
//Дополнительное задание (сдавать не нужно):
//придумать какие-то доменные сервисы (по типу библиотеки и заметок) и попытаться спроектировать его API.

@OpenAPIDefinition(
        info = @Info(
                title = "Библиотека",
                description = "Библиотека с функционалом выдачи книг читателям",
                version = "1.0.0"
        )
)
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
