package minitennis;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Ball
{

    private static final int DIAMETER = 30;

    int x = 0;
    int y = 0;
    int xa = 1;
    int ya = 1;
    private MiniTennis miniTennis;

    public Ball(MiniTennis miniTennis)
    {
        this.miniTennis = miniTennis;
    }

    void move()
    {
        boolean changeDirection = true;
        if (x + xa < 0) {
            xa = miniTennis.speed;
        } else if (x + xa > miniTennis.getWidth() - DIAMETER) {
            xa = -miniTennis.speed;
        } else if (y + ya < 0) {
            ya = miniTennis.speed;
        } else if (y + ya > miniTennis.getHeight() - DIAMETER) {
            miniTennis.gameOver();
        } else if (collision()) {
            ya = -miniTennis.speed;
            y = miniTennis.racquet.getTopY() - DIAMETER;
            miniTennis.speed++;
        } else {
            changeDirection = false;
        }

        if (changeDirection) {
            Sound.BALL.play();
        }
        x = x + xa;
        y = y + ya;
    }

    private boolean collision()
    {
        return miniTennis.racquet.getBounds().intersects(getBounds());
    }

    public void paint(Graphics2D g)
    {
        g.fillOval(x, y, DIAMETER, DIAMETER);
    }

    public Rectangle getBounds()
    {
        return new Rectangle(x, y, DIAMETER, DIAMETER);
    }
}
