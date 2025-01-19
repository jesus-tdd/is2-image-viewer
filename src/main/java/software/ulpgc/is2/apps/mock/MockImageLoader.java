package software.ulpgc.is2.apps.mock;

import software.ulpgc.is2.architecture.model.Image;
import software.ulpgc.is2.architecture.persistence.ImageLoader;

public class MockImageLoader implements ImageLoader {
    private final String[] ids = new String[] {"red", "green", "blue"};

    @Override
    public Image load() {
        return imageAt(0);
    }

    private Image imageAt(int i) {
        return new Image() {
            @Override
            public String id() {
                return ids[i];
            }

            @Override
            public Image next() {
                return imageAt((i + 1) % ids.length);
            }

            @Override
            public Image prev() {
                return imageAt(i > 0 ? i - 1 : ids.length - 1);
            }
        };
    }
}
