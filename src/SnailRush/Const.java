package SnailRush;

public enum Const {
    /**
     * <p>パネルの一辺の長さ</p>
     * <p>80</p>
     */
    PANEL_SIZE(80),
    /**
     * <p>パネルの一辺の長さの半分</p>
     * <p>40</p>
     */
    PANEL_HALF_SIZE(40),
    /**
     * <p>エージェントの大きさ</p>
     * <p>80</p>
     */
    AGENT_SIZE(80),
    /**
     * <p>エージェント人数</p>
     * <p>4</p>
     * */
    AGENT_NUMBER(4),
    /**
     * <p>パネル1辺上限</p>
     * <p>12</p>
     * */
    PANEL_EDGE_MAX(12),
    /**
     * <p>フィールド1辺上限</p>
     * <p>14</p>
     * */
    FIELD_EDGE_MAX(14),
    /**
     * <p>画面サイズ</p>
     * */
    SIZE(960),
    /**
     * <p>文字サイズ</p>
     * */
    TEXT_SIZE(20);;

    private final int id;

    Const(final int id) {
        this.id = id;
    }

    public int get() {
        return this.id;
    }
}
