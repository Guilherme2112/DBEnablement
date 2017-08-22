package br.com.fiap.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.primefaces.model.chart.PieChartModel;

import br.com.fiap.bo.AlunoBO;

@ManagedBean
public class GraficoBean {

	private PieChartModel pizza;
	private LineChartModel linha;
	private AlunoBO bo;
	
	@PostConstruct
	private void init(){
		pizza = new PieChartModel();
		
		bo = new AlunoBO();
		
		pizza.set("Otimo", bo.contarPorRating(8, 10));
		pizza.set("Regular", bo.contarPorRating(5,7));
		pizza.set("Ruim", bo.contarPorRating(0, 4));
		pizza.setShowDataLabels(true);
		pizza.setLegendPosition("e");
		
		//Gráfico de linha
		linha = new LineChartModel();
		linha.setLegendPosition("e");
		linha.getAxes().put(AxisType.X, new CategoryAxis("Mês"));
		
		String meses[] = {"Jan","Fev","Mar","Abr","Mai","Jun","Jul","Ago","Set","Out","Nov","Dez"};
		
		LineChartSeries series = new LineChartSeries();
		series.setLabel("Alunos");
		for (int i = 1; i<=12; i++){
			series.set(meses[i-1], bo.contarPorMes(i));
		}
		
		linha.addSeries(series);
	}

	public PieChartModel getPizza() {
		return pizza;
	}

	public void setPizza(PieChartModel pizza) {
		this.pizza = pizza;
	}

	public LineChartModel getLinha() {
		return linha;
	}

	public void setLinha(LineChartModel linha) {
		this.linha = linha;
	}
	
}
