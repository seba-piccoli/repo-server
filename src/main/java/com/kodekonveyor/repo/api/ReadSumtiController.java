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
  public SumtiDTO
      call(
          final String repository, final String tag,
          final Long sumti
      ) {

    //Find the repository candidates on the sumti repository
    final List<SumtiEntity> sumtiEntityList =
        sumtiEntityRepository.findByLerpoiName(repository);

    //Repository candidates not found
    if (sumtiEntityList == null)
      return new SumtiDTO();

    //Gets the sumti that is a repository
    final SumtiEntity sumtiEntity = getRepository(sumtiEntityList);

    //Repository not found
    if (sumtiEntity == null)
      return new SumtiDTO();

    //If tag is provided, check tag
    if (!checkTagIsPresent(tag, sumtiEntity))
      return new SumtiDTO();

    //Complete data for DTO
    final SumtiDTO sumtiDTO = new SumtiDTO();
    sumtiDTO.setUuid(sumtiEntity.getUuid());
    sumtiDTO.setId(sumtiEntity.getId());
    sumtiDTO.setBridi(sumtiEntity.getBridi());

    //Return DTO
    return sumtiDTO;

  }

  private boolean checkIsARepository(final List<BridiEntity> bridiList) {
    for (final BridiEntity bridi : bridiList)
      if (
        bridi.getUuid().equalsIgnoreCase(SumtiBridiConstantData.IS_A_BRIDI)
      ) {
        final List<SumtiEntity> sumtiIsA = bridi.getSumti();
        if (
          sumtiIsA.get(0).getUuid()
              .equalsIgnoreCase(SumtiBridiConstantData.REPOSITORY_SUMTI)
        )
          return true;
      }

    return false;
  }

  private boolean
      checkTagIsPresent(final String tag, final SumtiEntity sumtiEntity) {
    //No tag provided for query
    if (tag == null)
      return true;

    for (final BridiEntity bridi : sumtiEntity.getBridi())
      if (bridi.getUuid().equalsIgnoreCase(SumtiBridiConstantData.HAS_A_BRIDI))
        for (final SumtiEntity tags : bridi.getSumti())
          if (tags.getUuid().equalsIgnoreCase(tag))
            return true;

    return false;
  }

  private SumtiEntity getRepository(final List<SumtiEntity> sumtiEntityList) {

    //Check every candidate until we find a repository
    for (final SumtiEntity sumtiEntity : sumtiEntityList)
      if (checkIsARepository(sumtiEntity.getBridi()))
        return sumtiEntity;

    //No repository found
    return null;
  }

}
