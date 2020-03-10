package com.kodekonveyor.authentication;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.kodekonveyor.logging.LoggerService;

public class RestResponseEntityExceptionHandlerTestBase {

  @Mock
  LoggerService loggerService;

  @InjectMocks
  RestResponseEntityExceptionHandler restResponseEntityExceptionHandler;

  @BeforeEach
  public void setUp() {
  }

}
