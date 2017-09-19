package IlliaMine;

public class MineGame {
    private MineSetting mineSet;
    private Mine[][] mine;		// 레퍼런스

    public MineGame() {
        mineSet = new MineSetting();
        mine = new Mine[mineSet.getWidth()][mineSet.getHeight()]; //객체 생성
        for (int i = 0; i < mineSet.getWidth(); i++)
            for (int j = 0; j < mineSet.getHeight(); j++)
                mine[i][j] = new Mine();
    }

    public void setMine() {
        int number = this.mineSet.getMineNum();		// MineNum: 지뢰개수
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
                for (int x = -1; x < 2; x++){
                    for (int y = -1; y < 2; y++) {
                        if ((i == 0 && x == -1) || (i == mineSet.getWidth()-1 && x == 1) ||
                                (j == 0 && y == -1) || (j == mineSet.getHeight()-1 && y == 1)) continue; //칸 벗어나면 
                        if (mine[i + x][j + y].getState() == 9)
                            count++;
                    }
                } //0,9 예외처리 지뢰
                mine[i][j].setState(count);	
            }
        }
    }


}
