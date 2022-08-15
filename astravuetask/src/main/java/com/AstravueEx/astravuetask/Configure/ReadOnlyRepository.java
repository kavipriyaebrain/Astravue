package com.AstravueEx.astravuetask.Configure;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

@NoRepositoryBean
public interface ReadOnlyRepository <T, ID extends Serializable> extends Repository<T, ID> {
    
    Optional<T> findById(ID id);
    List<T> findAllById(Iterable<ID> ids);
    List<T> findAll();
    Page<T> findAll(Pageable pageable);
    long count();
}
