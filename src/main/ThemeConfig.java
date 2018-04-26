package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.AbstractAction;
import javax.swing.BoxLayout;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Component;
import javax.swing.JColorChooser;
import javax.swing.JDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.ComponentOrientation;
import javax.swing.DebugGraphics;
import javax.swing.JButton;
import javax.swing.JCheckBox;

public class ThemeConfig extends JDialog {

	private JPanel contentPane;
	private JButton btnBackground;
	private JButton btnCPUGaugeColor;
	private JButton btnCPUGaugeIndicatorColor;
	private JButton btnGPUGaugeColor;
	private JButton btnGPUGaugeIndicatorColor;
	private JButton btnProgressbarColor;
	private JButton btnProgressbarCriticalColor;
	private JButton btnFansColor;
	private JTextField txtCPUMaxTemp;
	private JTextField txtCPUCriticalTemp;
	private JTextField txtGPUMaxTemp;
	private JTextField txtGPUCriticalTemp;
	private JCheckBox cbDisplayCores;
	private JCheckBox cbCriticalLed;
	public Config config;

	/**
	 * Create the frame.
	 */
	public ThemeConfig(final Config or_config) {
		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 296, 381);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setMaximumSize(new Dimension(99999,20));
		contentPane.add(splitPane);
		
		config = or_config;
		
		Dimension dim = new Dimension(200,99999);
		
		JLabel lbl = new JLabel("Background");
		lbl.setMinimumSize(dim);
		splitPane.setLeftComponent(lbl);
		btnBackground = new JButton();
		btnBackground.setBackground(config.Background);
		btnBackground.addActionListener(new AbstractAction("Background color") {
		    public void actionPerformed(ActionEvent e) {
		    	Color color = JColorChooser.showDialog(contentPane, "Color picker", btnBackground.getBackground());
		    	btnBackground.setBackground(color);
		    	config.Background = color;
		    	config.Updated();
		    }
		});
		splitPane.setRightComponent(btnBackground);
		
		splitPane = new JSplitPane();
		splitPane.setMaximumSize(new Dimension(99999,20));
		contentPane.add(splitPane);
		
		lbl = new JLabel("CPU Gauge color");
		lbl.setMinimumSize(dim);
		splitPane.setLeftComponent(lbl);
		
		btnCPUGaugeColor = new JButton();
		btnCPUGaugeColor.setBackground(config.CPUGaugeColor);
		btnCPUGaugeColor.addActionListener(new AbstractAction("Color") {
		    public void actionPerformed(ActionEvent e) {
		    	Color color = JColorChooser.showDialog(contentPane, "Color picker", btnCPUGaugeColor.getBackground());
		    	btnCPUGaugeColor.setBackground(color);
		    	config.CPUGaugeColor = color;
		    	config.Updated();
		    }
		});
		splitPane.setRightComponent(btnCPUGaugeColor);
		
		splitPane = new JSplitPane();
		splitPane.setMaximumSize(new Dimension(99999,20));
		contentPane.add(splitPane);
		
		lbl = new JLabel("CPU Gauge indicator color");
		lbl.setMinimumSize(dim);
		splitPane.setLeftComponent(lbl);
		
		btnCPUGaugeIndicatorColor = new JButton();
		btnCPUGaugeIndicatorColor.setBackground(config.CPUGaugeIndicatorColor);
		btnCPUGaugeIndicatorColor.addActionListener(new AbstractAction("Color") {
		    public void actionPerformed(ActionEvent e) {
		    	Color color = JColorChooser.showDialog(contentPane, "Color picker", btnCPUGaugeIndicatorColor.getBackground());
		    	btnCPUGaugeIndicatorColor.setBackground(color);
		    	config.CPUGaugeIndicatorColor = color;
		    	config.Updated();
		    }
		});
		splitPane.setRightComponent(btnCPUGaugeIndicatorColor);
		
		splitPane = new JSplitPane();
		splitPane.setMaximumSize(new Dimension(99999,20));
		contentPane.add(splitPane);
		
		lbl = new JLabel("GPU Gauge color");
		lbl.setMinimumSize(dim);
		splitPane.setLeftComponent(lbl);
		
		btnGPUGaugeColor = new JButton();
		btnGPUGaugeColor.setBackground(config.GPUGaugeColor);
		btnGPUGaugeColor.addActionListener(new AbstractAction("Color") {
		    public void actionPerformed(ActionEvent e) {
		    	Color color = JColorChooser.showDialog(contentPane, "Color picker", btnGPUGaugeColor.getBackground());
		    	btnGPUGaugeColor.setBackground(color);
		    	config.GPUGaugeColor = color;
		    	config.Updated();
		    }
		});
		splitPane.setRightComponent(btnGPUGaugeColor);
		
		splitPane = new JSplitPane();
		splitPane.setMaximumSize(new Dimension(99999,20));
		contentPane.add(splitPane);
		
		lbl = new JLabel("GPU Gauge indicator color");
		lbl.setMinimumSize(dim);
		splitPane.setLeftComponent(lbl);
		
		btnGPUGaugeIndicatorColor = new JButton();
		btnGPUGaugeIndicatorColor.setBackground(config.GPUGaugeIndicatorColor);
		btnGPUGaugeIndicatorColor.addActionListener(new AbstractAction("Color") {
		    public void actionPerformed(ActionEvent e) {
		    	Color color = JColorChooser.showDialog(contentPane, "Color picker", btnGPUGaugeIndicatorColor.getBackground());
		    	btnGPUGaugeIndicatorColor.setBackground(color);
		    	config.GPUGaugeIndicatorColor = color;
		    	config.Updated();
		    }
		});
		splitPane.setRightComponent(btnGPUGaugeIndicatorColor);
		
		splitPane = new JSplitPane();
		splitPane.setMaximumSize(new Dimension(99999,20));
		contentPane.add(splitPane);
		
		lbl = new JLabel("Progress bar color");
		lbl.setMinimumSize(dim);
		splitPane.setLeftComponent(lbl);
		
		btnProgressbarColor = new JButton();
		btnProgressbarColor.setBackground(config.ProgressBarColors);
		btnProgressbarColor.addActionListener(new AbstractAction("Color") {
		    public void actionPerformed(ActionEvent e) {
		    	Color color = JColorChooser.showDialog(contentPane, "Color picker", btnProgressbarColor.getBackground());
		    	btnProgressbarColor.setBackground(color);
		    	config.ProgressBarColors = color;
		    	config.Updated();
		    }
		});
		splitPane.setRightComponent(btnProgressbarColor);
		
		splitPane = new JSplitPane();
		splitPane.setMaximumSize(new Dimension(99999,20));
		contentPane.add(splitPane);
		
		lbl = new JLabel("Progress bar critical color");
		lbl.setMinimumSize(dim);
		splitPane.setLeftComponent(lbl);
		
		btnProgressbarCriticalColor = new JButton();
		btnProgressbarCriticalColor.setBackground(config.ProgressCriticalColors);
		btnProgressbarCriticalColor.addActionListener(new AbstractAction("Color") {
		    public void actionPerformed(ActionEvent e) {
		    	Color color = JColorChooser.showDialog(contentPane, "Color picker", btnProgressbarCriticalColor.getBackground());
		    	btnProgressbarCriticalColor.setBackground(color);
		    	config.ProgressCriticalColors = color;
		    	config.Updated();
		    }
		});
		splitPane.setRightComponent(btnProgressbarCriticalColor);
		
		splitPane = new JSplitPane();
		splitPane.setMaximumSize(new Dimension(99999,20));
		contentPane.add(splitPane);
		
		lbl = new JLabel("Fans color");
		lbl.setMinimumSize(dim);
		splitPane.setLeftComponent(lbl);
		
		btnFansColor = new JButton();
		btnFansColor.setBackground(config.FansColor);
		btnFansColor.addActionListener(new AbstractAction("Color") {
		    public void actionPerformed(ActionEvent e) {
		    	Color color = JColorChooser.showDialog(contentPane, "Color picker", btnFansColor.getBackground());
		    	btnFansColor.setBackground(color);
		    	config.FansColor = color;
		    	config.Updated();
		    }
		});
		splitPane.setRightComponent(btnFansColor);
		
		splitPane = new JSplitPane();
		splitPane.setMaximumSize(new Dimension(99999,20));
		contentPane.add(splitPane);
		
		lbl = new JLabel("CPU Max temp");
		lbl.setMinimumSize(dim);
		splitPane.setLeftComponent(lbl);
		
		txtCPUMaxTemp = new JTextField();
		txtCPUMaxTemp.setText(config.CPUMaxTemp.toString());
		splitPane.setRightComponent(txtCPUMaxTemp);
		txtCPUMaxTemp.addActionListener(new AbstractAction("Color") {
		    public void actionPerformed(ActionEvent e) {
		    	config.CPUMaxTemp = Double.parseDouble(txtCPUMaxTemp.getText());
		    	config.Updated();
		    }
		});
		
		splitPane = new JSplitPane();
		splitPane.setMaximumSize(new Dimension(99999,20));
		contentPane.add(splitPane);
		
		lbl = new JLabel("GPU Max temp");
		lbl.setMinimumSize(dim);
		splitPane.setLeftComponent(lbl);
		
		txtGPUMaxTemp = new JTextField();
		txtGPUMaxTemp.setText(config.GPUMaxTemp.toString());
		splitPane.setRightComponent(txtGPUMaxTemp);
		txtGPUMaxTemp.addActionListener(new AbstractAction("Color") {
		    public void actionPerformed(ActionEvent e) {
		    	config.GPUMaxTemp = Double.parseDouble(txtGPUMaxTemp.getText());
		    	config.Updated();
		    }
		});
		
		splitPane = new JSplitPane();
		splitPane.setMaximumSize(new Dimension(99999,20));
		contentPane.add(splitPane);
		
		lbl = new JLabel("CPU Critical temp");
		lbl.setMinimumSize(dim);
		splitPane.setLeftComponent(lbl);
		
		txtCPUCriticalTemp = new JTextField();
		txtCPUCriticalTemp.setText(config.CPUCriticalTemp.toString());
		splitPane.setRightComponent(txtCPUCriticalTemp);
		txtCPUCriticalTemp.addActionListener(new AbstractAction("Color") {
		    public void actionPerformed(ActionEvent e) {
		    	config.CPUCriticalTemp = Double.parseDouble(txtCPUCriticalTemp.getText());
		    	config.Updated();
		    }
		});
		
		splitPane = new JSplitPane();
		splitPane.setMaximumSize(new Dimension(99999,20));
		contentPane.add(splitPane);
		
		lbl = new JLabel("GPU Critical temp");
		lbl.setMinimumSize(dim);
		splitPane.setLeftComponent(lbl);
		
		txtGPUCriticalTemp = new JTextField();
		txtGPUCriticalTemp.setText(config.GPUCriticalTemp.toString());
		splitPane.setRightComponent(txtGPUCriticalTemp);
		txtGPUCriticalTemp.addActionListener(new AbstractAction("Color") {
		    public void actionPerformed(ActionEvent e) {
		    	config.GPUCriticalTemp = Double.parseDouble(txtGPUCriticalTemp.getText());
		    	config.Updated();
		    }
		});
		
		splitPane = new JSplitPane();
		splitPane.setMaximumSize(new Dimension(99999,20));
		contentPane.add(splitPane);
		
		lbl = new JLabel("Display CPU cores");
		lbl.setMinimumSize(new Dimension(100,99999));
		splitPane.setLeftComponent(lbl);
		
		cbDisplayCores = new JCheckBox();
		cbDisplayCores.setSelected(config.DisplayCPUCores);
		cbDisplayCores.setText(config.DisplayCPUCores.toString());
		splitPane.setRightComponent(cbDisplayCores);
		cbDisplayCores.addActionListener(new AbstractAction("Color") {
		    public void actionPerformed(ActionEvent e) {
		    	config.DisplayCPUCores = cbDisplayCores.isSelected();
		    	config.Updated();
		    }
		});
		
		splitPane = new JSplitPane();
		splitPane.setMaximumSize(new Dimension(99999,20));
		contentPane.add(splitPane);
		
		lbl = new JLabel("Led visible");
		lbl.setMinimumSize(new Dimension(100,99999));
		splitPane.setLeftComponent(lbl);
		
		cbCriticalLed = new JCheckBox();
		cbCriticalLed.setSelected(config.CriticalLedVisible);
		cbCriticalLed.setText(config.CriticalLedVisible.toString());
		splitPane.setRightComponent(cbCriticalLed);
		cbCriticalLed.addActionListener(new AbstractAction("Color") {
		    public void actionPerformed(ActionEvent e) {
		    	config.CriticalLedVisible = cbCriticalLed.isSelected();
		    	config.Updated();
		    }
		});
		
	}
}
