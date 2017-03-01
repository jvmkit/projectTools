package site.poboc.pt.chain.filehandler;

import site.poboc.pt.utils.ReplaceBean;

public enum FileHanderChain{
	chain;
	public void handle(ReplaceBean rb){
		DaoFileHander dfh = new DaoFileHander();
		DaoImplFileHander difh = new DaoImplFileHander();
		SerFileHander sfh = new SerFileHander();
		SerImplFileHander sifh = new SerImplFileHander();
		ActionFileHander afh = new ActionFileHander();
		StrutsFileHandler stfh = new StrutsFileHandler();
		
		dfh.setNextHander(difh);
		difh.setNextHander(sfh);
		sfh.setNextHander(sifh);
		sifh.setNextHander(afh);
		afh.setNextHander(stfh);
		
		dfh.hander(rb);
	}
}
