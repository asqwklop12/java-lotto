package lotto.util;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.enums.Grade;

public final class AwardNumberUtil {


  private AwardNumberUtil() {
  }

  private static final String DELIMITER = ", ";

  public static Set<Integer> getAwardNumberList(String numbers) {
    return Arrays.stream(split(numbers))
        .map(Integer::parseInt)
        .collect(Collectors.toSet());
  }

  public static Grade matchCount(Set<Integer> lotteryTicket, Set<Integer> winningLotto,
      int bonusNumber) {
    int count = 0;
    for (int lottoNumber : lotteryTicket) {
      count = lottoMatchCount(winningLotto, count, lottoNumber);
    }
    return Grade.valueOf(count, getBonusCheck(lotteryTicket, bonusNumber));
  }

  private static boolean getBonusCheck(Set<Integer> winningLotto, int lottoNumber) {
    return winningLotto.contains(lottoNumber);
  }

  private static int lottoMatchCount(Set<Integer> winningLotto, int count, int lottoNumber) {
    if (winningLotto.contains(lottoNumber)) {
      count++;
    }
    return count;
  }

  private static String[] split(String string) {
    return string.split(DELIMITER);
  }

}
