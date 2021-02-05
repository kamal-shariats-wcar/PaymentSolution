package com.mydigipay.paymentService.base.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface IGenericService<T, ID extends Serializable> {
    void save(T model);

    void saveAll(List<T> models);

    void delete(ID pk);

    T get(ID id);

    Optional<T> find(ID id);

    List<T> findAll();

    Page<T> findAll(Pageable pageable);

    JpaRepository<T, ID> getRepositoryBean();

}
