package lotto.view;

import lotto.util.AwardNumberUtil;

import java.util.*;

public final class InputTable {

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputTable() {
    }

    public static Long inputHaveMoney() {
        return Long.parseLong(SCANNER.nextLine());
    }

    public static String inputAwardNumber() {
        return SCANNER.nextLine();
    }

    public static Integer inputBonusNumber() {
        return Integer.parseInt(SCANNER.nextLine());
    }

    public static int inputManualCount() {
        return Integer.parseInt(SCANNER.nextLine());
    }

    public static List<Set<Integer>> inputManualLotto(int manalLottoCount) {
        List<Set<Integer>> lottos = new ArrayList<>();
        while (manalLottoCount-- != 0) {
            lottos.add(new HashSet<>(AwardNumberUtil.getAwardNumberList(SCANNER.nextLine())));
        }
        return lottos;
    }
}
