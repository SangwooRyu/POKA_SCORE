package poka_score;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class ESports {
	
	public SashForm ESportsTab(Composite sports_tab) {
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
        p_down.setText("¡ä");
        p_down.setLayoutData(score_data);
        
        score_data = new GridData(GridData.FILL_BOTH);
        score_data.widthHint = 20;
        Text p_score = new Text(score_comp, SWT.BORDER | SWT.CENTER);
        p_score.setText("0");
        p_score.setLayoutData(score_data);
        
        score_data = new GridData(GridData.FILL_BOTH);
        score_data.widthHint = 5;
        Button p_up = new Button(score_comp, SWT.PUSH);
        p_up.setText("¡â");
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
        k_down.setText("¡ä");
        k_down.setLayoutData(score_data);
        
        score_data = new GridData(GridData.FILL_BOTH);
        score_data.widthHint = 20;
        Text k_score = new Text(score_comp, SWT.BORDER | SWT.CENTER);
        k_score.setText("0");
        k_score.setLayoutData(score_data);
        
        score_data = new GridData(GridData.FILL_BOTH);
        score_data.widthHint = 5;
        Button k_up = new Button(score_comp, SWT.PUSH);
        k_up.setText("¡â");
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
        
        sashForm.setWeights(new int[]{1,1});
        
		return sashForm;
	}
}
