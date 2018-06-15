package LangtonsAnt;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class AntFrame {

	private Ant a = new Ant(50, 50, Direction.South);	
	private World w = new World();
	private int world[][] = w.getWorld();
	
	private int steps = a.getSteps();
	private Timer timer = new Timer();
	private JFrame f = new JFrame();
	private int worldSize = w.getWorldSize();
	private AntPanel antPanel = new AntPanel();
   	
	public AntFrame() {
		f.setSize(600, 600);
		f.setTitle("Langtons Ant");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(new FlowLayout());
		f.add(antPanel);
		f.setVisible(true);		
		world[50][50] =1;
		a.setDirection(Direction.South);
		timer.schedule(new SimulationThread(), 400, 5);
	 
	}

	class SimulationThread extends TimerTask {

		private int tmp =0;
			
		@Override
		public void run() {
			   
	
				if(a.nextStep(world,a)==true) {
			      
					a.nextStep(world, a);
			       antPanel.repaint();
				   tmp = tmp+1;
				}
				else {
					timer.cancel();
				}										
		
		if(tmp==steps) {
			timer.cancel();
		}
				
		}	
	}
	class AntPanel extends JPanel {
				
		public AntPanel() {
			setPreferredSize(new Dimension(600, 600));
			setBackground(Color.WHITE);
		}

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);

			for (int i = 0; i < world.length; i++) {
				for (int j = 0; j < world.length; j++) {

					if (world[i][j] == 1) {
						g.setColor(Color.BLACK);
						g.fillRect(i * 3, j * 3, 3, 3);

					}
				}
			}
		}

	}

	public static void main(String[] args) {

		new AntFrame();
	}

}
