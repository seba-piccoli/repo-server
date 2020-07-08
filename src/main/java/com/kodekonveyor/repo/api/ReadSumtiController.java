package com.kodekonveyor.repo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReadSumtiController {

  @Autowired
  SumtiEntityRepository sumtiEntityRepository;

  @GetMapping("/{repository}/{tag}/{sumti}")
  public SumtiListDTO
      call(
          final String repository, final String tag,
          final Long sumti
      ) {

    final List<SumtiEntity> sumtiEntityList;

    if (tag == null)
      sumtiEntityList = sumtiEntityRepository.findByLerpoiName(repository);
    else
      sumtiEntityList =
          sumtiEntityRepository.findByLerpoiNameAndTag(repository, tag);

    final SumtiListDTO sumtiListDTO = new SumtiListDTO();

    final SumtiDTO sumtiDTO = new SumtiDTO();

    for (final SumtiEntity sumtiEntity : sumtiEntityList) {
      sumtiDTO.setId(sumtiEntity.getId());
      sumtiListDTO.getSumtiDTOList().add(sumtiDTO);
    }

    return sumtiListDTO;

  }

}
