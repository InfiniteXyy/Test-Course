package cn.infinitex.mockito.trading;

import cn.infinitex.mockito.trading.dto.Stock;

public interface MarketWatcher {

  Stock getQuote(String symbol);

}
