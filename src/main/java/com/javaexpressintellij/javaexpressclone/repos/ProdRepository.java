package com.javaexpressintellij.javaexpressclone.repos;

import com.javaexpressintellij.javaexpressclone.models.Prod;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdRepository extends CrudRepository<Prod,Long> {


}
