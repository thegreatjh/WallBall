package wallball;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Ball
{

    private static final int DIAMETER = 30;

    int x = 0;
    int y = 0;
    double xa = 1;
    double ya = 1;
    private Game wallBall;

    public Ball(Game wallBall)
    {
        this.wallBall = wallBall;
    }

    void move()
    {
        boolean changeDirection = true;
        if (x + xa < 0) {
            xa = wallBall.speed;
        } else if (x + xa > wallBall.getWidth() - DIAMETER) {
            xa = -wallBall.speed;
        } else if (y + ya < 0) {
            ya = wallBall.speed;
        } else if (y + ya > wallBall.getHeight() - DIAMETER) {
            wallBall.gameOver();
        } else if (collision()) {
            wallBall.score++;
            if (wallBall.score % 2 == 0) {
                wallBall.speed += 0.5;
                wallBall.paddleSpeed += 0.33;
                wallBall.level++;
            }
            ya = -wallBall.speed;
            y = wallBall.paddle.getTopY() - DIAMETER;

        } else {
            changeDirection = false;
        }

        if (changeDirection) {
            Sound.BALL.play();
        }
        x = x + (int) xa;
        y = y + (int) ya;
    }

    private boolean collision()
    {
        return wallBall.paddle.getBounds().intersects(getBounds());
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
