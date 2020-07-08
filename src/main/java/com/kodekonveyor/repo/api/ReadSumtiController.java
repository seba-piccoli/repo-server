package com.kodekonveyor.repo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReadSumtiController {

  @Autowired
  SumtiEntityRepository sumtiEntityRepository;

  @GetMapping("/{repository}/{tag}/{sumti}")
  public SumtiDTO
      call(
          final String repository, final String tag,
          final Long sumti
      ) {

    sumtiEntityRepository.findByLerpoiName(repository);

    return null;

  }

}
