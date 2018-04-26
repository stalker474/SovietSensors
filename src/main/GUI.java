package main;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.profesorfalken.jsensors.JSensors;
import com.profesorfalken.jsensors.model.components.*;

import trackers.*;

import javax.swing.AbstractAction;
import javax.swing.BoxLayout;
import javax.swing.JDialog;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;

import eu.hansolo.steelseries.gauges.*;
import graphics.MyProgressBar;
import graphics.TempGauge;
import eu.hansolo.steelseries.tools.BackgroundColor;
import java.awt.Color;
import java.awt.Dimension;

import eu.hansolo.steelseries.tools.*;
import java.awt.Font;
import javax.swing.JSplitPane;

public class GUI {

	private JFrame frmSovietSensors;
	private ThemeConfig frmThemeConfig;
	private Config config;
	private CPUTracker trackerCPU;
	private GPUTracker trackerGPU;
	private MOBOTracker trackerMobo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frmSovietSensors.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSovietSensors = new JFrame();
		frmSovietSensors.setTitle("Soviet Sensors");
		frmSovietSensors.setBounds(100, 100, 450, 597);
		frmSovietSensors.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSovietSensors.getContentPane().setLayout(new BorderLayout(0, 0));
		frmSovietSensors.addWindowListener(new WindowAdapter() {
		      public void windowClosing(WindowEvent e) {
		        WriteConfig();
		      }
		    });
		
		JPanel panel_Main = new JPanel();
		frmSovietSensors.getContentPane().add(panel_Main, BorderLayout.CENTER);
		panel_Main.setLayout(new BoxLayout(panel_Main, BoxLayout.Y_AXIS));
		
		JMenuBar menuBar;
		JMenu menu;
		JMenuItem menuItem;

		menuBar = new JMenuBar();

		menu = new JMenu("File");
		menuBar.add(menu);
		
		menuItem = new JMenuItem(new AbstractAction("Exit") {
		    public void actionPerformed(ActionEvent e) {
		        System.exit(0);
		    }
		});
		menu.add(menuItem);
		
		menu = new JMenu("Config");
		menuBar.add(menu);
		
		menuItem = new JMenuItem(new AbstractAction("Theme colors") {
		    public void actionPerformed(ActionEvent e) {
		    	frmThemeConfig.setVisible(true);
		    }
		});
		menu.add(menuItem);

		frmSovietSensors.setJMenuBar(menuBar);
		
		
		trackerCPU = new CPUTracker();
		panel_Main.add(trackerCPU);
		
		trackerGPU = new GPUTracker();
		panel_Main.add(trackerGPU);
		
		trackerMobo = new MOBOTracker();
		panel_Main.add(trackerMobo);
		
		if(!ReadConfig())
			cfg = new Config();
		frmThemeConfig = new ThemeConfig(cfg);
		cfg.Subscribe(trackerCPU);
		cfg.Subscribe(trackerGPU);
		cfg.Subscribe(trackerMobo);
		
		cfg.Updated();
		
		Map<String, String> overriddenConfig = new HashMap<String, String>();
		
		Components components = JSensors.get.config(overriddenConfig).components();
		
		List<Cpu> cpus = components.cpus;
		List<Gpu> gpus = components.gpus;
		List<Mobo> mobos = components.mobos;
		
		if ((cpus != null) && (cpus.size() > 0) && (cpus.get(0).sensors != null)) {
			trackerCPU.Init(cpus.get(0).sensors.loads.size()-2, cpus.get(0).sensors.fans.size());
		}
		
		if ((gpus != null) && (gpus.size() > 0) && (gpus.get(0).sensors != null)) {
			trackerGPU.Init(gpus.get(0).sensors.fans.size());
		}
		
		if ((mobos != null) && (mobos.size() > 0) && (mobos.get(0).sensors != null)) {
			trackerMobo.Init(mobos.get(0).sensors.fans.size());
		}

		Timer timer;
		timer = new Timer();
		timer.scheduleAtFixedRate(new java.util.TimerTask() {
            @Override
            public void run() {
            	Components components = JSensors.get.config(overriddenConfig).components();
            	
            	List<Cpu> cpus = components.cpus;
        		if ((cpus != null) && (cpus.size() > 0)) {
        			trackerCPU.Update(cpus.get(0));
        		}
        		
        		List<Gpu> gpus = components.gpus;
        		if ((gpus != null) && (gpus.size() > 0)) {
    				trackerGPU.Update(gpus.get(0));
        		}
        		
        		List<Mobo> mobos = components.mobos;
        		if ((mobos != null) && (mobos.size() > 0)) {
    				trackerMobo.Update(mobos.get(0));
        		}
            }
        }, 0, 200);
	}
	
	private Config cfg;
	
	private void WriteConfig() {
		 try
	        {
	            FileOutputStream fos = new FileOutputStream("config.cfg");
	            ObjectOutputStream oos = new ObjectOutputStream(fos);
	            oos.writeObject(cfg);
	            oos.close();
	            fos.close();
	        }
	        catch (Exception e)
	        {
	            e.printStackTrace();
	        }
	}
	
	private boolean ReadConfig() {
		 	try
	        {
	            FileInputStream fis = new FileInputStream("config.cfg");
	            ObjectInputStream ois = new ObjectInputStream(fis);
	            cfg = (Config)ois.readObject();
	            cfg.setListeners(new ArrayList<ConfigListener>());
	        }
	        catch (Exception e)
	        {
	            return false;
	        }
		 	return true;
	}
}
