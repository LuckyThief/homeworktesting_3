import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class ApplicationFormTest {

    @BeforeEach
    void setUpTests() {
        open("http://localhost:9999/");
    }

    @Test
    void shouldSendForm() {

        $("[data-test-id=name] input").setValue("Хряков Порось");
        $("[data-test-id=phone] input").setValue("+79023004000");
        $("[data-test-id=agreement]").click();
        $("button").click();
        $("[data-test-id=order-success]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));

    }

    @Test
    void shouldSendFormWithDashInName() {

        $("[data-test-id=name] input").setValue("Хряков Свин-Порось");
        $("[data-test-id=phone] input").setValue("+79023004000");
        $("[data-test-id=agreement]").click();
        $("button").click();
        $("[data-test-id=order-success]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));

    }

    @Test
    void shouldSendFormWithLetterYoInName() {

        $("[data-test-id=name] input").setValue("Хряков Поросёнок");
        $("[data-test-id=phone] input").setValue("+79023004000");
        $("[data-test-id=agreement]").click();
        $("button").click();
        $("[data-test-id=order-success]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));

    }

    @Test
    void shouldSendFormWithDashAndWhitespaceInName() {

        $("[data-test-id=name] input").setValue("Хряков-Кряков Свин Порось");
        $("[data-test-id=phone] input").setValue("+79023004000");
        $("[data-test-id=agreement]").click();
        $("button").click();
        $("[data-test-id=order-success]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));

    }
}
