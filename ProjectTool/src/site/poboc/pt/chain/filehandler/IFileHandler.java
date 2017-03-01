package site.poboc.pt.chain.filehandler;

import site.poboc.pt.utils.ReplaceBean;

public interface IFileHandler {

	public void readFromFile(ReplaceBean rb);
	
	public void writeToFile(ReplaceBean rb);
	
	public void hander(ReplaceBean rb);
	
	public boolean hasNextHandler();
	
	public void setNextHander(IFileHandler nextHander);
}
