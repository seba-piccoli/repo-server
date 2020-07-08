package com.kodekonveyor.repo.api;

import org.mockito.InjectMocks;
import org.mockito.Mock;

public class ReadSumtiControllerTestBase {

  @InjectMocks
  protected ReadSumtiController readSumtiController;
  @Mock
  protected SumtiEntityRepository sumtiEntityRepository;

}
