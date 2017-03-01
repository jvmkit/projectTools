package site.poboc.pt.chain.replacer;

import site.poboc.pt.utils.ReplaceBean;

public enum ReplacerChain{
	chain;
	public void replace(StringBuilder sb, ReplaceBean rb) {
		BasePkgReplacer bpr = new BasePkgReplacer();
		DomainClassReplacer dcr = new DomainClassReplacer();
		DomainVerReplacer dvr = new DomainVerReplacer();
		bpr.setNextReplacer(dcr);
		dcr.setNextReplacer(dvr);
		bpr.replace(sb, rb);
	}

}
