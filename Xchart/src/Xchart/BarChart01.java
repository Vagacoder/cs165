package Xchart;

// * Basic theme

import java.util.Arrays;

import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.SwingWrapper;

import org.knowm.xchart.demo.charts.ExampleChart;

import org.knowm.xchart.style.Styler.LegendPosition;

public class BarChart01 implements ExampleChart<CategoryChart> {

    @Override
    public CategoryChart getChart() {
        CategoryChart chart = new CategoryChartBuilder().width(800).height(600)
        .title("Score Histogram").xAxisTitle("Score").yAxisTitle("Number").build();

        chart.getStyler().setLegendPosition(LegendPosition.InsideNW);
        chart.getStyler().setHasAnnotations(true);

        chart.addSeries("test 1", Arrays.asList(new Integer[] {0, 1, 2, 3, 4}), 
        Arrays.asList(new Integer[] {4, 5, 9, 6, 5}));

        return chart;
        
    }

    public static void main(String[] args){
        ExampleChart<CategoryChart>  bc = new BarChart01();
        CategoryChart chart = bc.getChart();
        new SwingWrapper<CategoryChart>(chart).displayChart();
    }

}