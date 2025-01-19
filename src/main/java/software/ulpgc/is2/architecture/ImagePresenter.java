package software.ulpgc.is2.architecture;

import software.ulpgc.is2.architecture.model.Image;
import software.ulpgc.is2.architecture.view.ImageDisplay;
import software.ulpgc.is2.architecture.view.ImageDisplay.*;

public class ImagePresenter {
    private final ImageDisplay display;
    private Image image;

    public ImagePresenter(ImageDisplay display) {
        this.display = display;
        this.display.on((Shift)this::shift);
        this.display.on((Released) this::released);

    }

    private void released(int offset) {
        if (Math.abs(offset) >= display.getWidth() / 2) {
            image = offset > 0 ? image.prev() : image.next();
        }
        repaint();
    }

    private void shift(int offset) {
        display.clear();
        display.paint(image.id(), offset);
        if (offset > 0) {
            display.paint(image.prev().id(), offset - display.getWidth());
        } else {
            display.paint(image.prev().id(), offset + display.getWidth());
        }
    }

    public void show(Image image) {
        this.image = image;
        repaint();
    }

    private void repaint() {
        this.display.clear();
        this.display.paint(image.id(), 0);
    }
}
