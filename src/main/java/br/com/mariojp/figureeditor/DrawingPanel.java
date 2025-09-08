
package br.com.mariojp.figureeditor;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

class DrawingPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    private static final int DEFAULT_SIZE = 60;
    private final List<Shape> shapes = new ArrayList<>();
    private Point startDrag = null;
    private BufferedImage importedImage;
    private JButton importButton = new JButton("Importar");

    DrawingPanel() {

        setBackground(Color.WHITE);
        setOpaque(true);
        setDoubleBuffered(true);

        importButton.addActionListener(e -> importImage());
        this.setLayout(new BorderLayout());
        this.add(importButton, BorderLayout.NORTH);

        var mouse = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1 && startDrag == null) {
                    ShapeFactory shapeFactory = new ShapeFactory();
                    shapes.add(shapeFactory.getShape(e.getX(), e.getY(), 2));
                    repaint();
                }
            }
        };
        addMouseListener(mouse);
        addMouseMotionListener(mouse);

    }

    private void importImage() {
        JFileChooser chooser = new JFileChooser();
        int result = chooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                File file = chooser.getSelectedFile();
                importedImage = ImageIO.read(file);
                repaint();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao importar imagem: " + ex.getMessage());
            }
        }
    }

    void clear() {
        shapes.clear();
        importedImage = null;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (importedImage != null) {
            g2.drawImage(importedImage, 50, 50, this);
        }

        for (Shape s : shapes) {
            g2.setColor(new Color(30, 144, 255));
            g2.fill(s);
            g2.setColor(new Color(0, 0, 0, 70));
            g2.setStroke(new BasicStroke(1.2f));
            g2.draw(s);
        }

        g2.dispose();
    }

}
