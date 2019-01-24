package poka_score;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class BasketBall {
	
	public SashForm BasketTab(Composite sports_tab) {
		SashForm sashForm = new SashForm(sports_tab, SWT.HORIZONTAL);
        
        Composite score_comp = new Composite(sashForm, SWT.FILL);
        Composite extra_comp = new Composite(sashForm, SWT.FILL);
        
        GridLayout score_gridLayout = new GridLayout();
        score_gridLayout.numColumns = 4;
		score_comp.setLayout(score_gridLayout);
        
		GridData score_data = new GridData(GridData.FILL_BOTH);
		score_data.widthHint = 30;
        Label postech = new Label(score_comp, SWT.CENTER);
        postech.setText("POSTECH");
        postech.setLayoutData(score_data);

        score_data = new GridData(GridData.FILL_BOTH);
        score_data.widthHint = 5;
        Button p_down = new Button(score_comp, SWT.PUSH);
        p_down.setText("▽");
        p_down.setLayoutData(score_data);
        
        score_data = new GridData(GridData.FILL_BOTH);
        score_data.widthHint = 20;
        Text p_score = new Text(score_comp, SWT.BORDER | SWT.CENTER);
        p_score.setText("0");
        p_score.setLayoutData(score_data);
        
        score_data = new GridData(GridData.FILL_BOTH);
        score_data.widthHint = 5;
        Button p_up = new Button(score_comp, SWT.PUSH);
        p_up.setText("△");
        p_up.setLayoutData(score_data);
        
        p_down.addSelectionListener(new SelectionAdapter() {	 
      	   @Override
      	   public void widgetSelected(SelectionEvent arg0) {
      		   int p_int = Integer.parseInt(p_score.getText());
      		   if(p_int > 0)
      			   p_int = p_int - 1;
      	       p_score.setText(Integer.toString(p_int));
      	       
      	     PrintWriter p_pw = null;
 			try {
 				p_pw = new PrintWriter(Main.filePath + "/postech_score.txt");
 				
 				p_pw.print(p_score.getText());
 			} catch (FileNotFoundException e1) {
 				// TODO Auto-generated catch block
 				e1.printStackTrace();
 			}
 			p_pw.close();
      	   }
         });
         
         p_up.addSelectionListener(new SelectionAdapter() {	 
       	   @Override
       	   public void widgetSelected(SelectionEvent arg0) {
       		   int p_int = Integer.parseInt(p_score.getText());
       		   p_int = p_int + 1;
       	       p_score.setText(Integer.toString(p_int));
       	       
       	    PrintWriter p_pw = null;
			try {
				p_pw = new PrintWriter(Main.filePath + "/postech_score.txt");
				
				p_pw.print(p_score.getText());
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			p_pw.close();
       	   }
          });
        
        score_data = new GridData(GridData.FILL_BOTH);
		score_data.widthHint = 30;
		Label kaist = new Label(score_comp, SWT.CENTER);
        kaist.setText("KAIST");
        kaist.setLayoutData(score_data);
        
        score_data = new GridData(GridData.FILL_BOTH);
        score_data.widthHint = 5;
        Button k_down = new Button(score_comp, SWT.PUSH);
        k_down.setText("▽");
        k_down.setLayoutData(score_data);
        
        score_data = new GridData(GridData.FILL_BOTH);
        score_data.widthHint = 20;
        Text k_score = new Text(score_comp, SWT.BORDER | SWT.CENTER);
        k_score.setText("0");
        k_score.setLayoutData(score_data);
        
        score_data = new GridData(GridData.FILL_BOTH);
        score_data.widthHint = 5;
        Button k_up = new Button(score_comp, SWT.PUSH);
        k_up.setText("△");
        k_up.setLayoutData(score_data);
        
        k_down.addSelectionListener(new SelectionAdapter() {	 
       	   @Override
       	   public void widgetSelected(SelectionEvent arg0) {
       		   int k_int = Integer.parseInt(k_score.getText());
       		   if(k_int > 0)
       			   k_int = k_int - 1;
       	       k_score.setText(Integer.toString(k_int));
       	       
       	    PrintWriter k_pw = null;
			try {
				k_pw = new PrintWriter(Main.filePath + "/kaist_score.txt");
				
				k_pw.print(k_score.getText());
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			k_pw.close();
       	   }
          });
          
          k_up.addSelectionListener(new SelectionAdapter() {	 
        	   @Override
        	   public void widgetSelected(SelectionEvent arg0) {
        		   int k_int = Integer.parseInt(k_score.getText());
        		   k_int = k_int + 1;
        	       k_score.setText(Integer.toString(k_int));
        	       
        	       PrintWriter k_pw = null;
   				try {
   					k_pw = new PrintWriter(Main.filePath + "/kaist_score.txt");
   					
   					k_pw.print(k_score.getText());
   				} catch (FileNotFoundException e1) {
   					// TODO Auto-generated catch block
   					e1.printStackTrace();
   				}
   				k_pw.close();
        	   }
           });
          
        //extra_comp
        GridLayout extra_gridLayout = new GridLayout();
        extra_gridLayout.numColumns = 1;
        extra_comp.setLayout(extra_gridLayout);
          
        Group timeGroup = new Group(extra_comp, SWT.NONE);
        timeGroup.setText("경기 시간");
        timeGroup.setLayout(new RowLayout(SWT.HORIZONTAL));

        Button button1 = new Button(timeGroup, SWT.RADIO);
        button1.setSelection(true);
        button1.setText("1Q");
         
        Button button2 = new Button(timeGroup, SWT.RADIO);
        button2.setText("2Q");
        
        Button button3 = new Button(timeGroup, SWT.RADIO);
        button3.setText("3Q");
        
        Button button4 = new Button(timeGroup, SWT.RADIO);
        button4.setText("4Q");
        
        Button button5 = new Button(timeGroup, SWT.RADIO);
        button5.setText("연장");
        
        button1.addSelectionListener(new SelectionAdapter()  {	  
    		@Override
    		public void widgetSelected(SelectionEvent e) {
    			Button source=  (Button) e.getSource();
    		
    			if(source.getSelection()){
    				File first = new File(Main.filePath + "/basketball/score_1q.png");
    				File second = new File(Main.filePath + "/basketball/score_2q.png");
    				File third = new File(Main.filePath + "/basketball/score_3q.png");
    				File fourth = new File(Main.filePath + "/basketball/score_4q.png");
    				File fifth = new File(Main.filePath + "/basketball/score_연장.png");
    				File curr = new File(Main.filePath + "/basketball/score_current.png");
    				File temp = new File(Main.filePath + "/basketball/score_temp.png");

    				if(!second.exists()) {
    					curr.renameTo(second);
    					
    					try {
							Main.copyFileUsingChannel(first, temp);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
      					
      					temp.renameTo(curr);
    					//first.renameTo(curr);
    				}
    				else if(!third.exists()) {
    					curr.renameTo(third);
    					
    					try {
							Main.copyFileUsingChannel(first, temp);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
      					
      					temp.renameTo(curr);
    					//first.renameTo(curr);
    				}
    				else if(!fourth.exists()) {
    					curr.renameTo(fourth);
    					
    					try {
							Main.copyFileUsingChannel(first, temp);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
      					
      					temp.renameTo(curr);
    					//first.renameTo(curr);
    				}
    				else if(!fifth.exists()) {
    					curr.renameTo(fifth);
    					
    					try {
							Main.copyFileUsingChannel(first, temp);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
      					
      					temp.renameTo(curr);
    					//first.renameTo(curr);
    				}
    				else if(!first.exists()) {
    					
    				}
    				else if (first.exists() && second.exists() && third.exists() && fourth.exists() && fifth.exists()) {
    					curr.delete();
    					
    					try {
							Main.copyFileUsingChannel(first, temp);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
      					
      					temp.renameTo(curr);
    					//first.renameTo(curr);
    				}
    			}
    		}
      });
        
        button2.addSelectionListener(new SelectionAdapter()  {	  
    		@Override
    		public void widgetSelected(SelectionEvent e) {
    			Button source=  (Button) e.getSource();
    		
    			if(source.getSelection()){
    				File first = new File(Main.filePath + "/basketball/score_1q.png");
    				File second = new File(Main.filePath + "/basketball/score_2q.png");
    				File third = new File(Main.filePath + "/basketball/score_3q.png");
    				File fourth = new File(Main.filePath + "/basketball/score_4q.png");
    				File fifth = new File(Main.filePath + "/basketball/score_연장.png");
    				File curr = new File(Main.filePath + "/basketball/score_current.png");
    				File temp = new File(Main.filePath + "/basketball/score_temp.png");

    				if(!first.exists()) {
    					curr.renameTo(first);
    					
    					try {
							Main.copyFileUsingChannel(second, temp);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
      					
      					temp.renameTo(curr);
    					//second.renameTo(curr);
    				}
    				else if(!third.exists()) {
    					curr.renameTo(third);

    					try {
							Main.copyFileUsingChannel(second, temp);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
      					
      					temp.renameTo(curr);
    					//second.renameTo(curr);
    				}
    				else if(!fourth.exists()) {
    					curr.renameTo(fourth);

    					try {
							Main.copyFileUsingChannel(second, temp);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
      					
      					temp.renameTo(curr);
    					//second.renameTo(curr);
    				}
    				else if(!fifth.exists()) {
    					curr.renameTo(fifth);

    					try {
							Main.copyFileUsingChannel(second, temp);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
      					
      					temp.renameTo(curr);
    					//second.renameTo(curr);
    				}
    				else if(!second.exists()) {
    					
    				}
    				else if (first.exists() && second.exists() && third.exists() && fourth.exists() && fifth.exists()) {
    					curr.delete();

    					try {
							Main.copyFileUsingChannel(second, temp);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
      					
      					temp.renameTo(curr);
    					//second.renameTo(curr);
    				}
    			}
    		}
      });
        
        button3.addSelectionListener(new SelectionAdapter()  {	  
    		@Override
    		public void widgetSelected(SelectionEvent e) {
    			Button source=  (Button) e.getSource();
    		
    			if(source.getSelection()){
    				File first = new File(Main.filePath + "/basketball/score_1q.png");
    				File second = new File(Main.filePath + "/basketball/score_2q.png");
    				File third = new File(Main.filePath + "/basketball/score_3q.png");
    				File fourth = new File(Main.filePath + "/basketball/score_4q.png");
    				File fifth = new File(Main.filePath + "/basketball/score_연장.png");
    				File curr = new File(Main.filePath + "/basketball/score_current.png");
    				File temp = new File(Main.filePath + "/basketball/score_temp.png");

    				if(!second.exists()) {
    					curr.renameTo(second);
    					
    					try {
							Main.copyFileUsingChannel(third, temp);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
      					
      					temp.renameTo(curr);
    					//third.renameTo(curr);
    				}
    				else if(!first.exists()) {
    					curr.renameTo(first);
    					
    					try {
							Main.copyFileUsingChannel(third, temp);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
      					
      					temp.renameTo(curr);
    					//third.renameTo(curr);
    				}
    				else if(!fourth.exists()) {
    					curr.renameTo(fourth);
    					
    					try {
							Main.copyFileUsingChannel(third, temp);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
      					
      					temp.renameTo(curr);
    					//third.renameTo(curr);
    				}
    				else if(!fifth.exists()) {
    					curr.renameTo(fifth);
    					
    					try {
							Main.copyFileUsingChannel(third, temp);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
      					
      					temp.renameTo(curr);
    					//third.renameTo(curr);
    				}
    				else if(!third.exists()) {
    					
    				}
    				else if (first.exists() && second.exists() && third.exists() && fourth.exists() && fifth.exists()) {
    					curr.delete();
    					
    					try {
							Main.copyFileUsingChannel(third, temp);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
      					
      					temp.renameTo(curr);
    					//third.renameTo(curr);
    				}
    			}
    		}
      });
        
        button4.addSelectionListener(new SelectionAdapter()  {	  
    		@Override
    		public void widgetSelected(SelectionEvent e) {
    			Button source=  (Button) e.getSource();
    		
    			if(source.getSelection()){
    				File first = new File(Main.filePath + "/basketball/score_1q.png");
    				File second = new File(Main.filePath + "/basketball/score_2q.png");
    				File third = new File(Main.filePath + "/basketball/score_3q.png");
    				File fourth = new File(Main.filePath + "/basketball/score_4q.png");
    				File fifth = new File(Main.filePath + "/basketball/score_연장.png");
    				File curr = new File(Main.filePath + "/basketball/score_current.png");
    				File temp = new File(Main.filePath + "/basketball/score_temp.png");

    				if(!second.exists()) {
    					curr.renameTo(second);
    					
    					try {
							Main.copyFileUsingChannel(fourth, temp);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
      					
      					temp.renameTo(curr);
    					//fourth.renameTo(curr);
    				}
    				else if(!third.exists()) {
    					curr.renameTo(third);
    					
    					try {
							Main.copyFileUsingChannel(fourth, temp);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
      					
      					temp.renameTo(curr);
    					//fourth.renameTo(curr);
    				}
    				else if(!first.exists()) {
    					curr.renameTo(first);
    					
    					try {
							Main.copyFileUsingChannel(fourth, temp);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
      					
      					temp.renameTo(curr);
    					//fourth.renameTo(curr);
    				}
    				else if(!fifth.exists()) {
    					curr.renameTo(fifth);
    					
    					try {
							Main.copyFileUsingChannel(fourth, temp);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
      					
      					temp.renameTo(curr);
    					//fourth.renameTo(curr);
    				}
    				else if(!fourth.exists()) {
    					
    				}
    				else if (first.exists() && second.exists() && third.exists() && fourth.exists() && fifth.exists()) {
    					curr.delete();
    					
    					try {
							Main.copyFileUsingChannel(fourth, temp);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
      					
      					temp.renameTo(curr);
    					//fourth.renameTo(curr);
    				}
    			}
    		}
      });
        
        button5.addSelectionListener(new SelectionAdapter()  {	  
    		@Override
    		public void widgetSelected(SelectionEvent e) {
    			Button source=  (Button) e.getSource();
    		
    			if(source.getSelection()){
    				File first = new File(Main.filePath + "/basketball/score_1q.png");
    				File second = new File(Main.filePath + "/basketball/score_2q.png");
    				File third = new File(Main.filePath + "/basketball/score_3q.png");
    				File fourth = new File(Main.filePath + "/basketball/score_4q.png");
    				File fifth = new File(Main.filePath + "/basketball/score_연장.png");
    				File curr = new File(Main.filePath + "/basketball/score_current.png");
    				File temp = new File(Main.filePath + "/basketball/score_temp.png");

    				if(!second.exists()) {
    					curr.renameTo(second);
    					
    					try {
							Main.copyFileUsingChannel(fifth, temp);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
      					
      					temp.renameTo(curr);
    					//fifth.renameTo(curr);
    				}
    				else if(!third.exists()) {
    					curr.renameTo(third);
    					
    					try {
							Main.copyFileUsingChannel(fifth, temp);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
      					
      					temp.renameTo(curr);
    					//fifth.renameTo(curr);
    				}
    				else if(!fourth.exists()) {
    					curr.renameTo(fourth);
    					
    					try {
							Main.copyFileUsingChannel(fifth, temp);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
      					
      					temp.renameTo(curr);
    					//fifth.renameTo(curr);
    				}
    				else if(!first.exists()) {
    					curr.renameTo(first);
    					
    					try {
							Main.copyFileUsingChannel(fifth, temp);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
      					
      					temp.renameTo(curr);
    					//fifth.renameTo(curr);
    				}
    				else if(!fifth.exists()) {
    					
    				}
    				else if (first.exists() && second.exists() && third.exists() && fourth.exists() && fifth.exists()) {
    					curr.delete();
    					
    					try {
							Main.copyFileUsingChannel(fifth, temp);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
      					
      					temp.renameTo(curr);
    					//fifth.renameTo(curr);
    				}
    			}
    		}
      });
        
        sashForm.setWeights(new int[]{1,1});
        
		return sashForm;
	}
}
