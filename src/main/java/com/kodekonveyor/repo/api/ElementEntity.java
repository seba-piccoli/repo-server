package com.kodekonveyor.repo.api;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
class ElementEntity {

  private String commit;

  private String description;

  private String id;

  private String name;

  private String source;

  private String target;

}
