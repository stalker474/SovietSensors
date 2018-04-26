package graphics;

import java.awt.Color;
import java.awt.Font;

import eu.hansolo.steelseries.gauges.Radial;
import eu.hansolo.steelseries.tools.ColorDef;
import eu.hansolo.steelseries.tools.ForegroundType;
import eu.hansolo.steelseries.tools.KnobStyle;
import eu.hansolo.steelseries.tools.KnobType;
import eu.hansolo.steelseries.tools.Model;
import eu.hansolo.steelseries.tools.PointerType;
import eu.hansolo.steelseries.tools.TickmarkType;
import main.Config;

public class TempGauge extends Radial {

	public TempGauge(Double Danger) {
		DangerTemp = Danger;
		
		setMajorTickmarkType(TickmarkType.TRIANGLE);
		setUnitString("\u00B0C");
		setLcdVisible(false);
		setLcdBackgroundVisible(false);
		setForegroundType(ForegroundType.FG_TYPE5);
		setFrameVisible(false);
		setKnobStyle(KnobStyle.BLACK);
		setKnobType(KnobType.METAL_KNOB);
		setMinorTickmarkType(TickmarkType.CIRCLE);
		setKnobType(KnobType.SMALL_STD_KNOB);
		setLabelColorFromThemeEnabled(false);
		setPointerType(PointerType.TYPE12);
		setTitleAndUnitFontEnabled(true);
		setPointerShadowVisible(false);
		setPointerColor(ColorDef.GREEN);
		setForegroundVisible(false);
		setTitleAndUnitFont(new Font("Verdana", Font.BOLD, 16));
		setTickmarkColorFromThemeEnabled(false);
		setTickmarkColor(Color.GREEN);
		setPostsVisible(false);
		setLabelColor(Color.GREEN);
		setForeground(Color.GREEN);
		setBackgroundVisible(false);
		setMaxValue(85);
		this.setKnobType(KnobType.BIG_STD_KNOB);
		this.setKnobStyle(KnobStyle.BLACK);
		init(60, 60);
	}
	
	public void Update(Double Temp) {
		setValue(Temp);
		this.setLedBlinking(Temp > DangerTemp);
	}
	
	public void configure(final Config cfg) {
		this.setLedVisible(cfg.CriticalLedVisible);
	}
	
	public void SetMainColor(final Color color)
	{
		setTickmarkColor(color);
		setLabelColor(color);
		setForeground(color);
	}
	
	public void SetPointerColor(final Color color)
	{
		setPointerColor(ColorDef.CUSTOM);
		this.setCustomPointerColor(color);
	}
	
	public Double DangerTemp;

}
