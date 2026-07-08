package ap.project.civilization.model.ui;

public interface MenuProvider<T> {
    MenuModel createMenu(T object);
}
