package lotto.model;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.enums.Grade;
import lotto.exception.LottoLengthException;

public final class Lotto {

  private static final int DEFAULT_LOTTO_SIZE = 6;

  private final Grade grade;
  private final Set<LottoNumber> lottoNumbers;

  public Lotto(Set<Integer> lottoNumbers) {
    this(lottoNumbers, Grade.NONE);
  }

  public Lotto(Set<Integer> lottoNumbers, Grade grade) {
    valid(lottoNumbers);
    this.grade = grade;
    this.lottoNumbers = lottoNumbers
        .stream().map(LottoNumber::new)
        .collect(Collectors.toSet());
  }

  public static Lotto from(Set<Integer> winnerNumbers) {
    return new Lotto(winnerNumbers);
  }

  private void valid(Set<Integer> lottoNumbers) {
    if (DEFAULT_LOTTO_SIZE != lottoNumbers.size()) {
      throw new LottoLengthException();
    }
  }

  public Lotto reflectLottoGrade(int matchCount, boolean matchBonus) {
    if (matchBonus) {
      matchCount++;
    }
    return new Lotto(numbers(), Grade.valueOf(matchCount, matchBonus));
  }

  public Set<Integer> numbers() {
    return lottoNumbers.stream()
        .map(LottoNumber::currentNumber)
        .collect(Collectors.toSet());
  }

  public Grade currentGrade() {
    return this.grade;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Lotto lotto = (Lotto) o;
    return Objects.equals(lottoNumbers, lotto.lottoNumbers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lottoNumbers);
  }

  @Override
  public String toString() {
    return lottoNumbers.toString();
  }
}