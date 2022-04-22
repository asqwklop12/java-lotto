package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

  private StringCalculator stringCalculator;

  @BeforeEach
  void init() {
    stringCalculator = new StringCalculator();
  }

  @Test
  @DisplayName("덧셈 테스트")
  void addTest() {
    assertThat(stringCalculator.calculate("1 + 1")).isEqualTo(2);
  }

  @Test
  @DisplayName("연산 횟수 3개 이상 테스트")
  void addTripleTest() {
    assertThat(stringCalculator.calculate("1 + 1 + 1 + 1")).isEqualTo(4);
  }

  @Test
  @DisplayName("뻴셈 테스트")
  void minasTest() {
    assertThat(stringCalculator.calculate("2 - 1")).isEqualTo(1);
  }

  @Test
  @DisplayName("곱셈 테스트")
  void multipleTest() {
    assertThat(stringCalculator.calculate("2 * 4")).isEqualTo(8);
  }

  @Test
  @DisplayName("나눗셈 테스트")
  void divTest() {
    assertThat(stringCalculator.calculate("4 / 2")).isEqualTo(2);
  }

  @Test
  @DisplayName("복합 테스트")
  void complexTest() {
    assertThat(stringCalculator.calculate("4 / 2 * 3")).isEqualTo(6);
  }

  @Test
  @DisplayName("입력 값이 null이거나 빈 공백 문자일 경우")
  void blankCheckTest() {
    assertThatExceptionOfType(RuntimeException.class)
        .isThrownBy(() -> {
          stringCalculator.calculate(null);
          stringCalculator.calculate("    ");
        }).withMessageMatching("null");
  }
  @Test
  @DisplayName("사칙연산 기호가 아닌 경우")
  void wrongSignTest() {
    assertThatExceptionOfType(RuntimeException.class)
        .isThrownBy(() -> {
          stringCalculator.calculate("1 ^ 1");
        }).withMessageMatching("잘못된 부호를 넣었습니다. 다시 확인해주세요.");
  }

}
