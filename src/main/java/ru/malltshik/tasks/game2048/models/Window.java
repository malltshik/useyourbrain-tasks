package ru.malltshik.tasks.game2048.models;

import ru.malltshik.tasks.game2048.enums.Direction;
import ru.malltshik.tasks.game2048.exceptions.GameOverException;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;

public class Window implements KeyListener {

    private Field field;
    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel();
    private int scale = 150;

    private Map<Integer, Color> colorMap = new HashMap<>();

    public Window(Field field) {
        this.field = field;
        Dimension size = new Dimension(field.getSize() * scale, field.getSize() * scale);
        frame.setTitle("2048 GAME BY MALLTSHIK");
        panel.setBackground(new Color(253, 253, 253));
        panel.setSize(size);
        frame.add(panel);
        frame.setSize(size);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.addKeyListener(this);
        frame.setFocusable(true);
        frame.setFocusTraversalKeysEnabled(false);
        fillColorMap();
        draw();
    }

    public void show() {
        frame.setVisible(true);
    }

    private void draw() {
        this.panel.removeAll();
        Cell[][] cells = this.field.getCells();
        for (Cell[] row : cells) {
            for (int x = 0; x < cells.length; x++) {
                Cell cell = row[x];
                JLabel label = new JLabel();
                label.setPreferredSize(new Dimension(scale - 8, scale - 8));
                label.setOpaque(true);
                label.setBorder(LineBorder.createGrayLineBorder());
                label.setHorizontalAlignment(SwingConstants.CENTER);
                label.setVerticalAlignment(SwingConstants.CENTER);
                label.setHorizontalTextPosition(SwingConstants.CENTER);
                label.setVerticalTextPosition(SwingConstants.CENTER);
                if (cell != null) {
                    label.setBackground(colorMap.get(cell.getValue()));
                    label.setText(String.valueOf(cell.getValue()));
                    label.setFont(new Font("Default", Font.PLAIN, scale / 6));
                } else {
                    label.setBackground(new Color(247, 247, 247));
                    label.setText(" ");
                }
                panel.add(label);
            }
        }
        SwingUtilities.updateComponentTreeUI(frame);
    }


    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent event) {
        try {
            switch (event.getKeyCode()) {
                case 38:
                    this.field.move(Direction.UP);
                    draw();
                    break;
                case 39:
                    this.field.move(Direction.RIGHT);
                    draw();
                    break;
                case 40:
                    this.field.move(Direction.DOWN);
                    draw();
                    break;
                case 37:
                    this.field.move(Direction.LEFT);
                    draw();
                    break;
            }
        } catch (GameOverException e) {
            gameOver();
        }
        if (this.field.has(2048)) gameWin();

    }

    private void gameWin() {
        this.panel.removeAll();
        this.frame.removeKeyListener(this);
        JTextArea gameOver = new JTextArea("YOU WIN!");
        gameOver.setEnabled(false);
        gameOver.setFont(new Font("Default", Font.BOLD, scale / 2));
        gameOver.setDisabledTextColor(Color.GREEN);
        this.panel.add(gameOver, Component.CENTER_ALIGNMENT);
        SwingUtilities.updateComponentTreeUI(frame);
    }

    private void gameOver() {
        this.panel.removeAll();
        JTextArea gameOver = new JTextArea("GAME OVER");
        gameOver.setEnabled(false);
        gameOver.setFont(new Font("Default", Font.BOLD, scale / 2));
        gameOver.setDisabledTextColor(Color.RED);
        this.panel.add(gameOver, Component.CENTER_ALIGNMENT);
        SwingUtilities.updateComponentTreeUI(frame);
    }

    private void fillColorMap() {
        this.colorMap.put(2, new Color(249, 255, 114));
        this.colorMap.put(4, new Color(255, 196, 81));
        this.colorMap.put(8, new Color(141, 255, 124));
        this.colorMap.put(16, new Color(40, 255, 83));
        this.colorMap.put(32, new Color(124, 224, 255));
        this.colorMap.put(64, new Color(114, 125, 255));
        this.colorMap.put(128, new Color(232, 148, 255));
        this.colorMap.put(256, new Color(255, 158, 162));
        this.colorMap.put(512, new Color(255, 114, 94));
        this.colorMap.put(1024, new Color(46, 255, 255));
        this.colorMap.put(2048, new Color(60, 54, 255));
    }
}
