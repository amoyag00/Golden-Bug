package goldenbug;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Map;
/**
 * Fuente: https://www.javacodex.com/Graphics/Bar-Chart
 */
/**
 * 
 * @author Alejandro Moya García
 */
public class BarChart extends JPanel {
 
  private double[] values;
  private double[] frequencies;
  private String[] labels;
  private Color[] colors;
  private String title;
 
  public BarChart(Map<String,Double> map, String title,boolean red) {
    String keys []=new String[map.size()];
        double values[]=new double[map.size()];
        double frequencies[]=new double[map.size()];
        Color[] colors = new Color[map.size()];
        int i=0;
        if(red){
            for (String key: map.keySet()) {
                keys[i]=key;
                colors[i]=new Color(255, i*9, 0);
                frequencies[i]=map.get(key);
                values[i++]=map.get(key);
            }
        }else{
           for (String key: map.keySet()) {
                keys[i]=key;
                colors[i]=new Color(0, i*9, i*9);
                frequencies[i]=map.get(key);
                values[i++]=map.get(key);
            } 
        }
        
    this.labels = keys;
    this.values = values;
    this.colors = colors;
    this.title = title;
    this.frequencies=frequencies;
  }
 
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (values == null || values.length == 0) {
      return;
    }
 
    double minValue = 0;
    double maxValue = 0;
    for (int i = 0; i < values.length; i++) {
      if (minValue > values[i]) {
        minValue = values[i];
      }
      if (maxValue < values[i]) {
        maxValue = values[i];
      }
    }
 
    Dimension dim = getSize();
    int panelWidth = dim.width-50;
    int panelHeight = dim.height-50;
    int barWidth = panelWidth / values.length;
 
    Font titleFont = new Font("Book Antiqua", Font.BOLD, 12);
    FontMetrics titleFontMetrics = g.getFontMetrics(titleFont);
 
    Font labelFont = new Font("Book Antiqua", Font.PLAIN, 12);
    FontMetrics labelFontMetrics = g.getFontMetrics(labelFont);
 
    int titleWidth = titleFontMetrics.stringWidth(title);
    int stringHeight = titleFontMetrics.getAscent();
    int stringWidth = (panelWidth - titleWidth) / 2;
    g.setFont(titleFont);
    g.drawString(title, stringWidth, stringHeight);
 
    int top = titleFontMetrics.getHeight();
    int bottom = labelFontMetrics.getHeight();
    if (maxValue == minValue) {
      return;
    }
    double scale = (panelHeight - top - bottom) / (maxValue - minValue);
    stringHeight = panelHeight - labelFontMetrics.getDescent();
    g.setFont(labelFont);
    for (int j = 0; j < values.length; j++) {
      int valueP = j * barWidth + 1;
      int valueQ = top;
      int height = (int) (values[j] * scale);
      if (values[j] >= 0) {
        valueQ += (int) ((maxValue - values[j]) * scale);
      } else {
        valueQ += (int) (maxValue * scale);
        height = -height;
      }
 
      g.setColor(colors[j]);
      g.fillRect(valueP, valueQ, barWidth - 2, height);
      g.setColor(Color.black);
      g.drawRect(valueP, valueQ, barWidth - 2, height);
 
      int labelWidth = labelFontMetrics.stringWidth(labels[j]);
      stringWidth = j * barWidth + (barWidth - labelWidth) / 2;
      g.drawString(labels[j], stringWidth, stringHeight);
      g.drawString(""+frequencies[j], stringWidth, stringHeight+15);
    }
  }
 
  
}