package Xchart;

import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;

public class Example0{

    public static void main(String[] args){

        double[] xData = {0.0, 1.0, 2.0};
        double[] yData = {2.1, 1.2, 0.5} ;

        XYChart chart = QuickChart.getChart("Example 0", "X", "Y", "y(x)", xData, yData);

        new SwingWrapper(chart).displayChart();

    }
}