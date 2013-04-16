import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;


import com.cloudgarden.resource.SWTResourceManager;

public class Settings extends org.eclipse.swt.widgets.Composite {
	private CTabFolder cTabFolder1;
	private CTabItem cTabItem1;
	private Button button4;
	private Button button6;
	private Button button8;
	private Button button13;
	private Label label2;
	private Button button12;
	private Button button11;
	private Label label1;
	private Composite composite3;
	private Composite composite2;
	private Button button10;
	private Button button9;
	private Button button7;
	private Button button5;
	private Button button3;
	private Composite composite1;
	private Canvas canvas1;
	private Button button20;
	private Button button22;
	private Label label5;
	private Text text1;
	private Button button21;
	private Label label4;
	private Label label3;
	private Button button19;
	private Button button18;
	private Button button17;
	private Button button16;
	private Button button15;
	private Button button14;
	private Button button2;
	private Button button1;
	private CTabItem cTabItem4;
	private CTabItem cTabItem3;
	private CTabItem cTabItem2;

	{
		//Register as a resource user - SWTResourceManager will
		//handle the obtaining and disposing of resources
		SWTResourceManager.registerResourceUser(this);
	}

	public Settings(Composite parent, int style) {
		super(parent, style);
		initGUI();
	}
	
	/**
	* Initializes the GUI.
	*/
	private void initGUI() {
		try {
			this.setSize(446, 400);
			this.setBackground(SWTResourceManager.getColor(192, 192, 192));
			this.setLayout(null);
			{
				cTabFolder1 = new CTabFolder(this, SWT.NONE);
				{
					cTabItem1 = new CTabItem(cTabFolder1, SWT.NONE);
					cTabItem1.setText("Difficulty");
					{
						composite1 = new Composite(cTabFolder1, SWT.NONE);
						composite1.setLayout(null);
						cTabItem1.setControl(composite1);
						{
							button1 = new Button(composite1, SWT.RADIO | SWT.LEFT);
							button1.setText("Easy");
							button1.setBounds(26, 75, 60, 30);
						}
						{
							button2 = new Button(composite1, SWT.RADIO | SWT.LEFT);
							button2.setText("Medium");
							button2.setBounds(26, 111, 60, 30);
						}
						{
							button3 = new Button(composite1, SWT.RADIO | SWT.LEFT);
							button3.setText("Hard");
							button3.setBounds(26, 147, 60, 30);
						}
						{
							button4 = new Button(composite1, SWT.RADIO | SWT.LEFT);
							button4.setText("Wizard");
							button4.setBounds(26, 231, 60, 30);
						}
						{
							button5 = new Button(composite1, SWT.RADIO | SWT.LEFT);
							button5.setText("Expert");
							button5.setBounds(26, 189, 60, 30);
						}
						{
							button13 = new Button(composite1, SWT.PUSH | SWT.CENTER);
							button13.setText("Ok");
							button13.setBounds(31, 319, 60, 30);
						}
						{
							button14 = new Button(composite1, SWT.PUSH | SWT.CENTER);
							button14.setText("Cancel");
							button14.setBounds(119, 319, 60, 30);
						}
						{
							label3 = new Label(composite1, SWT.NONE);
							label3.setText("Choose The Difficulty Level");
							label3.setBounds(26, 27, 151, 30);
						}

					}
				}
				{
					cTabItem3 = new CTabItem(cTabFolder1, SWT.NONE);
					cTabItem3.setText("Updates");
					{
						composite2 = new Composite(cTabFolder1, SWT.NONE);
						composite2.setLayout(null);
						cTabItem3.setControl(composite2);
						{
							button11 = new Button(composite2, SWT.CHECK | SWT.LEFT);
							button11.setText("Autumatic Update");
							button11.setBounds(27, 53, 121, 30);
						}
						{
							label2 = new Label(composite2, SWT.NONE);
							label2.setText("Settings for updating software");
							label2.setBounds(27, 27, 168, 30);
						}
						{
							button17 = new Button(composite2, SWT.PUSH | SWT.CENTER);
							button17.setText("OK");
							button17.setBounds(31, 319, 60, 30);
						}
						{
							button18 = new Button(composite2, SWT.PUSH | SWT.CENTER);
							button18.setText("Cancel");
							button18.setBounds(119, 319, 60, 30);
						}
						{
							text1 = new Text(composite2, SWT.MULTI | SWT.WRAP);
							text1.setText("D:/workspace/Final_project/Updates");
							text1.setBounds(27, 131, 241, 19);
						}
						{
							label5 = new Label(composite2, SWT.NONE);
							label5.setText("Choose the Download destination");
							label5.setBounds(27, 105, 201, 20);
						}
						{
							button22 = new Button(composite2, SWT.PUSH | SWT.CENTER);
							button22.setText("Save");
							button22.setBounds(280, 129, 60, 25);
						}
					}
				}
				{
					cTabItem2 = new CTabItem(cTabFolder1, SWT.NONE);
					cTabItem2.setText("Language");
					{
						canvas1 = new Canvas(cTabFolder1, SWT.NONE);
						cTabItem2.setControl(canvas1);
						canvas1.setLayout(null);
						{
							button6 = new Button(canvas1, SWT.RADIO | SWT.LEFT);
							button6.setText("English");
							button6.setBounds(31, 64, 60, 30);
						}
						{
							button7 = new Button(canvas1, SWT.RADIO | SWT.LEFT);
							button7.setText("Espanol");
							button7.setBounds(31, 148, 68, 30);
						}
						{
							button8 = new Button(canvas1, SWT.RADIO | SWT.LEFT);
							button8.setText("Francais");
							button8.setBounds(31, 194, 68, 30);
						}
						{
							button9 = new Button(canvas1, SWT.RADIO | SWT.LEFT);
							button9.setText("Italiano");
							button9.setBounds(31, 244, 60, 30);
						}
						{
							button10 = new Button(canvas1, SWT.RADIO | SWT.LEFT);
							button10.setText("Deutsch");
							button10.setBounds(31, 106, 68, 30);
						}
						{
							label1 = new Label(canvas1, SWT.NONE);
							label1.setText("Please select the perferred Language");
							label1.setBounds(31, 28, 226, 30);
						}
						{
							button15 = new Button(canvas1, SWT.PUSH | SWT.CENTER);
							button15.setText("OK");
							OKButtonHandler searchHandler = new OKButtonHandler();
						
							button15.setBounds(31, 319, 60, 30);
							
						
						}
						{
							button16 = new Button(canvas1, SWT.PUSH | SWT.CENTER);
							button16.setText("Cancel");
							button16.setBounds(119, 319, 60, 30);
						}
					}
					
				}
				{
					cTabItem4 = new CTabItem(cTabFolder1, SWT.NONE);
					cTabItem4.setText("Other");
					{
						composite3 = new Composite(cTabFolder1, SWT.NONE);
						composite3.setLayout(null);
						cTabItem4.setControl(composite3);
						{
							button12 = new Button(composite3, SWT.CHECK | SWT.LEFT);
							button12.setText("Show Hints");
							button12.setBounds(32, 69, 95, 30);
						}
						{
							button19 = new Button(composite3, SWT.PUSH | SWT.CENTER);
							button19.setText("OK");
							button19.setBounds(31, 319, 60, 30);
						}
						{
							button20 = new Button(composite3, SWT.PUSH | SWT.CENTER);
							button20.setText("Cancel");
							button20.setBounds(119, 319, 60, 30);
						}
						{
							label4 = new Label(composite3, SWT.NONE);
							label4.setText("Other Settings");
							label4.setBounds(32, 27, 97, 30);
						}
						{
							button21 = new Button(composite3, SWT.CHECK | SWT.LEFT);
							button21.setText("Show Timer");
							button21.setBounds(32, 119, 85, 30);
						}
					}
				}
				cTabFolder1.setSelection(0);
				cTabFolder1.setBounds(0, 0, 446, 440);
			}
			this.layout();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private class OKButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
		}
	}
	}