package utils;

import java.awt.*;
import javax.swing.*;

/**
 * 
 **/
public class RotatableRoundedLabel extends JLabel {
    private double angle; 
    private int cornerRadius; 

    public RotatableRoundedLabel(String text, double angle, int cornerRadius) {
        super(text, SwingConstants.CENTER);
        this.angle = angle;
        this.cornerRadius = cornerRadius;
        setOpaque(false); 
        setFont(new Font("Arial", Font.BOLD, 46));
        setForeground(Color.BLACK);
        setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();


        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int w = getWidth();
        int h = getHeight();


        g2d.translate(w / 2, h / 2);
        g2d.rotate(Math.toRadians(angle));
        g2d.translate(-w / 2, -h / 2);

        // Dibujar fondo redondeado rotado
        g2d.setColor(getBackground());
        g2d.fillRoundRect(0, 0, w, h, cornerRadius, cornerRadius);

        // Dibujar el texto centrado
        g2d.setColor(getForeground());
        FontMetrics fm = g2d.getFontMetrics();
        int textWidth = fm.stringWidth(getText());
        int textHeight = fm.getAscent() - fm.getDescent();

        int textX = (w - textWidth) / 2;
        int textY = (h + textHeight) / 2;

        g2d.drawString(getText(), textX, textY);

        g2d.dispose();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(90, 90);
    }

    public void setAngle(double angle) {
        this.angle = angle;
        repaint();
    }

    public void setCornerRadius(int radius) {
        this.cornerRadius = radius;
        repaint();
    }
}
