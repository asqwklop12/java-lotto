package lotto.util;

import lotto.enums.Grade;
import lotto.exception.BonusContainWinningResultException;
import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public final class AwardNumberUtil {


    private AwardNumberUtil() {
    }

    private static final String DELIMITER = ", ";

    public static Set<Integer> getAwardNumberList(String numbers) {
        return Arrays.stream(split(numbers))
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
    }


    private static String[] split(String string) {
        return string.split(DELIMITER);
    }

    public static List<Lotto> convertLotto(Set<Integer>[] inputLottos) {
        List<Lotto> lottos = new ArrayList<>();
        for (Set<Integer> lotto : inputLottos) {
            lottos.add(new Lotto(lotto));
        };
        return lottos;
    }
}
