package ${base_package}.web.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import ${base_package}.domain.${domain_class};
import ${base_package}.service.I${domain_class}Service;

@Controller
@Scope("prototype")
public class ${domain_class}Action extends BaseAction<${domain_class}> {
	
	@Resource
	private I${domain_class}Service ${domain_class_veriable}Service;
	
}
