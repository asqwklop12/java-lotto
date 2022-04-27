package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StoreTest {

  @Test
  @DisplayName("돈을 받을 뒤 그에 해당하는 물건을 제작한다.")
  void delivery() {
    Store store = new Store();
    List<Product> products = store.delivery(14000);
    assertThat(products).hasSize(14);
  }
}