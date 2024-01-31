package esercizio;

import java.awt.Color;
import java.util.Scanner;
import javax.swing.*;

public class lettura implements Runnable {
	
	static Scanner leggi;
	static JPanel panel1;
	static JPanel panel2;
	static JPanel panel3;
	
	String s;
	String[] x = new String[2];
	
	

    @Override
    public void run() {
    	try {   
        	while (leggi.hasNextLine()) {
        		System.out.println("nel thread");
                s = leggi.nextLine();
                System.out.println("ho letto: " + s);
                
                x = s.split(";");
                
                
                if(x[0].equals("0")) {
					if(x[1].equals("SX")) {
						panel1.setBackground(Color.WHITE);
					}
					else if(x[1].equals("CX")) {
						panel2.setBackground(Color.WHITE);
					}
					else if(x[1].equals("DX")) {
						panel3.setBackground(Color.WHITE);
					}
				}
				
				else if(x[0].equals("1")) {
					if(x[1].equals("SX")) {
						panel1.setBackground(Color.BLACK);
					}
					else if(x[1].equals("CX")) {
						panel2.setBackground(Color.BLACK);
					}
					else if(x[1].equals("DX")) {
						panel3.setBackground(Color.BLACK);
					}
				}
				
				else if(x[0].equals("2")) {
					if(x[1].equals("SX")) {
						panel1.setBackground(Color.GREEN);
					}
					else if(x[1].equals("CX")) {
						panel2.setBackground(Color.GREEN);
					}
					else if(x[1].equals("DX")) {
						panel3.setBackground(Color.GREEN);
					}
				}
				
				else if(x[0].equals("3")) {
					if(x[1].equals("SX")) {
						panel1.setBackground(Color.RED);
					}
					else if(x[1].equals("CX")) {
						panel2.setBackground(Color.RED);
					}
					else if(x[1].equals("DX")) {
						panel3.setBackground(Color.RED);
					}
				}
				
				else if(x[0].equals("4")) {
					if(x[1].equals("SX")) {
						panel1.setBackground(Color.YELLOW);
					}
					else if(x[1].equals("CX")) {
						panel2.setBackground(Color.YELLOW);
					}
					else if(x[1].equals("DX")) {
						panel3.setBackground(Color.YELLOW);
					}
				}
				
				else if(x[0].equals("5")) {
					if(x[1].equals("SX")) {
						panel1.setBackground(Color.BLUE);
					}
					else if(x[1].equals("CX")) {
						panel2.setBackground(Color.BLUE);
					}
					else if(x[1].equals("DX")) {
						panel3.setBackground(Color.BLUE);
					}
				}
				
				else if(x[0].equals("6")) {
					if(x[1].equals("SX")) {
						panel1.setBackground(Color.ORANGE);
					}
					else if(x[1].equals("CX")) {
						panel2.setBackground(Color.ORANGE);
					}
					else if(x[1].equals("DX")) {
						panel3.setBackground(Color.ORANGE);
					}
				}
        	}
        	Thread.sleep(100);
    	}
    	catch (InterruptedException e) {
    		return;
	}  
        
    }
}
