package trackers;

import java.awt.Dimension;
import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import com.profesorfalken.jsensors.model.components.Gpu;
import com.profesorfalken.jsensors.model.components.Mobo;
import com.profesorfalken.jsensors.model.sensors.Fan;
import com.profesorfalken.jsensors.model.sensors.Load;
import com.profesorfalken.jsensors.model.sensors.Temperature;

import eu.hansolo.steelseries.gauges.DisplaySingle;
import graphics.MyProgressBar;
import main.Config;

public class MOBOTracker extends Tracker {

	public MOBOTracker() {
		super();
		Panel_Main.remove(Temp);
		Panel_Main.remove(MainPB);
		Panel_Main.remove(Panel_Loads);
	}
	
	public void Update(Mobo mobo) {
		if(mobo.sensors != null) {
			int i = 0;
			for(final Fan sensor : mobo.sensors.fans) {
				FanDisplays.get(i++).setLcdValue(sensor.value);
			}
		}
	}

	@Override
	public void Changed(Config cfg) {
		Configure(cfg);
	}
}
