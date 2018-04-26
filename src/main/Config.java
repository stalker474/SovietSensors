package main;

import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Config  implements Serializable{

	public Config() {
		Background = Color.BLACK;
		CPUGaugeColor = Color.GREEN;
		GPUGaugeColor = Color.GREEN;
		CPUGaugeIndicatorColor = Color.GREEN;
		GPUGaugeIndicatorColor = Color.GREEN;
		ProgressBarColors = Color.GREEN;
		ProgressCriticalColors = Color.RED;
		FansColor = Color.GREEN;
		CPUMaxTemp = 95.0;
		GPUMaxTemp = 85.0;
		CPUCriticalTemp = 80.0;
		GPUCriticalTemp = 70.0;
		DisplayCPUCores = true;
		CriticalLedVisible = true;
		
		setListeners(new ArrayList<ConfigListener>());
	}
	
	public void Updated() {
		for(ConfigListener l : getListeners())
			l.Changed(this);
	}
	
	public void Subscribe(ConfigListener listener)
	{
		getListeners().add(listener);
	}
	
	public List<ConfigListener> getListeners() {
		return Listeners;
	}

	public void setListeners(List<ConfigListener> listeners) {
		Listeners = listeners;
	}

	public Color Background;
	public Color CPUGaugeColor;
	public Color CPUGaugeIndicatorColor;
	public Color GPUGaugeColor;
	public Color GPUGaugeIndicatorColor;
	public Color ProgressBarColors;
	public Color ProgressCriticalColors;
	public Color FansColor;
	public Double CPUMaxTemp;
	public Double GPUMaxTemp;
	public Double CPUCriticalTemp;
	public Double GPUCriticalTemp;
	public Boolean	DisplayCPUCores;
	public Boolean CriticalLedVisible;
	
	private transient List<ConfigListener> Listeners;
}
