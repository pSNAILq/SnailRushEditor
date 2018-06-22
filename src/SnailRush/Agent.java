package SnailRush;

import processing.core.PApplet;

public class Agent {

    /*エージェントクラス*/
    /**
     * <p>エージェントのX座標</p>
     */
    public int posX;
    /**
     * <p>エージェントのY座標</p>
     */
    public int posY;
    /**
     * <p>チーム識別</p>
     */
    private Owner team;

    Agent(Owner team, int posX, int posY) {
        this.team = team;
        this.posX = posX;
        this.posY = posY;
        System.out.println(team.toString());
    }

    /**
     * <p>エージェントの枠線のカラーを与える</p>
     */
    private void identifyTeam(PApplet applet) {
        if (this.team == Owner.Red) {
            /*Red*/
            applet.fill(255, 0, 0, 90);
        } else {
            /*Blue*/
            applet.fill(0, 0, 255, 90);
        }
    }

    /**
     * <p>エージェント表示</p>
     */
    public void display(PApplet applet) {
        applet.strokeWeight(3);
        applet.fill(0);
        applet.text(this.team.toString(), Const.PANEL_HALF_SIZE.get(), Const.PANEL_HALF_SIZE.get());
        identifyTeam(applet);
        applet.ellipse(Const.PANEL_HALF_SIZE.get(), Const.PANEL_HALF_SIZE.get(), Const.AGENT_SIZE.get(), Const.AGENT_SIZE.get());

    }

}
