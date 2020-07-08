package com.kodekonveyor.repo.api;

import java.util.ArrayList;
import java.util.List;

public class SumtiEntityTestData {

  public static final String ELEMENT_ID = "elementId";
  public static final String HTTPS_REPO_KODEKONVEYOR_COM_CORE =
      "https://repo.kodekonveyor.com/core";
  public static final Long ID = 14L;
  public static final String NAME = "repo-server";
  public static final String TAG = "master";
  public static final String WRONG_NAME = "repo-server-bad";

  public static final List<SumtiEntity> getEmptyList() {

    return new ArrayList<SumtiEntity>();

  }

  public static final List<SumtiEntity> list() {

    final SumtiEntity sumtiEntity = new SumtiEntity();
    sumtiEntity.setId(ID);

    return List.of(sumtiEntity);
  }

}
