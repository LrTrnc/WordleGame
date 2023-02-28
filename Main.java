package cmp;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.RenderingHints.Key;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import javax.swing.JFrame;


public class Main {

	public static int size_x=600;
	public static int size_y=800;
	
	public static int font_size=55;
	
	public static Font font;
	
	public static String current="";
	
	public static void main(String[] args) {
		

		/*
		InputStream is = Main.class.getResourceAsStream("buenard.ttf");
		try {
			font=Font.createFont(Font.TRUETYPE_FONT, is);
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		JFrame fr = new JFrame();
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setSize(600, 900);
		fr.setVisible(true);
		
		fr.add(new WordleLayer());
		
		fr.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				char c = e.getKeyChar();
				System.out.println(e.getKeyCode());
				if(e.getKeyCode()==KeyEvent.VK_BACK_SPACE) {
					if(current.length()>0) {
						current=current.substring(0,current.length()-1);
						//System.err.println(current);
					}
				}
				else if(current.length()<5) {
					current+=(c+"");
				}if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					if(current.length()==5) {
						
						WordData nw = Checker.checkWord(current);
						WordleLayer.active.addWordData(nw);
						current="";
						//System.err.println(current);
					}
				}
				WordleLayer.active.refresh();
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			String str = sc.nextLine();
			
			WordData w = Checker.checkWord(str);
			
			for (int i :w.data) {
				System.out.print(i+" ");
			}
			
			WordleLayer.active.addWordData(w);
			
			System.out.println();
			
		}
		
	}
	
}
