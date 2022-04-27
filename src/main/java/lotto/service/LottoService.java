package lotto.service;

import java.util.List;
import lotto.model.Guest;
import lotto.model.Product;
import lotto.model.Store;
import lotto.util.AwardNumberUtil;

public class LottoService {

  public List<Product> visit(Guest guest, Store store) {
    return guest.choiceProduct(store);
  }

  public Product insertWinnerNumber(String winnerNumber) {
    return new Product(AwardNumberUtil.getAwadNumberList(winnerNumber));
  }
}
