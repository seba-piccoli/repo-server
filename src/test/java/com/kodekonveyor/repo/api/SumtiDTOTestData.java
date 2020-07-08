package com.kodekonveyor.repo.api;

import java.util.List;

public class SumtiDTOTestData {

  public static SumtiDTO get() {

    final SumtiDTO sumtiDTO = new SumtiDTO();
    sumtiDTO.setId(SumtiEntityTestData.ID);

    return sumtiDTO;

  }

  public static SumtiListDTO list() {
    final SumtiListDTO dto = new SumtiListDTO();
    dto.setSumtiDTOList(List.of(get()));

    return dto;
  }

}
