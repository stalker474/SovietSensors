package trackers;

import java.awt.Dimension;
import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import com.profesorfalken.jsensors.model.components.Cpu;
import com.profesorfalken.jsensors.model.components.Gpu;
import com.profesorfalken.jsensors.model.sensors.Fan;
import com.profesorfalken.jsensors.model.sensors.Load;
import com.profesorfalken.jsensors.model.sensors.Temperature;

import eu.hansolo.steelseries.gauges.DisplaySingle;
import graphics.MyDisplay;
import graphics.MyProgressBar;
import main.Config;

public class GPUTracker extends Tracker {

	public GPUTracker() {
		super();
		Temp.setTitle("GPU Temp");
	}
	
	public void Update(Gpu gpu) {
		if(gpu.sensors != null) {
			int incr = 0;
			for(final Load sensor : gpu.sensors.loads) {
				if(sensor.name.compareTo("Load GPU Core") == 0) {
					MainPB.setValue((int) Math.round(sensor.value));
				} else if(sensor.name.compareTo("Load GPU Memory") == 0) {
					SecondPB.setValue((int) Math.round(sensor.value));
				}
			}
			
			int i = 0;
			for(final Fan sensor : gpu.sensors.fans) {
				FanDisplays.get(i++).setLcdValue(sensor.value);
			}
			
			for(final Temperature sensor : gpu.sensors.temperatures) {
				if(sensor.name.compareTo("Temp GPU Core") == 0) {
					Temp.Update(sensor.value);
				}
			}
		}
	}
	
	@Override
	public void Changed(Config cfg) {
		Configure(cfg);
		Temp.SetMainColor(cfg.GPUGaugeColor);
		Temp.SetPointerColor(cfg.GPUGaugeIndicatorColor);
		Temp.DangerTemp = cfg.GPUCriticalTemp;
		Temp.setMaxValue(cfg.GPUMaxTemp);
	}
}
