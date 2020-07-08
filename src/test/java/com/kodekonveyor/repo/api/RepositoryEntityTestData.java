package com.kodekonveyor.repo.api;

public class RepositoryEntityTestData {

  public static RepositoryEntity get() {
    final RepositoryEntity entity = new RepositoryEntity();
    entity.setId(SumtiEntityTestData.ELEMENT_ID);
    entity.setUrl(SumtiEntityTestData.HTTPS_REPO_KODEKONVEYOR_COM_CORE);
    entity.setOwner(ElementEntityTestData.getOwner());

    return entity;
  }

}
