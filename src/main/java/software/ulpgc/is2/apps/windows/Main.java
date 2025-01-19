package software.ulpgc.is2.apps.windows;

import software.ulpgc.is2.apps.mock.MockImageLoader;
import software.ulpgc.is2.apps.windows.view.MainFrame;
import software.ulpgc.is2.architecture.ImagePresenter;
import software.ulpgc.is2.architecture.model.Image;

public class Main {
    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
        ImagePresenter presenter = new ImagePresenter(mainFrame.getDisplay());
        presenter.show(image());
        mainFrame.setVisible(true);
    }

    private static Image image() {
        return new MockImageLoader().load();
    }
}
