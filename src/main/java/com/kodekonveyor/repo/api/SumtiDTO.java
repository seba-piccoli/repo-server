package com.kodekonveyor.repo.api;

import java.util.List;

import lombok.Data;

@Data
public class SumtiDTO {

  private List<BridiEntity> bridi;

  private Long id;

  private String uuid;

}
