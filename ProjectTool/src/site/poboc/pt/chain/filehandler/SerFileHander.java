package site.poboc.pt.chain.filehandler;

import site.poboc.pt.chain.replacer.ReplacerChain;
import site.poboc.pt.utils.ProjectUtils;
import site.poboc.pt.utils.ReplaceBean;

public class SerFileHander extends AbstractFileHander {

	@Override
	public void readFromFile(ReplaceBean rb) {
		String serTplPath = rb.getSerTplPath();
		StringBuilder sb = ProjectUtils.su.readFileToSB(serTplPath);
		rb.setContent(sb);
	}

	@Override
	public void writeToFile(ReplaceBean rb) {
		ProjectUtils.su.writeString2File(rb, rb.getServiceInterfacePath(), "Service.java", "service", true);
	}

	@Override
	public void replace(StringBuilder sb, ReplaceBean replaceBean) {
		ReplacerChain.chain.replace(sb, replaceBean);
	}

}
