package oop.HW3.HWTetris_junit5;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class JBrainTetris extends JTetris {

    private Brain defaultBrain = new DefaultBrain();
    private Brain.Move brainMove = new Brain.Move();
    private int brainCount = -1;
    protected JSlider adversary;
    protected JLabel jlabel;
    protected JCheckBox playBrain;

    protected String On = "*Ok*";
    protected String Off = "OK";

    public JBrainTetris(int pixels) {
        super(pixels);
    }

    public void tick(int verb) {
        try {
            if (playBrain.isSelected()) {
                board.undo();
                if (verb == DOWN) {
                    if (brainCount != super.count) {
                        brainMove = defaultBrain.bestMove(board, currentPiece, board.getHeight() - TOP_SPACE, brainMove);
                        brainCount = super.count;
                    }
                    if (!currentPiece.equals(brainMove.piece))
                        super.tick(ROTATE);

                    if (currentX < brainMove.x)
                        super.tick(RIGHT);
                    if (currentX > brainMove.x)
                        super.tick(LEFT);
                }
            }
            super.tick(verb);
        } catch (NullPointerException e) {
            stopGame();
        }

    }

    public JComponent createControlPanel() {

        JComponent panel = super.createControlPanel();

        panel.add(new JLabel("Brain:"));
        JCheckBox brainMode = new JCheckBox("Brain active");
        panel.add(brainMode);

        // make a little panel, put a JSlider in it. JSlider responds to getValue()
        JPanel little = new JPanel();
        little.add(new JLabel("Adversary:"));
        adversary = new JSlider(0, 100, 0); // min, max, current
        adversary.setPreferredSize(new Dimension(100,15));
        little.add(adversary);
        // now add little to panel of controls
        panel.add(little);

//        JComponent text = new JPanel();
//        text.add(jlabel = new JLabel(Off));
//        panel.add(text);

        JTextField brainText = new JTextField();
        panel.add(brainText);
        JLabel status = new JLabel("Adversary:");
        JButton button = new JButton("Load brain");
        button.addActionListener(e -> {
            try {
                Class bClass = Class.forName(brainText.getText());
                Brain newBrain = (Brain) bClass.newInstance();
                // here change Brain ivar to use newBrain
                status.setText(brainText.getText() + " loaded");
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        panel.add(button);

        return (panel);
    }

    public Piece pickNextPiece() {
        if (adversary.getValue() == 0) {
            jlabel.setText(Off);
            return (super.pickNextPiece());
        }
        if (random.nextInt(100) < adversary.getValue()) {
            jlabel.setText(On);
            return bestPiece(true);
        } else {
            jlabel.setText(Off);
        }
        return (super.pickNextPiece());

    }

    private Piece bestPiece(boolean choose) {
        Brain.Move wMove = defaultBrain.bestMove(board, pieces[0], board.getHeight() - TOP_SPACE, null);
        ;
        Brain.Move tMove;
        int index = 0;
        for (int i = 0; i < pieces.length; i++) {
            tMove = defaultBrain.bestMove(board, pieces[i], board.getHeight() - TOP_SPACE, null);
            if (tMove == null && index == 0) {
                return pieces[i];
            }
            if (tMove.score >= wMove.score) {
                wMove = tMove;
                index = i;
            }
        }
        return pieces[index];
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) { }

        EventQueue.invokeLater(() -> {
            JBrainTetris tetris = new JBrainTetris(16);
            JFrame frame = JTetris.createFrame(tetris);
            frame.setVisible(true);
        });
    }
}