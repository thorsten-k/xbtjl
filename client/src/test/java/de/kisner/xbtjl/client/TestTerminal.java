package de.kisner.xbtjl.client;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import de.kisner.xbtjl.XbtjlBootstrap;

public class TestTerminal 
{
	final static Logger logger = LoggerFactory.getLogger(TestTerminal.class);
	
	public TestTerminal()
	{
		
	}
	
	public void terminal() throws InterruptedException, IOException
	{
		DefaultTerminalFactory tf = new DefaultTerminalFactory();
		Terminal terminal = tf.createTerminal();
		
		terminal.enterPrivateMode();
		 
	    terminal.putCharacter('H');
	    terminal.putCharacter('e');
	    terminal.putCharacter('l');
	    terminal.putCharacter('l');
	    terminal.putCharacter('o');
	    terminal.putCharacter('!');

		 
	    Thread.sleep(1000*5);
	    terminal.exitPrivateMode();
	}
	
	public void screen() throws InterruptedException, IOException
	{
		DefaultTerminalFactory tf = new DefaultTerminalFactory();
		Terminal terminal = tf.createTerminal();
		
		TerminalScreen screen = new TerminalScreen(terminal);
		
		screen.startScreen();
	    
		TextGraphics tg = screen.newTextGraphics();
		tg.putString(5, 5, "Hello");
		
		Thread.sleep(1000*5);
		
	    screen.stopScreen();
	}
	
	public static void main(String args[]) throws Exception
	{		
		XbtjlBootstrap.init();
		TestTerminal tt = new TestTerminal();
		tt.terminal();
		tt.screen();
		
	}
}