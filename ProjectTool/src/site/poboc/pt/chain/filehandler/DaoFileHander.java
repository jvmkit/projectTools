package site.poboc.pt.chain.filehandler;

import site.poboc.pt.chain.replacer.ReplacerChain;
import site.poboc.pt.utils.ProjectUtils;
import site.poboc.pt.utils.ReplaceBean;

public class DaoFileHander extends AbstractFileHander {

	@Override
	public void readFromFile(ReplaceBean rb) {
		String daoTplPath = rb.getDaoTplPath();
		StringBuilder sb = ProjectUtils.su.readFileToSB(daoTplPath);
		rb.setContent(sb);
	}

	@Override
	public void writeToFile(ReplaceBean rb) {
		ProjectUtils.su.writeString2File(rb, rb.getDaoInterfacePath(), "Dao.java", "dao", true);
	}

	@Override
	public void replace(StringBuilder sb, ReplaceBean replaceBean) {
		ReplacerChain.chain.replace(sb, replaceBean);
	}

}
