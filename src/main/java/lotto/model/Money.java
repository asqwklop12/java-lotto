package lotto.model;

import java.util.Objects;
import lotto.exception.MoneyEmptyException;
import lotto.exception.MoneyNegativeException;

public final class Money {
  private static final long EMPTY_VALUE = 0L;
  private final Long value;

  public Money() {
    this(EMPTY_VALUE);
  }

  public Money(Long value) {
    valid(value);
    this.value = value;
  }

  private void valid(Long value) {
    if(value < EMPTY_VALUE) {
      throw new MoneyNegativeException();
    }
    if(value == EMPTY_VALUE) {
      throw new MoneyEmptyException();
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Money money = (Money) o;
    return Objects.equals(value, money.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }

  @Override
  public String toString() {
    return value.toString();
  }
}
