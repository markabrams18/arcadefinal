package arcade;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class TetrisPanel extends JPanel {

	final int WIDTH = 800;
	final int HEIGHT = 800;

	Image bgImage, rSquare, gSquare, pSquare, bSquare, randomSquare;

	Timer timer, timer2;

	boolean upArrowR = false;
	boolean downArrow = false;
	boolean leftArrow = false;
	boolean rightArrow = false;

	boolean spaceBar = false;
	boolean cSave = false;

	int po = 0;

	// 297
	int x = 52;
	int y = 26;
	// 29
	int score = 0;
	String stScore;

	private final int blockSize = 26;

	private final int brdWidth = 10;
	private final int brdHeight = 24;

	// random block color
	int num = 0;
	// random block piece
	int random = 0;

	int[][] temp = new int[3][3];

	int[] pieceOrder = new int[3];
	ArrayList<Object> list = new ArrayList();

	int tempx = 0;
	int tempy = 0;

	int curX = 3;
	int curY = 0;

	int turn = 1;
	int[][] tempSetUp = new int[12][24];
	int[][] currPos = new int[12][24];
	int lineCount = 1;

	boolean leftWall = false;
	boolean rightWall = false;

	boolean flag = false;

	boolean bottomCheck = false;

	TetrisPanel() {

		bgImage = new ImageIcon("TetrisBG.png").getImage();
		rSquare = new ImageIcon("redBlock.png").getImage();
		bSquare = new ImageIcon("blueBlock.png").getImage();
		gSquare = new ImageIcon("greenBlock.png").getImage();
		pSquare = new ImageIcon("purpleBlock.png").getImage();

		Random colorR = new Random();

		makeOrder();
		blocks();

		random();
		
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setFocusable(true);

		this.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {

				switch (e.getKeyCode()) {
				// left arrow
				case 37:
					if (x > 0 && leftWall == false) {
						x -= 26;
						System.out.println(x);
					}
					if (curX > 0 && leftWall == false) {
						curX -= 1;
					}
					break;

				// up arrow
				case 38:
					turn += 1;
					if (turn == 5) {
						turn = 1;
					}

					if (turn == 1) {
						switch (pieceOrder[po]) {
						case 1:
							((LBlock) list.get(po)).upShape();
							temp = ((LBlock) list.get(po)).getShape();
							curX = 3;
							break;
						case 2:
							((TBlock) list.get(po)).upShape();
							temp = ((TBlock) list.get(po)).getShape();
							curX = 3;
							break;
						case 3:
							((OBlock) list.get(po)).upShape();
							temp = ((OBlock) list.get(po)).getShape();
							curX = 3;
							break;
						case 4:
							((ZShape) list.get(po)).upShape();
							temp = ((ZShape) list.get(po)).getShape();
							curX = 3;
							break;

						}

					} else if (turn == 2) {

						switch (pieceOrder[po]) {
						case 1:
							((LBlock) list.get(po)).rightShape();
							temp = ((LBlock) list.get(po)).getShape();
							curX = 3;
							break;
						case 2:
							((TBlock) list.get(po)).rightShape();
							temp = ((TBlock) list.get(po)).getShape();
							curX = 3;
							break;
						case 3:
							((OBlock) list.get(po)).upShape();
							temp = ((OBlock) list.get(po)).getShape();
							curX = 3;
							break;
						case 4:
							((ZShape) list.get(po)).rightShape();
							temp = ((ZShape) list.get(po)).getShape();
							curX = 3;
							break;
						}
						if (x < 0) {
							x += 26;

						}

					} else if (turn == 3) {

						switch (pieceOrder[po]) {
						case 1:
							((LBlock) list.get(po)).downShape();
							temp = ((LBlock) list.get(po)).getShape();
							curX = 3;
							break;
						case 2:
							((TBlock) list.get(po)).downShape();
							temp = ((TBlock) list.get(po)).getShape();
							curX = 3;
							break;
						case 3:
							((OBlock) list.get(po)).upShape();
							temp = ((OBlock) list.get(po)).getShape();
							curX = 3;
							break;
						case 4:
							((ZShape) list.get(po)).downShape();
							temp = ((ZShape) list.get(po)).getShape();
							curX = 3;
							break;

						}

						System.out.println(x);
						if (x < 0) {
							x += 26;
						}

						if (tempSetUp[curX + 2][curY + 2] == 0 && tempSetUp[curX + 2][curY + 1] == 0
								&& tempSetUp[curX + 2][curY] == 0 && rightWall == false) {
							x += 26;
						}

					} else if (turn == 4) {

						switch (pieceOrder[po]) {
						case 1:
							((LBlock) list.get(po)).leftShape();
							temp = ((LBlock) list.get(po)).getShape();
							curX = 3;
							break;
						case 2:
							((TBlock) list.get(po)).leftShape();
							temp = ((TBlock) list.get(po)).getShape();
							curX = 3;
							break;
						case 3:
							((OBlock) list.get(po)).upShape();
							temp = ((OBlock) list.get(po)).getShape();
							curX = 3;
							break;
						case 4:
							((ZShape) list.get(po)).leftShape();
							temp = ((ZShape) list.get(po)).getShape();
							curX = 3;
							break;

						}

					}

					break;

				// right arrow
				case 39:
					if (x < 200 && rightWall == false) {
						x += 26;
					}

					if (curX < 11 && rightWall == false) {
						curX += 1;
					}

					break;
				// down arrow
				case 40:
					if (y < 574 && bottomCheck == false) {
						y += 26;
						score += 2;
					}
					if (curY < tempSetUp[0].length && bottomCheck == false && curY < 21) {
						curY += 1;

					}
					break;

				case 49:
					spaceBar = true;
					break;

				case 67:
					cSave = true;
					break;

				default:
					System.out.println(e.getKeyCode());
				}

			}

			@Override
			public void keyReleased(KeyEvent e) {
				switch (e.getKeyCode()) {
				case 38:
					upArrowR = false;
					break;
				case 40:
					downArrow = false;
					break;

				case 37:
					leftArrow = false;
					break;
				case 39:
					rightArrow = false;
					break;

				case 49:
					spaceBar = false;
					break;
				case 67:
					cSave = false;
					break;

				default:
					System.out.println(e.getKeyCode());

				}
			}

		});
	
		switch (pieceOrder[po]) {
		case 1:
			((LBlock) list.get(po)).upShape();
			temp = ((LBlock) list.get(po)).getShape();
			curX = 3;
			break;
		case 2:
			((TBlock) list.get(po)).upShape();
			temp = ((TBlock) list.get(po)).getShape();
			curX = 3;
			break;
		case 3:
			((OBlock) list.get(po)).upShape();
			temp = ((OBlock) list.get(po)).getShape();
			curX = 3;
			break;
		case 4:
			((ZShape) list.get(po)).upShape();
			temp = ((ZShape) list.get(po)).getShape();
			curX = 3;
			break;

		}
		// pictures
		bgImage = new ImageIcon("blackBG.png").getImage();
		rSquare = new ImageIcon("redBlock.png").getImage();
		bSquare = new ImageIcon("blueBlock.png").getImage();
		gSquare = new ImageIcon("greenBlock.png").getImage();
		pSquare = new ImageIcon("purpleBlock.png").getImage();

		timer = new Timer(50, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (bottomCheck == true) {
				}

				stScore = Integer.toString(score);

				repaint();
			}

		});
		timer.start();

		timer2 = new Timer(1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (y < 574) {
					y += 26;
				} else {

					bottomCheck = true;

					System.out.println(bottomCheck);

				}
				score += 2;
				if (curY < tempSetUp[0].length && curY < 21) {
					curY = curY + 1;
				}

			}

		});

		timer2.start();
	}

	public void random() {
		Random r = new Random();
		random = r.nextInt(4) + 1;
		num = r.nextInt(4) + 1;

		if (num == 1) {
			randomSquare = rSquare;

		} else if (num == 2) {
			randomSquare = gSquare;

		} else if (num == 3) {
			randomSquare = bSquare;

		} else if (num == 4) {
			randomSquare = pSquare;

		}

		System.out.println(po);
		switch (pieceOrder[po]) {
		case 1:
			temp = ((LBlock) list.get(po)).getShape();
			curX = 3;
			break;
		case 2:
			temp = ((TBlock) list.get(po)).getShape();
			curX = 3;
			break;
		case 3:
			temp = ((OBlock) list.get(po)).getShape();
			curX = 3;
			break;
		case 4:
			temp = ((ZShape) list.get(po)).getShape();
			curX = 3;
			break;

		}

	}

	public void makeOrder() {
		Random q = new Random();

		for (int i = 0; i < pieceOrder.length; i++) {
			pieceOrder[i] = q.nextInt(4) + 1;
			
		}
	}

	public void blocks() {

		for (int i = 0; i < pieceOrder.length; i++) {
			switch (pieceOrder[i]) {
			case 1:
				list.add(new LBlock());
				break;
			case 2:
				list.add(new TBlock());
				break;
			case 3:
				list.add(new OBlock());
				break;
			case 4:
				list.add(new ZShape());
				break;

			}

		}

	}

	public void setUpPrint() {
		for (int j = 0; j < tempSetUp[0].length; j++) {
			for (int i = 0; i < tempSetUp.length; i++) {

				System.out.print(tempSetUp[i][j] + " ");
			}
			System.out.println(" ");
		}
	}

	public void tempSetUp() {
		for (int j = 0; j < tempSetUp[0].length; j++) {
			for (int i = 0; i < tempSetUp.length; i++) {

				tempSetUp[i][j] = 0;
				/**
				 * if (i == 0 || i == 11) { tempSetUp[i][j] = 1; } else if (j == 24) {
				 * tempSetUp[i][j] = 1; }
				 */
			}
		}
	}

	public void finalPrint() {
		for (int j = 0; j < currPos[0].length; j++) {
			for (int i = 0; i < currPos.length; i++) {

				System.out.print(currPos[i][j] + " ");
			}
			System.out.println(" ");
		}
	}

	public void FinalSetUp() {
		for (int j = 0; j < currPos[0].length; j++) {
			for (int i = 0; i < currPos.length; i++) {
				currPos[i][j] = 0;

				System.out.print(currPos[i][j] + " ");
			}
			System.out.println(" ");
		}

	}

	public void paint(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
		tempSetUp();

		g2D.drawImage(bgImage, 0, 0, null);

		g2D.setColor(Color.white);

		for (int i = 0; i <= brdHeight; i++) {

			g2D.drawLine(0, i * blockSize, brdWidth * blockSize, i * blockSize);
		}

		for (int i = 0; i <= brdWidth; i++) {

			g2D.drawLine(i * blockSize, 0, i * blockSize, brdHeight * 26);
		}

		Font font = new Font("Serif", Font.PLAIN, 40);
		g2D.setFont(font);
		g2D.setColor(Color.white);
		g2D.drawString(stScore, 400, 100);

		if (temp[0][0] == 1) {
			tempx = x - 26;
			tempy = y - 26;
			g2D.drawImage(randomSquare, tempx, tempy, null);

			tempSetUp[curX][curY] = 1;

			if (bottomCheck == true) {
				currPos[curX][curY] = 1;
			}

		}
		if (temp[1][0] == 1) {
			tempx = x;
			tempy = y - 26;
			g2D.drawImage(randomSquare, tempx, tempy, null);

			if (curX + 1 > tempSetUp[0].length) {
				curX -= 1;
				tempSetUp[curX + 1][curY] = 1;
			} else {
				tempSetUp[curX + 1][curY] = 1;
			}

			if (bottomCheck == true) {
				currPos[curX + 1][curY] = 1;
			}

		}
		if (temp[2][0] == 1) {
			tempx = x + 26;
			tempy = y - 26;
			g2D.drawImage(randomSquare, tempx, tempy, null);

			if (curX + 2 > tempSetUp[0].length) {
				curX = curX - 2;
				tempSetUp[curX + 2][curY] = 1;
			} else {
				tempSetUp[curX + 2][curY] = 1;
			}

			if (bottomCheck == true) {
				currPos[curX + 2][curY] = 1;
			}

		}
		if (temp[0][1] == 1) {
			tempx = x - 26;
			tempy = y;
			g2D.drawImage(randomSquare, tempx, tempy, null);

			tempSetUp[curX][curY + 1] = 1;

			if (bottomCheck == true) {
				currPos[curX][curY + 1] = 1;
			}

		}
		if (temp[1][1] == 1) {
			tempx = x;
			tempy = y;
			g2D.drawImage(randomSquare, tempx, tempy, null);

			if (curX + 1 > tempSetUp[0].length) {
				curX = curX - 1;
				tempSetUp[curX + 1][curY + 1] = 1;
			} else {
				tempSetUp[curX + 1][curY + 1] = 1;
			}

			if (bottomCheck == true) {
				currPos[curX + 1][curY + 1] = 1;
			}

		}
		if (temp[2][1] == 1) {
			tempx = x + 26;
			tempy = y;
			g2D.drawImage(randomSquare, tempx, tempy, null);

			if (curX + 2 > tempSetUp[0].length) {
				curX = curX - 2;
				tempSetUp[curX + 2][curY + 1] = 1;
			} else {
				tempSetUp[curX + 2][curY + 1] = 1;
			}

			if (bottomCheck == true) {
				currPos[curX + 2][curY + 1] = 1;
			}

		}
		if (temp[0][2] == 1) {
			tempx = x - 26;
			tempy = y + 26;
			g2D.drawImage(randomSquare, tempx, tempy, null);

			tempSetUp[curX][curY + 2] = 1;

			if (bottomCheck == true) {
				currPos[curX][curY + 2] = 1;
			}

		}
		if (temp[1][2] == 1) {
			tempx = x;
			tempy = y + 26;
			g2D.drawImage(randomSquare, tempx, tempy, null);

			if (curX + 1 > tempSetUp[0].length) {
				curX = curX - 1;
				tempSetUp[curX + 1][curY + 2] = 1;
			} else {
				tempSetUp[curX + 1][curY + 2] = 1;
			}

			if (bottomCheck == true) {
				currPos[curX + 1][curY + 2] = 1;
			}

		}
		if (temp[2][2] == 1) {
			tempx = x + 26;
			tempy = y + 26;
			g2D.drawImage(randomSquare, tempx, tempy, null);

			if (curX + 2 > tempSetUp[0].length) {
				curX = curX - 2;
				tempSetUp[curX + 2][curY + 2] = 1;
			} else {
				tempSetUp[curX + 2][curY + 2] = 1;
			}

			if (bottomCheck == true) {
				currPos[curX + 2][curY + 2] = 1;
			}
		}
		if (curX == 1) {
			leftWall = true;

		} else if (curX == 11) {
			rightWall = true;

		}
		System.out.println(curY + "Y AXIS");
		
		System.out.println("Current POS" + po);
		//finalPrint();
		System.out.println("");
	}
}
