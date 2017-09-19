//레이아웃 설정
package IlliaMine;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class MineGUI extends JFrame {
	private MineSetting mineSet;
	private Mine[][] mine;
	private JButton[][] button;
	private int count = 0;
	private boolean bool = false;

	JFrame f = new JFrame("지뢰찾기");
	JMenuBar menuBar = new JMenuBar(); // 메뉴바 객체 생성
	JMenu file = new JMenu("파일");
	JMenuItem file_new = new JMenuItem("새 게임");
	JMenuItem file_who = new JMenuItem("제작자");
	JMenuItem file_end = new JMenuItem("종료");

	public MineGUI() throws Exception {

		Music2 lie = new Music2("lie2.wav");
		Music3 clap = new Music3("clap.wav");
		Music m = new Music("ms_bgm.wav");
		
		
		m.Play();	// BGM 재생 

		f.setResizable(false); // 창 크기 고정
		mineSet = new MineSetting();
		mine = new Mine[mineSet.getWidth()][mineSet.getHeight()]; // 객체 생성
		for (int i = 0; i < mineSet.getWidth(); i++)
			for (int j = 0; j < mineSet.getHeight(); j++)
				mine[i][j] = new Mine();
		setMine();

		button = new JButton[mineSet.getWidth()][mineSet.getHeight()];
		for (int i = 0; i < mineSet.getWidth(); i++)
			for (int j = 0; j < mineSet.getHeight(); j++) {
				button[i][j] = new JButton(new ImageIcon(((new ImageIcon("default.png")).getImage())
						.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH)));

				f.add(button[i][j]);

				button[i][j].addMouseListener(new MouseListener() {

					public void mouseClicked(MouseEvent e) {

					}

					public void mouseEntered(MouseEvent e) {
					}

					public void mouseExited(MouseEvent e) {

					}

					@Override
					public void mousePressed(MouseEvent e) {

						for (int i = 0; i < 8; i++) {
							for (int j = 0; j < 8; j++) {
								if (mine[i][j].getClicked() == false) {
									if (mine[i][j].getflag() == false) {
										if (e.getSource() == button[i][j] && e.isMetaDown()) {
											button[i][j]
													.setIcon(new ImageIcon(((new ImageIcon("marked.png")).getImage())
															.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH)));
											mine[i][j].setflag(true);
										}
										// break;
									} else {
										if (e.getSource() == button[i][j] && e.isMetaDown()) {
											button[i][j]
													.setIcon(new ImageIcon(((new ImageIcon("default.png")).getImage())
															.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH)));
											mine[i][j].setflag(false);
										}
									}
								}
							}
						}
					}

					@Override
					public void mouseReleased(MouseEvent e) {
					}
				});

				button[i][j].addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e){
						for (int i = 0; i < 8; i++) {
							for (int j = 0; j < 8; j++) {
								if (mine[i][j].getflag() == false) {
									
									System.out.println(count);
									
									if (e.getSource() == button[i][j] && mine[i][j].getState() == 0) {
										button[i][j].setIcon(new ImageIcon(((new ImageIcon("open0.png")).getImage())
												.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH)));
									//	count++;
										mineSet.Playsound("./NoMine.wav");
										zero(i, j);
									//	count -=1;			// 인접한 0인 칸들과 그 주변 숫자들을 뒤집는데 클릭된 칸의 중복을 피함

									} else if (e.getSource() == button[i][j] && mine[i][j].getState() == 1) {
										button[i][j].setIcon(new ImageIcon(((new ImageIcon("open1.png")).getImage())
												.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH)));
										count++;
										mineSet.Playsound("./NoMine.wav");
										mine[i][j].setClicked(true);

									} else if (e.getSource() == button[i][j] && mine[i][j].getState() == 2) {
										button[i][j].setIcon(new ImageIcon(((new ImageIcon("open2.png")).getImage())
												.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH)));
										count++;
										mineSet.Playsound("./NoMine.wav");
										mine[i][j].setClicked(true);

									} else if (e.getSource() == button[i][j] && mine[i][j].getState() == 3) {
										button[i][j].setIcon(new ImageIcon(((new ImageIcon("open3.png")).getImage())
												.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH)));
										count++;
										mineSet.Playsound("./NoMine.wav");
										mine[i][j].setClicked(true);

									} else if (e.getSource() == button[i][j] && mine[i][j].getState() == 4) {
										button[i][j].setIcon(new ImageIcon(((new ImageIcon("open4.png")).getImage())
												.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH)));
										count++;
										mineSet.Playsound("./NoMine.wav");
										mine[i][j].setClicked(true);

									} else if (e.getSource() == button[i][j] && mine[i][j].getState() == 5) {
										button[i][j].setIcon(new ImageIcon(((new ImageIcon("open5.png")).getImage())
												.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH)));
										count++;
										mineSet.Playsound("./NoMine.wav");
										mine[i][j].setClicked(true);

									} else if (e.getSource() == button[i][j] && mine[i][j].getState() == 6) {
										button[i][j].setIcon(new ImageIcon(((new ImageIcon("open6.png")).getImage())
												.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH)));
										count++;
										mineSet.Playsound("./NoMine.wav");
										mine[i][j].setClicked(true);

									} else if (e.getSource() == button[i][j] && mine[i][j].getState() == 7) {
										button[i][j].setIcon(new ImageIcon(((new ImageIcon("open7.png")).getImage())
												.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH)));
										count++;
										mineSet.Playsound("./NoMine.wav");
										mine[i][j].setClicked(true);

									} else if (e.getSource() == button[i][j] && mine[i][j].getState() == 8) {
										button[i][j].setIcon(new ImageIcon(((new ImageIcon("open8.png")).getImage())
												.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH)));
										count++;
										mineSet.Playsound("./NoMine.wav");
										mine[i][j].setClicked(true);

									} else if (e.getSource() == button[i][j] && mine[i][j].getState() == 9) {
										button[i][j].setIcon(new ImageIcon(((new ImageIcon("mine.png")).getImage())
												.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH)));
										
										m.Stop();	//	BGM 종료
										lie.Play();	// BGM 재생 
										JOptionPane.showMessageDialog(null, "Game Over");
										lie.Stop();
										
										for (i = 0; i < 8; i++) {
											for (j = 0; j < 8; j++) 
												button[i][j].setEnabled(false);			// 객체 비활성화
											}
										
									}if (count >= 54) // 지뢰의 개수가 10개 이므로
										{
											for (i = 0; i < 8; i++) {
												for (j = 0; j < 8; j++) 
													button[i][j].setIcon(new ImageIcon(((new ImageIcon("open0.png")).getImage())
															.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH)));
												}
											m.Stop();
											clap.Play();	// BGM 재생 
											JOptionPane.showMessageDialog(null, "Clear!");
											clap.Stop();
										}
								}
							}
						}
					}
				});
			}

		file_who.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "준표상(팀장)" + '\n' + "정종한" + '\n' + "배성희" + '\n' + "이아란");
			}
		});

		file_end.addActionListener(new ActionListener() { // 메뉴바 종료 버튼
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Exit");
				System.exit(0);
			}
		});
		
		file_new.addActionListener(new ActionListener() { // 메뉴바 시작 버튼
			public void actionPerformed(ActionEvent e) {
				
				m.Play();
				count = 0;
				for (int i = 0; i < 8; i++) {
					for (int j = 0; j < 8; j++) {
						button[i][j].setEnabled(true);
						mine[i][j].setState(0);
						mine[i][j].setClicked(false);
						button[i][j].setIcon(new ImageIcon(((new ImageIcon("default.png")).getImage())
								.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH)));
					}
				}
				
				mineSet = new MineSetting();
				setMine();
			}
		});

		f.setLayout(new GridLayout(8, 8));
		f.setSize(50 * 8, 50 * 8); // 50 - 지뢰 한칸의 사이즈 , 8 - 지뢰의 갯수 (추후 동적으로 변경
		// -> 사용자정의)

		f.setJMenuBar(menuBar); // 프레임에 붙임
		menuBar.add(file); // 메뉴바에 file 붙임
		file.add(file_new);
		file.add(file_end);
		file.add(file_who);
		f.setVisible(true);
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// f.setResizable(false);
	}

	public void zero(int x, int y) // 0 클릭시 주변 0칸 모두 열기
	{
		int minX = x - 1;
		if (minX < 0) {
			minX = 0;
		}

		int maxX = x + 1;
		if (maxX > 7) {
			maxX = 7;
		}

		int minY = y - 1;
		if (minY < 0) {
			minY = 0;
		}

		int maxY = y + 1;
		if (maxY > 7) {
			maxY = 7;
		}

		for (int i = minX; i <= maxX; i++) {
			for (int j = minY; j <= maxY; j++) {
				if (mine[i][j].getClicked() == false) {
					if (mine[i][j].getState() != 9) {
						if (mine[i][j].getState() == 0) {
							mine[i][j].setClicked(true);
							button[i][j].setIcon(new ImageIcon(((new ImageIcon("open0.png")).getImage())
									.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH)));
							mineSet.Playsound("./sound8.wav");
							count++;
							zero(i, j);
						} else if (mine[i][j].getState() == 1) {
							mine[i][j].setClicked(true);
							count++;
							button[i][j].setIcon(new ImageIcon(((new ImageIcon("open1.png")).getImage())
									.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH)));
							
						} else if (mine[i][j].getState() == 2) {
							mine[i][j].setClicked(true);
							count++;
							button[i][j].setIcon(new ImageIcon(((new ImageIcon("open2.png")).getImage())
									.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH)));
							
						} else if (mine[i][j].getState() == 3) {
							mine[i][j].setClicked(true);
							count++;
							button[i][j].setIcon(new ImageIcon(((new ImageIcon("open3.png")).getImage())
									.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH)));
							
						} else if (mine[i][j].getState() == 4) {
							mine[i][j].setClicked(true);
							count++;
							button[i][j].setIcon(new ImageIcon(((new ImageIcon("open4.png")).getImage())
									.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH)));
							
						} else if (mine[i][j].getState() == 5) {
							mine[i][j].setClicked(true);
							count++;
							button[i][j].setIcon(new ImageIcon(((new ImageIcon("open5.png")).getImage())
									.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH)));
							
						} else if (mine[i][j].getState() == 6) {
							mine[i][j].setClicked(true);
							count++;
							button[i][j].setIcon(new ImageIcon(((new ImageIcon("open6.png")).getImage())
									.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH)));
							
						} else if (mine[i][j].getState() == 7) {
							mine[i][j].setClicked(true);
							count++;
							button[i][j].setIcon(new ImageIcon(((new ImageIcon("open7.png")).getImage())
									.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH)));
							
						} else if (mine[i][j].getState() == 8) {
							mine[i][j].setClicked(true);
							count++;
							button[i][j].setIcon(new ImageIcon(((new ImageIcon("open8.png")).getImage())
									.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH)));
						}
					}
				}
			}
		}
	}

	public void setMine() {

		int number = this.mineSet.getMineNum(); // MineNum: 지뢰개수
		int x = 0, y = 0;

		// 임의의 지뢰를 설정한다. 0/9
		do {
			x = (int) (Math.random() * mineSet.getWidth());
			y = (int) (Math.random() * mineSet.getHeight());

			if (mine[x][y].getState() == 0) {
				mine[x][y].setState(9);
				number--;
			}
		} while (number > 0);

		checkMine();
	}

	public void checkMine() {
		for (int i = 0; i < mineSet.getWidth(); i++) {
			for (int j = 0; j < mineSet.getHeight(); j++) {
				if (mine[i][j].getState() == 9)

					continue; // 해당칸이 지뢰면 다음으로 넘어감

				// 해당칸을 중심으로 9칸을 비교해서 지뢰의 수를 카운트한다.
				int count = 0;
				for (int x = -1; x < 2; x++) {
					for (int y = -1; y < 2; y++) {
						if ((i == 0 && x == -1) || (i == mineSet.getWidth() - 1 && x == 1) || (j == 0 && y == -1)
								|| (j == mineSet.getHeight() - 1 && y == 1))
							continue; // 칸 벗어나면
						if (mine[i + x][j + y].getState() == 9)
							count++;
					}
				} // 0,9 예외처리 지뢰
				mine[i][j].setState(count);
			}
		}
	}
}