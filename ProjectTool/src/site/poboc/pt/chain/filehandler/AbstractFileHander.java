package site.poboc.pt.chain.filehandler;

import site.poboc.pt.chain.replacer.AbstractReplacer;
import site.poboc.pt.utils.ReplaceBean;

public abstract class AbstractFileHander extends AbstractReplacer implements IFileHandler {

	private IFileHandler nextHander;
	
	@Override
	public final void hander(ReplaceBean rb) {
		this.readFromFile(rb);
		this.replace(rb.getContent(), rb);
		this.writeToFile(rb);
		if(hasNextHandler()){
			nextHander.hander(rb);
		}
	}

	@Override
	public void setNextHander(IFileHandler nextHander) {
		this.nextHander = nextHander;
	}

	@Override
	public boolean hasNextHandler() {
		return null!=nextHander;
	}
	
}
