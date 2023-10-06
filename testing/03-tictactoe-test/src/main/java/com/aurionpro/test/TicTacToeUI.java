package com.aurionpro.test;

import javax.swing.*;

import com.aurionpro.model.Game;
import com.aurionpro.model.MarkType;
import com.aurionpro.model.Player;
import com.aurionpro.model.ResultAnalyzer;
import com.aurionpro.model.ResultType;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class TicTacToeUI extends JFrame implements ActionListener {

	private JButton[][] buttons;
	private char currentPlayer;
	private boolean gameEnded;

	public TicTacToeUI() {
		buttons = new JButton[3][3];
		currentPlayer = 'X';
		gameEnded = false;

		initializeUI();
	}

	private void initializeUI() {
		setTitle("Tic-Tac-Toe");
		setSize(300, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(3, 3));

		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				buttons[row][col] = new JButton("");
				buttons[row][col].setFont(new Font("Arial", Font.PLAIN, 50));
				buttons[row][col].setFocusPainted(false);
				buttons[row][col].addActionListener(this);
				add(buttons[row][col]);
			}
		}

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (gameEnded) {
			return;
		}

		JButton clickedButton = (JButton) e.getSource();

		if (clickedButton.getText().equals("")) {
			clickedButton.setText(Character.toString(currentPlayer));

			if (checkForWin() || checkForDraw()) {
				endGame();
			} else {
				currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
			}
		}
	}

	private boolean checkForWin() {
		for (int row = 0; row < 3; row++) {
			if (buttons[row][0].getText().equals(Character.toString(currentPlayer))
					&& buttons[row][1].getText().equals(Character.toString(currentPlayer))
					&& buttons[row][2].getText().equals(Character.toString(currentPlayer))) {
				return true;
			}
		}

		for (int col = 0; col < 3; col++) {
			if (buttons[0][col].getText().equals(Character.toString(currentPlayer))
					&& buttons[1][col].getText().equals(Character.toString(currentPlayer))
					&& buttons[2][col].getText().equals(Character.toString(currentPlayer))) {
				return true;
			}
		}

		if (buttons[0][0].getText().equals(Character.toString(currentPlayer))
				&& buttons[1][1].getText().equals(Character.toString(currentPlayer))
				&& buttons[2][2].getText().equals(Character.toString(currentPlayer))) {
			return true;
		}

		if (buttons[0][2].getText().equals(Character.toString(currentPlayer))
				&& buttons[1][1].getText().equals(Character.toString(currentPlayer))
				&& buttons[2][0].getText().equals(Character.toString(currentPlayer))) {
			return true;
		}

		return false;
	}

	private boolean checkForDraw() {
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				if (buttons[row][col].getText().equals("")) {
					return false;
				}
			}
		}
		return true;
	}

	private void endGame() {
		gameEnded = true;
		JOptionPane.showMessageDialog(this, "Player " + currentPlayer + " wins!");
		System.exit(0);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new TicTacToeUI();
		});
	}
}
