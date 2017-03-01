package site.poboc.pt.chain.replacer;

import site.poboc.pt.utils.ReplaceBean;

public interface IReplacer {

	public void replace(StringBuilder sb, ReplaceBean replaceBean);
	
	public boolean hasNext();
	
	public void setNextReplacer(IReplacer replacer);
	
	public void next(StringBuilder sb, ReplaceBean replaceBean);
}
