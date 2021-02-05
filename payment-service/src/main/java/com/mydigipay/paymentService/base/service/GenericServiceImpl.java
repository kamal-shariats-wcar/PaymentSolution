package com.mydigipay.paymentService.base.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class GenericServiceImpl<T, ID extends Serializable> implements IGenericService<T, ID> {

    @Override
    @Transactional
    public void save(T model) {
        this.getRepositoryBean().save(model);
    }

    @Override
    @Transactional
    public void saveAll(List<T> models) {
        models.stream().forEach(m -> this.save(m));
    }

    @Override
    public T get(ID id) {
        return this.getRepositoryBean().getOne(id);
    }

    @Override
    public Optional<T> find(ID id) {
        return this.getRepositoryBean().findById(id);
    }

    @Override
    @Transactional
    public void delete(ID id) {
        this.getRepositoryBean().deleteById(id);
    }

    @Override
    public List<T> findAll() {
        return this.getRepositoryBean().findAll();
    }

    @Override
    public Page<T> findAll(Pageable pageable) {
        return this.getRepositoryBean().findAll(pageable);
    }

}
