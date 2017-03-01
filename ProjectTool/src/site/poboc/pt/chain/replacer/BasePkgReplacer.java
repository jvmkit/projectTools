package site.poboc.pt.chain.replacer;

import site.poboc.pt.utils.ReplaceBean;

public class BasePkgReplacer extends AbstractReplacer {

	@Override
	public void replace(StringBuilder sb, ReplaceBean replaceBean) {
		int start = -1;
		while((start = sb.indexOf("${base_package}")) >= 0){
			int end = start + 15;
			sb = sb.replace(start, end, replaceBean.getBasePkg());
		}
		if(this.hasNext()){
			this.next(sb, replaceBean);
		}
	}

}
