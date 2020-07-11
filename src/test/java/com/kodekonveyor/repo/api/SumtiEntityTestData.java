package com.kodekonveyor.repo.api;

import java.util.ArrayList;
import java.util.List;

public class SumtiEntityTestData {

  public static final List<BridiEntity> BRIDI = getBridi();
  public static final String ELEMENT_ID = "elementId";
  public static final String HTTPS_REPO_KODEKONVEYOR_COM_CORE =
      "https://repo.kodekonveyor.com/core";
  public static final Long ID = 14L;
  public static final String NAME = "repo-server";
  public static final String TAG = "master";
  public static final String UUID = "repo-server";
  public static final String WRONG_NAME = "repo-server-bad";
  public static final String WRONG_TAG = "wrong-master";

  public static List<BridiEntity> getBridi() {

    //Make sumti a repository
    final BridiEntity bridiIsA = new BridiEntity();
    bridiIsA.setUuid(SumtiBridiConstantData.IS_A_BRIDI);
    final SumtiEntity repository = new SumtiEntity();
    repository.setUuid(SumtiBridiConstantData.REPOSITORY_SUMTI);
    final List<SumtiEntity> repositoryList = new ArrayList<>();
    repositoryList.add(repository);
    bridiIsA.setSumti(repositoryList);

    //Add tag master
    final BridiEntity bridiHasA = new BridiEntity();
    bridiHasA.setUuid(SumtiBridiConstantData.HAS_A_BRIDI);
    final SumtiEntity tag = new SumtiEntity();
    tag.setUuid(TAG);
    final List<SumtiEntity> tagList = new ArrayList<>();
    tagList.add(tag);
    bridiHasA.setSumti(tagList);

    final List<BridiEntity> bridiList = new ArrayList<>();
    bridiList.add(bridiIsA);
    bridiList.add(bridiHasA);

    return bridiList;
  }

  public static final List<SumtiEntity> getEmptyList() {

    return new ArrayList<SumtiEntity>();

  }

  public static final List<SumtiEntity> list() {

    final SumtiEntity sumtiEntity = new SumtiEntity();
    sumtiEntity.setId(ID);
    sumtiEntity.setUuid(UUID);
    sumtiEntity.setBridi(BRIDI);

    return List.of(sumtiEntity);
  }

}
