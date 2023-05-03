import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class ApplicationFormTest {

    @Test
    void testFormV1() {

        open("http://localhost:9999");
        $("[data-test-id=name] input").setValue("Хряков Порось");
        $("[data-test-id=phone] input").setValue("+79023004000");
        $("[data-test-id=agreement]").click();
        $("button").click();
        $("[data-test-id=order-success]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));

    }

    @Test
    void testFormV2() {

        open("http://localhost:9999");
        $("[data-test-id=name] input").setValue("Хряков Свин-Порось");
        $("[data-test-id=phone] input").setValue("+79023004000");
        $("[data-test-id=agreement]").click();
        $("button").click();
        $("[data-test-id=order-success]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));

    }

    @Test
    void testFormV3() {

        open("http://localhost:9999");
        $("[data-test-id=name] input").setValue("Хряков Поросёнок");
        $("[data-test-id=phone] input").setValue("+79023004000");
        $("[data-test-id=agreement]").click();
        $("button").click();
        $("[data-test-id=order-success]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));

    }

    @Test
    void testFormV4() {

        open("http://localhost:9999");
        $("[data-test-id=name] input").setValue("Хряков-Кряков Свин Порось");
        $("[data-test-id=phone] input").setValue("+79023004000");
        $("[data-test-id=agreement]").click();
        $("button").click();
        $("[data-test-id=order-success]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));

    }
}
