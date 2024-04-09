package redstone.multimeter.common.meter;

import java.awt.Color;

import redstone.multimeter.util.ColorUtils;

public enum ColorPicker {

	RANDOM {

		private int index;

		@Override
		public int next() {
			float hue = ((index * 11) % 8 + (index / 8) / 2.0F) / 8.0F;
			index = (index + 1) % 16;

			return ColorUtils.setAlpha(Color.HSBtoRGB(hue, 0.7F, 1.0F), 0xFF);
		}
	},
	RAINBOW {

		private int index;

		@Override
		public int next() {
			float hue = index / 32.0F;
			index = (index + 1) % 32;

			return ColorUtils.setAlpha(Color.HSBtoRGB(hue, 0.7F, 1.0F), 0xFF);
		}
	};

	public abstract int next();

}
