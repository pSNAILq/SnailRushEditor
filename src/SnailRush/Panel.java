package SnailRush;

import processing.core.PApplet;

public class Panel {


        /**
         * <p>パネルX座標</p>
         */
        public int displayX = 0;
        /**
         * <p>パネルX座標</p>
         */
        public int displayY = 0;
        /**
         * <p>パネル得点</p>
         */
        public int score = 0;
        /**
         * <p>現オーナー</p>
         * <p>初期:Free</p>
         */
        public Owner owner = Owner.Free;

        /**
         * <p>パネル</p>
         */
        Panel(int posX, int posY, int score) {
            this.displayX = posX;
            this.displayY = posY;
            this.score = score;
        }

        /**
         * <p>表示</p>
         */
        public void display(PApplet applet) {
            ownerColor(applet);
            applet.textAlign(applet.CENTER, applet.CENTER);
            applet.textSize(Const.TEXT_SIZE.get());
            applet.rect(0, 0, Const.PANEL_SIZE.get(), Const.PANEL_SIZE.get());
            applet.fill(0);
            applet.text(this.score, Const.PANEL_HALF_SIZE.get(), Const.PANEL_HALF_SIZE.get());

        }

        /**
         * <p>オーナー色判別</p>
         */
        private void ownerColor(PApplet applet) {
            switch (this.owner) {
                case Free:
                    applet.fill(164, 164, 164);
                    break;
                case Red:
                    applet.fill(232, 113, 100);
                    break;
                case Blue:
                    applet.fill(97, 120, 220);
                    break;
            }
        }
    }
