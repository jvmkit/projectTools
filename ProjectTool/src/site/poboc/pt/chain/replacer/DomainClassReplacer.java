package site.poboc.pt.chain.replacer;

import site.poboc.pt.utils.ReplaceBean;

public class DomainClassReplacer extends AbstractReplacer {

	@Override
	public void replace(StringBuilder sb, ReplaceBean replaceBean) {
		int start = -1;
		while((start = sb.indexOf("${domain_class}")) >= 0){
			int end = start + 15;
			sb = sb.replace(start, end, replaceBean.getDomainClass());
		}
		if(this.hasNext()){
			this.next(sb, replaceBean);
		}
	}

}
