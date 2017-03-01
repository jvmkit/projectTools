package ${base_package}.dao.impl;

import org.springframework.stereotype.Repository;

import ${base_package}.dao.I${domain_class}Dao;
import ${base_package}.dao.base.impl.BaseDaoImpl;
import ${base_package}.domain.${domain_class};

@Repository
public class ${domain_class}DaoImpl extends BaseDaoImpl<${domain_class}> implements I${domain_class}Dao {

}
