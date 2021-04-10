package minitennis;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Racquet
{

    private static final int Y = 330;
    private static final int WITH = 60;
    private static final int HEIGHT = 10;
    int x = 0;
    int xa = 0;
    private MiniTennis miniTennis;

    public Racquet(MiniTennis miniTennis)
    {
        this.miniTennis = miniTennis;
    }

    public void move()
    {
        if (x + xa > 0 && x + xa < miniTennis.getWidth() - WITH) {
            x = x + xa;
        }
    }

    public void paint(Graphics2D g)
    {
        g.fillRect(x, Y, WITH, HEIGHT);
    }

    public void keyReleased(KeyEvent e)
    {
        xa = 0;
    }

    public void keyPressed(KeyEvent e)
    {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            xa = -miniTennis.speed;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            xa = miniTennis.speed;
        }
    }

    public Rectangle getBounds()
    {
        return new Rectangle(x, Y, WITH, HEIGHT);
    }

    public int getTopY()
    {
        return Y - HEIGHT;
    }
}
