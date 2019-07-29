package com.jpa.multilpledb.prod.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.multilpledb.prod.domain.SqsPostPublishTable;

public interface ProdErrorRepository extends JpaRepository<SqsPostPublishTable, Long>{

	@Override
	public List<SqsPostPublishTable> findAll();
	
	@Override
	public Optional<SqsPostPublishTable> findById(Long id);
	
}
