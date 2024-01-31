import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;

public class Daniele_2023_11_07 {

	private JFrame frame;
	JTextField addtxt;
	JTextField portTxt;
	JButton btnStart = new JButton("Start");
    JButton btnStop = new JButton("Stop");
    JButton btnClear = new JButton("Clear");
    JButton buttonDis = new JButton("Disconnetti");
    Socket socket;
    JTextArea txtPdf = new JTextArea(5, 15);
    JTextArea txtMp3 = new JTextArea(5, 15);
    JTextArea txtLog = new JTextArea(5, 15);
    Scanner scanner;
    Double sum = 0.0;
    JTextField txtDim;
    private PrintWriter writer;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Daniele_2023_11_07 window = new Daniele_2023_11_07();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Daniele_2023_11_07() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Daniele D'Alonzo 2059687");
		frame.setBounds(100, 100, 650, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		frame.setLayout(new GridLayout(3,3));
		JLabel addLab = new JLabel("Server address");
		addtxt = new JTextField(5);
		JLabel portLab = new JLabel("Port");
		portTxt = new JTextField(3);
        
		JButton buttonCon = new JButton("Connetti");
		buttonCon.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					socket = new Socket(addtxt.getText().toString() , Integer.valueOf(portTxt.getText().toString()));
					writer = new PrintWriter(socket.getOutputStream());
					buttonCon.setEnabled(false);
					btnClear.setEnabled(true);
					btnStart.setEnabled(true);
					buttonDis.setEnabled(true);
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Inserire un numero corretto nella porta", "Info Box", JOptionPane.INFORMATION_MESSAGE);
					   
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (UnknownHostException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Inserire un domain server corretto", "Info Box", JOptionPane.INFORMATION_MESSAGE);
					 
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
      
      
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(addLab);
        panel.add(addtxt);
        panel.add(portLab);
        panel.add(portTxt);
        panel.add(buttonCon);
        panel.add(buttonDis);
        frame.add(panel,0,0);
        
        
        JPanel secondo = new JPanel(new FlowLayout());
        
        txtMp3.setLineWrap(true); // Abilita il riavvolgimento automatico delle linee
        txtMp3.setWrapStyleWord(true); // Abilita il riavvolgimento delle parole

        JScrollPane scrollPane = new JScrollPane(txtLog);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); // Aggiunge la barra di scorrimento orizzontale

        TitledBorder border = new TitledBorder("Log");
        border.setTitleJustification(TitledBorder.LEFT);
        border.setTitlePosition(TitledBorder.TOP);
        scrollPane.setBorder(border);
        //secondo panel
        txtPdf.setLineWrap(true); // Abilita il riavvolgimento automatico delle linee
        txtPdf.setWrapStyleWord(true); // Abilita il riavvolgimento delle parole

        JScrollPane scrollPane2 = new JScrollPane(txtPdf);
        scrollPane2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); // Aggiunge la barra di scorrimento orizzontale

        TitledBorder border2 = new TitledBorder(".pdf");
        border2.setTitleJustification(TitledBorder.LEFT);
        border2.setTitlePosition(TitledBorder.TOP);
        scrollPane2.setBorder(border2);
        
        //terzo panel
    
        txtLog.setLineWrap(true); // Abilita il riavvolgimento automatico delle linee
        txtLog.setWrapStyleWord(true); // Abilita il riavvolgimento delle parole

        JScrollPane scrollPane3 = new JScrollPane(txtMp3);
        scrollPane3.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); // Aggiunge la barra di scorrimento orizzontale

        TitledBorder border3 = new TitledBorder(".txtMp3");
        border3.setTitleJustification(TitledBorder.LEFT);
        border3.setTitlePosition(TitledBorder.TOP);
        scrollPane3.setBorder(border3);
        secondo.add(scrollPane);
        secondo.add(scrollPane2);
        secondo.add(scrollPane3);
        
        frame.add(secondo,0,1);
    
        
        JPanel terzo = new JPanel(new FlowLayout());
        JLabel dim = new JLabel("Dimensione");
        txtDim = new JTextField(7);
        
        terzo.add(dim);
        terzo.add(txtDim);
        disattivaPulsanti();
        
        terzo.add(btnStart);
        terzo.add(btnClear);
        terzo.add(btnStop);
        btnStop.setEnabled(false);
        frame.add(terzo,0,2);
        
        
        btnStart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(socket.isConnected()) {
					try {
						PrintWriter print = new PrintWriter(socket.getOutputStream());
						print.println("start");
						print.flush();
						cancellaRis();
						disattivaPulsanti();
						btnStop.setEnabled(true);
						
						scanner = new Scanner(socket.getInputStream());
						ThreadNetwork thread = new ThreadNetwork();
						thread.start();
						btnStop.setEnabled(true);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			}
		});
        
        
        btnStop.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btnStop.setEnabled(false);
				writer.println("stop");
				writer.flush();
				attivaPulsanti();
			}
		});
        
        buttonDis.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					writer.println("disconnect");
					writer.flush();
					socket.close();
					disattivaPulsanti();
					buttonCon.setEnabled(true);
					btnStop.setEnabled(false);
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
		});
        
        btnClear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				clearAll();
			}
		});
	}
	
	void disattivaPulsanti() {
		btnClear.setEnabled(false);
        btnStart.setEnabled(false);
        buttonDis.setEnabled(false);
	}
	
	void attivaPulsanti() {
		btnClear.setEnabled(true);
        btnStart.setEnabled(true);
        buttonDis.setEnabled(true);
	}
	
	void cancellaRis() {
		txtMp3.setText("");
		txtLog.setText("");
		txtPdf.setText("");
	}
	
	void clearAll(){
		txtDim.setText("");
		txtLog.setText("");
		txtMp3.setText("");
		txtPdf.setText("");
	}
	
	

class ThreadNetwork extends Thread {
  @Override
  public void run() {
  	
		while(scanner.hasNextLine()) {			
			String response = scanner.nextLine().toString();
			
			if(!response.contains("END") && !response.contains("INTERRUPTED")){
			System.out.println(response);
			txtLog.setText(txtLog.getText().toString() + response.split(":")[1] + response.split(":")[2] + "\n");
			
			if(response.contains("MP3")){
				txtMp3.setText(txtMp3.getText().toString() + response.split(":")[1] + "\n");
			}else {
					
				txtPdf.setText(txtPdf.getText().toString() + response.split(":")[1] + "\n");
			}
			sum += Double.parseDouble(response.split(":")[2].split(" ")[0]);
			txtDim.setText(sum + " KB");
			}else {
				attivaPulsanti();
				btnStop.setEnabled(false);
				break;
			}
		}
		
  }
 
}

}
