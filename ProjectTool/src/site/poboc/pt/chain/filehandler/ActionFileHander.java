package site.poboc.pt.chain.filehandler;

import site.poboc.pt.chain.replacer.ReplacerChain;
import site.poboc.pt.utils.ProjectUtils;
import site.poboc.pt.utils.ReplaceBean;

public class ActionFileHander extends AbstractFileHander {

	@Override
	public void readFromFile(ReplaceBean rb) {
		String actionTplPath = rb.getActionTplPath();
		StringBuilder sb = ProjectUtils.su.readFileToSB(actionTplPath);
		rb.setContent(sb);
	}

	@Override
	public void writeToFile(ReplaceBean rb) {
		ProjectUtils.su.writeString2File(rb, rb.getActionPath(), "Action.java", "web/action", false);
	}

	@Override
	public void replace(StringBuilder sb, ReplaceBean replaceBean) {
		ReplacerChain.chain.replace(sb, replaceBean);
	}

}
