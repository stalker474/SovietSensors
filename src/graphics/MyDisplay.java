package graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import eu.hansolo.steelseries.gauges.DisplaySingle;
import eu.hansolo.steelseries.tools.LcdColor;
import main.Config;

public class MyDisplay extends DisplaySingle {

	public MyDisplay() {
		setPlainBargraphSegments(false);
		setGlowVisible(true);
		setCustomLcdForeground(Color.GREEN);
		setGlowColor(Color.GREEN);
		setLcdUnitString("rpm");
		setLcdMaxValue(9999.0);
		setLcdDecimals(0);
		setGlowing(true);
		setLcdBackgroundVisible(false);
		setLcdColor(LcdColor.CUSTOM);
		setMaximumSize(new Dimension(100, 40));
		//setMinimumSize(new Dimension(50, 80));
	}
	
	public void configure(final Config cfg) {
		setCustomLcdForeground(cfg.FansColor);
		setGlowColor(cfg.FansColor);
	}

}
