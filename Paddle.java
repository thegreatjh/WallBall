package wallball;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Paddle
{

    private static final int Y = 330;
    private static final int WIDTH = 60;
    private static final int HEIGHT = 10;
    double x = 0;
    double xa = 0;
    private final Game wallBall;

    public Paddle(Game wallBall)
    {
        this.wallBall = wallBall;
    }

    public void move()
    {
        if (x + xa > 0 && x + xa < wallBall.getWidth() - WIDTH) {
            x = x + xa;
        }
    }

    public void paint(Graphics2D g)
    {
        g.fillRect((int) x, Y, WIDTH, HEIGHT);
    }

    public void keyReleased(KeyEvent e)
    {
        xa = 0;
    }

    public void keyPressed(KeyEvent e)
    {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            xa = -wallBall.paddleSpeed;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            xa = wallBall.paddleSpeed;
        }
    }

    public Rectangle getBounds()
    {
        return new Rectangle((int) x, Y, WIDTH, HEIGHT);
    }

    public int getTopY()
    {
        return Y - HEIGHT;
    }
}
