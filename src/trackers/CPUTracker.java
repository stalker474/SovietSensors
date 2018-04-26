package trackers;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import com.profesorfalken.jsensors.model.components.Cpu;
import com.profesorfalken.jsensors.model.sensors.Fan;
import com.profesorfalken.jsensors.model.sensors.Load;
import com.profesorfalken.jsensors.model.sensors.Temperature;

import eu.hansolo.steelseries.gauges.DisplaySingle;
import eu.hansolo.steelseries.tools.LcdColor;
import graphics.MyDisplay;
import graphics.MyProgressBar;
import graphics.TempGauge;
import main.Config;

public class CPUTracker extends Tracker {

	public CPUTracker() {
		super();
		Temp.setTitle("CPU Temp");
		CoresPBContainer = new JPanel();
		CoresPBContainer.setOpaque(false);
		CoresPBContainer.setLayout(new BoxLayout(CoresPBContainer, BoxLayout.X_AXIS));
		
		CoresPB = new ArrayList<MyProgressBar>();
	}
	
	public void Init(final Integer CoresCount,final Integer FansCount) {
		super.Init(FansCount);
		this.CoresCount = CoresCount;
		
		for(int i = 0; i < CoresCount; i++)
		{
			MyProgressBar pb = new MyProgressBar(0,100,70);
			pb.setMaximumSize(new Dimension(10, 50));
			pb.setMinimumSize(new Dimension(10, 50));
			pb.setPreferredSize(new Dimension(10, 50));
			CoresPB.add(pb);
			CoresPBContainer.add(pb);
		}
	}
	
	public void Update(Cpu cpu) {
		if(cpu.sensors != null) {
			int incr = 0;
			for(final Load sensor : cpu.sensors.loads) {
				if(sensor.name.compareTo("Load CPU Total") == 0) {
					MainPB.setValue((int) Math.round(sensor.value));
				} else if(sensor.name.compareTo("Load Memory") == 0) {
					SecondPB.setValue((int) Math.round(sensor.value));
				}
				else {
					if(incr < CoresPB.size())
						CoresPB.get(incr++).setValue((int) Math.round(sensor.value));
				}
			}
			
			int i = 0;
			for(final Fan sensor : cpu.sensors.fans) {
				FanDisplays.get(i++).setLcdValue(sensor.value);
			}
			
			for(final Temperature sensor : cpu.sensors.temperatures) {
				if(sensor.name.compareTo("Temp CPU Package") == 0) {
					Temp.Update(sensor.value);
				}
			}
		}
	}
	
	private Integer CoresCount;
	private List<MyProgressBar> CoresPB;
	private JPanel CoresPBContainer;

	@Override
	public void Changed(Config cfg) {
		Configure(cfg);
		Temp.SetMainColor(cfg.CPUGaugeColor);
		Temp.SetPointerColor(cfg.CPUGaugeIndicatorColor);
		Temp.DangerTemp = cfg.CPUCriticalTemp;
		Temp.setMaxValue(cfg.CPUMaxTemp);

		if(cfg.DisplayCPUCores)
		{
			Panel_Loads.add(CoresPBContainer);
		} else {
			Panel_Loads.remove(CoresPBContainer);
		}
		
		for(MyProgressBar pb : CoresPB) {
			pb.configure(cfg);
		}
		Panel_Loads.validate();
	}
}
