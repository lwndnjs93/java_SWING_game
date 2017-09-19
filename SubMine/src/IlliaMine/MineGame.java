package IlliaMine;

public class MineGame {
    private MineSetting mineSet;
    private Mine[][] mine;		// ���۷���

    public MineGame() {
        mineSet = new MineSetting();
        mine = new Mine[mineSet.getWidth()][mineSet.getHeight()]; //��ü ����
        for (int i = 0; i < mineSet.getWidth(); i++)
            for (int j = 0; j < mineSet.getHeight(); j++)
                mine[i][j] = new Mine();
    }

    public void setMine() {
        int number = this.mineSet.getMineNum();		// MineNum: ���ڰ���
        int x = 0, y = 0;

        // ������ ���ڸ� �����Ѵ�. 0/9
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
                    continue; // �ش�ĭ�� ���ڸ� �������� �Ѿ

                // �ش�ĭ�� �߽����� 9ĭ�� ���ؼ� ������ ���� ī��Ʈ�Ѵ�.
                int count = 0;
                for (int x = -1; x < 2; x++){
                    for (int y = -1; y < 2; y++) {
                        if ((i == 0 && x == -1) || (i == mineSet.getWidth()-1 && x == 1) ||
                                (j == 0 && y == -1) || (j == mineSet.getHeight()-1 && y == 1)) continue; //ĭ ����� 
                        if (mine[i + x][j + y].getState() == 9)
                            count++;
                    }
                } //0,9 ����ó�� ����
                mine[i][j].setState(count);	
            }
        }
    }


}
