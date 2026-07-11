package ap.project.civilization.model.gameplay.ui.menuproviders;

import ap.project.civilization.model.gameplay.ui.MenuModel;

public interface MenuProvider<T> {
    MenuModel createMenu(T object);
}
