package SnailRush;

import processing.core.PApplet;

import java.util.Random;

public class Field {
    private PApplet applet;
    /**
     * <p>エージェント</p>
     * <p>[0]Red</p>
     * <p>[1]Red</p>
     * <p>[2]Blue</p>
     * <p>[3]Blue</p>
     */
    Agent[] agent = new Agent[Const.AGENT_NUMBER.get()];
    /**
     * <p>パネル生成</p>
     * <p>上限:12*12 =144</p>
     */
    Panel[][] panels = new Panel[Const.FIELD_EDGE_MAX.get()][Const.FIELD_EDGE_MAX.get()];
    /**
     * <p>Random</p>
     */
    Random rand = new Random();
    /**
     * <p>パネルY枚数</p>
     * <p>最低値:6の偶数</p>
     */
    private int[] agentPosX = new int[Const.AGENT_NUMBER.get()];
    /**
     * <p>エージェントY座標</p>
     */
    private int[] agentPosY = new int[Const.AGENT_NUMBER.get()];
    /**
     * <p>初期設定</p>
     * <p>・パネル生成枚数</p>
     */
    InitialSetting init;
    /**
     * <p>パネルY枚数</p>
     * <p>最低値:6の偶数</p>
     */
    private int panelXnum;
    /**
     * <p>エージェントX座標</p>
     */
    private int panelYnum;

    /**
     * <p>パネル得点</p>
     * <p>min:-16</p>
     * <p>max:16</p>
     */
    public int panelScore;


    Field() {
        applet = Main.getInstance();
        createDummyData();
    }

    /**
     * <p>ダミーデータ生成</p>
     * */
    private void createDummyData() {
        init = new InitialSetting();

        /*エージェント生成*/
        for (int i = 0; i < Const.AGENT_NUMBER.get(); i++) {
            agent[i] = new Agent(i / 2 == 0 ? Owner.Red:Owner.Blue, agentPosX[i], agentPosY[i]);
        }

        /*パネル生成*/
        System.out.println(panelXnum + ":" + panelYnum);
        for (int y = 0; y < panelYnum / 2; y++) {
            for (int x = 0; x < panelXnum; x++) {
                /*パネル得点の設定*/
                panelScore = rand.nextInt(32) - 16;
                panels[x][y] = new Panel(x * Const.PANEL_SIZE.get(), y * Const.PANEL_SIZE.get(), this.panelScore);
                panels[panelXnum - (x + 1)][panelYnum - (y + 1)] = new Panel((panelXnum - (x + 1)) * Const.PANEL_SIZE.get(), (panelYnum - (y + 1)) * Const.PANEL_SIZE.get(), this.panelScore);
            }
        }
    }

    /**
     * <p>フィールド表示</p>
     */
    public void display() {
        displayPanels();
        displayAgents();
    }

    /**
     * <p>パネル表示</p>
     */
    private void displayPanels() {
        for (int y = 0; y < panelYnum; y++) {
            for (int x = 0; x < panelXnum; x++) {
                applet.pushMatrix();
                applet.translate(panels[x][y].displayX, panels[x][y].displayY);
                panels[x][y].display(applet);
                applet.popMatrix();
            }
        }
    }

    /**
     * <p>エージェント</p>
     */
    private void displayAgents() {
        for (int i = 0; i < Const.AGENT_NUMBER.get(); i++) {
            applet.pushMatrix();
            applet.translate(getDisplayX(agent[i].posX), getDisplayY(agent[i].posY));
            agent[i].display(applet);
            applet.popMatrix();
        }
    }

    private int getDisplayX(int x) {
        return x * Const.PANEL_SIZE.get();
    }

    private int getDisplayY(int y) {
        return y * Const.PANEL_SIZE.get();
    }


    /**
     * インナークラス
     */
    /*初期設定クラスダミーデータ*/
    private class InitialSetting {
        InitialSetting() {
            /*パネルX枚数の設定*/
            panelXnum = (rand.nextInt(Const.PANEL_EDGE_MAX.get() / 4) * 2) + 6;
            /*パネルY枚数の設定*/
            panelYnum = (rand.nextInt(Const.PANEL_EDGE_MAX.get() / 4) + 3) * 2;
            /*エージェントX座標の設定*/
            agentPosX[0] = rand.nextInt(panelXnum / 2);
            agentPosX[1] = panelXnum - agentPosX[0] - 1;
            agentPosX[2] = agentPosX[1];
            agentPosX[3] = agentPosX[0];
            /*エージェントY座標の設定*/
            agentPosY[0] = rand.nextInt(panelYnum / 2);
            agentPosY[1] = panelYnum - agentPosY[0] - 1;
            agentPosY[2] = agentPosY[0];
            agentPosY[3] = agentPosY[1];

            for (int i = 0; i < Const.AGENT_NUMBER.get(); i++) {
                System.out.println("AgentposX[" + i + "]" + agentPosX[i]);
                System.out.println("AgentposY[" + i + "]" + agentPosY[i]);
            }
        }
    }
}
