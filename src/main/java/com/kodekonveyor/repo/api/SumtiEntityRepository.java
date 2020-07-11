package com.kodekonveyor.repo.api;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface SumtiEntityRepository
    extends PagingAndSortingRepository<SumtiEntity, Long> {

  List<SumtiEntity> findByLerpoiName(String name);

}
