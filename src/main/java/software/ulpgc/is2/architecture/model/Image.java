package software.ulpgc.is2.architecture.model;

public interface Image {
    String id();
    Image next();
    Image prev();
}
