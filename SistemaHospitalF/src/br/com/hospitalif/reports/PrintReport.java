package br.com.hospitalif.reports;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;
import br.com.hospitalif.conexao.Conexao;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;

public class PrintReport extends JFrame {
	private static final long serialVersionUID = 1L;

	public void showReport(String relatorio) throws ClassNotFoundException, SQLException, JRException {
		String reportSrcFile = "resource/reports/" + relatorio;
		JasperReport jasperReport = JasperCompileManager.compileReport(reportSrcFile);
		HashMap<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("","");
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		list.add(parameters);
		JasperPrint print = JasperFillManager.fillReport(jasperReport, null,new Conexao().getConnection());
		JRViewer viewer = new JRViewer(print);
		viewer.setOpaque(true);
		viewer.setVisible(true);
		this.add(viewer);
		this.setSize(700, 500);
		this.setVisible(true);
		System.out.print("Relatório Gerado!");
	}
}