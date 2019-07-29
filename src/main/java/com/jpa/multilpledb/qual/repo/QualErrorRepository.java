package com.jpa.multilpledb.qual.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.multilpledb.qual.domain.SqsPostPublishTable;

public interface QualErrorRepository extends JpaRepository<SqsPostPublishTable, Long>{

	@Override
	public List<SqsPostPublishTable> findAll();
	
	@Override
	public Optional<SqsPostPublishTable> findById(Long id);
	
}
