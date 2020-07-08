package com.kodekonveyor.repo.api;

import static org.junit.Assert.assertEquals;

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
  public void test1() {

    readSumtiController.call(
        SumtiEntityTestData.NAME, null,
        SumtiEntityTestData.ID
    );

    Mockito.verify(sumtiEntityRepository)
        .findByLerpoiName(SumtiEntityTestData.NAME);

  }

  @Test
  @DisplayName(
    "Looks up the repository by name and checks the sumti is correct"
  )
  public void test2() {

    Mockito
        .when(sumtiEntityRepository.findByLerpoiName(SumtiEntityTestData.NAME))
        .thenReturn(SumtiEntityTestData.list());

    final SumtiListDTO sumtiDTO = readSumtiController.call(
        SumtiEntityTestData.NAME, null,
        SumtiEntityTestData.ID
    );

    assertEquals(SumtiDTOTestData.list(), sumtiDTO);

  }

  @Test
  @DisplayName("Looks up the repository by name and tag")
  public void test3() {

    readSumtiController.call(
        SumtiEntityTestData.NAME, SumtiEntityTestData.TAG,
        SumtiEntityTestData.ID
    );

    Mockito.verify(sumtiEntityRepository)
        .findByLerpoiNameAndTag(
            SumtiEntityTestData.NAME, SumtiEntityTestData.TAG
        );

  }

  @Test
  @DisplayName(
    "Looks up the repository by name and tag and checks the sumti is correct"
  )
  public void test4() {

    Mockito
        .when(
            sumtiEntityRepository
                .findByLerpoiNameAndTag(
                    SumtiEntityTestData.NAME, SumtiEntityTestData.TAG
                )
        )
        .thenReturn(SumtiEntityTestData.list());

    final SumtiListDTO sumtiDTO = readSumtiController.call(
        SumtiEntityTestData.NAME, SumtiEntityTestData.TAG,
        SumtiEntityTestData.ID
    );

    assertEquals(SumtiDTOTestData.list(), sumtiDTO);

  }

}
