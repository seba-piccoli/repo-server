package com.kodekonveyor.repo.api;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import com.kodekonveyor.annotations.TestedBehaviour;
import com.kodekonveyor.annotations.TestedService;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@RunWith(MockitoJUnitRunner.class)
@TestedBehaviour("element lookup")
@TestedService("ReadSumtiController")
public class ReadSumtiControllerElementLookupTest
    extends ReadSumtiControllerTestBase {

  @Test
  @DisplayName("Looks up the repository by name")
  public void testLookUpRepositoryByName() {

    readSumtiController.call(SumtiEntityTestData.NAME, SumtiEntityTestData.TAG, SumtiEntityTestData.ID);

    Mockito.verify(sumtiEntityRepository).findByLerpoiName(SumtiEntityTestData.NAME);

  }

}
