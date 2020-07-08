package com.kodekonveyor.repo.api;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class SumtiListDTO {

  private List<SumtiDTO> sumtiDTOList = new ArrayList<>();

}
