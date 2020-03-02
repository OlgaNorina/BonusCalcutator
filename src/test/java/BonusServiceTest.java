import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    @Test
    void ShouldCalculatedForRegisteredAndUnderLimit() {
        BonusService service = new BonusService();
// подготавливаем данные:
        long amount = 1000_60;
        boolean registered = true;
        long expected = 30;
// вызываем целевой метод:
        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);

    }

    @Test
    void ShouldCalculatedForRegisteredAndOverLimit() {
        BonusService service = new BonusService();
// подготавливаем данные:
        long amount = 2_000_000_60;
        boolean registered = true;
        long expected = 500;
// вызываем целевой метод:
        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }

    @Test
    void ShouldCalculatedForNonRegisteredAndOverLimit() {
        BonusService service = new BonusService();
// подготавливаем данные:
        long amount = 10_000_000_00;
        boolean registered = false;
        long expected = 500;
// вызываем целевой метод:
        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }

    @Test
    void ShouldCalculatedForNonRegisteredAndUnderLimit() {
        BonusService service = new BonusService();
// подготавливаем данные:
        long amount = 10_000_00;
        boolean registered = false;
        long expected = 100;
// вызываем целевой метод:
        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }

    @Test
    void ShouldCalculatedForRegisteredAnd0() {
        BonusService service = new BonusService();
// подготавливаем данные:
        long amount = 00000;
        boolean registered = false;
        long expected = 0;
// вызываем целевой метод:
        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }

    @Test
    void ShouldCalculatedForNonRegisteredAnd0() {
        BonusService service = new BonusService();
// подготавливаем данные:
        long amount = 00000;
        boolean registered = true;
        long expected = 0;
// вызываем целевой метод:
        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }

    @Test
    void ShouldCalculatedForRegisteredAndNearUnderLimit() {
        BonusService service = new BonusService();
// подготавливаем данные:
        long amount = 16_633_34;
        boolean registrated = true;
        long expected = 499;
// вызываем целевой метод:
        long actual = service.calculate(amount, registrated);
        assertEquals(expected, actual);
    }

    @Test
    void ShouldCalculatedForRegisteredAndNearOverLimit() {
        BonusService service = new BonusService();
// подготавливаем данные:
        long amount = 16_700_00;
        boolean registrated = true;
        long expected = 500;
// вызываем целевой метод:
        long actual = service.calculate(amount, registrated);
        assertEquals(expected, actual);
    }

    @Test
    void ShouldCalculatedForNonRegisteredAndNearUnderLimit() {
        BonusService service = new BonusService();
// подготавливаем данные:
        long amount = 49_900_00;
        boolean registrated = false;
        long expected = 499;
// вызываем целевой метод:
        long actual = service.calculate(amount, registrated);
        assertEquals(expected, actual);
    }

    @Test
    void ShouldCalculatedForNonRegisteredAndNearOverLimit() {
        BonusService service = new BonusService();
// подготавливаем данные:
        long amount = 50_100_00;
        boolean registrated = false;
        long expected = 500;
// вызываем целевой метод:
        long actual = service.calculate(amount, registrated);
        assertEquals(expected, actual);
    }

    @Test
    void ShouldCalculatedForRegisteredAndMultiplicationLongAmount() {
        BonusService service = new BonusService();
// подготавливаем данные:
        long amount = 9_999_999_99 * 9_999_999_99;
        boolean registrated = true;
        long expected = 500;
// вызываем целевой метод:
        long actual = service.calculate(amount, registrated);
        assertEquals(expected, actual);
    }

    @Test
    void ShouldCalculatedForRegisteredAndAmountDeletedByZero() {
        BonusService service = new BonusService();
// подготавливаем данные:
        long amount = 1_000_60 / 0;
        boolean registrated = true;
        long expected = 0;
// вызываем целевой метод:
        long actual = service.calculate(amount, registrated);
        assertEquals(expected, actual);
    }
    @Test
    void ShouldCalculatedForRegisteredAndNegativAmount() {
        BonusService service = new BonusService();
// подготавливаем данные:
        long amount = - 1_000_00;
        boolean registrated = true;
        long expected = 0;
// вызываем целевой метод:
        long actual = service.calculate(amount, registrated);
        assertEquals(expected, actual);
    }
}