package com.kodekonveyor.repo.api;

import java.util.List;

import lombok.Data;

@Data
public class BridiDTO {

  private Long id;

  private SumtiEntity selbri;

  private List<SumtiEntity> sumti;

  private String uuid;

}
