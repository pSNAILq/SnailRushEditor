package SnailRush;

import processing.core.*;

public class Main extends PApplet {
    private static Main instance;

    public static Main getInstance() {
        return instance;
    }

    public static void setInstance(Main main) {
        instance = main;
    }


    public static void main(String[] ages) {

        PApplet.main("SnailRush.Main");
    }

    /*Class*/
    /**
     * <p>[Red]</p>
     * <p>獲得ポイント計算</p>
     */
    Team redTeam;
    /**
     * <p>[Blue]</p>
     * <p>獲得ポイント計算</p>
     */
    Team blueTeam;
    /**
     * <p>フィールド</p>
     */
    Field field;


    @Override
    public void settings() {
        setInstance(this);
        size(Const.SIZE.get(),Const.SIZE.get());
    }

    @Override
    public void setup() {
        /*class*/
        redTeam = new Team();
        blueTeam = new Team();
        field = new Field();
    }

    @Override
    public void draw() {
        field.display();
    }


}
