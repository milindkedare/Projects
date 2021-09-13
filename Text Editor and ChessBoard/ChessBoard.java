import java.awt.*;
import java.applet.*;
public class Chessboard extends Applet
{
	int x,y,dx,dy;
	public void paint(Graphics g)
	{
		x=1;
		y=1;
		dx=100;
		dy=100;
		for(int i=1;i<=8;i++)
		{
			for(int j=1;j<=8;j++)
			{
				if(i%2==1)
				{
					if(j%2==0)
					{
						g.setColor(Color.WHITE);
					}
					else
					{
						g.setColor(Color.BLACK);
					}
				}
				else
				{
					if(j%2==0)
					{
						g.setColor(Color.BLACK);
					}
					else
					{
						g.setColor(Color.WHITE);
					}
				}
				g.fillRect(x,y,dx,dy);
				x=x+dx;
			}
			y=y+dy;
			x=1;
		}
	}
}
/*<applet code=Chessboard.class width=500 height=500>
</applet>*/

