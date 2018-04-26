package trackers;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import graphics.MyDisplay;
import graphics.MyProgressBar;
import graphics.TempGauge;
import main.Config;
import main.ConfigListener;

public abstract class Tracker extends JPanel implements ConfigListener {

	public Tracker() {
		super();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		Panel_Main = new JPanel();
		Panel_Main.setBackground(Color.BLACK);
		this.add(Panel_Main);
		Panel_Main.setLayout(new BorderLayout(0, 0));
		
		Temp = new TempGauge(85.0);
		
		Temp.setTitle("Unknown");
		
		Panel_Fans = new JPanel();
		Panel_Fans.setOpaque(false);
		Panel_Fans.setPreferredSize(new Dimension(90,100));
		Panel_Fans.setLayout(new BoxLayout(Panel_Fans, BoxLayout.Y_AXIS));
		
		Panel_Loads = new JPanel();
		Panel_Loads.setOpaque(false);
		Panel_Loads.setPreferredSize(new Dimension(50,100));
		Panel_Loads.setLayout(new BoxLayout(Panel_Loads, BoxLayout.Y_AXIS));
		Panel_Loads.add(Box.createVerticalGlue());
		
		MainPB = new MyProgressBar(0,100, 70);
		SecondPB = new MyProgressBar(0,100, 70);
		
		Panel_Main.add(Temp, BorderLayout.CENTER);
		Panel_Main.add(Panel_Loads, BorderLayout.WEST);
		
		JPanel temp = new JPanel();
		temp.setOpaque(false);
		temp.setLayout(new BoxLayout(temp, BoxLayout.X_AXIS));
		temp.add(MainPB);
		temp.add(SecondPB);
		Panel_Loads.add(temp);
		
		FanDisplays = new ArrayList<MyDisplay>();
	}
	
	public void Init(final Integer FansCount) {
		this.FansCount = FansCount;
		
		for(int i = 0; i < FansCount; i++)
		{
			MyDisplay fan = new MyDisplay();
			Panel_Fans.add(fan);
			FanDisplays.add(fan);
		}
		
		if(this.FansCount > 0)
			Panel_Main.add(Panel_Fans, BorderLayout.EAST);
	}
	
	protected void Configure(final Config config) {
		Panel_Main.setOpaque(false);
		Panel_Main.setBackground(config.Background);
		MainPB.configure(config);
		SecondPB.configure(config);
		Temp.configure(config);
		
		for(MyDisplay disp : FanDisplays) {
			disp.configure(config);
		}
	}
	
	protected Integer FansCount;
	protected MyProgressBar MainPB;
	protected MyProgressBar SecondPB;
	protected TempGauge Temp;
	protected List<MyDisplay> FanDisplays;
	protected JPanel Panel_Fans;
	protected JPanel Panel_Loads;
	protected JPanel Panel_Main;
}
