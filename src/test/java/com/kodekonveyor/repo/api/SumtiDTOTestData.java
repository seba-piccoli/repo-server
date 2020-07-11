package com.kodekonveyor.repo.api;

public class SumtiDTOTestData {

  public static SumtiDTO get() {

    final SumtiDTO sumtiDTO = new SumtiDTO();
    sumtiDTO.setId(SumtiEntityTestData.ID);
    sumtiDTO.setUuid(SumtiEntityTestData.UUID);
    sumtiDTO.setBridi(SumtiEntityTestData.BRIDI);

    return sumtiDTO;

  }

}
