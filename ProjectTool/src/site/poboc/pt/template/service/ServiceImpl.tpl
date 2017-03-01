package ${base_package}.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ${base_package}.dao.I${domain_class}Dao;
import ${base_package}.service.I${domain_class}Service;

@Service
@Transactional
public class ${domain_class}ServiceImpl implements I${domain_class}Service {

	@Resource
	private I${domain_class}Dao ${domain_class_veriable}Dao;

}
