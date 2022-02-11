package dev.alnat.githubcitest;

import dev.alnat.githubcitest.config.PostgreSQLTestContainerConfiguration;
import dev.alnat.githubcitest.service.TestService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.time.LocalDateTime;

@SpringBootTest
@ContextConfiguration(classes = PostgreSQLTestContainerConfiguration.class) // Поднимаем БД в контейнере
class GithubCiTestApplicationTests {

    @Autowired
    private TestService testService;

    @Test
    void simpleTest() {
        final var testString = "test";
        Assertions.assertTrue("test".equalsIgnoreCase(testString));
    }

    @Test
    void dbTest() {
        Assertions.assertTrue(testService.test());
    }

    @Test
    void dependencyTest() {
        Assertions.assertTrue(testService.getDependency().getCreated().isBefore(LocalDateTime.now()));
    }

}
