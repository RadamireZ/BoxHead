package gui;

import logic.Player;
import logic.Vector2d;

public class MatriceCam {

	public Vector2d topLeft;

	public final static int MWIDTH = 800;
	public static final int MHEIGHT = 400;

	public double direction;

	public MatriceCam(Player p) {

		topLeft = new Vector2d();

		topLeft.x = (int) (p.centro.x - MWIDTH / 2);

		topLeft.y = (int) (p.centro.y - MHEIGHT / 2);

		direction = -1;
	}

	public void updatePosition(Player p) {
		if (p.speedCurr > 0) {

			if ((p.orientationAngle == 0)
					&& (topLeft.x + MWIDTH <= p.topLeft.x && topLeft.x + MWIDTH >= p.bottomLeft.x)) {
				topLeft = topLeft.add(new Vector2d(p.speedCurr, 0));
				direction = 0;
			}

			else if ((p.orientationAngle == 180) && (topLeft.x <= p.bottomLeft.x && topLeft.x >= p.topLeft.x)) {
				topLeft = topLeft.add(new Vector2d(-p.speedCurr, 0));
				direction = 180;
			}

			else if ((p.orientationAngle == 270) && (topLeft.y <= p.bottomLeft.y && topLeft.y >= p.topLeft.y)) {
				topLeft = topLeft.add(new Vector2d(0, -p.speedCurr));
				direction = 270;
			}

			else if ((p.orientationAngle == 90)
					&& (topLeft.y + MHEIGHT <= p.topLeft.y && topLeft.y + MHEIGHT >= p.bottomLeft.y)) {
				topLeft = topLeft.add(new Vector2d(0, p.speedCurr));
				direction = 90;
			}

			else if (p.orientationAngle == 315) {
				if ((topLeft.y <= p.bottomRight.y && topLeft.y >= p.topLeft.y)
						&& (topLeft.x + MWIDTH <= p.topRight.x && topLeft.x + MWIDTH >= p.bottomLeft.x)) {
					topLeft = topLeft.add(new Vector2d(p.speedCurr, -p.speedCurr));
					direction = 315;
				} else if (topLeft.y <= p.bottomRight.y && topLeft.y >= p.topLeft.y) {
					topLeft = topLeft.add(new Vector2d(0, -p.speedCurr));
					direction = 270;
				} else if (topLeft.x + MWIDTH <= p.topRight.x && topLeft.x + MWIDTH >= p.bottomLeft.x) {
					topLeft = topLeft.add(new Vector2d(p.speedCurr, 0));
					direction = 0;
				}
			}

			else if (p.orientationAngle == 225) {
				if ((topLeft.y <= p.bottomLeft.y && topLeft.y >= p.topRight.y)
						&& (topLeft.x <= p.bottomRight.x && topLeft.x >= p.topLeft.x)) {
					topLeft = topLeft.add(new Vector2d(-p.speedCurr, -p.speedCurr));
					direction = 225;
				} else if (topLeft.y <= p.bottomLeft.y && topLeft.y >= p.topRight.y) {
					topLeft = topLeft.add(new Vector2d(0, -p.speedCurr));
					direction = 270;
				} else if (topLeft.x <= p.bottomRight.x && topLeft.x >= p.topLeft.x) {
					topLeft = topLeft.add(new Vector2d(-p.speedCurr, 0));
					direction = 180;
				}
			} else if (p.orientationAngle == 45) {
				if ((topLeft.y + MHEIGHT <= p.topRight.y && topLeft.y + MHEIGHT >= p.bottomLeft.y)
						&& (topLeft.x + MWIDTH <= p.topLeft.x && topLeft.x + MWIDTH >= p.bottomRight.x)) {
					topLeft = topLeft.add(new Vector2d(p.speedCurr, p.speedCurr));
					direction = 45;
				} else if (topLeft.y + MHEIGHT <= p.topRight.y && topLeft.y + MHEIGHT >= p.bottomLeft.y) {
					topLeft = topLeft.add(new Vector2d(0, p.speedCurr));
					direction = 90;
				} else if (topLeft.x + MWIDTH <= p.topLeft.x && topLeft.x + MWIDTH >= p.bottomRight.x) {
					topLeft = topLeft.add(new Vector2d(p.speedCurr, 0));
					direction = 0;
				}
			} else if (p.orientationAngle == 135) {
				if ((topLeft.y + MHEIGHT <= p.topLeft.y && topLeft.y + MHEIGHT >= p.bottomRight.y)
						&& (topLeft.x <= p.bottomLeft.x && topLeft.x >= p.topRight.x)) {
					topLeft = topLeft.add(new Vector2d(-p.speedCurr, p.speedCurr));
					direction = 135;
				} else if (topLeft.y + MHEIGHT <= p.topLeft.y && topLeft.y + MHEIGHT >= p.bottomRight.y) {
					topLeft = topLeft.add(new Vector2d(0, p.speedCurr));
					direction = 90;
				} else if (topLeft.x <= p.bottomLeft.x && topLeft.x >= p.topRight.x) {
					topLeft = topLeft.add(new Vector2d(-p.speedCurr, 0));
					direction = 180;
				}
			}

		}
	}

};
