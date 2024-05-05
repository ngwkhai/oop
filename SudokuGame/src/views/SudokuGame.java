package views;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.DimensionUIResource;

import canvas.BoardGraphics;

import controller.Controller;
import models.SudokuModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SudokuGame extends JFrame implements ActionListener {
	JButton[][] board = new JButton[9][9];
	JButton[][] boardResult = new JButton[3][3];
	int[][] state = new int[9][9];
	int[][] stateSolve = new int[9][9];
	int numberCellIllegal = 0;
	JButton jbNew, jbSolved, jbReset;
	JButton lbMessage;
	JComboBox<String> comboBox;
	Controller controller;
	SudokuModel model;
	Random random = new Random();
	boolean reset = true;
	Font font = new Font("Arial", Font.BOLD, 16);
	ColorUIResource colorMain = new ColorUIResource(0, 128, 255);
	Color colorButton = new Color(0, 128, 255);
	Color colorOpacity = new Color(93, 174, 255);
	ColorUIResource colorCell = new ColorUIResource(178, 231, 250);
	ColorUIResource colorText = new ColorUIResource(255, 51, 51);
	Color colorSolved = new Color(255, 221, 221);

	public SudokuGame(Controller controller, SudokuModel model) {
		this.controller = controller;
		this.model = model;
		init();
	}

	public void init() {
		setTitle("Sudoku Game");
		setSize(700, 500);
		createView();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void createView() {
		JPanel container = new JPanel();
		add(container);
		container.setLayout(new BorderLayout());

		JLayeredPane boardPanel = new BoardGraphics(new GridLayout(9, 9, 2, 2));
		JPanel controlPanel = new JPanel(new BorderLayout());

		controlPanel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		controlPanel.setBackground(Color.white);
		boardPanel.setBorder(new LineBorder(colorMain, 5));
		container.add(boardPanel, BorderLayout.CENTER);
		container.add(controlPanel, BorderLayout.EAST);

		//
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {

				board[i][j] = new JButton();
				board[i][j].addActionListener(this);
				board[i][j].setActionCommand(i + " " + j);
				
				board[i][j].setBorder(new LineBorder(colorMain, 1));
				board[i][j].setFont(new Font("Arial", Font.BOLD, 25));
				board[i][j].setForeground(colorText);

				boardPanel.add(board[i][j]);

			}
		}
		//

		comboBox = new JComboBox<>(new String[] { "Easy", "Medium", "Hard" });
		comboBox.setPreferredSize(new DimensionUIResource(110, 20));
		comboBox.setBackground(colorMain);
		comboBox.setForeground(Color.white);
		comboBox.setOpaque(true);

		JLabel label = new JLabel("Level: ");
		JPanel headerPanel = new JPanel();
		headerPanel.add(label);
		headerPanel.add(comboBox);
		headerPanel.setBackground(Color.white);
		headerPanel.setBorder(new LineBorder(colorMain, 2));

		jbNew = new JButton("New game");
		jbNew.addActionListener(this);
		setUI(jbNew);
		setHover(jbNew);

		jbSolved = new JButton("Solve");
		setUI(jbSolved);
		setHover(jbSolved);
		jbSolved.addActionListener(this);

		jbReset = new JButton("Reset");
		setUI(jbReset);
		setHover(jbReset);
		jbReset.addActionListener(this);

		JPanel panelBt = new JPanel();
		panelBt.setPreferredSize(new DimensionUIResource(200, 120));
		panelBt.setLayout(new GridLayout(4, 1, 5, 5));
		panelBt.add(headerPanel);

		panelBt.add(jbNew);
		panelBt.add(jbSolved);
		panelBt.add(jbReset);

		lbMessage = new JButton("Create a new game!!!");
		lbMessage.setFont(new Font("Arial", Font.BOLD, 15));
		lbMessage.setBackground(Color.white);
		lbMessage.setBorder(null);
		lbMessage.setEnabled(true);

		JButton lbTitle = new JButton("Sudoku Game By NDK");
		lbTitle.setBackground(Color.white);
		lbTitle.setBorder(null);
		lbTitle.setEnabled(true);
		lbTitle.setFont(new Font("Arial", Font.BOLD, 19));
		lbTitle.setForeground(colorMain);

		JPanel panelInfo = new JPanel();
		panelInfo.add(lbTitle);
		panelInfo.add(lbMessage);
		panelInfo.setBorder(new LineBorder(colorMain,2));
		panelInfo.setLayout(new GridLayout(7, 1, 1, 1));
		panelInfo.setBackground(Color.white);

		JLayeredPane boardRes = new BoardGraphics(new GridLayout(3, 3, 1, 1));
		boardRes.setBorder(new LineBorder(colorMain, 3));
		boardRes.setPreferredSize(new DimensionUIResource(180, 180));
		//
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {

				boardResult[i][j] = new JButton(i * 3 + j + 1 + "");
				boardResult[i][j].addActionListener(this);
				boardResult[i][j].setActionCommand(i + " " + j);

				boardResult[i][j].setBorder(new LineBorder(colorMain, 1));
				boardResult[i][j].setFont(new Font("Arial", Font.PLAIN, 18));
				boardResult[i][j].setForeground(Color.black);

				boardRes.add(boardResult[i][j]);

			}
		}
		//

		controlPanel.add(panelInfo,BorderLayout.CENTER);
		controlPanel.add(panelBt,BorderLayout.NORTH);
		controlPanel.add(boardRes,BorderLayout.SOUTH);

	}

	public void setUI(JComponent component) {
		component.setBackground(colorButton);
		component.setForeground(Color.black);
		component.setFont(font);
		component.setCursor(new Cursor(Cursor.HAND_CURSOR));
		component.setBorder(null);

	}

	public void setHover(JComponent component) {
		component.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				component.setBackground(colorOpacity);
			}

			public void mouseExited(MouseEvent evt) {
				component.setBackground(colorButton);
			}
		});
	}

	public void level() {
		int level = 2;
		switch (comboBox.getSelectedIndex()) {
		case 0:
			level = 2;
			break;
		case 1:
			level = 4;
			break;
		case 2:
			level = 8;
			break;

		default:
			break;
		}
		for (int l = 0; l < level; l++) {
			for (int k = 0; k < 9; k++) {
				int i = 1 + random.nextInt(8);
				state[k][i] = 0;
			}
			for (int k = 0; k < 9; k++) {
				int i = 1 + random.nextInt(8);
				state[i][k] = 0;
			}
		}

	}

	/*public void checkWin() {
		boolean win = true;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j].isEditable()) {
					String inputUser = board[i][j].getText();
					if (!inputUser.equals(String.valueOf(stateSolve[i][j]))) {
						win = false;
						numberCellIllegal++;
						board[i][j].setBackground(Color.red);
						board[i][j].setForeground(Color.yellow);
					} else {
						board[i][j].setBackground(Color.white);
						board[i][j].setForeground(Color.black);
					}
				}
			}
		}
		if (win == true) {
			JOptionPane.showMessageDialog(this, "Chúc mừng bạn đã giải thành công");
			lbMessage.setText("Winer !!!\n Tạo trò chơi mới");
		}else {
			lbMessage.setText(numberCellIllegal+" ô không hợp lệ");
		}
		numberCellIllegal=0;
	}*/

	public void display(int board[][]) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(" " + board[i][j]);
			}

			System.out.println();
		}

		System.out.println();
	}

	public void resetBoard() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				board[i][j].setText("");
				state[i][j] = 0;
				board[i][j].setBackground(Color.white);
				//board[i][j].setEditable(true);
				board[i][j].setForeground(colorText);
			}
		}
	}

	/*public boolean isNumeric(String strNum) {
		try {
			int d = Integer.parseInt(strNum);
			if (!(d > 0 && d <= 9)) {
				return false;
			}
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	public void handleExceptionInput() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				int i1 = i;
				int i2 = j;
				board[i][j].getDocument().addDocumentListener(new DocumentListener() {
					@Override
					public void removeUpdate(DocumentEvent e) {
						board[i1][i2].setBackground(Color.white);
						board[i1][i2].setForeground(Color.red);

					}

					@Override
					public void insertUpdate(DocumentEvent e) {
						board[i1][i2].setBackground(Color.white);
						board[i1][i2].setForeground(Color.red);

					}

					@Override
					public void changedUpdate(DocumentEvent e) {
						board[i1][i2].setBackground(Color.white);
						board[i1][i2].setForeground(Color.red);
					}
				});
			}
		}
	}

	public boolean isEmtry() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (!(state[i][j] == 0)) {
					return false;
				}

			}
		}
		return true;
	}*/

	public void showBoard() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (state[i][j] != 0) {
					board[i][j].setText(String.valueOf(state[i][j]));
					board[i][j].setEnabled(false);
					//board[i][j].setEditable(false);
					board[i][j].setBackground(Color.white);
					board[i][j].setForeground(Color.red);
				}
			}
		}
	}

	public int[][] copyState(int[][] state) {
		int[][] result = new int[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				result[i][j] = state[i][j];
			}
		}
		return result;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		if (e.getSource() == jbNew) {
//			resetBoard();
//			controller.makeNewGame();
//			state = copyState(model.getGenome().getState());
//			stateSolve = copyState(model.getGenome().getState());
//			level();
//			showBoard();
//			display(state);
//			if(model.isSuccess()) {
//				lbMessage.setText("Creating successful!");
//			} else {
//				lbMessage.setText("Creating failed!");
//			}
//		}
		/*if (e.getSource() == jbSolved) {
			if (!isEmtry()) {
				for (int i = 0; i < 9; i++) {
					for (int j = 0; j < 9; j++) {

						if (board[i][j].isEditable()) {
							board[i][j].setText(String.valueOf(stateSolve[i][j]));
							board[i][j].setBackground(colorSolved);
							board[i][j].setForeground(Color.red);
						}
					}
				}
			} else {
				JOptionPane.showMessageDialog(this, "Bạn phải tạo trò chơi mới");

			}
		}
		if (e.getSource() == jbCheck) {
			checkWin();
			handleExceptionInput();
			System.out.println("hello");
		}*/
	}
}
