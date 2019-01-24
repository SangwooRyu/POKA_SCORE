package poka_score;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.channels.FileChannel;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.*;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;


public class Main {
	static String filePath;
	
	public static void main(String[] args){
		Display display = new Display();
		Shell shell = new Shell(display);
		
		shell.setText("POKA SCORE - by.Sangwoo Ryu");
		
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 1;
		shell.setLayout(gridLayout);
		
		//Location Group
		GridData data = new GridData(GridData.FILL_BOTH);
		data.heightHint =70;
	    data.widthHint = 600;
		Group group = new Group(shell, SWT.TOP | SWT.FILL);
		group.setText("Location");
	    group.setLayoutData(data);

	    GridLayout group_gridLayout = new GridLayout();
	    group_gridLayout.numColumns = 3;
	    group_gridLayout.makeColumnsEqualWidth = false;
		group.setLayout(group_gridLayout);
		
		GridData group_data = new GridData(GridData.FILL_BOTH);
		Label fLabel = new Label(group, SWT.CENTER);
		fLabel.setText("폴더");
		fLabel.setLayoutData(group_data);
		
		group_data = new GridData(GridData.FILL_BOTH);
		group_data.widthHint = 450;
		Text fText = new Text(group, SWT.SINGLE | SWT.BORDER);
		fText.setLayoutData(group_data);
		
		group_data = new GridData(GridData.FILL_BOTH);
		Button fButton = new Button(group, SWT.PUSH);
		fButton.setText("...");
		fButton.setLayoutData(group_data);
		
		fButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
                DirectoryDialog dialog = new DirectoryDialog(shell, SWT.NULL);
                
                String path = dialog.open();
                
                if (path != null) {
                    fText.setText(path);
                    
                    String filePath_before = fText.getText();
            		String filePath_refined = "";
            		
            		for(int i = 0; i < filePath_before.length(); i++) {
            			if(filePath_before.charAt(i) == '\\')
            				filePath_refined += '/';
            			else
            				filePath_refined += filePath_before.charAt(i);
            		}
            		
            		filePath = filePath_refined;
                }
            }
		});
		

		group_data = new GridData();
		group_data.horizontalAlignment = GridData.FILL;
		group_data.grabExcessHorizontalSpace = true;
		group_data.horizontalSpan = 2;
		group_data.heightHint = 30;
		Button fileButton = new Button(group, SWT.PUSH);
		fileButton.setText("Select Folder");
		fileButton.setLayoutData(group_data);
		
		fileButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				PrintWriter p_pw = null;
				PrintWriter k_pw = null;
				try {
					p_pw = new PrintWriter(filePath + "/postech_score.txt");
					k_pw = new PrintWriter(filePath + "/kaist_score.txt");
					
					p_pw.print("0");
					k_pw.print("0");
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				p_pw.close();
				k_pw.close();
				
				MessageBox messageBox = new MessageBox(shell, SWT.ICON_INFORMATION | SWT.CLOSE);
				
		        messageBox.setText("Infomation");
		        messageBox.setMessage("Selected!");
		        
		        int buttonID = messageBox.open();
            }
		});
		
		group_data = new GridData();
		group_data.horizontalAlignment = GridData.FILL;
		group_data.grabExcessHorizontalSpace = true;
		group_data.horizontalSpan = 1;
		group_data.heightHint = 30;
		Button initialize = new Button(group, SWT.PUSH);
		initialize.setText("Initialize");
		initialize.setLayoutData(group_data);
		
		initialize.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				initializeFiles(filePath);
				
				MessageBox messageBox = new MessageBox(shell, SWT.ICON_INFORMATION | SWT.CLOSE);
				
		        messageBox.setText("Infomation");
		        messageBox.setMessage("Initialized!");
		        
		        int buttonID = messageBox.open();
            }
		});
		
		
	    //Sports Tab
	    data = new GridData();
	    data.horizontalAlignment = GridData.FILL;
	    data.heightHint = 200;
	    data.widthHint = 600;
	
        CTabFolder sports_tab = new CTabFolder(shell, SWT.TOP);

        CTabItem cTabItem1 = new CTabItem(sports_tab, SWT.NONE);
        cTabItem1.setText("축구");
        CTabItem cTabItem2 = new CTabItem(sports_tab, SWT.NONE);
        cTabItem2.setText("야구");
        CTabItem cTabItem3 = new CTabItem(sports_tab, SWT.NONE);
        cTabItem3.setText("농구");
        CTabItem cTabItem4 = new CTabItem(sports_tab, SWT.NONE);
        cTabItem4.setText("E-Sports");
        
        Soccer soccerTab = new Soccer();
        SashForm soccerSash = soccerTab.SoccerTab(sports_tab);
        cTabItem1.setControl(soccerSash);
        
        BaseBall baseTab = new BaseBall();
        SashForm baseSash = baseTab.BaseTab(sports_tab);
        cTabItem2.setControl(baseSash);
        
        BasketBall basketTab = new BasketBall();
        SashForm basketSash = basketTab.BasketTab(sports_tab);
        cTabItem3.setControl(basketSash);
        
        ESports eTab = new ESports();
        SashForm eSash = eTab.ESportsTab(sports_tab);
        cTabItem4.setControl(eSash);
  
        sports_tab.setLayoutData(data);
        sports_tab.setSelectionForeground(display.getSystemColor(SWT.COLOR_RED));
        
        Label copyRight = new Label(shell, SWT.TOP);
        data = new GridData(GridData.HORIZONTAL_ALIGN_END);
        copyRight.setLayoutData(data);
        copyRight.setText("CopyRight. 2018 POSTECH Broadcasting System. 16 CSE Sangwoo Ryu");

        shell.pack();
        shell.open();
        
		while (!shell.isDisposed()) {
		    if (!display.readAndDispatch())
		     {
		        display.sleep();
		     }
		}

		// disposes all associated windows and their components
		display.dispose();
	}
	
	public static void initializeFiles(String currPath) {
		//soccer initialize
		File old_soccer_1 = new File(currPath + "/soccer/score_전반.png");
		File old_soccer_2 = new File(currPath + "/soccer/score_후반.png");
		File old_soccer_3 = new File(currPath + "/soccer/score_연장.png");		
		File old_soccer_curr = new File(currPath + "/soccer/score_current.png");
		
		old_soccer_1.delete();
		old_soccer_2.delete();
		old_soccer_3.delete();
		old_soccer_curr.delete();
		
		File new_soccer_curr = new File(currPath + "/soccer/initial/score_current.png");
		File new_soccer_2 = new File(currPath + "/soccer/initial/score_후반.png");
		File new_soccer_3 = new File(currPath + "/soccer/initial/score_연장.png");
		
		try {
			copyFileUsingChannel(new_soccer_curr, old_soccer_curr);
			copyFileUsingChannel(new_soccer_2, old_soccer_2);
			copyFileUsingChannel(new_soccer_3, old_soccer_3);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//basketball initialize
		File old_basketball_1 = new File(currPath + "/basketball/score_1q.png");
		File old_basketball_2 = new File(currPath + "/basketball/score_2q.png");
		File old_basketball_3 = new File(currPath + "/basketball/score_3q.png");
		File old_basketball_4 = new File(currPath + "/basketball/score_4q.png");
		File old_basketball_5 = new File(currPath + "/basketball/score_연장.png");
		File old_basketball_curr = new File(currPath + "/basketball/score_current.png");
		
		old_basketball_1.delete();
		old_basketball_2.delete();
		old_basketball_3.delete();
		old_basketball_4.delete();
		old_basketball_5.delete();
		old_basketball_curr.delete();
		
		File new_basketball_curr = new File(currPath + "/basketball/initial/score_current.png");
		File new_basketball_2 = new File(currPath + "/basketball/initial/score_2q.png");
		File new_basketball_3 = new File(currPath + "/basketball/initial/score_3q.png");
		File new_basketball_4 = new File(currPath + "/basketball/initial/score_4q.png");
		File new_basketball_5 = new File(currPath + "/basketball/initial/score_연장.png");
		
		try {
			copyFileUsingChannel(new_basketball_curr, old_basketball_curr);
			copyFileUsingChannel(new_basketball_2, old_basketball_2);
			copyFileUsingChannel(new_basketball_3, old_basketball_3);
			copyFileUsingChannel(new_basketball_4, old_basketball_4);
			copyFileUsingChannel(new_basketball_5, old_basketball_5);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//baseball initialize
		File[] a = new File[9];
		a[0] = new File(Main.filePath + "/baseball/inning_1초.png");
		a[1] = new File(Main.filePath + "/baseball/inning_2초.png");
		a[2] = new File(Main.filePath + "/baseball/inning_3초.png");
		a[3] = new File(Main.filePath + "/baseball/inning_4초.png");
		a[4] = new File(Main.filePath + "/baseball/inning_5초.png");
		a[5] = new File(Main.filePath + "/baseball/inning_6초.png");
		a[6] = new File(Main.filePath + "/baseball/inning_7초.png");
		a[7] = new File(Main.filePath + "/baseball/inning_8초.png");
		a[8] = new File(Main.filePath + "/baseball/inning_9초.png");
		
		File[] b = new File[9];
		
		b[0] = new File(Main.filePath + "/baseball/inning_1말.png");
		b[1] = new File(Main.filePath + "/baseball/inning_2말.png");
		b[2] = new File(Main.filePath + "/baseball/inning_3말.png");
		b[3] = new File(Main.filePath + "/baseball/inning_4말.png");
		b[4] = new File(Main.filePath + "/baseball/inning_5말.png");
		b[5] = new File(Main.filePath + "/baseball/inning_6말.png");
		b[6] = new File(Main.filePath + "/baseball/inning_7말.png");
		b[7] = new File(Main.filePath + "/baseball/inning_8말.png");
		b[8] = new File(Main.filePath + "/baseball/inning_9말.png");
		
		File old_inning_curr = new File(Main.filePath + "/baseball/inning_current.png");
		
		for(int i = 0; i < 9; i++) {
			a[i].delete();
			b[i].delete();
		}
		old_inning_curr.delete();
		
		File[] new_a = new File[9];
		new_a[0] = new File(Main.filePath + "/baseball/initial/inning_1초.png");
		new_a[1] = new File(Main.filePath + "/baseball/initial/inning_2초.png");
		new_a[2] = new File(Main.filePath + "/baseball/initial/inning_3초.png");
		new_a[3] = new File(Main.filePath + "/baseball/initial/inning_4초.png");
		new_a[4] = new File(Main.filePath + "/baseball/initial/inning_5초.png");
		new_a[5] = new File(Main.filePath + "/baseball/initial/inning_6초.png");
		new_a[6] = new File(Main.filePath + "/baseball/initial/inning_7초.png");
		new_a[7] = new File(Main.filePath + "/baseball/initial/inning_8초.png");
		new_a[8] = new File(Main.filePath + "/baseball/initial/inning_9초.png");
		
		File[] new_b = new File[9];
		
		new_b[0] = new File(Main.filePath + "/baseball/initial/inning_1말.png");
		new_b[1] = new File(Main.filePath + "/baseball/initial/inning_2말.png");
		new_b[2] = new File(Main.filePath + "/baseball/initial/inning_3말.png");
		new_b[3] = new File(Main.filePath + "/baseball/initial/inning_4말.png");
		new_b[4] = new File(Main.filePath + "/baseball/initial/inning_5말.png");
		new_b[5] = new File(Main.filePath + "/baseball/initial/inning_6말.png");
		new_b[6] = new File(Main.filePath + "/baseball/initial/inning_7말.png");
		new_b[7] = new File(Main.filePath + "/baseball/initial/inning_8말.png");
		new_b[8] = new File(Main.filePath + "/baseball/initial/inning_9말.png");
		
		File new_inning_curr = new File(Main.filePath + "/baseball/initial/inning_current.png");
		
		try {
			copyFileUsingChannel(new_inning_curr, old_inning_curr);
			for(int i = 0; i < 9; i++) {
				if (i > 0)
					copyFileUsingChannel(new_a[i], a[i]);
				copyFileUsingChannel(new_b[i], b[i]);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		File runner_0 = new File(Main.filePath + "/baseball/score_0.png");
		File runner_1 = new File(Main.filePath + "/baseball/score_1.png");
		File runner_2 =  new File(Main.filePath + "/baseball/score_2.png");
		File runner_3 = new File(Main.filePath + "/baseball/score_3.png");
		File runner_12 = new File(Main.filePath + "/baseball/score_12.png");
		File runner_13 = new File(Main.filePath + "/baseball/score_13.png");
		File runner_23 = new File(Main.filePath + "/baseball/score_23.png");
		File runner_123 = new File(Main.filePath + "/baseball/score_123.png");
		File old_baseball_curr = new File(Main.filePath + "/baseball/score_current.png");
		
		runner_0.delete();
		runner_1.delete();
		runner_2.delete();
		runner_3.delete();
		runner_12.delete();
		runner_13.delete();
		runner_23.delete();
		runner_123.delete();
		old_baseball_curr.delete();
	
		File new_runner_1 = new File(Main.filePath + "/baseball/initial/score_1.png");
		File new_runner_2 =  new File(Main.filePath + "/baseball/initial/score_2.png");
		File new_runner_3 = new File(Main.filePath + "/baseball/initial/score_3.png");
		File new_runner_12 = new File(Main.filePath + "/baseball/initial/score_12.png");
		File new_runner_13 = new File(Main.filePath + "/baseball/initial/score_13.png");
		File new_runner_23 = new File(Main.filePath + "/baseball/initial/score_23.png");
		File new_runner_123 = new File(Main.filePath + "/baseball/initial/score_123.png");
		File new_baseball_curr = new File(Main.filePath + "/baseball/initial/score_current.png");
		
		try {
			copyFileUsingChannel(new_baseball_curr, old_baseball_curr);
			copyFileUsingChannel(new_runner_1, runner_1);
			copyFileUsingChannel(new_runner_2, runner_2);
			copyFileUsingChannel(new_runner_3, runner_3);
			copyFileUsingChannel(new_runner_12, runner_12);
			copyFileUsingChannel(new_runner_13, runner_13);
			copyFileUsingChannel(new_runner_23, runner_23);
			copyFileUsingChannel(new_runner_123, runner_123);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@SuppressWarnings({ "resource" })
	static void copyFileUsingChannel(File source, File dest) throws IOException {
		if(!source.exists())
			return;
		
	    FileChannel sourceChannel = null;
	    FileChannel destChannel = null;
	    try {
	        sourceChannel = new FileInputStream(source).getChannel();
	        destChannel = new FileOutputStream(dest).getChannel();
	        destChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
	       }finally{
    		   sourceChannel.close();
    		   destChannel.close();
	   }
	}
}
