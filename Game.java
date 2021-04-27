package wallball;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class Game extends JPanel
{

    Ball ball = new Ball(this);
    Paddle paddle = new Paddle(this);
    double speed = 1, paddleSpeed = 5;
    int score = 0, level = 1;

    private int getScore()
    {
        return score;
    }

    private int getLevel()
    {
        return level;
    }

    public Game()
    {
        addKeyListener(new KeyListener()
        {
            @Override
            public void keyTyped(KeyEvent e)
            {
            }

            @Override
            public void keyReleased(KeyEvent e)
            {
                paddle.keyReleased(e);
            }

            @Override
            public void keyPressed(KeyEvent e)
            {
                paddle.keyPressed(e);
            }
        });
        setFocusable(true);
        Sound.BACK.loop();
    }

    private void move()
    {
        ball.move();
        paddle.move();
    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setColor(Color.MAGENTA);
        ball.paint(g2d);
        g2d.setColor(Color.BLUE);
        paddle.paint(g2d);

        g2d.setFont(new Font("Segoe UI", Font.BOLD, 20));
        g2d.drawString("Wall Ball", 103, 20);

        g2d.setColor(Color.GREEN);
        g2d.setFont(new Font("Verdana", Font.BOLD, 15));
        g2d.drawString("Score: " + getScore(), 10, 30);

        g2d.setColor(Color.RED);
        g2d.setFont(new Font("Verdana", Font.BOLD, 15));
        g2d.drawString("Level: " + getLevel(), 200, 30);
    }

    public void gameOver()
    {
        Sound.BACK.stop();
        Sound.GAMEOVER.play();
        if (getScore() < 5) {
            JOptionPane.showMessageDialog(this,
                    "That was abyssmal. Your score is: " + getScore(),
                    "Game Over", JOptionPane.YES_NO_OPTION);
        } else if (getScore() >= 5 && getScore() < 10) {
            JOptionPane.showMessageDialog(this,
                    "You'll get better with practice. Your score is: "
                    + getScore(), "Game Over", JOptionPane.YES_NO_OPTION);
        } else if (getScore() >= 10 && getScore() < 15) {
            JOptionPane.showMessageDialog(this, "Nice showing! Your score is: "
                    + getScore(), "Game Over", JOptionPane.YES_NO_OPTION);
        } else if (getScore() >= 15 && getScore() < 20) {
            JOptionPane.showMessageDialog(this,
                    "You are an amazing Wall Baller! Your score is: "
                    + getScore(), "Game Over", JOptionPane.YES_NO_OPTION);
        } else if (getScore() >= 20 && getScore() < 25) {
            JOptionPane.showMessageDialog(this,
                    "I bow before you, Wall Ball Master! Your score is: "
                    + getScore(), "Game Over", JOptionPane.YES_NO_OPTION);
        } else if (getScore() >= 25 && getScore() < 30) {
            JOptionPane.showMessageDialog(this,
                    "I kneel at your feet, Wall Ball Lord! Your score is: "
                    + getScore(), "Game Over", JOptionPane.YES_NO_OPTION);
        } else if (getScore() >= 30 && getScore() < 35) {
            JOptionPane.showMessageDialog(this,
                    "I kiss the ring, my Wall Ball King!!! "
                    + "Your score is: " + getScore(), "Game Over",
                    JOptionPane.YES_NO_OPTION);
        } else if (getScore() >= 35) {
            JOptionPane.showMessageDialog(this,
                    "I tremble before you. You are a Wall Ball God!!! "
                    + "Congratulations!!! Your score is: " + getScore(),
                    "Game Over", JOptionPane.YES_NO_OPTION);
        }

        System.exit(ABORT);
    }

    public static void main(String[] args) throws InterruptedException
    {
        JFrame frame = new JFrame("Wall Ball");
        Game wallBall = new Game();
        frame.add(wallBall);
        frame.setSize(300, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while (true) {
            wallBall.move();
            wallBall.repaint();
            Thread.sleep(10);
        }
    }
}
