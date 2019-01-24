package poka_score;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class BaseBall {
	
	public SashForm BaseTab(Composite sports_tab) {

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
        p_down.setText("′");
        p_down.setLayoutData(score_data);
        
        score_data = new GridData(GridData.FILL_BOTH);
        score_data.widthHint = 20;
        Text p_score = new Text(score_comp, SWT.BORDER | SWT.CENTER);
        p_score.setText("0");
        p_score.setLayoutData(score_data);
        
        score_data = new GridData(GridData.FILL_BOTH);
        score_data.widthHint = 5;
        Button p_up = new Button(score_comp, SWT.PUSH);
        p_up.setText("♀");
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
        k_down.setText("′");
        k_down.setLayoutData(score_data);
        
        score_data = new GridData(GridData.FILL_BOTH);
        score_data.widthHint = 20;
        Text k_score = new Text(score_comp, SWT.BORDER | SWT.CENTER);
        k_score.setText("0");
        k_score.setLayoutData(score_data);
        
        score_data = new GridData(GridData.FILL_BOTH);
        score_data.widthHint = 5;
        Button k_up = new Button(score_comp, SWT.PUSH);
        k_up.setText("♀");
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
        timeGroup.setText("版扁 矫埃");
        timeGroup.setLayout(new RowLayout(SWT.HORIZONTAL));
        
        Button i_down = new Button(timeGroup, SWT.PUSH);
        i_down.setText("′");
         
        Text i_text = new Text(timeGroup, SWT.BORDER);
        i_text.setText("1");
        
        Button i_up = new Button(timeGroup, SWT.PUSH);
        i_up.setText("♀");

        Button button4 = new Button(timeGroup, SWT.RADIO);
        button4.setSelection(true);
        button4.setText("檬");
        
        Button button5 = new Button(timeGroup, SWT.RADIO);
        button5.setText("富");
        
        i_down.addSelectionListener(new SelectionAdapter() {	 
     	   @Override
     	   public void widgetSelected(SelectionEvent arg0) {
     		   int i_int = Integer.parseInt(i_text.getText());
     		   if(i_int > 1)
     			   i_int = i_int - 1;
     	       i_text.setText(Integer.toString(i_int));
     	       
     			File[] a = new File[9];
     			a[0] = new File(Main.filePath + "/baseball/inning_1檬.png");
     			a[1] = new File(Main.filePath + "/baseball/inning_2檬.png");
     			a[2] = new File(Main.filePath + "/baseball/inning_3檬.png");
     			a[3] = new File(Main.filePath + "/baseball/inning_4檬.png");
     			a[4] = new File(Main.filePath + "/baseball/inning_5檬.png");
     			a[5] = new File(Main.filePath + "/baseball/inning_6檬.png");
     			a[6] = new File(Main.filePath + "/baseball/inning_7檬.png");
     			a[7] = new File(Main.filePath + "/baseball/inning_8檬.png");
     			a[8] = new File(Main.filePath + "/baseball/inning_9檬.png");
     			
     			File[] b = new File[9];
     			
     			b[0] = new File(Main.filePath + "/baseball/inning_1富.png");
     			b[1] = new File(Main.filePath + "/baseball/inning_2富.png");
     			b[2] = new File(Main.filePath + "/baseball/inning_3富.png");
     			b[3] = new File(Main.filePath + "/baseball/inning_4富.png");
     			b[4] = new File(Main.filePath + "/baseball/inning_5富.png");
     			b[5] = new File(Main.filePath + "/baseball/inning_6富.png");
     			b[6] = new File(Main.filePath + "/baseball/inning_7富.png");
     			b[7] = new File(Main.filePath + "/baseball/inning_8富.png");
     			b[8] = new File(Main.filePath + "/baseball/inning_9富.png");

     			File curr = new File(Main.filePath + "/baseball/inning_current.png");
     			File temp = new File(Main.filePath + "/baseball/inning_temp.png");
     			
     	       
     	       for(int i = 0; i < 9; i++) {
     	    	   if(i_int - 1 == i) {
	   	     	    	if(button4.getSelection()) {
		     	    		curr.renameTo(a[i + 1]);
		     	    		curr.delete();
		     	    		
		     	    		try {
								Main.copyFileUsingChannel(a[i], temp);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
	      					
	      					temp.renameTo(curr);
		     	    		//a[i].renameTo(curr);
		     	    	}
		     	    	else {
		     	    		curr.renameTo(b[i + 1]);
		     	    		curr.delete();
		     	    		
		     	    		try {
								Main.copyFileUsingChannel(b[i], temp);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
	      					
	      					temp.renameTo(curr);
		     	    		//b[i].renameTo(curr);
		     	    	}
     	    	   }
     	       }
     	   }
        });
        
        
        i_up.addSelectionListener(new SelectionAdapter() {	 
     	   @Override
     	   public void widgetSelected(SelectionEvent arg0) {
     		   int i_int = Integer.parseInt(i_text.getText());
     		   if(i_int < 9)
     			   i_int = i_int + 1;
     	       i_text.setText(Integer.toString(i_int));
     	       
     	    File[] a = new File[9];
   			a[0] = new File(Main.filePath + "/baseball/inning_1檬.png");
   			a[1] = new File(Main.filePath + "/baseball/inning_2檬.png");
   			a[2] = new File(Main.filePath + "/baseball/inning_3檬.png");
   			a[3] = new File(Main.filePath + "/baseball/inning_4檬.png");
   			a[4] = new File(Main.filePath + "/baseball/inning_5檬.png");
   			a[5] = new File(Main.filePath + "/baseball/inning_6檬.png");
   			a[6] = new File(Main.filePath + "/baseball/inning_7檬.png");
   			a[7] = new File(Main.filePath + "/baseball/inning_8檬.png");
   			a[8] = new File(Main.filePath + "/baseball/inning_9檬.png");
   			
   			File[] b = new File[9];
   			
   			b[0] = new File(Main.filePath + "/baseball/inning_1富.png");
   			b[1] = new File(Main.filePath + "/baseball/inning_2富.png");
   			b[2] = new File(Main.filePath + "/baseball/inning_3富.png");
   			b[3] = new File(Main.filePath + "/baseball/inning_4富.png");
   			b[4] = new File(Main.filePath + "/baseball/inning_5富.png");
   			b[5] = new File(Main.filePath + "/baseball/inning_6富.png");
   			b[6] = new File(Main.filePath + "/baseball/inning_7富.png");
   			b[7] = new File(Main.filePath + "/baseball/inning_8富.png");
   			b[8] = new File(Main.filePath + "/baseball/inning_9富.png");

   			File curr = new File(Main.filePath + "/baseball/inning_current.png");
   			File temp = new File(Main.filePath + "/baseball/inning_temp.png");
   			
   	       
   	       for(int i = 1; i < 9; i++) {
   	    	   if(i_int - 1 == i) {
	   	     	    	if(button4.getSelection()) {
		     	    		curr.renameTo(a[i - 1]);
		     	    		curr.delete();
		     	    		
		     	    		try {
								Main.copyFileUsingChannel(a[i], temp);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
	      					
	      					temp.renameTo(curr);
		     	    		//a[i].renameTo(curr);
		     	    	}
		     	    	else {
		     	    		curr.renameTo(b[i - 1]);
		     	    		curr.delete();
		     	    		
		     	    		try {
								Main.copyFileUsingChannel(b[i], temp);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
	      					
	      					temp.renameTo(curr);
		     	    		//b[i].renameTo(curr);
		     	    	}
   	    	   }
   	       }
     	   }
        });
        
        button4.addSelectionListener(new SelectionAdapter()  {	  
    		@Override
    		public void widgetSelected(SelectionEvent e) {
    			Button source=  (Button) e.getSource();
    		
    			if(source.getSelection()){
    	     	    File[] a = new File[9];
    	   			a[0] = new File(Main.filePath + "/baseball/inning_1檬.png");
    	   			a[1] = new File(Main.filePath + "/baseball/inning_2檬.png");
    	   			a[2] = new File(Main.filePath + "/baseball/inning_3檬.png");
    	   			a[3] = new File(Main.filePath + "/baseball/inning_4檬.png");
    	   			a[4] = new File(Main.filePath + "/baseball/inning_5檬.png");
    	   			a[5] = new File(Main.filePath + "/baseball/inning_6檬.png");
    	   			a[6] = new File(Main.filePath + "/baseball/inning_7檬.png");
    	   			a[7] = new File(Main.filePath + "/baseball/inning_8檬.png");
    	   			a[8] = new File(Main.filePath + "/baseball/inning_9檬.png");
    	   			
    	   			File[] b = new File[9];
    	   			
    	   			b[0] = new File(Main.filePath + "/baseball/inning_1富.png");
    	   			b[1] = new File(Main.filePath + "/baseball/inning_2富.png");
    	   			b[2] = new File(Main.filePath + "/baseball/inning_3富.png");
    	   			b[3] = new File(Main.filePath + "/baseball/inning_4富.png");
    	   			b[4] = new File(Main.filePath + "/baseball/inning_5富.png");
    	   			b[5] = new File(Main.filePath + "/baseball/inning_6富.png");
    	   			b[6] = new File(Main.filePath + "/baseball/inning_7富.png");
    	   			b[7] = new File(Main.filePath + "/baseball/inning_8富.png");
    	   			b[8] = new File(Main.filePath + "/baseball/inning_9富.png");

    	   			File curr = new File(Main.filePath + "/baseball/inning_current.png");
    	   			File temp = new File(Main.filePath + "/baseball/inning_temp.png");

    	   			int i_int = Integer.parseInt(i_text.getText());
    	    	       for(int i = 1; i < 10; i++) {
    	       	    	   if(i_int - 1 == i) {
    	       	    		   curr.renameTo(b[i]);
    	       	    		   curr.delete();
    	       	    		   
	    	       	    		try {
									Main.copyFileUsingChannel(a[i], temp);
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
		      					
		      					temp.renameTo(curr);
    	       	    		   //a[i].renameTo(curr);
    	       	    	   }
    	       	       }
    			}
    		}
      });
        
        button5.addSelectionListener(new SelectionAdapter()  {	  
    		@Override
    		public void widgetSelected(SelectionEvent e) {
    			Button source=  (Button) e.getSource();
    		
    			if(source.getSelection()){
    	     	    File[] a = new File[9];
    	   			a[0] = new File(Main.filePath + "/baseball/inning_1檬.png");
    	   			a[1] = new File(Main.filePath + "/baseball/inning_2檬.png");
    	   			a[2] = new File(Main.filePath + "/baseball/inning_3檬.png");
    	   			a[3] = new File(Main.filePath + "/baseball/inning_4檬.png");
    	   			a[4] = new File(Main.filePath + "/baseball/inning_5檬.png");
    	   			a[5] = new File(Main.filePath + "/baseball/inning_6檬.png");
    	   			a[6] = new File(Main.filePath + "/baseball/inning_7檬.png");
    	   			a[7] = new File(Main.filePath + "/baseball/inning_8檬.png");
    	   			a[8] = new File(Main.filePath + "/baseball/inning_9檬.png");
    	   			
    	   			File[] b = new File[9];
    	   			
    	   			b[0] = new File(Main.filePath + "/baseball/inning_1富.png");
    	   			b[1] = new File(Main.filePath + "/baseball/inning_2富.png");
    	   			b[2] = new File(Main.filePath + "/baseball/inning_3富.png");
    	   			b[3] = new File(Main.filePath + "/baseball/inning_4富.png");
    	   			b[4] = new File(Main.filePath + "/baseball/inning_5富.png");
    	   			b[5] = new File(Main.filePath + "/baseball/inning_6富.png");
    	   			b[6] = new File(Main.filePath + "/baseball/inning_7富.png");
    	   			b[7] = new File(Main.filePath + "/baseball/inning_8富.png");
    	   			b[8] = new File(Main.filePath + "/baseball/inning_9富.png");

    	   			File curr = new File(Main.filePath + "/baseball/inning_current.png");
    	   			File temp = new File(Main.filePath + "/baseball/inning_temp.png");

    	   			int i_int = Integer.parseInt(i_text.getText());
    	    	       for(int i = 1; i < 10; i++) {
    	       	    	   if(i_int - 1 == i) {
    	       	    		   curr.renameTo(a[i]);
    	       	    		   curr.delete();
    	       	    		   
	    	       	    		try {
									Main.copyFileUsingChannel(b[i], temp);
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
		      					
		      					temp.renameTo(curr);
    	       	    		   //b[i].renameTo(curr);
    	       	    	   }
    	       	       }
    			}
    		}
      });
        
        Composite run_comp = new Composite(extra_comp, SWT.FILL);
        
        GridLayout run_gridLayout = new GridLayout();
        run_gridLayout.numColumns = 2;
        run_comp.setLayout(run_gridLayout);
        
        GridData r_data = new GridData(GridData.FILL_BOTH);
        r_data.horizontalAlignment = GridData.FILL;
		r_data.grabExcessHorizontalSpace = true;
		r_data.horizontalSpan = 2;
		r_data.widthHint = 250;
		r_data.heightHint = 50;
		
        Button button_second = new Button(run_comp, SWT.TOGGLE);
        button_second.setLayoutData(r_data);
        button_second.setText("2风");
        
        r_data = new GridData(GridData.FILL_BOTH);
        r_data.horizontalAlignment = GridData.FILL;
		r_data.grabExcessHorizontalSpace = true;
		r_data.heightHint = 50;
        Button button_third = new Button(run_comp, SWT.TOGGLE);
        button_third.setLayoutData(r_data);
        button_third.setText("3风");
        
        r_data = new GridData(GridData.FILL_BOTH);
        r_data.horizontalAlignment = GridData.FILL;
		r_data.grabExcessHorizontalSpace = true;
		r_data.heightHint = 50;
        Button button_first = new Button(run_comp, SWT.TOGGLE);
        button_first.setLayoutData(r_data);
        button_first.setText("1风");

        SelectionListener first_selectionListener = new SelectionAdapter() {
        	@Override
        		public void widgetSelected(SelectionEvent e) {
        			Button source = (Button) e.getSource();

        			File runner_0 = new File(Main.filePath + "/baseball/score_0.png");
        			File runner_1 = new File(Main.filePath + "/baseball/score_1.png");
        			File runner_2 =  new File(Main.filePath + "/baseball/score_2.png");
        			File runner_3 = new File(Main.filePath + "/baseball/score_3.png");
        			File runner_12 = new File(Main.filePath + "/baseball/score_12.png");
        			File runner_13 = new File(Main.filePath + "/baseball/score_13.png");
        			File runner_23 = new File(Main.filePath + "/baseball/score_23.png");
        			File runner_123 = new File(Main.filePath + "/baseball/score_123.png");

        			File curr = new File(Main.filePath + "/baseball/score_current.png");
        			File temp = new File(Main.filePath + "/baseball/score_temp.png");

        			if (source.getSelection()) {
        				if(!button_second.getSelection() && !button_third.getSelection()){
        					curr.renameTo(runner_0);
        					curr.delete();
        					
        					try {
								Main.copyFileUsingChannel(runner_1, temp);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
	      					
	      					temp.renameTo(curr);
        					//runner_1.renameTo(curr);
        				}
        				else if(button_second.getSelection() && !button_third.getSelection()){
        					curr.renameTo(runner_2);
        					curr.delete();
        					
        					try {
								Main.copyFileUsingChannel(runner_12, temp);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
	      					
        					temp.renameTo(curr);
        					//runner_12.renameTo(curr);
        				}
        				else if(!button_second.getSelection() && button_third.getSelection()){
        					curr.renameTo(runner_3);
        					
        					try {
								Main.copyFileUsingChannel(runner_13, temp);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
	      					
        					temp.renameTo(curr);
        					curr.delete();
        					//runner_13.renameTo(curr);
        				}
        				else{
        					curr.renameTo(runner_23);
        					curr.delete();
        					
        					try {
								Main.copyFileUsingChannel(runner_123, temp);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
	      					
        					temp.renameTo(curr);
        					//runner_123.renameTo(curr);
        				}
        			} else {
        				if(!button_second.getSelection() && !button_third.getSelection()){
        					curr.renameTo(runner_1);
        					curr.delete();
        					
        					try {
								Main.copyFileUsingChannel(runner_0, temp);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
	      					
	      					temp.renameTo(curr);
        					//runner_0.renameTo(curr);
        				}
        				else if(button_second.getSelection() && !button_third.getSelection()){
        					curr.renameTo(runner_12);
        					curr.delete();
        					
        					try {
								Main.copyFileUsingChannel(runner_2, temp);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
	      					
	      					temp.renameTo(curr);
        					//runner_2.renameTo(curr);
        				}
        				else if(!button_second.getSelection() && button_third.getSelection()){
        					curr.renameTo(runner_13);
        					curr.delete();
        					
        					try {
								Main.copyFileUsingChannel(runner_3, temp);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
	      					
	      					temp.renameTo(curr);
        					//runner_3.renameTo(curr);
        				}
        				else{
        					curr.renameTo(runner_123);
        					curr.delete();
        					
        					try {
								Main.copyFileUsingChannel(runner_23, temp);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
	      					
	      					temp.renameTo(curr);
        					//runner_23.renameTo(curr);
        				}
        			}

        	}
        };

        SelectionListener second_selectionListener = new SelectionAdapter() {
        	@Override
        		public void widgetSelected(SelectionEvent e) {
        			Button source = (Button) e.getSource();

        			File runner_0 = new File(Main.filePath + "/baseball/score_0.png");
        			File runner_1 = new File(Main.filePath + "/baseball/score_1.png");
        			File runner_2 =  new File(Main.filePath + "/baseball/score_2.png");
        			File runner_3 = new File(Main.filePath + "/baseball/score_3.png");
        			File runner_12 = new File(Main.filePath + "/baseball/score_12.png");
        			File runner_13 = new File(Main.filePath + "/baseball/score_13.png");
        			File runner_23 = new File(Main.filePath + "/baseball/score_23.png");
        			File runner_123 = new File(Main.filePath + "/baseball/score_123.png");

        			File curr = new File(Main.filePath + "/baseball/score_current.png");
        			File temp = new File(Main.filePath + "/baseball/score_temp.png");
        			
        			if (source.getSelection()) {
        				if(!button_first.getSelection() && !button_third.getSelection()){
        					curr.renameTo(runner_0);
        					curr.delete();
        					
        					try {
								Main.copyFileUsingChannel(runner_2, temp);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
	      					
	      					temp.renameTo(curr);
        					//runner_2.renameTo(curr);
        				}
        				else if(button_first.getSelection() && !button_third.getSelection()){
        					curr.renameTo(runner_1);
        					curr.delete();
        					
        					try {
								Main.copyFileUsingChannel(runner_12, temp);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
	      					
	      					temp.renameTo(curr);
        					//runner_12.renameTo(curr);
        				}
        				else if(!button_first.getSelection() && button_third.getSelection()){
        					curr.renameTo(runner_3);
        					curr.delete();
        					
        					try {
								Main.copyFileUsingChannel(runner_23, temp);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
	      					
	      					temp.renameTo(curr);
        					//runner_23.renameTo(curr);
        				}
        				else{
        					curr.renameTo(runner_13);
        					curr.delete();
        					
        					try {
								Main.copyFileUsingChannel(runner_123, temp);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
	      					
	      					temp.renameTo(curr);
        					//runner_123.renameTo(curr);
        				}
        			} else {
        				if(!button_first.getSelection() && !button_third.getSelection()){
        					curr.renameTo(runner_2);
        					curr.delete();
        					
        					try {
								Main.copyFileUsingChannel(runner_0, temp);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
	      					
	      					temp.renameTo(curr);
        					//runner_0.renameTo(curr);
        				}
        				else if(button_first.getSelection() && !button_third.getSelection()){
        					curr.renameTo(runner_12);
        					curr.delete();
        					
        					try {
								Main.copyFileUsingChannel(runner_1, temp);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
	      					
	      					temp.renameTo(curr);
        					//runner_1.renameTo(curr);
        				}
        				else if(!button_first.getSelection() && button_third.getSelection()){
        					curr.renameTo(runner_23);
        					curr.delete();
        					
        					try {
								Main.copyFileUsingChannel(runner_3, temp);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
	      					
	      					temp.renameTo(curr);
        					//runner_3.renameTo(curr);
        				}
        				else{
        					curr.renameTo(runner_123);
        					curr.delete();
        					
        					try {
								Main.copyFileUsingChannel(runner_13, temp);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
	      					
	      					temp.renameTo(curr);
        					//runner_13.renameTo(curr);
        				}
        			}

        	}
        };

        SelectionListener third_selectionListener = new SelectionAdapter() {
        	@Override
        		public void widgetSelected(SelectionEvent e) {
        			Button source = (Button) e.getSource();

        			File runner_0 = new File(Main.filePath + "/baseball/score_0.png");
        			File runner_1 = new File(Main.filePath + "/baseball/score_1.png");
        			File runner_2 =  new File(Main.filePath + "/baseball/score_2.png");
        			File runner_3 = new File(Main.filePath + "/baseball/score_3.png");
        			File runner_12 = new File(Main.filePath + "/baseball/score_12.png");
        			File runner_13 = new File(Main.filePath + "/baseball/score_13.png");
        			File runner_23 = new File(Main.filePath + "/baseball/score_23.png");
        			File runner_123 = new File(Main.filePath + "/baseball/score_123.png");

        			File curr = new File(Main.filePath + "/baseball/score_current.png");
        			File temp = new File(Main.filePath + "/baseball/score_temp.png");

        			if (source.getSelection()) {
        				if(!button_first.getSelection() && !button_second.getSelection()){
        					curr.renameTo(runner_0);
        					curr.delete();
        					
        					try {
								Main.copyFileUsingChannel(runner_3, temp);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
	      					
	      					temp.renameTo(curr);
        					//runner_3.renameTo(curr);
        				}
        				else if(button_first.getSelection() && !button_second.getSelection()){
        					curr.renameTo(runner_1);
        					curr.delete();
        					
        					try {
								Main.copyFileUsingChannel(runner_13, temp);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
	      					
	      					temp.renameTo(curr);
        					//runner_13.renameTo(curr);
        				}
        				else if(!button_first.getSelection() && button_second.getSelection()){
        					curr.renameTo(runner_2);
        					curr.delete();
        					
        					try {
								Main.copyFileUsingChannel(runner_23, temp);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
	      					
	      					temp.renameTo(curr);
        					//runner_23.renameTo(curr);
        				}
        				else{
        					curr.renameTo(runner_12);
        					curr.delete();
        					
        					try {
								Main.copyFileUsingChannel(runner_123, temp);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
	      					
	      					temp.renameTo(curr);
        					//runner_123.renameTo(curr);
        				}
        			} else {
        				if(!button_first.getSelection() && !button_second.getSelection()){
        					curr.renameTo(runner_3);
        					curr.delete();
        					
        					try {
								Main.copyFileUsingChannel(runner_0, temp);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
	      					
	      					temp.renameTo(curr);
        					//runner_0.renameTo(curr);
        				}
        				else if(button_first.getSelection() && !button_second.getSelection()){
        					curr.renameTo(runner_13);
        					curr.delete();
        					
        					try {
								Main.copyFileUsingChannel(runner_1, temp);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
	      					
	      					temp.renameTo(curr);
        					//runner_1.renameTo(curr);
        				}
        				else if(!button_first.getSelection() && button_second.getSelection()){
        					curr.renameTo(runner_23);
        					curr.delete();
        					
        					try {
								Main.copyFileUsingChannel(runner_2, temp);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
	      					
	      					temp.renameTo(curr);
        					//runner_2.renameTo(curr);
        				}
        				else{
        					curr.renameTo(runner_123);
        					curr.delete();
        					
        					try {
								Main.copyFileUsingChannel(runner_12, temp);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
	      					
	      					temp.renameTo(curr);
        					//runner_12.renameTo(curr);
        				}
        			}

        	}
        };

        button_first.addSelectionListener(first_selectionListener);
        button_second.addSelectionListener(second_selectionListener);
        button_third.addSelectionListener(third_selectionListener);
        
        sashForm.setWeights(new int[]{1,1});
        
		return sashForm;
	}
}
