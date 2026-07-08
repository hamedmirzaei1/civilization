package ap.project.civilization.model.ui.menuproviders;

import ap.project.civilization.model.ui.MenuModel;

public interface MenuProvider<T> {
    MenuModel createMenu(T object);
}
