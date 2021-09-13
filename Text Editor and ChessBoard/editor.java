import java.awt.*; 
import javax.swing.*; 
import java.io.*; 
import java.awt.event.*; 
import javax.swing.text.*; 
class editor extends JFrame implements ActionListener 
{ 
    	JTextArea t; 
   	 JFrame f; 
   	 editor() 
   	 { 
        		f = new JFrame("editor");
        		t = new JTextArea(); 
 		JMenuBar mb = new JMenuBar();
        		JMenu m1 = new JMenu("File");
       		 JMenuItem mi1 = new JMenuItem("New"); 
        		JMenuItem mi2 = new JMenuItem("Open"); 
       	 	 JMenuItem mi3 = new JMenuItem("Save"); 
        		JMenuItem mi9 = new JMenuItem("Print");
       		 mi1.addActionListener(this); 
        		mi2.addActionListener(this); 
       		 mi3.addActionListener(this); 
        		mi9.addActionListener(this); 
  
        		m1.add(mi1); 
        		m1.add(mi2); 
        		m1.add(mi3); 
        		m1.add(mi9);
       		 JMenu m2 = new JMenu("Edit");
        		JMenuItem mi4 = new JMenuItem("cut"); 
        		JMenuItem mi5 = new JMenuItem("copy"); 
        		JMenuItem mi6 = new JMenuItem("paste");
       		 mi4.addActionListener(this); 
        		mi5.addActionListener(this); 
        		mi6.addActionListener(this); 
  
        		m2.add(mi4); 
        		m2.add(mi5); 
        		m2.add(mi6); 
  
        		JMenuItem mc = new JMenuItem("close"); 
  
       		 mc.addActionListener(this); 
  
        		mb.add(m1); 
        		mb.add(m2); 
        		mb.add(mc); 
  
        		f.setJMenuBar(mb); 
        		f.add(t); 
        		f.setSize(500, 500); 
        		f.show(); 
   	 } 
  
    	// If a button is pressed 
    	public void actionPerformed(ActionEvent e) 
   	 { 
        		String s = e.getActionCommand(); 
  
        		if (s.equals("cut")) 
		{ 
            			t.cut(); 
        		} 
        		else if (s.equals("copy")) 
		{ 
           		 	t.copy(); 
       		 } 
        		else if (s.equals("paste")) 
		{ 
            			t.paste(); 
       	 	} 
        		else if (s.equals("Save"))
	 	{ 
			try
            		{
                		FileDialog fd=new FileDialog(this,"Save File",FileDialog.SAVE);
                		fd.setVisible(true);
                		String txt=txta_show.getText();
                		String dir=fd.getDirectory();
                		String fname=fd.getFile();
                		FileOutputStream fos=new FileOutputStream(dir+fname);
                		DataOutputStream dos=new DataOutputStream(fos);
                		dos.writeBytes(txt);
                		dos.close();
            		}
               		catch(Exception e)
            {
            }}

        		else if (s.equals("Print"))
	 		{ 
            			try
		 		{ 
                				t.print(); 
           		 	} 
            			
				catch (Exception evt) {} 
        		} 
        		else if (s.equals("Open"))
	 		{ 
            			try
            			{
                			FileDialog fd=new FileDialog(this,"Open File",FileDialog.LOAD);
                			fd.setVisible(true);
                			String dir=fd.getDirectory();
                			String fname=fd.getFile();
                			FileInputStream fis=new FileInputStream(dir+fname);
                			DataInputStream dis=new DataInputStream(fis);
                			String str=" ",msg=" ";
                			while((str=dis.readLine())!=null)
                			{
                    				msg=msg+str;
                    				msg+="\n";
                			}
                			txta_show.setText(msg);
                			dis.close();
            			}
            			catch(Exception e){}
        		}

   		} 
        		else if (s.equals("New")) 
		{ 
            			t.setText(""); 
        		} 
        		else if (s.equals("close"))
	 	{ 
            			f.setVisible(false); 
        		} 
    	} 

    	public static void main(String args[]) 
    	{ 
        		editor e = new editor(); 
    	} 
} 