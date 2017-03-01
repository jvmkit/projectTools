package site.poboc.pt.chain.replacer;

import site.poboc.pt.utils.ReplaceBean;

public class DomainVerReplacer extends AbstractReplacer {

	@Override
	public void replace(StringBuilder sb, ReplaceBean replaceBean) {
		int start = -1;
		while((start = sb.indexOf("${domain_class_veriable}")) >= 0){
			int end = start + 24;
			sb = sb.replace(start, end, replaceBean.getDomainVer());
		}
		if(this.hasNext()){
			this.next(sb, replaceBean);
		}
	}

}
