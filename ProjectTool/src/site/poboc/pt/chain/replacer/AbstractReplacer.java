package site.poboc.pt.chain.replacer;

import site.poboc.pt.utils.ReplaceBean;

public abstract class AbstractReplacer implements IReplacer{

	private IReplacer nextReplacer;
	
	@Override
	public final boolean hasNext() {
		return null != this.nextReplacer;
	}

	@Override
	public final void setNextReplacer(IReplacer replacer) {
		this.nextReplacer = replacer;
	}

	@Override
	public final void next(StringBuilder sb, ReplaceBean replaceBean) {
		this.nextReplacer.replace(sb, replaceBean);
	}
	
}
