import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Graph_maker extends JPanel {
private static final long serialVersionUID = 1L;


int x[]={61,180,240,400,460};
int y[]=Graph_helper.ExportPoints();
int x_size = 15;
int y_size = 14;
public void paintComponent(Graphics g){
	
		for(int j=0; j<x.length-1; j++){
			g.drawLine(x[j], y[j], x[j+1], y[j+1]);
			}
		
	String Xvals[]=new String[x_size];
	for(int i=0; i<x_size; i++){
		Xvals[i]=Integer.toString((i)*10);		
	}
	
	String Yvals[]=new String[y_size];
	int k=y_size-1;
	for(int i=0; i<y_size; i++){
		Yvals[i]=Integer.toString((k--)*10);		
	}
	
			Font font=new Font("Arial",10,10);
			g.setFont(font);
	for(int i=0;i<Xvals.length;i++){
		g.drawString(Xvals[i],60+i*30, 520);
	}
	
	for(int j=0;j<Yvals.length;j++){
		
		g.drawString(Yvals[j],40, 110+j*30);
	//g.translate(j, j);
	}
   
  
}



}
