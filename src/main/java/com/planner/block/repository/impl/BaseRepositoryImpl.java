package com.planner.block.repository.impl;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.planner.block.repository.BaseRepository;

@Repository
public class BaseRepositoryImpl extends NamedParameterJdbcDaoSupport implements BaseRepository{
	
	@Autowired
	protected DataSource dataSource;

	@PostConstruct
	private void init() {
		super.setDataSource(dataSource);
	}
		
}
