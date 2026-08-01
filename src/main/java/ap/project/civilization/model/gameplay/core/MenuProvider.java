package ap.project.civilization.model.gameplay.core;

public interface MenuProvider<T> {
    MenuModel createMenu(T object);
}
