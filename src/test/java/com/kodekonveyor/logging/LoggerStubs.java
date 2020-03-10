package com.kodekonveyor.logging;

import static org.mockito.Mockito.reset;

class LoggerStubs {

  public void behaviour(final LoggerService loggerService) {
    reset(loggerService);
  }
}
