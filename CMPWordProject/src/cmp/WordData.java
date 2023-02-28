package cmp;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class WordData {
	
	public static int sizeX=80;
	public static int sizeY=85;
	public static int spaceBetween=10;
	public static int spaceTop=10;
	public static int slide_back_x=3;
	public static int slide_back_y=3;
	
	public boolean isEmpty=false;
	
	public static Color[] clr = new Color[] {
			Color.DARK_GRAY,
			new Color(241, 195, 57),
			new Color(78,214,24)
	};
	
	
	public WordData(String word,int[] data) {
		this.word=word;
		this.data=data;
		isEmpty=false;
		
	}
	public WordData() {
		isEmpty=true;
	}
	
	public String word = "     ";
	public int[] data = new int[5];
	
	
	public void drawWord(Graphics g,int y) {
		
		g.setFont(new Font("Ariel", Font.BOLD, Main.font_size)); 
		
		drawSquare(g, Main.size_x/2-(2*spaceBetween+sizeX*2), y, data[0], word.charAt(0));
		drawSquare(g, Main.size_x/2-(spaceBetween+sizeX), y, data[1], word.charAt(1));
		drawSquare(g, Main.size_x/2, y, data[2], word.charAt(2));
		drawSquare(g, Main.size_x/2+(spaceBetween+sizeX), y, data[3], word.charAt(3));
		drawSquare(g, Main.size_x/2+(2*spaceBetween+sizeX*2), y, data[4], word.charAt(4));
		
	}
	public void drawSquare(Graphics g,int centerX,int centerY,int i,char c) {
		if(!isEmpty) {
			g.setColor(Color.BLACK);
			g.fillRect(centerX - sizeX/2+slide_back_x, centerY - sizeY/2 + slide_back_y, sizeX, sizeY);
			g.setColor(clr[i]);
			g.fillRect(centerX - sizeX/2, centerY - sizeY/2 , sizeX, sizeY);
			g.setColor(Color.WHITE);
			g.drawString(c+"", centerX-(int)(Main.font_size*0.3f), centerY+(int)(Main.font_size*0.3f));
		}else {
			g.setColor(Color.black);
			g.fillRect(centerX - sizeX/2, centerY - sizeY/2 , sizeX, sizeY);
			g.setColor(Color.white);
			g.drawRect(centerX - sizeX/2, centerY - sizeY/2 , sizeX, sizeY);
			g.setColor(Color.white);
			g.drawRect(centerX - sizeX/2, centerY - sizeY/2 , sizeX, sizeY);
		}
		
	}
	
}
