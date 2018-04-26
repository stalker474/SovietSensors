package graphics;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoundedRangeModel;
import javax.swing.JProgressBar;

import eu.hansolo.steelseries.gauges.LinearBargraph;
import eu.hansolo.steelseries.tools.ColorDef;
import eu.hansolo.steelseries.tools.LcdColor;
import main.Config;

public class MyProgressBar extends LinearBargraph {


	public MyProgressBar(int Min, int Max, final int Tolerance) {
		super();
		this.Tolerance = Tolerance;
		setMaxValue(Max);
		setMinValue(Min);
		
		setTitleVisible(false);
		setTickmarksVisible(false);
		setTickmarkColorFromThemeEnabled(false);
		setTicklabelsVisible(false);
		setMinorTickmarkVisible(false);
		setMajorTickmarkVisible(false);
		setLedVisible(false);
		setLcdVisible(false);
		setLcdColor(LcdColor.GRAY_LCD);
		setLcdBackgroundVisible(false);
		setLabelColorFromThemeEnabled(false);
		setFrameVisible(false);
		setForegroundVisible(false);
		setBorder(null);
		setBarGraphColor(ColorDef.CUSTOM);
		setBackgroundVisible(false);
		color = Color.GREEN;
		criticalColor = Color.RED;
	}
	
	public void setValue(int Value) {
		super.setValue(Value);
		if(Value < Tolerance) {
			setCustomBarGraphColor(color);
		} else
		{
			setCustomBarGraphColor(criticalColor);
		}
	}
	
	public void configure(final Config cfg) {
		color = cfg.ProgressBarColors;
		criticalColor = cfg.ProgressCriticalColors;
	}
	
	private int Tolerance;
	private Color color;
	private Color criticalColor;

}
