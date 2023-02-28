package cmp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JLabel;

public class WordleLayer extends JLabel{

	public static WordleLayer active;
	
	public int size=50;
	
	
	public ArrayList<WordData> list = new ArrayList<WordData>();
	
	public WordleLayer() {
		// TODO Auto-generated constructor stub
		active=this;
	}
	
	public void addWordData(WordData w) {
		list.add(w);
		repaint();
	}
	public void refresh() {
		repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		float topY=0.5f; 	// boþluklarý ayarlar
		int count=0; 		// kaç adet word bilgisi yazdýrýldýðýný tutar
		for(WordData w : list) {
			w.drawWord(g, (int)((WordData.sizeY+WordData.spaceTop)*topY));
			topY+=1;
			count++;
		}
		String m = Main.current+"     ";
		new WordData(m.toUpperCase(),new int[5]).drawWord(g, (int)((WordData.sizeY+WordData.spaceTop)*topY));
		count++;
		topY+=1;
		for(int i = count;i<5;i++) {
			new WordData().drawWord(g, (int)((WordData.sizeY+WordData.spaceTop)*topY));
			topY+=1;
			count++;
		}
		//*/
		
		
	}
	
}
