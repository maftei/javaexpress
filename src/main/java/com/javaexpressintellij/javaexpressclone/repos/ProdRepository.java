package com.javaexpressintellij.javaexpressclone.repos;

import com.javaexpressintellij.javaexpressclone.models.Prod;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdRepository extends CrudRepository<Prod,Long> {

    //Query Method Generation
    //https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods

     List<Prod> findByBarCode(Integer barCode);


     @Query(value="select prodName from Prod p")
     List<String> fetchAllProductName();
}
