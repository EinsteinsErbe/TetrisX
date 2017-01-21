package com.major94.TetrisX.other;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

/**
 * Diverse nützliche Methoden:
 * Länge einer Integer-Zahl bestimmen,
 * Linie erzeugen,
 * Leerschläge erzeugen,
 * Pause-Funktion,
 * Read-Funktionen (Int, Double und String)
 * 
 * @author Manuel
 * @version 1.0
 */

public class Tools {
	private static java.util.Scanner pause;
	private static java.util.Scanner scanner;
	private static java.util.Scanner scanner2;
	private static java.util.Scanner scanner3;

	/**
	 * Erzeugt eine Linie mit definierbarer Länge und Darstellung
	 * 
	 * @param length Länge der Linie
	 * @param character Bestandteile der Linie
	 * @return String mit der Linie
	 */
	//Linie erzeugen
	public static String createLine (int length, char character){
		String line = "";
		for(int i=0; i<length; i++){
			line += character;
		}
		return line;
	}

	/**
	 * Bestimmt die Länge eines Integer-Wertes.
	 * Das Vorzeichen wird beachtet.
	 * 
	 * @param integer Zahl (int)
	 * @return Länge (int)
	 */
	//Länge eines Integers bestimmen
	public static int intLength(int integer){
		int length = 1;
		if(integer<0){
			length++;
			integer = integer*(-1);
		}
		while(integer>=10){
			length++;
			integer = (int)integer/10;
		}
		return length;
	}

	/**
	 * Erzeugt einen String mit Leerschlägen
	 * 
	 * @param length Anzahl Leerschläge
	 * @return String mit Leerschlägen
	 */
	//Leerschläge erzeugen
	public static String createSpace(int length){
		String space = "";
		for(int i=0; i<length; i++){
			space += " ";
		}
		return space;
	}

	/**
	 * Pausiert das Programm und wartet auf die Betätigung der ENTER-Taste.
	 */
	//Pause
	public static void pause(){
		try {
			Thread.sleep(500);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.print("\nZum Fortfahren ENTER drücken...");

		pause = new java.util.Scanner(System.in);
		pause.nextLine();
		//pause.close();
	}

	/**
	 * Gibt eine Dezimalzahl im gewünschten Format rechtsbündig bezogen auf die Referenzlänge aus.
	 * 
	 * @param value Zahl
	 * @param format Zahlenformat (z.B. "#0.00")
	 * @param maxLength Referenzlänge
	 */
	//Read Integer
	public static void printValue(double value, String format, int maxLength){
		java.text.DecimalFormat f;
		
		f = new java.text.DecimalFormat(format);
		
		int length = 1;
		int integer = (int)value;
		if(integer<0){
			length++;
			integer = integer*(-1);
		}
		while(integer>=10){
			length++;
			integer = (int)integer/10;
		}
		System.out.println(Tools.createSpace(maxLength-length)+f.format(value));
	}
	
	/**
	 * Liest einen Integer-Wert mit Eingabeaufforderung ein.
	 * Wiederholung bei ungültiger Eingabe.
	 * 
	 * @param instruction Eingabebefehl (String)
	 * @return Integer-Wert
	 */
	//Read Integer
	public static int readInt(String instruction){
		scanner = new java.util.Scanner(System.in);
		int input = 0;
		boolean control = false;
		while(!control){
			System.out.print(instruction);
			try{
				input = Integer.parseInt(scanner.next());
				control = true;
			}
			catch(Exception e){
				System.err.println("Ungültige Eingabe!");
			}
			try{
				Thread.sleep(100);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return input;
	}
	
	/**
	 * Liest einen Double-Wert mit Eingabeaufforderung ein.
	 * Wiederholung bei ungültiger Eingabe.
	 * 
	 * @param instruction Eingabebefehl (String)
	 * @return Double-Wert
	 */
	//Read Double
	public static double readDouble(String instruction){
		scanner2 = new java.util.Scanner(System.in);
		double input = 0.0;
		boolean control = false;
		while(!control){
			System.out.print(instruction);
			try{
				input = Double.parseDouble(scanner2.next());
				control = true;
			}
			catch(Exception e){
				System.err.println("Ungültige Eingabe!");
			}
			try{
				Thread.sleep(100);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return input;
	}
	
	/**
	 * Liest einen String mit Eingabeaufforderung ein.
	 * Wiederholung bei ungültiger Eingabe.
	 * 
	 * @param instruction Eingabebefehl (String)
	 * @return String
	 */
	//Read String
	public static String readString(String instruction){
		scanner3 = new java.util.Scanner(System.in);
		String input = "";
		boolean control = false;
		while(!control){
			System.out.print(instruction);
			try{
				input = scanner3.nextLine();
				control = true;
			}
			catch(Exception e){
				System.err.println("Ungültige Eingabe!");
			}
			try{
				Thread.sleep(100);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return input;
	}
	
	/**
	 * Gibt String zentriert aus
	 * 
	 */
	//Read String
	public static void drawCenteredString(int x, int y, String text, Font font, Color color, Graphics g){
		FontMetrics metrics;
		metrics = g.getFontMetrics(font);
		g.setColor(color);
		g.setFont(font);
		g.drawString(text, x-metrics.stringWidth(text)/2, y+(int)(metrics.getAscent()*0.716)/2);
	}
	
	public static void drawCenteredString(int x, int y, int width, int height, String text, Font font, Color color, Graphics g){
		FontMetrics metrics;
		metrics = g.getFontMetrics(font);
		g.setColor(color);
		g.setFont(font);
		g.drawString(text, x+(width-metrics.stringWidth(text))/2, y+(height+(int)(metrics.getAscent()*0.716))/2);
	}
}
